package kr.switcher.switcherm.ui.setting.presenter;

import android.view.View;
import androidx.viewpager.widget.ViewPager;
import kr.switcher.device.IODevice;
import kr.switcher.device.switcher.Switcher;
import kr.switcher.device.switcher.interfaces.IODeviceCallbacks;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.util.IOLog;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.preference.OAuthToken;
import kr.switcher.switcherm.ui.setting.helper.DayOfWeekRepeater;
import kr.switcher.switcherm.ui.setting.helper.ReservationInfo;
import kr.switcher.switcherm.ui.setting.helper.SwitcherReservationCreator;
import kr.switcher.switcherm.ui.setting.view.ReservationView;

/* JADX INFO: loaded from: classes2.dex */
public class ReservationPresenter {
    private final String TAG = "ReservationPresenter";
    private ReservationView view;

    public ReservationPresenter(ReservationView reservationView) {
        this.view = reservationView;
    }

    public void initialize(Switcher switcher, Switcher.SwitcherReservation switcherReservation) {
        this.view.hideProgressbar();
        this.view.trackReservationForGA();
        setDefault();
        setSwitcherType(switcher.getProductId());
        initViewPager(switcher, switcherReservation);
        this.view.initWheel();
        if (switcherReservation != null) {
            this.view.setTitle(switcherReservation.title);
            this.view.setTimerInfo(switcherReservation);
            this.view.showRemoveButton();
        } else {
            this.view.setTimerInfo(new SwitcherReservationCreator().getSwitcherReservation());
            this.view.hideRemoveButton();
        }
    }

