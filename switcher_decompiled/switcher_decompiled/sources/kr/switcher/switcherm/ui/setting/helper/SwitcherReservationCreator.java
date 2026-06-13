package kr.switcher.switcherm.ui.setting.helper;

import java.util.Calendar;
import kr.switcher.device.switcher.Switcher;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.util.IOUtil;

/* JADX INFO: loaded from: classes2.dex */
public class SwitcherReservationCreator {
    private Switcher.SwitcherReservation switcherTimer;

    public SwitcherReservationCreator() {
        setCurrentReservation();
    }

    private void setCurrentReservation() {
        String dayOfWeekString = IOUtil.getDayOfWeekString(Calendar.getInstance().get(7));
        Switcher.SwitcherReservation switcherReservation = new Switcher.SwitcherReservation("", dayOfWeekString.equals(IOUtil.getStringResource(R.string.mon_day)), dayOfWeekString.equals(IOUtil.getStringResource(R.string.tue_day)), dayOfWeekString.equals(IOUtil.getStringResource(R.string.wed_day)), dayOfWeekString.equals(IOUtil.getStringResource(R.string.thu_day)), dayOfWeekString.equals(IOUtil.getStringResource(R.string.fri_day)), dayOfWeekString.equals(IOUtil.getStringResource(R.string.sat_day)), dayOfWeekString.equals(IOUtil.getStringResource(R.string.sun_day)), IOUtil.getCurrentAmPm(), Calendar.getInstance().get(11), Calendar.getInstance().get(12));
        this.switcherTimer = switcherReservation;
        switcherReservation.switcherTarget = Switcher.SwitcherReservation.SWITCH_1WAY_FIRMWARE;
        this.switcherTimer.light = true;
    }

    public Switcher.SwitcherReservation createNewReservation(ReservationInfo reservationInfo) {
        String title = reservationInfo.getTitle();
        boolean zIsSelected = reservationInfo.getMon().isSelected();
        boolean zIsSelected2 = reservationInfo.getTue().isSelected();
        boolean zIsSelected3 = reservationInfo.getWed().isSelected();
        boolean zIsSelected4 = reservationInfo.getThu().isSelected();
        boolean zIsSelected5 = reservationInfo.getFri().isSelected();
        boolean zIsSelected6 = reservationInfo.getSat().isSelected();
        boolean zIsSelected7 = reservationInfo.getSun().isSelected();
        String amPmForWheel = IOUtil.getAmPmForWheel(reservationInfo.getAmpm());
        int hourForWheel = IOUtil.getHourForWheel(reservationInfo.getHour()) + 1;
        int minForWheel = IOUtil.getMinForWheel(reservationInfo.getMin());
        boolean zIsSelected8 = reservationInfo.getTimerOn().isSelected();
        int currentItem = reservationInfo.getSwitcherType().getCurrentItem();
        String str = Switcher.SwitcherReservation.SWITCH_1WAY_FIRMWARE;
        if (currentItem != Integer.parseInt(Switcher.SwitcherReservation.SWITCH_1WAY_FIRMWARE)) {
            str = "1";
        }
        Switcher.SwitcherReservation switcherReservation = new Switcher.SwitcherReservation(title, zIsSelected, zIsSelected2, zIsSelected3, zIsSelected4, zIsSelected5, zIsSelected6, zIsSelected7, amPmForWheel, hourForWheel, minForWheel, zIsSelected8, str, true);
        this.switcherTimer = switcherReservation;
        return switcherReservation;
    }

    public Switcher.SwitcherReservation getSwitcherReservation() {
        return this.switcherTimer;
    }
}
