package kr.switcher.switcherm.ui.dialog;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import kr.switcher.switcherm.R;

/* JADX INFO: loaded from: classes2.dex */
public class ConfirmDialogFragment extends DialogFragment {
    private static final String ARG_REQUEST_ID = "request_id";
    private static final String ARG_TOPIC_NAME = "topic_name";
    private static final String TAG = "ConfirmDialogFragment";
    private static ConfirmCallback callback;
    private String topicName;

    public static ConfirmDialogFragment newInstance(String str, ConfirmCallback confirmCallback) {
        ConfirmDialogFragment confirmDialogFragment = new ConfirmDialogFragment();
        callback = confirmCallback;
        Bundle bundle = new Bundle();
        bundle.putString(ARG_TOPIC_NAME, str);
        confirmDialogFragment.setArguments(bundle);
        return confirmDialogFragment;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreate(bundle);
        getDialog().getWindow().requestFeature(1);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
        if (getArguments() != null) {
            this.topicName = getArguments().getString(ARG_TOPIC_NAME);
        }
        View viewInflate = layoutInflater.inflate(R.layout.fragment_dialog_confirm, viewGroup, false);
        TextView textView = (TextView) viewInflate.findViewById(R.id.tv_topic_name);
        RelativeLayout relativeLayout = (RelativeLayout) viewInflate.findViewById(R.id.btn_confirm);
        String str = this.topicName;
        if (str != null && str != "") {
            textView.setText(str);
        }
        relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: kr.switcher.switcherm.ui.dialog.ConfirmDialogFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ConfirmDialogFragment.callback != null) {
                    ConfirmDialogFragment.callback.onConfirmResult(true);
                }
                ConfirmDialogFragment.this.dismiss();
            }
        });
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
}
