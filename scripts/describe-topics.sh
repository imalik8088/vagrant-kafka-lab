#!/bin/bash

/usr/local/kafka_2.11-0.10.2.0/bin/kafka-topics.sh --describe --zookeeper kafka-1:2181,kafka-2:2181,kafka-3:2181
