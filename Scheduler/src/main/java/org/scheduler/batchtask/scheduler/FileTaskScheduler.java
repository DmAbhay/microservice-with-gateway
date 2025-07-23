package org.scheduler.batchtask.scheduler;


import org.scheduler.batchtask.service.TaskService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class FileTaskScheduler {

    private final TaskService taskService;

    public FileTaskScheduler(TaskService taskService) {
        this.taskService = taskService;
    }

    // Every day at 3:00 PM
    @Scheduled(cron = "0 */5 * * * *")
    public void runTasks() {
        taskService.executeAllTasks();
    }
}
