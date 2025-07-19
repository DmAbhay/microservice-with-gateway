package org.ms4.test.controller;

import com.fasterxml.jackson.databind.JsonNode;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TestController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/hit-ms4")
    public ResponseEntity<?> test(@RequestParam("name") String name){


        JSONObject obj = new JSONObject();
        obj.put("name", "Abhay");
        obj.put("age", 30);
        obj.put("city", "Lucknow");

        System.out.println("JSON Output: " + obj.toString());
        System.out.println("RequestParam is : "+name);

        System.out.println("Response from instance running on port: " + port);

        return ResponseEntity.ok("ms4 test controller hit\nResponse from instance running on port: " + port);
    }

    @PostMapping("/hit-ms4-post")
    public ResponseEntity<?> testPost(@RequestBody JsonNode payload){

        System.out.println(payload.toPrettyString());

        System.out.println("Response from instance running on port: " + port);

        //return ResponseEntity.ok("ms4 test controller hit\nResponse from instance running on port: " + port+"\n"+payload);
        return ResponseEntity.ok(payload);
    }


}
