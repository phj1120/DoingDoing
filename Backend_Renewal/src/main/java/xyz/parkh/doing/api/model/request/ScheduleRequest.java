package xyz.parkh.doing.api.model.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import xyz.parkh.doing.domain.schedule.model.OpenScope;
import xyz.parkh.doing.domain.schedule.model.Period;
import xyz.parkh.doing.domain.schedule.model.PeriodType;
import xyz.parkh.doing.domain.schedule.model.ScheduleType;


@Getter
@Setter
@ToString
public class ScheduleRequest {

    private ScheduleType scheduleType;
    private OpenScope openScope;

    private PeriodType periodType;
    private int year;
    private int month;
    private int week;

    public ScheduleRequest(ScheduleType scheduleType, OpenScope openScope, PeriodType periodType, int year, int month, int week) {
        this.scheduleType = scheduleType;
        this.openScope = openScope;
        this.periodType = periodType;
        this.year = year;
        this.month = month;
        this.week = week;
    }
}
