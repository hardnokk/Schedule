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
        // 비밀번호 유효성 검사
        if (scheduleRequest.getPassword() == null || scheduleRequest.getPassword().trim().isEmpty()) {
            throw new IllegalArgumentException("비밀번호는 반드시 입력해야 합니다.");
        }

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

    @Transactional
    public ScheduleResponse updateSchedule(Long Id, ScheduleRequest scheduleRequest) {
        ScheduleEntity scheduleEntity = scheduleRepository.findById(Id).orElseThrow(
                () -> new IllegalArgumentException("해당 스케줄이 존재하지 않습니다.")
        );
        if (scheduleEntity.getPassword().equals(scheduleRequest.getPassword())) { // 입력한 비밀번호 비교
            scheduleEntity.updateSchedule(
                    scheduleRequest.getContent(),
                    scheduleRequest.getName()
            );
        } else {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }
        return new ScheduleResponse(
                scheduleEntity.getId(),
                scheduleEntity.getTitle(),
                scheduleEntity.getContent(),
                scheduleEntity.getName(),
                scheduleEntity.getCreateTime(),
                scheduleEntity.getUpdateTime()
        );
    }

    @Transactional
    public void deleteSchedule(Long id, String password) {
        ScheduleEntity scheduleEntity = scheduleRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("그런 메모는 존재하지 않습니다.")
        );

        if (!scheduleEntity.getPassword().equals(password)) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }

        scheduleRepository.deleteById(id);
    }
}
