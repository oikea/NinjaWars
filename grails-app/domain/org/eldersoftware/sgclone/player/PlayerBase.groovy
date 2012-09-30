/**
 * <p>Elder Software SGClone
 * プレイヤーベースドメインクラス
 * 
 * @since 2012/09/19
 * @author RaTTiE
 */
package org.eldersoftware.sgclone.player

public class PlayerBase {
	transient grailsApplication

	/** ユニットタイプ */
	UnitTypeBase unitType

	/** レベル */
	int level

	/** 経験値 */
	int experience

	/** 所持金 */
	int money

	/** 友情ポイント */
	int friendPoint

	/** 最大体力 */
	int maxStamina

	/** 最大攻コスト */
	int maxAttackCost

	/** 最大守コスト */
	int maxDefenceCost

	/** ユニット上限数 */
	int maxUnits

	/** 体力が完全に回復する時刻 */
	Date dateStaminaFull

	/** 攻コストが完全に回復する時刻 */
	Date dateAttackFull

	/** 守コストが完全に回復する時刻 */
	Date dateDefenceFull

	/** 総ステータスポイント */
	int totalStatusPoint

	/** 使用済のステータスポイント */
	int usedStatusPoint

	/** 体力回復薬の所持数 */
	int staminaPotionCount

	/** コスト回復薬の所持数 */
	int costPotionCount

	/** 罠の所持数 */
	int trapCount

	/** チュートリアルが完了しているか？ */
	boolean tutorialCompleted

	/** エンティティ制約。 */
	static constraints = {
		unitType(nullable:true)
	}

	/**
	 * <p>このドメインクラスは、以下のドメインクラスと一対多の関連を持つ。
	 * 
	 * <dl>
	 * <dt>units({@link org.eldersoftware.sgclone.player.PlayerUnitBase PlayerUnitBase})<dd>ユニット情報。
	 * <dt>decks({@link org.eldersoftware.sgclone.player.DeckBase DeckBase})<dd>デッキ情報。
	 * </dl>
	 */
	static hasMany = [
		units:PlayerUnitBase,
		decks:DeckBase
	]

	/**
	 * <p>以下のプロパティは永続化対象外とする。
	 * 
	 * <ul>
	 * <li>statusPoint
	 * <li>stamina
	 * <li>attackCost
	 * <li>defenceCost
	 * <li>friends
	 * <li>tutorialProgress
	 * <li>maxFriends
	 * </ul>
	 */
	static transients = [
		"statusPoint",
		"stamina",
		"attackCost",
		"defenceCost",
		"friends",
		"tutorialProgress",
		"maxFriends",
	]

	/**
	 * <p>現在のステータスポイントを取得する。
	 * <p>現在のステータスポイントはプレーヤーの総ステータスポイントと使用済ステータスポイントから算出する。
	 * 
	 * @return 現在のステータスポイント。
	 */
	public int getStatusPoint() {
		return totalStatusPoint - usedStatusPoint
	}

	/**
	 * <p>プレーヤーのステータスポイントをリフレッシュする。
	 * <p>現在のステータスポイントを確認し、マイナスになっている場合は超過分をステータスから減算し、データを更新する。
	 */
	public void refreshStatusPoint() {
		totalStatusPoint = calcTotalStatusPoint

		if (statusPoint < 0) {
			usedStatusPoint = 0

			this.save()
		}
	}

	/**
	 * <p>プレーヤーの総ステータスポイントを算出する。
	 * <p>プレーヤーのステータスポイントはレベル、クリアしたミッション数、フレンド数で決定される。
	 * 
	 * @return 算出した総ステータスポイント。
	 */
	public int calcTotalStatusPoint() {
		int value = level - 1 + friends.size()

		return value
	}

	/**
	 * <p>現在の体力を取得する。
	 * <p>値は最大値と完全回復する時間、回復のインターバルから動的に算出される。
	 * 
	 * @return 現在の体力。
	 */
	public int getStamina() {
		return calcParameterValue(
			dateStaminaFull, 
			maxStamina, 
			grailsApplication.config.sgclone.recoveryInterval.stamina ?: 1
		)
	}

