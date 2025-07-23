package org.scheduler.test.service;

import org.scheduler.test.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;


@Component
public class BirthdayScheduler {

    @Autowired
    private CronExpressionProvider cronExpressionProvider;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Scheduled(cron = "#{@cronExpressionProvider.getCronExpression()}")
    public void sendBirthdayWishes() {
        List<Map<String, Object>> todaysBirthdays = employeeRepository.getEmployeesWithTodayBirthday();
        String birthdayMessageTemplate = employeeRepository.getBirthDayTemplate();

        for (Map<String, Object> employee : todaysBirthdays) {
            String name = (String) employee.get("name");
            String message = birthdayMessageTemplate.replace("{name}", name);
            System.out.println("🎉 Sending Birthday Wish to " + name + ": " + message);
        }
        System.out.println("✅ Birthday wishes sent at: " + LocalDateTime.now());
    }
}
