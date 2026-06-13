package kr.switcher.switcherm.ui.setting.fragment;

import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.rey.material.widget.Switch;
import kr.switcher.switcherm.R;

/* JADX INFO: loaded from: classes2.dex */
public class SettingListFragment_ViewBinding implements Unbinder {
    private SettingListFragment target;
    private View view7f0900ca;
    private View view7f090234;

    public SettingListFragment_ViewBinding(final SettingListFragment settingListFragment, View view) {
        this.target = settingListFragment;
        settingListFragment.rl_share_code = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_share_code, "field 'rl_share_code'", RelativeLayout.class);
        settingListFragment.rl_selector_main_switcher = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_selector_main_switcher, "field 'rl_selector_main_switcher'", RelativeLayout.class);
        settingListFragment.rl_firmware_update = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_firmware_update, "field 'rl_firmware_update'", RelativeLayout.class);
        settingListFragment.et_room_name = (EditText) Utils.findRequiredViewAsType(view, R.id.et_room_name, "field 'et_room_name'", EditText.class);
        settingListFragment.tv_firmware_version = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_firmware_version, "field 'tv_firmware_version'", TextView.class);
        settingListFragment.tv_new = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_new, "field 'tv_new'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.cb_main_switcher, "field 'cb_main_switcher' and method 'onMainSwitcherButtonClicked'");
        settingListFragment.cb_main_switcher = (CheckBox) Utils.castView(viewFindRequiredView, R.id.cb_main_switcher, "field 'cb_main_switcher'", CheckBox.class);
        this.view7f0900ca = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.setting.fragment.SettingListFragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                settingListFragment.onMainSwitcherButtonClicked();
            }
        });
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.sc_mirror_button, "field 'sc_mirror_button' and method 'onMirrorButtonClicked'");
        settingListFragment.sc_mirror_button = (Switch) Utils.castView(viewFindRequiredView2, R.id.sc_mirror_button, "field 'sc_mirror_button'", Switch.class);
        this.view7f090234 = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.setting.fragment.SettingListFragment_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                settingListFragment.onMirrorButtonClicked();
            }
        });
        settingListFragment.tv_name = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_name, "field 'tv_name'", TextView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        SettingListFragment settingListFragment = this.target;
        if (settingListFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        settingListFragment.rl_share_code = null;
        settingListFragment.rl_selector_main_switcher = null;
        settingListFragment.rl_firmware_update = null;
        settingListFragment.et_room_name = null;
        settingListFragment.tv_firmware_version = null;
        settingListFragment.tv_new = null;
        settingListFragment.cb_main_switcher = null;
        settingListFragment.sc_mirror_button = null;
        settingListFragment.tv_name = null;
        this.view7f0900ca.setOnClickListener(null);
        this.view7f0900ca = null;
        this.view7f090234.setOnClickListener(null);
        this.view7f090234 = null;
    }
}
