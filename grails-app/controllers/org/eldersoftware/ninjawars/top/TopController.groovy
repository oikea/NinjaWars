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

class TopController {
	def grailsApplication

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
