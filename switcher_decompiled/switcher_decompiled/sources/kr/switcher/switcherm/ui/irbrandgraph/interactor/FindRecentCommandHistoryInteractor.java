package kr.switcher.switcherm.ui.irbrandgraph.interactor;

import java.util.ArrayList;
import java.util.List;
import kr.switcher.device.IODevice;
import kr.switcher.device.linker.Linker;
import kr.switcher.device.remocon.Remocon;
import kr.switcher.device.switcher.linker.SwitcherLinker;
import kr.switcher.switcherm.common.util.IOLog;
import kr.switcher.switcherm.network.http.RestSwitcherAPIStore;
import kr.switcher.switcherm.network.http.response.HttpAPIResponse;
import kr.switcher.switcherm.network.http.response.HttpResponseHandler;
import kr.switcher.switcherm.network.http.response.SensorsForLastOneAPIResponse;
import kr.switcher.switcherm.preference.OAuthToken;
import kr.switcher.switcherm.ui.irbrandgraph.adapter.CommandHistoryItem;
import kr.switcher.switcherm.ui.irbrandgraph.interactor.helper.RecentHistoryDataParser;
import kr.switcher.switcherm.ui.irbrandgraph.interactor.helper.SensorChartData;

/* JADX INFO: loaded from: classes2.dex */
public class FindRecentCommandHistoryInteractor {
    private static final String TAG = "FindRecentCommandHistoryInteractor";
    private ExpandedControllerID controllerId;
    private IODevice ioDevice;
    private Linker linker;
    private final String TITLE_NAME_TEMPPERATURE = "온도";
    private final String TITLE_NAME_SOUND = "소리 크기";
    private final String TITLE_NAME_ILLUMINATION_INTENSITY = "밝기";
    private RecentHistoryDataParser parser = new RecentHistoryDataParser();

    public enum ExpandedControllerID {
        AIRCON,
        TV,
        SET_TOP_BOX,
        SWITCHER,
        REMOCON,
        UNKNOWN
    }

    public interface OnFindRecentCommandHistoryListener {
        void onFindCommands(List<CommandHistoryItem> list);

        void onFindSensors(SensorChartData sensorChartData);
    }

    public interface OnFindTitleListener {
        void onFindTitle(String str);
    }

    public FindRecentCommandHistoryInteractor(Linker linker, IODevice iODevice, OnFindTitleListener onFindTitleListener) {
        this.linker = linker;
        this.ioDevice = iODevice;
        onFindTitleListener.onFindTitle(getTitleAndSetExpandedControllerID(iODevice));
    }

    public void findRecentSensorHistory(final OnFindRecentCommandHistoryListener onFindRecentCommandHistoryListener) {
        RestSwitcherAPIStore.requestGetSensorsForLastOneHour(this.linker.getMacAddress(), new HttpResponseHandler() { // from class: kr.switcher.switcherm.ui.irbrandgraph.interactor.FindRecentCommandHistoryInteractor.1
            @Override // kr.switcher.switcherm.network.http.response.HttpResponseHandler
            public void onSuccess(HttpAPIResponse httpAPIResponse) {
                onFindRecentCommandHistoryListener.onFindSensors(FindRecentCommandHistoryInteractor.this.parser.parseSensorItems((SensorsForLastOneAPIResponse) httpAPIResponse, FindRecentCommandHistoryInteractor.this.controllerId));
            }

            @Override // kr.switcher.switcherm.network.http.response.HttpResponseHandler
            public void onFailure(String str, String str2) {
                IOLog.error(FindRecentCommandHistoryInteractor.TAG, new OAuthToken().getOAuthToken(), "findRecentSensorHistory", new Exception("code:" + str + ", message:" + str2));
            }
        });
    }

    public void findRecentCommandHistory(final OnFindRecentCommandHistoryListener onFindRecentCommandHistoryListener) {
        RestSwitcherAPIStore.requestGetSensorsForLastOneHour(this.ioDevice.getClass() == SwitcherLinker.class ? this.ioDevice.getMacAddress() : this.linker.getMacAddress(), new HttpResponseHandler() { // from class: kr.switcher.switcherm.ui.irbrandgraph.interactor.FindRecentCommandHistoryInteractor.2
            @Override // kr.switcher.switcherm.network.http.response.HttpResponseHandler
            public void onSuccess(HttpAPIResponse httpAPIResponse) {
                onFindRecentCommandHistoryListener.onFindCommands(FindRecentCommandHistoryInteractor.this.parser.parseCommandItems((SensorsForLastOneAPIResponse) httpAPIResponse, FindRecentCommandHistoryInteractor.this.controllerId, FindRecentCommandHistoryInteractor.this.ioDevice.getProductId()));
            }

            @Override // kr.switcher.switcherm.network.http.response.HttpResponseHandler
            public void onFailure(String str, String str2) {
                onFindRecentCommandHistoryListener.onFindCommands(new ArrayList());
                IOLog.error(FindRecentCommandHistoryInteractor.TAG, new OAuthToken().getOAuthToken(), "findRecentCommandHistory", new Exception("code:" + str + ", message:" + str2));
            }
        });
    }

