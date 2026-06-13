package kr.switcher.switcherm.ui.switcherInfo.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import kr.switcher.device.switcher.interfaces.IODeviceCallbacks;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.util.IOLog;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.databinding.FragmentReturnBooking2Binding;
import kr.switcher.switcherm.device.switcher.handler.SwitcherHandler;
import kr.switcher.switcherm.preference.OAuthToken;
import kr.switcher.switcherm.preference.ReturnInfo;
import kr.switcher.switcherm.ui.switcherInfo.SwitcherInfoActivity;
import kr.switcher.switcherm.user.UserStateManager;
import kr.switcher.switcherm.viewmodel.ReturnBooking2FragmentViewModel;

/* JADX INFO: loaded from: classes2.dex */
public class ReturnBooking2Fragment extends Fragment {
    private static final String TAG = "ReturnBooking2Fragment";
    private static SwitcherInfoActivity.ReturnCompleteListener listener;
    private FragmentReturnBooking2Binding binder;
    private String connectedMacAddress;
    private ReturnBooking2FragmentViewModel viewModel;

    public static ReturnBooking2Fragment newInstance(String str, SwitcherInfoActivity.ReturnCompleteListener returnCompleteListener) {
        ReturnBooking2Fragment returnBooking2Fragment = new ReturnBooking2Fragment();
        Bundle bundle = new Bundle();
        bundle.putString("CONNECTED_MAC_ADDRESS", str);
        returnBooking2Fragment.setArguments(bundle);
        listener = returnCompleteListener;
        return returnBooking2Fragment;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        FragmentReturnBooking2Binding fragmentReturnBooking2Binding = (FragmentReturnBooking2Binding) DataBindingUtil.inflate(layoutInflater, R.layout.fragment_return_booking2, viewGroup, false);
        this.binder = fragmentReturnBooking2Binding;
        View root = fragmentReturnBooking2Binding.getRoot();
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.connectedMacAddress = arguments.getString("CONNECTED_MAC_ADDRESS");
        }
        if (UserStateManager.getInstance().getCurrentUserFromDB() == null) {
            IOUtil.showToast(IOUtil.getStringResource(R.string.not_found_user));
            getActivity().finish();
            return null;
        }
        ReturnBooking2FragmentViewModel returnBooking2FragmentViewModel = new ReturnBooking2FragmentViewModel();
        this.viewModel = returnBooking2FragmentViewModel;
        this.binder.setViewModel(returnBooking2FragmentViewModel);
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() { // from class: kr.switcher.switcherm.ui.switcherInfo.fragments.ReturnBooking2Fragment.1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    ReturnBooking2Fragment.this.binder.rbVisitDay1.setChecked(ReturnBooking2Fragment.this.binder.rbVisitDay1 == compoundButton);
                    ReturnBooking2Fragment.this.binder.rbVisitDay2.setChecked(ReturnBooking2Fragment.this.binder.rbVisitDay2 == compoundButton);
                    ReturnBooking2Fragment.this.binder.rbVisitDay3.setChecked(ReturnBooking2Fragment.this.binder.rbVisitDay3 == compoundButton);
                    ReturnBooking2Fragment.this.binder.rbVisitDay4.setChecked(ReturnBooking2Fragment.this.binder.rbVisitDay4 == compoundButton);
                    ReturnBooking2Fragment.this.binder.rbVisitDay5.setChecked(ReturnBooking2Fragment.this.binder.rbVisitDay5 == compoundButton);
                }
            }
        };
        this.binder.rbVisitDay1.setOnCheckedChangeListener(onCheckedChangeListener);
        this.binder.rbVisitDay2.setOnCheckedChangeListener(onCheckedChangeListener);
        this.binder.rbVisitDay3.setOnCheckedChangeListener(onCheckedChangeListener);
        this.binder.rbVisitDay4.setOnCheckedChangeListener(onCheckedChangeListener);
        this.binder.rbVisitDay5.setOnCheckedChangeListener(onCheckedChangeListener);
        return root;
    }

    public String getHopeVisit() {
        String str;
        ReturnInfo returnInfo = new ReturnInfo(this.connectedMacAddress);
        if (this.binder.rbVisitDay1.isChecked()) {
            String visitDay1 = this.viewModel.getVisitDay1();
            returnInfo.setHopeVisit(visitDay1);
            str = visitDay1.split(IOUtil.getStringResource(R.string.year))[0] + "-" + String.format("%02d", Integer.valueOf(Integer.parseInt(visitDay1.split(" ")[1].split(IOUtil.getStringResource(R.string.month))[0]))) + "-" + String.format("%02d", Integer.valueOf(Integer.parseInt(visitDay1.split(" ")[2].split(IOUtil.getStringResource(R.string.day))[0])));
        } else if (this.binder.rbVisitDay2.isChecked()) {
            String visitDay2 = this.viewModel.getVisitDay2();
            returnInfo.setHopeVisit(visitDay2);
            str = visitDay2.split(IOUtil.getStringResource(R.string.year))[0] + "-" + String.format("%02d", Integer.valueOf(Integer.parseInt(visitDay2.split(" ")[1].split(IOUtil.getStringResource(R.string.month))[0]))) + "-" + String.format("%02d", Integer.valueOf(Integer.parseInt(visitDay2.split(" ")[2].split(IOUtil.getStringResource(R.string.day))[0])));
        } else if (this.binder.rbVisitDay3.isChecked()) {
            String visitDay3 = this.viewModel.getVisitDay3();
            returnInfo.setHopeVisit(visitDay3);
            str = visitDay3.split(IOUtil.getStringResource(R.string.year))[0] + "-" + String.format("%02d", Integer.valueOf(Integer.parseInt(visitDay3.split(" ")[1].split(IOUtil.getStringResource(R.string.month))[0]))) + "-" + String.format("%02d", Integer.valueOf(Integer.parseInt(visitDay3.split(" ")[2].split(IOUtil.getStringResource(R.string.day))[0])));
        } else if (this.binder.rbVisitDay4.isChecked()) {
            String visitDay4 = this.viewModel.getVisitDay4();
            returnInfo.setHopeVisit(visitDay4);
            str = visitDay4.split(IOUtil.getStringResource(R.string.year))[0] + "-" + String.format("%02d", Integer.valueOf(Integer.parseInt(visitDay4.split(" ")[1].split(IOUtil.getStringResource(R.string.month))[0]))) + "-" + String.format("%02d", Integer.valueOf(Integer.parseInt(visitDay4.split(" ")[2].split(IOUtil.getStringResource(R.string.day))[0])));
        } else if (this.binder.rbVisitDay5.isChecked()) {
            String visitDay5 = this.viewModel.getVisitDay5();
            returnInfo.setHopeVisit(visitDay5);
            str = visitDay5.split(IOUtil.getStringResource(R.string.year))[0] + "-" + String.format("%02d", Integer.valueOf(Integer.parseInt(visitDay5.split(" ")[1].split(IOUtil.getStringResource(R.string.month))[0]))) + "-" + String.format("%02d", Integer.valueOf(Integer.parseInt(visitDay5.split(" ")[2].split(IOUtil.getStringResource(R.string.day))[0])));
        } else {
            str = null;
        }
        return str + "T23:59:59";
    }

    public void onReturnCompletedBookingButtonClicked() {
        this.viewModel.showProgressbar();
        final ReturnInfo returnInfo = new ReturnInfo(this.connectedMacAddress);
        String hopeVisit = getHopeVisit();
        if (hopeVisit == null || hopeVisit.equals("")) {
            IOUtil.showToast("희망 배송일을 지정해주세요");
            IOLog.error(TAG, new OAuthToken().getOAuthToken(), "onReturnCompletedBookingButtonClicked", new Exception("hope visit is null"));
        } else {
            SwitcherHandler.getInstance().returnSwitcher(this.connectedMacAddress, returnInfo.getAddress1(), returnInfo.getAddress2(), returnInfo.getPostNumber(), hopeVisit, new IODeviceCallbacks.ReturnResultResponseCallback() { // from class: kr.switcher.switcherm.ui.switcherInfo.fragments.ReturnBooking2Fragment.2
                @Override // kr.switcher.device.switcher.interfaces.IODeviceCallbacks.ReturnResultResponseCallback
                public void onReturnResult(String str) {
                    ReturnBooking2Fragment.this.viewModel.hideProgressbar();
                    if (str != null && str != "") {
                        returnInfo.setInvoiceNumber(str);
                        ReturnBooking2Fragment.listener.onReturnComplete(null);
                    } else {
                        IOUtil.showToast(IOUtil.getStringResource(R.string.failed_request_return_message));
                    }
                }
            });
        }
    }
}
