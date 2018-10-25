#kafka-从docker部署开始1小时入门
##一、入门须知
- 1.docker
 
- 2.什么是MQ
 
- 3.zookeeper的入门
 
+ 4.lombok
##二、kafka服务器搭建指南
- 1.kafka简单介绍

>Kafka 是 LinkedIn  开源的一种高吞吐量的分布式发布订阅消息系统，kafka的诞生就是为了处理海量日志数据，所以kafka处理消息的效率非常高，即使是非常普通的硬件也可以支持每秒数百万的消息。
kafka 天然支持集群负载均衡，使用 zookeeper 进行分布式协调管理。不支持事务，有一定概率丢失消息。
kafka 的特点，决定了使用场景：日志中间件。
- 2.kafka-docker的搭建

 + 1.下载docker镜像  
>zookeeker: docker pull zookeeper:latest 
kafka: docker pull wurstmeister/kafka:latest
+ 2.先启动zookeeper:  
>docker run -d --name zookeeper --publish 2181:2181 \
--volume /etc/localtime:/etc/localtime \
zookeeper:latest
+ 3.启动kafka  
>docker run -d --name kafka --publish 9092:9092 \
 --link zookeeper \
 --env KAFKA_ZOOKEEPER_CONNECT=zookeeper所在宿主机的IP:2181 \
 --env KAFKA_ADVERTISED_HOST_NAME=kafka所在宿主机的IP \
 --env KAFKA_ADVERTISED_PORT=9092 \
 --volume /etc/localtime:/etc/localtime \
 wurstmeister/kafka:latest



