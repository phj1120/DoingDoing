package xyz.parkh.doing.domain.schedule.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.parkh.doing.domain.schedule.entity.Schedule;
import xyz.parkh.doing.domain.schedule.model.*;
import xyz.parkh.doing.domain.schedule.repository.ScheduleRepository;
import xyz.parkh.doing.domain.user.entity.User;
import xyz.parkh.doing.domain.user.service.UserService;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class ScheduleService {

    private final UserService userService;
    private final ScheduleRepository scheduleRepository;

    // 일정 생성
    public void addSchedule(ScheduleDto scheduleDTO) {
        Schedule schedule = null;

        if (scheduleDTO.getScheduleType() == ScheduleType.HABIT) {
            schedule = scheduleDTO.convertHabitSchedule();
        } else if (scheduleDTO.getScheduleType() == ScheduleType.TODO) {
            schedule = scheduleDTO.convertToDoSchedule();
        }

        if (schedule == null) {
            throw new NullPointerException();
        }
        scheduleRepository.save(schedule);
    }

    // 일정 목록 조회
    public List<Schedule> findScheduleList(ScheduleConditionDTO scheduleConditionDto) {
        // 요청하는 사람과 일정 주인의 관계 확인
        // - OpenScope.PRIVATE : 본인
        // - OpenScope.FRIEND : 본인, 친구
        // - OpenScope.PUBLIC : 모든 사용자 (본인, 친구, 친구X, 로그인 안 한 사용자)

        // 일정 조회 기간 확인
        //    일정 기간 타입 확인
        //    - PeriodType.YEAR, PeriodType.MONTH, PeriodType.DAY
        //    일정 기간 확인
        //    - Period.year, Period.week, Period.day

        // 일정 타입 확인
        // - ScheduleType.HABIT : 습관
        // - ScheduleType.TODO : 할일

        User user = userService.findByAuthId(scheduleConditionDto.getAuthId());
        Period period = scheduleConditionDto.getPeriod();
        OpenScope openScope = scheduleConditionDto.getOpenScope();
        ScheduleType scheduleType = scheduleConditionDto.getScheduleType();

        List<Schedule> scheduleList = scheduleRepository.findAllByUserAndPeriodAndOpenScopeAndScheduleType(user, period, openScope, scheduleType);

        return scheduleList;
    }


    // 오늘 일정 조회


    // 일정 수정

    // 일정 삭제


}
