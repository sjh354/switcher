package kr.switcher.switcherm.ui.irbrandgraph.interactor.helper;

import kr.switcher.device.IODevice;
import kr.switcher.switcherm.common.chart.IOLineChart;
import kr.switcher.switcherm.ui.irbrandgraph.interactor.FindRecentCommandHistoryInteractor;

/* JADX INFO: loaded from: classes2.dex */
public class FindRecentCommandHistoryHelper {
    private static final String ONE_WAY_BOTTOM_OFF_NAME = "하단 꺼짐";
    private static final String ONE_WAY_BOTTOM_ON_NAME = "하단 켜짐";
    private static final int ONE_WAY_OFF = 1;
    private static final String ONE_WAY_OFF_NAME = "꺼짐";
    private static final int ONE_WAY_ON = 0;
    private static final String ONE_WAY_ON_NAME = "켜짐";
    private static final String ONE_WAY_TOP_OFF_NAME = "상단 꺼짐";
    private static final String ONE_WAY_TOP_ON_NAME = "상단 켜짐";
    private static final int TWO_WAY_BOTTOM_OFF = 3;
    private static final int TWO_WAY_BOTTOM_ON = 2;
    private static final int TWO_WAY_TOP_OFF = 1;
    private static final int TWO_WAY_TOP_ON = 0;

    public static String getNameOfValue(IODevice.ProductId productId, int i, String str) {
        if (productId.equals(IODevice.ProductId.SWITCHER_TYPE_ONE)) {
            if (i == 0) {
                return ONE_WAY_ON_NAME;
            }
            if (i == 1) {
                return ONE_WAY_OFF_NAME;
            }
        } else if (productId.equals(IODevice.ProductId.SWITCHER_TYPE_TWO)) {
            if (i == 0) {
                return ONE_WAY_TOP_ON_NAME;
            }
            if (i == 1) {
                return ONE_WAY_TOP_OFF_NAME;
            }
            if (i == 2) {
                return ONE_WAY_BOTTOM_ON_NAME;
            }
            if (i == 3) {
                return ONE_WAY_BOTTOM_OFF_NAME;
            }
        }
        return str;
    }

    public static String getHourMinOfDate(String str) {
        try {
            String str2 = str.split("T")[1];
            return str2.split(":")[0] + ":" + str2.split(":")[1];
        } catch (Exception unused) {
            return "-";
        }
    }

    public static float convertStringToFloat(String str) {
        try {
            return Float.parseFloat(str);
        } catch (NumberFormatException unused) {
            return 0.0f;
        }
    }

    public static float convertStringToFloatDecimalTwo(String str) {
        try {
            return Float.parseFloat(String.format("%.2f", Float.valueOf(Float.parseFloat(str))));
        } catch (NumberFormatException unused) {
            return 0.0f;
        }
    }

    /* JADX INFO: renamed from: kr.switcher.switcherm.ui.irbrandgraph.interactor.helper.FindRecentCommandHistoryHelper$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$kr$switcher$switcherm$ui$irbrandgraph$interactor$FindRecentCommandHistoryInteractor$ExpandedControllerID;

        static {
            int[] iArr = new int[FindRecentCommandHistoryInteractor.ExpandedControllerID.values().length];
            $SwitchMap$kr$switcher$switcherm$ui$irbrandgraph$interactor$FindRecentCommandHistoryInteractor$ExpandedControllerID = iArr;
            try {
                iArr[FindRecentCommandHistoryInteractor.ExpandedControllerID.TV.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$kr$switcher$switcherm$ui$irbrandgraph$interactor$FindRecentCommandHistoryInteractor$ExpandedControllerID[FindRecentCommandHistoryInteractor.ExpandedControllerID.SET_TOP_BOX.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$kr$switcher$switcherm$ui$irbrandgraph$interactor$FindRecentCommandHistoryInteractor$ExpandedControllerID[FindRecentCommandHistoryInteractor.ExpandedControllerID.SWITCHER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$kr$switcher$switcherm$ui$irbrandgraph$interactor$FindRecentCommandHistoryInteractor$ExpandedControllerID[FindRecentCommandHistoryInteractor.ExpandedControllerID.AIRCON.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static IOLineChart.ChartYUnitKinds getUnit(FindRecentCommandHistoryInteractor.ExpandedControllerID expandedControllerID) {
        int i = AnonymousClass1.$SwitchMap$kr$switcher$switcherm$ui$irbrandgraph$interactor$FindRecentCommandHistoryInteractor$ExpandedControllerID[expandedControllerID.ordinal()];
        if (i == 1 || i == 2 || i == 3) {
            return IOLineChart.ChartYUnitKinds.PERCENTAGE;
        }
        if (i == 4) {
            return IOLineChart.ChartYUnitKinds.CELSIUS;
        }
        return IOLineChart.ChartYUnitKinds.DEFAULT;
    }
}
