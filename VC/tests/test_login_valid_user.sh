#!/bin/bash
test_description="Valid user login"
test_protocol="http"
test_hostname="localhost"
test_port="8080"
test_endpoint="/VC/rest/login"
test_http_method="POST"
test_json_payload='{"username":"Test user","password":"password"}'
expected_return_code="HTTP/1.1 200 OK"

test_url="${test_protocol}://${test_hostname}:${test_port}${test_endpoint}"
echo -n "## Testing : ${test_description} - ${test_url}"
return_code=$(curl -sS -i -X ${test_http_method} -H "Content-Type: application/json" -d "${test_json_payload}" ${test_url} | head -n 1 | tr -d '\r\n')
if [ "${return_code}" == "${expected_return_code}" ]; then
	echo -e "\t [OK]"
else
	echo -e "\t [FAIL]"
	echo -e "\t Expected: ${expected_return_code} - Received: ${return_code}"
fi
