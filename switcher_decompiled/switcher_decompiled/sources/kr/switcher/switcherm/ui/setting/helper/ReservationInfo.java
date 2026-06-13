package kr.switcher.switcherm.ui.setting.helper;

import android.view.View;
import androidx.viewpager.widget.ViewPager;
import antistatic.spinnerwheel.AbstractWheel;

/* JADX INFO: loaded from: classes2.dex */
public class ReservationInfo {
    private AbstractWheel ampm;
    private View fri;
    private AbstractWheel hour;
    private AbstractWheel min;
    private View mon;
    private View sat;
    private View sun;
    private ViewPager switcherType;
    private View thu;
    private View timerOff;
    private View timerOn;
    private String title;
    private View tue;
    private View wed;

    public ReservationInfo(String str, View view, View view2, View view3, View view4, View view5, View view6, View view7, AbstractWheel abstractWheel, AbstractWheel abstractWheel2, AbstractWheel abstractWheel3, View view8, View view9, ViewPager viewPager) {
        this.title = str;
        this.mon = view;
        this.tue = view2;
        this.wed = view3;
        this.thu = view4;
        this.fri = view5;
        this.sat = view6;
        this.sun = view7;
        this.ampm = abstractWheel;
        this.hour = abstractWheel2;
        this.min = abstractWheel3;
        this.timerOn = view8;
        this.timerOff = view9;
        this.switcherType = viewPager;
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

    public AbstractWheel getAmpm() {
        return this.ampm;
    }

    public AbstractWheel getHour() {
        return this.hour;
    }

    public AbstractWheel getMin() {
        return this.min;
    }

    public View getTimerOn() {
        return this.timerOn;
    }

    public View getTimerOff() {
        return this.timerOff;
    }

    public ViewPager getSwitcherType() {
        return this.switcherType;
    }
}
