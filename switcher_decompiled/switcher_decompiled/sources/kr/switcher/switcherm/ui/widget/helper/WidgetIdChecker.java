package kr.switcher.switcherm.ui.widget.helper;

/* JADX INFO: loaded from: classes2.dex */
public class WidgetIdChecker {
    private int[] widgetIds;

    public WidgetIdChecker(int[] iArr) {
        this.widgetIds = iArr;
    }

    public boolean checkIsExistedWidgetId(int i) {
        for (int i2 : this.widgetIds) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }
}
