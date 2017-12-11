#!/bin/bash

# Start Services for CISpaces
# J.Robinson@software.ac.uk

echo "### - Starting CISPaces "
source ~/.profile

echo "# - Starting Apache Derby in the background..."
cd ${CISPACES}/tools/derby
bin/startNetworkServer &
if [ $? -eq 0 ]; then echo "[OK]"; else echo "[Failed]"; exit; fi
sleep 2
cd -

echo
echo "# - Starting Apache Tomcat in the background..."
${CATALINA_HOME}/bin/startup.sh
if [ $? -eq 0 ]; then
	echo "[OK]"
	echo
	echo "# Waiting 20s for application startup..."
	for ((i=20; i>=1; i--))
	do
		sleep 1
    		echo -n "${i}..."
	done
	echo
	echo
	echo "# CISpaces started listening at the following URLs:"
	echo
	for host_ip in $(hostname -I)
	do
		echo "http://${host_ip}:8080"
	done
	echo
	echo "# Please ensure port 8080 is accessible."
	echo
	echo "# RHEL / CentOS:"
	echo "    $ sudo firewall-cmd --zone=public --add-port=8080/tcp --permanent"
	echo "    $ sudo firewall-cmd --reload"
	echo 
	echo "# Ubuntu:"
	echo "    $ sudo ufw allow 8080"
	echo
	echo "# Do not close this terminal"
else echo "[Failed]"; exit; fi
