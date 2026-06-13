package kr.switcher.switcherm.ui.main.adapter;

/* JADX INFO: loaded from: classes2.dex */
public class CommandItem {
    private String commandTitle;
    private String id;
    private String time;

    public CommandItem(String str) {
        this.commandTitle = str;
    }

    public CommandItem(String str, String str2) {
        this.commandTitle = str2;
        this.id = str;
    }

    public String getCommandTitle() {
        return this.commandTitle;
    }

    public void setCommandTitle(String str) {
        this.commandTitle = str;
    }

    public String getTime() {
        return this.time;
    }

    public void setTime(String str) {
        this.time = str;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }
}
