package kr.switcher.switcherm.ui.irbrandgraph.adapter;

/* JADX INFO: loaded from: classes2.dex */
public class CommandHistoryItem {
    private String created_at;
    private String name;

    public CommandHistoryItem(String str, String str2) {
        this.created_at = str;
        this.name = str2;
    }

    public String getCreated_at() {
        return this.created_at;
    }

    public String getName() {
        return this.name;
    }
}
