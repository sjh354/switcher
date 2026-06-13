package kr.switcher.switcherm.ui.questionnaire.presenter;

import antistatic.spinnerwheel.AbstractWheel;
import kr.switcher.device.IODeviceConfig;
import kr.switcher.device.switcher.Switcher;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.ui.questionnaire.QuestionnaireData;
import kr.switcher.switcherm.ui.questionnaire.views.QuestionCard5View;
import kr.switcher.switcherm.ui.setting.helper.SwitcherReservationCreator;

/* JADX INFO: loaded from: classes2.dex */
public class QuestionCard5Presenter {
    private QuestionCard5View view;

    public QuestionCard5Presenter(QuestionCard5View questionCard5View) {
        this.view = questionCard5View;
    }

    public void initialize() {
        this.view.initWheel();
    }

    public void onSaveButtonClicked(AbstractWheel abstractWheel, AbstractWheel abstractWheel2, AbstractWheel abstractWheel3) {
        this.view.setQuestion5Data(IOUtil.getAmPmForWheel(abstractWheel), IOUtil.getHourForWheel(abstractWheel2), IOUtil.getMinForWheel(abstractWheel3));
        this.view.moveNextPage(5);
    }

    public void setCurrentPosition(QuestionnaireData questionnaireData) {
        QuestionnaireData.Question5Data question5Data = questionnaireData.getQuestion5Data();
        if (question5Data == null) {
            Switcher.SwitcherReservation switcherReservation = new SwitcherReservationCreator().getSwitcherReservation();
            this.view.setDefaultData(!switcherReservation.ampm.equalsIgnoreCase(IODeviceConfig.AM) ? 1 : 0, switcherReservation.hour - 1, switcherReservation.min);
        } else {
            this.view.setData(!question5Data.getAmpm().equalsIgnoreCase(IODeviceConfig.AM) ? 1 : 0, question5Data.getHour() - 1, question5Data.getMin());
        }
    }
}
