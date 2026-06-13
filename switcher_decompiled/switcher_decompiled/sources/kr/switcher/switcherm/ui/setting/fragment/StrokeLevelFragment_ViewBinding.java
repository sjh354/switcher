package kr.switcher.switcherm.ui.setting.fragment;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.ui.setting.viewpager.StrokeLevelViewPager;
import me.relex.circleindicator.CircleIndicator;

/* JADX INFO: loaded from: classes2.dex */
public class StrokeLevelFragment_ViewBinding implements Unbinder {
    private StrokeLevelFragment target;
    private View view7f0900c9;
    private View view7f0900cb;
    private View view7f0900d0;

    public StrokeLevelFragment_ViewBinding(final StrokeLevelFragment strokeLevelFragment, View view) {
        this.target = strokeLevelFragment;
        strokeLevelFragment.ci_propose = (CircleIndicator) Utils.findRequiredViewAsType(view, R.id.ci_propose, "field 'ci_propose'", CircleIndicator.class);
        strokeLevelFragment.rl_left_arrow_btn = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_left_arrow_btn, "field 'rl_left_arrow_btn'", RelativeLayout.class);
        strokeLevelFragment.rl_right_arrow_btn = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_right_arrow_btn, "field 'rl_right_arrow_btn'", RelativeLayout.class);
        strokeLevelFragment.iv_left_arrow_btn = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_left_arrow_btn, "field 'iv_left_arrow_btn'", ImageView.class);
        strokeLevelFragment.iv_right_arrow_btn = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_right_arrow_btn, "field 'iv_right_arrow_btn'", ImageView.class);
        strokeLevelFragment.tv_small_level = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_small_level, "field 'tv_small_level'", TextView.class);
        strokeLevelFragment.tv_middle_level = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_middle_level, "field 'tv_middle_level'", TextView.class);
        strokeLevelFragment.tv_long_level = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_long_level, "field 'tv_long_level'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.cb_small_level, "field 'cb_small_level' and method 'onStrokeLevelSmallButtonClicked'");
        strokeLevelFragment.cb_small_level = (CheckBox) Utils.castView(viewFindRequiredView, R.id.cb_small_level, "field 'cb_small_level'", CheckBox.class);
        this.view7f0900d0 = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.setting.fragment.StrokeLevelFragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                strokeLevelFragment.onStrokeLevelSmallButtonClicked();
            }
        });
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.cb_middle_level, "field 'cb_middle_level' and method 'onStrokeLevelMiddleButtonClicked'");
        strokeLevelFragment.cb_middle_level = (CheckBox) Utils.castView(viewFindRequiredView2, R.id.cb_middle_level, "field 'cb_middle_level'", CheckBox.class);
        this.view7f0900cb = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.setting.fragment.StrokeLevelFragment_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                strokeLevelFragment.onStrokeLevelMiddleButtonClicked();
            }
        });
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.cb_long_level, "field 'cb_long_level' and method 'onStrokeLevelLongButtonClicked'");
        strokeLevelFragment.cb_long_level = (CheckBox) Utils.castView(viewFindRequiredView3, R.id.cb_long_level, "field 'cb_long_level'", CheckBox.class);
        this.view7f0900c9 = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.setting.fragment.StrokeLevelFragment_ViewBinding.3
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                strokeLevelFragment.onStrokeLevelLongButtonClicked();
            }
        });
        strokeLevelFragment.vp_propose = (StrokeLevelViewPager) Utils.findRequiredViewAsType(view, R.id.vp_propose, "field 'vp_propose'", StrokeLevelViewPager.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        StrokeLevelFragment strokeLevelFragment = this.target;
        if (strokeLevelFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        strokeLevelFragment.ci_propose = null;
        strokeLevelFragment.rl_left_arrow_btn = null;
        strokeLevelFragment.rl_right_arrow_btn = null;
        strokeLevelFragment.iv_left_arrow_btn = null;
        strokeLevelFragment.iv_right_arrow_btn = null;
        strokeLevelFragment.tv_small_level = null;
        strokeLevelFragment.tv_middle_level = null;
        strokeLevelFragment.tv_long_level = null;
        strokeLevelFragment.cb_small_level = null;
        strokeLevelFragment.cb_middle_level = null;
        strokeLevelFragment.cb_long_level = null;
        strokeLevelFragment.vp_propose = null;
        this.view7f0900d0.setOnClickListener(null);
        this.view7f0900d0 = null;
        this.view7f0900cb.setOnClickListener(null);
        this.view7f0900cb = null;
        this.view7f0900c9.setOnClickListener(null);
        this.view7f0900c9 = null;
    }
}
