# Base image
FROM ubuntu:xenial

MAINTAINER James Graham <J.Graham@software.ac.uk>

WORKDIR /usr/local/cispaces-web-services
COPY . ./

# Securely get the deployment ssh private key and clone the repo
# Delete the private key before this layer is commited so it does not persist
#RUN \
#	wget -O /tmp/id_rsa_deploy http://172.17.0.1:8001/id_rsa_deploy && \
#	chmod 600 /tmp/id_rsa_deploy && \
#	mkdir ~/.ssh/ && \
#	echo "Host gitlab.it-innovation.soton.ac.uk\nIdentityFile /tmp/id_rsa_deploy\nIdentitiesOnly yes" >> ~/.ssh/config && \
#	touch ~/.ssh/known_hosts && \
#	ssh-keyscan gitlab.it-innovation.soton.ac.uk >> ~/.ssh/known_hosts && \
#	git clone -v git@gitlab.it-innovation.soton.ac.uk:IntelAnalysisDSTL/cispaces-web-services.git && \
#	git checkout maven && \
#	rm /tmp/id_rsa_deploy

RUN apt-get install -y sudo

RUN bash install-prereqs.sh -y

#RUN source ~/.profile && cd ${CISPACES}/tools/derby && ${GAIAN}/bin/startNetworkServer &

#RUN source ~/.profile && ${CATALINA_HOME}/bin/startup.sh

EXPOSE 8080
