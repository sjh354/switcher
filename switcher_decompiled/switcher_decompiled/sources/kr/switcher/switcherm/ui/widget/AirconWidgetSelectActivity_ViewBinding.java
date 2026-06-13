package kr.switcher.switcherm.ui.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import kr.switcher.switcherm.R;

/* JADX INFO: loaded from: classes2.dex */
public class AirconWidgetSelectActivity_ViewBinding implements Unbinder {
    private AirconWidgetSelectActivity target;

    public AirconWidgetSelectActivity_ViewBinding(AirconWidgetSelectActivity airconWidgetSelectActivity) {
        this(airconWidgetSelectActivity, airconWidgetSelectActivity.getWindow().getDecorView());
    }

    public AirconWidgetSelectActivity_ViewBinding(AirconWidgetSelectActivity airconWidgetSelectActivity, View view) {
        this.target = airconWidgetSelectActivity;
        airconWidgetSelectActivity.rv_device_list = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_device_list, "field 'rv_device_list'", RecyclerView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        AirconWidgetSelectActivity airconWidgetSelectActivity = this.target;
        if (airconWidgetSelectActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        airconWidgetSelectActivity.rv_device_list = null;
    }
}
