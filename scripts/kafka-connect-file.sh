#!/bin/bash


cd /home/vagrant/kafka/ &&
/vagrant/scripts/create-topic.sh connect-test &&
echo `date -u +"%Y-%m-%dT%H:%M:%S-%N"` >> test.txt &&
nohup bin/connect-standalone.sh config/connect-standalone.properties config/connect-file-source.properties config/connect-file-sink.properties > conncect_standalone.log
