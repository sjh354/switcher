package kr.switcher.switcherm.ui.dialog.signal;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.activity.ActivityController;
import kr.switcher.switcherm.common.util.IOLog;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.signal.SignalData;
import kr.switcher.switcherm.signal.SignalFragment;
import kr.switcher.switcherm.ui.dialog.signal.interactor.SendStatusForSignalInteractor;
import kr.switcher.switcherm.ui.dialog.signal.presenter.SignalTypePresenter;
import kr.switcher.switcherm.ui.dialog.signal.view.SignalTypeView;
import kr.switcher.switcherm.ui.switcherInfo.SwitcherInfoActivity;
import kr.switcher.switcherm.ui.switcherList.SwitcherListActivity;
import kr.switcher.switcherm.ui.troubleshooting.TroubleshootingActivity;

/* JADX INFO: loaded from: classes2.dex */
public class SignalTypeDialogFragment extends DialogFragment implements SignalTypeView {
    private static final String PARM_SIGNAL_DATA = "SIGNAL_DATA";
    private static final String TAG = "SignalTypeDialogFragment";
    private static SignalFragment.OnSignalListener listener;

    @BindView(R.id.btn_yes)
    TextView btn_yes;
    private String connectedMacAddress;
    private SignalTypePresenter presenter;
    private SignalData signalData;

    @BindView(R.id.tv_suggestion)
    TextView tv_suggestion;

    public static SignalTypeDialogFragment newInstance(String str, SignalData signalData, SignalFragment.OnSignalListener onSignalListener) {
        listener = onSignalListener;
        SignalTypeDialogFragment signalTypeDialogFragment = new SignalTypeDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putString("CONNECTED_MAC_ADDRESS", str);
        bundle.putParcelable(PARM_SIGNAL_DATA, signalData);
        signalTypeDialogFragment.setArguments(bundle);
        return signalTypeDialogFragment;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreate(bundle);
        View viewInflate = layoutInflater.inflate(R.layout.fragment_dialog_signal_type, viewGroup, false);
        ButterKnife.bind(this, viewInflate);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.connectedMacAddress = arguments.getString("CONNECTED_MAC_ADDRESS");
            this.signalData = (SignalData) arguments.getParcelable(PARM_SIGNAL_DATA);
        }
        if (this.signalData == null) {
            dismissDialog();
        }
        SignalTypePresenter signalTypePresenter = new SignalTypePresenter(this, new SendStatusForSignalInteractor());
        this.presenter = signalTypePresenter;
        signalTypePresenter.onCreateView(this.signalData);
        return viewInflate;
    }

    @Override // kr.switcher.switcherm.ui.dialog.signal.view.SignalTypeView
    public void setDialog() {
        getDialog().getWindow().requestFeature(1);
        getDialog().getWindow().clearFlags(2);
        getDialog().getWindow().setGravity(80);
        getDialog().getWindow().getAttributes().windowAnimations = R.style.SwipeUpDialogAnimation;
        getDialog().getWindow().setFlags(32, 32);
        getDialog().setCanceledOnTouchOutside(true);
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        dismissDialog();
    }

    @Override // kr.switcher.switcherm.ui.dialog.signal.view.SignalTypeView
    public void dismissDialog() {
        dismiss();
    }

    @Override // kr.switcher.switcherm.ui.dialog.signal.view.SignalTypeView
    public void setSuggestionText(String str) {
        this.tv_suggestion.setText(str);
    }

    @Override // kr.switcher.switcherm.ui.dialog.signal.view.SignalTypeView
    public void setButtonText(String str) {
        this.btn_yes.setText(str);
    }

    @OnClick({R.id.btn_yes})
    public void onAcceptButtonClicked() {
        this.presenter.onAcceptButtonClicked(this.connectedMacAddress, this.signalData);
    }

    @OnClick({R.id.btn_deny})
    public void onDenyButtonClicked() {
        this.presenter.onDenyButtonClicked(this.connectedMacAddress, this.signalData);
    }

    @Override // kr.switcher.switcherm.ui.dialog.signal.view.SignalTypeView
    public void moveSettingStrokeMenu(String str) {
        ActivityController.moveSettingStrokeMenuActivity(getActivity(), str);
    }

    @Override // kr.switcher.switcherm.ui.dialog.signal.view.SignalTypeView
    public void moveSettingReservationMenu(String str) {
        ActivityController.moveSettingReservationMenuActivity(getActivity(), str);
    }

    @Override // kr.switcher.switcherm.ui.dialog.signal.view.SignalTypeView
    public void moveWidgetSetting(String str) {
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
    }

    @Override // kr.switcher.switcherm.ui.dialog.signal.view.SignalTypeView
    public void trackFingerForGA() {
        IOLog.activity(IOUtil.getStringResource(R.string.screen_title_2_3_0_0));
    }

    @Override // kr.switcher.switcherm.ui.dialog.signal.view.SignalTypeView
    public void finishActivity() {
        getActivity().finish();
    }

    @Override // kr.switcher.switcherm.ui.dialog.signal.view.SignalTypeView
    public void finish() {
        SignalFragment.OnSignalListener onSignalListener = listener;
        if (onSignalListener != null) {
            onSignalListener.onStartSignal();
        }
    }

    @Override // kr.switcher.switcherm.ui.dialog.signal.view.SignalTypeView
    public void moveTroubleShootingMenu() {
        Intent intent = new Intent(getContext(), (Class<?>) TroubleshootingActivity.class);
        intent.putExtra(TroubleshootingActivity.AI_FROM, TroubleshootingActivity.FROM_SCANNED_SWITCHER);
        startActivity(intent);
    }

    @Override // kr.switcher.switcherm.ui.dialog.signal.view.SignalTypeView
    public void moveCardInfoScreen(String str) {
        Intent intent = new Intent(getContext(), (Class<?>) SwitcherInfoActivity.class);
        intent.putExtra(SwitcherListActivity.INTENT_PARM_MAC_ADDRESS_FOR_CARD, str);
        intent.putExtra(SwitcherInfoActivity.PARM_IS_IO_CASH_PROMOTION, "true");
        startActivity(intent);
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        super.onCancel(dialogInterface);
        this.presenter.onCancel();
    }
}
