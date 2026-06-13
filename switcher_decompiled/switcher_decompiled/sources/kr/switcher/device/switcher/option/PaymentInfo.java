package kr.switcher.device.switcher.option;

/* JADX INFO: loaded from: classes2.dex */
public class PaymentInfo {
    public static final String BUYING_TYPE_CONSIGNMENT = "consignment";
    public static final String BUYING_TYPE_CONTRACT = "contract";
    public static final String BUYING_TYPE_FREE_TRIAL = "free_trial";
    public static final String BUYING_TYPE_UNKNOWN = "unknown";
    public static final String CONTRACT_STATUS_BROKEN = "STATUS_BROKEN";
    public static final String CONTRACT_STATUS_FINISHED = "STATUS_FINISHED";
    public static final String CONTRACT_STATUS_ON_GOING = "STATUS_ON_GOING";
    public static final int PAYMENT_METHOD_LEASE = 1;
    public static final int PAYMENT_METHOD_LUMP_SUM = 2;
    public static final int PAYMENT_METHOD_RENTAL_1YEARLY = 4;
    public static final int PAYMENT_METHOD_RENTAL_2YEARLY = 5;
    public static final int PAYMENT_METHOD_RENTAL_3YEARLY = 6;
    public static final int PAYMENT_METHOD_RENTAL_MONTHLY = 3;
    private int buyingId;
    private int cardId;
    private String cardName;
    private String cardNumber;
    private String expirationDate;
    private String nextPayAt;
    private int paymentMethod;
    private String status;
    private String type;

    public PaymentInfo(String str) {
        this.type = str;
    }

    public String getType() {
        return this.type;
    }

    public int getBuyingId() {
        return this.buyingId;
    }

    public void setBuyingId(int i) {
        this.buyingId = i;
    }

    public void setType(String str) {
        this.type = str;
    }

    public int getPaymentMethod() {
        return this.paymentMethod;
    }

    public void setPaymentMethod(int i) {
        this.paymentMethod = i;
    }

    public String getNextPayAt() {
        return this.nextPayAt;
    }

    public void setNextPayAt(String str) {
        this.nextPayAt = str;
    }

    public int getCardId() {
        return this.cardId;
    }

    public void setCardId(int i) {
        this.cardId = i;
    }

    public String getCardName() {
        return this.cardName;
    }

    public void setCardName(String str) {
        this.cardName = str;
    }

    public String getCardNumber() {
        return this.cardNumber;
    }

    public void setCardNumber(String str) {
        this.cardNumber = str;
    }

    public String getExpirationDate() {
        return this.expirationDate;
    }

    public void setExpirationDate(String str) {
        this.expirationDate = str;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String str) {
        this.status = str;
    }
}
