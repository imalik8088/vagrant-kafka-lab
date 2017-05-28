#!/bin/bash

if [ $# -gt 0 ]; then
   /usr/local/kafka_2.11-0.10.2.0/bin/kafka-run-class.sh kafka.tools.GetOffsetShell --broker-list kafka-1:9092,kafka-2:9092,kafka-3:9092 --topic $1 --time -1
else
    echo "Usage: "$(basename $0)" <topic_name>"
fi
