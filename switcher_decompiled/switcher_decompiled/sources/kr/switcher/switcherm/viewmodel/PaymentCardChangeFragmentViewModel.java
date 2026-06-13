package kr.switcher.switcherm.viewmodel;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import java.util.List;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.util.IOUtil;

/* JADX INFO: loaded from: classes2.dex */
public class PaymentCardChangeFragmentViewModel extends BaseObservable {
    private String billingTerms;
    private String cardNumber1;
    private String cardNumber2;
    private String cardNumber3;
    private String cardNumber4;
    private String company;
    private String validityMonth;
    private String validityYear;

    public PaymentCardChangeFragmentViewModel() {
        setBillingTerms(IOUtil.getStringResource(R.string.billing_terms_text));
        this.company = "";
    }

    public void setCompaniesSpinner(Spinner spinner) {
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: kr.switcher.switcherm.viewmodel.PaymentCardChangeFragmentViewModel.1
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                PaymentCardChangeFragmentViewModel.this.setCompany(adapterView.getAdapter().getItem(i).toString());
            }
        });
    }

    public void setValidityMonthSpinner(Spinner spinner) {
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: kr.switcher.switcherm.viewmodel.PaymentCardChangeFragmentViewModel.2
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                PaymentCardChangeFragmentViewModel.this.setValidityMonth(adapterView.getAdapter().getItem(i).toString());
            }
        });
    }

    public void setValidityYearSpinner(Spinner spinner) {
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: kr.switcher.switcherm.viewmodel.PaymentCardChangeFragmentViewModel.3
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                PaymentCardChangeFragmentViewModel.this.setValidityYear(adapterView.getAdapter().getItem(i).toString());
            }
        });
    }

    public void setHighlightAndFocusEditTextBox(final List<EditText> list) {
        for (final int i = 0; i < list.size(); i++) {
            EditText editText = list.get(i);
            editText.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: kr.switcher.switcherm.viewmodel.PaymentCardChangeFragmentViewModel.4
                @Override // android.view.View.OnFocusChangeListener
                public void onFocusChange(View view, boolean z) {
                    if (z) {
                        view.setBackgroundResource(R.drawable.shape_rectangle_active);
                    } else {
                        view.setBackgroundResource(R.drawable.shape_rectangle_inactive);
                    }
                }
            });
            editText.addTextChangedListener(new TextWatcher() { // from class: kr.switcher.switcherm.viewmodel.PaymentCardChangeFragmentViewModel.5
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (i + 1 >= list.size()) {
                        return;
                    }
                    EditText editText2 = (EditText) list.get(i + 1);
                    if (editable.length() == 4) {
                        editText2.requestFocus();
                    }
                }
            });
        }
    }

    @Bindable
    public String getCardNumber1() {
        return this.cardNumber1;
    }

    public void setCardNumber1(String str) {
        this.cardNumber1 = str;
        notifyPropertyChanged(3);
    }

    @Bindable
    public String getCardNumber2() {
        return this.cardNumber2;
    }

    public void setCardNumber2(String str) {
        this.cardNumber2 = str;
        notifyPropertyChanged(4);
    }

    @Bindable
    public String getCardNumber3() {
        return this.cardNumber3;
    }

    public void setCardNumber3(String str) {
        this.cardNumber3 = str;
        notifyPropertyChanged(5);
    }

    @Bindable
    public String getCardNumber4() {
        return this.cardNumber4;
    }

    public void setCardNumber4(String str) {
        this.cardNumber4 = str;
        notifyPropertyChanged(6);
    }

    public String getValidityMonth() {
        return String.format("%02d", Integer.valueOf(Integer.parseInt(this.validityMonth.split(IOUtil.getStringResource(R.string.mon))[0])));
    }

    public void setValidityMonth(String str) {
        this.validityMonth = str;
    }

    public String getValidityYear() {
        return String.format("20%02d", Integer.valueOf(Integer.parseInt(this.validityYear.split(IOUtil.getStringResource(R.string.year))[0].substring(2, 4))));
    }

    public void setValidityYear(String str) {
        this.validityYear = str;
    }

    @Bindable
    public String getBillingTerms() {
        return this.billingTerms;
    }

    public void setBillingTerms(String str) {
        this.billingTerms = str;
        notifyPropertyChanged(1);
    }

    public String getCompany() {
        return this.company;
    }

    public void setCompany(String str) {
        this.company = str;
    }
}
