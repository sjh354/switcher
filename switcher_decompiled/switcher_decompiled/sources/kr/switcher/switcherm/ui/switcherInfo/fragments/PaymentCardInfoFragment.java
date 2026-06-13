package kr.switcher.switcherm.ui.switcherInfo.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import java.util.List;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.util.IOLog;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.databinding.FragmentPaymentCardInfoBinding;
import kr.switcher.switcherm.network.http.RestSwitcherAPIStore;
import kr.switcher.switcherm.network.http.response.HttpResponseListHandler;
import kr.switcher.switcherm.preference.OAuthToken;
import kr.switcher.switcherm.ui.switcherInfo.SwitcherInfoActivity;
import kr.switcher.switcherm.ui.switcherInfo.adapter.PaymentCardItem;
import kr.switcher.switcherm.ui.switcherInfo.helper.SwitcherInfoJsonParser;
import kr.switcher.switcherm.user.UserStateManager;
import kr.switcher.switcherm.viewmodel.PaymentCardInfoFragmentViewModel;

/* JADX INFO: loaded from: classes2.dex */
public class PaymentCardInfoFragment extends Fragment {
    private static final String TAG = "PaymentCardInfoFragment";
    private FragmentPaymentCardInfoBinding binder;
    private String connectedMacAddress;
    private boolean isDiscountCustomer;
    private int myCardId;
    private PaymentCardInfoFragmentViewModel viewModel;

    public static PaymentCardInfoFragment newInstance(String str) {
        PaymentCardInfoFragment paymentCardInfoFragment = new PaymentCardInfoFragment();
        Bundle bundle = new Bundle();
        bundle.putString("CONNECTED_MAC_ADDRESS", str);
        paymentCardInfoFragment.setArguments(bundle);
        return paymentCardInfoFragment;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.binder = (FragmentPaymentCardInfoBinding) DataBindingUtil.inflate(layoutInflater, R.layout.fragment_payment_card_info, viewGroup, false);
        if (UserStateManager.getInstance().getCurrentUserFromDB() == null) {
            IOUtil.showToast(IOUtil.getStringResource(R.string.not_found_user));
            getActivity().finish();
            return null;
        }
        PaymentCardInfoFragmentViewModel paymentCardInfoFragmentViewModel = new PaymentCardInfoFragmentViewModel();
        this.viewModel = paymentCardInfoFragmentViewModel;
        this.binder.setViewModel(paymentCardInfoFragmentViewModel);
        hideCardDiscountInfo();
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.connectedMacAddress = arguments.getString("CONNECTED_MAC_ADDRESS");
        }
        requestGetPaymentCards();
        return this.binder.getRoot();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        IOLog.activity(IOUtil.getStringResource(R.string.screen_title_5_0_2_3_0));
    }

    private void requestGetPaymentCards() {
        RestSwitcherAPIStore.requestGetCreditCardMe(new HttpResponseListHandler() { // from class: kr.switcher.switcherm.ui.switcherInfo.fragments.PaymentCardInfoFragment.1
            @Override // kr.switcher.switcherm.network.http.response.HttpResponseListHandler
            public void onSuccess(List list) {
                IOLog.i(PaymentCardInfoFragment.TAG, "response get price models json : " + list);
                try {
                    PaymentCardItem getMainPaymentCard = SwitcherInfoJsonParser.parseGetMainPaymentCard(list);
                    PaymentCardInfoFragment.this.myCardId = getMainPaymentCard.getCardId();
                    ((SwitcherInfoActivity) PaymentCardInfoFragment.this.getActivity()).setMyCardId(PaymentCardInfoFragment.this.myCardId);
                    PaymentCardInfoFragment.this.viewModel.viewData(getMainPaymentCard.getPaymentCardName(), getMainPaymentCard.getCardNumber());
                    if (getMainPaymentCard.getPaymentCardName().equals("기본등록")) {
                        PaymentCardInfoFragment.this.showCardDiscountInfo();
                        ((SwitcherInfoActivity) PaymentCardInfoFragment.this.getActivity()).setDiscountCustomer(true);
                    }
                } catch (Exception e) {
                    IOLog.error(PaymentCardInfoFragment.TAG, new OAuthToken().getOAuthToken(), "onSuccess", e);
                }
            }

            @Override // kr.switcher.switcherm.network.http.response.HttpResponseListHandler
            public void onFailure(String str, String str2) {
                IOLog.error(PaymentCardInfoFragment.TAG, new OAuthToken().getOAuthToken(), "requestGetCreditCardMe()", new Exception("code:" + str + ", message:" + str2));
            }
        });
    }

    private void hideCardDiscountInfo() {
        this.binder.tvCardDiscountInfo.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showCardDiscountInfo() {
        this.binder.tvCardDiscountInfo.setVisibility(0);
    }

    public boolean isDiscountCustomer() {
        return this.isDiscountCustomer;
    }
}
