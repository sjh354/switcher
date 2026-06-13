package kr.switcher.switcherm.ui.questionnaire.presenter;

import antistatic.spinnerwheel.AbstractWheel;
import kr.switcher.device.IODeviceConfig;
import kr.switcher.device.switcher.Switcher;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.ui.questionnaire.QuestionnaireData;
import kr.switcher.switcherm.ui.questionnaire.views.QuestionCard2View;
import kr.switcher.switcherm.ui.setting.helper.SwitcherReservationCreator;

/* JADX INFO: loaded from: classes2.dex */
public class QuestionCard2Presenter {
    private QuestionCard2View view;

    public QuestionCard2Presenter(QuestionCard2View questionCard2View) {
        this.view = questionCard2View;
    }

    public void initialize() {
        this.view.initWheel();
    }

    public void onSaveButtonClicked(AbstractWheel abstractWheel, AbstractWheel abstractWheel2, AbstractWheel abstractWheel3) {
        this.view.setQuestion2Data(IOUtil.getAmPmForWheel(abstractWheel), IOUtil.getHourForWheel(abstractWheel2), IOUtil.getMinForWheel(abstractWheel3));
        this.view.moveNextPage(2);
    }

    public void setCurrentPosition(QuestionnaireData questionnaireData) {
        QuestionnaireData.Question2Data question2Data = questionnaireData.getQuestion2Data();
        if (question2Data == null) {
            Switcher.SwitcherReservation switcherReservation = new SwitcherReservationCreator().getSwitcherReservation();
            this.view.setDefaultData(!switcherReservation.ampm.equalsIgnoreCase(IODeviceConfig.AM) ? 1 : 0, switcherReservation.hour - 1, switcherReservation.min);
        } else {
            this.view.setData(!question2Data.getAmpm().equalsIgnoreCase(IODeviceConfig.AM) ? 1 : 0, question2Data.getHour() - 1, question2Data.getMin());
        }
    }
}
