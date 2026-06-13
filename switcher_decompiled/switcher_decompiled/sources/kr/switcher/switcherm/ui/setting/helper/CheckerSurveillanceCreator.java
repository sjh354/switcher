package kr.switcher.switcherm.ui.setting.helper;

import java.util.Calendar;
import kr.switcher.device.checker.Checker;
import kr.switcher.device.switcher.Switcher;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.util.IOUtil;

/* JADX INFO: loaded from: classes2.dex */
public class CheckerSurveillanceCreator {
    private Checker.Surveillance surveillance;

    public CheckerSurveillanceCreator() {
        setCurrentSurveillance();
    }

    private void setCurrentSurveillance() {
        String dayOfWeekString = IOUtil.getDayOfWeekString(Calendar.getInstance().get(7));
        this.surveillance = new Checker.Surveillance("", 1, 19, 0, 22, 0, Boolean.valueOf(dayOfWeekString.equals(IOUtil.getStringResource(R.string.mon_day))), Boolean.valueOf(dayOfWeekString.equals(IOUtil.getStringResource(R.string.tue_day))), Boolean.valueOf(dayOfWeekString.equals(IOUtil.getStringResource(R.string.wed_day))), Boolean.valueOf(dayOfWeekString.equals(IOUtil.getStringResource(R.string.thu_day))), Boolean.valueOf(dayOfWeekString.equals(IOUtil.getStringResource(R.string.fri_day))), Boolean.valueOf(dayOfWeekString.equals(IOUtil.getStringResource(R.string.sat_day))), Boolean.valueOf(dayOfWeekString.equals(IOUtil.getStringResource(R.string.sun_day))));
    }

    public Checker.Surveillance createNewSurveillance(CheckerSurveillanceInfo checkerSurveillanceInfo, int i) {
        Checker.Surveillance surveillance = new Checker.Surveillance(checkerSurveillanceInfo.getTitle(), "True", 1, 1, i, checkerSurveillanceInfo.getStartHour().getCurrentItem(), IOUtil.getMinForWheel(checkerSurveillanceInfo.getStartMin()), checkerSurveillanceInfo.getEndHour().getCurrentItem(), IOUtil.getMinForWheel(checkerSurveillanceInfo.getEndMin()), Boolean.valueOf(checkerSurveillanceInfo.getMon().isSelected()), Boolean.valueOf(checkerSurveillanceInfo.getTue().isSelected()), Boolean.valueOf(checkerSurveillanceInfo.getWed().isSelected()), Boolean.valueOf(checkerSurveillanceInfo.getThu().isSelected()), Boolean.valueOf(checkerSurveillanceInfo.getFri().isSelected()), Boolean.valueOf(checkerSurveillanceInfo.getSat().isSelected()), Boolean.valueOf(checkerSurveillanceInfo.getSun().isSelected()));
        this.surveillance = surveillance;
        surveillance.weekDays = makeWeekDays(surveillance);
        Checker.Surveillance surveillance2 = this.surveillance;
        surveillance2.startAt = makeTimeAt(surveillance2.startHour, this.surveillance.startMin);
        Checker.Surveillance surveillance3 = this.surveillance;
        surveillance3.endAt = makeTimeAt(surveillance3.endHour, this.surveillance.endMin);
        this.surveillance.isActive = "True";
        return this.surveillance;
    }

    public Checker.Surveillance getCheckerSurveillance() {
        return this.surveillance;
    }

    public String makeWeekDays(Checker.Surveillance surveillance) {
        return (((((String.valueOf(surveillance.mon.booleanValue() ? 1 : 0) + (surveillance.tue.booleanValue() ? 1 : 0)) + (surveillance.wed.booleanValue() ? 1 : 0)) + (surveillance.thu.booleanValue() ? 1 : 0)) + (surveillance.fri.booleanValue() ? 1 : 0)) + (surveillance.sat.booleanValue() ? 1 : 0)) + (surveillance.sun.booleanValue() ? 1 : 0);
    }

    private String makeTimeAt(int i, int i2) {
        String str;
        if (i < 10) {
            str = "" + Switcher.SwitcherReservation.SWITCH_1WAY_FIRMWARE + String.valueOf(i);
        } else {
            str = "" + String.valueOf(i);
        }
        if (i2 < 10) {
            return str + Switcher.SwitcherReservation.SWITCH_1WAY_FIRMWARE + String.valueOf(i2);
        }
        return str + String.valueOf(i2);
    }
}
