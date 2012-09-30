class UrlMappings {
	static mappings = {
		"/"(controller:"top", action:"index")
		"/login/$action?" (controller:"login")
		"/logout/$action?" (controller:"logout")
		"/signup/$action?" (controller:"signup")
		"/tutorial/" (controller:"tutorial", action:"execute")
		"/mypage/" (controller:"mypage", action:"index")

		//"400"(view:'/error')
		//"403"(view:'/error')
		//"404"(view:'/error')
		//"405"(view:'/error')
		"500"(view:'/error')
	}
}
