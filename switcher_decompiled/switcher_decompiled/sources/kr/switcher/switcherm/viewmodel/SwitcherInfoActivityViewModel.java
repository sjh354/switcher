package kr.switcher.switcherm.viewmodel;

import android.graphics.drawable.Drawable;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import java.util.HashMap;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.util.IOUtil;

/* JADX INFO: loaded from: classes2.dex */
public class SwitcherInfoActivityViewModel extends BaseObservable {
    public static final String MENU_BUYING_TYPE_CHANGE = "BUYING_TYPE_CHANGE";
    public static final String MENU_CARD_INFO_FROM_LIST = "CARD_INFO_FROM_LIST";
    public static final String MENU_CONSIGNMENT = "CONSIGNMENT";
    public static final String MENU_CONTRACT = "CONTRACT";
    public static final String MENU_DELIVERY = "DELIVERY";
    public static final String MENU_FREE_TRIAL = "FREE_TRIAL";
    public static final String MENU_PAYMENT_CARD_CHANGE = "PAYMENT_CARD_CHANGE";
    public static final String MENU_PAYMENT_CARD_INFO = "PAYMENT_CARD_INFO";
    public static final String MENU_PLAN = "PLAN";
    public static final String MENU_POST_CODE = "POST_CODE";
    public static final String MENU_PRODUCTION = "PRODUCTION";
    public static final String MENU_REMOCON = "REMOCON";
    public static final String MENU_RETURN_BOOKING = "RETURN_BOOKING";
    public static final String MENU_RETURN_BOOKING2 = "RETURN_BOOKING2";
    public static final String MENU_RETURN_CONFIRM = "RETURN_CONFIRM";
    public static final String MENU_RETURN_INFO = "RETURN_INFO";
    public static final String MENU_SWITCHER_INFO_MAIN = "SWITCHER_INFO_MAIN";
    private Drawable leftButton;
    private HashMap<String, Drawable> leftButtonImages;
    private String menuName;
    private HashMap<String, String> menuNames;
    private Drawable rightButton;
    private HashMap<String, Drawable> rightButtonImages;
    private String rightButtonText;
    private HashMap<String, String> rightButtonTexts;
    private String state;
    private int visibilityOfRightImageButton;
    private HashMap<String, Integer> visibilityOfRightImageButtons;
    private int visibilityOfRightTextButton;
    private HashMap<String, Integer> visibilityOfRightTextButtons;

    public SwitcherInfoActivityViewModel(String str) {
        initResources();
        setState(str);
        setViews();
    }

    public void setState(String str) {
        this.state = str;
        setViews();
    }

    private void setViews() {
        setSettingName();
        setLeftButton();
        setRightButton();
        setRightTextButton();
        setVisibilityOfRightTextButton();
        setVisibilityOfRightImageButton();
    }

