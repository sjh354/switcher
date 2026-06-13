package kr.switcher.switcherm.viewmodel;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.databinding.BaseObservable;

/* JADX INFO: loaded from: classes2.dex */
public class HelpFragmentViewModel extends BaseObservable {
    private Context context;

    public HelpFragmentViewModel(Context context) {
        this.context = context;
    }

    private Drawable makeDrawable(int i) {
        return this.context.getResources().getDrawable(i);
    }
}
