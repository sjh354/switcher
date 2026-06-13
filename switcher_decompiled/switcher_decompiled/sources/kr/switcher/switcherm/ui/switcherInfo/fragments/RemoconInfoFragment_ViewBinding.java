package kr.switcher.switcherm.ui.switcherInfo.fragments;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import kr.switcher.switcherm.R;

/* JADX INFO: loaded from: classes2.dex */
public class RemoconInfoFragment_ViewBinding implements Unbinder {
    private RemoconInfoFragment target;
    private View view7f09006b;

    public RemoconInfoFragment_ViewBinding(final RemoconInfoFragment remoconInfoFragment, View view) {
        this.target = remoconInfoFragment;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.btn_delete_remocon, "field 'btn_delete_remocon' and method 'onDeleteButtonClicked'");
        remoconInfoFragment.btn_delete_remocon = (TextView) Utils.castView(viewFindRequiredView, R.id.btn_delete_remocon, "field 'btn_delete_remocon'", TextView.class);
        this.view7f09006b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.switcherInfo.fragments.RemoconInfoFragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                remoconInfoFragment.onDeleteButtonClicked();
            }
        });
        remoconInfoFragment.tv_remocon_type = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_remocon_type, "field 'tv_remocon_type'", TextView.class);
        remoconInfoFragment.tv_remocon_name = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_remocon_name, "field 'tv_remocon_name'", TextView.class);
        remoconInfoFragment.iv_remocon_icon = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_remocon_icon, "field 'iv_remocon_icon'", ImageView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        RemoconInfoFragment remoconInfoFragment = this.target;
        if (remoconInfoFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        remoconInfoFragment.btn_delete_remocon = null;
        remoconInfoFragment.tv_remocon_type = null;
        remoconInfoFragment.tv_remocon_name = null;
        remoconInfoFragment.iv_remocon_icon = null;
        this.view7f09006b.setOnClickListener(null);
        this.view7f09006b = null;
    }
}
