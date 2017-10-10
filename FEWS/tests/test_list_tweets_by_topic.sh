#!/usr/bin/env bash

test_description="List Tweets by Topic"
test_protocol="http"
test_hostname="localhost"
test_port="8080"
test_endpoint="/fewsservlet/tweets"
test_http_method="POST"
test_json_payload='[{"name": "blocked", "negated": -1, "genuine": -1},{"name":"mentioned_media", "negated": -1, "genuine": -1}]'
expected_return_code="HTTP/1.1 200 OK"
header="Authorization: Bearer dummytoken"

test_url="${test_protocol}://${test_hostname}:${test_port}${test_endpoint}"
echo -n "## Testing : ${test_description} - ${test_url}"
return_code=$(curl -H "${header}" -sS -i -X ${test_http_method} -H "Content-Type: application/json" -d "${test_json_payload}" ${test_url} | head -n 1 | tr -d '\r\n')
return_data=$(curl -sS -i -X ${test_http_method} -H "Content-Type: application/json" -d "${test_json_payload}" ${test_url})

if [ "${return_code}" == "${expected_return_code}" ]; then
	echo -e "\t [OK]"
else
	echo -e "\t [FAIL]"
	echo -e "\t Expected: ${expected_return_code} - Received: ${return_code}"
fi

if (( $# > 0 )) && [ "$1" == "-v" ] ; then
    echo "$return_data" | tail -n 1 | python3 -m json.tool
fi
