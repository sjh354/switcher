package kr.switcher.switcherm.viewmodel;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.databinding.BaseObservable;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.util.IOLog;
import kr.switcher.switcherm.common.util.IOUtil;

/* JADX INFO: loaded from: classes2.dex */
public class ReturnInfoFragmentViewModel extends BaseObservable {
    private Context context;

    public ReturnInfoFragmentViewModel(Context context) {
        this.context = context;
        IOLog.activity(IOUtil.getStringResource(R.string.screen_title_5_0_2_2_0));
    }

    private Drawable makeDrawable(int i) {
        return this.context.getResources().getDrawable(i);
    }
}
