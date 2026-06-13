package kr.switcher.switcherm.ui.main.fragment;

import android.view.View;
import android.widget.LinearLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import kr.switcher.switcherm.R;

/* JADX INFO: loaded from: classes2.dex */
public class MainConnectingFragment_ViewBinding implements Unbinder {
    private MainConnectingFragment target;

    public MainConnectingFragment_ViewBinding(MainConnectingFragment mainConnectingFragment, View view) {
        this.target = mainConnectingFragment;
        mainConnectingFragment.lin_1set = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.lin_1set, "field 'lin_1set'", LinearLayout.class);
        mainConnectingFragment.lin_2set = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.lin_2set, "field 'lin_2set'", LinearLayout.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        MainConnectingFragment mainConnectingFragment = this.target;
        if (mainConnectingFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        mainConnectingFragment.lin_1set = null;
        mainConnectingFragment.lin_2set = null;
    }
}
