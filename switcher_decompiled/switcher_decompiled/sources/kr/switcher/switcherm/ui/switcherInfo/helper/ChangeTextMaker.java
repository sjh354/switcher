package kr.switcher.switcherm.ui.switcherInfo.helper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/* JADX INFO: loaded from: classes2.dex */
public class ChangeTextMaker {
    public static String make(int i, String str) {
        MonthDay monthDayThatWantDate;
        int day;
        int month;
        try {
            monthDayThatWantDate = getMonthDayThatWantDate(new SimpleDateFormat("yyyy-MM-dd").parse(str), -1);
        } catch (ParseException e) {
            e.printStackTrace();
            monthDayThatWantDate = null;
        }
        if (monthDayThatWantDate != null) {
            month = monthDayThatWantDate.getMonth();
            day = monthDayThatWantDate.getDay();
        } else {
            day = 0;
            month = 0;
        }
        return String.format(i + "구로 변경 원하시나요?\n\n발송 전 변경은 1회만 가능하고\n%d월 %d일 00시 이후에는 변경 불가능합니다", Integer.valueOf(month), Integer.valueOf(day));
    }

    public static MonthDay getMonthDayThatWantDate(Date date, int i) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(5, i);
        return new MonthDay(calendar.get(2) + 1, calendar.get(5));
    }

    public static class MonthDay {
        private int day;
        private int month;

        public MonthDay(int i, int i2) {
            this.month = i;
            this.day = i2;
        }

        public int getMonth() {
            return this.month;
        }

        public int getDay() {
            return this.day;
        }
    }
}
