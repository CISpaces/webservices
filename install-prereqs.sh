# Install CISpaces on Ubuntu 16.04
# J.Robinson@software.ac.uk
# J.Graham@software.ac.uk

TOMCAT_VERSION="8.0.46"
GAIAN_VERSION="2.1.6d_20150804"

echo "### - Install CISPACES Prerequisites on Ubuntu 16.04...? (Y/n)" 
read stopgo; if [ "$stopgo" == "n" ]; then exit 0; fi

echo "# - Updating environment..."
echo "export CISPACES=${PWD}/cispaces" >> ~/.profile
source ~/.profile

echo "# - Installing prerequisites [default-jdk, ant, zip, screen]...(Y/n)" 
read stopgo; if [ "$stopgo" == "n" ]; then exit 0; fi
sudo apt-get install --yes default-jdk ant unzip screen
if [ $? -eq 0 ]; then echo "[OK]"; else echo "[Failed]"; exit; fi

echo "# - Updating environment..."
echo "export JAVA_HOME=/usr/lib/jvm/default-java" >> ~/.profile

echo "# - Installing GaianDB...(Y/n)" 
read stopgo; if [ "$stopgo" == "n" ]; then exit 0; fi
mkdir -p $CISPACES/tools/GaianDB/GAIANDB_V${GAIAN_VERSION}
wget -O GAIANDB_V${GAIAN_VERSION}.zip https://github.com/gaiandb/gaiandb/blob/master/build/GAIANDB_V${GAIAN_VERSION}.zip?raw=true
unzip GAIANDB_V${GAIAN_VERSION}.zip -d $CISPACES/tools/GaianDB/GAIANDB_V${GAIAN_VERSION}
if [ $? -eq 0 ]; then echo "[OK]"; else echo "[Failed]"; exit; fi

echo "# - Updating environment..."
echo "export GAIAN=${CISPACES}/tools/GaianDB/GAIANDB_V${GAIAN_VERSION}" >> ~/.profile
source ~/.profile

echo "# - Apache Tomcat...(Y/n)" 
read stopgo; if [ "$stopgo" == "n" ]; then exit 0; fi
mkdir -p $CISPACES/tools/Tomcat
if [ ! -e "apache-tomcat-${TOMCAT_VERSION}.tar.zxf" ]; then
	wget http://www.mirrorservice.org/sites/ftp.apache.org/tomcat/tomcat-8/v${TOMCAT_VERSION}/bin/apache-tomcat-${TOMCAT_VERSION}.tar.gz && tar xf apache-tomcat-${TOMCAT_VERSION}.tar.gz -C ${CISPACES}/tools/Tomcat/
fi
if [ $? -eq 0 ]; then echo "[OK]"; else echo "[Failed]"; exit; fi

echo "# - Updating environment..."
echo "export CATALINA_HOME=${CISPACES}/tools/Tomcat/apache-tomcat-${TOMCAT_VERSION}" >> ~/.profile
source ~/.profile

echo "# - Copying GAIANDB library"
cp ${GAIAN}/lib/derbyclient.jar ${CATALINA_HOME}/lib/
if [ $? -eq 0 ]; then echo "[OK]"; else echo "[Failed]"; exit; fi

echo "# - Configuring Tomcat...(Y/n)"
read stopgo; if [ "$stopgo" == "n" ]; then exit 0; fi
sed -i 's:</Context>::g' ${CISPACES}/tools/Tomcat/apache-tomcat-${TOMCAT_VERSION}/conf/context.xml
cat << 'EOF' >> ${CISPACES}/tools/Tomcat/apache-tomcat-${TOMCAT_VERSION}/conf/context.xml
<Resource name="jdbc/myDB"
        auth="Container"
        type="javax.sql.DataSource"
        username="gaiandb"
        password="passw0rd"
        driverClassName="org.apache.derby.jdbc.ClientDriver"
        url="jdbc:derby://localhost:6414/gaiandb"
        maxTotal="10"
        removeAbandonedOnBorrow="true"
        removeAbandonedTimeout="60"
        logAbandoned="true"
    />
</Context>
EOF
if [ $? -eq 0 ]; then echo "[OK] - Your system is now ready to install CISpaces."; else echo "[Failed]"; exit; fi
