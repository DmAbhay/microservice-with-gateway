//package org.scheduler.test.dynamicscheduler;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/scheduler")
//public class SchedulerController {
//
//    @Autowired
//    private BirthdaySchedulerService birthdaySchedulerService;
//
//    @PostMapping("/reschedule")
//    public ResponseEntity<String> rescheduleTask(@RequestParam("cronExpression") String cronExpression) {
//        birthdaySchedulerService.scheduleTask(cronExpression);
//        return ResponseEntity.ok("✅ Birthday Task Rescheduled Successfully!");
//    }
//
//}
//
