package kr.switcher.switcherm.ui.switcherInfo.fragments;

import android.view.View;
import android.webkit.WebView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import kr.switcher.switcherm.R;

/* JADX INFO: loaded from: classes2.dex */
public class PostCodeFragment_ViewBinding implements Unbinder {
    private PostCodeFragment target;

    public PostCodeFragment_ViewBinding(PostCodeFragment postCodeFragment, View view) {
        this.target = postCodeFragment;
        postCodeFragment.wv_post_code = (WebView) Utils.findRequiredViewAsType(view, R.id.wv_post_code, "field 'wv_post_code'", WebView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        PostCodeFragment postCodeFragment = this.target;
        if (postCodeFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        postCodeFragment.wv_post_code = null;
    }
}
