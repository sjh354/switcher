package kr.switcher.switcherm.ui.irbrandgraph.interactor.helper;

import kr.switcher.switcherm.ui.irbrandgraph.interactor.FindRecentCommandHistoryInteractor;

/* JADX INFO: loaded from: classes2.dex */
public class UnitConverter {
    private static final float ILLUMINATION_MAX_VALUE = 2000.0f;
    private static final float SOUND_MAX_VALUE = 2000.0f;
    private static final float Y_MAX_PERCENTAGE = 100.0f;
    private static final float Y_MIN_PERCENTAGE = 0.0f;

    public static Float convertIllumination(String str) {
        return Float.valueOf((Float.valueOf(FindRecentCommandHistoryHelper.convertStringToFloat(str)).floatValue() / 2000.0f) * Y_MAX_PERCENTAGE);
    }

    public static Float convertSound(String str) {
        return Float.valueOf((Float.valueOf(FindRecentCommandHistoryHelper.convertStringToFloat(str)).floatValue() / 2000.0f) * Y_MAX_PERCENTAGE);
    }

    public static Float convertTemperature(String str) {
        return Float.valueOf(FindRecentCommandHistoryHelper.convertStringToFloatDecimalTwo(str));
    }

    /* JADX INFO: renamed from: kr.switcher.switcherm.ui.irbrandgraph.interactor.helper.UnitConverter$1, reason: invalid class name */
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
        }
    }

    public static MinMax getControllerMinMaxValue(FindRecentCommandHistoryInteractor.ExpandedControllerID expandedControllerID) {
        int i = AnonymousClass1.$SwitchMap$kr$switcher$switcherm$ui$irbrandgraph$interactor$FindRecentCommandHistoryInteractor$ExpandedControllerID[expandedControllerID.ordinal()];
        if (i == 1 || i == 2) {
            return new MinMax(0.0f, Y_MAX_PERCENTAGE);
        }
        if (i == 3) {
            return new MinMax(0.0f, Y_MAX_PERCENTAGE);
        }
        return new MinMax();
    }
}
