package kr.switcher.switcherm.ui.dialog;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.util.IOUtil;

/* JADX INFO: loaded from: classes2.dex */
public class SignalDialogFragment extends DialogFragment {
    private static final String ARG_BACKGROUND_COLOR_RESOURCE = "ARG_BACKGROUND_COLOR_RESOURCE";
    private static final String ARG_CONTENTS_NAME = "topic_name";
    private static final String ARG_LEFT_BUTTON_NAME = "button_name";
    private static final String ARG_MAIN_IMAGE_RESOURCE = "ARG_MAIN_IMAGE_RESOURCE";
    private static final String ARG_RIGHT_BUTTON_NAME = "right_button_name";
    private static final String TAG = "SignalDialogFragment";
    private static ConfirmCallback callback;
    private int backgroundColorResource;
    private String contents;
    private String leftButtonName;
    private int mainImageResource;
    private String rightButtonName;

    public static SignalDialogFragment newInstance(String str, String str2, String str3, int i, int i2, ConfirmCallback confirmCallback) {
        SignalDialogFragment signalDialogFragment = new SignalDialogFragment();
        callback = confirmCallback;
        Bundle bundle = new Bundle();
        bundle.putString(ARG_CONTENTS_NAME, str);
        bundle.putString(ARG_LEFT_BUTTON_NAME, str2);
        bundle.putString(ARG_RIGHT_BUTTON_NAME, str3);
        bundle.putInt(ARG_MAIN_IMAGE_RESOURCE, i);
        bundle.putInt(ARG_BACKGROUND_COLOR_RESOURCE, i2);
        signalDialogFragment.setArguments(bundle);
        return signalDialogFragment;
    }

    private void initialize() {
        setDialog();
        this.contents = "";
        this.leftButtonName = "";
        this.rightButtonName = "";
        this.mainImageResource = 0;
        this.backgroundColorResource = 0;
    }

    private void setDialog() {
        getDialog().getWindow().requestFeature(1);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
        getDialog().getWindow().setGravity(80);
        WindowManager.LayoutParams attributes = getDialog().getWindow().getAttributes();
        getDialog().setCanceledOnTouchOutside(true);
        attributes.y = 34;
        getDialog().getWindow().setAttributes(attributes);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreate(bundle);
        initialize();
        if (getArguments() != null) {
            this.contents = getArguments().getString(ARG_CONTENTS_NAME);
            this.leftButtonName = getArguments().getString(ARG_LEFT_BUTTON_NAME);
            this.rightButtonName = getArguments().getString(ARG_RIGHT_BUTTON_NAME);
            this.mainImageResource = getArguments().getInt(ARG_MAIN_IMAGE_RESOURCE);
            this.backgroundColorResource = getArguments().getInt(ARG_BACKGROUND_COLOR_RESOURCE);
        }
        View viewInflate = layoutInflater.inflate(R.layout.fragment_dialog_signal_1, viewGroup, false);
        LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(R.id.lin_top_bg);
        TextView textView = (TextView) viewInflate.findViewById(R.id.tv_contents);
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.tv_left_button_name);
        TextView textView3 = (TextView) viewInflate.findViewById(R.id.tv_right_button_name);
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.iv_main_image);
        RelativeLayout relativeLayout = (RelativeLayout) viewInflate.findViewById(R.id.btn_cancel);
        RelativeLayout relativeLayout2 = (RelativeLayout) viewInflate.findViewById(R.id.btn_test);
        String str = this.contents;
        if (str != null && str != "") {
            textView.setText(str);
        }
        String str2 = this.leftButtonName;
        if (str2 != null && str2 != "") {
            textView2.setText(str2);
        }
        String str3 = this.rightButtonName;
        if (str3 != null && str3 != "") {
            textView3.setText(str3);
        }
        int i = this.mainImageResource;
        if (i != 0) {
            imageView.setImageDrawable(IOUtil.makeDrawable(i));
        }
        int i2 = this.backgroundColorResource;
        if (i2 != 0) {
            linearLayout.setBackgroundColor(IOUtil.getColorResource(i2));
        }
        relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: kr.switcher.switcherm.ui.dialog.SignalDialogFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (SignalDialogFragment.callback != null) {
                    SignalDialogFragment.callback.onConfirmResult(false);
                }
                SignalDialogFragment.this.dismiss();
            }
        });
        relativeLayout2.setOnClickListener(new View.OnClickListener() { // from class: kr.switcher.switcherm.ui.dialog.SignalDialogFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (SignalDialogFragment.callback != null) {
                    SignalDialogFragment.callback.onConfirmResult(true);
                }
                SignalDialogFragment.this.dismiss();
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
