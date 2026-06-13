package kr.switcher.switcherm.ui.switcherInfo.helper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import kr.switcher.switcherm.common.util.IOUtil;

/* JADX INFO: loaded from: classes2.dex */
public class SwitcherInfoHelper {
    private final String SEPARATOR = ",";
    private final int POST_CODE_NUMBER = 0;
    private final int ZONE_CODE_NUMBER = 1;
    private final int ADDRESS_NUMBER = 2;
    private final String EMPTY_VALUE = "";

    public int getChangeModelType(int i) {
        if (i != 1) {
            return i != 2 ? 0 : 1;
        }
        return 2;
    }

    public String getPostNumberByWebView(String str) {
        String[] strArrSplit = str.split(",");
        if (!checkIsValidData(strArrSplit)) {
            return "";
        }
        String str2 = strArrSplit[0];
        if (IOUtil.checkIsNullAndEmptyParameter(str2)) {
            str2 = strArrSplit[1];
        }
        return IOUtil.checkIsNullAndEmptyParameter(str2) ? "" : str2;
    }

    public String getAddressByWebView(String str) {
        String[] strArrSplit = str.split(",");
        if (!checkIsValidData(strArrSplit)) {
            return "";
        }
        String strSubstring = str.substring(strArrSplit[0].length() + 1 + strArrSplit[1].length() + 1);
        return IOUtil.checkIsNullAndEmptyParameter(strSubstring) ? "" : strSubstring;
    }

    private boolean checkIsValidData(String[] strArr) {
        return strArr.length >= 3;
    }

    public int getFewDaysLeft(String str, String str2) {
        try {
            return (int) ((new SimpleDateFormat("yyyy-MM-dd").parse(str2).getTime() - new SimpleDateFormat("yyyy-MM-dd").parse(str).getTime()) / 86400000);
        } catch (ParseException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
