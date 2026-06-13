package kr.switcher.switcherm.ui.main.fragment;

import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import antistatic.spinnerwheel.AbstractWheel;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.wang.avi.AVLoadingIndicatorView;
import kr.switcher.switcherm.R;

/* JADX INFO: loaded from: classes2.dex */
public class AirconRemoconConnectedFragment_ViewBinding implements Unbinder {
    private AirconRemoconConnectedFragment target;
    private View view7f09004f;
    private View view7f090050;
    private View view7f090051;
    private View view7f090069;
    private View view7f09006d;
    private View view7f090070;
    private View view7f090079;
    private View view7f090090;
    private View view7f0900ba;

    public AirconRemoconConnectedFragment_ViewBinding(final AirconRemoconConnectedFragment airconRemoconConnectedFragment, View view) {
        this.target = airconRemoconConnectedFragment;
        airconRemoconConnectedFragment.wh_temperature = (AbstractWheel) Utils.findRequiredViewAsType(view, R.id.wh_temperature, "field 'wh_temperature'", AbstractWheel.class);
        airconRemoconConnectedFragment.pb_registering = (AVLoadingIndicatorView) Utils.findRequiredViewAsType(view, R.id.pb_registering, "field 'pb_registering'", AVLoadingIndicatorView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.btn_mode, "field 'btn_mode' and method 'onModeButtonClicked'");
        airconRemoconConnectedFragment.btn_mode = (ImageButton) Utils.castView(viewFindRequiredView, R.id.btn_mode, "field 'btn_mode'", ImageButton.class);
        this.view7f090079 = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.main.fragment.AirconRemoconConnectedFragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                airconRemoconConnectedFragment.onModeButtonClicked();
            }
        });
        airconRemoconConnectedFragment.rv_command_list = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_command_list, "field 'rv_command_list'", RecyclerView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.btn_air_volume, "field 'btn_air_volume' and method 'onAirVolumeButtonClicked'");
        airconRemoconConnectedFragment.btn_air_volume = (ImageButton) Utils.castView(viewFindRequiredView2, R.id.btn_air_volume, "field 'btn_air_volume'", ImageButton.class);
        this.view7f09004f = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.main.fragment.AirconRemoconConnectedFragment_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                airconRemoconConnectedFragment.onAirVolumeButtonClicked();
            }
        });
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.btn_etc, "field 'btn_etc' and method 'onETCButtonClicked'");
        airconRemoconConnectedFragment.btn_etc = (ImageButton) Utils.castView(viewFindRequiredView3, R.id.btn_etc, "field 'btn_etc'", ImageButton.class);
        this.view7f09006d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.main.fragment.AirconRemoconConnectedFragment_ViewBinding.3
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                airconRemoconConnectedFragment.onETCButtonClicked();
            }
        });
        View viewFindRequiredView4 = Utils.findRequiredView(view, R.id.btn_custom, "field 'btn_custom' and method 'onCustomButtonClicked'");
        airconRemoconConnectedFragment.btn_custom = (ImageButton) Utils.castView(viewFindRequiredView4, R.id.btn_custom, "field 'btn_custom'", ImageButton.class);
        this.view7f090069 = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.main.fragment.AirconRemoconConnectedFragment_ViewBinding.4
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                airconRemoconConnectedFragment.onCustomButtonClicked();
            }
        });
        View viewFindRequiredView5 = Utils.findRequiredView(view, R.id.btn_reservation, "field 'btn_reservation' and method 'onReservationButtonClicked'");
        airconRemoconConnectedFragment.btn_reservation = (ImageButton) Utils.castView(viewFindRequiredView5, R.id.btn_reservation, "field 'btn_reservation'", ImageButton.class);
        this.view7f090090 = viewFindRequiredView5;
        viewFindRequiredView5.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.main.fragment.AirconRemoconConnectedFragment_ViewBinding.5
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                airconRemoconConnectedFragment.onReservationButtonClicked();
            }
        });
        View viewFindRequiredView6 = Utils.findRequiredView(view, R.id.btn_hold_temperature, "field 'btn_hold_temperature' and method 'onHoldTemperatureButtonClicked'");
        airconRemoconConnectedFragment.btn_hold_temperature = (ImageButton) Utils.castView(viewFindRequiredView6, R.id.btn_hold_temperature, "field 'btn_hold_temperature'", ImageButton.class);
        this.view7f090070 = viewFindRequiredView6;
        viewFindRequiredView6.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.main.fragment.AirconRemoconConnectedFragment_ViewBinding.6
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                airconRemoconConnectedFragment.onHoldTemperatureButtonClicked();
            }
        });
        View viewFindRequiredView7 = Utils.findRequiredView(view, R.id.btn_widget, "field 'btn_widget' and method 'onWidgetButtonClicked'");
        airconRemoconConnectedFragment.btn_widget = (ImageButton) Utils.castView(viewFindRequiredView7, R.id.btn_widget, "field 'btn_widget'", ImageButton.class);
        this.view7f0900ba = viewFindRequiredView7;
        viewFindRequiredView7.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.main.fragment.AirconRemoconConnectedFragment_ViewBinding.7
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                airconRemoconConnectedFragment.onWidgetButtonClicked();
            }
        });
        View viewFindRequiredView8 = Utils.findRequiredView(view, R.id.btn_aircon_on, "field 'btn_aircon_on' and method 'onAirconONButtonClicked'");
        airconRemoconConnectedFragment.btn_aircon_on = (LinearLayout) Utils.castView(viewFindRequiredView8, R.id.btn_aircon_on, "field 'btn_aircon_on'", LinearLayout.class);
        this.view7f090051 = viewFindRequiredView8;
        viewFindRequiredView8.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.main.fragment.AirconRemoconConnectedFragment_ViewBinding.8
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                airconRemoconConnectedFragment.onAirconONButtonClicked();
            }
        });
        View viewFindRequiredView9 = Utils.findRequiredView(view, R.id.btn_aircon_off, "field 'btn_aircon_off' and method 'onAirconOFFButtonClicked'");
        airconRemoconConnectedFragment.btn_aircon_off = (LinearLayout) Utils.castView(viewFindRequiredView9, R.id.btn_aircon_off, "field 'btn_aircon_off'", LinearLayout.class);
        this.view7f090050 = viewFindRequiredView9;
        viewFindRequiredView9.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.main.fragment.AirconRemoconConnectedFragment_ViewBinding.9
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                airconRemoconConnectedFragment.onAirconOFFButtonClicked();
            }
        });
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        AirconRemoconConnectedFragment airconRemoconConnectedFragment = this.target;
        if (airconRemoconConnectedFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        airconRemoconConnectedFragment.wh_temperature = null;
        airconRemoconConnectedFragment.pb_registering = null;
        airconRemoconConnectedFragment.btn_mode = null;
        airconRemoconConnectedFragment.rv_command_list = null;
        airconRemoconConnectedFragment.btn_air_volume = null;
        airconRemoconConnectedFragment.btn_etc = null;
        airconRemoconConnectedFragment.btn_custom = null;
        airconRemoconConnectedFragment.btn_reservation = null;
        airconRemoconConnectedFragment.btn_hold_temperature = null;
        airconRemoconConnectedFragment.btn_widget = null;
        airconRemoconConnectedFragment.btn_aircon_on = null;
        airconRemoconConnectedFragment.btn_aircon_off = null;
        this.view7f090079.setOnClickListener(null);
        this.view7f090079 = null;
        this.view7f09004f.setOnClickListener(null);
        this.view7f09004f = null;
        this.view7f09006d.setOnClickListener(null);
        this.view7f09006d = null;
        this.view7f090069.setOnClickListener(null);
        this.view7f090069 = null;
        this.view7f090090.setOnClickListener(null);
        this.view7f090090 = null;
        this.view7f090070.setOnClickListener(null);
        this.view7f090070 = null;
        this.view7f0900ba.setOnClickListener(null);
        this.view7f0900ba = null;
        this.view7f090051.setOnClickListener(null);
        this.view7f090051 = null;
        this.view7f090050.setOnClickListener(null);
        this.view7f090050 = null;
    }
}
