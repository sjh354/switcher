package kr.switcher.switcherm.ui.dialog.signal;

import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import androidx.fragment.app.DialogFragment;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.ga.GALogger;
import kr.switcher.switcherm.common.util.IOLog;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.ui.dialog.ConfirmCallback;
import kr.switcher.switcherm.ui.dialog.signal.presenter.AlarmSignalUsecaseSuggestionImpl;
import kr.switcher.switcherm.ui.dialog.signal.presenter.AlarmSignalUsecaseSuggestionPresenter;
import kr.switcher.switcherm.ui.dialog.signal.view.AlarmSignalUsecaseSuggestionView;

/* JADX INFO: loaded from: classes2.dex */
public class AlarmSignalUsecaseSuggestionFragment extends DialogFragment implements AlarmSignalUsecaseSuggestionView, View.OnClickListener {
    private static final String TAG = "AlarmSignalUsecaseSuggestionFragment";
    private static ConfirmCallback callback;
    private AlarmSignalUsecaseSuggestionPresenter presenter;

    public static AlarmSignalUsecaseSuggestionFragment newInstance(ConfirmCallback confirmCallback) {
        AlarmSignalUsecaseSuggestionFragment alarmSignalUsecaseSuggestionFragment = new AlarmSignalUsecaseSuggestionFragment();
        callback = confirmCallback;
        return alarmSignalUsecaseSuggestionFragment;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreate(bundle);
        View viewInflate = layoutInflater.inflate(R.layout.fragment_dialog_signal_3, viewGroup, false);
        RelativeLayout relativeLayout = (RelativeLayout) viewInflate.findViewById(R.id.btn_cancel);
        RelativeLayout relativeLayout2 = (RelativeLayout) viewInflate.findViewById(R.id.btn_test);
        relativeLayout.setOnClickListener(this);
        relativeLayout2.setOnClickListener(this);
        AlarmSignalUsecaseSuggestionImpl alarmSignalUsecaseSuggestionImpl = new AlarmSignalUsecaseSuggestionImpl(this);
        this.presenter = alarmSignalUsecaseSuggestionImpl;
        alarmSignalUsecaseSuggestionImpl.initialize();
        return viewInflate;
    }

    @Override // kr.switcher.switcherm.ui.dialog.signal.view.AlarmSignalUsecaseSuggestionView
    public void setDialog() {
        getDialog().getWindow().requestFeature(1);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
        getDialog().getWindow().setGravity(80);
        getDialog().setCanceledOnTouchOutside(true);
        WindowManager.LayoutParams attributes = getDialog().getWindow().getAttributes();
        attributes.y = (int) IOUtil.getDp(34);
        getDialog().getWindow().setAttributes(attributes);
        getDialog().setOnCancelListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_cancel) {
            this.presenter.onCancelButtonClicked();
        } else {
            if (id != R.id.btn_test) {
                return;
            }
            this.presenter.onTestButtonClicked();
        }
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.presenter.onCancelButtonClicked();
    }

    @Override // kr.switcher.switcherm.ui.dialog.signal.view.AlarmSignalUsecaseSuggestionView
    public void dismissDialog(boolean z) {
        ConfirmCallback confirmCallback = callback;
        if (confirmCallback != null) {
            confirmCallback.onConfirmResult(z);
        }
        dismiss();
    }

    @Override // kr.switcher.switcherm.ui.dialog.signal.view.AlarmSignalUsecaseSuggestionView
    public void trackForGA() {
        IOLog.activity(IOUtil.getStringResource(R.string.screen_title_2_3_1_1_0));
    }

    @Override // kr.switcher.switcherm.ui.dialog.signal.view.AlarmSignalUsecaseSuggestionView
    public void acceptEventForGA() {
        IOLog.event(GALogger.CATEGORY_SIGNAL, GALogger.ACTION_ACCEPT_ALARM_SIGNAL_USECASE_SUGGESTION);
    }

    @Override // kr.switcher.switcherm.ui.dialog.signal.view.AlarmSignalUsecaseSuggestionView
    public void denyEventForGA() {
        IOLog.event(GALogger.CATEGORY_SIGNAL, GALogger.ACTION_DENY_ALARM_SIGNAL_USECASE_SUGGESTION);
    }
}
