package kr.switcher.switcherm.ui.dialog.warning;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.fragment.app.DialogFragment;
import butterknife.ButterKnife;
import butterknife.OnClick;
import kr.switcher.switcherm.R;

/* JADX INFO: loaded from: classes2.dex */
public class WarningForRegisterDialogFragment extends DialogFragment {
    private static final String TAG = "WarningForRegisterDialogFragment";

    public static WarningForRegisterDialogFragment newInstance() {
        WarningForRegisterDialogFragment warningForRegisterDialogFragment = new WarningForRegisterDialogFragment();
        warningForRegisterDialogFragment.setArguments(new Bundle());
        return warningForRegisterDialogFragment;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreate(bundle);
        View viewInflate = layoutInflater.inflate(R.layout.fragment_dialog_warning_register, viewGroup, false);
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

    @OnClick({R.id.btn_confirm})
    public void onConfirmButtonClicked() {
        dismiss();
    }
}
