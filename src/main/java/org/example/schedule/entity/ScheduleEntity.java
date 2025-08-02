package org.example.schedule.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
public class ScheduleEntity extends BaseEntity { // BaseEntity 상속
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // PK (DB 자동 생성)

    private String title;   // 제목
    private String content; //내용
    private String name;    // 작성자

    private String password;// 비밀번호

    public ScheduleEntity(
            String title,
            String content,
            String name,
            String password
    ) {
        this.title = title;
        this.content = content;
        this.name = name;
        this.password = password;
    }

    public void updateSchedule(
            String content,
            String name
    ) {
        this.content = content;
        this.name = name;
    }
}
