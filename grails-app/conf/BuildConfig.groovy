grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"

grails.project.fork = [
    // configure settings for compilation JVM, note that if you alter the Groovy version forked compilation is required
    //  compile: [maxMemory: 256, minMemory: 64, debug: false, maxPerm: 256, daemon:true],

    // configure settings for the test-app JVM, uses the daemon by default
    test: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256, daemon:true],
    // configure settings for the run-app JVM
    run: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256, forkReserve:false],
    // configure settings for the run-war JVM
    war: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256, forkReserve:false],
    // configure settings for the Console UI JVM
    console: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256]
]

grails.project.dependency.resolver = "maven"  // or ivy
grails.project.dependency.resolution = {
    // inherit Grails' default dependencies
    inherits("global") {
        excludes 'javax.transaction:jta:1.1'
        // uncomment to disable ehcache
        // excludes 'ehcache'
    }
    log "warn" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
    repositories {
        grailsCentral()
        mavenLocal()
        mavenCentral()
        // uncomment the below to enable remote dependency resolution
        // from public Maven repositories

        mavenRepo "https://repository.jboss.org/nexus/content/groups/public/"
        //mavenRepo "http://repository.codehaus.org"
        mavenRepo "http://download.java.net/maven/2/"
        //mavenRepo "http://repository.jboss.com/maven2/"
    }
    dependencies {
        def droolsVersion = '6.0.0.CR3'

        runtime "org.jbpm:jbpm-bpmn2:${droolsVersion}"
        runtime "org.jbpm:jbpm-flow:${droolsVersion}"

        runtime ("org.jbpm:jbpm-runtime-manager:${droolsVersion}") {
            excludes 'org.slf4j:slf4j-ext:1.7.2'

        }
        runtime "org.jbpm:jbpm-persistence-jpa:${droolsVersion}"


        /**
         * use dependency org.kie.kie-ci to use embedded maven for remote discovery
         * (find kieModules in local maven repo)
         *
         * use KieScanner to automatically update dependency graphs from maven.
         */

        /*
        runtime("org.kie:kie-spring:${droolsVersion}") {
            excludes    'org.springframework:spring-core:3.0.6.RELEASE',
                        'org.springframework:spring-beans:3.0.6.RELEASE',
                        'org.springframework:spring-context:3.0.6.RELEASE',
                        'org.jboss.seam.spring:seam-spring-core:3.1.0.Final',
                        //'javax.enterprise:cdi-api:1.0-SP4',
                        'org.jboss.weld.se:weld-se-core:1.1.13.Final'
        }
        */


        //For Atomikos plugin
        compile ('org.springframework:spring-jms:3.2.4.RELEASE'){
            export = false
        }

    }

    plugins {
        build(":release:3.0.0",
              ":rest-client-builder:1.0.3",
              ":tomcat:7.0.41") {
            export = false
        }

        compile(':platform-core:1.0.RC5',
                ":atomikos:1.0"
        ){
            export = false
        }

        runtime(":hibernate:3.6.10.1"
                ,":droolsjbpm-atomikos-integration:1.0"
                ){
            export = false
        }
    }
}
