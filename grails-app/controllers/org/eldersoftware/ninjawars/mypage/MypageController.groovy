/**
 * <p>NinjaWars
 * �}�C�y�[�W�R���g���[���N���X
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
