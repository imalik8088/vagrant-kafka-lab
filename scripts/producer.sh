#!/bin/bash

if [ $# -gt 0 ]; then
    /home/vagrant/kafka/bin/kafka-console-producer.sh --topic "$1" --broker-list kafka-1:9092,kafka-2:9092,kafka-3:9092
else
    echo "Usage: "$(basename $0)" <topic_name>"
fi
