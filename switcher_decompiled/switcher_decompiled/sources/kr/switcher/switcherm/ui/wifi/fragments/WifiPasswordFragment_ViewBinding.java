package kr.switcher.switcherm.ui.wifi.fragments;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import kr.switcher.switcherm.R;

/* JADX INFO: loaded from: classes2.dex */
public class WifiPasswordFragment_ViewBinding implements Unbinder {
    private WifiPasswordFragment target;
    private View view7f0900bb;

    public WifiPasswordFragment_ViewBinding(final WifiPasswordFragment wifiPasswordFragment, View view) {
        this.target = wifiPasswordFragment;
        wifiPasswordFragment.tv_wifi_name = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_wifi_name, "field 'tv_wifi_name'", TextView.class);
        wifiPasswordFragment.et_password = (EditText) Utils.findRequiredViewAsType(view, R.id.et_password, "field 'et_password'", EditText.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.btn_wifi_confirm, "method 'onConfirmButtonClicked'");
        this.view7f0900bb = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.wifi.fragments.WifiPasswordFragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                wifiPasswordFragment.onConfirmButtonClicked();
            }
        });
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        WifiPasswordFragment wifiPasswordFragment = this.target;
        if (wifiPasswordFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        wifiPasswordFragment.tv_wifi_name = null;
        wifiPasswordFragment.et_password = null;
        this.view7f0900bb.setOnClickListener(null);
        this.view7f0900bb = null;
    }
}
