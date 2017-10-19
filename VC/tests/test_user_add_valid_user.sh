#!/bin/bash
test_description="Add a new user - valid"
test_protocol="http"
test_hostname="localhost"
test_port="8080"

# Login
test_endpoint="/VC/rest/login"
test_http_method="POST"
test_json_payload='{"username":"Ella","password":"password"}'
expected_return_code="HTTP/1.1 200 OK"

test_url="${test_protocol}://${test_hostname}:${test_port}${test_endpoint}"
return_data=$(curl -sS -i -X ${test_http_method} -H "Content-Type: application/json" -d "${test_json_payload}" ${test_url})
return_code=$(echo "${return_data}" | head -n 1 | tr -d '\r\n')
auth_token=$(echo "${return_data}" | grep 'Authorization' | cut -d' ' -f3)

# Test
test_endpoint="/VC/rest/user/add"
test_http_method="POST"
test_json_payload='{"username":"Test user","password":"password","affiliation":"None"}'
expected_return_code="HTTP/1.1 201 Created"
header="Authorization: Bearer ${auth_token}"

test_url="${test_protocol}://${test_hostname}:${test_port}${test_endpoint}"
echo -n "## Testing : ${test_description} - ${test_url}"
return_data=$(curl -H "${header}" -sS -i -X ${test_http_method} -H "Content-Type: application/json" -d "${test_json_payload}" ${test_url})
return_code=$(echo "${return_data}" | head -n 1 | tr -d '\r\n')

if [ "${return_code}" == "${expected_return_code}" ]; then
	echo -e "\t [OK]"
else
	echo -e "\t [FAIL]"
	echo -e "\t Expected: ${expected_return_code} - Received: ${return_code}"
fi

if (( $# > 0 )) && [ "$1" == "-v" ] ; then
    echo "$return_data" | tail -n 1
fi
