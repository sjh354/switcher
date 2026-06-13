package kr.switcher.switcherm.ui.mypage.helper;

/* JADX INFO: loaded from: classes2.dex */
public class SubscriptionsMeItem {
    private Boolean info;
    private int infoId;
    private Boolean marketing;
    private int markettingId;

    public SubscriptionsMeItem() {
        this.marketing = false;
        this.info = false;
    }

    public SubscriptionsMeItem(Boolean bool, int i, Boolean bool2, int i2) {
        this.marketing = bool;
        this.markettingId = i;
        this.info = bool2;
        this.infoId = i2;
    }

    public SubscriptionsMeItem(Boolean bool, Boolean bool2) {
        this.marketing = bool;
        this.info = bool2;
    }

    public Boolean getMarketing() {
        return this.marketing;
    }

    public Boolean getInfo() {
        return this.info;
    }

    public void setMarketing(Boolean bool) {
        this.marketing = bool;
    }

    public void setInfo(Boolean bool) {
        this.info = bool;
    }

    public void setMarkettingId(int i) {
        this.markettingId = i;
    }

    public void setInfoId(int i) {
        this.infoId = i;
    }

    public int getMarkettingId() {
        return this.markettingId;
    }

    public int getInfoId() {
        return this.infoId;
    }
}
