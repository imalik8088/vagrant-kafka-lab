#!/bin/bash


cd /usr/local/kafka_2.11-0.10.2.0; bin/connect-standalone.sh config/connect-standalone.properties config/connect-file-source.properties config/connect-file-sink.properties
