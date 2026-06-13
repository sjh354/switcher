package kr.switcher.device.remocon;

/* JADX INFO: loaded from: classes2.dex */
public class IRCommand {
    private String id;
    private String name;

    public IRCommand(String str) {
        this.name = str;
    }

    public IRCommand(String str, String str2) {
        this.id = str;
        this.name = str2;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }
}
