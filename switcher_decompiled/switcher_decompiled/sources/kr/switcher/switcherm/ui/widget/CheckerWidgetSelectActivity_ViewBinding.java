package kr.switcher.switcherm.ui.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import kr.switcher.switcherm.R;

/* JADX INFO: loaded from: classes2.dex */
public class CheckerWidgetSelectActivity_ViewBinding implements Unbinder {
    private CheckerWidgetSelectActivity target;

    public CheckerWidgetSelectActivity_ViewBinding(CheckerWidgetSelectActivity checkerWidgetSelectActivity) {
        this(checkerWidgetSelectActivity, checkerWidgetSelectActivity.getWindow().getDecorView());
    }

    public CheckerWidgetSelectActivity_ViewBinding(CheckerWidgetSelectActivity checkerWidgetSelectActivity, View view) {
        this.target = checkerWidgetSelectActivity;
        checkerWidgetSelectActivity.rv_device_list = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_device_list, "field 'rv_device_list'", RecyclerView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        CheckerWidgetSelectActivity checkerWidgetSelectActivity = this.target;
        if (checkerWidgetSelectActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        checkerWidgetSelectActivity.rv_device_list = null;
    }
}
