package kr.switcher.switcherm.ui.irbrand.view;

import java.util.List;
import kr.switcher.switcherm.ui.irbrand.adapter.BrandItem;

/* JADX INFO: loaded from: classes2.dex */
public interface IRBrandListView {
    void acvivityFinish();

    void initRecyclerListView();

    void setBrandItems(List<BrandItem> list);
}
