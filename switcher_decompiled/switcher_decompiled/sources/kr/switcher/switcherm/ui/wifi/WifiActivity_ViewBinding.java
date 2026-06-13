package kr.switcher.switcherm.ui.wifi;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import kr.switcher.switcherm.R;

/* JADX INFO: loaded from: classes2.dex */
public class WifiActivity_ViewBinding implements Unbinder {
    private WifiActivity target;
    private View view7f090076;

    public WifiActivity_ViewBinding(WifiActivity wifiActivity) {
        this(wifiActivity, wifiActivity.getWindow().getDecorView());
    }

    public WifiActivity_ViewBinding(final WifiActivity wifiActivity, View view) {
        this.target = wifiActivity;
        wifiActivity.tv_menu_name = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_menu_name, "field 'tv_menu_name'", TextView.class);
        wifiActivity.pb_sending = (ProgressBar) Utils.findRequiredViewAsType(view, R.id.pb_sending, "field 'pb_sending'", ProgressBar.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.btn_left_arrow, "method 'onLeftButtonClicked'");
        this.view7f090076 = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.wifi.WifiActivity_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                wifiActivity.onLeftButtonClicked();
            }
        });
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        WifiActivity wifiActivity = this.target;
        if (wifiActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        wifiActivity.tv_menu_name = null;
        wifiActivity.pb_sending = null;
        this.view7f090076.setOnClickListener(null);
        this.view7f090076 = null;
    }
}
