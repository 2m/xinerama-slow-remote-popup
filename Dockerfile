FROM ubuntu:13.10 
MAINTAINER Martynas Mickevicius <martynas@igeolise.com>

RUN apt-get update
RUN apt-get install -y libxrender1 libxtst-dev wget openssh-server augeas-tools

WORKDIR /opt

RUN wget -nv http://download.oracle.com/otn-pub/java/jdk/7u51-b13/jdk-7u51-linux-x64.tar.gz --no-cookies --header "Cookie: gpw_e24=http%3A%2F%2Fwww.oracle.com" --no-check-certificate
RUN tar xzf jdk-7u51-linux-x64.tar.gz

RUN mkdir -p /var/run/sshd

RUN addgroup --gid 1000 martynas
RUN useradd --uid 1000 --gid 1000 --shell /bin/bash --password qqq martynas

ADD files/home/martynas/.ssh/id_rsa /home/martynas/.ssh/id_rsa
ADD files/home/martynas/.ssh/id_rsa.pub /home/martynas/.ssh/id_rsa.pub
ADD files/home/martynas/.ssh/authorized_keys /home/martynas/.ssh/authorized_keys
ADD files/home/martynas/SimpleExample.java /home/martynas/SimpleExample.java
RUN chown -R martynas:martynas /home/martynas

RUN augtool set /files/etc/ssh/sshd_config/UsePAM no
