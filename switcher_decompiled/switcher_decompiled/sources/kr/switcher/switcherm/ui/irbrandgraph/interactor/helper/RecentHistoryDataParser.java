package kr.switcher.switcherm.ui.irbrandgraph.interactor.helper;

import java.util.ArrayList;
import java.util.List;
import kr.switcher.switcherm.common.chart.IOChartData;
import kr.switcher.switcherm.network.http.RestErrorCode;
import kr.switcher.switcherm.network.http.response.SensorsForLastOneAPIResponse;
import kr.switcher.switcherm.ui.irbrandgraph.interactor.FindRecentCommandHistoryInteractor;

/* JADX INFO: loaded from: classes2.dex */
public class RecentHistoryDataParser {
    private final String COMMAND_NO_SWITCHER = "1";
    private final String COMMAND_NO_REMOCON = RestErrorCode.AUTHNUMBER_IS_WRONG;

    public SensorChartData parseSensorItems(SensorsForLastOneAPIResponse sensorsForLastOneAPIResponse, FindRecentCommandHistoryInteractor.ExpandedControllerID expandedControllerID) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        Float fValueOf = Float.valueOf(-1.0f);
        if (sensorsForLastOneAPIResponse == null) {
            return null;
        }
        List<SensorsForLastOneAPIResponse.HeartBeatsForLastOne> list = sensorsForLastOneAPIResponse.heart_beat_list;
        Float f = fValueOf;
        for (int i = 0; i < list.size(); i++) {
            SensorsForLastOneAPIResponse.HeartBeatsForLastOne heartBeatsForLastOne = list.get(i);
            arrayList2.add(FindRecentCommandHistoryHelper.getHourMinOfDate(heartBeatsForLastOne.created_at));
            int i2 = AnonymousClass1.$SwitchMap$kr$switcher$switcherm$ui$irbrandgraph$interactor$FindRecentCommandHistoryInteractor$ExpandedControllerID[expandedControllerID.ordinal()];
            if (i2 == 1) {
                Float fConvertTemperature = UnitConverter.convertTemperature(heartBeatsForLastOne.temperature);
                if (fValueOf.floatValue() == -1.0f && f.floatValue() == -1.0f) {
                    fValueOf = fConvertTemperature;
                    f = fValueOf;
                } else if (fConvertTemperature.floatValue() < fValueOf.floatValue()) {
                    fValueOf = fConvertTemperature;
                } else if (fConvertTemperature.floatValue() > f.floatValue()) {
                    f = fConvertTemperature;
                }
                arrayList3.add(fConvertTemperature);
            } else if (i2 == 2) {
                arrayList3.add(UnitConverter.convertSound(heartBeatsForLastOne.decibel));
            } else if (i2 == 3) {
                arrayList3.add(UnitConverter.convertSound(heartBeatsForLastOne.decibel));
            } else if (i2 == 4) {
                arrayList3.add(UnitConverter.convertIllumination(heartBeatsForLastOne.illumination_intensity));
            }
        }
        arrayList.add(new IOChartData("링커", arrayList2, arrayList3));
        if (expandedControllerID == FindRecentCommandHistoryInteractor.ExpandedControllerID.AIRCON) {
            return new SensorChartData(arrayList, new MinMax(fValueOf.floatValue() - 2.0f, f.floatValue() + 2.0f), FindRecentCommandHistoryHelper.getUnit(expandedControllerID));
        }
        return new SensorChartData(arrayList, UnitConverter.getControllerMinMaxValue(expandedControllerID), FindRecentCommandHistoryHelper.getUnit(expandedControllerID));
    }

    /* JADX INFO: renamed from: kr.switcher.switcherm.ui.irbrandgraph.interactor.helper.RecentHistoryDataParser$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$kr$switcher$switcherm$ui$irbrandgraph$interactor$FindRecentCommandHistoryInteractor$ExpandedControllerID;

        static {
            int[] iArr = new int[FindRecentCommandHistoryInteractor.ExpandedControllerID.values().length];
            $SwitchMap$kr$switcher$switcherm$ui$irbrandgraph$interactor$FindRecentCommandHistoryInteractor$ExpandedControllerID = iArr;
            try {
                iArr[FindRecentCommandHistoryInteractor.ExpandedControllerID.AIRCON.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$kr$switcher$switcherm$ui$irbrandgraph$interactor$FindRecentCommandHistoryInteractor$ExpandedControllerID[FindRecentCommandHistoryInteractor.ExpandedControllerID.TV.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$kr$switcher$switcherm$ui$irbrandgraph$interactor$FindRecentCommandHistoryInteractor$ExpandedControllerID[FindRecentCommandHistoryInteractor.ExpandedControllerID.SET_TOP_BOX.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$kr$switcher$switcherm$ui$irbrandgraph$interactor$FindRecentCommandHistoryInteractor$ExpandedControllerID[FindRecentCommandHistoryInteractor.ExpandedControllerID.SWITCHER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$kr$switcher$switcherm$ui$irbrandgraph$interactor$FindRecentCommandHistoryInteractor$ExpandedControllerID[FindRecentCommandHistoryInteractor.ExpandedControllerID.REMOCON.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$kr$switcher$switcherm$ui$irbrandgraph$interactor$FindRecentCommandHistoryInteractor$ExpandedControllerID[FindRecentCommandHistoryInteractor.ExpandedControllerID.UNKNOWN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x004f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.util.List<kr.switcher.switcherm.ui.irbrandgraph.adapter.CommandHistoryItem> parseCommandItems(kr.switcher.switcherm.network.http.response.SensorsForLastOneAPIResponse r8, kr.switcher.switcherm.ui.irbrandgraph.interactor.FindRecentCommandHistoryInteractor.ExpandedControllerID r9, kr.switcher.device.IODevice.ProductId r10) {
        /*
            r7 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            if (r8 == 0) goto L72
            java.util.List<kr.switcher.switcherm.network.http.response.SensorsForLastOneAPIResponse$CommandsForLastOne> r8 = r8.command_list
            int r1 = r8.size()
            r2 = 1
            int r1 = r1 - r2
        Lf:
            if (r1 < 0) goto L72
            java.lang.Object r3 = r8.get(r1)
            kr.switcher.switcherm.network.http.response.SensorsForLastOneAPIResponse$CommandsForLastOne r3 = (kr.switcher.switcherm.network.http.response.SensorsForLastOneAPIResponse.CommandsForLastOne) r3
            int[] r4 = kr.switcher.switcherm.ui.irbrandgraph.interactor.helper.RecentHistoryDataParser.AnonymousClass1.$SwitchMap$kr$switcher$switcherm$ui$irbrandgraph$interactor$FindRecentCommandHistoryInteractor$ExpandedControllerID
            int r5 = r9.ordinal()
            r4 = r4[r5]
            if (r4 == r2) goto L4f
            r5 = 2
            if (r4 == r5) goto L4f
            r5 = 3
            if (r4 == r5) goto L4f
            r5 = 4
            if (r4 == r5) goto L2e
            r5 = 5
            if (r4 == r5) goto L4f
            goto L6f
        L2e:
            java.lang.String r4 = r3.command_no
            java.lang.String r5 = "1"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L6f
            kr.switcher.switcherm.ui.irbrandgraph.adapter.CommandHistoryItem r4 = new kr.switcher.switcherm.ui.irbrandgraph.adapter.CommandHistoryItem
            int r5 = r3.value
            java.lang.String r6 = r3.name
            java.lang.String r5 = kr.switcher.switcherm.ui.irbrandgraph.interactor.helper.FindRecentCommandHistoryHelper.getNameOfValue(r10, r5, r6)
            java.lang.String r3 = r3.created_at
            java.lang.String r3 = kr.switcher.switcherm.ui.irbrandgraph.interactor.helper.FindRecentCommandHistoryHelper.getHourMinOfDate(r3)
            r4.<init>(r5, r3)
            r0.add(r4)
            goto L6f
        L4f:
            java.lang.String r4 = r3.command_no
            java.lang.String r5 = "4"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L6f
            kr.switcher.switcherm.ui.irbrandgraph.adapter.CommandHistoryItem r4 = new kr.switcher.switcherm.ui.irbrandgraph.adapter.CommandHistoryItem
            int r5 = r3.value
            java.lang.String r6 = r3.name
            java.lang.String r5 = kr.switcher.switcherm.ui.irbrandgraph.interactor.helper.FindRecentCommandHistoryHelper.getNameOfValue(r10, r5, r6)
            java.lang.String r3 = r3.created_at
            java.lang.String r3 = kr.switcher.switcherm.ui.irbrandgraph.interactor.helper.FindRecentCommandHistoryHelper.getHourMinOfDate(r3)
            r4.<init>(r5, r3)
            r0.add(r4)
        L6f:
            int r1 = r1 + (-1)
            goto Lf
        L72:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kr.switcher.switcherm.ui.irbrandgraph.interactor.helper.RecentHistoryDataParser.parseCommandItems(kr.switcher.switcherm.network.http.response.SensorsForLastOneAPIResponse, kr.switcher.switcherm.ui.irbrandgraph.interactor.FindRecentCommandHistoryInteractor$ExpandedControllerID, kr.switcher.device.IODevice$ProductId):java.util.List");
    }
}
