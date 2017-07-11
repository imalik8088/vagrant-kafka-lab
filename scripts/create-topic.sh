#!/bin/bash

if [ $# -gt 0 ]; then
    /usr/local/kafka_2.11-0.10.2.0/bin/kafka-topics.sh --zookeeper kafka-1:2181 --replication-factor 3 --partition 3 --topic $1 --create
else
    echo "Usage: "$(basename $0)" <topic_name>"
fi

