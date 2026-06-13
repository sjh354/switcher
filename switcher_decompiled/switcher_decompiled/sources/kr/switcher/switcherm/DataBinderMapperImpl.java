package kr.switcher.switcherm;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.core.app.NotificationCompat;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import cz.msebera.android.httpclient.cookie.ClientCookie;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kr.switcher.switcherm.database.DBIODeviceDAO;
import kr.switcher.switcherm.databinding.ActivityAuthBindingImpl;
import kr.switcher.switcherm.databinding.ActivityMypageBindingImpl;
import kr.switcher.switcherm.databinding.ActivitySettingBindingImpl;
import kr.switcher.switcherm.databinding.ActivitySwitcherInfoBindingImpl;
import kr.switcher.switcherm.databinding.FragmentAuthIdentifyBindingImpl;
import kr.switcher.switcherm.databinding.FragmentAuthPhoneNumberBindingImpl;
import kr.switcher.switcherm.databinding.FragmentDfuBindingImpl;
import kr.switcher.switcherm.databinding.FragmentHelpBindingImpl;
import kr.switcher.switcherm.databinding.FragmentLinkerInsertIrCommandBindingImpl;
import kr.switcher.switcherm.databinding.FragmentLinkerTestIrCommandBindingImpl;
import kr.switcher.switcherm.databinding.FragmentPaymentCardChangeBindingImpl;
import kr.switcher.switcherm.databinding.FragmentPaymentCardInfoBindingImpl;
import kr.switcher.switcherm.databinding.FragmentRemoconInfoBindingImpl;
import kr.switcher.switcherm.databinding.FragmentRentalPlanFreeBindingImpl;
import kr.switcher.switcherm.databinding.FragmentReturnBooking2BindingImpl;
import kr.switcher.switcherm.databinding.FragmentReturnConfirmBindingImpl;
import kr.switcher.switcherm.databinding.FragmentReturnInfoBindingImpl;
import kr.switcher.switcherm.databinding.FragmentSwitcherInfoMainBindingImpl;

