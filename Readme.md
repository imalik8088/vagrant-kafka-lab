#Vagrant Kafka Lab


## Prerequistes

- Git
- Vagrant
- Virtual Box
- Ansible


## Installation


```bash
$ git clone https://github.com/ineedcode/vagrant-kafka-lab
$ cd vagrant-kafka-lab
$ vagrant up
```


### Kafka Connect

```bash
./bin/connect-standalone.sh config/connect-standalone.properties config/connect-file-source.properties config/connect-file-sink.properties
```

./bin/kafka-topics.sh --zookeeper localhost:2181 --list
./bin/kafka-topics.sh --zookeeper localhost:2181 --replication-factor 1 --partition 1 --topic connect-test --create