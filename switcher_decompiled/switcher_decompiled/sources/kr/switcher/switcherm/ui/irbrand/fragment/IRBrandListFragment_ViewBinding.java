package kr.switcher.switcherm.ui.irbrand.fragment;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import kr.switcher.switcherm.R;

/* JADX INFO: loaded from: classes2.dex */
public class IRBrandListFragment_ViewBinding implements Unbinder {
    private IRBrandListFragment target;

    public IRBrandListFragment_ViewBinding(IRBrandListFragment iRBrandListFragment, View view) {
        this.target = iRBrandListFragment;
        iRBrandListFragment.rv_ir_brand_list = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_ir_brand_list, "field 'rv_ir_brand_list'", RecyclerView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        IRBrandListFragment iRBrandListFragment = this.target;
        if (iRBrandListFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        iRBrandListFragment.rv_ir_brand_list = null;
    }
}
