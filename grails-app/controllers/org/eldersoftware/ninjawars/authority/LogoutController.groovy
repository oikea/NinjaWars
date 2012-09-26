/**
 * <p>NinjaWars
 * ログアウト処理コントローラクラス
 * 
 * @since 2012/09/22
 * @author RaTTiE
 */
package org.eldersoftware.ninjawars.authority

import org.codehaus.groovy.grails.plugins.springsecurity.SpringSecurityUtils

class LogoutController {
	/**
	 * <p>ログアウト処理を行う。
	 */
	def index = {
		def config = SpringSecurityUtils.securityConfig

		redirect(uri:config.logout.filterProcessesUrl)
	}
}
