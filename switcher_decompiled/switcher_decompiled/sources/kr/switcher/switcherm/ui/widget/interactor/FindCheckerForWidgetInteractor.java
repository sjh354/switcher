package kr.switcher.switcherm.ui.widget.interactor;

import java.util.List;
import kr.switcher.device.checker.Checker;
import kr.switcher.switcherm.device.checker.CheckerDBProvider;

/* JADX INFO: loaded from: classes2.dex */
public class FindCheckerForWidgetInteractor {
    private static final String TAG = "FindCheckerForWidgetInteractor";
    private OnFoundCheckerForWidgetListener listener;

    public interface OnFoundCheckerForWidgetListener {
        void onFoundCheckerList(List<Checker> list);
    }

    public FindCheckerForWidgetInteractor(OnFoundCheckerForWidgetListener onFoundCheckerForWidgetListener) {
        this.listener = onFoundCheckerForWidgetListener;
    }

    public List<Checker> createCheckerList() {
        return new CheckerDBProvider().getCheckerAll();
    }

    public void getCheckerList(List<Checker> list) {
        this.listener.onFoundCheckerList(list);
    }
}
