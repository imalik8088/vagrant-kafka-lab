# Vagrant Kafka Lab
------

**Prerequistes:** Vagrant (1.9.4), Virtual Box (5.0.20) and Ansible (2.2.1.0)

## Web UIs

- Grafana: [http://kafka-1:3000](http://kafka-1:3000)
- Kafka-Manager: [http://kafka-1:9000](http://kafka-1:9000)
- Prometheus-UI: [http://kafka-1:9090](http://kafka-1:9090)


## Installation

```bash
git clone https://github.com/ineedcode/vagrant-kafka-lab
cd vagrant-kafka-lab
vagrant up
```

##### Grafana Konfiguration
access to Grafana and use the default credentials with `admin:admin`. Add Dashboard with Prometheus as source, the source is available at localhost:9000.

Upload the Kafka Dashboard which is included in the doc folder: [Grafana-Kafka-Dashboard](doc/Grafana-Kafka-Dashboard-v1.json)

## Components
In the following you'll find list of components that has been used and with some general settings.

| IP           | Hostname | Description                                 | Settings |
|--------------|----------|---------------------------------------------|----------|
| 192.168.10.2 | kafka-1  | ZK, Kafka Broker, Kafka-Manager, Prometheus | 2GB RAM  |
| 192.168.10.3 | kafka-2  | ZK, Kafka Broker                            | 1GB RAM  |
| 192.168.10.4 | kafka-3  | ZK, Kafka Broker                            | 1GB RAM  |


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

