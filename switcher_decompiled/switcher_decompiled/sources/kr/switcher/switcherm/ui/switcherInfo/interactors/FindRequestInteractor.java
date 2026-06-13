package kr.switcher.switcherm.ui.switcherInfo.interactors;

import kr.switcher.switcherm.user.Preparing;

/* JADX INFO: loaded from: classes2.dex */
public class FindRequestInteractor {
    private Preparing preparing = null;

    public interface OnGetPreparingListener {
        void onPreparing(Preparing preparing);
    }

    public void findPreparing(int i, OnGetPreparingListener onGetPreparingListener) {
    }

    public void findPreparing(OnGetPreparingListener onGetPreparingListener) {
    }

    public void setRequest(Preparing preparing) {
        this.preparing = preparing;
    }

    public Preparing getPreparing() {
        return this.preparing;
    }
}
