.PHONY: deploy
deploy:
	${CATALINA_HOME}/bin/shutdown.sh
	mvn install
	${CATALINA_HOME}/bin/startup.sh

.PHONY: clean
clean:
	ant clean
	mvn clean

all: deploy

.PHONY: test
test:
	./testrunner.sh

.PHONY: cleantomcat
cleantomcat:
	rm -rf ${CATALINA_HOME}/webapps/ers
	rm -rf ${CATALINA_HOME}/webapps/fewsservlet
	rm -rf ${CATALINA_HOME}/webapps/info
	rm -rf ${CATALINA_HOME}/webapps/provsimp
	rm -rf ${CATALINA_HOME}/webapps/VC
	rm -f ${CATALINA_HOME}/webapps/ers.war
	rm -f ${CATALINA_HOME}/webapps/fewsservlet.war
	rm -f ${CATALINA_HOME}/webapps/info.war
	rm -f ${CATALINA_HOME}/webapps/provsimp.war
	rm -f ${CATALINA_HOME}/webapps/VC.war
