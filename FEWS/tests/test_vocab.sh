#!/usr/bin/env bash

test_description="all Vocab endpoints"
test_protocol="http"
test_hostname="localhost"
test_port="8080"
expected_return_code="HTTP/1.1 200 OK"

test_endpoint="/VC/rest/login"
test_http_method="POST"
test_json_payload='{"username":"Ella","password":"password"}'

test_url="${test_protocol}://${test_hostname}:${test_port}${test_endpoint}"
return_data=$(curl -sS -i -X ${test_http_method} -H "Content-Type: application/json" -d "${test_json_payload}" ${test_url})
return_code=$(echo "${return_data}" | head -n 1 | tr -d '\r\n')
auth_token=$(echo "${return_data}" | grep 'Authorization' | cut -d' ' -f3)

# Setup - delete if exists
test_endpoint="/fewsservlet/vocab/testing"
test_http_method="DELETE"
header="Authorization: Bearer ${auth_token}"

test_url="${test_protocol}://${test_hostname}:${test_port}${test_endpoint}"
return_data=$(curl -H "${header}" -sS -i -X ${test_http_method} ${test_url})


# Start testing
echo "## Testing : ${test_description}"

# Test - get a non-existing topic
test_description="non-existing vocab"
expected_return_code="HTTP/1.1 404 Not Found"
test_endpoint="/fewsservlet/vocab/testing"
test_http_method="GET"

test_url="${test_protocol}://${test_hostname}:${test_port}${test_endpoint}"
return_data=$(curl -H "${header}" -sS -i -X ${test_http_method} ${test_url})
return_code=$(echo "${return_data}" | head -n 1 | tr -d '\r\n')

if [ "${return_code}" == "${expected_return_code}" ]; then
	echo -e "\t [OK]"
else
    echo -n "${test_endpoint} : ${test_http_method} ${test_description} "
	echo -e "\t [FAIL]"
	echo -e "\t Expected: ${expected_return_code} - Received: ${return_code}"
fi

# Test - create a vocabKeyword on a non-existing topic
test_description="new keyword on non-existing vocabTopic"
expected_return_code="HTTP/1.1 404 Not Found"
test_endpoint="/fewsservlet/vocab/testing/keywords/testkeyword"
test_http_method="POST"

test_url="${test_protocol}://${test_hostname}:${test_port}${test_endpoint}"
return_data=$(curl -H "${header}" -sS -i -X ${test_http_method} ${test_url})
return_code=$(echo "${return_data}" | head -n 1 | tr -d '\r\n')

if [ "${return_code}" == "${expected_return_code}" ]; then
	echo -e "\t [OK]"
else
    echo -n "${test_endpoint} : ${test_http_method} ${test_description} "
	echo -e "\t [FAIL]"
	echo -e "\t Expected: ${expected_return_code} - Received: ${return_code}"
fi

# Test - create new vocabTopic
test_description="new vocabTopic"
expected_return_code="HTTP/1.1 201 Created"
test_endpoint="/fewsservlet/vocab/testing/schema/test"
test_http_method="POST"

test_url="${test_protocol}://${test_hostname}:${test_port}${test_endpoint}"
return_data=$(curl -H "${header}" -sS -i -X ${test_http_method} ${test_url})
return_code=$(echo "${return_data}" | head -n 1 | tr -d '\r\n')

if [ "${return_code}" == "${expected_return_code}" ]; then
	echo -e "\t [OK]"
else
    echo -n "${test_endpoint} : ${test_http_method} ${test_description} "
	echo -e "\t [FAIL]"
	echo -e "\t Expected: ${expected_return_code} - Received: ${return_code}"
fi

# Test - create new vocabTopic that already exists
test_description="new vocabTopic that already exists"
expected_return_code="HTTP/1.1 409 Conflict"
test_endpoint="/fewsservlet/vocab/testing/schema/test"
test_http_method="POST"

test_url="${test_protocol}://${test_hostname}:${test_port}${test_endpoint}"
return_data=$(curl -H "${header}" -sS -i -X ${test_http_method} ${test_url})
return_code=$(echo "${return_data}" | head -n 1 | tr -d '\r\n')

if [ "${return_code}" == "${expected_return_code}" ]; then
	echo -e "\t [OK]"
else
    echo -n "${test_endpoint} : ${test_http_method} ${test_description} "
	echo -e "\t [FAIL]"
	echo -e "\t Expected: ${expected_return_code} - Received: ${return_code}"
fi

# Test - create a vocabKeyword on an existing topic
test_description="new keyword on existing vocabTopic"
expected_return_code="HTTP/1.1 201 Created"
test_endpoint="/fewsservlet/vocab/testing/keywords/testkeyword"
test_http_method="POST"

test_url="${test_protocol}://${test_hostname}:${test_port}${test_endpoint}"
return_data=$(curl -H "${header}" -sS -i -X ${test_http_method} ${test_url})
return_code=$(echo "${return_data}" | head -n 1 | tr -d '\r\n')

if [ "${return_code}" == "${expected_return_code}" ]; then
	echo -e "\t [OK]"
else
    echo -n "${test_endpoint} : ${test_http_method} ${test_description} "
	echo -e "\t [FAIL]"
	echo -e "\t Expected: ${expected_return_code} - Received: ${return_code}"
fi

# Test - create a vocabKeyword that already exists on an existing topic
test_description="new keyword that already exists"
expected_return_code="HTTP/1.1 409 Conflict"
test_endpoint="/fewsservlet/vocab/testing/keywords/testkeyword"
test_http_method="POST"

