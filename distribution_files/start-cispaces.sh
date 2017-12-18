#!/bin/bash

# Start Services for CISpaces
# J.Robinson@software.ac.uk

if [[ $EUID -eq 0 ]]; then
   echo "This script must NOT be run as root" 
   exit 1
fi

start_dir=$(pwd)
export JAVA_HOME=${start_dir}/fact-extraction/third-party/jdk1.8.0_151

echo "### - Starting CISPaces "

if [ -d fact-extraction ]; then
	echo
	echo "Starting Fact Extraction in the background..."
	cd fact-extraction/
	./startup-fe.sh &
	sleep 3
	cd ${start_dir}
fi

echo
echo "# - Starting Apache Derby in the background..."
cd tools/derby
bin/startNetworkServer > cispaces-fact-extraction.log 2>&1 &
if [ $? -eq 0 ]; then echo "[OK]"; else echo "[Failed]"; exit; fi
sleep 2
cd -

echo
echo "# - Starting Apache Tomcat in the background..."
tools/tomcat/bin/startup.sh
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
