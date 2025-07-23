package org.scheduler.test.service;

import org.scheduler.test.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Component
public class CronExpressionProvider {

    @Autowired
    private EmployeeRepository employeeRepository;

//    public String getCronExpression() {
//        String timeFromDB = employeeRepository.getCronTimeFromDatabase().replace(".", ":");
//        LocalTime localTime = LocalTime.parse(timeFromDB);
//        return String.format("0 %d %d * * ?", localTime.getMinute(), localTime.getHour());
//    }

    public String getCronExpression() {
        return employeeRepository.getCronCronExpressionFromDatabase();
    }
}
