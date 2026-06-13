package kr.switcher.switcherm.ui.main.fragment;

import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.wang.avi.AVLoadingIndicatorView;
import kr.switcher.switcherm.R;

/* JADX INFO: loaded from: classes2.dex */
public class SettopRemoconConnectedFragment_ViewBinding implements Unbinder {
    private SettopRemoconConnectedFragment target;
    private View view7f090090;
    private View view7f0900a6;
    private View view7f0900a7;
    private View view7f0900a8;
    private View view7f0900a9;
    private View view7f0900aa;
    private View view7f0900ab;
    private View view7f0900ac;
    private View view7f0900ad;
    private View view7f0900ae;
    private View view7f0900af;
    private View view7f0900b0;
    private View view7f0900b1;
    private View view7f0900b2;
    private View view7f0900b3;
    private View view7f0900ba;

    public SettopRemoconConnectedFragment_ViewBinding(final SettopRemoconConnectedFragment settopRemoconConnectedFragment, View view) {
        this.target = settopRemoconConnectedFragment;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.btn_reservation, "field 'btn_reservation' and method 'onReservationButtonClicked'");
        settopRemoconConnectedFragment.btn_reservation = (ImageButton) Utils.castView(viewFindRequiredView, R.id.btn_reservation, "field 'btn_reservation'", ImageButton.class);
        this.view7f090090 = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.main.fragment.SettopRemoconConnectedFragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                settopRemoconConnectedFragment.onReservationButtonClicked();
            }
        });
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.btn_widget, "field 'btn_widget' and method 'onWidgetButtonClicked'");
        settopRemoconConnectedFragment.btn_widget = (ImageButton) Utils.castView(viewFindRequiredView2, R.id.btn_widget, "field 'btn_widget'", ImageButton.class);
        this.view7f0900ba = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.main.fragment.SettopRemoconConnectedFragment_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                settopRemoconConnectedFragment.onWidgetButtonClicked();
            }
        });
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.btn_tv_confirm, "field 'btn_tv_confirm' and method 'onConfirmButtonClicked'");
        settopRemoconConnectedFragment.btn_tv_confirm = (ImageButton) Utils.castView(viewFindRequiredView3, R.id.btn_tv_confirm, "field 'btn_tv_confirm'", ImageButton.class);
        this.view7f0900aa = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.main.fragment.SettopRemoconConnectedFragment_ViewBinding.3
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                settopRemoconConnectedFragment.onConfirmButtonClicked();
            }
        });
        View viewFindRequiredView4 = Utils.findRequiredView(view, R.id.btn_tv_up, "field 'btn_tv_up' and method 'onUpButtonClicked'");
        settopRemoconConnectedFragment.btn_tv_up = (ImageButton) Utils.castView(viewFindRequiredView4, R.id.btn_tv_up, "field 'btn_tv_up'", ImageButton.class);
        this.view7f0900b1 = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.main.fragment.SettopRemoconConnectedFragment_ViewBinding.4
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                settopRemoconConnectedFragment.onUpButtonClicked();
            }
        });
        View viewFindRequiredView5 = Utils.findRequiredView(view, R.id.btn_tv_down, "field 'btn_tv_down' and method 'onDownButtonClicked'");
        settopRemoconConnectedFragment.btn_tv_down = (ImageButton) Utils.castView(viewFindRequiredView5, R.id.btn_tv_down, "field 'btn_tv_down'", ImageButton.class);
        this.view7f0900ab = viewFindRequiredView5;
        viewFindRequiredView5.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.main.fragment.SettopRemoconConnectedFragment_ViewBinding.5
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                settopRemoconConnectedFragment.onDownButtonClicked();
            }
        });
        View viewFindRequiredView6 = Utils.findRequiredView(view, R.id.btn_tv_left, "field 'btn_tv_left' and method 'onLeftButtonClicked'");
        settopRemoconConnectedFragment.btn_tv_left = (ImageButton) Utils.castView(viewFindRequiredView6, R.id.btn_tv_left, "field 'btn_tv_left'", ImageButton.class);
        this.view7f0900ac = viewFindRequiredView6;
        viewFindRequiredView6.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.main.fragment.SettopRemoconConnectedFragment_ViewBinding.6
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                settopRemoconConnectedFragment.onLeftButtonClicked();
            }
        });
        View viewFindRequiredView7 = Utils.findRequiredView(view, R.id.btn_tv_right, "field 'btn_tv_right' and method 'onRightButtonClicked'");
        settopRemoconConnectedFragment.btn_tv_right = (ImageButton) Utils.castView(viewFindRequiredView7, R.id.btn_tv_right, "field 'btn_tv_right'", ImageButton.class);
        this.view7f0900af = viewFindRequiredView7;
        viewFindRequiredView7.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.main.fragment.SettopRemoconConnectedFragment_ViewBinding.7
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                settopRemoconConnectedFragment.onRightButtonClicked();
            }
        });
        View viewFindRequiredView8 = Utils.findRequiredView(view, R.id.btn_tv_previous, "field 'btn_tv_previous' and method 'onPreviousButtonClicked'");
        settopRemoconConnectedFragment.btn_tv_previous = (ImageButton) Utils.castView(viewFindRequiredView8, R.id.btn_tv_previous, "field 'btn_tv_previous'", ImageButton.class);
        this.view7f0900ae = viewFindRequiredView8;
        viewFindRequiredView8.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.main.fragment.SettopRemoconConnectedFragment_ViewBinding.8
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                settopRemoconConnectedFragment.onPreviousButtonClicked();
            }
        });
        View viewFindRequiredView9 = Utils.findRequiredView(view, R.id.btn_tv_cancel, "field 'btn_tv_cancel' and method 'onCancelButtonClicked'");
        settopRemoconConnectedFragment.btn_tv_cancel = (ImageButton) Utils.castView(viewFindRequiredView9, R.id.btn_tv_cancel, "field 'btn_tv_cancel'", ImageButton.class);
        this.view7f0900a6 = viewFindRequiredView9;
        viewFindRequiredView9.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.main.fragment.SettopRemoconConnectedFragment_ViewBinding.9
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                settopRemoconConnectedFragment.onCancelButtonClicked();
            }
        });
        View viewFindRequiredView10 = Utils.findRequiredView(view, R.id.btn_tv_timetable, "field 'btn_tv_timetable' and method 'onTimeTableButtonClicked'");
        settopRemoconConnectedFragment.btn_tv_timetable = (ImageButton) Utils.castView(viewFindRequiredView10, R.id.btn_tv_timetable, "field 'btn_tv_timetable'", ImageButton.class);
        this.view7f0900b0 = viewFindRequiredView10;
        viewFindRequiredView10.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.main.fragment.SettopRemoconConnectedFragment_ViewBinding.10
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                settopRemoconConnectedFragment.onTimeTableButtonClicked();
            }
        });
        View viewFindRequiredView11 = Utils.findRequiredView(view, R.id.btn_tv_power, "field 'btn_tv_power' and method 'onPowerButtonClicked'");
        settopRemoconConnectedFragment.btn_tv_power = (ImageButton) Utils.castView(viewFindRequiredView11, R.id.btn_tv_power, "field 'btn_tv_power'", ImageButton.class);
        this.view7f0900ad = viewFindRequiredView11;
        viewFindRequiredView11.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.main.fragment.SettopRemoconConnectedFragment_ViewBinding.11
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                settopRemoconConnectedFragment.onPowerButtonClicked();
            }
        });
        View viewFindRequiredView12 = Utils.findRequiredView(view, R.id.btn_tv_channel, "field 'btn_tv_channel' and method 'onChannelButtonClicked'");
        settopRemoconConnectedFragment.btn_tv_channel = (ImageButton) Utils.castView(viewFindRequiredView12, R.id.btn_tv_channel, "field 'btn_tv_channel'", ImageButton.class);
        this.view7f0900a7 = viewFindRequiredView12;
        viewFindRequiredView12.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.main.fragment.SettopRemoconConnectedFragment_ViewBinding.12
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                settopRemoconConnectedFragment.onChannelButtonClicked();
            }
        });
        View viewFindRequiredView13 = Utils.findRequiredView(view, R.id.btn_tv_volume_up, "field 'btn_tv_volume_up' and method 'onVolumeUpButtonTouched'");
        settopRemoconConnectedFragment.btn_tv_volume_up = (ImageButton) Utils.castView(viewFindRequiredView13, R.id.btn_tv_volume_up, "field 'btn_tv_volume_up'", ImageButton.class);
        this.view7f0900b3 = viewFindRequiredView13;
        viewFindRequiredView13.setOnTouchListener(new View.OnTouchListener() { // from class: kr.switcher.switcherm.ui.main.fragment.SettopRemoconConnectedFragment_ViewBinding.13
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                return settopRemoconConnectedFragment.onVolumeUpButtonTouched(view2, motionEvent);
            }
        });
        View viewFindRequiredView14 = Utils.findRequiredView(view, R.id.btn_tv_volume_down, "field 'btn_tv_volume_down' and method 'onVolumeDownButtonTouched'");
        settopRemoconConnectedFragment.btn_tv_volume_down = (ImageButton) Utils.castView(viewFindRequiredView14, R.id.btn_tv_volume_down, "field 'btn_tv_volume_down'", ImageButton.class);
        this.view7f0900b2 = viewFindRequiredView14;
        viewFindRequiredView14.setOnTouchListener(new View.OnTouchListener() { // from class: kr.switcher.switcherm.ui.main.fragment.SettopRemoconConnectedFragment_ViewBinding.14
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                return settopRemoconConnectedFragment.onVolumeDownButtonTouched(view2, motionEvent);
            }
        });
        View viewFindRequiredView15 = Utils.findRequiredView(view, R.id.btn_tv_channel_up, "field 'btn_tv_channel_up' and method 'onChannelUpButtonTouched'");
        settopRemoconConnectedFragment.btn_tv_channel_up = (ImageButton) Utils.castView(viewFindRequiredView15, R.id.btn_tv_channel_up, "field 'btn_tv_channel_up'", ImageButton.class);
        this.view7f0900a9 = viewFindRequiredView15;
        viewFindRequiredView15.setOnTouchListener(new View.OnTouchListener() { // from class: kr.switcher.switcherm.ui.main.fragment.SettopRemoconConnectedFragment_ViewBinding.15
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                return settopRemoconConnectedFragment.onChannelUpButtonTouched(view2, motionEvent);
            }
        });
        View viewFindRequiredView16 = Utils.findRequiredView(view, R.id.btn_tv_channel_down, "field 'btn_tv_channel_down' and method 'onChannelDownButtonTouched'");
        settopRemoconConnectedFragment.btn_tv_channel_down = (ImageButton) Utils.castView(viewFindRequiredView16, R.id.btn_tv_channel_down, "field 'btn_tv_channel_down'", ImageButton.class);
        this.view7f0900a8 = viewFindRequiredView16;
        viewFindRequiredView16.setOnTouchListener(new View.OnTouchListener() { // from class: kr.switcher.switcherm.ui.main.fragment.SettopRemoconConnectedFragment_ViewBinding.16
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                return settopRemoconConnectedFragment.onChannelDownButtonTouched(view2, motionEvent);
            }
        });
        settopRemoconConnectedFragment.rv_command_list = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_command_list, "field 'rv_command_list'", RecyclerView.class);
        settopRemoconConnectedFragment.pb_registering = (AVLoadingIndicatorView) Utils.findRequiredViewAsType(view, R.id.pb_registering, "field 'pb_registering'", AVLoadingIndicatorView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        SettopRemoconConnectedFragment settopRemoconConnectedFragment = this.target;
        if (settopRemoconConnectedFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        settopRemoconConnectedFragment.btn_reservation = null;
        settopRemoconConnectedFragment.btn_widget = null;
        settopRemoconConnectedFragment.btn_tv_confirm = null;
        settopRemoconConnectedFragment.btn_tv_up = null;
        settopRemoconConnectedFragment.btn_tv_down = null;
        settopRemoconConnectedFragment.btn_tv_left = null;
        settopRemoconConnectedFragment.btn_tv_right = null;
        settopRemoconConnectedFragment.btn_tv_previous = null;
        settopRemoconConnectedFragment.btn_tv_cancel = null;
        settopRemoconConnectedFragment.btn_tv_timetable = null;
        settopRemoconConnectedFragment.btn_tv_power = null;
        settopRemoconConnectedFragment.btn_tv_channel = null;
        settopRemoconConnectedFragment.btn_tv_volume_up = null;
        settopRemoconConnectedFragment.btn_tv_volume_down = null;
        settopRemoconConnectedFragment.btn_tv_channel_up = null;
        settopRemoconConnectedFragment.btn_tv_channel_down = null;
        settopRemoconConnectedFragment.rv_command_list = null;
        settopRemoconConnectedFragment.pb_registering = null;
        this.view7f090090.setOnClickListener(null);
        this.view7f090090 = null;
        this.view7f0900ba.setOnClickListener(null);
        this.view7f0900ba = null;
        this.view7f0900aa.setOnClickListener(null);
        this.view7f0900aa = null;
        this.view7f0900b1.setOnClickListener(null);
        this.view7f0900b1 = null;
        this.view7f0900ab.setOnClickListener(null);
        this.view7f0900ab = null;
        this.view7f0900ac.setOnClickListener(null);
        this.view7f0900ac = null;
        this.view7f0900af.setOnClickListener(null);
        this.view7f0900af = null;
        this.view7f0900ae.setOnClickListener(null);
        this.view7f0900ae = null;
        this.view7f0900a6.setOnClickListener(null);
        this.view7f0900a6 = null;
        this.view7f0900b0.setOnClickListener(null);
        this.view7f0900b0 = null;
        this.view7f0900ad.setOnClickListener(null);
        this.view7f0900ad = null;
        this.view7f0900a7.setOnClickListener(null);
        this.view7f0900a7 = null;
        this.view7f0900b3.setOnTouchListener(null);
        this.view7f0900b3 = null;
        this.view7f0900b2.setOnTouchListener(null);
        this.view7f0900b2 = null;
        this.view7f0900a9.setOnTouchListener(null);
        this.view7f0900a9 = null;
        this.view7f0900a8.setOnTouchListener(null);
        this.view7f0900a8 = null;
    }
}
