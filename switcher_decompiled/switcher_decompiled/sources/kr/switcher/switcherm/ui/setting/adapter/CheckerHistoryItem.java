package kr.switcher.switcherm.ui.setting.adapter;

/* JADX INFO: loaded from: classes2.dex */
public class CheckerHistoryItem {
    private int checker;
    private String created_at;
    private int id;
    private String transition_type;

    public CheckerHistoryItem(int i, String str, String str2, int i2) {
        this.id = i;
        this.transition_type = str;
        this.created_at = str2;
        this.checker = i2;
    }

    public int getId() {
        return this.id;
    }

    public String getTransition_type() {
        return this.transition_type;
    }

    public String getCreated_at() {
        return this.created_at;
    }

    public int getChecker() {
        return this.checker;
    }
}
