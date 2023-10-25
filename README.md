
- [Springboot Kafka Example](https://github.com/spring-projects/spring-kafka/blob/main/samples/README.adoc)
- [Reference Docs](https://github.com/spring-projects/spring-kafka/tree/main/samples)

### Producer
```shell
 kafka-console-producer.sh --bootstrap-server localhost:9092 --topic test.topic
```

### Consumer
```shell
 kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic test.topic --from-beginning --property print.offset=true
```

### admin
```shell
#List all the topics
kafka-topics.sh --bootstrap-server localhost:9092 --list

#Create a topic
kafka-topics.sh --bootstrap-server localhost:9092 --create --topic test.topic --partitions 3 --replication-factor 1

#Describe a topic
kafka-topics.sh --bootstrap-server localhost:9092 --describe --topic test.topic

#Delete a topic
kafka-topics.sh --bootstrap-server localhost:9092 --delete --topic test.topic

#List all the consumer groups
kafka-consumer-groups.sh --bootstrap-server localhost:9092 --list 

#Describe a consumer group
kafka-consumer-groups.sh --bootstrap-server localhost:9092 --describe --group group.three 

#Describe a consumer group with members
kafka-consumer-groups.sh --bootstrap-server localhost:9092 --describe --group group.three --members

#reset offset
kafka-consumer-groups.sh --bootstrap-server localhost:9092 --reset-offsets --group group.two --topic test.topic --to-earliest --execute
```