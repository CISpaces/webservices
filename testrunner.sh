#!/usr/bin/env bash

testfiles=(*/tests/test*.sh)
echo -e "Found ${#testfiles[@]} tests\n"

num_ok=0
num_nok=0
for testfile in "${testfiles[@]}"; do
    echo "$testfile"
    result=$("$testfile")
    if [[ "$result" == *"[OK]"* ]]; then
        echo "OK"
        (( num_ok += 1 ))
    else
        echo "$result"
        (( num_nok += 1 ))
    fi
done

echo -e "\nPassed: $num_ok"
echo -e "Failed: $num_nok"