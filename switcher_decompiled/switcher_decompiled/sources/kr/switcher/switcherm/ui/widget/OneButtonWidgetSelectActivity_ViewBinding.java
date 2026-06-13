package kr.switcher.switcherm.ui.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import kr.switcher.switcherm.R;

/* JADX INFO: loaded from: classes2.dex */
public class OneButtonWidgetSelectActivity_ViewBinding implements Unbinder {
    private OneButtonWidgetSelectActivity target;

    public OneButtonWidgetSelectActivity_ViewBinding(OneButtonWidgetSelectActivity oneButtonWidgetSelectActivity) {
        this(oneButtonWidgetSelectActivity, oneButtonWidgetSelectActivity.getWindow().getDecorView());
    }

    public OneButtonWidgetSelectActivity_ViewBinding(OneButtonWidgetSelectActivity oneButtonWidgetSelectActivity, View view) {
        this.target = oneButtonWidgetSelectActivity;
        oneButtonWidgetSelectActivity.rv_device_list = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_device_list, "field 'rv_device_list'", RecyclerView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        OneButtonWidgetSelectActivity oneButtonWidgetSelectActivity = this.target;
        if (oneButtonWidgetSelectActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        oneButtonWidgetSelectActivity.rv_device_list = null;
    }
}