test_url="${test_protocol}://${test_hostname}:${test_port}${test_endpoint}"
return_data=$(curl -H "${header}" -sS -i -X ${test_http_method} ${test_url})
return_code=$(echo "${return_data}" | head -n 1 | tr -d '\r\n')

if [ "${return_code}" == "${expected_return_code}" ]; then
	echo -e "\t [OK]"
else
    echo -n "${test_endpoint} : ${test_http_method} ${test_description} "
	echo -e "\t [FAIL]"
	echo -e "\t Expected: ${expected_return_code} - Received: ${return_code}"
fi

# Test - get an existing topic
test_description="existing topic"
expected_return_code="HTTP/1.1 200 OK"
test_endpoint="/fewsservlet/vocab/testing"
test_http_method="GET"

test_url="${test_protocol}://${test_hostname}:${test_port}${test_endpoint}"
return_data=$(curl -H "${header}" -sS -i -X ${test_http_method} ${test_url})
return_code=$(echo "${return_data}" | head -n 1 | tr -d '\r\n')

if [ "${return_code}" == "${expected_return_code}" ]; then
	echo -e "\t [OK]"
else
    echo -n "${test_endpoint} : ${test_http_method} ${test_description} "
	echo -e "\t [FAIL]"
	echo -e "\t Expected: ${expected_return_code} - Received: ${return_code}"
fi

# Test - get all existing topics
test_description="all existing topics"
expected_return_code="HTTP/1.1 200 OK"
test_endpoint="/fewsservlet/vocab"
test_http_method="GET"

test_url="${test_protocol}://${test_hostname}:${test_port}${test_endpoint}"
return_data=$(curl -H "${header}" -sS -i -X ${test_http_method} ${test_url})
return_code=$(echo "${return_data}" | head -n 1 | tr -d '\r\n')

if [ "${return_code}" == "${expected_return_code}" ]; then
	echo -e "\t [OK]"
else
    echo -n "${test_endpoint} : ${test_http_method} ${test_description} "
	echo -e "\t [FAIL]"
	echo -e "\t Expected: ${expected_return_code} - Received: ${return_code}"
fi

# Test - delete an existing vocabKeyword on an existing topic
test_description="existing keyword"
expected_return_code="HTTP/1.1 204 No Content"
test_endpoint="/fewsservlet/vocab/testing/keywords/testkeyword"
test_http_method="DELETE"

test_url="${test_protocol}://${test_hostname}:${test_port}${test_endpoint}"
return_data=$(curl -H "${header}" -sS -i -X ${test_http_method} ${test_url})
return_code=$(echo "${return_data}" | head -n 1 | tr -d '\r\n')

if [ "${return_code}" == "${expected_return_code}" ]; then
	echo -e "\t [OK]"
else
    echo -n "${test_endpoint} : ${test_http_method} ${test_description} "
	echo -e "\t [FAIL]"
	echo -e "\t Expected: ${expected_return_code} - Received: ${return_code}"
fi

# Test - delete a non-existing vocabKeyword on an existing topic - you can delete things that don't exist
test_description="non-existing keyword"
expected_return_code="HTTP/1.1 204 No Content"
test_endpoint="/fewsservlet/vocab/testing/keywords/testkeyword"
test_http_method="DELETE"

test_url="${test_protocol}://${test_hostname}:${test_port}${test_endpoint}"
return_data=$(curl -H "${header}" -sS -i -X ${test_http_method} ${test_url})
return_code=$(echo "${return_data}" | head -n 1 | tr -d '\r\n')

if [ "${return_code}" == "${expected_return_code}" ]; then
	echo -e "\t [OK]"
else
    echo -n "${test_endpoint} : ${test_http_method} ${test_description} "
	echo -e "\t [FAIL]"
	echo -e "\t Expected: ${expected_return_code} - Received: ${return_code}"
fi

# Test - delete an existing vocabTopic
test_description="existing vocabTopic"
expected_return_code="HTTP/1.1 204 No Content"
test_endpoint="/fewsservlet/vocab/testing"
test_http_method="DELETE"

test_url="${test_protocol}://${test_hostname}:${test_port}${test_endpoint}"
return_data=$(curl -H "${header}" -sS -i -X ${test_http_method} ${test_url})
return_code=$(echo "${return_data}" | head -n 1 | tr -d '\r\n')

if [ "${return_code}" == "${expected_return_code}" ]; then
	echo -e "\t [OK]"
else
    echo -n "${test_endpoint} : ${test_http_method} ${test_description} "
	echo -e "\t [FAIL]"
	echo -e "\t Expected: ${expected_return_code} - Received: ${return_code}"
fi

# Test - delete a non-existing vocabTopic
test_description="non-existing vocabTopic"
expected_return_code="HTTP/1.1 204 No Content"
test_endpoint="/fewsservlet/vocab/testing"
test_http_method="DELETE"

test_url="${test_protocol}://${test_hostname}:${test_port}${test_endpoint}"
return_data=$(curl -H "${header}" -sS -i -X ${test_http_method} ${test_url})
return_code=$(echo "${return_data}" | head -n 1 | tr -d '\r\n')

if [ "${return_code}" == "${expected_return_code}" ]; then
	echo -e "\t [OK]"
else
    echo -n "${test_endpoint} : ${test_http_method} ${test_description} "
	echo -e "\t [FAIL]"
	echo -e "\t Expected: ${expected_return_code} - Received: ${return_code}"
fi
