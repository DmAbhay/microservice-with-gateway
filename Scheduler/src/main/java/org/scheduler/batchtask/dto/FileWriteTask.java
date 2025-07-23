package org.scheduler.batchtask.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FileWriteTask {

    private String localPath;
    private String fileName;
    private String text;

}
