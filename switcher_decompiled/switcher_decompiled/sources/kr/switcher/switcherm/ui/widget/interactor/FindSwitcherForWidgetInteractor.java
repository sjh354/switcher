package kr.switcher.switcherm.ui.widget.interactor;

import java.util.ArrayList;
import java.util.List;
import kr.switcher.device.IODevice;
import kr.switcher.device.switcher.Switcher;
import kr.switcher.switcherm.device.switcher.handler.SwitcherDBProvider;

/* JADX INFO: loaded from: classes2.dex */
public class FindSwitcherForWidgetInteractor {
    private static final String TAG = "FindSwitcherForWidgetInteractor";
    private OnFoundSwitcherForWidgetListener listener;

    public interface OnFoundSwitcherForWidgetListener {
        void onFoundSwitcherList(List<Switcher> list);
    }

    public FindSwitcherForWidgetInteractor(OnFoundSwitcherForWidgetListener onFoundSwitcherForWidgetListener) {
        this.listener = onFoundSwitcherForWidgetListener;
    }

    public List<Switcher> createSwitcherList() {
        return new SwitcherDBProvider().getSwitcherAll();
    }

    public void getOneButtonSwitcherList(List<Switcher> list) {
        ArrayList arrayList = new ArrayList();
        for (Switcher switcher : list) {
            if (switcher.getProductId() == IODevice.ProductId.SWITCHER_TYPE_ONE) {
                arrayList.add(switcher);
            }
        }
        this.listener.onFoundSwitcherList(arrayList);
    }

    public void getTwoButtonSwitcherList(List<Switcher> list) {
        ArrayList arrayList = new ArrayList();
        for (Switcher switcher : list) {
            if (switcher.getProductId() == IODevice.ProductId.SWITCHER_TYPE_TWO) {
                arrayList.add(switcher);
            }
        }
        this.listener.onFoundSwitcherList(arrayList);
    }
}
