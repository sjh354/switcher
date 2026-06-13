package kr.switcher.switcherm.ui.dialog.lowbattery;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import kr.switcher.switcherm.R;

/* JADX INFO: loaded from: classes2.dex */
public class LowBatteryDialogFragment_ViewBinding implements Unbinder {
    private LowBatteryDialogFragment target;
    private View view7f0901f1;

    public LowBatteryDialogFragment_ViewBinding(final LowBatteryDialogFragment lowBatteryDialogFragment, View view) {
        this.target = lowBatteryDialogFragment;
        lowBatteryDialogFragment.tv_current_battery = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_current_battery, "field 'tv_current_battery'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.rl_low_battery, "method 'onViewClicked'");
        this.view7f0901f1 = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.dialog.lowbattery.LowBatteryDialogFragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                lowBatteryDialogFragment.onViewClicked();
            }
        });
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        LowBatteryDialogFragment lowBatteryDialogFragment = this.target;
        if (lowBatteryDialogFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        lowBatteryDialogFragment.tv_current_battery = null;
        this.view7f0901f1.setOnClickListener(null);
        this.view7f0901f1 = null;
    }
}
