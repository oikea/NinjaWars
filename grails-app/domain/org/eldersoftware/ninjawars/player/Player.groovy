/**
 * <p>NinjaWars
 * プレイヤードメインクラス
 * 
 * @since 2012/09/18
 * @author RaTTiE
 */
package org.eldersoftware.ninjawars.player

import org.eldersoftware.ninjawars.authority.Account
import org.eldersoftware.sgclone.player.PlayerBase

class Player extends PlayerBase {
	/** コーベイン所持数 */
	int cobain

	/** このドメインクラスは{@link org.eldersoftware.ninjawars.authority.Account Account}と単方向関連を持つ。 */
	static belongsTo = [account:Account]
}
