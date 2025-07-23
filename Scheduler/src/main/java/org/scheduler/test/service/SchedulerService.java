package org.scheduler.test.service;

import org.scheduler.test.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;

@Component
public class SchedulerService {


    @Autowired
    private EmployeeRepository employeeRepository;


    // Run every 5 seconds
//    @Scheduled(fixedRate = 60000)
//    public void performTask() {
//        System.out.println("Task executed at: " + java.time.LocalDateTime.now());
//    }
//
//
//    // ✅ Every 5 seconds
//    @Scheduled(cron = "*/5 * * * * *")
//    public void everyFiveSeconds() {
//        System.out.println("Every 5 Seconds :: " + java.time.LocalDateTime.now());
//    }
//
//    // ✅ Every 1 minute at 0th second
//    @Scheduled(cron = "0 * * * * *")
//    public void everyMinute() {
//        System.out.println("Every Minute :: " + java.time.LocalDateTime.now());
//    }
//
//    // ✅ Daily at 8 AM
//    @Scheduled(cron = "0 0 8 * * *")
//    public void dailyAt8AM() {
//        System.out.println("Daily at 8 AM :: " + java.time.LocalDateTime.now());
//    }
//
//    // ✅ Every Monday at 10 AM
//    @Scheduled(cron = "0 0 10 * * MON")
//    public void everyMondayAt10AM() {
//        System.out.println("Monday 10 AM Task :: " + java.time.LocalDateTime.now());
//    }
//
//    // ✅ First day of month at 9 AM
//    @Scheduled(cron = "0 0 9 1 * *")
//    public void firstDayOfMonth() {
//        System.out.println("First day of month at 9 AM :: " + java.time.LocalDateTime.now());
//
//    }
//
//
//    @Scheduled(cron = "0 * * * * *") // Every minute
//    public void sendBirthdayWishe() {
//        List<Map<String, Object>> todaysBirthdays = employeeRepository.getEmployeesWithTodayBirthday();
//        String birthdayMessageTemplate = employeeRepository.getBirthDayTemplate();
//
//        for (Map<String, Object> employee : todaysBirthdays) {
//            String name = (String) employee.get("name"); // assuming your column is `name`
//            String message = birthdayMessageTemplate.replace("{name}", name);
//
//            System.out.println("Sending Birthday Wish: " + message);
//            // you can call your SMS or Email service here
//        }
//
//        System.out.println("Birthday wishes sent at: " + LocalDateTime.now());
//    }
//
//
//    @Scheduled(cron = "0 05 16 * * *") // at 3:15 PM daily
//    public void sendBirthdayWishesto() {
//        List<Map<String, Object>> todaysBirthdays = employeeRepository.getEmployeesWithTodayBirthday();
//        String birthdayMessageTemplate = employeeRepository.getBirthDayTemplate();
//
//        for (Map<String, Object> employee : todaysBirthdays) {
//            String name = (String) employee.get("name"); // assuming your column is `name`
//            String message = birthdayMessageTemplate.replace("{name}", name);
//
//            System.out.println("Sending Birthday Wish: " + message);
//            // you can call your SMS or Email service here
//        }
//
//        System.out.println("Birthday wishes sent at: " + LocalDateTime.now());
//    }
//
//
//    @Scheduled(cron = "0 * * * * *")  // Runs every minute
//    public void sendBirthdayWishesDynamically() {
//        String timeFromDB = employeeRepository.getCronTimeFromDatabase().replace(".",":");  // Format "HH:mm"
//        LocalTime scheduledTime = LocalTime.parse(timeFromDB);
//
//        LocalTime now = LocalTime.now();
//        if (now.getHour() == scheduledTime.getHour() && now.getMinute() == scheduledTime.getMinute()) {
//            List<Map<String, Object>> todaysBirthdays = employeeRepository.getEmployeesWithTodayBirthday();
//            String birthdayMessageTemplate = employeeRepository.getBirthDayTemplate();
//
//            for (Map<String, Object> employee : todaysBirthdays) {
//                String name = (String) employee.get("name");
//                String message = birthdayMessageTemplate.replace("{name}", name);
//                System.out.println("🎉 Sending Birthday Wish to " + name + ": " + message);
//            }
//
//            System.out.println("✅ Birthday wishes sent at: " + LocalDateTime.now());
//        } else {
//            System.out.println("⏰ Not scheduled time. Now: " + now + " Scheduled: " + scheduledTime);
//        }
//    }






}
