package org.scheduler.batchtask.controller;


import dataman.dmbase.utils.DmUtil;
import lombok.RequiredArgsConstructor;
import org.scheduler.batchtask.dto.FileWriteTask;
import org.scheduler.batchtask.service.TaskService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @PostMapping("/add")
    public String addTask(@RequestBody FileWriteTask task) {
        taskService.addTask(task);

        return "Task added to queue.";
    }

}
