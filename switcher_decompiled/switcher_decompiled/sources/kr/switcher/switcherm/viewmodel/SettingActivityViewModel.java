package kr.switcher.switcherm.viewmodel;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import java.util.HashMap;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.util.IOUtil;

/* JADX INFO: loaded from: classes2.dex */
public class SettingActivityViewModel extends BaseObservable {
    public static final String MENU_AIRCON_MAINTAINING_TEMPERATURE = "MENU_AIRCON_MAINTAINING_TEMPERATURE";
    public static final String MENU_AIRCON_MAINTAINING_TEMPERATURE_LIST = "MENU_AIRCON_MAINTAINING_TEMPERATURE_LIST";
    public static final String MENU_AIRCON_RESERVATION = "MENU_AIRCON_RESERVATION";
    public static final String MENU_AIRCON_RESERVATION_LIST = "MENU_AIRCON_RESERVATION_LIST";
    public static final String MENU_CHECKER_HISTORY = "MENU_CHECKER_HISTORY";
    public static final String MENU_CHECKER_SETTING = "MENU_CHECKER_SETTING";
    public static final String MENU_CHECKER_SURVEILLANCE = "MENU_CHECKER_SURVEILLANCE";
    public static final String MENU_CHECKER_SURVEILLANCE_LIST = "MENU_CHECKER_SURVEILLANCE_LIST";
    public static final String MENU_FIRMWARE_UPDATE = "FIRMWARE_UPDATE";
    public static final String MENU_LIST = "LIST";
    public static final String MENU_SETTOP_RESERVATION = "MENU_SETTOP_RESERVATION";
    public static final String MENU_SETTOP_RESERVATION_LIST = "MENU_SETTOP_RESERVATION_LIST";
    public static final String MENU_SHARE_CODE = "SHARE_CODE";
    public static final String MENU_SHARE_CODE_CLICKED = "SHARE_CODE_CLICKED";
    public static final String MENU_STROKE_LEVEL = "MENU_STROKE_LEVEL";
    public static final String MENU_STROKE_LEVEL_TEST_ING = "MENU_STROKE_LEVEL_TEST_ING";
    public static final String MENU_TIMER = "TIMER";
    public static final String MENU_TIMER_LIST = "TIMER_LIST";
    public static final String MENU_TIMER_LIST_FULL = "TIMER_LIST_FULL";
    private Context context;
    private Drawable leftButton;
    private HashMap<String, Drawable> leftButtonImages;
    private String menuName;
    private HashMap<String, String> menuNames;
    private Drawable rightButton;
    private HashMap<String, Drawable> rightButtonImages;
    private String rightButtonText;
    private HashMap<String, String> rightButtonTexts;
    private String state;
    private int visibilityOfProgressbar;
    private int visibilityOfRightImageButton;
    private HashMap<String, Integer> visibilityOfRightImageButtons;
    private int visibilityOfRightTextButton;
    private HashMap<String, Integer> visibilityOfRightTextButtons;

    public SettingActivityViewModel(Context context, String str) {
        this.context = context;
        initResources();
        setState(str);
        hideProgressbar();
    }

    public void setState(String str) {
        this.state = str;
        setViews();
    }

    public String getState() {
        return this.state;
    }

    private void setViews() {
        setSettingName();
        setLeftButton();
        setRightButton();
        setRightButtonText();
    }

