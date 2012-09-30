/**
 * <p>Elder Software SGClone
 * チュートリアル抽象コントローラクラス
 * 
 * @since 2012/09/27
 * @author RaTTiE
 */
package org.eldersoftware.sgclone.tutorial

import org.apache.commons.lang.StringUtils
import org.eldersoftware.sgclone.player.PlayerBase

public class AbstractTutorialController {
	def playerService

	static defaultAction = "execute"

	/**
	 * <p>エントリポイント。
	 * <p>チュートリアルは状態をＤＢで永続化しているため、
	 * チュートリアルのページ処理はすべてexecuteアクションで行っている。
	 * <p>エントリポイントはプレイヤーのtutorialProgressを取得し、
	 * progressに格納されたアクションのメソッド(onXXXX)を実行する。<br>
	 * メソッドが存在しない場合、該当するビューのレンダリングを行う。
	 * <p>リクエスト時にイベントパラメータ(__YYYY)が指定されている場合、
	 * イベントパラメータに応じたメソッド(onXXXX_YYYY)を検索し、存在する場合は
	 * 該当するメソッドを実行する。<br>
	 * メソッドが存在しない場合、イベントは無視されて通常のアクションが実行される。
	 * 
	 * @fixme もう少しうまい実装が思いついたら変更するかも…。
	 */
	def execute() {
		def config = grailsApplication.config.sgclone
		def player = playerService.getLoginPlayer()

		// チュートリアル完了時は無視
		if (player.tutorialCompleted) {
			redirect(controller:config.mypage.top.controller ?: "mypage")

			return
		}

		def progress = findProgress()

		try {
			String methodName = "on${StringUtils.capitalize(progress.action)}"

			// イベントキーが指定されている場合は
			// イベントキーに対応するメソッドを検索して実行する
			String event = getEventKey()
			if (event) {
				String eventMethodName = "${methodName}_${event}"
				if (existsMethod(eventMethodName)) {
					methodName = eventMethodName
				}
			}

			// 現在のプログレスアクションを実行
			def model
			if (existsMethod(methodName)) {
				model = this."${methodName}"()
			}

			if (!request.redirected) {
				render(view:progress.action, model:model)
			}
		} catch (TutorialAbortException ex) {
			redirect(controller:config.tutorial.controller ?: "tutorial", action:"execute")

			return
		}
	}

	/**
	 * <p>チュートリアルの終了アクション。
	 * <p>進捗情報を削除した上で完了フラグを立て、マイページにリダイレクトする。
	 */
	protected def onEnd() {
		PlayerBase.withTransaction {
			def player = playerService.getLoginPlayer()

			player.tutorialCompleted = true
			player.save()

			def progress = findProgress()
			progress.delete()

			def config = grailsApplication.config.sgclone.mypage
			redirect(controller:config.top.controller ?: "mypage")
		}
	}

	/**
	 * <p>チュートリアル進捗のクラスを取得する。
	 * 
	 * @return コンフィグ(sgclone.tutorial.progressClass)で定義されたクラスを返す。

	 */
	protected def findProgressClass() {
		def progressClass = grailsApplication.config.sgclone.tutorial.progressClass

		if (progressClass) {
			return progressClass
		} else {
			return grailsApplication.classLoader.loadClass("org.eldersoftware.sgclone.player.TutorialProgressBase")
		}
	}

	/**
	 * <p>プレイヤーのチュートリアル進捗を取得する。
	 * <p>進捗データが存在しない場合は新規にレコードを作成する。
	 * 
	 * @return チュートリアル進捗のインスタンス。
	 */
	protected def findProgress() {
		def progressClass = findProgressClass()
		def player = playerService.getLoginPlayer()

		def progress = progressClass.findByPlayerId(player.id)
		if (!progress) {
			progress = progressClass.newInstance()

			progress.initialize(player)
			progress.save(failOnError:true)
		}

		return progress
	}

	/**
	 * <p>次のアクションを指定する。
	 * <p>指定したアクションはチュートリアル進捗に保存され、
	 * 即座に該当アクションの実行(リダイレクト)が行われる。
	 * <p>また、処理の中断時には例外(TutorialAbortException)が
	 * 発生するため、withTransactionクロージャ内で起動すると
	 * ロールバックが発生する。注意すること。
	 */
	protected void nextAction(String action) {
		def progress = findProgress()

		progress.action = action
		progress.save()

		throw new TutorialAbortException()
	}

	/**
	 * <p>イベントキーをパラメータから検索する内部メソッド。
	 */
	protected String getEventKey() {
		for (String key : params.keySet()) {
			def m = key =~ /^__([a-z]+[0-9a-z])*/
			if (m.find()) {
				return m[0][1]
			}
		}

		return null
	}

	/**
	 * <p>指定したイベントメソッドが存在するか判定する内部メソッド。
	 */
	protected boolean existsMethod(String methodName) {
		def clazz = this.class

		while (clazz) {
			try {
				clazz.getDeclaredMethod(methodName)

				return true
			} catch (NoSuchMethodException ex) {
				clazz = clazz.superclass
			}
		}

		return false
	}
}
