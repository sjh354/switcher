package kr.switcher.switcherm.ui.main.fragment;

import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import kr.switcher.switcherm.R;

/* JADX INFO: loaded from: classes2.dex */
public class MainConnectedFragment_ViewBinding implements Unbinder {
    private MainConnectedFragment target;
    private View view7f090085;
    private View view7f090086;
    private View view7f090097;
    private View view7f090098;
    private View view7f0900a0;
    private View view7f0900b4;
    private View view7f0900b5;
    private View view7f0900b6;
    private View view7f0900b7;

    public MainConnectedFragment_ViewBinding(final MainConnectedFragment mainConnectedFragment, View view) {
        this.target = mainConnectedFragment;
        mainConnectedFragment.lin_1set = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.lin_1set, "field 'lin_1set'", LinearLayout.class);
        mainConnectedFragment.lin_2set = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.lin_2set, "field 'lin_2set'", LinearLayout.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.btn_one_set_off, "field 'btn_one_set_off' and method 'onOneSetOffButtonTouched'");
        mainConnectedFragment.btn_one_set_off = (ImageButton) Utils.castView(viewFindRequiredView, R.id.btn_one_set_off, "field 'btn_one_set_off'", ImageButton.class);
        this.view7f090085 = viewFindRequiredView;
        viewFindRequiredView.setOnTouchListener(new View.OnTouchListener() { // from class: kr.switcher.switcherm.ui.main.fragment.MainConnectedFragment_ViewBinding.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                return mainConnectedFragment.onOneSetOffButtonTouched(view2, motionEvent);
            }
        });
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.btn_one_set_on, "field 'btn_one_set_on' and method 'onOneSetOnButtonTouched'");
        mainConnectedFragment.btn_one_set_on = (ImageButton) Utils.castView(viewFindRequiredView2, R.id.btn_one_set_on, "field 'btn_one_set_on'", ImageButton.class);
        this.view7f090086 = viewFindRequiredView2;
        viewFindRequiredView2.setOnTouchListener(new View.OnTouchListener() { // from class: kr.switcher.switcherm.ui.main.fragment.MainConnectedFragment_ViewBinding.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                return mainConnectedFragment.onOneSetOnButtonTouched(view2, motionEvent);
            }
        });
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.btn_two_set_top_off, "field 'btn_two_set_top_off' and method 'onTwoSetTopOffButtonTouched'");
        mainConnectedFragment.btn_two_set_top_off = (ImageButton) Utils.castView(viewFindRequiredView3, R.id.btn_two_set_top_off, "field 'btn_two_set_top_off'", ImageButton.class);
        this.view7f0900b6 = viewFindRequiredView3;
        viewFindRequiredView3.setOnTouchListener(new View.OnTouchListener() { // from class: kr.switcher.switcherm.ui.main.fragment.MainConnectedFragment_ViewBinding.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                return mainConnectedFragment.onTwoSetTopOffButtonTouched(view2, motionEvent);
            }
        });
        View viewFindRequiredView4 = Utils.findRequiredView(view, R.id.btn_two_set_top_on, "field 'btn_two_set_top_on' and method 'onTwoSetTopOnButtonTouched'");
        mainConnectedFragment.btn_two_set_top_on = (ImageButton) Utils.castView(viewFindRequiredView4, R.id.btn_two_set_top_on, "field 'btn_two_set_top_on'", ImageButton.class);
        this.view7f0900b7 = viewFindRequiredView4;
        viewFindRequiredView4.setOnTouchListener(new View.OnTouchListener() { // from class: kr.switcher.switcherm.ui.main.fragment.MainConnectedFragment_ViewBinding.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                return mainConnectedFragment.onTwoSetTopOnButtonTouched(view2, motionEvent);
            }
        });
        View viewFindRequiredView5 = Utils.findRequiredView(view, R.id.btn_two_set_bottom_off, "field 'btn_two_set_bottom_off' and method 'onTwoSetBottomOffButtonTouched'");
        mainConnectedFragment.btn_two_set_bottom_off = (ImageButton) Utils.castView(viewFindRequiredView5, R.id.btn_two_set_bottom_off, "field 'btn_two_set_bottom_off'", ImageButton.class);
        this.view7f0900b4 = viewFindRequiredView5;
        viewFindRequiredView5.setOnTouchListener(new View.OnTouchListener() { // from class: kr.switcher.switcherm.ui.main.fragment.MainConnectedFragment_ViewBinding.5
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                return mainConnectedFragment.onTwoSetBottomOffButtonTouched(view2, motionEvent);
            }
        });
        View viewFindRequiredView6 = Utils.findRequiredView(view, R.id.btn_two_set_bottom_on, "field 'btn_two_set_bottom_on' and method 'onTwoSetBottomOnButtonTouched'");
        mainConnectedFragment.btn_two_set_bottom_on = (ImageButton) Utils.castView(viewFindRequiredView6, R.id.btn_two_set_bottom_on, "field 'btn_two_set_bottom_on'", ImageButton.class);
        this.view7f0900b5 = viewFindRequiredView6;
        viewFindRequiredView6.setOnTouchListener(new View.OnTouchListener() { // from class: kr.switcher.switcherm.ui.main.fragment.MainConnectedFragment_ViewBinding.6
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                return mainConnectedFragment.onTwoSetBottomOnButtonTouched(view2, motionEvent);
            }
        });
        mainConnectedFragment.pb_waiting = (ProgressBar) Utils.findRequiredViewAsType(view, R.id.pb_waiting, "field 'pb_waiting'", ProgressBar.class);
        mainConnectedFragment.iv_model_type = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_model_type, "field 'iv_model_type'", ImageView.class);
        mainConnectedFragment.rl_timer_setting = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_timer_setting, "field 'rl_timer_setting'", RelativeLayout.class);
        mainConnectedFragment.rl_stroke_setting = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_stroke_setting, "field 'rl_stroke_setting'", RelativeLayout.class);
        View viewFindRequiredView7 = Utils.findRequiredView(view, R.id.btn_timer_setting, "method 'onMoveTimerSettingMenuButtonClicked'");
        this.view7f0900a0 = viewFindRequiredView7;
        viewFindRequiredView7.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.main.fragment.MainConnectedFragment_ViewBinding.7
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                mainConnectedFragment.onMoveTimerSettingMenuButtonClicked();
            }
        });
        View viewFindRequiredView8 = Utils.findRequiredView(view, R.id.btn_stroke_setting, "method 'onMoveStrokeSettingMenuButtonClicked'");
        this.view7f090098 = viewFindRequiredView8;
        viewFindRequiredView8.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.main.fragment.MainConnectedFragment_ViewBinding.8
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                mainConnectedFragment.onMoveStrokeSettingMenuButtonClicked();
            }
        });
        View viewFindRequiredView9 = Utils.findRequiredView(view, R.id.btn_setting, "method 'onMoveSettingMenuButtonClicked'");
        this.view7f090097 = viewFindRequiredView9;
        viewFindRequiredView9.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.main.fragment.MainConnectedFragment_ViewBinding.9
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                mainConnectedFragment.onMoveSettingMenuButtonClicked();
            }
        });
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        MainConnectedFragment mainConnectedFragment = this.target;
        if (mainConnectedFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        mainConnectedFragment.lin_1set = null;
        mainConnectedFragment.lin_2set = null;
        mainConnectedFragment.btn_one_set_off = null;
        mainConnectedFragment.btn_one_set_on = null;
        mainConnectedFragment.btn_two_set_top_off = null;
        mainConnectedFragment.btn_two_set_top_on = null;
        mainConnectedFragment.btn_two_set_bottom_off = null;
        mainConnectedFragment.btn_two_set_bottom_on = null;
        mainConnectedFragment.pb_waiting = null;
        mainConnectedFragment.iv_model_type = null;
        mainConnectedFragment.rl_timer_setting = null;
        mainConnectedFragment.rl_stroke_setting = null;
        this.view7f090085.setOnTouchListener(null);
        this.view7f090085 = null;
        this.view7f090086.setOnTouchListener(null);
        this.view7f090086 = null;
        this.view7f0900b6.setOnTouchListener(null);
        this.view7f0900b6 = null;
        this.view7f0900b7.setOnTouchListener(null);
        this.view7f0900b7 = null;
        this.view7f0900b4.setOnTouchListener(null);
        this.view7f0900b4 = null;
        this.view7f0900b5.setOnTouchListener(null);
        this.view7f0900b5 = null;
        this.view7f0900a0.setOnClickListener(null);
        this.view7f0900a0 = null;
        this.view7f090098.setOnClickListener(null);
        this.view7f090098 = null;
        this.view7f090097.setOnClickListener(null);
        this.view7f090097 = null;
    }
}
