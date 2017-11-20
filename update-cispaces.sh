#!/bin/bash

# Update CISpaces to lastet Git Master
# J.Robinson@software.ac.uk

echo "### - Update CISPaces to latest Git Master..? (Y/n)"
read stopgo; if [ "$stopgo" == "n" ]; then exit 0; fi

echo "# Stopping running CISpaces instances..."
./stop-cispaces.sh > /dev/null

echo "Updating..."
if [ $? -eq 0 ]; then echo "[OK]"; else echo "[Failed]"; exit; fi

git pull origin master
if [ $? -eq 0 ]; then echo "[OK]"; else echo "[Failed]"; exit; fi

echo "Rebuilding..."
mvn install
if [ $? -eq 0 ]; then 
	echo "[OK]"
	echo "You can now run ./start-cispaces.sh"
else echo "[Failed]"; exit 1; fi
