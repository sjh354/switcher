package kr.switcher.switcherm.ui.switcherInfo.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.util.IOLog;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.databinding.FragmentReturnConfirmBinding;
import kr.switcher.switcherm.preference.ReturnInfo;
import kr.switcher.switcherm.user.UserStateManager;
import kr.switcher.switcherm.viewmodel.ReturnConfirmFragmentViewModel;

/* JADX INFO: loaded from: classes2.dex */
public class ReturnConfirmFragment extends Fragment {
    private static final String TAG = "ReturnConfirmFragment";
    private FragmentReturnConfirmBinding binder;
    private String connectedMacAddress;
    private ReturnConfirmFragmentViewModel viewModel;

    public static ReturnConfirmFragment newInstance(String str) {
        ReturnConfirmFragment returnConfirmFragment = new ReturnConfirmFragment();
        Bundle bundle = new Bundle();
        bundle.putString("CONNECTED_MAC_ADDRESS", str);
        returnConfirmFragment.setArguments(bundle);
        return returnConfirmFragment;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        FragmentReturnConfirmBinding fragmentReturnConfirmBinding = (FragmentReturnConfirmBinding) DataBindingUtil.inflate(layoutInflater, R.layout.fragment_return_confirm, viewGroup, false);
        this.binder = fragmentReturnConfirmBinding;
        View root = fragmentReturnConfirmBinding.getRoot();
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.connectedMacAddress = arguments.getString("CONNECTED_MAC_ADDRESS");
        }
        if (UserStateManager.getInstance().getCurrentUserFromDB() == null) {
            IOUtil.showToast(IOUtil.getStringResource(R.string.not_found_user));
            getActivity().finish();
            return null;
        }
        ReturnInfo returnInfo = new ReturnInfo(this.connectedMacAddress);
        ReturnConfirmFragmentViewModel returnConfirmFragmentViewModel = new ReturnConfirmFragmentViewModel(returnInfo.getHopeVisit(), returnInfo.getInvoiceNumber());
        this.viewModel = returnConfirmFragmentViewModel;
        this.binder.setViewModel(returnConfirmFragmentViewModel);
        return root;
    }

    public void onReturnConfirmButtonClicked() {
        IOLog.i(TAG, "onReturnConfirmButtonClicked() connected mac address : " + this.connectedMacAddress);
    }
}
