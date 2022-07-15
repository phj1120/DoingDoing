package xyz.parkh.doing.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Schedule {

    @Id
    @GeneratedValue
    @Column(name = "schedule_no")
    private Long no;

    @ManyToOne
    @JoinColumn(name = "user_no")
    private User user;

    private String title;

    @Lob
    private String content;

    private LocalDate endDate;

    private Boolean isPublic;

    private Boolean isComplete;

    private Integer type;
}
