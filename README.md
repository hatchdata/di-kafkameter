# DI-KafkaMeter

## Introduction

This plugin is an extended version of Kafkameter with restructured UI and additional features which kafkameter missed

## Required Components

1. DI-Jmeter or Apache Jmeter
2. Kafka Configs (Broker lists, Topic(s), etc)


## Jar Dependencies Required

* Kafka-clients-2.5.0

## Jmeter Target

* Jmeter version 5.2.1 or above
* Java 8 or above

## Installation Instructions

* Download the source code from the Gitlab.
* Just do a mvn clean install (M2 is required)
* Jar will be generated under the target directory (di-kafkameter-1.0.jar).
* Copy the Jar to \<Jmeter Installed Directory\>/lib/ext/ for DI Jmeter \<Jmeter Installed Directory\>/di/plugins


## Producer Elements

Configure Kafka properties by Adding KafkaProducerConfig Element.

* Provide a variable name used to refer to this config's kafka producer client (Necessary to change if more than one kafka producer client is desired)
* Provide the list of kafka brokers (If you have more than one, provide it in comma separated format)
* Additional kafka client configs can be added to the producer by adding entries in AdditionalConfigs table. 
* Refer the list of additional kafka client configs which can be added to Kafka producer from the below Producer config properties section.

Add and Configure KafkaProducer Sampler to the thread group

* Provide a variable name of the kafka producer client to use (Same as one defined in a KafkaProducerConfig element)
* Provide the kafka topic to which the messages needs to be posted
* Kafka Message key - key for the message to publish the message (empty for null keys)
* Kafka Message - Original message which needs to be posted
* Partition String (Optional) - You can taget the posting of messages to particular partition by providing the partition number
* Message Headers (Optional) - You can add headers to the messages which are being posted (It's possible to add more than one headers)

## Producer Config Properties which can be added as part of producer creation.

| Property | Description | Default Values |
| :---     |     :---    |  :---     |
| acks | The number of acknowledgments the producer requires the leader to have received before considering a request complete| 1 |
| batch.size | The producer will attempt to batch records together into fewer requests whenever multiple records are being sent to the same partition | 16384 |
| bootstrap.servers | A list of host/port pairs to use for establishing the initial connection to the Kafka cluster | [localhost:9091] |
| buffer.memory | The total bytes of memory the producer can use to buffer records | 33554432 |
| client.dns.lookup | Controls how the client uses DNS lookups. | default |
| client.id | A unique id string to pass to the server when making requests. | JMeter-Producer-1 |
| compression.type | The compression type for all data generated by the producer ('gzip','snappy','lz4','zstd') | none |
| connections.max.idle.ms | Close idle connections after the number of milliseconds specified by this config. | 540000 |
| delivery.timeout.ms | An upper bound on the time to report success or failure after a call to send() returns. | 120000 |
| enable.idempotence || false |
| interceptor.classes || [] |
| key.serializer || org.apache.kafka.common.serialization.StringSerializer |
| value.serializer | Serializer implementation that accepts String data. | org.apache.kafka.common.serialization.StringSerializer |
| linger.ms || 0 |
| max.block.ms || 60000 |
| max.in.flight.requests.per.connection || 5 |
| max.request.size || 1048576 |
| metadata.max.age.ms || 300000 |
| metadata.max.idle.ms || 300000 |
| metric.reporters || [] |
| metrics.num.samples || 2 |
| metrics.recording.level || INFO |
| metrics.sample.window.ms || 30000 |
| partitioner.class || org.apache.kafka.clients.producer.internals.DefaultPartitioner |
| receive.buffer.bytes || 32768 |
| reconnect.backoff.max.ms || 1000 |
| reconnect.backoff.ms || 50 |
| request.timeout.ms || 30000 |
| retries | Setting a value greater than zero will cause the client to resend any record whose send fails | 2147483647 |
| retry.backoff.ms || 100 |
| sasl.client.callback.handler.class || null |
| sasl.jaas.config || null |
| sasl.kerberos.kinit.cmd || /usr/bin/kinit |
| sasl.kerberos.min.time.before.relogin || 60000 |
| sasl.kerberos.service.name || null |
| sasl.kerberos.ticket.renew.jitter || 0.05 |
| sasl.kerberos.ticket.renew.window.factor || 0.8 |
| sasl.login.callback.handler.class || null |
| sasl.login.class || null |
| sasl.login.refresh.buffer.seconds || 300 |
| sasl.login.refresh.min.period.seconds || 60 |
| sasl.login.refresh.window.factor || 0.8 |
| sasl.login.refresh.window.jitter || 0.05 |
| sasl.mechanism || GSSAPI |
| security.protocol || SSL |
| security.providers || null |
| send.buffer.bytes || 131072 |
| ssl.cipher.suites || null |
| ssl.enabled.protocols || [TLSv1.2] |
| ssl.endpoint.identification.algorithm || https |
| ssl.key.password || null |
| ssl.keymanager.algorithm || SunX509 |
| ssl.keystore.location ||  |
| ssl.keystore.password || [hidden] |
| ssl.keystore.type || JKS |
| ssl.protocol || TLSv1.2 |
| ssl.provider || null |
| ssl.secure.random.implementation || null |
| ssl.trustmanager.algorithm || PKIX |
| ssl.truststore.location ||  |
| ssl.truststore.password || [hidden] |
| ssl.truststore.type || JKS |
| transaction.timeout.ms || 60000 |
| transactional.id || null |



## Consumer Elements

Under Development 

## References

 * Plugin Overview: https://github.com/BrightTag/kafkameter  
 * How to add headers to message: https://stackoverflow.com/questions/29025627/adding-custom-headers-in-kafka-message
 * TableEditor : https://www.programcreek.com/java-api-examples/?api=org.apache.jmeter.testbeans.gui.TableEditor
 * Validation : Kafka tool (http://www.kafkatool.com/)
 * Producer Config property : https://kafka.apache.org/documentation/#producerconfigs


## 💲 Donate
<a href="https://www.buymeacoffee.com/rollno748" target="_blank"><img src="https://cdn.buymeacoffee.com/buttons/v2/default-green.png" alt="Buy Me A Coffee" style="max-width:20%;" ></a> 

Please rate a :star2: if you like it.

Please open up a :beetle: - If you experienced something.
 
