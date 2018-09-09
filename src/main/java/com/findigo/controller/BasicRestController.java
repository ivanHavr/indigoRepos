package com.findigo.controller;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/messages")
public class BasicRestController {

    private Integer counter = 3;

    private List<Map<String,String>> messages = new ArrayList<Map<String, String>>(){{
        add(new HashMap<String, String>(){{put("id","1"); put("text","first message");}});
        add(new HashMap<String, String>(){{put("id","2"); put("text","second message");}});
    }};

    @GetMapping
    private List<Map<String,String>> getAllTest(){
        return messages;
    }

    @GetMapping("{id}")
    private Map<String,String> getMessageTest(@PathVariable String id){
        return getMessage(id);
    }

    @PostMapping
    private Map<String,String> createTest(@RequestBody Map<String,String> message){
        message.put("id", String.valueOf(counter++));

        messages.add(message);

        return message;
    }

    @PutMapping("{id}")
    private Map<String,String> updateTest(@PathVariable String id, @RequestBody Map<String,String> message){
        Map<String,String> messagess  =  getMessage(id);
        messagess.putAll(message);
        messagess.put("id",id);

        return messagess;
    }

    @DeleteMapping("{id}")
    private void deleteTest(@PathVariable String id){
        Map<String,String> message  =  getMessage(id);

        messages.remove(message);
    }

    private Map<String,String> getMessage(@PathVariable String id){
        return messages.stream()
                .filter(x -> x.get("id").equals(id))
                .findFirst()
                .get();
    }
}
