package kr.switcher.switcherm.ui.troubleshooting.fragment;

import android.view.View;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import kr.switcher.switcherm.R;

/* JADX INFO: loaded from: classes2.dex */
public class HelpTroubleshootingFragment_ViewBinding implements Unbinder {
    private HelpTroubleshootingFragment target;
    private View view7f09005f;
    private View view7f09006e;
    private View view7f0900bc;
    private View view7f0900c5;
    private View view7f0900c8;

    public HelpTroubleshootingFragment_ViewBinding(final HelpTroubleshootingFragment helpTroubleshootingFragment, View view) {
        this.target = helpTroubleshootingFragment;
        helpTroubleshootingFragment.tv_cafe_link = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_cafe_link, "field 'tv_cafe_link'", TextView.class);
        helpTroubleshootingFragment.tv_yello_id_link = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_yello_id_link, "field 'tv_yello_id_link'", TextView.class);
        helpTroubleshootingFragment.tv_gps_setting = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_gps_setting, "field 'tv_gps_setting'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.btn_gps_setting, "field 'btn_gps_setting' and method 'onGPSSettingTextClicked'");
        helpTroubleshootingFragment.btn_gps_setting = (RelativeLayout) Utils.castView(viewFindRequiredView, R.id.btn_gps_setting, "field 'btn_gps_setting'", RelativeLayout.class);
        this.view7f09006e = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.troubleshooting.fragment.HelpTroubleshootingFragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                helpTroubleshootingFragment.onGPSSettingTextClicked();
            }
        });
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.cb_gps, "field 'cb_gps' and method 'onGPSSettingChecked'");
        helpTroubleshootingFragment.cb_gps = (CheckBox) Utils.castView(viewFindRequiredView2, R.id.cb_gps, "field 'cb_gps'", CheckBox.class);
        this.view7f0900c8 = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.troubleshooting.fragment.HelpTroubleshootingFragment_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                helpTroubleshootingFragment.onGPSSettingChecked();
            }
        });
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.cb_bluetooth, "field 'cb_bluetooth' and method 'onBluetoothSettingChecked'");
        helpTroubleshootingFragment.cb_bluetooth = (CheckBox) Utils.castView(viewFindRequiredView3, R.id.cb_bluetooth, "field 'cb_bluetooth'", CheckBox.class);
        this.view7f0900c5 = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.troubleshooting.fragment.HelpTroubleshootingFragment_ViewBinding.3
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                helpTroubleshootingFragment.onBluetoothSettingChecked();
            }
        });
        View viewFindRequiredView4 = Utils.findRequiredView(view, R.id.btn_cafe_link, "method 'onCafeLinkButtonClicked'");
        this.view7f09005f = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.troubleshooting.fragment.HelpTroubleshootingFragment_ViewBinding.4
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                helpTroubleshootingFragment.onCafeLinkButtonClicked();
            }
        });
        View viewFindRequiredView5 = Utils.findRequiredView(view, R.id.btn_yello_id_link, "method 'onYelloIDLinkButtonClicked'");
        this.view7f0900bc = viewFindRequiredView5;
        viewFindRequiredView5.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.troubleshooting.fragment.HelpTroubleshootingFragment_ViewBinding.5
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                helpTroubleshootingFragment.onYelloIDLinkButtonClicked();
            }
        });
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        HelpTroubleshootingFragment helpTroubleshootingFragment = this.target;
        if (helpTroubleshootingFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        helpTroubleshootingFragment.tv_cafe_link = null;
        helpTroubleshootingFragment.tv_yello_id_link = null;
        helpTroubleshootingFragment.tv_gps_setting = null;
        helpTroubleshootingFragment.btn_gps_setting = null;
        helpTroubleshootingFragment.cb_gps = null;
        helpTroubleshootingFragment.cb_bluetooth = null;
        this.view7f09006e.setOnClickListener(null);
        this.view7f09006e = null;
        this.view7f0900c8.setOnClickListener(null);
        this.view7f0900c8 = null;
        this.view7f0900c5.setOnClickListener(null);
        this.view7f0900c5 = null;
        this.view7f09005f.setOnClickListener(null);
        this.view7f09005f = null;
        this.view7f0900bc.setOnClickListener(null);
        this.view7f0900bc = null;
    }
}
