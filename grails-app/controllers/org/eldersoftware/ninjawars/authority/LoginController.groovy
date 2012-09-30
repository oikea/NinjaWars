/**
 * <p>NinjaWars
 * ログイン処理コントローラクラス
 * 
 * @since 2012/09/22
 * @author RaTTiE
 */
package org.eldersoftware.ninjawars.authority

import org.springframework.security.authentication.AccountExpiredException
import org.springframework.security.authentication.CredentialsExpiredException
import org.springframework.security.authentication.DisabledException
import org.springframework.security.authentication.LockedException
import org.springframework.security.web.WebAttributes

class LoginController {
	/**
	 * <p>インデックスアクション。
	 */
	def index = { redirect(uri:"/") }

	/**
	 * <p>アクセス拒否時アクション。
	 */
	def denied = { redirect(uri:"/") }

	/**
	 * <p>クッキー認証不可アクション。
	 */
	def full = { redirect(uri:"/") }

	/**
	 * <p>認証失敗時アクション。
	 */
	def authfail = {
		// 期限切れ、ユーザロック、無効は現状ないため、失敗エラーのみ
		flash.message = g.message(code:"springSecurity.errors.login.fail")

		return []
	}
}
