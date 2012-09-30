/**
 * <p>NinjaWars
 * マイページコントローラクラス
 * 
 * @since 2012/09/30
 * @author RaTTiE
 */
package org.eldersoftware.ninjawars.mypage

import grails.plugins.springsecurity.Secured

@Secured(["ROLE_USER"])
class MypageController {
	def index() {
	}
}
