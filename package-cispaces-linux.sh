#!/usr/bin/env bash
# Package CISpaces WebServices for Deployment on RHEL
# Tested on RHEL 7.3
# J.Robinson@software.ac.uk

echo
echo "### - Package CISpaces Web Services for linux? (Y/n)"

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

if [ "${yes}" != 'true' ]; then read stopgo; if [ "$stopgo" == "n" ]; then exit 0; fi; fi

echo
echo "Looking for CISpaces Web Services..."
find cispaces/tools/tomcat/ | grep war$
if [ $? -ne 0 ]; then
        echo "# Failed to find CISpaces Web Services to package - did you run 'mvn install'?"
        exit 1
fi  
echo "[OK]"

echo
echo "Removing downloaded dependency archives.."
rm -f cispaces/tools/*.tar.gz
echo "[OK]"

echo
echo "Copying in start / stop scripts..."
cp start-cispaces.sh stop-cispaces.sh cispaces/
echo "Modifying start / stop scripts..."
sed -i 's/source \~\/\.profile//' cispaces/start-cispaces.sh cispaces/stop-cispaces.sh \
	&& sed -i 's/\${CISPACES}\///' cispaces/start-cispaces.sh cispaces/stop-cispaces.sh \
	&& sed -i 's/\${CATALINA_HOME}\//tools\/tomcat\//' cispaces/start-cispaces.sh cispaces/stop-cispaces.sh
if [ $? -eq 0 ]; then echo "[OK]"; else echo "[Failed]"; exit; fi

echo
echo "Copying example_cis_files/..."
cp -a example_cis_files/ cispaces
echo "[OK]"

echo
echo "Copying README.dist.md"
cp README.dist.md cispaces/
echo "[OK]"

echo
packagename="cispaces-linux-$(date '+%Y%m%d-%H%M%S').zip"
echo "Creating archive ${packagename}..."
zip --symlinks -qr ${packagename} cispaces/
if [ $? -eq 0 ]; then echo "[OK]"; else echo "[Failed]"; exit; fi
