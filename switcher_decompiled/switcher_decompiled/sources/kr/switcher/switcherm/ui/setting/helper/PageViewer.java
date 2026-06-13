package kr.switcher.switcherm.ui.setting.helper;

import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.util.IOUtil;

/* JADX INFO: loaded from: classes2.dex */
public class PageViewer {
    private PageHashMap pageHashMap = new PageHashMap();

    public PageViewer(int i) {
        setCurrentStrokeLevel(i);
    }

    public void setCurrentStrokeLevel(int i) {
        if (i == 0) {
            setShortPage();
        } else if (i == 1) {
            setMediumPage();
        } else {
            if (i != 2) {
                return;
            }
            setLongPage();
        }
    }

    private void setShortPage() {
        this.pageHashMap.put(0, IOUtil.makeDrawable(R.drawable.ic_too_short), IOUtil.getStringResource(R.string.short_propose), IOUtil.getStringResource(R.string.short_situation));
    }

    private void setMediumPage() {
        this.pageHashMap.put(0, IOUtil.makeDrawable(R.drawable.ic_too_long), IOUtil.getStringResource(R.string.stroke_level_short_propose_message), IOUtil.getStringResource(R.string.stroke_level_short_situation));
        this.pageHashMap.put(1, IOUtil.makeDrawable(R.drawable.ic_medium), IOUtil.getStringResource(R.string.stroke_level_medium_propose_message), "");
        this.pageHashMap.put(2, IOUtil.makeDrawable(R.drawable.ic_too_short), IOUtil.getStringResource(R.string.stroke_level_long_propose_message), IOUtil.getStringResource(R.string.stroke_level_long_situation));
    }

    private void setLongPage() {
        this.pageHashMap.put(2, IOUtil.makeDrawable(R.drawable.ic_too_long), IOUtil.getStringResource(R.string.long_propose), IOUtil.getStringResource(R.string.long_situation));
    }

    public PageHashMap getPage() {
        return this.pageHashMap;
    }
}
