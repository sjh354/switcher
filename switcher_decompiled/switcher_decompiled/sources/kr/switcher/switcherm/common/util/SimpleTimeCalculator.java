package kr.switcher.switcherm.common.util;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import kr.switcher.device.IODeviceConfig;

/* JADX INFO: loaded from: classes2.dex */
public class SimpleTimeCalculator {
    private boolean ampm;
    private DayOfTheWeekMap dayMap;
    private int hour;
    private int min;
    private final int MAX_HOUR = 12;
    private final int MIN_HOUR = 0;
    private final int MAX_MIN = 60;
    private final int MIN_MIN = 0;

    public enum DayOfTheWeek implements Serializable {
        MON,
        TUE,
        WED,
        THU,
        FRI,
        SAT,
        SUN
    }

    public SimpleTimeCalculator(String str, int i, int i2, DayOfTheWeekMap dayOfTheWeekMap) {
        setAmpm(str);
        setHour(i);
        setMin(i2);
        setDayMap(dayOfTheWeekMap);
    }

    public String getAmPm() {
        return this.ampm ? IODeviceConfig.AM : "pm";
    }

    public void setAmpm(String str) {
        this.ampm = str.equalsIgnoreCase(IODeviceConfig.AM);
    }

    public int getHour() {
        int i = this.hour;
        if (i == 0) {
            return 12;
        }
        return i;
    }

    public void setHour(int i) {
        if (i == 12) {
            i = 0;
        }
        this.hour = i;
    }

    public int getMin() {
        return this.min;
    }

    public void setMin(int i) {
        this.min = i;
    }

    public DayOfTheWeekMap getDayMap() {
        return this.dayMap;
    }

    public void setDayMap(DayOfTheWeekMap dayOfTheWeekMap) {
        this.dayMap = dayOfTheWeekMap;
    }

    public void calculate(int i, int i2) {
        calculateHour(i);
        calculateMin(i2);
    }

    private void changeAmPm() {
        this.ampm = !this.ampm;
    }

    private void over() {
        changeAmPm();
        if (this.ampm) {
            pushOneByOneDay();
        }
    }

    private void under() {
        changeAmPm();
        if (this.ampm) {
            return;
        }
        pushBackOneByOneDay();
    }

    private void pushOneByOneDay() {
        boolean z = this.dayMap.get(DayOfTheWeek.MON);
        boolean z2 = this.dayMap.get(DayOfTheWeek.TUE);
        boolean z3 = this.dayMap.get(DayOfTheWeek.WED);
        boolean z4 = this.dayMap.get(DayOfTheWeek.THU);
        boolean z5 = this.dayMap.get(DayOfTheWeek.FRI);
        boolean z6 = this.dayMap.get(DayOfTheWeek.SAT);
        this.dayMap.put(DayOfTheWeek.MON, this.dayMap.get(DayOfTheWeek.SUN));
        this.dayMap.put(DayOfTheWeek.TUE, z);
        this.dayMap.put(DayOfTheWeek.WED, z2);
        this.dayMap.put(DayOfTheWeek.THU, z3);
        this.dayMap.put(DayOfTheWeek.FRI, z4);
        this.dayMap.put(DayOfTheWeek.SAT, z5);
        this.dayMap.put(DayOfTheWeek.SUN, z6);
    }

    private void pushBackOneByOneDay() {
        boolean z = this.dayMap.get(DayOfTheWeek.MON);
        boolean z2 = this.dayMap.get(DayOfTheWeek.TUE);
        boolean z3 = this.dayMap.get(DayOfTheWeek.WED);
        boolean z4 = this.dayMap.get(DayOfTheWeek.THU);
        boolean z5 = this.dayMap.get(DayOfTheWeek.FRI);
        boolean z6 = this.dayMap.get(DayOfTheWeek.SAT);
        boolean z7 = this.dayMap.get(DayOfTheWeek.SUN);
        this.dayMap.put(DayOfTheWeek.MON, z2);
        this.dayMap.put(DayOfTheWeek.TUE, z3);
        this.dayMap.put(DayOfTheWeek.WED, z4);
        this.dayMap.put(DayOfTheWeek.THU, z5);
        this.dayMap.put(DayOfTheWeek.FRI, z6);
        this.dayMap.put(DayOfTheWeek.SAT, z7);
        this.dayMap.put(DayOfTheWeek.SUN, z);
    }

    private void calculateHour(int i) {
        int i2 = this.hour + i;
        this.hour = i2;
        if (i2 >= 12) {
            over();
            this.hour -= 12;
        }
        if (this.hour < 0) {
            under();
            this.hour += 12;
        }
    }

    private void calculateMin(int i) {
        int i2 = this.min + i;
        this.min = i2;
        if (i2 >= 60) {
            calculateHour(1);
            this.min -= 60;
        }
        if (this.min < 0) {
            calculateHour(-1);
            this.min += 60;
        }
    }

    public static class DayOfTheWeekMap {
        Map<DayOfTheWeek, Boolean> map = new HashMap();

        public DayOfTheWeekMap() {
        }

        public DayOfTheWeekMap(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
            put(z, z2, z3, z4, z5, z6, z7);
        }

        public DayOfTheWeekMap putEveryDay() {
            return put(true, true, true, true, true, true, true);
        }

        public DayOfTheWeekMap putWeekDay() {
            return put(true, true, true, true, true, false, false);
        }

        public DayOfTheWeekMap putWeekend() {
            return put(false, false, false, false, false, true, true);
        }

        public DayOfTheWeekMap put(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
            this.map.put(DayOfTheWeek.MON, Boolean.valueOf(z));
            this.map.put(DayOfTheWeek.TUE, Boolean.valueOf(z2));
            this.map.put(DayOfTheWeek.WED, Boolean.valueOf(z3));
            this.map.put(DayOfTheWeek.THU, Boolean.valueOf(z4));
            this.map.put(DayOfTheWeek.FRI, Boolean.valueOf(z5));
            this.map.put(DayOfTheWeek.SAT, Boolean.valueOf(z6));
            this.map.put(DayOfTheWeek.SUN, Boolean.valueOf(z7));
            return this;
        }

        public void put(DayOfTheWeek dayOfTheWeek, boolean z) {
            this.map.put(dayOfTheWeek, Boolean.valueOf(z));
        }

        public boolean get(DayOfTheWeek dayOfTheWeek) {
            return this.map.get(dayOfTheWeek).booleanValue();
        }
    }
}
