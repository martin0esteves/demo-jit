#!/bin/bash

# Function to send a curl request and handle errors
send_request() {
    curl localhost:8080/warmup
}
export -f send_request

# Use parallel to execute the function 1000 times with 10 jobs
parallel -j 10 send_request ::: {1..1000}

