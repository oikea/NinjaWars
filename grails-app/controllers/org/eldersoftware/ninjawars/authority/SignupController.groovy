/**
 * <p>NinjaWars
 * ユーザ登録コントローラクラス
 * 
 * @since 2012/09/22
 * @author RaTTiE
 */
package org.eldersoftware.ninjawars.authority

import org.eldersoftware.ninjawars.player.Player
import grails.plugins.springsecurity.Secured

class SignupController {
	def springSecurityService

	/**
	 * <p>アクション実行前に実行される処理。
	 */
	def beforeInterceptor = {
		if (springSecurityService.isLoggedIn()) {
			if (!request.redirected) redirect(uri:"/")

			return false
		} else {
			return true
		}
	}

	/**
	 * <p>インデックスアクション。
	 */
	def index() { }

	/**
	 * <p>内容確認アクション。
	 */
	def confirm() {
		def input = new SignupInput()

		input.userId = params.userId
		input.password = params.password
		input.confirmPassword = params.confirmPassword

		if (!input.validate()) {
			render(view:"index", model:[input:input])
		} else {
			render(view:"confirm", model:[input:input])
		}
	}

	/**
	 * <p>確認結果送信アクション。
	 */
	def submit() {
		def input = new SignupInput()

		input.userId = params.userId
		input.password = params.password
		input.confirmPassword = params.password

		if (params.submit && input.validate()) {
			// ユーザ登録してリダイレクト。
			def account = new Account(
				userId:input.userId,
				password:input.password,
				enabled:true
			)
			def player = new Player()
			player.initialize()

			account.player = player
			player.account = account

			account.save()
			account.addAuthority(Role.findByAuthority("ROLE_USER"))

			springSecurityService.reauthenticate(account.userId, account.password)

			redirect(uri:"/")
		} else {
			render(view:"index", model:[input:input])
		}
	}
}
