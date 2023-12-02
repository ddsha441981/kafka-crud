# kafka-crud
1) Start Zookeeper
cmd>.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties

3) Start Kafka setup
cmd>.\bin\windows\kafka-server-start.bat .\config\server.properties

5) Create a Topic
cmd>.\bin\windows\kafka-topics.bat --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic my-topic
