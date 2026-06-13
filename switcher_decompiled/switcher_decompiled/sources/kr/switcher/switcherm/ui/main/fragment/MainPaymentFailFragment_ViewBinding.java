package kr.switcher.switcherm.ui.main.fragment;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import kr.switcher.switcherm.R;

/* JADX INFO: loaded from: classes2.dex */
public class MainPaymentFailFragment_ViewBinding implements Unbinder {
    private MainPaymentFailFragment target;

    public MainPaymentFailFragment_ViewBinding(MainPaymentFailFragment mainPaymentFailFragment, View view) {
        this.target = mainPaymentFailFragment;
        mainPaymentFailFragment.tv_start_date_time = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_start_date_time, "field 'tv_start_date_time'", TextView.class);
        mainPaymentFailFragment.tv_end_date_time = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_end_date_time, "field 'tv_end_date_time'", TextView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        MainPaymentFailFragment mainPaymentFailFragment = this.target;
        if (mainPaymentFailFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        mainPaymentFailFragment.tv_start_date_time = null;
        mainPaymentFailFragment.tv_end_date_time = null;
    }
}
