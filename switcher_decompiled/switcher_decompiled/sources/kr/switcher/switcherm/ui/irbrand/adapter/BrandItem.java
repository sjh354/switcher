package kr.switcher.switcherm.ui.irbrand.adapter;

/* JADX INFO: loaded from: classes2.dex */
public class BrandItem {
    private String brandName;
    private int id;

    public BrandItem(int i, String str) {
        this.id = i;
        this.brandName = str;
    }

    public String getBrandName() {
        return this.brandName;
    }

    public void setBrandName(String str) {
        this.brandName = str;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int i) {
        this.id = i;
    }
}
