/**
 * <p>Elder Software SGClone
 * 共通タグライブラリクラス
 * 
 * @since 2012/09/18
 * @author RaTTiE
 */
package org.eldersoftware.sgclone.taglib

class ApplicationTagLib {
	static def namespace = "sg"

	def playerService

	/**
	 * <p>プレーヤー情報をページスコープにセットする。
	 */
	def setPlayer = {
		g.set(var:"player", value:playerService.loginPlayer)
	}
}
