package kr.switcher.switcherm.ui.switcherInfo.adapter;

/* JADX INFO: loaded from: classes2.dex */
public class PlanItem {
    private boolean isMain;
    private int planCode;
    private String planInfo;
    private String planName;
    private int price;

    public PlanItem(int i, int i2, String str, String str2, boolean z) {
        this.planCode = i;
        this.price = i2;
        this.planName = str;
        this.planInfo = str2;
        this.isMain = z;
    }

    public PlanItem(int i, int i2, String str, String str2) {
        this.planCode = i;
        this.price = i2;
        this.planName = str;
        this.planInfo = str2;
        this.isMain = false;
    }

    public int getPlanCode() {
        return this.planCode;
    }

    public void setPlanCode(int i) {
        this.planCode = i;
    }

    public String getPlanInfo() {
        return this.planInfo;
    }

    public void setPlanInfo(String str) {
        this.planInfo = str;
    }

    public String getPlanName() {
        return this.planName;
    }

    public void setPlanName(String str) {
        this.planName = str;
    }

    public boolean isMain() {
        return this.isMain;
    }

    public void setIsMain(boolean z) {
        this.isMain = z;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int i) {
        this.price = i;
    }
}
