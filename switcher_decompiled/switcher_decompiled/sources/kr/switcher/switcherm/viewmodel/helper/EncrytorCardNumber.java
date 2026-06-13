package kr.switcher.switcherm.viewmodel.helper;

/* JADX INFO: loaded from: classes2.dex */
public class EncrytorCardNumber {
    public static final String INVALID_CARD_NUMBER = "INVALID_CARD_NUMBER";
    private final int CARD_NUMBER_LENGTH_15 = 15;
    private final int CARD_NUMBER_LENGTH_16 = 16;

    public String encode(String str) {
        int length = str.length();
        if (15 != length && 16 != length) {
            return INVALID_CARD_NUMBER;
        }
        return str.substring(0, 4) + "********" + ("**" + str.substring(14, length));
    }
}
