package kr.switcher.switcherm.ui.setting.fragment;

import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import kr.switcher.switcherm.R;

/* JADX INFO: loaded from: classes2.dex */
public class ShareCodeFragment_ViewBinding implements Unbinder {
    private ShareCodeFragment target;

    public ShareCodeFragment_ViewBinding(ShareCodeFragment shareCodeFragment, View view) {
        this.target = shareCodeFragment;
        shareCodeFragment.et_share_code = (EditText) Utils.findRequiredViewAsType(view, R.id.et_share_code, "field 'et_share_code'", EditText.class);
        shareCodeFragment.pb_changing = (ProgressBar) Utils.findRequiredViewAsType(view, R.id.pb_changing, "field 'pb_changing'", ProgressBar.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        ShareCodeFragment shareCodeFragment = this.target;
        if (shareCodeFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        shareCodeFragment.et_share_code = null;
        shareCodeFragment.pb_changing = null;
    }
}
