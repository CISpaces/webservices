.PHONY: deploy
deploy:
	${CATALINA_HOME}/bin/shutdown.sh
	ant deploy
	${CATALINA_HOME}/bin/startup.sh

.PHONY: clean
clean:
	ant clean

all: deploy

.PHONY: test
test:
	./testrunner.sh
