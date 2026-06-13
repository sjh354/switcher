package kr.switcher.switcherm.ui.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import kr.switcher.switcherm.R;

/* JADX INFO: loaded from: classes2.dex */
public class SettopWidgetSelectActivity_ViewBinding implements Unbinder {
    private SettopWidgetSelectActivity target;

    public SettopWidgetSelectActivity_ViewBinding(SettopWidgetSelectActivity settopWidgetSelectActivity) {
        this(settopWidgetSelectActivity, settopWidgetSelectActivity.getWindow().getDecorView());
    }

    public SettopWidgetSelectActivity_ViewBinding(SettopWidgetSelectActivity settopWidgetSelectActivity, View view) {
        this.target = settopWidgetSelectActivity;
        settopWidgetSelectActivity.rv_device_list = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_device_list, "field 'rv_device_list'", RecyclerView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        SettopWidgetSelectActivity settopWidgetSelectActivity = this.target;
        if (settopWidgetSelectActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        settopWidgetSelectActivity.rv_device_list = null;
    }
}
