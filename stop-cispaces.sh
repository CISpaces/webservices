#!/bin/bash

# Stop Services for CISpaces
# J.Robinson@software.ac.uk

echo "### - Stopping CISPaces "
source ~/.profile

echo "# - Stopping Apache Derby..."
cd ${CISPACES}/tools/derby
bin/stopNetworkServer
if [ $? -eq 0 ]; then echo "[OK]"; else echo "[Failed]"; exit; fi

sleep 2
cd -

echo
echo "# - Stopping Apache Tomcat..."
$CATALINA_HOME/bin/shutdown.sh
if [ $? -eq 0 ]; then 
	echo "[OK]"
	echo
	echo "# CISpaces stopped"
else echo "[Failed]"; exiti 1; fi
