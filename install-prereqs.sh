#!/usr/bin/env bash
# Install CISpaces on Ubuntu 16.04
# J.Robinson@software.ac.uk
# J.Graham@software.ac.uk

TOMCAT_VERSION="8.0.47"
DERBY_VERSION="10.12.1.1"

usage="$(basename "$0") [-h] [-y]

where:
    -h  Show this help text
    -y  Automatically answer yes for all questions"

yes='false'
while getopts 'yh' flag; do
    case "${flag}" in
        y) yes='true' ;;
        h) echo "${usage}"
           exit ;;
        *) exit 1 ;;
    esac
done

echo
echo "### - Install CISPACES Prerequisites on Ubuntu 16.04...? (Y/n)" 
if [ "${yes}" != 'true' ]; then read stopgo; if [ "$stopgo" == "n" ]; then exit 0; fi; fi

echo "# - Updating environment..."
echo "export CISPACES=${PWD}/cispaces" >> ~/.profile
source ~/.profile

echo "# - Install prerequisite OS packages [default-jdk-headless, wget, zip, screen, rabbitmq-server, maven]...? (Y/n)"
if [ "${yes}" != 'true' ]; then read stopgo; if [ "$stopgo" == "n" ]; then exit 0; fi; fi
sudo apt-get install --yes default-jdk-headless wget unzip screen rabbitmq-server maven
if [ $? -eq 0 ]; then echo "[OK]"; else echo "[Failed]"; exit; fi
echo

echo "# - Updating environment..."
echo "export JAVA_HOME=/usr/lib/jvm/default-java" >> ~/.profile
echo 

echo "# - Creating tools directory.."
mkdir -p $CISPACES/tools/
echo

echo "# - Install Apache Derby...? (Y/n)" 
if [ "${yes}" != 'true' ]; then read stopgo; if [ "$stopgo" == "n" ]; then exit 0; fi; fi
if [ ! -e "$CISPACES/tools/derby/db-derby-${DERBY_VERSION}-bin.tar.gz" ]; then
        mkdir -p $CISPACES/tools/derby/ \
	&& wget -O $CISPACES/tools/derby/db-derby-${DERBY_VERSION}-bin.tar.gz http://mirrors.ukfast.co.uk/sites/ftp.apache.org//db/derby/db-derby-${DERBY_VERSION}/db-derby-${DERBY_VERSION}-bin.tar.gz?raw=true 
fi	
tar xf $CISPACES/tools/derby/db-derby-${DERBY_VERSION}-bin.tar.gz -C $CISPACES/tools/derby
if [ $? -eq 0 ]; then echo "[OK]"; else echo "[Failed]"; exit; fi
echo

echo "# - Updating environment..."
echo "export GAIAN=$CISPACES/tools/derby/db-derby-${DERBY_VERSION}-bin" >> ~/.profile
source ~/.profile
echo

echo "# - Install Apache Tomcat...? (Y/n)" 
if [ "${yes}" != 'true' ]; then read stopgo; if [ "$stopgo" == "n" ]; then exit 0; fi; fi
mkdir -p $CISPACES/tools/tomcat
if [ ! -e "$CISPACES/tools/tomcat/apache-tomcat-${TOMCAT_VERSION}.tar.gz" ]; then
	wget -O $CISPACES/tools/tomcat/apache-tomcat-${TOMCAT_VERSION}.tar.gz http://www.mirrorservice.org/sites/ftp.apache.org/tomcat/tomcat-8/v${TOMCAT_VERSION}/bin/apache-tomcat-${TOMCAT_VERSION}.tar.gz
fi
tar xf $CISPACES/tools/tomcat/apache-tomcat-${TOMCAT_VERSION}.tar.gz -C ${CISPACES}/tools/tomcat/ \
	&& rm -rf $CISPACES/tools/tomcat/apache-tomcat-${TOMCAT_VERSION}/webapps/ROOT.war \
	&& rm -rf $CISPACES/tools/tomcat/apache-tomcat-${TOMCAT_VERSION}/webapps/ROOT 
if [ $? -eq 0 ]; then echo "[OK]"; else echo "[Failed]"; exit; fi
echo 

echo "# - Updating environment..."
echo "export CATALINA_HOME=${CISPACES}/tools/tomcat/apache-tomcat-${TOMCAT_VERSION}" >> ~/.profile
source ~/.profile
echo

echo "# - Copying GAIANDB library"
cp ${GAIAN}/lib/derbyclient.jar ${CATALINA_HOME}/lib/ \
&& cp ${GAIAN}/lib/derbyLocale* ${CATALINA_HOME}/lib/
if [ $? -eq 0 ]; then echo "[OK]"; else echo "[Failed]"; exit; fi
echo 

echo "# - Configure Tomcat...? (Y/n)"
if [ "${yes}" != 'true' ]; then read stopgo; if [ "$stopgo" == "n" ]; then exit 0; fi; fi
sed -i 's:</Context>::g' ${CISPACES}/tools/tomcat/apache-tomcat-${TOMCAT_VERSION}/conf/context.xml
cat << 'EOF' >> ${CISPACES}/tools/tomcat/apache-tomcat-${TOMCAT_VERSION}/conf/context.xml
<Resource name="jdbc/myDB"
        auth="Container"
        type="javax.sql.DataSource"
        username="gaiandb"
        password="passw0rd"
        driverClassName="org.apache.derby.jdbc.ClientDriver"
        url="jdbc:derby://localhost:1527/gaiandb"
        maxTotal="10"
        removeAbandonedOnBorrow="true"
        removeAbandonedTimeout="60"
        logAbandoned="true"
    />
</Context>
EOF
echo

echo "# - Create database tables...? (Y/n)"
if [ "${yes}" != 'true' ]; then read stopgo; if [ "$stopgo" == "n" ]; then exit 0; fi; fi

./create-database.sh

if [ $? -eq 0 ]; then echo "[OK] - Your system is now ready to install CISpaces."; else echo "[Failed]"; exit; fi
echo

