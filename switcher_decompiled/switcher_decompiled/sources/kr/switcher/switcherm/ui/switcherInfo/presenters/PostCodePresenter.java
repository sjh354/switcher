package kr.switcher.switcherm.ui.switcherInfo.presenters;

import kr.switcher.switcherm.ui.switcherInfo.views.PostCodeView;

/* JADX INFO: loaded from: classes2.dex */
public class PostCodePresenter {
    private PostCodeView view;

    public PostCodePresenter(PostCodeView postCodeView) {
        this.view = postCodeView;
    }

    public void initialize() {
        this.view.setWebView();
        this.view.showPostCodeWebView();
        this.view.trackZipCodeForGA();
    }
}
