ENV["LC_ALL"] = "en_US.UTF-8"

KAFKA = 3


Vagrant.configure("2") do |config|


  config.vm.box = "puppetlabs/centos-7.0-64-puppet"
  config.ssh.forward_agent = true # So that boxes don't have to setup key-less ssh
  config.ssh.insert_key = false # To generate a new ssh key and don't use the default Vagrant one

  config.vm.synced_folder "download", "/vagrant/download", create: true
  config.vm.provision :shell, :inline => "echo \"vagrant\"|passwd --stdin vagrant"
  config.vm.provision :shell, :inline => "echo \"vagrant\"|passwd --stdin root"

  (1..KAFKA).each do |i|
    config.vm.define "kafka-#{i}" do |kafka|
      kafka.vm.hostname = "kafka-#{i}"
      kafka.vm.network "forwarded_port", guest: 9000, host: 9000 if i == 1
      kafka.vm.provider "virtualbox" do |vb|
        if i == 1
          vb.memory = "2048"
          vb.cpus = "2"
        else
          vb.memory = "1024"
          vb.cpus = "1"
        end
      end
      kafka.vm.network :private_network, ip: "192.168.10.#{1 + i}", auto_config: true

      if i == KAFKA
        kafka.vm.provision :ansible do |ansible|
          ansible.limit = "zookeeper,kafka,kafka-manager-download,kafka-connect"
          ansible.playbook = "ansible/cluster.yml"
          ansible.inventory_path = "ansible/inventories/vbox"
        end
      end

    end
  end

end