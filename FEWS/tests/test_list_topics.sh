#!/usr/bin/env bash

test_description="List Topics present in database"
test_protocol="http"
test_hostname="localhost"
test_port="8080"
test_endpoint="/fewsservlet/topics"
test_http_method="GET"
expected_return_code="HTTP/1.1 200 OK"
header="Authorization: Bearer dummytoken"

test_url="${test_protocol}://${test_hostname}:${test_port}${test_endpoint}"
echo -n "## Testing : ${test_description} - ${test_url}"
return_code=$(curl -H "${header}" -sS -i -X ${test_http_method} ${test_url} | head -n 1 | tr -d '\r\n')
return_data=$(curl -H "${header}" -sS -i -X ${test_http_method} ${test_url})

if [ "${return_code}" == "${expected_return_code}" ]; then
	echo -e "\t [OK]"
else
	echo -e "\t [FAIL]"
	echo -e "\t Expected: ${expected_return_code} - Received: ${return_code}"
fi

if (( $# > 0 )) && [ "$1" == "-v" ] ; then
    echo "$return_data" | tail -n 1 | python3 -m json.tool
fi
