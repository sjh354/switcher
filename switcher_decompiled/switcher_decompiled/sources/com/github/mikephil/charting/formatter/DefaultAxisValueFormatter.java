package com.github.mikephil.charting.formatter;

import java.text.DecimalFormat;
import kr.switcher.device.switcher.Switcher;

/* JADX INFO: loaded from: classes.dex */
public class DefaultAxisValueFormatter extends ValueFormatter {
    protected int digits;
    protected DecimalFormat mFormat;

    public DefaultAxisValueFormatter(int i) {
        this.digits = i;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < i; i2++) {
            if (i2 == 0) {
                stringBuffer.append(".");
            }
            stringBuffer.append(Switcher.SwitcherReservation.SWITCH_1WAY_FIRMWARE);
        }
        this.mFormat = new DecimalFormat("###,###,###,##0" + stringBuffer.toString());
    }

    @Override // com.github.mikephil.charting.formatter.ValueFormatter
    public String getFormattedValue(float f) {
        return this.mFormat.format(f);
    }

    public int getDecimalDigits() {
        return this.digits;
    }
}
