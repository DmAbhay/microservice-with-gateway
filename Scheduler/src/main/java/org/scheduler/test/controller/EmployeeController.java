package org.scheduler.test.controller;

import org.scheduler.test.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/test-scheduler")
    public ResponseEntity<?> test(){
        System.out.println(employeeRepository.getEmployeesWithTodayBirthday());
        System.out.println(employeeRepository.getBirthDayTemplate());
        System.out.println(employeeRepository.getCronTimeFromDatabase());
        return ResponseEntity.ok("Jai shree krishna");
    }
}
