#!/bin/bash
# Initalize a compute engine machine based on Ubuntu 14.04 LTS

###########
# Vertx installation
############
# install dependencies
add-apt-repository ppa:openjdk-r/ppa -y
apt-get update
apt-get install -y git openjdk-8-jdk authbind

# create an user for the bidder
useradd -d /home/bidder -m bidder

# give access to bidder to the port 80
touch /etc/authbind/byport/80
chown bidder:bidder /etc/authbind/byport/80
chmod 700 /etc/authbind/byport/80

# clone project
cd /home/bidder
git clone https://poiuytrez2:BG6000esp.C.@bitbucket.org/databerries/bidder.git

# creates the fat jar
cd bidder
./gradlew shadowJar

# copy the init script
cp conf/etc/init/bidder.conf /etc/init/
start bidder

###############
# Redis
##############
cd
apt-get install -y gcc make
wget http://download.redis.io/releases/redis-3.0.2.tar.gz
tar -xvzf redis-3.0.2.tar.gz
cd redis-3.0.2
make
make install
mkdir /etc/redis
mkdir /var/redis
cp /home/bidder/bidder/conf/etc/redis/redis.conf /etc/redis/redis.conf 
cp /home/bidder/bidder/conf/etc/init.d/redis /etc/init.d/redis
update-rc.d redis defaults 
/etc/init.d/redis start