/* JADX INFO: loaded from: classes2.dex */
public class DataBinderMapperImpl extends DataBinderMapper {
    private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP;
    private static final int LAYOUT_ACTIVITYAUTH = 1;
    private static final int LAYOUT_ACTIVITYMYPAGE = 2;
    private static final int LAYOUT_ACTIVITYSETTING = 3;
    private static final int LAYOUT_ACTIVITYSWITCHERINFO = 4;
    private static final int LAYOUT_FRAGMENTAUTHIDENTIFY = 5;
    private static final int LAYOUT_FRAGMENTAUTHPHONENUMBER = 6;
    private static final int LAYOUT_FRAGMENTDFU = 7;
    private static final int LAYOUT_FRAGMENTHELP = 8;
    private static final int LAYOUT_FRAGMENTLINKERINSERTIRCOMMAND = 9;
    private static final int LAYOUT_FRAGMENTLINKERTESTIRCOMMAND = 10;
    private static final int LAYOUT_FRAGMENTPAYMENTCARDCHANGE = 11;
    private static final int LAYOUT_FRAGMENTPAYMENTCARDINFO = 12;
    private static final int LAYOUT_FRAGMENTREMOCONINFO = 13;
    private static final int LAYOUT_FRAGMENTRENTALPLANFREE = 14;
    private static final int LAYOUT_FRAGMENTRETURNBOOKING2 = 15;
    private static final int LAYOUT_FRAGMENTRETURNCONFIRM = 16;
    private static final int LAYOUT_FRAGMENTRETURNINFO = 17;
    private static final int LAYOUT_FRAGMENTSWITCHERINFOMAIN = 18;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray(18);
        INTERNAL_LAYOUT_ID_LOOKUP = sparseIntArray;
        sparseIntArray.put(R.layout.activity_auth, 1);
        sparseIntArray.put(R.layout.activity_mypage, 2);
        sparseIntArray.put(R.layout.activity_setting, 3);
        sparseIntArray.put(R.layout.activity_switcher_info, 4);
        sparseIntArray.put(R.layout.fragment_auth_identify, 5);
        sparseIntArray.put(R.layout.fragment_auth_phone_number, 6);
        sparseIntArray.put(R.layout.fragment_dfu, 7);
        sparseIntArray.put(R.layout.fragment_help, 8);
        sparseIntArray.put(R.layout.fragment_linker_insert_ir_command, 9);
        sparseIntArray.put(R.layout.fragment_linker_test_ir_command, 10);
        sparseIntArray.put(R.layout.fragment_payment_card_change, 11);
        sparseIntArray.put(R.layout.fragment_payment_card_info, 12);
        sparseIntArray.put(R.layout.fragment_remocon_info, 13);
        sparseIntArray.put(R.layout.fragment_rental_plan_free, 14);
        sparseIntArray.put(R.layout.fragment_return_booking2, 15);
        sparseIntArray.put(R.layout.fragment_return_confirm, 16);
        sparseIntArray.put(R.layout.fragment_return_info, 17);
        sparseIntArray.put(R.layout.fragment_switcher_info_main, 18);
    }

    @Override // androidx.databinding.DataBinderMapper
    public ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View view, int i) {
        int i2 = INTERNAL_LAYOUT_ID_LOOKUP.get(i);
        if (i2 <= 0) {
            return null;
        }
        Object tag = view.getTag();
        if (tag == null) {
            throw new RuntimeException("view must have a tag");
        }
        switch (i2) {
            case 1:
                if ("layout/activity_auth_0".equals(tag)) {
                    return new ActivityAuthBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_auth is invalid. Received: " + tag);
            case 2:
                if ("layout/activity_mypage_0".equals(tag)) {
                    return new ActivityMypageBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_mypage is invalid. Received: " + tag);
            case 3:
                if ("layout/activity_setting_0".equals(tag)) {
                    return new ActivitySettingBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_setting is invalid. Received: " + tag);
            case 4:
                if ("layout/activity_switcher_info_0".equals(tag)) {
                    return new ActivitySwitcherInfoBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_switcher_info is invalid. Received: " + tag);
            case 5:
                if ("layout/fragment_auth_identify_0".equals(tag)) {
                    return new FragmentAuthIdentifyBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_auth_identify is invalid. Received: " + tag);
            case 6:
                if ("layout/fragment_auth_phone_number_0".equals(tag)) {
                    return new FragmentAuthPhoneNumberBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_auth_phone_number is invalid. Received: " + tag);
            case 7:
                if ("layout/fragment_dfu_0".equals(tag)) {
                    return new FragmentDfuBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_dfu is invalid. Received: " + tag);
            case 8:
                if ("layout/fragment_help_0".equals(tag)) {
                    return new FragmentHelpBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_help is invalid. Received: " + tag);
            case 9:
                if ("layout/fragment_linker_insert_ir_command_0".equals(tag)) {
                    return new FragmentLinkerInsertIrCommandBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_linker_insert_ir_command is invalid. Received: " + tag);
            case 10:
                if ("layout/fragment_linker_test_ir_command_0".equals(tag)) {
                    return new FragmentLinkerTestIrCommandBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_linker_test_ir_command is invalid. Received: " + tag);
            case 11:
                if ("layout/fragment_payment_card_change_0".equals(tag)) {
                    return new FragmentPaymentCardChangeBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_payment_card_change is invalid. Received: " + tag);
            case 12:
                if ("layout/fragment_payment_card_info_0".equals(tag)) {
                    return new FragmentPaymentCardInfoBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_payment_card_info is invalid. Received: " + tag);
            case 13:
                if ("layout/fragment_remocon_info_0".equals(tag)) {
                    return new FragmentRemoconInfoBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_remocon_info is invalid. Received: " + tag);
            case 14:
                if ("layout/fragment_rental_plan_free_0".equals(tag)) {
                    return new FragmentRentalPlanFreeBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_rental_plan_free is invalid. Received: " + tag);
            case 15:
                if ("layout/fragment_return_booking2_0".equals(tag)) {
                    return new FragmentReturnBooking2BindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_return_booking2 is invalid. Received: " + tag);
            case 16:
                if ("layout/fragment_return_confirm_0".equals(tag)) {
                    return new FragmentReturnConfirmBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_return_confirm is invalid. Received: " + tag);
            case 17:
                if ("layout/fragment_return_info_0".equals(tag)) {
                    return new FragmentReturnInfoBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_return_info is invalid. Received: " + tag);
            case 18:
                if ("layout/fragment_switcher_info_main_0".equals(tag)) {
                    return new FragmentSwitcherInfoMainBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_switcher_info_main is invalid. Received: " + tag);
            default:
                return null;
        }
    }

    @Override // androidx.databinding.DataBinderMapper
    public ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View[] viewArr, int i) {
        if (viewArr == null || viewArr.length == 0 || INTERNAL_LAYOUT_ID_LOOKUP.get(i) <= 0 || viewArr[0].getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }

    @Override // androidx.databinding.DataBinderMapper
    public int getLayoutId(String str) {
        Integer num;
        if (str == null || (num = InnerLayoutIdLookup.sKeys.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }

    @Override // androidx.databinding.DataBinderMapper
    public String convertBrIdToString(int i) {
        return InnerBrLookup.sKeys.get(i);
    }

    @Override // androidx.databinding.DataBinderMapper
    public List<DataBinderMapper> collectDependencies() {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
        return arrayList;
    }

    private static class InnerBrLookup {
        static final SparseArray<String> sKeys;

        private InnerBrLookup() {
        }

        static {
            SparseArray<String> sparseArray = new SparseArray<>(59);
            sKeys = sparseArray;
            sparseArray.put(0, "_all");
            sparseArray.put(1, "billingTerms");
            sparseArray.put(2, "cardCompany");
            sparseArray.put(3, "cardNumber1");
            sparseArray.put(4, "cardNumber2");
            sparseArray.put(5, "cardNumber3");
            sparseArray.put(6, "cardNumber4");
            sparseArray.put(7, "cardNumbers");
            sparseArray.put(8, "creditCard");
            sparseArray.put(9, "descriptions");
            sparseArray.put(10, "discounts");
            sparseArray.put(11, "invoiceNumber");
            sparseArray.put(12, "isCheckedPlans");
            sparseArray.put(13, "isMineList");
            sparseArray.put(14, "isVisitDay1");
            sparseArray.put(15, "isVisitDay2");
            sparseArray.put(16, "isVisitDay3");
            sparseArray.put(17, "isVisitDay4");
            sparseArray.put(18, "isVisitDay5");
            sparseArray.put(19, "leftButton");
            sparseArray.put(20, "menuName");
            sparseArray.put(21, DBIODeviceDAO.COLUMN_OWNER);
            sparseArray.put(22, "paymentDay");
            sparseArray.put(23, "prices");
            sparseArray.put(24, "pricingModel");
            sparseArray.put(25, NotificationCompat.CATEGORY_PROGRESS);
            sparseArray.put(26, "purchasePrice");
            sparseArray.put(27, "reservationDateReturn");
            sparseArray.put(28, "reservationReturnDate");
            sparseArray.put(29, "returnState");
            sparseArray.put(30, "rightButton");
            sparseArray.put(31, "rightButtonText");
            sparseArray.put(32, "serialNumber");
            sparseArray.put(33, "shareCode");
            sparseArray.put(34, "siwtcherName");
            sparseArray.put(35, "switcherIcon");
            sparseArray.put(36, "switcherType");
            sparseArray.put(37, "titles");
            sparseArray.put(38, ClientCookie.VERSION_ATTR);
            sparseArray.put(39, "viewModel");
            sparseArray.put(40, "visibilityOfDFUUpdating");
            sparseArray.put(41, "visibilityOfFreeTrial");
            sparseArray.put(42, "visibilityOfLastVersion");
            sparseArray.put(43, "visibilityOfOwnerMenu");
            sparseArray.put(44, "visibilityOfPaymentDay");
            sparseArray.put(45, "visibilityOfPlanButton");
            sparseArray.put(46, "visibilityOfProgressbar");
            sparseArray.put(47, "visibilityOfReturn");
            sparseArray.put(48, "visibilityOfReturnButton");
            sparseArray.put(49, "visibilityOfReturnComplete");
            sparseArray.put(50, "visibilityOfRightImageButton");
            sparseArray.put(51, "visibilityOfRightTextButton");
            sparseArray.put(52, "visibilityOfUpdate");
            sparseArray.put(53, "visibilityOfUsing");
            sparseArray.put(54, "visitDay1");
            sparseArray.put(55, "visitDay2");
            sparseArray.put(56, "visitDay3");
            sparseArray.put(57, "visitDay4");
            sparseArray.put(58, "visitDay5");
        }
    }

    private static class InnerLayoutIdLookup {
        static final HashMap<String, Integer> sKeys;

        private InnerLayoutIdLookup() {
        }

        static {
            HashMap<String, Integer> map = new HashMap<>(18);
            sKeys = map;
            map.put("layout/activity_auth_0", Integer.valueOf(R.layout.activity_auth));
            map.put("layout/activity_mypage_0", Integer.valueOf(R.layout.activity_mypage));
            map.put("layout/activity_setting_0", Integer.valueOf(R.layout.activity_setting));
            map.put("layout/activity_switcher_info_0", Integer.valueOf(R.layout.activity_switcher_info));
            map.put("layout/fragment_auth_identify_0", Integer.valueOf(R.layout.fragment_auth_identify));
            map.put("layout/fragment_auth_phone_number_0", Integer.valueOf(R.layout.fragment_auth_phone_number));
            map.put("layout/fragment_dfu_0", Integer.valueOf(R.layout.fragment_dfu));
            map.put("layout/fragment_help_0", Integer.valueOf(R.layout.fragment_help));
            map.put("layout/fragment_linker_insert_ir_command_0", Integer.valueOf(R.layout.fragment_linker_insert_ir_command));
            map.put("layout/fragment_linker_test_ir_command_0", Integer.valueOf(R.layout.fragment_linker_test_ir_command));
            map.put("layout/fragment_payment_card_change_0", Integer.valueOf(R.layout.fragment_payment_card_change));
            map.put("layout/fragment_payment_card_info_0", Integer.valueOf(R.layout.fragment_payment_card_info));
            map.put("layout/fragment_remocon_info_0", Integer.valueOf(R.layout.fragment_remocon_info));
            map.put("layout/fragment_rental_plan_free_0", Integer.valueOf(R.layout.fragment_rental_plan_free));
            map.put("layout/fragment_return_booking2_0", Integer.valueOf(R.layout.fragment_return_booking2));
            map.put("layout/fragment_return_confirm_0", Integer.valueOf(R.layout.fragment_return_confirm));
            map.put("layout/fragment_return_info_0", Integer.valueOf(R.layout.fragment_return_info));
            map.put("layout/fragment_switcher_info_main_0", Integer.valueOf(R.layout.fragment_switcher_info_main));
        }
    }
}