	/**
	 * <p>現在の攻コストを取得する。
	 * <p>値は最大値と完全回復する時間、回復のインターバルから動的に算出される。
	 * 
	 * @return 現在の体力。
	 */
	public int getAttackCost() {
		return calcParameterValue(
			dateAttackFull, 
			maxAttackCost, 
			grailsApplication.config.sgclone.recoveryInterval.attackCost ?: 1
		)
	}

	/**
	 * <p>現在の守コストを取得する。
	 * <p>値は最大値と完全回復する時間、回復のインターバルから動的に算出される。
	 * 
	 * @return 現在の体力。
	 */
	public int getDefenceCost() {
		return calcParameterValue(
			dateDefenceFull, 
			maxDefenceCost, 
			grailsApplication.config.sgclone.recoveryInterval.defenceCost ?: 1
		)
	}

	/**
	 * <p>プレイヤーデータの初期値をセットする。
	 * <p>一部値はConfigのsgclone.player.initialParameterの設定値が使用される。
	 */
	public void initialize() {
		def config = grailsApplication.config.sgclone.player.initialParameter
		Date now = new Date()

		this.level = 1
		this.experience = 0
		this.money = config.money ?: 0
		this.friendPoint = 0
		this.maxStamina = config.stamina ?: 20
		this.maxAttackCost = config.attackCost ?: 10
		this.maxDefenceCost = config.defenceCost ?: 10
		this.maxUnits = config.maxUnits ?: 30
		this.dateStaminaFull = now
		this.dateAttackFull = now
		this.dateDefenceFull = now
		this.usedStatusPoint = 0
		this.staminaPotionCount = 0
		this.costPotionCount = 0
		this.trapCount = 0
	}

	/**
	 * <p>プレーヤーがレベルアップ可能かチェックする。
	 * 
	 * @return プレーヤーがレベルアップ可能なら{@code true}を返す。
	 */
	public boolean checkLevelup() {
		return false
	}

	/**
	 * <p>プレーヤーのフレンドを取得する。
	 * 
	 * @return フレンドの{@code List}。
	 */
	public def getFriends() {
		return []
	}

	/**
	 * <p>プレーヤーのフレンド最大人数を取得する。
	 * 
	 * @return フレンドの最大人数。
	 */
	public int getMaxFriends() {
		def config = grailsApplication.config.sgclone.player.initialParameter

		return (config.maxFriends ?: 5) + (level / 5)
	}

	/**
	 * <p>パラメータの値を算出する内部メソッド。
	 * <p>値は最大値と完全回復する時間、回復のインターバルから算出される。
	 * <p>また、計算結果が最小値、最大値の範囲を超えた場合は範囲の補正が行われる。
	 * 
	 * @param dateFull 完全回復する時刻。
	 * @param maxValue 最大値。
	 * @param recoveryInterval パラメータが1回復するのにかかる時間(分)。
	 * 
	 * @return 算出したパラメータ値。
	 */
	protected int calcParameterValue(Date dateFull, int maxValue, int recoveryInterval) {
		long diff = dateFull.time - (new Date()).time

		return Math.min(Math.max(0, Math.floor(maxValue - (diff / 36000 / recoveryInterval))), maxValue)
	}

	/**
	 * <p>指定したパラメータ値に対する完全回復時刻を求める内部メソッド。
	 * <p>値は現在値と最大値、回復のインターバルから算出される。
	 * <p>また、指定した現在値が最小値、最大値の範囲を超えた場合は範囲の補正が行われる。
	 * 
	 * @param value 現在値。
	 * @param maxValue 最大値。
	 * @param recoveryInterval パラメータが1回復するのにかかる時間(分)。
	 * 
	 * @return 算出した完全回復時刻。
	 */
	protected Date calcParameterDate(int value, int maxValue, int recoveryInterval) {
		int diff = Math.min(Math.max(maxValue - value, 0), maxValue)

		return new Date((new Date()).time + this.calcParameterTime(diff, recoveryInterval))
	}

	/**
	 * <p>パラメータに加減算する時間のTick値(ms)を求める内部メソッド。
	 * <p>値と回復のインターバルから算出される。
	 * 
	 * @param value 値。
	 * @param recoveryInterval パラメータが1回復するのにかかる時間(分)。
	 * 
	 * @return 算出した時間のTick値(ms)。
	 */
	protected int calcParameterTime(int value, int recoveryInterval) {
		return value * 36000 * recoveryInterval
	}
}
