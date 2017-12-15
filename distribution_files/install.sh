#!/bin/bash

# Install CISpaces on EL 7.x
# J.Robinson@software.ac.uk

echo "### - Install CISpaces on Enterprise Linux 7.x ? (Y/n)"
read stopgo; if [ "$stopgo" == "n" ]; then exit 0; fi

if [[ $EUID -ne 0 ]]; then
   echo "This script must be run as root" 
   exit 1
fi

start_dir=$(pwd)
cd fact-extraction/
source install.sh

cd ${start_dir}

echo
if [ $? -eq 0 ]; then echo "[OK] - Your system is now ready to run CISpaces. - ./start-cispaces.sh "; else echo "[Failed]"; exit; fi

