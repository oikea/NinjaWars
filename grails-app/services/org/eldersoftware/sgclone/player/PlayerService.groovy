/**
 * <p>Elder Software SGClone
 * プレイヤーサービスクラス
 * 
 * @since 2012/09/22
 * @author RaTTiE
 */
package org.eldersoftware.sgclone.player

import org.codehaus.groovy.grails.plugins.springsecurity.SpringSecurityUtils

class PlayerService {
	static transactional = false

	def grailsApplication
	def springSecurityService

	/**
	 * <p>ログインユーザにリンクされたプレイヤー情報を取得する。
	 * <p>未ログイン状態の場合、メソッドは{@code null}を返す。
	 */
	public def getLoginPlayer() {
		if (!springSecurityService.isLoggedIn()) return null

		String userClassName = SpringSecurityUtils.securityConfig.userLookup.userDomainClassName
		def dc = grailsApplication.getDomainClass(userClassName)
		if (!dc) throw new RuntimeException("The specified user domain class '$userClassName' is not a domain class")

		return dc.clazz.get(springSecurityService.principal.id)."${grailsApplication.config.sgclone.player.propertyName}"
	}
}