    /* JADX INFO: renamed from: kr.switcher.switcherm.ui.setting.presenter.ReservationPresenter$6, reason: invalid class name */
    static /* synthetic */ class AnonymousClass6 {
        static final /* synthetic */ int[] $SwitchMap$kr$switcher$device$IODevice$ProductId;

        static {
            int[] iArr = new int[IODevice.ProductId.values().length];
            $SwitchMap$kr$switcher$device$IODevice$ProductId = iArr;
            try {
                iArr[IODevice.ProductId.SWITCHER_TYPE_ONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$kr$switcher$device$IODevice$ProductId[IODevice.ProductId.SWITCHER_TYPE_TWO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private void setSwitcherType(IODevice.ProductId productId) {
        int i = AnonymousClass6.$SwitchMap$kr$switcher$device$IODevice$ProductId[productId.ordinal()];
        if (i == 1) {
            this.view.hideViewPager();
        } else {
            if (i != 2) {
                return;
            }
            this.view.showViewPager();
        }
    }

    private void initViewPager(Switcher switcher, Switcher.SwitcherReservation switcherReservation) {
        IODevice.ProductId productId = switcher.getProductId();
        int i = 0;
        if (switcherReservation != null && productId == IODevice.ProductId.SWITCHER_TYPE_TWO && !switcherReservation.switcherTarget.equals(Switcher.SwitcherReservation.SWITCH_1WAY_FIRMWARE)) {
            if (switcherReservation.switcherTarget.equals("1")) {
                i = 1;
            } else {
                IOUtil.showToast(IOUtil.getStringResource(R.string.not_support_type));
                IOLog.error(this.TAG, new OAuthToken().getOAuthToken(), "initViewPager", new NullPointerException(IOUtil.getStringResource(R.string.not_support_type)));
            }
        }
        this.view.initViewPager(i);
    }

    public void setArrowStatus(int i) {
        if (i == 0) {
            this.view.hideLeftArrowButton();
            this.view.showRightArrowButton();
        } else if (i == 1) {
            this.view.hideRightArrowButton();
            this.view.showLeftArrowButton();
        } else {
            this.view.showLeftArrowButton();
            this.view.showRightArrowButton();
        }
    }

    public void saveReservation(Switcher.SwitcherReservation switcherReservation, boolean z, ReservationInfo reservationInfo, IODeviceCallbacks.ReservationUpdateResultCallback reservationUpdateResultCallback) {
        if (!z && reservationInfo.checkIsValidDaySet()) {
            this.view.showProgressbar();
            Switcher.SwitcherReservation switcherReservationCreateNewReservation = new SwitcherReservationCreator().createNewReservation(reservationInfo);
            if (switcherReservation == null) {
                this.view.addReservation(switcherReservationCreateNewReservation, reservationUpdateResultCallback);
                this.view.trackCreateAlarmForGA(switcherReservationCreateNewReservation.light);
            } else {
                switcherReservationCreateNewReservation.id = switcherReservation.id;
                this.view.updateReservation(switcherReservationCreateNewReservation, reservationUpdateResultCallback);
                this.view.trackEditAlarmForGA(switcherReservationCreateNewReservation.light);
            }
        }
    }

    public void removeReservation(Switcher.SwitcherReservation switcherReservation, boolean z, IODeviceCallbacks.ReservationUpdateResultCallback reservationUpdateResultCallback) {
        if (z) {
            return;
        }
        if (switcherReservation == null) {
            this.view.showErrorMessage(IOUtil.getStringResource(R.string.etc_error));
            this.view.finish();
        } else {
            this.view.showProgressbar();
            this.view.removeReservation(switcherReservation.id, reservationUpdateResultCallback);
            this.view.trackDeleteAlarmForGA(switcherReservation.light);
        }
    }

    public void showResult(int i) {
        if (i != 1) {
            if (i == 111) {
                this.view.hideProgressbar();
                this.view.showErrorMessage(IOUtil.getStringResource(R.string.timer_is_max_num_message));
            } else if (i == 112) {
                this.view.hideProgressbar();
                this.view.showErrorMessage(IOUtil.getStringResource(R.string.duplicate_timer_message));
            } else {
                this.view.showErrorMessage(IOUtil.getStringResource(R.string.etc_error));
                this.view.finish();
            }
            IOLog.error(this.TAG, new OAuthToken().getOAuthToken(), "saveReservation", new Exception("failed add or update or remove timer (error code:" + i + ")"));
        }
    }

    public IODeviceCallbacks.ReservationUpdateResultCallback getReservationUpdateResultCallback(final Switcher.SwitcherReservation switcherReservation, final IODeviceCallbacks.ReservationUpdateResultCallback reservationUpdateResultCallback) {
        return new IODeviceCallbacks.ReservationUpdateResultCallback() { // from class: kr.switcher.switcherm.ui.setting.presenter.ReservationPresenter.1
            @Override // kr.switcher.device.switcher.interfaces.IODeviceCallbacks.ReservationUpdateResultCallback
            public void onUpdatedReservation(boolean z) {
                ReservationPresenter.this.view.hideProgressbar();
                reservationUpdateResultCallback.onUpdatedReservation(z);
                if (z) {
                    ReservationPresenter.this.view.updateReservationToDB(switcherReservation);
                }
            }
        };
    }

    public IODeviceCallbacks.ReservationUpdateResultCallback getReservationRemoveResultCallback(final int i, final IODeviceCallbacks.ReservationUpdateResultCallback reservationUpdateResultCallback) {
        return new IODeviceCallbacks.ReservationUpdateResultCallback() { // from class: kr.switcher.switcherm.ui.setting.presenter.ReservationPresenter.2
            @Override // kr.switcher.device.switcher.interfaces.IODeviceCallbacks.ReservationUpdateResultCallback
            public void onUpdatedReservation(boolean z) {
                ReservationPresenter.this.view.hideProgressbar();
                reservationUpdateResultCallback.onUpdatedReservation(z);
                if (z) {
                    ReservationPresenter.this.view.removeReservationToDB(i);
                }
            }
        };
    }

    public View.OnClickListener getRightArrowButtonClicked(final int i) {
        return new View.OnClickListener() { // from class: kr.switcher.switcherm.ui.setting.presenter.ReservationPresenter.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ReservationPresenter.this.view.selectRightItem(i);
            }
        };
    }

    public void selectRightItem(int i, int i2) {
        int i3 = i + 1;
        if (i3 < i2) {
            this.view.selectItem(i3);
        }
    }

    public View.OnClickListener getLeftArrowButtonClicked() {
        return new View.OnClickListener() { // from class: kr.switcher.switcherm.ui.setting.presenter.ReservationPresenter.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ReservationPresenter.this.view.selectLeftItem();
            }
        };
    }

    public void selectLeftItem(int i) {
        int i2 = i - 1;
        if (i2 >= 0) {
            this.view.selectItem(i2);
        }
    }

    public ViewPager.OnPageChangeListener getOnPageChangeListener() {
        return new ViewPager.OnPageChangeListener() { // from class: kr.switcher.switcherm.ui.setting.presenter.ReservationPresenter.5
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                ReservationPresenter.this.view.pageSelected(i);
            }
        };
    }

    public void pageSelected(boolean z, int i) {
        if (!z) {
            this.view.select(true);
        } else {
            this.view.selectItem(i);
        }
    }

    public void setSwitch(boolean z) {
        if (z) {
            this.view.selectTimerOn();
            this.view.unSelectTimerOff();
            this.view.setBackgroundTimerOffWhenIsOn();
            this.view.setBackgroundTimerOnWhenIsOn();
            this.view.setColorTimerOffTextWhenIsOn();
            this.view.setColorTimerOnTextWhenIsOn();
            return;
        }
        this.view.selectTimerOff();
        this.view.unSelectTimerOn();
        this.view.setBackgroundTimerOffWhenIsOff();
        this.view.setBackgroundTimerOnWhenIsOff();
        this.view.setColorTimerOffTextWhenIsOff();
        this.view.setColorTimerOnTextWhenIsOff();
    }

    public void setRepeater(DayOfWeekRepeater dayOfWeekRepeater) {
        int status = dayOfWeekRepeater.getStatus();
        if (status == 1) {
            this.view.selectDaily();
            this.view.unSelectWeekday();
            this.view.unSelectWeekend();
        } else if (status == 2) {
            this.view.unSelectDaily();
            this.view.selectWeekday();
            this.view.unSelectWeekend();
        } else if (status == 3) {
            this.view.unSelectDaily();
            this.view.unSelectWeekday();
            this.view.selectWeekend();
        } else {
            this.view.unSelectDaily();
            this.view.unSelectWeekday();
            this.view.unSelectWeekend();
        }
    }

    public void setMon(boolean z) {
        if (z) {
            this.view.selectMon();
        } else {
            this.view.unSelectMon();
        }
        this.view.setRepeater();
    }

    public void setTue(boolean z) {
        if (z) {
            this.view.selectTue();
        } else {
            this.view.unSelectTue();
        }
        this.view.setRepeater();
    }

    public void setWed(boolean z) {
        if (z) {
            this.view.selectWed();
        } else {
            this.view.unSelectWed();
        }
        this.view.setRepeater();
    }

    public void setThu(boolean z) {
        if (z) {
            this.view.selectThu();
        } else {
            this.view.unSelectThu();
        }
        this.view.setRepeater();
    }

    public void setFri(boolean z) {
        if (z) {
            this.view.selectFri();
        } else {
            this.view.unSelectFri();
        }
        this.view.setRepeater();
    }

    public void setSat(boolean z) {
        if (z) {
            this.view.selectSat();
        } else {
            this.view.unSelectSat();
        }
        this.view.setRepeater();
    }

    public void setSun(boolean z) {
        if (z) {
            this.view.selectSun();
        } else {
            this.view.unSelectSun();
        }
        this.view.setRepeater();
    }

    public void setDefault() {
        setTue(false);
        setWed(false);
        setThu(false);
        setFri(false);
        setSat(false);
        setSun(false);
    }

    public void setDaily() {
        setMon(true);
        setTue(true);
        setWed(true);
        setThu(true);
        setFri(true);
        setSat(true);
        setSun(true);
        this.view.setRepeater();
    }

    public void setWeekday() {
        setMon(true);
        setTue(true);
        setWed(true);
        setThu(true);
        setFri(true);
        setSat(false);
        setSun(false);
        this.view.setRepeater();
    }

    public void setWeekend() {
        setMon(false);
        setTue(false);
        setWed(false);
        setThu(false);
        setFri(false);
        setSat(true);
        setSun(true);
        this.view.setRepeater();
    }
}
