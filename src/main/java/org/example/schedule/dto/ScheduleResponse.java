package org.example.schedule.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ScheduleResponse {
    private final Long id;

    private final String title;
    private final String content;
    private final String name;

    private final LocalDateTime createTime;
    private final LocalDateTime updateTime;

    public ScheduleResponse(
            Long id,
            String title,
            String content,
            String name,
            LocalDateTime createTime,
            LocalDateTime updateTime
    ) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.name = name;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }
}
