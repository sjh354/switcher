package kr.switcher.switcherm.ui.switcherInfo.adapter;

/* JADX INFO: loaded from: classes2.dex */
public class PaymentCardItem {
    private int cardId;
    private String cardNumber;
    private String expireDate;
    private boolean isMain;
    private String paymentCardName;

    public PaymentCardItem(int i, String str, String str2, String str3, boolean z) {
        this.cardId = i;
        this.paymentCardName = str;
        this.cardNumber = str2;
        this.expireDate = str3;
        this.isMain = z;
    }

    public int getCardId() {
        return this.cardId;
    }

    public void setCardId(int i) {
        this.cardId = i;
    }

    public String getPaymentCardName() {
        return this.paymentCardName;
    }

    public void setPaymentCardName(String str) {
        this.paymentCardName = str;
    }

    public String getCardNumber() {
        return this.cardNumber;
    }

    public void setCardNumber(String str) {
        this.cardNumber = str;
    }

    public String getExpireDate() {
        return this.expireDate;
    }

    public void setExpireDate(String str) {
        this.expireDate = str;
    }

    public boolean isMain() {
        return this.isMain;
    }

    public void setIsMain(boolean z) {
        this.isMain = z;
    }
}
