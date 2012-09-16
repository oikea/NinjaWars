package org.eldersoftware.ninjawars.authority

import com.the6hours.grails.springsecurity.twitter.TwitterUserDomain

class TwitterUser implements TwitterUserDomain {
	int uid
	String screenName
	String tokenSecret
	String token

	static belongsTo = [user: Account]

	static constraints = {
		uid(unique:true)
	}
}
