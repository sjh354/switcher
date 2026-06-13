package kr.switcher.switcherm.ui.switcherInfo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import kr.switcher.device.IODevice;
import kr.switcher.device.switcher.interfaces.IODeviceCallbacks;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.activity.IOActivity;
import kr.switcher.switcherm.common.util.IOLog;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.databinding.ActivitySwitcherInfoBinding;
import kr.switcher.switcherm.device.IODeviceHandler;
import kr.switcher.switcherm.preference.OAuthToken;
import kr.switcher.switcherm.ui.main.MainActivity;
import kr.switcher.switcherm.ui.switcherInfo.fragments.BuyingTypeChangeFragment;
import kr.switcher.switcherm.ui.switcherInfo.fragments.ContractFragment;
import kr.switcher.switcherm.ui.switcherInfo.fragments.DeliveryFragment;
import kr.switcher.switcherm.ui.switcherInfo.fragments.FreeTrialFragment;
import kr.switcher.switcherm.ui.switcherInfo.fragments.PaymentCardChangeFragment;
import kr.switcher.switcherm.ui.switcherInfo.fragments.PaymentCardInfoFragment;
import kr.switcher.switcherm.ui.switcherInfo.fragments.PostCodeFragment;
import kr.switcher.switcherm.ui.switcherInfo.fragments.ProductionFragment;
import kr.switcher.switcherm.ui.switcherInfo.fragments.RemoconInfoFragment;
import kr.switcher.switcherm.ui.switcherInfo.fragments.RentalPlanFragment;
import kr.switcher.switcherm.ui.switcherInfo.fragments.RentalPlanFreeFragment;
import kr.switcher.switcherm.ui.switcherInfo.fragments.ReturnBooking2Fragment;
import kr.switcher.switcherm.ui.switcherInfo.fragments.ReturnBookingFragment;
import kr.switcher.switcherm.ui.switcherInfo.fragments.ReturnConfirmFragment;
import kr.switcher.switcherm.ui.switcherInfo.fragments.ReturnInfoFragment;
import kr.switcher.switcherm.ui.switcherInfo.fragments.SwitcherInfoMainFragment;
import kr.switcher.switcherm.ui.switcherInfo.fragments.WholesaleFragment;
import kr.switcher.switcherm.ui.switcherInfo.helper.SwitcherInfoHelper;
import kr.switcher.switcherm.ui.switcherInfo.interactors.FindSwitcherInfoInteractor;
import kr.switcher.switcherm.ui.switcherInfo.presenters.SwitcherInfoPresenter;
import kr.switcher.switcherm.ui.switcherInfo.views.SwitcherInfoView;
import kr.switcher.switcherm.ui.switcherList.SwitcherListActivity;
import kr.switcher.switcherm.viewmodel.SwitcherInfoActivityViewModel;

/* JADX INFO: loaded from: classes2.dex */
public class SwitcherInfoActivity extends IOActivity implements SwitcherInfoView {
    public static final String PARM_CONNECTED_MAC_ADDRESS = "CONNECTED_MAC_ADDRESS";
    public static final String PARM_FREE_TRIAL_ID = "REQUEST_ID";
    public static final String PARM_IS_IO_CASH_PROMOTION = "IS_IO_CASH_PROMOTION";
    public static final String PARM_PRODUCT_ID = "PRODUCT_ID";
    public static final int RES_COMPLETE_SWITCHER_INFO = 301;
    private static final String TAG = "SwitcherInfoActivity";
    private ActivitySwitcherInfoBinding binder;
    private BuyingTypeChangeFragment buyingTypeChangeFragment;
    private String connectedMacAddress;
    private ContractFragment contractFragment;
    private DeliveryFragment deliveryFragment;
    private FreeTrialFragment freeTrialFragment;
    private SwitcherInfoHelper helper;
    private IODevice ioDevice;
    private String isCashDiscount;
    private boolean isDiscountCustomer = false;
    private String macAddressForCardChange;
    private int myCardId;
    private PaymentCardChangeFragment paymentCardChangeFragment;
    private PaymentCardInfoFragment paymentCardInfoFragment;
    private RentalPlanFragment planFragment;
    private RentalPlanFreeFragment planFreeFragment;
    private PostCodeFragment postCodeFragment;
    private SwitcherInfoPresenter presenter;
    private ProductionFragment productionFragment;
    private RemoconInfoFragment remoconInfoFragment;
    private ReturnBooking2Fragment returnBooking2Fragment;
    private ReturnBookingFragment returnBookingFragment;
    private ReturnConfirmFragment returnConfirmFragment;
    private ReturnInfoFragment returnInfoFragment;
    private SwitcherInfoMainFragment switcherInfoMainFragment;
    private SwitcherInfoActivityViewModel viewModel;
    private WholesaleFragment wholesaleFragment;

