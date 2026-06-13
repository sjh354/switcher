package kr.switcher.switcherm.ui.setting.helper;

import java.util.Calendar;
import kr.switcher.device.remocon.Remocon;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.util.IOUtil;

/* JADX INFO: loaded from: classes2.dex */
public class RemoconReservationCreator {
    private Remocon.RemoconReservation rResrv;

    public RemoconReservationCreator() {
        setCurrentReservation();
    }

    private void setCurrentReservation() {
        String dayOfWeekString = IOUtil.getDayOfWeekString(Calendar.getInstance().get(7));
        boolean zEquals = dayOfWeekString.equals(IOUtil.getStringResource(R.string.mon_day));
        boolean zEquals2 = dayOfWeekString.equals(IOUtil.getStringResource(R.string.tue_day));
        boolean zEquals3 = dayOfWeekString.equals(IOUtil.getStringResource(R.string.wed_day));
        boolean zEquals4 = dayOfWeekString.equals(IOUtil.getStringResource(R.string.thu_day));
        boolean zEquals5 = dayOfWeekString.equals(IOUtil.getStringResource(R.string.fri_day));
        boolean zEquals6 = dayOfWeekString.equals(IOUtil.getStringResource(R.string.sat_day));
        boolean zEquals7 = dayOfWeekString.equals(IOUtil.getStringResource(R.string.sun_day));
        Remocon.RemoconReservation remoconReservation = new Remocon.RemoconReservation("", Boolean.valueOf(zEquals), Boolean.valueOf(zEquals2), Boolean.valueOf(zEquals3), Boolean.valueOf(zEquals4), Boolean.valueOf(zEquals5), Boolean.valueOf(zEquals6), Boolean.valueOf(zEquals7), Calendar.getInstance().get(11), Calendar.getInstance().get(12));
        this.rResrv = remoconReservation;
        remoconReservation.tag = "19";
    }

    public Remocon.RemoconReservation createNewReservation(RemoconReservationInfo remoconReservationInfo) {
        Remocon.RemoconReservation remoconReservation = new Remocon.RemoconReservation(remoconReservationInfo.getTitle(), Boolean.valueOf(remoconReservationInfo.getMon().isSelected()), Boolean.valueOf(remoconReservationInfo.getTue().isSelected()), Boolean.valueOf(remoconReservationInfo.getWed().isSelected()), Boolean.valueOf(remoconReservationInfo.getThu().isSelected()), Boolean.valueOf(remoconReservationInfo.getFri().isSelected()), Boolean.valueOf(remoconReservationInfo.getSat().isSelected()), Boolean.valueOf(remoconReservationInfo.getSun().isSelected()), IOUtil.getHourForWheel(remoconReservationInfo.getHour()), IOUtil.getMinForWheel(remoconReservationInfo.getMin()), remoconReservationInfo.getTag());
        this.rResrv = remoconReservation;
        return remoconReservation;
    }

    public Remocon.RemoconReservation getRemoconReservation() {
        return this.rResrv;
    }
}
