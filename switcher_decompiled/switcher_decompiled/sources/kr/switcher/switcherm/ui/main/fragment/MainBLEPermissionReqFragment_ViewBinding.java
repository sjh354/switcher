package kr.switcher.switcherm.ui.main.fragment;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import kr.switcher.switcherm.R;

/* JADX INFO: loaded from: classes2.dex */
public class MainBLEPermissionReqFragment_ViewBinding implements Unbinder {
    private MainBLEPermissionReqFragment target;
    private View view7f090087;

    public MainBLEPermissionReqFragment_ViewBinding(final MainBLEPermissionReqFragment mainBLEPermissionReqFragment, View view) {
        this.target = mainBLEPermissionReqFragment;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.btn_permission_setting, "method 'onRequestBLEPermissionButtonClicked'");
        this.view7f090087 = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.main.fragment.MainBLEPermissionReqFragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                mainBLEPermissionReqFragment.onRequestBLEPermissionButtonClicked();
            }
        });
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        if (this.target == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        this.view7f090087.setOnClickListener(null);
        this.view7f090087 = null;
    }
}