    public void findPastOneDaySensorHistory(final OnFindRecentCommandHistoryListener onFindRecentCommandHistoryListener) {
        RestSwitcherAPIStore.requestGetSensorsForLastOneDay(this.linker.getMacAddress(), new HttpResponseHandler() { // from class: kr.switcher.switcherm.ui.irbrandgraph.interactor.FindRecentCommandHistoryInteractor.3
            @Override // kr.switcher.switcherm.network.http.response.HttpResponseHandler
            public void onSuccess(HttpAPIResponse httpAPIResponse) {
                onFindRecentCommandHistoryListener.onFindSensors(FindRecentCommandHistoryInteractor.this.parser.parseSensorItems((SensorsForLastOneAPIResponse) httpAPIResponse, FindRecentCommandHistoryInteractor.this.controllerId));
            }

            @Override // kr.switcher.switcherm.network.http.response.HttpResponseHandler
            public void onFailure(String str, String str2) {
                IOLog.error(FindRecentCommandHistoryInteractor.TAG, new OAuthToken().getOAuthToken(), "findRecentSensorHistory", new Exception("code:" + str + ", message:" + str2));
            }
        });
    }

    public void findPastOneDayCommandHistory(final OnFindRecentCommandHistoryListener onFindRecentCommandHistoryListener) {
        RestSwitcherAPIStore.requestGetSensorsForLastOneDay(this.ioDevice.getClass() == SwitcherLinker.class ? this.ioDevice.getMacAddress() : this.linker.getMacAddress(), new HttpResponseHandler() { // from class: kr.switcher.switcherm.ui.irbrandgraph.interactor.FindRecentCommandHistoryInteractor.4
            @Override // kr.switcher.switcherm.network.http.response.HttpResponseHandler
            public void onSuccess(HttpAPIResponse httpAPIResponse) {
                onFindRecentCommandHistoryListener.onFindCommands(FindRecentCommandHistoryInteractor.this.parser.parseCommandItems((SensorsForLastOneAPIResponse) httpAPIResponse, FindRecentCommandHistoryInteractor.this.controllerId, FindRecentCommandHistoryInteractor.this.ioDevice.getProductId()));
            }

            @Override // kr.switcher.switcherm.network.http.response.HttpResponseHandler
            public void onFailure(String str, String str2) {
                onFindRecentCommandHistoryListener.onFindCommands(new ArrayList());
                IOLog.error(FindRecentCommandHistoryInteractor.TAG, new OAuthToken().getOAuthToken(), "findRecentCommandHistory", new Exception("code:" + str + ", message:" + str2));
            }
        });
    }

    private String getTitleAndSetExpandedControllerID(IODevice iODevice) {
        if (iODevice.getClass().equals(Remocon.class)) {
            int i = AnonymousClass5.$SwitchMap$kr$switcher$device$remocon$Remocon$ControllerID[((Remocon) iODevice).getControllerId().ordinal()];
            if (i == 1) {
                this.controllerId = ExpandedControllerID.AIRCON;
                return "온도";
            }
            if (i == 2) {
                this.controllerId = ExpandedControllerID.TV;
            } else {
                if (i != 3) {
                    if (i == 4) {
                        this.controllerId = ExpandedControllerID.REMOCON;
                        return "";
                    }
                    this.controllerId = ExpandedControllerID.UNKNOWN;
                    return "";
                }
                this.controllerId = ExpandedControllerID.SET_TOP_BOX;
            }
            return "소리 크기";
        }
        if (!iODevice.getClass().equals(SwitcherLinker.class)) {
            return "";
        }
        IODevice.ProductId productId = iODevice.getProductId();
        if (!productId.equals(IODevice.ProductId.SWITCHER_TYPE_ONE) && !productId.equals(IODevice.ProductId.SWITCHER_TYPE_TWO)) {
            return "";
        }
        this.controllerId = ExpandedControllerID.SWITCHER;
        return "밝기";
    }

    /* JADX INFO: renamed from: kr.switcher.switcherm.ui.irbrandgraph.interactor.FindRecentCommandHistoryInteractor$5, reason: invalid class name */
    static /* synthetic */ class AnonymousClass5 {
        static final /* synthetic */ int[] $SwitchMap$kr$switcher$device$remocon$Remocon$ControllerID;

        static {
            int[] iArr = new int[Remocon.ControllerID.values().length];
            $SwitchMap$kr$switcher$device$remocon$Remocon$ControllerID = iArr;
            try {
                iArr[Remocon.ControllerID.AIRCON.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$kr$switcher$device$remocon$Remocon$ControllerID[Remocon.ControllerID.TV.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$kr$switcher$device$remocon$Remocon$ControllerID[Remocon.ControllerID.SET_TOP_BOX.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$kr$switcher$device$remocon$Remocon$ControllerID[Remocon.ControllerID.REMOCON.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }
}
