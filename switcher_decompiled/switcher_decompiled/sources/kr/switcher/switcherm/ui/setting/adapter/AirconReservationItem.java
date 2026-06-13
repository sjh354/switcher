package kr.switcher.switcherm.ui.setting.adapter;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class AirconReservationItem {
    private String appliance_id;
    private String created_at;
    private List<String> ir_id_list;
    private String is_enabled;
    private String mac_address;
    private String tag;
    private String time;
    private String title;
    private String week;
    private String week_time;

    public AirconReservationItem(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, List<String> list) {
        this.mac_address = str;
        this.week = str2;
        this.created_at = str3;
        this.time = str4;
        this.week_time = str5;
        this.is_enabled = str6;
        this.appliance_id = str7;
        this.title = str8;
        this.ir_id_list = list;
        this.tag = str9;
    }

    public String getTime() {
        return this.time;
    }

    public void setTime(String str) {
        this.time = str;
    }

    public String getMac_address() {
        return this.mac_address;
    }

    public void setMac_address(String str) {
        this.mac_address = str;
    }

    public String getWeek() {
        return this.week;
    }

    public void setWeek(String str) {
        this.week = str;
    }

    public String getCreated_at() {
        return this.created_at;
    }

    public void setCreated_at(String str) {
        this.created_at = str;
    }

    public String getWeek_time() {
        return this.week_time;
    }

    public void setWeek_time(String str) {
        this.week_time = str;
    }

    public String getIs_enabled() {
        return this.is_enabled;
    }

    public void setIs_enabled(String str) {
        this.is_enabled = str;
    }

    public String getAppliance_id() {
        return this.appliance_id;
    }

    public void setAppliance_id(String str) {
        this.appliance_id = str;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public List<String> getIr_id_list() {
        return this.ir_id_list;
    }

    public void setIr_id_list(List<String> list) {
        this.ir_id_list = list;
    }

    public String getTag() {
        return this.tag;
    }

    public void setTag(String str) {
        this.tag = str;
    }
}
