/**
 * <p>Elder Software SGClone
 * プレイヤーサービスクラス
 * 
 * @since 2012/09/22
 * @author RaTTiE
 */
package org.eldersoftware.sgclone.player

class PlayerService {
	static transactional = false

	def grailsApplication
	def springSecurityService

	/**
	 * <p>ログインユーザにリンクされたプレイヤー情報を取得する。
	 * <p>未ログイン状態の場合、メソッドは{@code null}を返す。
	 */
	public def getLoginPlayer() {
		def principal = springSecurityService.principal

		// principalが存在しないか未ログインならnull
		if (principal == null || principal instanceof String) return

		return principal.domainClass.${grailsApplication.config.sgclone.player.propertyName}
	}
}