    public interface FinishActivityListener {
        void onFinishActivity();
    }

    public interface ReturnCompleteListener {
        void onReturnComplete(String str);
    }

    @Override // kr.switcher.switcherm.ui.switcherInfo.views.SwitcherInfoView
    public void movePlanFreeFragment() {
    }

    public void onPlanMenuButtonClicked(View view) {
    }

    @Override // kr.switcher.switcherm.common.activity.IOActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.binder = (ActivitySwitcherInfoBinding) DataBindingUtil.setContentView(this, R.layout.activity_switcher_info);
        SwitcherInfoActivityViewModel switcherInfoActivityViewModel = new SwitcherInfoActivityViewModel(SwitcherInfoActivityViewModel.MENU_SWITCHER_INFO_MAIN);
        this.viewModel = switcherInfoActivityViewModel;
        this.binder.setViewModel(switcherInfoActivityViewModel);
        this.helper = new SwitcherInfoHelper();
        this.connectedMacAddress = getIntent().getStringExtra("CONNECTED_MAC_ADDRESS");
        this.ioDevice = IODeviceHandler.getInstance().getDevice(this.connectedMacAddress);
        int intExtra = getIntent().getIntExtra(PARM_FREE_TRIAL_ID, 0);
        this.macAddressForCardChange = getIntent().getStringExtra(SwitcherListActivity.INTENT_PARM_MAC_ADDRESS_FOR_CARD);
        this.isCashDiscount = getIntent().getStringExtra(PARM_IS_IO_CASH_PROMOTION);
        this.presenter = new SwitcherInfoPresenter(this, new FindSwitcherInfoInteractor(this, this.ioDevice));
        this.switcherInfoMainFragment = SwitcherInfoMainFragment.newInstance(this.connectedMacAddress);
        this.productionFragment = ProductionFragment.newInstance(IODeviceHandler.getInstance().getPreparing(intExtra));
        this.deliveryFragment = DeliveryFragment.newInstance(this.connectedMacAddress);
        this.returnInfoFragment = ReturnInfoFragment.newInstance();
        this.returnConfirmFragment = ReturnConfirmFragment.newInstance(this.connectedMacAddress);
        this.returnBookingFragment = ReturnBookingFragment.newInstance(this.connectedMacAddress, getReturnCompleteListenerForReturnBooking());
        this.returnBooking2Fragment = ReturnBooking2Fragment.newInstance(this.connectedMacAddress, getReturnCompleteListenerForReturnBooking2());
        this.paymentCardInfoFragment = PaymentCardInfoFragment.newInstance(this.connectedMacAddress);
        this.paymentCardChangeFragment = PaymentCardChangeFragment.newInstance(this.connectedMacAddress);
        this.planFragment = RentalPlanFragment.newInstance(this.connectedMacAddress);
        this.planFreeFragment = RentalPlanFreeFragment.newInstance(this.connectedMacAddress);
        this.postCodeFragment = PostCodeFragment.newInstance(getReturnCompleteListenerForPostCode());
        this.wholesaleFragment = WholesaleFragment.newInstance(this.connectedMacAddress);
        this.freeTrialFragment = FreeTrialFragment.newInstance(this.connectedMacAddress);
        this.contractFragment = ContractFragment.newInstance(this.connectedMacAddress);
        this.buyingTypeChangeFragment = BuyingTypeChangeFragment.newInstance(this.connectedMacAddress);
        this.remoconInfoFragment = RemoconInfoFragment.newInstance(this.connectedMacAddress, getFinishActivityListener());
        this.presenter.onCreate(IODeviceHandler.getInstance().getDevice(this.connectedMacAddress), this.macAddressForCardChange);
    }

    @Override // kr.switcher.switcherm.ui.switcherInfo.views.SwitcherInfoView
    public void show() {
        IODevice iODevice = this.ioDevice;
        if (iODevice != null) {
            this.presenter.show(iODevice.getOption().getPaymentInfo().getType(), this.ioDevice.getOption().getShipping().getStatus(), this.ioDevice.getOption().getPaymentInfo().getPaymentMethod(), this.ioDevice.getOption().getPaymentInfo().getStatus());
        } else {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void moveFragment(Fragment fragment, String str, String str2) {
        this.viewModel.setState(str2);
        FragmentTransaction fragmentTransactionBeginTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransactionBeginTransaction.replace(R.id.container, fragment, str);
        try {
            fragmentTransactionBeginTransaction.commit();
        } catch (Exception e) {
            IOLog.error(TAG, new OAuthToken().getOAuthToken(), "moveWifiConnectFragment", e);
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        this.presenter.onBackPressed(this);
    }

    @Override // kr.switcher.switcherm.ui.switcherInfo.views.SwitcherInfoView
    public void finishActivity() {
        setResult(301, new Intent(this, (Class<?>) MainActivity.class));
        finish();
    }

    @Override // kr.switcher.switcherm.ui.switcherInfo.views.SwitcherInfoView
    public void showMessage(String str) {
        IOUtil.showToast(str);
    }

    public void onLeftButtonClicked(View view) {
        onBackPressed();
    }

    public void onReturnButtonClicked(View view) {
        this.presenter.onReturnButtonClicked(IODeviceHandler.getInstance().getDevice(this.connectedMacAddress));
    }

    public void onDeliveryButtonClicked(View view) {
        this.presenter.onDeliveryButtonClicked(IODeviceHandler.getInstance().getDevice(this.connectedMacAddress));
    }

    public void onReturnCompletedBookingButtonClicked(View view) {
        this.returnBooking2Fragment.onReturnCompletedBookingButtonClicked();
    }

    public void onReturnConfirmButtonClicked(View view) {
        this.returnConfirmFragment.onReturnConfirmButtonClicked();
        onBackPressed();
    }

    public void onOtherDeliveryButtonClicked(View view) {
        IOLog.activity(IOUtil.getStringResource(R.string.screen_title_5_0_2_2_1));
    }

    public void onPaymentCardMenuButtonClicked(View view) {
        moveFragment(this.paymentCardInfoFragment, "PaymentCardInfoFragment", SwitcherInfoActivityViewModel.MENU_PAYMENT_CARD_INFO);
    }

    public void onCardChangeButtonClicked(View view) {
        moveFragment(this.paymentCardChangeFragment, "PaymentCardChangeFragment", SwitcherInfoActivityViewModel.MENU_PAYMENT_CARD_CHANGE);
    }

    public void onPlan1Checked(View view) {
        this.planFreeFragment.onPlan1Checked();
    }

    public void onPlan2Checked(View view) {
        this.planFreeFragment.onPlan2Checked();
    }

    public void onPlan3Checked(View view) {
        this.planFreeFragment.onPlan3Checked();
    }

    public void onPlan4Checked(View view) {
        this.planFreeFragment.onPlan4Checked();
    }

    public void onChangePlanButtonClicked(View view) {
        this.planFreeFragment.onChangePlanButtonClicked(new IODeviceCallbacks.OnChangePaymentPlanInfoResultCallback() { // from class: kr.switcher.switcherm.ui.switcherInfo.SwitcherInfoActivity.1
            @Override // kr.switcher.device.switcher.interfaces.IODeviceCallbacks.OnChangePaymentPlanInfoResultCallback
            public void onPaymentPlanResult(boolean z) {
                if (z) {
                    SwitcherInfoActivity.this.onBackPressed();
                }
            }
        });
    }

    public void onConfirmCardChangeButtonClicked(View view) {
        int i = this.myCardId;
        if (i != 0) {
            this.paymentCardChangeFragment.setMyCardId(i);
        }
        this.paymentCardChangeFragment.onConfirmCardChangeButtonClicked(new IODeviceCallbacks.OnCardChangeResultCallback() { // from class: kr.switcher.switcherm.ui.switcherInfo.SwitcherInfoActivity.2
            @Override // kr.switcher.device.switcher.interfaces.IODeviceCallbacks.OnCardChangeResultCallback
            public void onCardChangeResult(boolean z) {
                if (z) {
                    SwitcherInfoActivity.this.onBackPressed();
                }
            }
        });
    }

    public void onMovePostCodeButtonClicked(View view) {
        moveFragment(this.postCodeFragment, "PostCodeFragment", SwitcherInfoActivityViewModel.MENU_POST_CODE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ReturnCompleteListener getReturnCompleteListenerForReturnBooking() {
        return new ReturnCompleteListener() { // from class: kr.switcher.switcherm.ui.switcherInfo.SwitcherInfoActivity.3
            @Override // kr.switcher.switcherm.ui.switcherInfo.SwitcherInfoActivity.ReturnCompleteListener
            public void onReturnComplete(String str) {
                SwitcherInfoActivity switcherInfoActivity = SwitcherInfoActivity.this;
                switcherInfoActivity.moveFragment(switcherInfoActivity.returnBooking2Fragment, "ReturnBooking2Fragment", SwitcherInfoActivityViewModel.MENU_RETURN_BOOKING2);
            }
        };
    }

    private ReturnCompleteListener getReturnCompleteListenerForReturnBooking2() {
        return new ReturnCompleteListener() { // from class: kr.switcher.switcherm.ui.switcherInfo.SwitcherInfoActivity.4
            @Override // kr.switcher.switcherm.ui.switcherInfo.SwitcherInfoActivity.ReturnCompleteListener
            public void onReturnComplete(String str) {
                SwitcherInfoActivity switcherInfoActivity = SwitcherInfoActivity.this;
                switcherInfoActivity.moveFragment(switcherInfoActivity.returnConfirmFragment, "ReturnConfirmFragment", SwitcherInfoActivityViewModel.MENU_RETURN_CONFIRM);
            }
        };
    }

    private ReturnCompleteListener getReturnCompleteListenerForPostCode() {
        return new ReturnCompleteListener() { // from class: kr.switcher.switcherm.ui.switcherInfo.SwitcherInfoActivity.5
            @Override // kr.switcher.switcherm.ui.switcherInfo.SwitcherInfoActivity.ReturnCompleteListener
            public void onReturnComplete(String str) {
                if (str == null) {
                    return;
                }
                SwitcherInfoActivity switcherInfoActivity = SwitcherInfoActivity.this;
                switcherInfoActivity.returnBookingFragment = ReturnBookingFragment.newInstance(switcherInfoActivity.connectedMacAddress, SwitcherInfoActivity.this.helper.getPostNumberByWebView(str), SwitcherInfoActivity.this.helper.getAddressByWebView(str), SwitcherInfoActivity.this.getReturnCompleteListenerForReturnBooking());
                SwitcherInfoActivity switcherInfoActivity2 = SwitcherInfoActivity.this;
                switcherInfoActivity2.moveFragment(switcherInfoActivity2.returnBookingFragment, "ReturnBookingFragment", SwitcherInfoActivityViewModel.MENU_RETURN_BOOKING);
            }
        };
    }

    private FinishActivityListener getFinishActivityListener() {
        return new FinishActivityListener() { // from class: kr.switcher.switcherm.ui.switcherInfo.SwitcherInfoActivity.6
            @Override // kr.switcher.switcherm.ui.switcherInfo.SwitcherInfoActivity.FinishActivityListener
            public void onFinishActivity() {
                SwitcherInfoActivity.this.finishActivity();
            }
        };
    }

    @Override // kr.switcher.switcherm.ui.switcherInfo.views.SwitcherInfoView
    public void moveFreeTrialView() {
        moveFragment(this.freeTrialFragment, "FreeTrialFragment", SwitcherInfoActivityViewModel.MENU_FREE_TRIAL);
    }

    @Override // kr.switcher.switcherm.ui.switcherInfo.views.SwitcherInfoView
    public void moveWholeSaleView() {
        moveFragment(this.wholesaleFragment, "WholesaleFragment", SwitcherInfoActivityViewModel.MENU_CONSIGNMENT);
    }

    @Override // kr.switcher.switcherm.ui.switcherInfo.views.SwitcherInfoView
    public void moveRentalPreSaleView() {
        moveFragment(this.productionFragment, "ProductionFragment", SwitcherInfoActivityViewModel.MENU_PRODUCTION);
    }

    @Override // kr.switcher.switcherm.ui.switcherInfo.views.SwitcherInfoView
    public void moveRentalDeliveryCompletedView() {
        moveFragment(this.deliveryFragment, "DeliveryFragment", SwitcherInfoActivityViewModel.MENU_DELIVERY);
    }

    @Override // kr.switcher.switcherm.ui.switcherInfo.views.SwitcherInfoView
    public void moveRentalReturningView() {
        moveFragment(this.switcherInfoMainFragment, "SwitcherInfoMainFragment", SwitcherInfoActivityViewModel.MENU_SWITCHER_INFO_MAIN);
    }

    @Override // kr.switcher.switcherm.ui.switcherInfo.views.SwitcherInfoView
    public void moveRentalCompletedView() {
        moveFragment(this.switcherInfoMainFragment, "SwitcherInfoMainFragment", SwitcherInfoActivityViewModel.MENU_SWITCHER_INFO_MAIN);
    }

    @Override // kr.switcher.switcherm.ui.switcherInfo.views.SwitcherInfoView
    public void moveRentalUsingView() {
        moveFragment(this.switcherInfoMainFragment, "SwitcherInfoMainFragment", SwitcherInfoActivityViewModel.MENU_SWITCHER_INFO_MAIN);
        refreshSwitcherInfoMainFragment();
    }

    private void refreshSwitcherInfoMainFragment() {
        this.switcherInfoMainFragment.refreshView();
    }

    @Override // kr.switcher.switcherm.ui.switcherInfo.views.SwitcherInfoView
    public void moveReturnBookingFragment() {
        moveFragment(this.returnBookingFragment, "ReturnBookingFragment", SwitcherInfoActivityViewModel.MENU_RETURN_BOOKING);
    }

    @Override // kr.switcher.switcherm.ui.switcherInfo.views.SwitcherInfoView
    public void movePaymentCardInfoFragment() {
        moveFragment(this.paymentCardInfoFragment, "PaymentCardInfoFragment", SwitcherInfoActivityViewModel.MENU_PAYMENT_CARD_INFO);
    }

    @Override // kr.switcher.switcherm.ui.switcherInfo.views.SwitcherInfoView
    public boolean isDiscount() {
        return this.isDiscountCustomer;
    }

    @Override // kr.switcher.switcherm.ui.switcherInfo.views.SwitcherInfoView
    public void moveReturnInfoFragment() {
        moveFragment(this.returnInfoFragment, "ReturnInfoFragment", SwitcherInfoActivityViewModel.MENU_RETURN_INFO);
    }

    @Override // kr.switcher.switcherm.ui.switcherInfo.views.SwitcherInfoView
    public void movePlanFragment() {
        moveFragment(this.planFragment, "RentalPlanFragment", SwitcherInfoActivityViewModel.MENU_PLAN);
    }

    @Override // kr.switcher.switcherm.ui.switcherInfo.views.SwitcherInfoView
    public void moveBuyingTypeChangeFragment() {
        moveFragment(this.buyingTypeChangeFragment, "BuyingTypeChangeFragment", SwitcherInfoActivityViewModel.MENU_BUYING_TYPE_CHANGE);
    }

    @Override // kr.switcher.switcherm.ui.switcherInfo.views.SwitcherInfoView
    public void moveContractView() {
        moveFragment(this.contractFragment, "ContractFragment", SwitcherInfoActivityViewModel.MENU_CONTRACT);
    }

    @Override // kr.switcher.switcherm.ui.switcherInfo.views.SwitcherInfoView
    public void moveRemoconInfoView() {
        moveFragment(this.remoconInfoFragment, "RemoconInfoFragment", SwitcherInfoActivityViewModel.MENU_REMOCON);
    }

    public void setMyCardId(int i) {
        this.myCardId = i;
    }

    public int getMyCardId() {
        return this.myCardId;
    }

    public boolean getIsDiscountCustomer() {
        return this.isDiscountCustomer;
    }

    public void setDiscountCustomer(boolean z) {
        this.isDiscountCustomer = z;
    }
}
