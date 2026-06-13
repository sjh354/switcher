package kr.switcher.switcherm.ui.questionnaire.logic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kr.switcher.device.switcher.Switcher;
import kr.switcher.device.switcher.SwitcherReservationChecker;
import kr.switcher.device.switcher.interfaces.IODeviceCallbacks;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.IOConfig;
import kr.switcher.switcherm.common.ga.GALogger;
import kr.switcher.switcherm.common.util.IOLog;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.common.util.SimpleTimeCalculator;
import kr.switcher.switcherm.device.switcher.handler.SwitcherDBProvider;
import kr.switcher.switcherm.preference.OAuthToken;
import kr.switcher.switcherm.ui.questionnaire.QuestionnaireData;

/* JADX INFO: loaded from: classes2.dex */
public class AnalyzedTimerMaker {
    public static final String DEFAULT_AM_PM = "pm";
    public static final int DEFAULT_HOUR = 6;
    public static final int DEFAULT_MIN = 20;
    public static final int QUESTION1_MIN_MINUS = -1;
    public static final int QUESTION2_HOUR_ADD = 1;
    public static final int QUESTION5_HOUR_ADD = 2;
    private int count;
    private SwitcherDBProvider dbProvider;

    static /* synthetic */ int access$008(AnalyzedTimerMaker analyzedTimerMaker) {
        int i = analyzedTimerMaker.count;
        analyzedTimerMaker.count = i + 1;
        return i;
    }

    public void analysis(Switcher switcher) {
        List<Switcher.SwitcherReservation> listMakeSwitcherReservation = makeSwitcherReservation(switcher);
        this.dbProvider = new SwitcherDBProvider();
        if (listMakeSwitcherReservation.size() > 0) {
            this.count = 0;
            addTimer(switcher, listMakeSwitcherReservation);
        }
    }

    public List<Switcher.SwitcherReservation> makeSwitcherReservation(Switcher switcher) {
        ArrayList arrayList = new ArrayList();
        QuestionnaireData questionnaireData = new QuestionnaireData();
        return getValidSwitcherReservations(switcher, analyzeQuestion5(analyzeQuestion4(analyzeQuestion3(analyzeQuestion2(analyzeQuestion1(arrayList, questionnaireData.getQuestion1Data()), questionnaireData.getQuestion2Data()), questionnaireData.getQuestion3Data()), questionnaireData.getQuestion4Data(), questionnaireData.getQuestion3Data()), questionnaireData.getQuestion5Data()));
    }