    private void initResources() {
        HashMap<String, String> map = new HashMap<>();
        this.menuNames = map;
        map.put(MENU_SWITCHER_INFO_MAIN, IOUtil.getStringResource(R.string.switcher_info_menu));
        this.menuNames.put(MENU_PRODUCTION, IOUtil.getStringResource(R.string.production_menu));
        this.menuNames.put(MENU_DELIVERY, IOUtil.getStringResource(R.string.switcher_info_menu));
        this.menuNames.put(MENU_RETURN_INFO, IOUtil.getStringResource(R.string.return_info_menu));
        this.menuNames.put(MENU_RETURN_BOOKING, IOUtil.getStringResource(R.string.return_booking_menu));
        this.menuNames.put(MENU_RETURN_BOOKING2, IOUtil.getStringResource(R.string.return_booking_menu));
        this.menuNames.put(MENU_RETURN_CONFIRM, IOUtil.getStringResource(R.string.return_confirm_menu));
        this.menuNames.put(MENU_PAYMENT_CARD_CHANGE, IOUtil.getStringResource(R.string.payment_card_selection_menu));
        this.menuNames.put(MENU_PAYMENT_CARD_INFO, IOUtil.getStringResource(R.string.payment_card_info_menu));
        this.menuNames.put(MENU_PLAN, IOUtil.getStringResource(R.string.plan_menu));
        this.menuNames.put(MENU_POST_CODE, IOUtil.getStringResource(R.string.return_booking_menu));
        this.menuNames.put(MENU_CONSIGNMENT, IOUtil.getStringResource(R.string.switcher_info_menu));
        this.menuNames.put(MENU_FREE_TRIAL, IOUtil.getStringResource(R.string.switcher_info_menu));
        this.menuNames.put(MENU_CONTRACT, IOUtil.getStringResource(R.string.switcher_info_menu));
        this.menuNames.put(MENU_BUYING_TYPE_CHANGE, IOUtil.getStringResource(R.string.buying_type_change_menu));
        this.menuNames.put(MENU_REMOCON, IOUtil.getStringResource(R.string.remocon_menu));
        HashMap<String, Drawable> map2 = new HashMap<>();
        this.leftButtonImages = map2;
        map2.put(MENU_SWITCHER_INFO_MAIN, IOUtil.makeDrawable(R.drawable.btn_left_arrow));
        this.leftButtonImages.put(MENU_PRODUCTION, IOUtil.makeDrawable(R.drawable.btn_left_arrow));
        this.leftButtonImages.put(MENU_DELIVERY, IOUtil.makeDrawable(R.drawable.btn_left_arrow));
        this.leftButtonImages.put(MENU_RETURN_INFO, IOUtil.makeDrawable(R.drawable.btn_left_arrow));
        this.leftButtonImages.put(MENU_RETURN_BOOKING, IOUtil.makeDrawable(R.drawable.btn_left_arrow));
        this.leftButtonImages.put(MENU_RETURN_BOOKING2, IOUtil.makeDrawable(R.drawable.btn_left_arrow));
        this.leftButtonImages.put(MENU_RETURN_CONFIRM, null);
        this.leftButtonImages.put(MENU_PAYMENT_CARD_CHANGE, IOUtil.makeDrawable(R.drawable.btn_left_arrow));
        this.leftButtonImages.put(MENU_PAYMENT_CARD_INFO, IOUtil.makeDrawable(R.drawable.btn_left_arrow));
        this.leftButtonImages.put(MENU_PLAN, IOUtil.makeDrawable(R.drawable.btn_left_arrow));
        this.leftButtonImages.put(MENU_POST_CODE, IOUtil.makeDrawable(R.drawable.btn_left_arrow));
        this.leftButtonImages.put(MENU_CONSIGNMENT, IOUtil.makeDrawable(R.drawable.btn_left_arrow));
        this.leftButtonImages.put(MENU_FREE_TRIAL, IOUtil.makeDrawable(R.drawable.btn_left_arrow));
        this.leftButtonImages.put(MENU_CONTRACT, IOUtil.makeDrawable(R.drawable.btn_left_arrow));
        this.leftButtonImages.put(MENU_BUYING_TYPE_CHANGE, IOUtil.makeDrawable(R.drawable.btn_left_arrow));
        this.leftButtonImages.put(MENU_REMOCON, IOUtil.makeDrawable(R.drawable.btn_left_arrow));
        HashMap<String, Drawable> map3 = new HashMap<>();
        this.rightButtonImages = map3;
        map3.put(MENU_SWITCHER_INFO_MAIN, null);
        this.rightButtonImages.put(MENU_PRODUCTION, null);
        this.rightButtonImages.put(MENU_DELIVERY, null);
        this.rightButtonImages.put(MENU_RETURN_INFO, null);
        this.rightButtonImages.put(MENU_RETURN_BOOKING, null);
        this.rightButtonImages.put(MENU_RETURN_BOOKING2, null);
        this.rightButtonImages.put(MENU_RETURN_CONFIRM, null);
        this.rightButtonImages.put(MENU_PAYMENT_CARD_CHANGE, IOUtil.makeDrawable(R.drawable.btn_security));
        this.rightButtonImages.put(MENU_PAYMENT_CARD_INFO, null);
        this.rightButtonImages.put(MENU_PLAN, IOUtil.makeDrawable(R.drawable.btn_faq_white_default));
        this.rightButtonImages.put(MENU_POST_CODE, null);
        this.rightButtonImages.put(MENU_CONSIGNMENT, null);
        this.rightButtonImages.put(MENU_FREE_TRIAL, null);
        this.rightButtonImages.put(MENU_CONTRACT, null);
        this.rightButtonImages.put(MENU_BUYING_TYPE_CHANGE, null);
        this.rightButtonImages.put(MENU_REMOCON, null);
        HashMap<String, String> map4 = new HashMap<>();
        this.rightButtonTexts = map4;
        map4.put(MENU_SWITCHER_INFO_MAIN, null);
        this.rightButtonTexts.put(MENU_PRODUCTION, null);
        this.rightButtonTexts.put(MENU_DELIVERY, null);
        this.rightButtonTexts.put(MENU_RETURN_INFO, null);
        this.rightButtonTexts.put(MENU_RETURN_BOOKING, null);
        this.rightButtonTexts.put(MENU_RETURN_BOOKING2, null);
        this.rightButtonTexts.put(MENU_RETURN_CONFIRM, null);
        this.rightButtonTexts.put(MENU_PAYMENT_CARD_CHANGE, null);
        this.rightButtonTexts.put(MENU_PAYMENT_CARD_INFO, null);
        this.rightButtonTexts.put(MENU_PLAN, IOUtil.getStringResource(R.string.confirm));
        this.rightButtonTexts.put(MENU_POST_CODE, null);
        this.rightButtonTexts.put(MENU_CONSIGNMENT, null);
        this.rightButtonTexts.put(MENU_FREE_TRIAL, null);
        this.rightButtonTexts.put(MENU_CONTRACT, null);
        this.rightButtonTexts.put(MENU_BUYING_TYPE_CHANGE, null);
        this.rightButtonTexts.put(MENU_REMOCON, null);
        HashMap<String, Integer> map5 = new HashMap<>();
        this.visibilityOfRightImageButtons = map5;
        map5.put(MENU_SWITCHER_INFO_MAIN, 4);
        this.visibilityOfRightImageButtons.put(MENU_PRODUCTION, 4);
        this.visibilityOfRightImageButtons.put(MENU_DELIVERY, 4);
        this.visibilityOfRightImageButtons.put(MENU_RETURN_INFO, 4);
        this.visibilityOfRightImageButtons.put(MENU_RETURN_BOOKING, 4);
        this.visibilityOfRightImageButtons.put(MENU_RETURN_BOOKING2, 4);
        this.visibilityOfRightImageButtons.put(MENU_RETURN_CONFIRM, 4);
        this.visibilityOfRightImageButtons.put(MENU_PAYMENT_CARD_CHANGE, 0);
        this.visibilityOfRightImageButtons.put(MENU_PAYMENT_CARD_INFO, 4);
        this.visibilityOfRightImageButtons.put(MENU_PLAN, 0);
        this.visibilityOfRightImageButtons.put(MENU_POST_CODE, 4);
        this.visibilityOfRightImageButtons.put(MENU_CONSIGNMENT, 4);
        this.visibilityOfRightImageButtons.put(MENU_FREE_TRIAL, 4);
        this.visibilityOfRightImageButtons.put(MENU_CONTRACT, 4);
        this.visibilityOfRightImageButtons.put(MENU_BUYING_TYPE_CHANGE, 4);
        this.visibilityOfRightImageButtons.put(MENU_REMOCON, 4);
        HashMap<String, Integer> map6 = new HashMap<>();
        this.visibilityOfRightTextButtons = map6;
        map6.put(MENU_SWITCHER_INFO_MAIN, 4);
        this.visibilityOfRightTextButtons.put(MENU_PRODUCTION, 4);
        this.visibilityOfRightTextButtons.put(MENU_DELIVERY, 4);
        this.visibilityOfRightTextButtons.put(MENU_RETURN_INFO, 4);
        this.visibilityOfRightTextButtons.put(MENU_RETURN_BOOKING, 4);
        this.visibilityOfRightTextButtons.put(MENU_RETURN_BOOKING2, 4);
        this.visibilityOfRightTextButtons.put(MENU_RETURN_CONFIRM, 4);
        this.visibilityOfRightTextButtons.put(MENU_PAYMENT_CARD_CHANGE, 4);
        this.visibilityOfRightTextButtons.put(MENU_PAYMENT_CARD_INFO, 4);
        this.visibilityOfRightTextButtons.put(MENU_PLAN, 4);
        this.visibilityOfRightTextButtons.put(MENU_POST_CODE, 4);
        this.visibilityOfRightTextButtons.put(MENU_CONSIGNMENT, 4);
        this.visibilityOfRightTextButtons.put(MENU_FREE_TRIAL, 4);
        this.visibilityOfRightTextButtons.put(MENU_CONTRACT, 4);
        this.visibilityOfRightTextButtons.put(MENU_BUYING_TYPE_CHANGE, 4);
        this.visibilityOfRightTextButtons.put(MENU_REMOCON, 4);
    }

