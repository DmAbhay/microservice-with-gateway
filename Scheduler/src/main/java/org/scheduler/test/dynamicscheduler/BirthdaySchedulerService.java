//package org.scheduler.test.dynamicscheduler;
//
//import jakarta.annotation.PostConstruct;
//import jakarta.annotation.PreDestroy;
//import org.scheduler.test.repository.EmployeeRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.scheduling.TaskScheduler;
//import org.springframework.scheduling.support.CronTrigger;
//import org.springframework.stereotype.Service;
//
//import java.time.LocalDateTime;
//import java.util.Date;
//import java.util.List;
//import java.util.Map;
//import java.util.concurrent.ScheduledFuture;
//
//@Service
//public class BirthdaySchedulerService {
//
//    @Autowired
//    private EmployeeRepository employeeRepository;
//
//    @Autowired
//    private TaskScheduler taskScheduler; // Spring's TaskScheduler
//
//    private ScheduledFuture<?> scheduledFuture;
//
//    @PostConstruct
//    public void init() {
//        System.out.println("✅ Initializing scheduler...");
//        String cronExpression = employeeRepository.getCronCronExpressionFromDatabase(); // e.g., "0 56 17 * * *"
//        scheduleTask(cronExpression);
//    }
//
//    public void scheduleTask(String cronExpression) {
//        if (scheduledFuture != null) {
//            scheduledFuture.cancel(false);
//            System.out.println("🛑 Previous scheduled task cancelled.");
//        }
//
//
//        System.out.println("⏰ Scheduling task with cron: " + cronExpression);
//        scheduledFuture = taskScheduler.schedule(this::sendBirthdayWishes, new CronTrigger(cronExpression));
//    }
//
//    private void sendBirthdayWishes() {
//        System.out.println("🎉 Birthday Task Running at " + LocalDateTime.now());
//        List<Map<String, Object>> todaysBirthdays = employeeRepository.getEmployeesWithTodayBirthday();
//        String birthdayMessageTemplate = employeeRepository.getBirthDayTemplate();
//
//        todaysBirthdays.forEach(employee -> {
//            String name = (String) employee.get("name");
//            String message = birthdayMessageTemplate.replace("{name}", name);
//            System.out.println("🎁 Sending Birthday Wish to " + name + ": " + message);
//        });
//        System.out.println("✅ Birthday wishes sent successfully.");
//
//
//    }
//
//    @PreDestroy
//    public void shutdown() {
//        if (scheduledFuture != null) scheduledFuture.cancel(false);
//        System.out.println("🛑 Scheduler shutdown complete.");
//    }
//}
//
//
//
//
//
//
//
//
////package org.scheduler.test.dynamicscheduler;
////
////
////
////import jakarta.annotation.PostConstruct;
////import jakarta.annotation.PreDestroy;
////import org.scheduler.test.repository.EmployeeRepository;
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.stereotype.Service;
////
////import java.time.Duration;
////import java.time.LocalDateTime;
////import java.time.LocalTime;
////import java.util.List;
////import java.util.Map;
////import java.util.concurrent.*;
////
////@Service
////public class BirthdaySchedulerService {
////
////    @Autowired
////    private EmployeeRepository employeeRepository;
////
////    private final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
////    private ScheduledFuture<?> scheduledFuture;
////
////    @PostConstruct
////    public void init() {
////        System.out.println("✅ Initializing Scheduler");
////        scheduleBirthdayTask();
////    }
////
////    /**
////     * Schedules birthday wishes at the time from DB.
////     */
////    public void scheduleBirthdayTask() {
////        if (scheduledFuture != null) {
////            scheduledFuture.cancel(false);
////            System.out.println("🛑 Previous task cancelled");
////        }
////
////        String timeFromDB = employeeRepository.getCronTimeFromDatabase().replace(".", ":");
////        LocalTime scheduledTime = LocalTime.parse(timeFromDB);
////        System.out.println("⏰ Scheduling next task at: " + scheduledTime);
////
////        long initialDelay = calculateInitialDelay(scheduledTime);
////        long oneDay = TimeUnit.DAYS.toSeconds(1);
////
////        scheduledFuture = executorService.scheduleAtFixedRate(
////                this::sendBirthdayWishes, initialDelay, oneDay, TimeUnit.SECONDS);
////
////        System.out.println("✅ Next task will run in " + initialDelay + " seconds");
////    }
////
////    private long calculateInitialDelay(LocalTime scheduledTime) {
////        LocalDateTime now = LocalDateTime.now();
////        LocalDateTime nextRun = now.withHour(scheduledTime.getHour()).withMinute(scheduledTime.getMinute()).withSecond(0);
////        if (nextRun.isBefore(now)) nextRun = nextRun.plusDays(1);
////        return Duration.between(now, nextRun).getSeconds();
////    }
////
////    private void sendBirthdayWishes() {
////        System.out.println("🎉 Running Birthday Wishes Task at " + LocalDateTime.now());
////        List<Map<String, Object>> todaysBirthdays = employeeRepository.getEmployeesWithTodayBirthday();
////        String birthdayMessage = employeeRepository.getBirthDayTemplate();
////
////        todaysBirthdays.forEach(emp -> {
////            String name = (String) emp.get("name");
////            String message = birthdayMessage.replace("{name}", name);
////            System.out.println("🎁 Sending birthday wish to " + name + ": " + message);
////        });
////
////        System.out.println("✅ Birthday wishes sent at " + LocalDateTime.now());
////    }
////
////    @PreDestroy
////    public void shutdown() {
////        if (scheduledFuture != null) scheduledFuture.cancel(false);
////        executorService.shutdown();
////        System.out.println("🛑 Scheduler shutdown complete");
////    }
////}
