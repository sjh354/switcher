package kr.switcher.switcherm.ui.questionnaire.fragment;

import android.view.View;
import androidx.cardview.widget.CardView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import kr.switcher.switcherm.R;

/* JADX INFO: loaded from: classes2.dex */
public class CardFragment_ViewBinding implements Unbinder {
    private CardFragment target;

    public CardFragment_ViewBinding(CardFragment cardFragment, View view) {
        this.target = cardFragment;
        cardFragment.cardview = (CardView) Utils.findRequiredViewAsType(view, R.id.cardview, "field 'cardview'", CardView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        CardFragment cardFragment = this.target;
        if (cardFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        cardFragment.cardview = null;
    }
}
