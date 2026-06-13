package kr.switcher.switcherm.ui.switcherInfo.presenters;

import kr.switcher.device.IODevice;
import kr.switcher.device.switcher.option.PaymentInfo;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.activity.IOActivity;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.ui.switcherInfo.fragments.BuyingTypeChangeFragment;
import kr.switcher.switcherm.ui.switcherInfo.fragments.PaymentCardChangeFragment;
import kr.switcher.switcherm.ui.switcherInfo.fragments.PaymentCardInfoFragment;
import kr.switcher.switcherm.ui.switcherInfo.fragments.PostCodeFragment;
import kr.switcher.switcherm.ui.switcherInfo.fragments.RentalPlanFragment;
import kr.switcher.switcherm.ui.switcherInfo.fragments.RentalPlanFreeFragment;
import kr.switcher.switcherm.ui.switcherInfo.fragments.ReturnBooking2Fragment;
import kr.switcher.switcherm.ui.switcherInfo.fragments.ReturnBookingFragment;
import kr.switcher.switcherm.ui.switcherInfo.fragments.ReturnConfirmFragment;
import kr.switcher.switcherm.ui.switcherInfo.fragments.ReturnInfoFragment;
import kr.switcher.switcherm.ui.switcherInfo.interactors.FindSwitcherInfoInteractor;
import kr.switcher.switcherm.ui.switcherInfo.views.SwitcherInfoView;

/* JADX INFO: loaded from: classes2.dex */
public class SwitcherInfoPresenter implements FindSwitcherInfoInteractor.OnPaymentInfoListener {
    private FindSwitcherInfoInteractor interactor;
    private SwitcherInfoView view;

    public SwitcherInfoPresenter(SwitcherInfoView switcherInfoView, FindSwitcherInfoInteractor findSwitcherInfoInteractor) {
        this.view = switcherInfoView;
        this.interactor = findSwitcherInfoInteractor;
    }

    public void show(String str, int i, int i2, String str2) {
        if (i == 0) {
            this.view.moveRentalPreSaleView();
        }
        if (i != 4) {
            if (i == 6) {
                this.view.moveRentalReturningView();
                return;
            } else {
                if (i != 8) {
                    return;
                }
                this.view.moveRentalCompletedView();
                return;
            }
        }
        str.hashCode();
        switch (str) {
            case "contract":
                if (str2.equals(PaymentInfo.CONTRACT_STATUS_ON_GOING)) {
                    if (i2 >= 3 && i2 <= 6) {
                        this.view.moveRentalUsingView();
                    } else {
                        this.view.moveContractView();
                    }
                    break;
                } else {
                    this.view.moveWholeSaleView();
                    break;
                }
                break;
            case "free_trial":
                this.view.moveFreeTrialView();
                break;
            case "consignment":
                this.view.moveWholeSaleView();
                break;
        }
    }

    public void onCreate(IODevice iODevice, String str) {
        if (str != null) {
            this.view.movePaymentCardInfoFragment();
            return;
        }
        if (iODevice == null) {
            this.view.moveRentalPreSaleView();
        } else if (iODevice.getProductId() == IODevice.ProductId.REMOCON) {
            this.view.moveRemoconInfoView();
        } else {
            this.interactor.findPaymentInfo(this);
        }
    }

