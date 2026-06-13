package kr.switcher.switcherm.ui.ircommandtest.fragment;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import kr.switcher.switcherm.R;

/* JADX INFO: loaded from: classes2.dex */
public class LinkerInsertIrCommandFragment_ViewBinding implements Unbinder {
    private LinkerInsertIrCommandFragment target;
    private View view7f090073;

    public LinkerInsertIrCommandFragment_ViewBinding(final LinkerInsertIrCommandFragment linkerInsertIrCommandFragment, View view) {
        this.target = linkerInsertIrCommandFragment;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.btn_insert_command, "field 'btn_insert_command' and method 'onCommandInsertButtonClicked'");
        linkerInsertIrCommandFragment.btn_insert_command = (TextView) Utils.castView(viewFindRequiredView, R.id.btn_insert_command, "field 'btn_insert_command'", TextView.class);
        this.view7f090073 = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.ircommandtest.fragment.LinkerInsertIrCommandFragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                linkerInsertIrCommandFragment.onCommandInsertButtonClicked();
            }
        });
        linkerInsertIrCommandFragment.tv_command_name = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_command_name, "field 'tv_command_name'", TextView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        LinkerInsertIrCommandFragment linkerInsertIrCommandFragment = this.target;
        if (linkerInsertIrCommandFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        linkerInsertIrCommandFragment.btn_insert_command = null;
        linkerInsertIrCommandFragment.tv_command_name = null;
        this.view7f090073.setOnClickListener(null);
        this.view7f090073 = null;
    }
}
