package kr.switcher.switcherm.ui.switcherInfo.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.util.IOLog;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.network.http.RestSwitcherAPIStore;
import kr.switcher.switcherm.ui.switcherInfo.SwitcherInfoActivity;
import kr.switcher.switcherm.ui.switcherInfo.presenters.PostCodePresenter;
import kr.switcher.switcherm.ui.switcherInfo.views.PostCodeView;

/* JADX INFO: loaded from: classes2.dex */
public class PostCodeFragment extends Fragment implements PostCodeView {
    private static final String JAVASCRIPT_MAPPING_ID = "Android";
    private static SwitcherInfoActivity.ReturnCompleteListener listener;
    private PostCodePresenter presenter;

    @BindView(R.id.wv_post_code)
    WebView wv_post_code;

    public static PostCodeFragment newInstance(SwitcherInfoActivity.ReturnCompleteListener returnCompleteListener) {
        PostCodeFragment postCodeFragment = new PostCodeFragment();
        listener = returnCompleteListener;
        return postCodeFragment;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_post_code, viewGroup, false);
        ButterKnife.bind(this, viewInflate);
        PostCodePresenter postCodePresenter = new PostCodePresenter(this);
        this.presenter = postCodePresenter;
        postCodePresenter.initialize();
        return viewInflate;
    }

    @Override // kr.switcher.switcherm.ui.switcherInfo.views.PostCodeView
    public void setWebView() {
        this.wv_post_code.getSettings().setJavaScriptEnabled(true);
        this.wv_post_code.getSettings().setAllowUniversalAccessFromFileURLs(true);
        this.wv_post_code.addJavascriptInterface(new AndroidBridge(), JAVASCRIPT_MAPPING_ID);
    }

    @Override // kr.switcher.switcherm.ui.switcherInfo.views.PostCodeView
    public void showPostCodeWebView() {
        this.wv_post_code.loadUrl(RestSwitcherAPIStore.getPostCodeURL());
    }

    @Override // kr.switcher.switcherm.ui.switcherInfo.views.PostCodeView
    public void trackZipCodeForGA() {
        IOLog.activity(IOUtil.getStringResource(R.string.screen_title_5_0_2_2_2_0));
    }

    private class AndroidBridge {
        private AndroidBridge() {
        }

        @JavascriptInterface
        public void processData(String str) {
            PostCodeFragment.listener.onReturnComplete(str);
        }
    }
}
