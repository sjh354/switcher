package kr.switcher.switcherm.ui.splash.interactors;

/* JADX INFO: loaded from: classes2.dex */
public interface FindTokenInteractor {

    public interface OnFinishedListener {
        void onIsToken(boolean z);

        void onMigration(boolean z);
    }

    void findIsToken(OnFinishedListener onFinishedListener);

    void finish();

    void requestMigration(String str, OnFinishedListener onFinishedListener);
}
