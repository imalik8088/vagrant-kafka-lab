#Vagrant Kafka Lab

**Prerequistes:** Vagrant, Virtual Box and Ansible

### Web UIs

- Grafana: [http://192.168.10.2:3000](http://192.168.10.2:3000)
- Kafka-Manager: [http://192.168.10.2:9000](http://192.168.10.2:9000)
- Prometheus-UI: [http://192.168.10.2:9090](http://192.168.10.2:9090)


### Installation

```bash
$ git clone https://github.com/ineedcode/vagrant-kafka-lab
$ cd vagrant-kafka-lab
$ vagrant up
```

##### Grafana Konfiguration
access to Grafana and use the default credentials with `admin:admin`. Add Dashboard with Prometheus as source, the source is available at localhost:9000.

## Usage

##### Use pre build commands to interact with Kafka

```bash
vagrant ssh kafka-1
list-topics.sh #lists all topics

```

##### Deploy new Kafka Broker configs

```bash
ansible-playbook ansible/cluster.yml --tags "new-kafka-config"
```

##### Kafka Connect

```bash
./bin/connect-standalone.sh config/connect-standalone.properties config/connect-file-source.properties config/connect-file-sink.properties
```
