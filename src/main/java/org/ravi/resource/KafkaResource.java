package org.ravi.resource;

import org.ravi.services.KafkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public class KafkaResource {

    @Autowired
    private KafkaService kafkaService;

    @GetMapping("/message/{message}")
    public String sendMessage(@PathVariable("message") final String message){
        return  kafkaService.sendMessage(message);
    }

    @GetMapping("/object/{id}")
    public String sendObject(@PathVariable("id") final Integer id){
        return  kafkaService.sendObject(id);
    }
}
