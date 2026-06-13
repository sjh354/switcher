package kr.switcher.switcherm.ui.main.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import kr.switcher.switcherm.R;

/* JADX INFO: loaded from: classes2.dex */
public class MainConnectedCheckerFragment_ViewBinding implements Unbinder {
    private MainConnectedCheckerFragment target;
    private View view7f09006f;
    private View view7f090097;
    private View view7f09009a;

    public MainConnectedCheckerFragment_ViewBinding(final MainConnectedCheckerFragment mainConnectedCheckerFragment, View view) {
        this.target = mainConnectedCheckerFragment;
        mainConnectedCheckerFragment.tv_is_opened = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_is_opened, "field 'tv_is_opened'", TextView.class);
        mainConnectedCheckerFragment.iv_checker = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_checker, "field 'iv_checker'", ImageView.class);
        mainConnectedCheckerFragment.rl_setting = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_setting, "field 'rl_setting'", RelativeLayout.class);
        mainConnectedCheckerFragment.rl_history = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_history, "field 'rl_history'", RelativeLayout.class);
        mainConnectedCheckerFragment.rl_surbeillance = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_surveillance, "field 'rl_surbeillance'", RelativeLayout.class);
        mainConnectedCheckerFragment.tv_checker_name = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_checker_name, "field 'tv_checker_name'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.btn_surveillance, "field 'btn_surveillance' and method 'onMoveSurveillanceMenuButtonClicked'");
        mainConnectedCheckerFragment.btn_surveillance = (ImageView) Utils.castView(viewFindRequiredView, R.id.btn_surveillance, "field 'btn_surveillance'", ImageView.class);
        this.view7f09009a = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.main.fragment.MainConnectedCheckerFragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                mainConnectedCheckerFragment.onMoveSurveillanceMenuButtonClicked();
            }
        });
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.btn_history, "method 'onMoveHistoryMenuButtonClicked'");
        this.view7f09006f = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.main.fragment.MainConnectedCheckerFragment_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                mainConnectedCheckerFragment.onMoveHistoryMenuButtonClicked();
            }
        });
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.btn_setting, "method 'onMoveSettingMenuButtonClicked'");
        this.view7f090097 = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.main.fragment.MainConnectedCheckerFragment_ViewBinding.3
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                mainConnectedCheckerFragment.onMoveSettingMenuButtonClicked();
            }
        });
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        MainConnectedCheckerFragment mainConnectedCheckerFragment = this.target;
        if (mainConnectedCheckerFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        mainConnectedCheckerFragment.tv_is_opened = null;
        mainConnectedCheckerFragment.iv_checker = null;
        mainConnectedCheckerFragment.rl_setting = null;
        mainConnectedCheckerFragment.rl_history = null;
        mainConnectedCheckerFragment.rl_surbeillance = null;
        mainConnectedCheckerFragment.tv_checker_name = null;
        mainConnectedCheckerFragment.btn_surveillance = null;
        this.view7f09009a.setOnClickListener(null);
        this.view7f09009a = null;
        this.view7f09006f.setOnClickListener(null);
        this.view7f09006f = null;
        this.view7f090097.setOnClickListener(null);
        this.view7f090097 = null;
    }
}
