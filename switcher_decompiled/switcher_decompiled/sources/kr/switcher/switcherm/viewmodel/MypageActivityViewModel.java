package kr.switcher.switcherm.viewmodel;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import java.util.HashMap;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.util.IOUtil;

/* JADX INFO: loaded from: classes2.dex */
public class MypageActivityViewModel extends BaseObservable {
    public static final String MENU_HELP = "HELP";
    public static final String MENU_HELP_COMPANY_INFO = "HELP_COMPANY_INFO";
    public static final String MENU_HELP_OPEN_SOURCE = "HELP_OPEN_SOURCE";
    public static final String MENU_HELP_PURCHASE = "HELP_PURCHASE";
    public static final String MENU_HELP_RETURN = "HELP_RETURN";
    public static final String MENU_HELP_TERMS_OF_USE = "HELP_TERMS_OF_USE";
    public static final String MENU_HELP_TROUBLESHOOTING = "HELP_TROUBLESHOOTING";
    public static final String MENU_LIST = "MYPAGE";
    private Context context;
    private Drawable leftButton;
    private HashMap<String, Drawable> leftButtonImages;
    private String menuName;
    private HashMap<String, String> menuNames;
    private Drawable rightButton;
    private HashMap<String, Drawable> rightButtonImages;
    private String state;

    public MypageActivityViewModel(Context context, String str) {
        this.context = context;
        initResources();
        setState(str);
    }

    public void setState(String str) {
        this.state = str;
        setViews();
    }

    private void setViews() {
        setSettingName();
        setLeftButton();
        setRightButton();
    }

    private void initResources() {
        HashMap<String, String> map = new HashMap<>();
        this.menuNames = map;
        map.put(MENU_LIST, IOUtil.getStringResource(R.string.mypage_name));
        this.menuNames.put(MENU_HELP, IOUtil.getStringResource(R.string.mypage_help));
        this.menuNames.put(MENU_HELP_TROUBLESHOOTING, IOUtil.getStringResource(R.string.help_menu_name1));
        this.menuNames.put(MENU_HELP_PURCHASE, IOUtil.getStringResource(R.string.help_menu_name2));
        this.menuNames.put(MENU_HELP_RETURN, IOUtil.getStringResource(R.string.help_menu_name3));
        this.menuNames.put(MENU_HELP_COMPANY_INFO, IOUtil.getStringResource(R.string.help_menu_name4));
        this.menuNames.put(MENU_HELP_TERMS_OF_USE, IOUtil.getStringResource(R.string.help_menu_name5));
        this.menuNames.put(MENU_HELP_OPEN_SOURCE, IOUtil.getStringResource(R.string.help_menu_name6));
        HashMap<String, Drawable> map2 = new HashMap<>();
        this.leftButtonImages = map2;
        map2.put(MENU_LIST, makeDrawable(R.drawable.btn_close_dark_default));
        this.leftButtonImages.put(MENU_HELP, makeDrawable(R.drawable.btn_left_arrow));
        this.leftButtonImages.put(MENU_HELP_TROUBLESHOOTING, makeDrawable(R.drawable.btn_left_arrow));
        this.leftButtonImages.put(MENU_HELP_PURCHASE, makeDrawable(R.drawable.btn_left_arrow));
        this.leftButtonImages.put(MENU_HELP_RETURN, makeDrawable(R.drawable.btn_left_arrow));
        this.leftButtonImages.put(MENU_HELP_COMPANY_INFO, makeDrawable(R.drawable.btn_left_arrow));
        this.leftButtonImages.put(MENU_HELP_TERMS_OF_USE, makeDrawable(R.drawable.btn_left_arrow));
        this.leftButtonImages.put(MENU_HELP_OPEN_SOURCE, makeDrawable(R.drawable.btn_left_arrow));
        HashMap<String, Drawable> map3 = new HashMap<>();
        this.rightButtonImages = map3;
        map3.put(MENU_LIST, null);
        this.rightButtonImages.put(MENU_HELP, null);
        this.rightButtonImages.put(MENU_HELP_TROUBLESHOOTING, null);
        this.rightButtonImages.put(MENU_HELP_PURCHASE, null);
        this.rightButtonImages.put(MENU_HELP_RETURN, null);
        this.rightButtonImages.put(MENU_HELP_COMPANY_INFO, null);
        this.rightButtonImages.put(MENU_HELP_TERMS_OF_USE, null);
        this.rightButtonImages.put(MENU_HELP_OPEN_SOURCE, null);
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
}