    private void initResources() {
        HashMap<String, String> map = new HashMap<>();
        this.menuNames = map;
        map.put(MENU_LIST, IOUtil.getStringResource(R.string.setting_list_menu));
        this.menuNames.put(MENU_TIMER_LIST, IOUtil.getStringResource(R.string.timer_list_menu));
        this.menuNames.put(MENU_TIMER_LIST_FULL, IOUtil.getStringResource(R.string.timer_list_menu));
        this.menuNames.put(MENU_TIMER, IOUtil.getStringResource(R.string.timer_menu));
        this.menuNames.put(MENU_SHARE_CODE, IOUtil.getStringResource(R.string.share_code_menu));
        this.menuNames.put(MENU_SHARE_CODE_CLICKED, IOUtil.getStringResource(R.string.share_code_menu));
        this.menuNames.put(MENU_FIRMWARE_UPDATE, IOUtil.getStringResource(R.string.firmware_update_menu));
        this.menuNames.put(MENU_STROKE_LEVEL, IOUtil.getStringResource(R.string.stroke_level_menu));
        this.menuNames.put(MENU_STROKE_LEVEL_TEST_ING, IOUtil.getStringResource(R.string.stroke_level_menu));
        this.menuNames.put(MENU_CHECKER_HISTORY, IOUtil.getStringResource(R.string.checker_history_name));
        this.menuNames.put(MENU_CHECKER_SETTING, IOUtil.getStringResource(R.string.checker_setting_name));
        this.menuNames.put(MENU_AIRCON_RESERVATION_LIST, IOUtil.getStringResource(R.string.aircon_reservation_list));
        this.menuNames.put(MENU_AIRCON_RESERVATION, IOUtil.getStringResource(R.string.timer_menu));
        this.menuNames.put(MENU_AIRCON_MAINTAINING_TEMPERATURE_LIST, IOUtil.getStringResource(R.string.aircon_maintainance_list));
        this.menuNames.put(MENU_AIRCON_MAINTAINING_TEMPERATURE, IOUtil.getStringResource(R.string.maintaining_temperature_menu));
        this.menuNames.put(MENU_CHECKER_SURVEILLANCE, IOUtil.getStringResource(R.string.surveillance_menu));
        this.menuNames.put(MENU_CHECKER_SURVEILLANCE_LIST, IOUtil.getStringResource(R.string.surveillance_list_menu));
        this.menuNames.put(MENU_SETTOP_RESERVATION, IOUtil.getStringResource(R.string.timer_menu));
        this.menuNames.put(MENU_SETTOP_RESERVATION_LIST, IOUtil.getStringResource(R.string.aircon_reservation_list));
        HashMap<String, Drawable> map2 = new HashMap<>();
        this.leftButtonImages = map2;
        map2.put(MENU_LIST, makeDrawable(R.drawable.btn_close_dark_default));
        this.leftButtonImages.put(MENU_TIMER_LIST, makeDrawable(R.drawable.btn_left_arrow));
        this.leftButtonImages.put(MENU_TIMER_LIST_FULL, makeDrawable(R.drawable.btn_left_arrow));
        this.leftButtonImages.put(MENU_TIMER, makeDrawable(R.drawable.btn_left_arrow));
        this.leftButtonImages.put(MENU_SHARE_CODE, makeDrawable(R.drawable.btn_left_arrow));
        this.leftButtonImages.put(MENU_SHARE_CODE_CLICKED, makeDrawable(R.drawable.btn_left_arrow));
        this.leftButtonImages.put(MENU_FIRMWARE_UPDATE, makeDrawable(R.drawable.btn_left_arrow));
        this.leftButtonImages.put(MENU_STROKE_LEVEL, makeDrawable(R.drawable.btn_left_arrow));
        this.leftButtonImages.put(MENU_STROKE_LEVEL_TEST_ING, makeDrawable(R.drawable.btn_left_arrow));
        this.leftButtonImages.put(MENU_CHECKER_HISTORY, makeDrawable(R.drawable.btn_left_arrow));
        this.leftButtonImages.put(MENU_AIRCON_RESERVATION_LIST, makeDrawable(R.drawable.btn_left_arrow));
        this.leftButtonImages.put(MENU_AIRCON_RESERVATION, makeDrawable(R.drawable.btn_left_arrow));
        this.leftButtonImages.put(MENU_AIRCON_MAINTAINING_TEMPERATURE_LIST, makeDrawable(R.drawable.btn_left_arrow));
        this.leftButtonImages.put(MENU_AIRCON_MAINTAINING_TEMPERATURE, makeDrawable(R.drawable.btn_close_dark_default));
        this.leftButtonImages.put(MENU_CHECKER_SURVEILLANCE, makeDrawable(R.drawable.btn_close_dark_default));
        this.leftButtonImages.put(MENU_CHECKER_SURVEILLANCE_LIST, makeDrawable(R.drawable.btn_left_arrow));
        this.leftButtonImages.put(MENU_SETTOP_RESERVATION_LIST, makeDrawable(R.drawable.btn_left_arrow));
        this.leftButtonImages.put(MENU_SETTOP_RESERVATION, makeDrawable(R.drawable.btn_left_arrow));
        HashMap<String, Drawable> map3 = new HashMap<>();
        this.rightButtonImages = map3;
        map3.put(MENU_LIST, null);
        this.rightButtonImages.put(MENU_TIMER_LIST, makeDrawable(R.drawable.btn_menu_default));
        this.rightButtonImages.put(MENU_TIMER_LIST_FULL, null);
        this.rightButtonImages.put(MENU_TIMER, null);
        this.rightButtonImages.put(MENU_SHARE_CODE, null);
        this.rightButtonImages.put(MENU_SHARE_CODE_CLICKED, null);
        this.rightButtonImages.put(MENU_FIRMWARE_UPDATE, null);
        this.rightButtonImages.put(MENU_STROKE_LEVEL, null);
        this.rightButtonImages.put(MENU_STROKE_LEVEL_TEST_ING, null);
        this.rightButtonImages.put(MENU_CHECKER_HISTORY, null);
        this.rightButtonImages.put(MENU_AIRCON_RESERVATION_LIST, makeDrawable(R.drawable.btn_menu_default));
        this.rightButtonImages.put(MENU_AIRCON_RESERVATION, null);
        this.rightButtonImages.put(MENU_AIRCON_MAINTAINING_TEMPERATURE_LIST, makeDrawable(R.drawable.btn_menu_default));
        this.rightButtonImages.put(MENU_AIRCON_MAINTAINING_TEMPERATURE, null);
        this.rightButtonImages.put(MENU_CHECKER_SURVEILLANCE, null);
        this.rightButtonImages.put(MENU_CHECKER_SURVEILLANCE_LIST, makeDrawable(R.drawable.btn_menu_default));
        this.rightButtonImages.put(MENU_SETTOP_RESERVATION_LIST, makeDrawable(R.drawable.btn_menu_default));
        this.rightButtonImages.put(MENU_SETTOP_RESERVATION, null);
        HashMap<String, String> map4 = new HashMap<>();
        this.rightButtonTexts = map4;
        map4.put(MENU_LIST, null);
        this.rightButtonTexts.put(MENU_TIMER_LIST, null);
        this.rightButtonTexts.put(MENU_TIMER_LIST_FULL, null);
        this.rightButtonTexts.put(MENU_TIMER, IOUtil.getStringResource(R.string.save));
        this.rightButtonTexts.put(MENU_SHARE_CODE, IOUtil.getStringResource(R.string.save));
        this.rightButtonTexts.put(MENU_SHARE_CODE_CLICKED, null);
        this.rightButtonTexts.put(MENU_FIRMWARE_UPDATE, null);
        this.rightButtonTexts.put(MENU_STROKE_LEVEL, IOUtil.getStringResource(R.string.save));
        this.rightButtonTexts.put(MENU_STROKE_LEVEL_TEST_ING, null);
        this.rightButtonTexts.put(MENU_CHECKER_HISTORY, null);
        this.rightButtonTexts.put(MENU_AIRCON_RESERVATION_LIST, null);
        this.rightButtonTexts.put(MENU_AIRCON_RESERVATION, IOUtil.getStringResource(R.string.save));
        this.rightButtonTexts.put(MENU_AIRCON_MAINTAINING_TEMPERATURE_LIST, null);
        this.rightButtonTexts.put(MENU_AIRCON_MAINTAINING_TEMPERATURE, IOUtil.getStringResource(R.string.save));
        this.rightButtonTexts.put(MENU_CHECKER_SURVEILLANCE, IOUtil.getStringResource(R.string.save));
        this.rightButtonTexts.put(MENU_CHECKER_SURVEILLANCE_LIST, null);
        this.rightButtonTexts.put(MENU_SETTOP_RESERVATION_LIST, null);
        this.rightButtonTexts.put(MENU_SETTOP_RESERVATION, IOUtil.getStringResource(R.string.save));
        HashMap<String, Integer> map5 = new HashMap<>();
        this.visibilityOfRightImageButtons = map5;
        map5.put(MENU_LIST, 4);
        this.visibilityOfRightImageButtons.put(MENU_TIMER_LIST, 0);
        this.visibilityOfRightImageButtons.put(MENU_TIMER_LIST_FULL, 0);
        this.visibilityOfRightImageButtons.put(MENU_TIMER, 4);
        this.visibilityOfRightImageButtons.put(MENU_SHARE_CODE, 4);
        this.visibilityOfRightImageButtons.put(MENU_SHARE_CODE_CLICKED, 4);
        this.visibilityOfRightImageButtons.put(MENU_FIRMWARE_UPDATE, 4);
        this.visibilityOfRightImageButtons.put(MENU_STROKE_LEVEL, 4);
        this.visibilityOfRightImageButtons.put(MENU_STROKE_LEVEL_TEST_ING, 4);
        this.visibilityOfRightImageButtons.put(MENU_STROKE_LEVEL_TEST_ING, 4);
        this.visibilityOfRightImageButtons.put(MENU_AIRCON_RESERVATION_LIST, 0);
        this.visibilityOfRightImageButtons.put(MENU_AIRCON_RESERVATION, 4);
        this.visibilityOfRightImageButtons.put(MENU_AIRCON_MAINTAINING_TEMPERATURE_LIST, 0);
        this.visibilityOfRightImageButtons.put(MENU_AIRCON_MAINTAINING_TEMPERATURE, 4);
        this.visibilityOfRightImageButtons.put(MENU_CHECKER_SURVEILLANCE, 4);
        this.visibilityOfRightImageButtons.put(MENU_CHECKER_SURVEILLANCE_LIST, 0);
        this.visibilityOfRightImageButtons.put(MENU_SETTOP_RESERVATION_LIST, 0);
        this.visibilityOfRightImageButtons.put(MENU_SETTOP_RESERVATION, 4);
        HashMap<String, Integer> map6 = new HashMap<>();
        this.visibilityOfRightTextButtons = map6;
        map6.put(MENU_LIST, 4);
        this.visibilityOfRightTextButtons.put(MENU_TIMER_LIST, 4);
        this.visibilityOfRightTextButtons.put(MENU_TIMER, 0);
        this.visibilityOfRightTextButtons.put(MENU_SHARE_CODE, 0);
        this.visibilityOfRightTextButtons.put(MENU_SHARE_CODE_CLICKED, 8);
        this.visibilityOfRightTextButtons.put(MENU_FIRMWARE_UPDATE, 4);
        this.visibilityOfRightTextButtons.put(MENU_STROKE_LEVEL, 4);
        this.visibilityOfRightTextButtons.put(MENU_STROKE_LEVEL, 0);
        this.visibilityOfRightTextButtons.put(MENU_STROKE_LEVEL_TEST_ING, 4);
        this.visibilityOfRightTextButtons.put(MENU_CHECKER_HISTORY, 4);
        this.visibilityOfRightTextButtons.put(MENU_AIRCON_RESERVATION_LIST, 0);
        this.visibilityOfRightTextButtons.put(MENU_AIRCON_MAINTAINING_TEMPERATURE_LIST, 0);
        this.visibilityOfRightTextButtons.put(MENU_AIRCON_MAINTAINING_TEMPERATURE, 0);
        this.visibilityOfRightTextButtons.put(MENU_CHECKER_SURVEILLANCE, 0);
        this.visibilityOfRightTextButtons.put(MENU_CHECKER_SURVEILLANCE_LIST, 0);
        this.visibilityOfRightTextButtons.put(MENU_SETTOP_RESERVATION_LIST, 0);
        this.visibilityOfRightTextButtons.put(MENU_SETTOP_RESERVATION, 0);
    }

    public void showProgressbar() {
        setVisibilityOfProgressbar(0);
    }

    public void hideProgressbar() {
        setVisibilityOfProgressbar(4);
    }

    private Drawable makeDrawable(int i) {
        return this.context.getResources().getDrawable(i);
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

    public void setRightButtonText() {
        this.rightButtonText = this.rightButtonTexts.get(this.state);
        notifyPropertyChanged(31);
    }

    @Bindable
    public int getVisibilityOfRightImageButton() {
        return this.visibilityOfRightImageButton;
    }

    public void setVisibilityOfRightImageButton(int i) {
        this.visibilityOfRightImageButton = i;
        notifyPropertyChanged(50);
    }

    @Bindable
    public int getVisibilityOfRightTextButton() {
        return this.visibilityOfRightTextButton;
    }

    public void setVisibilityOfRightTextButton(int i) {
        this.visibilityOfRightTextButton = i;
        notifyPropertyChanged(51);
    }

    @Bindable
    public int getVisibilityOfProgressbar() {
        return this.visibilityOfProgressbar;
    }

    public void setVisibilityOfProgressbar(int i) {
        this.visibilityOfProgressbar = i;
        notifyPropertyChanged(46);
    }
}
