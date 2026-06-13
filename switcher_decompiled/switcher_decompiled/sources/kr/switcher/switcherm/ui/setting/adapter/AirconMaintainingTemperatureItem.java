package kr.switcher.switcherm.ui.setting.adapter;

/* JADX INFO: loaded from: classes2.dex */
public class AirconMaintainingTemperatureItem {
    public int appliances;
    public String created_at;
    public String end_time_at;
    public int goal_temperature;
    public int id;
    public Boolean is_enabled;
    public String start_time_at;
    public String title;
    public String weekdays;

    public AirconMaintainingTemperatureItem(int i, String str, Boolean bool, int i2, String str2, String str3, String str4, String str5, int i3) {
        this.id = i;
        this.title = str;
        this.is_enabled = bool;
        this.goal_temperature = i2;
        this.weekdays = str2;
        this.start_time_at = str3;
        this.end_time_at = str4;
        this.created_at = str5;
        this.appliances = i3;
    }
}
