#!/usr/bin/env bash
# Setup fact-extraction on Ubuntu 16.04
# J.Graham@software.ac.uk

source ~/.profile

SQL_USER="intelanalysis"
SQL_DB_NAME="intelanalysis"
SQL_SCHEMA_NAME="factextract"

FACT_EXTRACTION_DIR=${CISPACES}/tools/fact-extraction

usage="$(basename "$0") [-h] [-y]

where:
    -h  Show this help text
    -y  Automatically answer yes for all questions
    -e  Setup over existing installation"

yes='false'
existing='false'
while getopts 'yhe' flag; do
    case "${flag}" in
        y) yes='true' ;;
        h) echo "${usage}"
           exit ;;
        e) existing='true' ;;
        *) exit 1 ;;
    esac
done

echo "### - Set up fact-extraction on Ubuntu 16.04...? (Y/n)"
if [ "${yes}" != 'true' ]; then read stopgo; if [ "$stopgo" == "n" ]; then exit 0; fi; fi

echo "# - Installing prerequisites [postgresql, postgis, curl, ant, python2.7, python-virtualenv, git-lfs]...(Y/n)"
if [ "${yes}" != 'true' ]; then read stopgo; if [ "$stopgo" == "n" ]; then exit 0; fi; fi
if [ "${existing}" != 'true' ]; then curl -s https://packagecloud.io/install/repositories/github/git-lfs/script.deb.sh | sudo bash; fi
if [ "${existing}" != 'true' ]; then sudo apt-get install --yes postgresql postgis curl ant python2.7 python-virtualenv git-lfs; fi
if [ "${existing}" != 'true' ]; then git lfs install; fi
if [ $? -eq 0 ]; then echo "[OK]"; else echo "[Failed]"; exit; fi

echo "# - Download fact-extraction...? (Y/n)"
if [ "${yes}" != 'true' ]; then read stopgo; if [ "$stopgo" == "n" ]; then exit 0; fi; fi
if [ "${existing}" != 'true' ]; then
    git clone https://gitlab.it-innovation.soton.ac.uk/IntelAnalysisDSTL/fact-extraction.git ${FACT_EXTRACTION_DIR}
else
    git -C ${FACT_EXTRACTION_DIR} fetch
fi
if [ $? -eq 0 ]; then echo "[OK]"; else echo "[Failed]"; exit; fi
echo

echo "# - Download fact-extraction...? (Y/n)"
if [ "${yes}" != 'true' ]; then read stopgo; if [ "$stopgo" == "n" ]; then exit 0; fi; fi
git -C ${FACT_EXTRACTION_DIR} checkout
git -C ${FACT_EXTRACTION_DIR} lfs pull -I third-party/*none-any.whl
git -C ${FACT_EXTRACTION_DIR} lfs pull -I third-party/stanford-postagger-full-2016-10-31.zip
git -C ${FACT_EXTRACTION_DIR} lfs pull -I third-party/stanford-parser-full-2016-10-31.zip
git -C ${FACT_EXTRACTION_DIR} lfs pull -I third-party/stanford-english-corenlp-2016-10-31-models.jar
if [ $? -eq 0 ]; then echo "[OK]"; else echo "[Failed]"; exit; fi
echo

echo "# - Creating role and database...(Y/n)" 
if [ "${yes}" != 'true' ]; then read stopgo; if [ "$stopgo" == "n" ]; then exit 0; fi; fi
if [ "${existing}" != 'true' ]; then sudo -u postgres createdb ${SQL_DB_NAME}; fi
if [ "${existing}" != 'true' ]; then sudo -u postgres createuser ${SQL_USER} -P; fi
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
if [ $? -eq 0 ]; then echo "[OK]"; else echo "[Failed]"; exit; fi

echo "# - Install Python requirements...(Y/n)"
if [ "${yes}" != 'true' ]; then read stopgo; if [ "$stopgo" == "n" ]; then exit 0; fi; fi
cp $(dirname $0)/requirements.txt ${FACT_EXTRACTION_DIR}/requirements.txt
xargs -L 1 pip install < ${FACT_EXTRACTION_DIR}/requirements.txt
pip install ${FACT_EXTRACTION_DIR}/third-party/*none-any.whl
python -m nltk.downloader stopwords names
if [ $? -eq 0 ]; then echo "[OK]"; else echo "[Failed]"; exit; fi

echo "# - Extract Stanford CoreNLP...(Y/n)"
if [ "${yes}" != 'true' ]; then read stopgo; if [ "$stopgo" == "n" ]; then exit 0; fi; fi
if [ "${existing}" != 'true' ]; then unzip ${FACT_EXTRACTION_DIR}/third-party/stanford-parser-full-2016-10-31.zip -d ${FACT_EXTRACTION_DIR}/third-party; fi
if [ "${existing}" != 'true' ]; then unzip ${FACT_EXTRACTION_DIR}/third-party/stanford-postagger-full-2016-10-31.zip -d ${FACT_EXTRACTION_DIR}/third-party; fi
if [ "${existing}" != 'true' ]; then ln -s ${FACT_EXTRACTION_DIR}/third-party/stanford*models.jar ${FACT_EXTRACTION_DIR}/third-party/stanford-parser-full-2016-10-31/.; fi
if [ $? -eq 0 ]; then echo "[OK]"; else echo "[Failed]"; exit; fi

echo "# - Configure fact-extraction...(Y/n)"
if [ "${yes}" != 'true' ]; then read stopgo; if [ "$stopgo" == "n" ]; then exit 0; fi; fi
CONFIG_FILE=${FACT_EXTRACTION_DIR}/config/fact_extraction_app/fact_extraction_app.ini
if [ "${existing}" != 'true' ]; then sed -i "s#/projects-git/intel-analysis-dstl/fact-extraction#${FACT_EXTRACTION_DIR}#g" ${CONFIG_FILE}; fi
if [ "${existing}" != 'true' ]; then sed -i "s#/stanford-postagger-full#${FACT_EXTRACTION_DIR}/third-party/stanford-postagger-full-2016-10-31#g" ${CONFIG_FILE}; fi
if [ "${existing}" != 'true' ]; then sed -i "s#/stanford-parser-full#${FACT_EXTRACTION_DIR}/third-party/stanford-parser-full-2016-10-31#g" ${CONFIG_FILE}; fi
sed -i "s#db_user=postgres#db_user=intelanalysis#g" ${FACT_EXTRACTION_DIR}/config/fact_extraction_app/fact_extraction_app.ini
sed -i "s#db_pass=postgres#db_pass=passw0rd#g" ${FACT_EXTRACTION_DIR}/config/fact_extraction_app/fact_extraction_app.ini
if [ $? -eq 0 ]; then echo "[OK]"; else echo "[Failed]"; exit; fi

echo "# - Modify Python source...(Y/n)"
if [ "${yes}" != 'true' ]; then read stopgo; if [ "$stopgo" == "n" ]; then exit 0; fi; fi
sed -i "s#connection.socket#connection#g" ${FACT_EXTRACTION_DIR}/src/fact_extraction_app/RabbitMQHandler.py
if [ $? -eq 0 ]; then echo "[OK]"; else echo "[Failed]"; exit; fi

if [ $? -eq 0 ]; then echo "[OK] - Fact-extraction set up."; else echo "[Failed]"; exit; fi
