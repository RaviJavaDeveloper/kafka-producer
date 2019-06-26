package org.ravi.config;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConfig {

    @Bean
    public Map<String, Object> getProducerObjConf(){
        Map<String, Object> map = new HashMap<>();
        map.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        map.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        map.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        return map;
    }

    @Bean
    public KafkaTemplate<String, Object> createKafkaTemplate1(){
        ProducerFactory<String, Object> factory = new DefaultKafkaProducerFactory<>(getProducerObjConf());
        KafkaTemplate<String, Object> t = new KafkaTemplate<>(factory);
        System.out.println("Custom kafka template is created");
        return t;
    }

    @Bean
    public Map<String, Object> getProducerStringConf(){
        Map<String, Object> map = new HashMap<>();
        map.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        map.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        map.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        return map;
    }

    @Bean
    public KafkaTemplate<String, String> createKafkaTemplate2(){
        ProducerFactory<String, String> factory = new DefaultKafkaProducerFactory<>(getProducerStringConf());
        KafkaTemplate<String, String> t = new KafkaTemplate<>(factory);
        System.out.println("Custom kafka template is created");
        return t;
    }
}
