/**
 * <p>NinjaWars
 * トップページコントローラクラス
 * 
 * @since 2012/09/22
 * @author RaTTiE
 */
package org.eldersoftware.ninjawars.top

import org.codehaus.groovy.grails.commons.ConfigurationHolder
import org.codehaus.groovy.grails.plugins.springsecurity.SpringSecurityUtils
import org.eldersoftware.ninjawars.authority.Account
import org.eldersoftware.ninjawars.player.Player

class TopController {
	/**
	 * <p>インデックスアクション。
	 */
	def index() {
		def titleImages = grailsApplication.config.sgclone.top.titleImages?.clone() ?: []
		String loginUrl = "${request.contextPath}${SpringSecurityUtils.securityConfig.apf.filterProcessesUrl}"

		Collections.shuffle(titleImages)

		[
			titleImageUrl:titleImages ? titleImages[0] : null,
			loginUrl:loginUrl
		]
	}
}
