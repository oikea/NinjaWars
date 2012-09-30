/**
 * <p>Elder Software SGClone
 * チュートリアル進捗ベースドメインクラス
 * 
 * @since 2012/09/28
 * @author RaTTiE
 */
package org.eldersoftware.sgclone.player

class TutorialProgressBase {
	/** プレイヤーＩＤ */
	long playerId

	/** 現在のアクション */
	String action

	/** ユニットタイプ */
	UnitTypeBase unitType

	/** エンティティ制約。 */
	static constraints = {
		playerId(unique:true)
		action(maxSize:15, nullable:false, blank:false)
		unitType(nullable:true)
	}

	/**
	 * <p>進捗データの初期値をセットする。
	 * <p>初期アクションはstartとなる。
	 */
	public void initialize(def player) {
		playerId = player.id
		action = "start"
	}
}
