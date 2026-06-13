package kr.switcher.switcherm.ui.dialog;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.util.IOLog;
import kr.switcher.switcherm.common.util.IOUtil;

/* JADX INFO: loaded from: classes2.dex */
public class ChangeDialogFragment extends DialogFragment {
    private static final String ARG_TOPIC_NAME = "topic_name";
    private static final String TAG = "ChangeDialogFragment";
    private static ConfirmCallback callback;

    @BindView(R.id.tv_topic_name)
    TextView tv_topic_name;

    public static ChangeDialogFragment newInstance(String str, ConfirmCallback confirmCallback) {
        ChangeDialogFragment changeDialogFragment = new ChangeDialogFragment();
        callback = confirmCallback;
        Bundle bundle = new Bundle();
        bundle.putString(ARG_TOPIC_NAME, str);
        changeDialogFragment.setArguments(bundle);
        return changeDialogFragment;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreate(bundle);
        getDialog().getWindow().requestFeature(1);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
        WindowManager.LayoutParams attributes = getDialog().getWindow().getAttributes();
        attributes.width = (int) IOUtil.getDp(280);
        attributes.height = (int) IOUtil.getDp(248);
        getDialog().getWindow().setAttributes(attributes);
        String string = getArguments() != null ? getArguments().getString(ARG_TOPIC_NAME) : null;
        View viewInflate = layoutInflater.inflate(R.layout.fragment_dialog_change, viewGroup, false);
        ButterKnife.bind(this, viewInflate);
        if (string != null && string != "") {
            this.tv_topic_name.setText(string);
        }
        trackChangeForGA();
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        ConfirmCallback confirmCallback = callback;
        if (confirmCallback != null) {
            confirmCallback.onConfirmResult(false);
        }
        dismiss();
    }

    public void trackChangeForGA() {
        IOLog.activity(IOUtil.getStringResource(R.string.screen_title_5_0_0_0));
    }

    @OnClick({R.id.btn_change})
    public void onChangeButtonClicked() {
        ConfirmCallback confirmCallback = callback;
        if (confirmCallback != null) {
            confirmCallback.onConfirmResult(true);
        }
        dismiss();
    }

    @OnClick({R.id.btn_cancel})
    public void onCancelButtonClicked() {
        onPause();
    }
}
