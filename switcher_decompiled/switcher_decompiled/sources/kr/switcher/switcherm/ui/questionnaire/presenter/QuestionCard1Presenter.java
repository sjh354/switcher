package kr.switcher.switcherm.ui.questionnaire.presenter;

import antistatic.spinnerwheel.AbstractWheel;
import kr.switcher.device.IODeviceConfig;
import kr.switcher.device.switcher.Switcher;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.ui.questionnaire.QuestionnaireData;
import kr.switcher.switcherm.ui.questionnaire.views.QuestionCard1View;
import kr.switcher.switcherm.ui.setting.helper.SwitcherReservationCreator;

/* JADX INFO: loaded from: classes2.dex */
public class QuestionCard1Presenter {
    private QuestionCard1View view;

    public QuestionCard1Presenter(QuestionCard1View questionCard1View) {
        this.view = questionCard1View;
    }

    public void initialize() {
        this.view.initWheel();
    }

    public void onSaveButtonClicked(AbstractWheel abstractWheel, AbstractWheel abstractWheel2, AbstractWheel abstractWheel3) {
        this.view.setQuestion1Data(IOUtil.getAmPmForWheel(abstractWheel), IOUtil.getHourForWheel(abstractWheel2), IOUtil.getMinForWheel(abstractWheel3));
        this.view.moveNextPage(1);
    }

    public void setCurrentPosition(QuestionnaireData questionnaireData) {
        QuestionnaireData.Question1Data question1Data = questionnaireData.getQuestion1Data();
        if (question1Data == null) {
            Switcher.SwitcherReservation switcherReservation = new SwitcherReservationCreator().getSwitcherReservation();
            this.view.setDefaultData(!switcherReservation.ampm.equalsIgnoreCase(IODeviceConfig.AM) ? 1 : 0, switcherReservation.hour - 1, switcherReservation.min);
        } else {
            this.view.setData(!question1Data.getAmpm().equalsIgnoreCase(IODeviceConfig.AM) ? 1 : 0, question1Data.getHour() - 1, question1Data.getMin());
        }
    }
}
