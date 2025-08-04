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
    @GetMapping("/schedules")
    public List<ScheduleResponse> getSchedules() {
        return scheduleService.findAll();
    }

    // 선택 일정 조회
    @GetMapping("/schedules/{Id}")
    public ScheduleResponse getSchedule(
            @PathVariable Long Id
    ) {
        return scheduleService.findSchedule(Id);
    }

    // 선택 일정 수정
    @PutMapping("/schedules/{Id}")
    public ScheduleResponse updateSchedule(
            @PathVariable Long Id,
            @RequestBody ScheduleRequest scheduleRequest
    ) {
        return scheduleService.updateSchedule(Id, scheduleRequest);
    }

    // 선택 일정 삭제
    @DeleteMapping("/schedules/{id}/{password}")
    public void deleteSchedule(
            @PathVariable Long id,
            @PathVariable String password
    ) {
        scheduleService.deleteSchedule(id, password);
    }
}
