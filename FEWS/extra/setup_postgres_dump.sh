#!/usr/bin/env bash
# Import PostgreSQL dump on Ubuntu 16.04
# J.Graham@software.ac.uk

SQL_DUMP="scenario-25-sept-2017.sql"
SQL_USER="factextract"
SQL_DB_NAME="factextract"
SQL_SCHEMA_NAME="factextract"

echo "### - Install PostgreSQL dump on Ubuntu 16.04...? (Y/n)" 
read stopgo; if [ "$stopgo" == "n" ]; then exit 0; fi

echo "# - Installing prerequisites [postgresql]...(Y/n)" 
read stopgo; if [ "$stopgo" == "n" ]; then exit 0; fi
sudo apt-get install --yes postgresql
if [ $? -eq 0 ]; then echo "[OK]"; else echo "[Failed]"; exit; fi

echo "# - Creating role and database...(Y/n)" 
read stopgo; if [ "$stopgo" == "n" ]; then exit 0; fi
sudo -u postgres createdb ${SQL_DB_NAME}
sudo -u postgres createuser ${SQL_USER} -P
sudo -u postgres createdb ${SQL_USER}
if [ $? -eq 0 ]; then echo "[OK]"; else echo "[Failed]"; exit; fi

echo "# - Importing SQL dump...(Y/n)" 
read stopgo; if [ "$stopgo" == "n" ]; then exit 0; fi
sudo -u postgres psql -d ${SQL_DB_NAME} < ${SQL_DUMP}
if [ $? -eq 0 ]; then echo "[OK]"; else echo "[Failed]"; exit; fi

echo "# - Modifying PostgreSQL config...(Y/n)" 
read stopgo; if [ "$stopgo" == "n" ]; then exit 0; fi
sudo sed -i.bak "s/#listen_addresses = 'localhost'/listen_addresses = '*'/" /etc/postgresql/9.5/main/postgresql.conf
echo "host    ${SQL_DB_NAME}     ${SQL_USER}             all                     password" | sudo tee --append /etc/postgresql/9.5/main/pg_hba.conf
if [ $? -eq 0 ]; then echo "[OK]"; else echo "[Failed]"; exit; fi

echo "# - Restarting PostgreSQL service...(Y/n)" 
read stopgo; if [ "$stopgo" == "n" ]; then exit 0; fi
sudo systemctl restart postgresql
if [ $? -eq 0 ]; then echo "[OK]"; else echo "[Failed]"; exit; fi

echo "# - Setting database permissions...(Y/n)" 
read stopgo; if [ "$stopgo" == "n" ]; then exit 0; fi
echo "GRANT ALL ON SCHEMA ${SQL_DB_NAME} TO ${SQL_USER};" | sudo -u postgres psql -d ${SQL_DB_NAME}
echo "GRANT ALL ON ALL TABLES IN SCHEMA ${SQL_SCHEMA_NAME} TO ${SQL_USER};" | sudo -u postgres psql -d ${SQL_DB_NAME}
if [ $? -eq 0 ]; then echo "[OK]"; else echo "[Failed]"; exit; fi

if [ $? -eq 0 ]; then echo "[OK] - PostgreSQL dump imported."; else echo "[Failed]"; exit; fi
