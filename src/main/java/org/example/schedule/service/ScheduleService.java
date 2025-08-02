package org.example.schedule.service;

import lombok.RequiredArgsConstructor;
import org.example.schedule.dto.ScheduleRequest;
import org.example.schedule.dto.ScheduleResponse;
import org.example.schedule.entity.ScheduleEntity;
import org.example.schedule.repository.ScheduleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;

    @Transactional
    public ScheduleResponse save(ScheduleRequest scheduleRequest) {
        ScheduleEntity scheduleEntity = new ScheduleEntity(
                scheduleRequest.getTitle(),
                scheduleRequest.getContent(),
                scheduleRequest.getName(),
                scheduleRequest.getPassword()
        );
        ScheduleEntity saveSchedule = scheduleRepository.save(scheduleEntity);

        return new ScheduleResponse(
                saveSchedule.getId(),
                saveSchedule.getTitle(),
                saveSchedule.getContent(),
                saveSchedule.getName(),
                saveSchedule.getCreateTime(),
                saveSchedule.getUpdateTime()
        );
    }
}
