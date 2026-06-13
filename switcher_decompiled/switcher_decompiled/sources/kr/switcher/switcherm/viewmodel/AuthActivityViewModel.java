package kr.switcher.switcherm.viewmodel;

import android.content.Context;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

/* JADX INFO: loaded from: classes2.dex */
public class AuthActivityViewModel extends BaseObservable {
    private Context context;
    private int visibilityOfProgressbar;

    public AuthActivityViewModel(Context context) {
        this.context = context;
        hideProgressbar();
    }

    public void showProgressbar() {
        setVisibilityOfProgressbar(0);
    }

    public void hideProgressbar() {
        setVisibilityOfProgressbar(4);
    }

    @Bindable
    public int getVisibilityOfProgressbar() {
        return this.visibilityOfProgressbar;
    }

    public void setVisibilityOfProgressbar(int i) {
        this.visibilityOfProgressbar = i;
        notifyPropertyChanged(46);
    }
}
