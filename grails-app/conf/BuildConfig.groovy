grails.servlet.version = "2.5"
grails.project.target.level = 1.6
grails.project.source.level = 1.6
grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"

grails.project.dependency.resolution = {
	inherits("global") { }
	dependencies { }

	log "error"
	checksums true

	repositories {
		inherits true

		grailsPlugins()
		grailsHome()
		grailsCentral()

		mavenLocal()
		mavenCentral()
    }

	plugins {
		runtime ":hibernate:$grailsVersion"
		runtime ":jquery:1.7.2"
		runtime ":resources:1.1.6"

		build ":tomcat:$grailsVersion"

		runtime ":database-migration:1.1"

		compile ":cache:1.0.0"
	}
}

// es-commonプラグインは動的編集可能なようにインラインプラグインで設定
grails.plugin.location."es-common-core"="../es-common-core"
