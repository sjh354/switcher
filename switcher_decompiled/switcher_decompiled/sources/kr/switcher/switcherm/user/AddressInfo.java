package kr.switcher.switcherm.user;

/* JADX INFO: loaded from: classes2.dex */
public class AddressInfo {
    private String address1;
    private String address2;
    private String postNumber;

    public AddressInfo() {
    }

    public AddressInfo(String str, String str2, String str3) {
        this.postNumber = str;
        this.address1 = str2;
        this.address2 = str3;
    }

    public String getPostNumber() {
        return this.postNumber;
    }

    public void setPostNumber(String str) {
        this.postNumber = str;
    }

    public String getAddress1() {
        return this.address1;
    }

    public void setAddress1(String str) {
        this.address1 = str;
    }

    public String getAddress2() {
        return this.address2;
    }

    public void setAddress2(String str) {
        this.address2 = str;
    }
}
