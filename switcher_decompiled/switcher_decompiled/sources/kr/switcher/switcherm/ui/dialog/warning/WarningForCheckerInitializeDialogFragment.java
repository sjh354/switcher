package kr.switcher.switcherm.ui.dialog.warning;

import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.fragment.app.DialogFragment;
import butterknife.ButterKnife;
import butterknife.OnClick;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.ui.dialog.ConfirmCallback;

/* JADX INFO: loaded from: classes2.dex */
public class WarningForCheckerInitializeDialogFragment extends DialogFragment {
    private static final String TAG = "WarningForCheckerInitializeDialogFragment";
    private static ConfirmCallback callback;

    public static WarningForCheckerInitializeDialogFragment newInstance(ConfirmCallback confirmCallback) {
        callback = confirmCallback;
        WarningForCheckerInitializeDialogFragment warningForCheckerInitializeDialogFragment = new WarningForCheckerInitializeDialogFragment();
        warningForCheckerInitializeDialogFragment.setArguments(new Bundle());
        return warningForCheckerInitializeDialogFragment;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreate(bundle);
        View viewInflate = layoutInflater.inflate(R.layout.fragment_dialog_warning_initialize_for_checker, viewGroup, false);
        ButterKnife.bind(this, viewInflate);
        return viewInflate;
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        LinearLayout linearLayout = new LinearLayout(getActivity());
        Dialog dialog = new Dialog(getActivity());
        dialog.requestWindowFeature(1);
        dialog.setContentView(linearLayout);
        return dialog;
    }

    @OnClick({R.id.btn_cancel})
    public void onCancelButtonClicked() {
        dismiss();
        callback.onConfirmResult(false);
    }

    @OnClick({R.id.btn_initialize})
    public void onInitializeButtonClicked() {
        dismiss();
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(IOUtil.getStringResource(R.string.kakao_talk_link))));
    }
}
