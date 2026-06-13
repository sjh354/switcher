package kr.switcher.switcherm.ui.widget.view;

import java.util.List;
import kr.switcher.switcherm.ui.switcherList.adapter.IODeviceItem;

/* JADX INFO: loaded from: classes2.dex */
public interface OneButtonWidgetSelectView {
    void addWidget(String str);

    void setRecyclerView(List<IODeviceItem> list);

    void showMessage(String str);
}
