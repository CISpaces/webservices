.PHONY: deploy
deploy:
	${CATALINA_HOME}/bin/shutdown.sh
	ant deploy
	${CATALINA_HOME}/bin/catalina.sh jpda start -agentlib:jdwp=transport=dt_socket,address=42137,suspend=n,server=y

.PHONY: clean
clean:
	ant clean

all: deploy

.PHONY: test
test:
	./testrunner.sh
