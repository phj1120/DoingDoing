package xyz.parkh.doing.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
// NO, USER_ID, TITLE, CONTENT, END_TIME, IS_PUBLIC, IS_COMPLETE
public class ScheduleVo {
    private Integer no;
    private String userId;
    private String title;
    private String content;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime endTime;

    private Boolean isPublic;
    private Boolean isComplete; // 생성 시 default : false
}
