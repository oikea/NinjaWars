/**
 * <p>Elder Software SGClone
 * デッキベースドメインクラス
 * 
 * @since 2012/09/20
 * @author RaTTiE
 */
package org.eldersoftware.sgclone.player

public class DeckBase {
	/** エンティティ制約。 */
	static constraints = {
	}

	/**
	 * <p>このドメインクラスは、以下のドメインクラスと一対多の関連を持つ。
	 * 
	 * <dl>
	 * <dt>units({@link org.eldersoftware.sgclone.player.PlayerUnitBase PlayerUnitBase})<dd>ユニット情報。
	 * </dl>
	 */
	static hasMany = [
		units:PlayerUnitBase
	]
}
