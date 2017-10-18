#!/usr/bin/env bash
# Import PostgreSQL dump on Ubuntu 16.04
# J.Graham@software.ac.uk

SQL_USER="intelanalysis"
SQL_DB_NAME="intelanalysis"
SQL_SCHEMA_NAME="factextract"

FACT_EXTRACTION_DIR=${CISPACES}/tools/fact-extraction

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

echo "### - Set up fact-extraction on Ubuntu 16.04...? (Y/n)"
if [ "${yes}" != 'true' ]; then read stopgo; if [ "$stopgo" == "n" ]; then exit 0; fi; fi

echo "# - Installing prerequisites [postgresql, postgis]...(Y/n)"
if [ "${yes}" != 'true' ]; then read stopgo; if [ "$stopgo" == "n" ]; then exit 0; fi; fi
curl -s https://packagecloud.io/install/repositories/github/git-lfs/script.deb.sh | sudo bash
sudo apt-get install --yes postgresql postgis ant python2.7 python-virtualenv git-lfs
git lfs install
if [ $? -eq 0 ]; then echo "[OK]"; else echo "[Failed]"; exit; fi

echo "# - Download fact-extraction...? (Y/n)"
if [ "${yes}" != 'true' ]; then read stopgo; if [ "$stopgo" == "n" ]; then exit 0; fi; fi
git lfs clone https://gitlab.it-innovation.soton.ac.uk/IntelAnalysisDSTL/fact-extraction.git ${FACT_EXTRACTION_DIR}
if [ $? -eq 0 ]; then echo "[OK]"; else echo "[Failed]"; exit; fi
echo

echo "# - Creating role and database...(Y/n)" 
if [ "${yes}" != 'true' ]; then read stopgo; if [ "$stopgo" == "n" ]; then exit 0; fi; fi
sudo -u postgres createdb ${SQL_DB_NAME}
sudo -u postgres createuser ${SQL_USER} -P
echo "CREATE EXTENSION IF NOT EXISTS postgis;" | sudo -u postgres psql -d ${SQL_DB_NAME}
echo "CREATE EXTENSION IF NOT EXISTS fuzzystrmatch;" | sudo -u postgres psql -d ${SQL_DB_NAME}
echo "CREATE EXTENSION IF NOT EXISTS postgis_tiger_geocoder;" | sudo -u postgres psql -d ${SQL_DB_NAME}
echo "CREATE EXTENSION IF NOT EXISTS hstore;" | sudo -u postgres psql -d ${SQL_DB_NAME}
echo "CREATE SCHEMA IF NOT EXISTS ${SQL_SCHEMA_NAME};" | sudo -u postgres psql -d ${SQL_DB_NAME}
if [ $? -eq 0 ]; then echo "[OK]"; else echo "[Failed]"; exit; fi

echo "# - Setting database permissions...(Y/n)" 
if [ "${yes}" != 'true' ]; then read stopgo; if [ "$stopgo" == "n" ]; then exit 0; fi; fi
echo "GRANT ALL ON SCHEMA ${SQL_SCHEMA_NAME} TO ${SQL_USER};" | sudo -u postgres psql -d ${SQL_DB_NAME}
echo "GRANT ALL ON ALL TABLES IN SCHEMA ${SQL_SCHEMA_NAME} TO ${SQL_USER};" | sudo -u postgres psql -d ${SQL_DB_NAME}
if [ $? -eq 0 ]; then echo "[OK]"; else echo "[Failed]"; exit; fi

echo "# - Modifying PostgreSQL config...(Y/n)" 
if [ "${yes}" != 'true' ]; then read stopgo; if [ "$stopgo" == "n" ]; then exit 0; fi; fi
sudo sed -i.bak "s/#listen_addresses = 'localhost'/listen_addresses = '*'/" /etc/postgresql/9.5/main/postgresql.conf
echo "host    ${SQL_DB_NAME}     ${SQL_USER}             all                     password" | sudo tee --append /etc/postgresql/9.5/main/pg_hba.conf
if [ $? -eq 0 ]; then echo "[OK]"; else echo "[Failed]"; exit; fi

echo "# - Restarting PostgreSQL service...(Y/n)" 
if [ "${yes}" != 'true' ]; then read stopgo; if [ "$stopgo" == "n" ]; then exit 0; fi; fi
sudo systemctl restart postgresql
if [ $? -eq 0 ]; then echo "[OK]"; else echo "[Failed]"; exit; fi

echo "# - Setting up virtualenv...(Y/n)"
if [ "${yes}" != 'true' ]; then read stopgo; if [ "$stopgo" == "n" ]; then exit 0; fi; fi
virtualenv -p python2.7 ${FACT_EXTRACTION_DIR}/env
source ${FACT_EXTRACTION_DIR}/env/bin/activate
pip install -r ${FACT_EXTRACTION_DIR}/requirements.txt
pip install ${FACT_EXTRACTION_DIR}/third-party/*none-any.whl
if [ $? -eq 0 ]; then echo "[OK]"; else echo "[Failed]"; exit; fi

if [ $? -eq 0 ]; then echo "[OK] - Fact-extraction set up."; else echo "[Failed]"; exit; fi
