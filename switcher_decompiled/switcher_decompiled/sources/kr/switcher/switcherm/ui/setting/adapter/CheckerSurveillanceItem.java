package kr.switcher.switcherm.ui.setting.adapter;

/* JADX INFO: loaded from: classes2.dex */
public class CheckerSurveillanceItem {
    public int alarm_duration_min;
    public int checkerId;
    public String createdAt;
    public String endAt;
    public int id;
    public String isActive;
    public int level;
    public String startAt;
    public String title;
    public int trespass_duration_min;
    public String weekDays;

    public CheckerSurveillanceItem(int i, String str, String str2, int i2, int i3, int i4, String str3, String str4, String str5, String str6, int i5) {
        this.id = i;
        this.title = str;
        this.isActive = str2;
        this.trespass_duration_min = i2;
        this.alarm_duration_min = i3;
        this.level = i4;
        this.weekDays = str3;
        this.startAt = str4;
        this.endAt = str5;
        this.createdAt = str6;
        this.checkerId = i5;
    }
}
