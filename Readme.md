#Vagrant Kafka Lab

**Prerequistes:** Vagrant, Virtual Box (Ansible)

### Installation

```bash
$ git clone https://github.com/ineedcode/vagrant-kafka-lab
$ cd vagrant-kafka-lab
$ vagrant up
```

### Commands

1) use scripts in kafka cluster

```bash
vagrant ssh kafka-1
list-topics.sh #lists all topics

```

2) Deploy new kafka configs

```bash
ansible-playbook ansible/cluster.yml --tags "new-kafka-config"
```

### Kafka Connect

```bash
./bin/connect-standalone.sh config/connect-standalone.properties config/connect-file-source.properties config/connect-file-sink.properties
```

./bin/kafka-topics.sh --zookeeper localhost:2181 --list
./bin/kafka-topics.sh --zookeeper localhost:2181 --replication-factor 1 --partition 1 --topic connect-test --create