    public void onBackPressed(IOActivity iOActivity) {
        ReturnInfoFragment returnInfoFragment = (ReturnInfoFragment) iOActivity.getSupportFragmentManager().findFragmentByTag("ReturnInfoFragment");
        ReturnBookingFragment returnBookingFragment = (ReturnBookingFragment) iOActivity.getSupportFragmentManager().findFragmentByTag("ReturnBookingFragment");
        ReturnBooking2Fragment returnBooking2Fragment = (ReturnBooking2Fragment) iOActivity.getSupportFragmentManager().findFragmentByTag("ReturnBooking2Fragment");
        ReturnConfirmFragment returnConfirmFragment = (ReturnConfirmFragment) iOActivity.getSupportFragmentManager().findFragmentByTag("ReturnConfirmFragment");
        PaymentCardInfoFragment paymentCardInfoFragment = (PaymentCardInfoFragment) iOActivity.getSupportFragmentManager().findFragmentByTag("PaymentCardInfoFragment");
        PaymentCardChangeFragment paymentCardChangeFragment = (PaymentCardChangeFragment) iOActivity.getSupportFragmentManager().findFragmentByTag("PaymentCardChangeFragment");
        RentalPlanFragment rentalPlanFragment = (RentalPlanFragment) iOActivity.getSupportFragmentManager().findFragmentByTag("RentalPlanFragment");
        RentalPlanFreeFragment rentalPlanFreeFragment = (RentalPlanFreeFragment) iOActivity.getSupportFragmentManager().findFragmentByTag("RentalPlanFreeFragment");
        PostCodeFragment postCodeFragment = (PostCodeFragment) iOActivity.getSupportFragmentManager().findFragmentByTag("PostCodeFragment");
        BuyingTypeChangeFragment buyingTypeChangeFragment = (BuyingTypeChangeFragment) iOActivity.getSupportFragmentManager().findFragmentByTag("BuyingTypeChangeFragment");
        if (returnInfoFragment != null) {
            this.view.show();
            return;
        }
        if (returnBookingFragment != null) {
            this.view.show();
            return;
        }
        if (returnBooking2Fragment != null) {
            this.view.moveReturnBookingFragment();
            return;
        }
        if (returnConfirmFragment != null) {
            this.view.show();
            return;
        }
        if (paymentCardInfoFragment != null) {
            this.view.show();
            return;
        }
        if (paymentCardChangeFragment != null) {
            this.view.movePaymentCardInfoFragment();
            return;
        }
        if (rentalPlanFragment != null) {
            this.view.show();
            return;
        }
        if (rentalPlanFreeFragment != null) {
            this.view.show();
            return;
        }
        if (postCodeFragment != null) {
            this.view.moveReturnBookingFragment();
        } else if (buyingTypeChangeFragment != null) {
            this.view.show();
        } else {
            this.view.finishActivity();
        }
    }

    public void onReturnButtonClicked(IODevice iODevice) {
        if (checkSwitcherIsAbleToBeRefunded(iODevice)) {
            this.view.moveReturnInfoFragment();
        }
    }

    public void onDeliveryButtonClicked(IODevice iODevice) {
        if (checkSwitcherIsAbleToBeRefunded(iODevice)) {
            this.view.moveReturnBookingFragment();
        }
    }

    public void onPlanMenuButtonClicked(IODevice iODevice) {
        if (isValid(iODevice)) {
            String type = iODevice.getOption().getPaymentInfo().getType();
            type.hashCode();
            if (type.equals(PaymentInfo.BUYING_TYPE_FREE_TRIAL)) {
                if (iODevice.getOption().getPaymentInfo().getPaymentMethod() == 1 || iODevice.getOption().getPaymentInfo().getPaymentMethod() == 2) {
                    this.view.moveBuyingTypeChangeFragment();
                    return;
                }
                if (iODevice.getOption().getPaymentInfo().getPaymentMethod() == 3 || iODevice.getOption().getPaymentInfo().getPaymentMethod() == 4 || iODevice.getOption().getPaymentInfo().getPaymentMethod() == 5 || iODevice.getOption().getPaymentInfo().getPaymentMethod() == 6) {
                    this.view.movePlanFreeFragment();
                    return;
                } else {
                    this.view.showMessage(IOUtil.getStringResource(R.string.not_support_buying_type));
                    return;
                }
            }
            this.view.movePlanFreeFragment();
        }
    }

    private boolean isValid(IODevice iODevice) {
        if (iODevice != null) {
            return true;
        }
        this.view.showMessage(IOUtil.getStringResource(R.string.etc_error));
        this.view.finishActivity();
        return false;
    }

    private boolean checkSwitcherIsAbleToBeRefunded(IODevice iODevice) {
        if (!isValid(iODevice)) {
            return false;
        }
        if (iODevice.getOption().getShipping().getStatus() > 4) {
            this.view.showMessage(IOUtil.getStringResource(R.string.already_returned));
            return false;
        }
        if (iODevice.getOption().getShipping().getStatus() >= 4) {
            return true;
        }
        this.view.showMessage(IOUtil.getStringResource(R.string.not_yet_shipped));
        return false;
    }

    @Override // kr.switcher.switcherm.ui.switcherInfo.interactors.FindSwitcherInfoInteractor.OnPaymentInfoListener
    public void onPaymentInfo(String str, int i, int i2, String str2) {
        show(str, i, i2, str2);
    }
}
