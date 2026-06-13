package kr.switcher.switcherm.ui.setting.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import kr.switcher.switcherm.R;

/* JADX INFO: loaded from: classes2.dex */
public class StrokeLevelIconFragment_ViewBinding implements Unbinder {
    private StrokeLevelIconFragment target;

    public StrokeLevelIconFragment_ViewBinding(StrokeLevelIconFragment strokeLevelIconFragment, View view) {
        this.target = strokeLevelIconFragment;
        strokeLevelIconFragment.iv_switcher_icon = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_switcher_icon, "field 'iv_switcher_icon'", ImageView.class);
        strokeLevelIconFragment.tv_propose_message = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_propose_message, "field 'tv_propose_message'", TextView.class);
        strokeLevelIconFragment.tv_situation = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_situation, "field 'tv_situation'", TextView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        StrokeLevelIconFragment strokeLevelIconFragment = this.target;
        if (strokeLevelIconFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        strokeLevelIconFragment.iv_switcher_icon = null;
        strokeLevelIconFragment.tv_propose_message = null;
        strokeLevelIconFragment.tv_situation = null;
    }
}
