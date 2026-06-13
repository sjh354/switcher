package kr.switcher.switcherm.ui.setting.fragment;

import android.view.View;
import android.widget.ImageView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import kr.switcher.switcherm.R;

/* JADX INFO: loaded from: classes2.dex */
public class CheckerLevelIconFragment_ViewBinding implements Unbinder {
    private CheckerLevelIconFragment target;

    public CheckerLevelIconFragment_ViewBinding(CheckerLevelIconFragment checkerLevelIconFragment, View view) {
        this.target = checkerLevelIconFragment;
        checkerLevelIconFragment.iv_level_info = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_level_info, "field 'iv_level_info'", ImageView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        CheckerLevelIconFragment checkerLevelIconFragment = this.target;
        if (checkerLevelIconFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        checkerLevelIconFragment.iv_level_info = null;
    }
}
