modules = {
	top {
		resource(url:"/images/top/title01.jpg", attrs:[width:"100%"], disposition:"inline")
		resource(url:"/images/top/title02.jpg", attrs:[width:"100%"], disposition:"inline")
	}

	common {
		resource(url:"/css/common/reset.css", attrs:[media:"all"])
		resource(url:"/css/common/base.css", attrs:[media:"all"])
		resource(url:"/images/common/powered_by.png", attrs:[alt:"Powered by Grails", width:80, height:24], disposition:"inline")
	}
}
