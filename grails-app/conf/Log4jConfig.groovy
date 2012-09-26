import org.apache.log4j.ConsoleAppender
import org.apache.log4j.DailyRollingFileAppender
import org.apache.log4j.PatternLayout
import org.apache.log4j.Level

def DEFAULT_LAYOUT_PATTERN = new PatternLayout("%d [%t] %-5p %c{1} %x - %m%n")
def CONSOLE_LAYOUT_PATTERN = new PatternLayout("%d{HH:mm:ss} %-5p - %m%n")

log4j = {
	appenders {
		"null"(name:"stacktrace")
		appender(new ConsoleAppender(name:"stdout", layout:CONSOLE_LAYOUT_PATTERN))
		appender(
			new DailyRollingFileAppender(
				name:"infoLog",
				datePattern:"'.'yyyy-MM-dd",
				layout:DEFAULT_LAYOUT_PATTERN,
				file:"target/info.log",
				threshold:Level.INFO
			)
		)
		appender(
			new DailyRollingFileAppender(
				name:"errorLog",
				datePattern:"'.'yyyy-MM-dd",
				layout:DEFAULT_LAYOUT_PATTERN,
				file:"target/error.log",
				threshold:Level.WARN
			)
		)
	}

	error(
		"grails.app",
		"org.eldersoftware",
		"org.codehaus.groovy.grails.web.servlet",
		"org.codehaus.groovy.grails.web.pages",
		"org.codehaus.groovy.grails.web.sitemesh",
		"org.codehaus.groovy.grails.web.mapping.filter",
		"org.codehaus.groovy.grails.web.mapping",
		"org.codehaus.groovy.grails.commons",
		"org.codehaus.groovy.grails.plugins",
		"org.codehaus.groovy.grails.orm.hibernate",
		"org.springframework",
		"org.hibernate",
		"net.sf.ehcache.hibernate"
	)

	warn(
		"grails.app",
		"org.eldersoftware",
		"org.mortbay.log"
	)

	info(
		"grails.app",
		"org.eldersoftware",
		"org.springframework.security"
	)

	debug(
		//"org.hibernate.SQL"
		"org.eldersoftware",
		"grails.app.job",
		"grails.app.domain",
		"grails.app.controllers",
		"grails.app.services",
		"org.codehaus.groovy.grails.plugins.springsecurity"
	)

	root {
		error("stdout", "infolog", "errorLog")

		additivity = true
	}
}
