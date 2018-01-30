#!/bin/bash

if [ $# -gt 0 ]; then
    /home/vagrant/kafka/bin/kafka-console-consumer.sh --from-beginning --topic $1 --bootstrap-server kafka-1:9092,kafka-2:9092,kafka-3:9092
else
    echo "Usage: "$(basename $0)" <topic_name>"
fi

