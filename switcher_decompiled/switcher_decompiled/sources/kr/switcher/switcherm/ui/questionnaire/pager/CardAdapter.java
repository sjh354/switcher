package kr.switcher.switcherm.ui.questionnaire.pager;

import androidx.cardview.widget.CardView;

/* JADX INFO: loaded from: classes2.dex */
public interface CardAdapter {
    public static final int MAX_ELEVATION_FACTOR = 3;

    float getBaseElevation();

    CardView getCardViewAt(int i);

    int getCount();
}
