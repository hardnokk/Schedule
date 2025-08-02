package org.example.schedule.service;

import lombok.RequiredArgsConstructor;
import org.example.schedule.dto.ScheduleRequest;
import org.example.schedule.dto.ScheduleResponse;
import org.example.schedule.entity.ScheduleEntity;
import org.example.schedule.repository.ScheduleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

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

    @Transactional(readOnly = true)
    public List<ScheduleResponse> findAll() {
        List<ScheduleEntity> ScheduleList = scheduleRepository.findAll();
        List<ScheduleResponse> dtoList = new ArrayList<>();

        for (ScheduleEntity scheduleEntity : ScheduleList) {
            dtoList.add(new ScheduleResponse(
                    scheduleEntity.getId(),
                    scheduleEntity.getTitle(),
                    scheduleEntity.getContent(),
                    scheduleEntity.getName(),
                    scheduleEntity.getCreateTime(),
                    scheduleEntity.getUpdateTime()
            ));
        }
        return dtoList;
    }

    @Transactional
    public ScheduleResponse findSchedule(Long Id) {
        ScheduleEntity scheduleEntity = scheduleRepository.findById(Id).orElseThrow(
                () -> new IllegalArgumentException("해당 스케줄은 존재하지 않습니다.")
        );
        return new ScheduleResponse(
                scheduleEntity.getId(),
                scheduleEntity.getTitle(),
                scheduleEntity.getContent(),
                scheduleEntity.getName(),
                scheduleEntity.getCreateTime(),
                scheduleEntity.getUpdateTime()
        );
    }
}
