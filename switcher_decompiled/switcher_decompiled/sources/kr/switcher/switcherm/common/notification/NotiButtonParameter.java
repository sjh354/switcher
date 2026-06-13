package kr.switcher.switcherm.common.notification;

/* JADX INFO: loaded from: classes2.dex */
public class NotiButtonParameter {
    public static final String NOTI_ACTION_CONFIRM = "NOTI_ACTION_CONFIRM";
    public static final String NOTI_ACTION_DISABLE = "NOTI_ACTION_DISABLE";
    public static final String PARM_NOTI_ACTION = "NOTI_ACTION";
    private String action;
    private String title;
    private String value;

    public NotiButtonParameter(String str, String str2, String str3) {
        this.action = str;
        this.value = str2;
        this.title = str3;
    }

    public String getAction() {
        return this.action;
    }

    public void setAction(String str) {
        this.action = str;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String str) {
        this.value = str;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }
}
