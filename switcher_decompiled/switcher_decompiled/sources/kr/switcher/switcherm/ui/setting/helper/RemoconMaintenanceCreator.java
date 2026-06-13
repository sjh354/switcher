package kr.switcher.switcherm.ui.setting.helper;

import java.util.Calendar;
import kr.switcher.device.remocon.Remocon;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.util.IOUtil;

/* JADX INFO: loaded from: classes2.dex */
public class RemoconMaintenanceCreator {
    private Remocon.RemoconMaintenanceTemperature rMaintenance;

    public RemoconMaintenanceCreator() {
        setCurrentMaintenance();
    }

    private void setCurrentMaintenance() {
        String dayOfWeekString = IOUtil.getDayOfWeekString(Calendar.getInstance().get(7));
        this.rMaintenance = new Remocon.RemoconMaintenanceTemperature("", dayOfWeekString.equals(IOUtil.getStringResource(R.string.mon_day)), dayOfWeekString.equals(IOUtil.getStringResource(R.string.tue_day)), dayOfWeekString.equals(IOUtil.getStringResource(R.string.wed_day)), dayOfWeekString.equals(IOUtil.getStringResource(R.string.thu_day)), dayOfWeekString.equals(IOUtil.getStringResource(R.string.fri_day)), dayOfWeekString.equals(IOUtil.getStringResource(R.string.sat_day)), dayOfWeekString.equals(IOUtil.getStringResource(R.string.sun_day)), 22, 19, 22, 0, 0);
    }

    public Remocon.RemoconMaintenanceTemperature createNewMaintenance(RemoconMaintenanceInfo remoconMaintenanceInfo) {
        Remocon.RemoconMaintenanceTemperature remoconMaintenanceTemperature = new Remocon.RemoconMaintenanceTemperature(remoconMaintenanceInfo.getTitle(), remoconMaintenanceInfo.getMon().isSelected(), remoconMaintenanceInfo.getTue().isSelected(), remoconMaintenanceInfo.getWed().isSelected(), remoconMaintenanceInfo.getThu().isSelected(), remoconMaintenanceInfo.getFri().isSelected(), remoconMaintenanceInfo.getSat().isSelected(), remoconMaintenanceInfo.getSun().isSelected(), Integer.parseInt(remoconMaintenanceInfo.getGoalTemperature().getText().toString()), remoconMaintenanceInfo.getStartHour().getCurrentItem(), remoconMaintenanceInfo.getEndHour().getCurrentItem(), IOUtil.getMinForWheel(remoconMaintenanceInfo.getStartMin()), IOUtil.getMinForWheel(remoconMaintenanceInfo.getEndMin()));
        this.rMaintenance = remoconMaintenanceTemperature;
        return remoconMaintenanceTemperature;
    }

    public Remocon.RemoconMaintenanceTemperature getRemoconMaintenance() {
        return this.rMaintenance;
    }
}
