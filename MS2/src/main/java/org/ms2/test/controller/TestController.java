package org.ms2.test.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/hit-ms2")
    public ResponseEntity<?> test(){

        return ResponseEntity.ok("ms2 test controller hit");
    }
}
