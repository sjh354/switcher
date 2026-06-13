package kr.switcher.switcherm.ui.switcherInfo.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import java.util.List;
import kr.switcher.device.switcher.Switcher;
import kr.switcher.device.switcher.interfaces.IODeviceCallbacks;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.util.IOLog;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.databinding.FragmentRentalPlanFreeBinding;
import kr.switcher.switcherm.device.switcher.handler.SwitcherHandler;
import kr.switcher.switcherm.ui.switcherInfo.adapter.PlanItem;
import kr.switcher.switcherm.ui.switcherInfo.helper.ConverterPricingModelDBToPlanItem;
import kr.switcher.switcherm.user.UserStateManager;
import kr.switcher.switcherm.viewmodel.PlanFreeFragmentViewModel;

/* JADX INFO: loaded from: classes2.dex */
public class RentalPlanFreeFragment extends Fragment {
    private static final String TAG = "RentalPlanFreeFragment";
    private FragmentRentalPlanFreeBinding binder;
    private String connectedMacAddress;
    private PlanFreeFragmentViewModel viewModel;

    public static RentalPlanFreeFragment newInstance(String str) {
        RentalPlanFreeFragment rentalPlanFreeFragment = new RentalPlanFreeFragment();
        Bundle bundle = new Bundle();
        bundle.putString("CONNECTED_MAC_ADDRESS", str);
        rentalPlanFreeFragment.setArguments(bundle);
        return rentalPlanFreeFragment;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.binder = (FragmentRentalPlanFreeBinding) DataBindingUtil.inflate(layoutInflater, R.layout.fragment_rental_plan_free, viewGroup, false);
        if (UserStateManager.getInstance().getCurrentUserFromDB() == null) {
            IOUtil.showToast(IOUtil.getStringResource(R.string.not_found_user));
            getActivity().finish();
            return null;
        }
        PlanFreeFragmentViewModel planFreeFragmentViewModel = new PlanFreeFragmentViewModel(this.binder);
        this.viewModel = planFreeFragmentViewModel;
        this.binder.setViewModel(planFreeFragmentViewModel);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.connectedMacAddress = arguments.getString("CONNECTED_MAC_ADDRESS");
        }
        setPricingModels();
        return this.binder.getRoot();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        IOLog.activity(IOUtil.getStringResource(R.string.screen_title_5_0_2_0_0));
    }

    private void setPricingModels() {
        Switcher switcher = SwitcherHandler.getInstance().getSwitcher(this.connectedMacAddress);
        if (switcher == null) {
            IOUtil.showToast(IOUtil.getStringResource(R.string.etc_error));
            getActivity().finish();
        } else {
            setPlanListView(new ConverterPricingModelDBToPlanItem().setMainPlanCode(switcher.getDeviceOption().getPaymentInfo().getPaymentMethod()).getPlanItems());
        }
    }

    private void setPlanListView(List<PlanItem> list) {
        this.viewModel.viewData("매월 플랜", "매달 1,800원 결제", "", "", list.get(0).isMain());
        this.viewModel.viewData("1년 플랜", "1년 마다 17,000원 결제", "1,430원/월", "20% 할인", list.get(1).isMain());
        this.viewModel.viewData("2년 플랜", "2년 마다 28,000원 결제", "1,170원/월", "35% 할인", list.get(2).isMain());
        this.viewModel.viewData("3년 플랜", "3년 마다 35,500원 결제", "990원/월", "45% 할인", list.get(3).isMain());
    }

    public void onPlan1Checked() {
        this.viewModel.checkPlan(1);
    }

    public void onPlan2Checked() {
        this.viewModel.checkPlan(2);
    }

    public void onPlan3Checked() {
        this.viewModel.checkPlan(3);
    }

    public void onPlan4Checked() {
        this.viewModel.checkPlan(4);
    }

    public void onChangePlanButtonClicked(final IODeviceCallbacks.OnChangePaymentPlanInfoResultCallback onChangePaymentPlanInfoResultCallback) {
        SwitcherHandler.getInstance().changePayPlanToRestServer(this.connectedMacAddress, this.viewModel.getCheckedPlan(), new IODeviceCallbacks.OnChangePaymentPlanInfoResultCallback() { // from class: kr.switcher.switcherm.ui.switcherInfo.fragments.RentalPlanFreeFragment.1
            @Override // kr.switcher.device.switcher.interfaces.IODeviceCallbacks.OnChangePaymentPlanInfoResultCallback
            public void onPaymentPlanResult(boolean z) {
                if (z) {
                    IOUtil.showToast(IOUtil.getStringResource(R.string.changed_payment_plan_message));
                    onChangePaymentPlanInfoResultCallback.onPaymentPlanResult(z);
                }
            }
        });
    }
}
