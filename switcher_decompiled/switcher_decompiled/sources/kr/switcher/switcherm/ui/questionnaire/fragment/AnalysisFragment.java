package kr.switcher.switcherm.ui.questionnaire.fragment;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import kr.switcher.device.switcher.Switcher;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.activity.ActivityController;
import kr.switcher.switcherm.common.util.IOLog;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.device.switcher.handler.SwitcherHandler;
import kr.switcher.switcherm.ui.questionnaire.presenter.AnalysisPresenter;
import kr.switcher.switcherm.ui.questionnaire.views.AnalysisView;
import no.nordicsemi.android.dfu.internal.scanner.BootloaderScanner;

/* JADX INFO: loaded from: classes2.dex */
public class AnalysisFragment extends Fragment implements AnalysisView {
    private final int LOADING_TIMEOUT = 5000;
    private String connectedMacAddress;
    private int count;
    private CountDownTimer countDownTimer;
    private AnalysisPresenter presenter;

    @BindView(R.id.tv_loading)
    TextView tv_loading;

    static /* synthetic */ int access$008(AnalysisFragment analysisFragment) {
        int i = analysisFragment.count;
        analysisFragment.count = i + 1;
        return i;
    }

    public static AnalysisFragment newInstance(String str) {
        AnalysisFragment analysisFragment = new AnalysisFragment();
        Bundle bundle = new Bundle();
        bundle.putString("CONNECTED_MAC_ADDRESS", str);
        analysisFragment.setArguments(bundle);
        return analysisFragment;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_analysis, viewGroup, false);
        ButterKnife.bind(this, viewInflate);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.connectedMacAddress = arguments.getString("CONNECTED_MAC_ADDRESS");
        }
        this.presenter = new AnalysisPresenter(this);
        Switcher switcher = getSwitcher(this.connectedMacAddress);
        if (switcher == null) {
            IOUtil.showToast(IOUtil.getStringResource(R.string.not_connected_switcher));
            getActivity().finish();
            return null;
        }
        this.presenter.initialize(switcher);
        return viewInflate;
    }

    private Switcher getSwitcher(String str) {
        Switcher switcher;
        if (IOUtil.checkIsIODeviceKey(str) && (switcher = SwitcherHandler.getInstance().getSwitcher(str)) != null) {
            return switcher;
        }
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.presenter.onPause();
    }

    @Override // kr.switcher.switcherm.ui.questionnaire.views.AnalysisView
    public void trackAnalysisForGA() {
        IOLog.activity(IOUtil.getStringResource(R.string.screen_title_2_3_1_0_2));
    }

    @Override // kr.switcher.switcherm.ui.questionnaire.views.AnalysisView
    public void setLoadingText(String str) {
        this.tv_loading.setText(str);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [kr.switcher.switcherm.ui.questionnaire.fragment.AnalysisFragment$1] */
    @Override // kr.switcher.switcherm.ui.questionnaire.views.AnalysisView
    public void startTimer() {
        this.count = 0;
        this.countDownTimer = new CountDownTimer(BootloaderScanner.TIMEOUT, 1500L) { // from class: kr.switcher.switcherm.ui.questionnaire.fragment.AnalysisFragment.1
            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                AnalysisFragment.this.presenter.count(AnalysisFragment.access$008(AnalysisFragment.this));
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                ActivityController.moveSettingReservationMenuActivity(AnalysisFragment.this.getActivity(), AnalysisFragment.this.connectedMacAddress);
                AnalysisFragment.this.getActivity().finish();
            }
        }.start();
    }

    @Override // kr.switcher.switcherm.ui.questionnaire.views.AnalysisView
    public void cancelTimer() {
        CountDownTimer countDownTimer = this.countDownTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }
}
