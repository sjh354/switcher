package kr.switcher.switcherm.ui.dialog;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.DialogFragment;
import kr.switcher.switcherm.R;

/* JADX INFO: loaded from: classes2.dex */
public class ProgressbarDialogFragment extends DialogFragment {
    private static final String ARG_TIMEOUT = "TIMEOUT";
    private static final String TAG = "ProgressbarDialogFragment";

    public static ProgressbarDialogFragment newInstance(int i) {
        ProgressbarDialogFragment progressbarDialogFragment = new ProgressbarDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_TIMEOUT, i);
        progressbarDialogFragment.setArguments(bundle);
        return progressbarDialogFragment;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreate(bundle);
        getDialog().getWindow().requestFeature(1);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
        int i = getArguments() != null ? getArguments().getInt(ARG_TIMEOUT) : 0;
        View viewInflate = layoutInflater.inflate(R.layout.fragment_dialog_progressbar, viewGroup, false);
        new Handler().postDelayed(new Runnable() { // from class: kr.switcher.switcherm.ui.dialog.ProgressbarDialogFragment.1
            @Override // java.lang.Runnable
            public void run() {
                ProgressbarDialogFragment.this.dismiss();
            }
        }, i);
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        dismiss();
    }
}
