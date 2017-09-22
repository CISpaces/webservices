#!/bin/bash

# Create databse tables required for CISpaces
# J.Robinson@software.ac.uk

echo "### - Creating database tables for CISPaces "
source ~/.profile

cd ${CISPACES}/tools/derby
echo "# - Starting Apache Derby in the background..."
${GAIAN}/bin/startNetworkServer &
if [ $? -eq 0 ]; then echo "[OK]"; else echo "[Failed]"; exit; fi
sleep 5

echo "# - Importing tables from ${GAIAN}/bin/ij ${CISPACES}/../DATABASE/create-cispaces-tables.sql "
${GAIAN}/bin/ij ${CISPACES}/../DATABASE/create-cispaces-tables.sql
if [ $? -eq 0 ]; then echo "[OK]"; else echo "[Failed]"; exit; fi

echo "The CISpaces database has been created at: ${CISPACES}/tools/derby/gaindb"
echo "If you need to delete the database, remove this directory"
echo

echo "# - Shutting down background Apache Derby..."
kill $!
if [ $? -eq 0 ]; then echo "[OK]"; else echo "[Failed]"; exit; fi
cd -
