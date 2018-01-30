# Vagrant Kafka Lab
------

**Prerequistes:** Vagrant (2.0.1), Virtual Box (5.2.0) and Ansible (2.4.1.0)

## Web UIs

- Grafana: [http://kafka-1:3000](http://kafka-1:3000)
- Prometheus-UI: [http://kafka-1:9090](http://kafka-1:9090)

## Installation

```bash
git clone https://github.com/ineedcode/vagrant-kafka-lab
cd vagrant-kafka-lab
vagrant plugin install vagrant-hostmanager
vagrant up
```

##### Grafana Konfiguration
access to Grafana and use the default credentials with `admin:admin`. Add Dashboard with Prometheus as source, the source is available at `localhost:9000.

Upload the Kafka Dashboard which is included in the doc folder: [Grafana-Kafka-Dashboard](doc/Grafana-Kafka-Dashboard-v1.json)

## Components
In the following you'll find list of components that has been used and with some general settings.

| IP           | Hostname | Description                         | Settings |
|--------------|----------|-------------------------------------|----------|
| 192.168.10.2 | kafka-1  | ZK, Kafka Broker, Prometheus        | 2GB RAM  |
| 192.168.10.3 | kafka-2  | ZK, Kafka Broker                    | 1GB RAM  |
| 192.168.10.4 | kafka-3  | ZK, Kafka Broker                    | 1GB RAM  |


# Ansible

```bash
ansible all -i ansible/inventories/vbox/hosts -m ping -o
ansible-playbook ansible/cluster.yml --tags "new-kafka-config"
```

## Usage

##### Use pre build commands to interact with Kafka
The `script` folder has been added to the PATH therefore you can use the shell scripts from your cli of the virtual machines.

```bash
vagrant ssh kafka-1
list-topics.sh #lists all topics

```



### Versions

Following versions are used in this lab

- Kafka is using 0.11.0.2 ([change it here](ansible/roles/kafka/defaults/main.yml)) 
- Zookeeper is using 3.4.10 ([change it here](ansible/roles/zookeeper/defaults/main.yml)) 
- Promeutheus is using 1.7.1 ([change it here](ansible/roles/promeutheus/defaults/main.yml)) 
- Grafana is using 4.3.2 ([change it here](ansible/roles/promeutheus/defaults/main.yml)) 