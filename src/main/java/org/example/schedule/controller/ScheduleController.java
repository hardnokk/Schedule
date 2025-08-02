package org.example.schedule.controller;

import lombok.RequiredArgsConstructor;
import org.example.schedule.dto.ScheduleRequest;
import org.example.schedule.dto.ScheduleResponse;
import org.example.schedule.service.ScheduleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ScheduleController {
    private final ScheduleService scheduleService;

    // 읿정 등록
    @PostMapping("/schedules")
    public ScheduleResponse saveSchedule(
            @RequestBody ScheduleRequest scheduleRequest
    ) {
        return scheduleService.save(scheduleRequest);
    }

    // 전체 일정 조회

    // 선택 일정 조회

    // 선택 일정 수정

    // 선택 일정 삭제

}
