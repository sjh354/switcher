package com.github.mikephil.charting.formatter;

import java.text.DecimalFormat;

/* JADX INFO: loaded from: classes.dex */
public class LargeValueFormatter extends ValueFormatter {
    private DecimalFormat mFormat;
    private int mMaxLength;
    private String[] mSuffix;
    private String mText;

    public int getDecimalDigits() {
        return 0;
    }

    public LargeValueFormatter() {
        this.mSuffix = new String[]{"", "k", "m", "b", "t"};
        this.mMaxLength = 5;
        this.mText = "";
        this.mFormat = new DecimalFormat("###E00");
    }

    public LargeValueFormatter(String str) {
        this();
        this.mText = str;
    }

    @Override // com.github.mikephil.charting.formatter.ValueFormatter
    public String getFormattedValue(float f) {
        return makePretty(f) + this.mText;
    }

    public void setAppendix(String str) {
        this.mText = str;
    }

    public void setSuffix(String[] strArr) {
        this.mSuffix = strArr;
    }

    public void setMaxLength(int i) {
        this.mMaxLength = i;
    }

    private String makePretty(double d) {
        String str = this.mFormat.format(d);
        String strReplaceAll = str.replaceAll("E[0-9][0-9]", this.mSuffix[Integer.valueOf(Character.getNumericValue(str.charAt(str.length() - 2)) + "" + Character.getNumericValue(str.charAt(str.length() - 1))).intValue() / 3]);
        while (true) {
            if (strReplaceAll.length() <= this.mMaxLength && !strReplaceAll.matches("[0-9]+\\.[a-z]")) {
                return strReplaceAll;
            }
            strReplaceAll = strReplaceAll.substring(0, strReplaceAll.length() - 2) + strReplaceAll.substring(strReplaceAll.length() - 1);
        }
    }
}
