package kr.switcher.switcherm.ui.setting.helper;

import android.view.View;
import antistatic.spinnerwheel.AbstractWheel;

/* JADX INFO: loaded from: classes2.dex */
public class RemoconReservationInfo {
    private View fri;
    private AbstractWheel hour;
    private AbstractWheel min;
    private View mon;
    private View sat;
    private View sun;
    private String tag;
    private View thu;
    private String title;
    private View tue;
    private View wed;

    public RemoconReservationInfo(String str, View view, View view2, View view3, View view4, View view5, View view6, View view7, AbstractWheel abstractWheel, AbstractWheel abstractWheel2, String str2) {
        this.title = str;
        this.mon = view;
        this.tue = view2;
        this.wed = view3;
        this.thu = view4;
        this.fri = view5;
        this.sat = view6;
        this.sun = view7;
        this.hour = abstractWheel;
        this.min = abstractWheel2;
        this.tag = str2;
    }

    public boolean checkIsValidDaySet() {
        return this.mon.isSelected() || this.tue.isSelected() || this.wed.isSelected() || this.thu.isSelected() || this.fri.isSelected() || this.sat.isSelected() || this.sun.isSelected();
    }

    public String getTitle() {
        return this.title;
    }

    public View getMon() {
        return this.mon;
    }

    public View getTue() {
        return this.tue;
    }

    public View getWed() {
        return this.wed;
    }

    public View getThu() {
        return this.thu;
    }

    public View getFri() {
        return this.fri;
    }

    public View getSat() {
        return this.sat;
    }

    public View getSun() {
        return this.sun;
    }

    public AbstractWheel getHour() {
        return this.hour;
    }

    public AbstractWheel getMin() {
        return this.min;
    }

    public String getTag() {
        return this.tag;
    }
}