    @Bindable
    public String getMenuName() {
        return this.menuName;
    }

    public void setSettingName() {
        this.menuName = this.menuNames.get(this.state);
        notifyPropertyChanged(20);
    }

    @Bindable
    public Drawable getLeftButton() {
        return this.leftButton;
    }

    public void setLeftButton() {
        this.leftButton = this.leftButtonImages.get(this.state);
        notifyPropertyChanged(19);
    }

    @Bindable
    public Drawable getRightButton() {
        return this.rightButton;
    }

    public void setRightButton() {
        this.rightButton = this.rightButtonImages.get(this.state);
        notifyPropertyChanged(30);
    }

    @Bindable
    public String getRightButtonText() {
        return this.rightButtonText;
    }

    public void setRightTextButton() {
        this.rightButtonText = this.rightButtonTexts.get(this.state);
        notifyPropertyChanged(31);
    }

    @Bindable
    public int getVisibilityOfRightImageButton() {
        return this.visibilityOfRightImageButton;
    }

    public void setVisibilityOfRightImageButton() {
        this.visibilityOfRightImageButton = this.visibilityOfRightImageButtons.get(this.state).intValue();
        notifyPropertyChanged(50);
    }

    @Bindable
    public int getVisibilityOfRightTextButton() {
        return this.visibilityOfRightTextButton;
    }

    public void setVisibilityOfRightTextButton() {
        this.visibilityOfRightTextButton = this.visibilityOfRightTextButtons.get(this.state).intValue();
        notifyPropertyChanged(51);
    }
}
