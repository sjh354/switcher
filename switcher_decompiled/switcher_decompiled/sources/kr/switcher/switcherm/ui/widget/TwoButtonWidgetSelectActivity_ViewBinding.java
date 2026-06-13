package kr.switcher.switcherm.ui.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import kr.switcher.switcherm.R;

/* JADX INFO: loaded from: classes2.dex */
public class TwoButtonWidgetSelectActivity_ViewBinding implements Unbinder {
    private TwoButtonWidgetSelectActivity target;

    public TwoButtonWidgetSelectActivity_ViewBinding(TwoButtonWidgetSelectActivity twoButtonWidgetSelectActivity) {
        this(twoButtonWidgetSelectActivity, twoButtonWidgetSelectActivity.getWindow().getDecorView());
    }

    public TwoButtonWidgetSelectActivity_ViewBinding(TwoButtonWidgetSelectActivity twoButtonWidgetSelectActivity, View view) {
        this.target = twoButtonWidgetSelectActivity;
        twoButtonWidgetSelectActivity.rv_device_list = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_device_list, "field 'rv_device_list'", RecyclerView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        TwoButtonWidgetSelectActivity twoButtonWidgetSelectActivity = this.target;
        if (twoButtonWidgetSelectActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        twoButtonWidgetSelectActivity.rv_device_list = null;
    }
}