    public List<Switcher.SwitcherReservation> getValidSwitcherReservations(Switcher switcher, List<Switcher.SwitcherReservation> list) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(switcher.sResrvs);
        List<Switcher.SwitcherReservation> possibleSwitcherReservation = getPossibleSwitcherReservation(arrayList.size(), list);
        ArrayList arrayList2 = new ArrayList();
        SwitcherReservationChecker switcherReservationChecker = new SwitcherReservationChecker(arrayList);
        Iterator<Switcher.SwitcherReservation> it = possibleSwitcherReservation.iterator();
        while (it.hasNext()) {
            Switcher.SwitcherReservation validSwitcherReservation = getValidSwitcherReservation(switcherReservationChecker, it.next());
            arrayList2.add(validSwitcherReservation);
            switcherReservationChecker.add(validSwitcherReservation);
        }
        return arrayList2;
    }

    public List<Switcher.SwitcherReservation> getPossibleSwitcherReservation(int i, List<Switcher.SwitcherReservation> list) {
        int i2 = 10 - i;
        if (i2 < 0) {
            i2 = 0;
        }
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < list.size(); i3++) {
            if (i3 < i2) {
                arrayList.add(list.get(i3));
            }
        }
        return arrayList;
    }

    public Switcher.SwitcherReservation getValidSwitcherReservation(SwitcherReservationChecker switcherReservationChecker, Switcher.SwitcherReservation switcherReservation) {
        if (!switcherReservationChecker.checkIsDuplicationTimer(switcherReservation)) {
            return switcherReservation;
        }
        if (switcherReservation.min >= 59) {
            switcherReservation.min--;
        } else {
            switcherReservation.min++;
        }
        return getValidSwitcherReservation(switcherReservationChecker, switcherReservation);
    }

    public List<Switcher.SwitcherReservation> analyzeQuestion1(List<Switcher.SwitcherReservation> list, QuestionnaireData.Question1Data question1Data) {
        if (question1Data == null) {
            return list;
        }
        SimpleTimeCalculator.DayOfTheWeekMap dayOfTheWeekMapPutWeekDay = new SimpleTimeCalculator.DayOfTheWeekMap().putWeekDay();
        SimpleTimeCalculator simpleTimeCalculator = new SimpleTimeCalculator(question1Data.getAmpm(), question1Data.getHour(), question1Data.getMin(), dayOfTheWeekMapPutWeekDay);
        simpleTimeCalculator.calculate(0, -1);
        list.add(new Switcher.SwitcherReservation(-1, IOUtil.getStringResource(R.string.default_timer_title1), dayOfTheWeekMapPutWeekDay.get(SimpleTimeCalculator.DayOfTheWeek.MON), dayOfTheWeekMapPutWeekDay.get(SimpleTimeCalculator.DayOfTheWeek.TUE), dayOfTheWeekMapPutWeekDay.get(SimpleTimeCalculator.DayOfTheWeek.WED), dayOfTheWeekMapPutWeekDay.get(SimpleTimeCalculator.DayOfTheWeek.THU), dayOfTheWeekMapPutWeekDay.get(SimpleTimeCalculator.DayOfTheWeek.FRI), dayOfTheWeekMapPutWeekDay.get(SimpleTimeCalculator.DayOfTheWeek.SAT), dayOfTheWeekMapPutWeekDay.get(SimpleTimeCalculator.DayOfTheWeek.SUN), simpleTimeCalculator.getAmPm().toLowerCase(), simpleTimeCalculator.getHour(), simpleTimeCalculator.getMin(), true, Switcher.SwitcherReservation.SWITCH_1WAY_FIRMWARE, true));
        return list;
    }

    public List<Switcher.SwitcherReservation> analyzeQuestion2(List<Switcher.SwitcherReservation> list, QuestionnaireData.Question2Data question2Data) {
        if (question2Data == null) {
            return list;
        }
        SimpleTimeCalculator.DayOfTheWeekMap dayOfTheWeekMapPutEveryDay = new SimpleTimeCalculator.DayOfTheWeekMap().putEveryDay();
        SimpleTimeCalculator simpleTimeCalculator = new SimpleTimeCalculator(question2Data.getAmpm(), question2Data.getHour(), question2Data.getMin(), dayOfTheWeekMapPutEveryDay);
        simpleTimeCalculator.calculate(1, 0);
        list.add(new Switcher.SwitcherReservation(-1, IOUtil.getStringResource(R.string.default_timer_title2), dayOfTheWeekMapPutEveryDay.get(SimpleTimeCalculator.DayOfTheWeek.MON), dayOfTheWeekMapPutEveryDay.get(SimpleTimeCalculator.DayOfTheWeek.TUE), dayOfTheWeekMapPutEveryDay.get(SimpleTimeCalculator.DayOfTheWeek.WED), dayOfTheWeekMapPutEveryDay.get(SimpleTimeCalculator.DayOfTheWeek.THU), dayOfTheWeekMapPutEveryDay.get(SimpleTimeCalculator.DayOfTheWeek.FRI), dayOfTheWeekMapPutEveryDay.get(SimpleTimeCalculator.DayOfTheWeek.SAT), dayOfTheWeekMapPutEveryDay.get(SimpleTimeCalculator.DayOfTheWeek.SUN), simpleTimeCalculator.getAmPm().toLowerCase(), simpleTimeCalculator.getHour(), simpleTimeCalculator.getMin(), false, Switcher.SwitcherReservation.SWITCH_1WAY_FIRMWARE, true));
        return list;
    }

    public List<Switcher.SwitcherReservation> analyzeQuestion3(List<Switcher.SwitcherReservation> list, QuestionnaireData.Question3Data question3Data) {
        if (question3Data != null && question3Data.getYn() == 1) {
            list.add(new Switcher.SwitcherReservation(-1, IOUtil.getStringResource(R.string.default_timer_title3), true, true, true, true, true, false, false, "pm", 6, 20, true, Switcher.SwitcherReservation.SWITCH_1WAY_FIRMWARE, true));
        }
        return list;
    }

    public List<Switcher.SwitcherReservation> analyzeQuestion4(List<Switcher.SwitcherReservation> list, QuestionnaireData.Question4Data question4Data, QuestionnaireData.Question3Data question3Data) {
        if (question4Data == null || question4Data.getYn() != 1 || (question3Data != null && question3Data.getYn() == 1)) {
            return list;
        }
        list.add(new Switcher.SwitcherReservation(-1, IOUtil.getStringResource(R.string.default_timer_title4), true, true, true, true, true, false, false, "pm", 6, 20, true, Switcher.SwitcherReservation.SWITCH_1WAY_FIRMWARE, true));
        return list;
    }

    public List<Switcher.SwitcherReservation> analyzeQuestion5(List<Switcher.SwitcherReservation> list, QuestionnaireData.Question5Data question5Data) {
        if (question5Data == null) {
            return list;
        }
        SimpleTimeCalculator.DayOfTheWeekMap dayOfTheWeekMapPutEveryDay = new SimpleTimeCalculator.DayOfTheWeekMap().putEveryDay();
        SimpleTimeCalculator simpleTimeCalculator = new SimpleTimeCalculator(question5Data.getAmpm(), question5Data.getHour(), question5Data.getMin(), dayOfTheWeekMapPutEveryDay);
        simpleTimeCalculator.calculate(2, 0);
        list.add(new Switcher.SwitcherReservation(-1, IOUtil.getStringResource(R.string.default_timer_title5), dayOfTheWeekMapPutEveryDay.get(SimpleTimeCalculator.DayOfTheWeek.MON), dayOfTheWeekMapPutEveryDay.get(SimpleTimeCalculator.DayOfTheWeek.TUE), dayOfTheWeekMapPutEveryDay.get(SimpleTimeCalculator.DayOfTheWeek.WED), dayOfTheWeekMapPutEveryDay.get(SimpleTimeCalculator.DayOfTheWeek.THU), dayOfTheWeekMapPutEveryDay.get(SimpleTimeCalculator.DayOfTheWeek.FRI), dayOfTheWeekMapPutEveryDay.get(SimpleTimeCalculator.DayOfTheWeek.SAT), dayOfTheWeekMapPutEveryDay.get(SimpleTimeCalculator.DayOfTheWeek.SUN), simpleTimeCalculator.getAmPm().toLowerCase(), simpleTimeCalculator.getHour(), simpleTimeCalculator.getMin(), false, Switcher.SwitcherReservation.SWITCH_1WAY_FIRMWARE, true));
        return list;
    }

    private IODeviceCallbacks.ReservationUpdateResultCallback getUpdatedReservationResultCallback(final Switcher switcher, final List<Switcher.SwitcherReservation> list) {
        return new IODeviceCallbacks.ReservationUpdateResultCallback() { // from class: kr.switcher.switcherm.ui.questionnaire.logic.AnalyzedTimerMaker.1
            @Override // kr.switcher.device.switcher.interfaces.IODeviceCallbacks.ReservationUpdateResultCallback
            public void onUpdatedReservation(boolean z) {
                AnalyzedTimerMaker.access$008(AnalyzedTimerMaker.this);
                if (AnalyzedTimerMaker.this.count >= list.size()) {
                    AnalyzedTimerMaker.this.dbProvider.updateSwitcherReservationListToDB(switcher.getMacAddress(), list);
                } else {
                    AnalyzedTimerMaker.this.addTimer(switcher, list);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addTimer(Switcher switcher, List<Switcher.SwitcherReservation> list) {
        int size = list.size();
        int i = this.count;
        if (size <= i) {
            return;
        }
        Switcher.SwitcherReservation switcherReservation = list.get(i);
        int iAddReservation = switcher.addReservation(switcherReservation, getUpdatedReservationResultCallback(switcher, list));
        if (iAddReservation != 1) {
            if (iAddReservation == 111) {
                IOUtil.showToast(IOUtil.getStringResource(R.string.timer_is_max_num_message));
            } else if (iAddReservation == 112) {
                IOUtil.showToast(IOUtil.getStringResource(R.string.duplicate_timer_message));
            } else {
                IOUtil.showToast(IOUtil.getStringResource(R.string.etc_error));
            }
            IOLog.error("ContentValues", new OAuthToken().getOAuthToken(), "saveTimer", new Exception("failed add timer (error code:" + iAddReservation + ")"));
        }
        IOLog.event(GALogger.CATEGORY_AUTOMATION, GALogger.ACTION_CREATE_ALARM, switcherReservation.light ? "ON" : IOConfig.OFF);
    }
}
