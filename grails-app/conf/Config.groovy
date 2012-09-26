grails.config.locations = [
	"file:./grails-app/conf/SGConfig.groovy",
	"file:./grails-app/conf/NinjaWarsConfig.groovy",
	"file:./grails-app/conf/SecurityConfig.groovy",
	"file:./grails-app/conf/Log4jConfig.groovy",
	/* ↓ここからバージョン管理外 */
	"file:./grails-app/conf/AuthKeys.groovy",
	/* ↑ここまでバージョン管理外 */
]

grails.gorm.failOnError = true
grails.project.groupId = appName
grails.mime.file.extensions = true
grails.mime.use.accept.header = false
grails.mime.types = [
	all:"*/*",
	atom:"application/atom+xml",
	css:"text/css",
	csv:"text/csv",
	form:"application/x-www-form-urlencoded",
	html:["text/html","application/xhtml+xml"],
	js:"text/javascript",
	json:["application/json", "text/json"],
	multipartForm:"multipart/form-data",
	rss:"application/rss+xml",
	text:"text/plain",
	xml:["text/xml", "application/xml"]
]

grails.urlmapping.cache.maxsize = 5000
grails.resources.adhoc.patterns = []
grails.views.default.codec = "none"
grails.views.gsp.encoding = "UTF-8"
grails.views.gsp.sitemesh.preprocess = true
grails.converters.encoding = "UTF-8"
grails.scaffolding.templates.domainSuffix = "Instance"
grails.json.legacy.builder = false
grails.enable.native2ascii = true
grails.spring.bean.packages = []
grails.web.disable.multipart = true
grails.exceptionresolver.params.exclude = ["password"]
grails.hibernate.cache.queries = false
grails.logging.jul.usebridge = false

environments {
	production {
		// grails.serverURL = "http://www.ninjawars.com"
	}
	development {
		//grails.logging.jul.usebridge = true
	}
}
