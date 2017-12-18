#!/bin/bash

# Stop Services for CISpaces
# J.Robinson@software.ac.uk

echo "### - Stopping CISPaces "

start_dir=$(pwd)
export JAVA_HOME=${start_dir}/fact-extraction/third-party/jdk1.8.0_151

echo "# - Stopping Apache Derby..."
cd tools/derby
bin/stopNetworkServer
if [ $? -eq 0 ]; then echo "[OK]"; else echo "[Failed]"; fi

sleep 2
cd -

echo
echo "# - Stopping Apache Tomcat..."
tools/tomcat/bin/shutdown.sh
if [ $? -eq 0 ]; then echo "[OK]"; else echo "[Failed]"; fi

echo
echo "# - Stopping Fact Extraction..."
pgrep -f  run.fact-extraction-app

if [ $? -eq 0 ]; then 
	echo "[OK]"
	echo
	echo "# CISpaces stopped"
else echo "[Failed]"; exiti 1; fi

