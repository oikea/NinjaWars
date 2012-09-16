class UrlMappings {
	static mappings = {
		"/"(controller:"top", action:"index")
		"/auth/$action?" (controller:"twitterAuth")

		"400"(view:'/error')
		"403"(view:'/error')
		"404"(view:'/error')
		"405"(view:'/error')
		"500"(view:'/error')
	}
}
