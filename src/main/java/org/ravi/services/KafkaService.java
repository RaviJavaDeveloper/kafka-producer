package org.ravi.services;

import org.ravi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {

    @Autowired
    private KafkaTemplate<String, String> kafkaString;

    @Autowired
    private KafkaTemplate<String, Object> kafkaObject;

    public String sendObject(Integer message){
        User user = new User(message, "Ravi_"+message, "Hyderabad");
        kafkaObject.send("topic1", user);
        return "Object sent successfully";
    }

    public String sendMessage(String message){
        kafkaString.send("topic1", message);
        return "Message sent successfully";
    }

}


