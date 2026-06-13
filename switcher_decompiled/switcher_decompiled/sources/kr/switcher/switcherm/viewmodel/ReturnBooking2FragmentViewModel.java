package kr.switcher.switcherm.viewmodel;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import java.util.Calendar;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.util.IOLog;
import kr.switcher.switcherm.common.util.IOUtil;

/* JADX INFO: loaded from: classes2.dex */
public class ReturnBooking2FragmentViewModel extends BaseObservable {
    private final int dayToMiliSecond = 86400000;
    private boolean isVisitDay1;
    private boolean isVisitDay2;
    private boolean isVisitDay3;
    private boolean isVisitDay4;
    private boolean isVisitDay5;
    private int visibilityOfProgressbar;
    private String visitDay1;
    private String visitDay2;
    private String visitDay3;
    private String visitDay4;
    private String visitDay5;

    public ReturnBooking2FragmentViewModel() {
        hideProgressbar();
        initResource();
        initDate();
        IOLog.activity(IOUtil.getStringResource(R.string.screen_title_5_0_2_2_3));
    }

    private void initResource() {
        setIsVisitDay1(true);
        setIsVisitDay2(false);
        setIsVisitDay3(false);
        setIsVisitDay4(false);
        setIsVisitDay5(false);
    }

    private int getNextDayIndex(Calendar calendar, int i) {
        long timeInMillis = calendar.getTimeInMillis();
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(timeInMillis + 86400000);
        if (calendar2.get(7) == 1) {
            i++;
        } else if (calendar2.get(7) == 7) {
            i += 2;
        }
        return i + 1;
    }

    private void initDate() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        Calendar calendar = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        Calendar calendar3 = Calendar.getInstance();
        Calendar calendar4 = Calendar.getInstance();
        Calendar calendar5 = Calendar.getInstance();
        Calendar calendar6 = Calendar.getInstance();
        calendar.setTimeInMillis(jCurrentTimeMillis);
        int nextDayIndex = getNextDayIndex(calendar, 0);
        calendar2.setTimeInMillis(((long) (nextDayIndex * 86400000)) + jCurrentTimeMillis);
        int nextDayIndex2 = getNextDayIndex(calendar2, nextDayIndex);
        calendar3.setTimeInMillis(((long) (nextDayIndex2 * 86400000)) + jCurrentTimeMillis);
        int nextDayIndex3 = getNextDayIndex(calendar3, nextDayIndex2);
        calendar4.setTimeInMillis(((long) (nextDayIndex3 * 86400000)) + jCurrentTimeMillis);
        int nextDayIndex4 = getNextDayIndex(calendar4, nextDayIndex3);
        calendar5.setTimeInMillis(((long) (nextDayIndex4 * 86400000)) + jCurrentTimeMillis);
        calendar6.setTimeInMillis(jCurrentTimeMillis + ((long) (getNextDayIndex(calendar5, nextDayIndex4) * 86400000)));
        setVisitDay1(calendar2.get(1) + IOUtil.getStringResource(R.string.year) + " " + (calendar2.get(2) + 1) + IOUtil.getStringResource(R.string.month) + " " + calendar2.get(5) + IOUtil.getStringResource(R.string.day) + " " + IOUtil.getDayOfWeekString(calendar2.get(7)));
        setVisitDay2(calendar3.get(1) + IOUtil.getStringResource(R.string.year) + " " + (calendar3.get(2) + 1) + IOUtil.getStringResource(R.string.month) + " " + calendar3.get(5) + IOUtil.getStringResource(R.string.day) + " " + IOUtil.getDayOfWeekString(calendar3.get(7)));
        setVisitDay3(calendar4.get(1) + IOUtil.getStringResource(R.string.year) + " " + (calendar4.get(2) + 1) + IOUtil.getStringResource(R.string.month) + " " + calendar4.get(5) + IOUtil.getStringResource(R.string.day) + " " + IOUtil.getDayOfWeekString(calendar4.get(7)));
        setVisitDay4(calendar5.get(1) + IOUtil.getStringResource(R.string.year) + " " + (calendar5.get(2) + 1) + IOUtil.getStringResource(R.string.month) + " " + calendar5.get(5) + IOUtil.getStringResource(R.string.day) + " " + IOUtil.getDayOfWeekString(calendar5.get(7)));
        setVisitDay5(calendar6.get(1) + IOUtil.getStringResource(R.string.year) + " " + (calendar6.get(2) + 1) + IOUtil.getStringResource(R.string.month) + " " + calendar6.get(5) + IOUtil.getStringResource(R.string.day) + " " + IOUtil.getDayOfWeekString(calendar6.get(7)));
    }

    public void showProgressbar() {
        setVisibilityOfProgressbar(0);
    }

    public void hideProgressbar() {
        setVisibilityOfProgressbar(4);
    }

    @Bindable
    public int getVisibilityOfProgressbar() {
        return this.visibilityOfProgressbar;
    }

    public void setVisibilityOfProgressbar(int i) {
        this.visibilityOfProgressbar = i;
        notifyPropertyChanged(46);
    }

    @Bindable
    public String getVisitDay1() {
        return this.visitDay1;
    }

    public void setVisitDay1(String str) {
        this.visitDay1 = str;
        notifyPropertyChanged(54);
    }

    @Bindable
    public String getVisitDay2() {
        return this.visitDay2;
    }

    public void setVisitDay2(String str) {
        this.visitDay2 = str;
        notifyPropertyChanged(55);
    }

    @Bindable
    public String getVisitDay3() {
        return this.visitDay3;
    }

    public void setVisitDay3(String str) {
        this.visitDay3 = str;
        notifyPropertyChanged(56);
    }

    @Bindable
    public String getVisitDay4() {
        return this.visitDay4;
    }

    public void setVisitDay4(String str) {
        this.visitDay4 = str;
        notifyPropertyChanged(57);
    }

    @Bindable
    public String getVisitDay5() {
        return this.visitDay5;
    }

    public void setVisitDay5(String str) {
        this.visitDay5 = str;
        notifyPropertyChanged(58);
    }

    @Bindable
    public boolean getIsVisitDay1() {
        return this.isVisitDay1;
    }

    public void setIsVisitDay1(boolean z) {
        this.isVisitDay1 = z;
        notifyPropertyChanged(14);
    }

    @Bindable
    public boolean getIsVisitDay2() {
        return this.isVisitDay2;
    }

    public void setIsVisitDay2(boolean z) {
        this.isVisitDay2 = z;
        notifyPropertyChanged(15);
    }

    @Bindable
    public boolean getIsVisitDay3() {
        return this.isVisitDay3;
    }

    public void setIsVisitDay3(boolean z) {
        this.isVisitDay3 = z;
        notifyPropertyChanged(16);
    }

    @Bindable
    public boolean getIsVisitDay4() {
        return this.isVisitDay4;
    }

    public void setIsVisitDay4(boolean z) {
        this.isVisitDay4 = z;
        notifyPropertyChanged(17);
    }

    @Bindable
    public boolean getIsVisitDay5() {
        return this.isVisitDay5;
    }

    public void setIsVisitDay5(boolean z) {
        this.isVisitDay5 = z;
        notifyPropertyChanged(18);
    }
}
