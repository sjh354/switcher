package kr.switcher.switcherm.ui.ircommandtest.fragment;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.wang.avi.AVLoadingIndicatorView;
import kr.switcher.switcherm.R;

/* JADX INFO: loaded from: classes2.dex */
public class LinkerTestIrCommandFragment_ViewBinding implements Unbinder {
    private LinkerTestIrCommandFragment target;
    private View view7f09009f;

    public LinkerTestIrCommandFragment_ViewBinding(final LinkerTestIrCommandFragment linkerTestIrCommandFragment, View view) {
        this.target = linkerTestIrCommandFragment;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.btn_test_command, "field 'btn_test_command' and method 'onTestBtnClicked'");
        linkerTestIrCommandFragment.btn_test_command = (TextView) Utils.castView(viewFindRequiredView, R.id.btn_test_command, "field 'btn_test_command'", TextView.class);
        this.view7f09009f = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.ircommandtest.fragment.LinkerTestIrCommandFragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                linkerTestIrCommandFragment.onTestBtnClicked();
            }
        });
        linkerTestIrCommandFragment.pb_registering = (AVLoadingIndicatorView) Utils.findRequiredViewAsType(view, R.id.pb_registering, "field 'pb_registering'", AVLoadingIndicatorView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        LinkerTestIrCommandFragment linkerTestIrCommandFragment = this.target;
        if (linkerTestIrCommandFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        linkerTestIrCommandFragment.btn_test_command = null;
        linkerTestIrCommandFragment.pb_registering = null;
        this.view7f09009f.setOnClickListener(null);
        this.view7f09009f = null;
    }
}
