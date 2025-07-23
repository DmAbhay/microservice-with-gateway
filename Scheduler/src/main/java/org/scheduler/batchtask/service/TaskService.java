package org.scheduler.batchtask.service;

import org.scheduler.batchtask.dto.FileWriteTask;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

@Service
public class TaskService {

    private final Queue<FileWriteTask> taskQueue = new ConcurrentLinkedQueue<>();

    public void addTask(FileWriteTask task) {
        taskQueue.add(task);
        System.out.println("✅ Task added: " + task.getFileName());
    }

    public void executeAllTasks() {

        if(taskQueue.isEmpty()){
            System.out.println("No any task for executing in execution queue");
            return;
        }
        System.out.println("⏳ Writing all files...");

        while (!taskQueue.isEmpty()) {
            FileWriteTask task = taskQueue.poll();
            try {
                File dir = new File(task.getLocalPath());
                if (!dir.exists()) {
                    dir.mkdirs();
                }

                File file = new File(dir, task.getFileName());
                try (FileWriter writer = new FileWriter(file)) {
                    writer.write(task.getText());
                }

                System.out.println("✅ File written: " + file.getAbsolutePath());
            } catch (IOException e) {
                System.out.println("❌ Failed to write file: " + e.getMessage());
            }
        }

        System.out.println("✅ All tasks completed.");
    }
}

