grails.plugins.springsecurity {
	userLookup.userDomainClassName = "org.eldersoftware.ninjawars.authority.Account"
	userLookup.authorityJoinClassName = "org.eldersoftware.ninjawars.authority.AccountRole"
	authority.className = "org.eldersoftware.ninjawars.authority.Role"
	requestMap.className = "org.eldersoftware.ninjawars.authority.RequestMap"
	securityConfigType = "Requestmap"

	twitter {
		app.key = "NinjaWars"
		domain.className = "org.eldersoftware.ninjawars.authority.TwitterUser"
	}
}
