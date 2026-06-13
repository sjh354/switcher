package kr.switcher.switcherm.ui.questionnaire.presenter;

import kr.switcher.device.switcher.Switcher;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.ui.questionnaire.logic.AnalyzedTimerMaker;
import kr.switcher.switcherm.ui.questionnaire.views.AnalysisView;

/* JADX INFO: loaded from: classes2.dex */
public class AnalysisPresenter {
    private AnalyzedTimerMaker maker = new AnalyzedTimerMaker();
    private AnalysisView view;

    public AnalysisPresenter(AnalysisView analysisView) {
        this.view = analysisView;
    }

    public void initialize(Switcher switcher) {
        this.view.trackAnalysisForGA();
        analyzing();
        this.maker.analysis(switcher);
        this.view.startTimer();
    }

    public void onPause() {
        this.view.cancelTimer();
    }

    private void analyzing() {
        this.view.setLoadingText(IOUtil.getStringResource(R.string.analyzing));
    }

    private void generating() {
        this.view.setLoadingText(IOUtil.getStringResource(R.string.generating));
    }

    private void complete() {
        this.view.setLoadingText(IOUtil.getStringResource(R.string.complete));
    }

    public void count(int i) {
        if (i == 0) {
            analyzing();
        } else if (i == 1) {
            generating();
        } else {
            complete();
        }
    }
}
