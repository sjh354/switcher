package kr.switcher.switcherm.ui.switcherInfo.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.util.IOLog;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.preference.ReturnInfo;
import kr.switcher.switcherm.ui.switcherInfo.SwitcherInfoActivity;
import kr.switcher.switcherm.ui.switcherInfo.presenters.ReturnBookingPresenter;
import kr.switcher.switcherm.ui.switcherInfo.views.ReturnBookingView;
import kr.switcher.switcherm.user.User;
import kr.switcher.switcherm.user.UserStateManager;

/* JADX INFO: loaded from: classes2.dex */
public class ReturnBookingFragment extends Fragment implements ReturnBookingView {
    public static final String PARM_ADDRESS = "PARM_ADDRESS";
    public static final String PARM_POST_CODE = "PARM_POST_CODE";
    private static final String TAG = "ReturnBookingFragment";
    private static SwitcherInfoActivity.ReturnCompleteListener listener;
    private String connectedMacAddress;

    @BindView(R.id.et_address2)
    EditText et_address2;
    private ReturnBookingPresenter presenter;

    @BindView(R.id.tv_address1)
    TextView tv_address1;

    @BindView(R.id.tv_phone_number)
    TextView tv_phone_number;

    @BindView(R.id.tv_post_number)
    TextView tv_post_number;

    @BindView(R.id.tv_return_name)
    TextView tv_return_name;

    public static ReturnBookingFragment newInstance(String str, SwitcherInfoActivity.ReturnCompleteListener returnCompleteListener) {
        return newInstance(str, "", "", returnCompleteListener);
    }

    public static ReturnBookingFragment newInstance(String str, String str2, String str3, SwitcherInfoActivity.ReturnCompleteListener returnCompleteListener) {
        ReturnBookingFragment returnBookingFragment = new ReturnBookingFragment();
        Bundle bundle = new Bundle();
        bundle.putString("CONNECTED_MAC_ADDRESS", str);
        bundle.putString(PARM_POST_CODE, str2);
        bundle.putString(PARM_ADDRESS, str3);
        returnBookingFragment.setArguments(bundle);
        listener = returnCompleteListener;
        return returnBookingFragment;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_return_booking, viewGroup, false);
        ButterKnife.bind(this, viewInflate);
        User currentUserFromDB = UserStateManager.getInstance().getCurrentUserFromDB();
        if (currentUserFromDB == null) {
            IOUtil.showToast(IOUtil.getStringResource(R.string.not_found_user));
            getActivity().finish();
            return null;
        }
        ReturnBookingPresenter returnBookingPresenter = new ReturnBookingPresenter(this);
        this.presenter = returnBookingPresenter;
        returnBookingPresenter.initialize(currentUserFromDB.getUserName(), currentUserFromDB.getPhoneNumber(), currentUserFromDB.getPostNumber(), currentUserFromDB.getAddress1(), currentUserFromDB.getAddress2());
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.connectedMacAddress = arguments.getString("CONNECTED_MAC_ADDRESS");
            if (!IOUtil.checkIsNullAndEmptyParameter(arguments.getString(PARM_POST_CODE))) {
                this.presenter.updatePostNumber(arguments.getString(PARM_POST_CODE));
            }
            if (!IOUtil.checkIsNullAndEmptyParameter(arguments.getString(PARM_ADDRESS))) {
                this.presenter.updateAddress1(arguments.getString(PARM_ADDRESS));
            }
        }
        return viewInflate;
    }

    @Override // kr.switcher.switcherm.ui.switcherInfo.views.ReturnBookingView
    public void setReturnInfo(String str, String str2, String str3, String str4, String str5) {
        this.tv_return_name.setText(str);
        this.tv_phone_number.setText(str2);
        this.tv_post_number.setText(str3);
        this.tv_address1.setText(str4);
        this.et_address2.setText(str5);
    }

    @Override // kr.switcher.switcherm.ui.switcherInfo.views.ReturnBookingView
    public void setPostNumber(String str) {
        this.tv_post_number.setText(str);
    }

    @Override // kr.switcher.switcherm.ui.switcherInfo.views.ReturnBookingView
    public void setAddress1(String str) {
        this.tv_address1.setText(str);
    }

    @Override // kr.switcher.switcherm.ui.switcherInfo.views.ReturnBookingView
    public void clearAndFocusAddress2() {
        this.et_address2.setText("");
        this.et_address2.requestFocus();
        IOUtil.showKeyBoard();
    }

    @Override // kr.switcher.switcherm.ui.switcherInfo.views.ReturnBookingView
    public void trackAddressForGA() {
        IOLog.activity(IOUtil.getStringResource(R.string.screen_title_5_0_2_2_2));
    }

    @OnClick({R.id.tv_setting_courier_visit_btn})
    public void onMoveSettingCourierVisitButtonClicked() {
        ReturnInfo returnInfo = new ReturnInfo(this.connectedMacAddress);
        returnInfo.setPostNumber(this.tv_post_number.getText().toString());
        returnInfo.setAddress1(this.tv_address1.getText().toString());
        returnInfo.setAddress2(this.et_address2.getText().toString());
        listener.onReturnComplete(null);
    }
}
