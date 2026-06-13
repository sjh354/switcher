package kr.switcher.switcherm.ui.questionnaire.pager;

/* JADX INFO: loaded from: classes2.dex */
public class CardItem {
    private int mTextResource;
    private int mTitleResource;

    public CardItem(int i, int i2) {
        this.mTitleResource = i;
        this.mTextResource = i2;
    }

    public int getText() {
        return this.mTextResource;
    }

    public int getTitle() {
        return this.mTitleResource;
    }
}
