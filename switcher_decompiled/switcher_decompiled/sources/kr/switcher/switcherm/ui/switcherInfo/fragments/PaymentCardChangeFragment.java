package kr.switcher.switcherm.ui.switcherInfo.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.SpinnerAdapter;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import java.util.ArrayList;
import java.util.List;
import kr.switcher.device.IODevice;
import kr.switcher.device.switcher.interfaces.IODeviceCallbacks;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.util.IOLog;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.databinding.FragmentPaymentCardChangeBinding;
import kr.switcher.switcherm.device.IODeviceHandler;
import kr.switcher.switcherm.device.switcher.handler.SwitcherHandler;
import kr.switcher.switcherm.user.UserStateManager;
import kr.switcher.switcherm.viewmodel.PaymentCardChangeFragmentViewModel;

/* JADX INFO: loaded from: classes2.dex */
public class PaymentCardChangeFragment extends Fragment {
    private static final int CARD_NUMBER_LENGTH = 15;
    private static final int EXPIRED_MONTH_LENGTH = 2;
    private static final int EXPIRED_YEAR_LENGTH = 4;
    private static final String TAG = "PaymentCardChangeFragment";
    private FragmentPaymentCardChangeBinding binder;
    private IODevice ioDevice;
    private int myCardId;
    private PaymentCardChangeFragmentViewModel viewModel;

    public static PaymentCardChangeFragment newInstance(String str) {
        PaymentCardChangeFragment paymentCardChangeFragment = new PaymentCardChangeFragment();
        Bundle bundle = new Bundle();
        bundle.putString("CONNECTED_MAC_ADDRESS", str);
        paymentCardChangeFragment.setArguments(bundle);
        return paymentCardChangeFragment;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.binder = (FragmentPaymentCardChangeBinding) DataBindingUtil.inflate(layoutInflater, R.layout.fragment_payment_card_change, viewGroup, false);
        if (UserStateManager.getInstance().getCurrentUserFromDB() == null) {
            IOUtil.showToast(IOUtil.getStringResource(R.string.not_found_user));
            getActivity().finish();
            return null;
        }
        PaymentCardChangeFragmentViewModel paymentCardChangeFragmentViewModel = new PaymentCardChangeFragmentViewModel();
        this.viewModel = paymentCardChangeFragmentViewModel;
        this.binder.setViewModel(paymentCardChangeFragmentViewModel);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.ioDevice = IODeviceHandler.getInstance().getDevice(arguments.getString("CONNECTED_MAC_ADDRESS"));
        }
        initResource();
        return this.binder.getRoot();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        IOLog.activity(IOUtil.getStringResource(R.string.screen_title_5_0_2_3_0));
    }

    private void initResource() {
        requestGetCardCompanies();
        setValidityMonthData();
        setValidityYearData();
        this.viewModel.setCompaniesSpinner(this.binder.spCompanies);
        this.viewModel.setValidityMonthSpinner(this.binder.spValidityMonth);
        this.viewModel.setValidityYearSpinner(this.binder.spValidityYear);
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.binder.etCardNumber1);
        arrayList.add(this.binder.etCardNumber2);
        arrayList.add(this.binder.etCardNumber3);
        arrayList.add(this.binder.etCardNumber4);
        this.viewModel.setHighlightAndFocusEditTextBox(arrayList);
    }

    private void requestGetCardCompanies() {
        SwitcherHandler.getInstance().getCardCompaniesFromRestServer(new IODeviceCallbacks.OnGetCardCompaniesCallback() { // from class: kr.switcher.switcherm.ui.switcherInfo.fragments.PaymentCardChangeFragment.1
            @Override // kr.switcher.device.switcher.interfaces.IODeviceCallbacks.OnGetCardCompaniesCallback
            public void onCardCompaniesResult(List<String> list) {
                ArrayAdapter arrayAdapter = new ArrayAdapter(PaymentCardChangeFragment.this.getContext(), R.layout.item_spinner_card_change, list);
                arrayAdapter.setDropDownViewResource(R.layout.item_spinner_drop_down_list);
                PaymentCardChangeFragment.this.binder.spCompanies.setAdapter((SpinnerAdapter) arrayAdapter);
                arrayAdapter.notifyDataSetChanged();
            }
        });
    }

    private void setValidityMonthData() {
        ArrayAdapter arrayAdapter = new ArrayAdapter(getContext(), R.layout.item_spinner_card_change, IOUtil.getMonths());
        arrayAdapter.setDropDownViewResource(R.layout.item_spinner_drop_down_list);
        this.binder.spValidityMonth.setAdapter((SpinnerAdapter) arrayAdapter);
        arrayAdapter.notifyDataSetChanged();
    }

    private void setValidityYearData() {
        ArrayAdapter arrayAdapter = new ArrayAdapter(getContext(), R.layout.item_spinner_card_change, IOUtil.getValidityYears());
        arrayAdapter.setDropDownViewResource(R.layout.item_spinner_drop_down_list);
        this.binder.spValidityYear.setAdapter((SpinnerAdapter) arrayAdapter);
        arrayAdapter.notifyDataSetChanged();
    }

    private boolean checkIsInvalidData(String str, String str2, String str3, String str4) {
        if (str == null || str.equals("")) {
            IOUtil.showToast(IOUtil.getStringResource(R.string.propose_card_company_select_message));
            return false;
        }
        if (str2 == null || str2.length() < 15) {
            IOUtil.showToast(IOUtil.getStringResource(R.string.propose_card_number_edit_message));
            return false;
        }
        if (str3 == null || str3.length() != 4) {
            IOUtil.showToast(IOUtil.getStringResource(R.string.propose_expired_date_edit_message));
            return false;
        }
        if (str4 != null && str4.length() == 2) {
            return true;
        }
        IOUtil.showToast(IOUtil.getStringResource(R.string.propose_expired_date_edit_message));
        return false;
    }

    public void onConfirmCardChangeButtonClicked(final IODeviceCallbacks.OnCardChangeResultCallback onCardChangeResultCallback) {
        String company = this.viewModel.getCompany();
        String str = this.binder.etCardNumber1.getText().toString() + this.binder.etCardNumber2.getText().toString() + this.binder.etCardNumber3.getText().toString() + this.binder.etCardNumber4.getText().toString();
        String validityYear = this.viewModel.getValidityYear();
        String validityMonth = this.viewModel.getValidityMonth();
        if (checkIsInvalidData(company, str, validityYear, validityMonth)) {
            IOLog.i(TAG, "card change : \ncompany : " + company + "\ncardNumber : " + str + "\nexpireDate : " + validityMonth + validityYear);
            SwitcherHandler.getInstance().setCreditCardToRestServer(getCardId(), company, str, validityMonth, validityYear, new IODeviceCallbacks.OnSetCreditCardCallback() { // from class: kr.switcher.switcherm.ui.switcherInfo.fragments.PaymentCardChangeFragment.2
                @Override // kr.switcher.device.switcher.interfaces.IODeviceCallbacks.OnSetCreditCardCallback
                public void onCreditCardResult(boolean z) {
                    if (z) {
                        onCardChangeResultCallback.onCardChangeResult(z);
                    }
                }
            });
        }
    }

    private int getCardId() {
        int i = this.myCardId;
        return i != 0 ? i : this.ioDevice.getOption().getPaymentInfo().getCardId();
    }

    public void setMyCardId(int i) {
        this.myCardId = i;
    }
}
