package kr.switcher.switcherm.ui.switcherInfo.views;

import java.util.List;
import kr.switcher.switcherm.ui.switcherInfo.adapter.PlanItem;

/* JADX INFO: loaded from: classes2.dex */
public interface RentalPlanView {
    void setPlanListView(List<PlanItem> list);

    void setPurchasePrice(String str);

    void showConfirmDialog(String str, String str2, String str3, String str4);

    void showMessage(String str);

    void trackRentalPlanForGA();
}
