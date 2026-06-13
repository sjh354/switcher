package kr.switcher.switcherm.ui.switcherInfo.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import kr.switcher.device.IODevice;
import kr.switcher.device.IODeviceConfig;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.databinding.FragmentSwitcherInfoMainBinding;
import kr.switcher.switcherm.device.IODeviceHandler;
import kr.switcher.switcherm.ui.switcherInfo.helper.SwitcherInfoHelper;
import kr.switcher.switcherm.ui.switcherInfo.interactors.FindSwitcherInfoInteractor;
import kr.switcher.switcherm.ui.switcherInfo.presenters.SwitcherInfoMainPresenter;
import kr.switcher.switcherm.ui.switcherInfo.views.SwitcherInfoMainView;
import kr.switcher.switcherm.user.UserStateManager;
import kr.switcher.switcherm.viewmodel.SwitcherInfoMainFragmentViewModel;

/* JADX INFO: loaded from: classes2.dex */
public class SwitcherInfoMainFragment extends Fragment implements SwitcherInfoMainView {
    private static final String TAG = "SwitcherInfoMainFragment";
    private FragmentSwitcherInfoMainBinding binder;
    private String connectedMacAddress;
    private SwitcherInfoMainPresenter presenter;
    private SwitcherInfoMainFragmentViewModel viewModel;

    public static SwitcherInfoMainFragment newInstance(String str) {
        SwitcherInfoMainFragment switcherInfoMainFragment = new SwitcherInfoMainFragment();
        Bundle bundle = new Bundle();
        bundle.putString("CONNECTED_MAC_ADDRESS", str);
        switcherInfoMainFragment.setArguments(bundle);
        return switcherInfoMainFragment;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        IODevice device;
        this.binder = (FragmentSwitcherInfoMainBinding) DataBindingUtil.inflate(layoutInflater, R.layout.fragment_switcher_info_main, viewGroup, false);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.connectedMacAddress = arguments.getString("CONNECTED_MAC_ADDRESS");
        }
        if (!IOUtil.checkIsIODeviceKey(this.connectedMacAddress) || (device = IODeviceHandler.getInstance().getDevice(this.connectedMacAddress)) == null) {
            return null;
        }
        SwitcherInfoMainFragmentViewModel switcherInfoMainFragmentViewModel = new SwitcherInfoMainFragmentViewModel(getContext());
        this.viewModel = switcherInfoMainFragmentViewModel;
        this.binder.setViewModel(switcherInfoMainFragmentViewModel);
        SwitcherInfoMainPresenter switcherInfoMainPresenter = new SwitcherInfoMainPresenter(this, UserStateManager.getInstance().getCurrentUserFromDB(), new FindSwitcherInfoInteractor(getContext(), device), new SwitcherInfoHelper());
        this.presenter = switcherInfoMainPresenter;
        switcherInfoMainPresenter.initialize(this.connectedMacAddress);
        return this.binder.getRoot();
    }

    @Override // kr.switcher.switcherm.ui.switcherInfo.views.SwitcherInfoMainView
    public void initViewModel(IODevice.ProductId productId) {
        this.viewModel.initResource(productId);
    }

    @Override // kr.switcher.switcherm.ui.switcherInfo.views.SwitcherInfoMainView
    public void viewData(IODevice iODevice, String str, String str2, String str3, String str4, String str5) {
        this.viewModel.viewData(iODevice, IODeviceConfig.NO, str, str3, str2, str4, str5);
    }

    @Override // kr.switcher.switcherm.ui.switcherInfo.views.SwitcherInfoMainView
    public void setWhoAmI(boolean z) {
        this.viewModel.setWhoAmI(z);
    }

    @Override // kr.switcher.switcherm.ui.switcherInfo.views.SwitcherInfoMainView
    public void showErrorMessage(String str) {
        IOUtil.showToast(str);
    }

    public void refreshView() {
        SwitcherInfoMainPresenter switcherInfoMainPresenter = this.presenter;
        if (switcherInfoMainPresenter != null) {
            switcherInfoMainPresenter.setInfo(this.connectedMacAddress);
        }
    }
}
