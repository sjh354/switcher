package kr.switcher.switcherm.ui.main.adapter;

/* JADX INFO: loaded from: classes2.dex */
public class RemoconCommandItem {
    private String commandName;
    private String id;

    public RemoconCommandItem(String str) {
        this.commandName = str;
    }

    public RemoconCommandItem(String str, String str2) {
        this.commandName = str2;
        this.id = str;
    }

    public String getCommandName() {
        return this.commandName;
    }

    public void setCommandName(String str) {
        this.commandName = this.commandName;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }
}
