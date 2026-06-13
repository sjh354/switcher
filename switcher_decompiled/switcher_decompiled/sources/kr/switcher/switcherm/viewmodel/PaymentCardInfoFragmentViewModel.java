package kr.switcher.switcherm.viewmodel;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import java.util.ArrayList;
import java.util.List;
import kr.switcher.switcherm.viewmodel.helper.EncrytorCardNumber;

/* JADX INFO: loaded from: classes2.dex */
public class PaymentCardInfoFragmentViewModel extends BaseObservable {
    private String cardCompany;
    private List<String> cardNumbers;

    public void viewData(String str, String str2) {
        String strEncode = new EncrytorCardNumber().encode(str2);
        if (EncrytorCardNumber.INVALID_CARD_NUMBER.equals(strEncode)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        int length = strEncode.length();
        arrayList.add(strEncode.substring(0, 4));
        arrayList.add(strEncode.substring(4, 8));
        arrayList.add(strEncode.substring(8, 12));
        arrayList.add(strEncode.substring(12, length));
        setCardCompany(str);
        setCardNumbers(arrayList);
    }

    @Bindable
    public String getCardCompany() {
        return this.cardCompany;
    }

    public void setCardCompany(String str) {
        this.cardCompany = str;
        notifyPropertyChanged(2);
    }

    @Bindable
    public List<String> getCardNumbers() {
        return this.cardNumbers;
    }

    public void setCardNumbers(List<String> list) {
        this.cardNumbers = list;
        notifyPropertyChanged(7);
    }
}
