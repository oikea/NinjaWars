grails.plugins.springsecurity.userLookup.userDomainClassName = "org.eldersoftware.ninjawars.authority.Account"
grails.plugins.springsecurity.userLookup.usernamePropertyName = "userId"

grails.plugins.springsecurity.authority.className = "org.eldersoftware.ninjawars.authority.Role"
grails.plugins.springsecurity.userLookup.authorityJoinClassName = "org.eldersoftware.ninjawars.authority.AccountRole"

grails.plugins.springsecurity.rememberMe.cookieName = "ninjawars_remember_me"
grails.plugins.springsecurity.rememberMe.alwaysRemember = true
grails.plugins.springsecurity.rememberMe.tokenValiditySeconds = 86400 * 360
grails.plugins.springsecurity.rememberMe.key = 'furinkazan'

grails.plugins.springsecurity.auth.loginFormUrl = "/"

environments {
	production {
		grails.plugins.springsecurity.portMapper.httpPort = 80
		grails.plugins.springsecurity.portMapper.httpsPort = 443
	}
}
