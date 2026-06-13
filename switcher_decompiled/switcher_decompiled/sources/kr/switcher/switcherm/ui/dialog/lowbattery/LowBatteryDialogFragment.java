package kr.switcher.switcherm.ui.dialog.lowbattery;

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
import kr.switcher.switcherm.common.util.IOLog;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.ui.dialog.lowbattery.presenter.LowBatteryPresenter;
import kr.switcher.switcherm.ui.dialog.lowbattery.view.LowBatteryView;

/* JADX INFO: loaded from: classes2.dex */
public class LowBatteryDialogFragment extends DialogFragment implements LowBatteryView {
    private static final String PARM_CURRENT_BATTERY = "CURRENT_BATTERY";
    private static final String TAG = "LowBatteryDialogFragment";
    private LowBatteryPresenter presenter;

    @BindView(R.id.tv_current_battery)
    TextView tv_current_battery;

    public static LowBatteryDialogFragment newInstance(int i) {
        LowBatteryDialogFragment lowBatteryDialogFragment = new LowBatteryDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(PARM_CURRENT_BATTERY, i);
        lowBatteryDialogFragment.setArguments(bundle);
        return lowBatteryDialogFragment;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreate(bundle);
        View viewInflate = layoutInflater.inflate(R.layout.fragment_dialog_low_battery, viewGroup, false);
        ButterKnife.bind(this, viewInflate);
        Bundle arguments = getArguments();
        int i = arguments != null ? arguments.getInt(PARM_CURRENT_BATTERY) : 0;
        LowBatteryPresenter lowBatteryPresenter = new LowBatteryPresenter(this);
        this.presenter = lowBatteryPresenter;
        lowBatteryPresenter.onCreateView(i);
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.presenter.dismissDialog();
    }

    @Override // kr.switcher.switcherm.ui.dialog.lowbattery.view.LowBatteryView
    public void setDialog() {
        getDialog().getWindow().requestFeature(1);
        getDialog().getWindow().clearFlags(2);
        getDialog().getWindow().setGravity(48);
        getDialog().getWindow().getAttributes().windowAnimations = R.style.SwipeDialogAnimation;
        getDialog().getWindow().setFlags(32, 32);
        getDialog().setCanceledOnTouchOutside(true);
    }

    @Override // kr.switcher.switcherm.ui.dialog.lowbattery.view.LowBatteryView
    public void dismissDialog() {
        dismiss();
    }

    @Override // kr.switcher.switcherm.ui.dialog.lowbattery.view.LowBatteryView
    public void setCurrentBattery(int i) {
        this.tv_current_battery.setText(IOUtil.getStringResource(R.string.low_battery_noti_title));
    }

    @OnClick({R.id.rl_low_battery})
    public void onViewClicked() {
        dismissDialog();
    }

    @Override // kr.switcher.switcherm.ui.dialog.lowbattery.view.LowBatteryView
    public void trackLowBatteryForGA() {
        IOLog.activity(IOUtil.getStringResource(R.string.screen_title_2_3_4));
    }
}
