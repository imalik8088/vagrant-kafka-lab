#!/usr/bin/env bash

if [ $# -gt 0 ]; then
    /home/vagrant/kafka/bin/kafka-topics.sh --delete --zookeeper kafka-1:2181 --topic $1
else
    echo "Usage: "$(basename $0)" <topic_name>"
fi
