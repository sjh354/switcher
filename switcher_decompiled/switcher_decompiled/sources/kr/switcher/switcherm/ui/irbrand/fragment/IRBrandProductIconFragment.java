package kr.switcher.switcherm.ui.irbrand.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.ui.irbrand.helper.PageHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class IRBrandProductIconFragment extends Fragment {
    private static final String PARM_POSITION = "position";
    private static PageHashMap pageHashMap;

    @BindView(R.id.iv_ir_product_icon)
    ImageView iv_switcher_icon;

    @BindView(R.id.tv_propose_message)
    TextView tv_propose_message;

    public static IRBrandProductIconFragment newInstance(int i, PageHashMap pageHashMap2) {
        IRBrandProductIconFragment iRBrandProductIconFragment = new IRBrandProductIconFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(PARM_POSITION, i);
        iRBrandProductIconFragment.setArguments(bundle);
        pageHashMap = pageHashMap2;
        return iRBrandProductIconFragment;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Bundle arguments = getArguments();
        int id = arguments != null ? arguments.getInt(PARM_POSITION) : 0;
        View viewInflate = layoutInflater.inflate(R.layout.fragment_ir_brand_product_page, viewGroup, false);
        ButterKnife.bind(this, viewInflate);
        if (pageHashMap.getSize() <= 1) {
            id = pageHashMap.getId();
        }
        this.tv_propose_message.setText(pageHashMap.getProposeMessage(id));
        this.iv_switcher_icon.setImageDrawable(pageHashMap.getPageDrawable(id));
        return viewInflate;
    }
}
