package kr.switcher.switcherm.ui.setting.helper;

/* JADX INFO: loaded from: classes2.dex */
public class DayOfWeekRepeater {
    public static final int DAILY = 1;
    public static final int NONE = 0;
    public static final int WEEKDAY = 2;
    public static final int WEEKEND = 3;
    private int status = 0;

    public void setDayOfWeek(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
        if (z && z2 && z3 && z4 && z5 && z6 && z7) {
            this.status = 1;
            return;
        }
        if (z && z2 && z3 && z4 && z5 && !z6 && !z7) {
            this.status = 2;
            return;
        }
        if (!z && !z2 && !z3 && !z4 && !z5 && z6 && z7) {
            this.status = 3;
        } else {
            this.status = 0;
        }
    }

    public int getStatus() {
        return this.status;
    }
}
