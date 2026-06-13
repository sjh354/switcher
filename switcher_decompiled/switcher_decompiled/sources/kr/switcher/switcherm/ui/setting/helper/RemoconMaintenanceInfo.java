package kr.switcher.switcherm.ui.setting.helper;

import android.view.View;
import android.widget.TextView;
import antistatic.spinnerwheel.AbstractWheel;

/* JADX INFO: loaded from: classes2.dex */
public class RemoconMaintenanceInfo {
    private AbstractWheel endHour;
    private AbstractWheel endMin;
    private View fri;
    private TextView goalTemperature;
    private View mon;
    private View sat;
    private AbstractWheel startHour;
    private AbstractWheel startMin;
    private View sun;
    private View thu;
    private String title;
    private View tue;
    private View wed;

    public RemoconMaintenanceInfo(String str, View view, View view2, View view3, View view4, View view5, View view6, View view7, TextView textView, AbstractWheel abstractWheel, AbstractWheel abstractWheel2, AbstractWheel abstractWheel3, AbstractWheel abstractWheel4) {
        this.title = str;
        this.mon = view;
        this.tue = view2;
        this.wed = view3;
        this.thu = view4;
        this.fri = view5;
        this.sat = view6;
        this.sun = view7;
        this.startHour = abstractWheel;
        this.endHour = abstractWheel2;
        this.startMin = abstractWheel3;
        this.endMin = abstractWheel4;
        this.goalTemperature = textView;
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

    public AbstractWheel getStartHour() {
        return this.startHour;
    }

    public AbstractWheel getEndHour() {
        return this.endHour;
    }

    public AbstractWheel getStartMin() {
        return this.startMin;
    }

    public AbstractWheel getEndMin() {
        return this.endMin;
    }

    public TextView getGoalTemperature() {
        return this.goalTemperature;
    }
}
