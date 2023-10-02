package org.example.util;

import java.util.Calendar;
import java.util.TimeZone;

/**
 * @author chensh
 * @datetime 2023/10/2 12:57 PM
 */
public class CalendarTest {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        // 当前时间
        System.out.println(calendar.getTime());
        // 获取当前周周一的日期
        System.out.println(calendar.getFirstDayOfWeek());
        // 获取当前日期类型
        System.out.println(calendar.getCalendarType());
        System.out.println(calendar.getTimeZone());
        System.out.println(calendar.getWeeksInWeekYear());
        System.out.println(calendar.getWeekYear());

        calendar.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        System.out.println(calendar.toInstant());

    }
}
