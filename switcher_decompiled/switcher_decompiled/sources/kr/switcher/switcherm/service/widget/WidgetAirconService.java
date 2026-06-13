package kr.switcher.switcherm.service.widget;

import java.util.List;
import kr.switcher.device.IODevice;
import kr.switcher.device.remocon.IRCommand;
import kr.switcher.device.remocon.Remocon;
import kr.switcher.switcherm.common.IOConfig;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.device.IODeviceHandler;
import kr.switcher.switcherm.device.IODeviceMapper;
import kr.switcher.switcherm.network.http.RestSwitcherAPIStore;
import kr.switcher.switcherm.network.http.response.HttpAPIResponse;
import kr.switcher.switcherm.network.http.response.HttpResponseHandler;
import kr.switcher.switcherm.network.http.response.HttpResponseListHandler;
import kr.switcher.switcherm.preference.WidgetPreference;
import kr.switcher.switcherm.ui.widget.interactor.GetCurrentSensorValueForWidgetInteractor;

/* JADX INFO: loaded from: classes2.dex */
public class WidgetAirconService {
    private static final String TAG = "WidgetAirconService";
    private int airconCommand;
    private IODevice ioDevice;
    private List<IRCommand> irCommandList;
    private String AIRCON_ON_COMMAND = "ON";
    private String AIRCON_OFF_COMMAND = IOConfig.OFF;
    private String AIRCON_FIRST_TEMPERATURE_COMMAND = "19";
    private String AIRCON_SECOND_TEMPERATURE_COMMAND = "21";
    private String AIRCON_THIRD_TEMPERATURE_COMMAND = "23";
    private String AIRCON_FOURTH_TEMPERATURE_COMMAND = "25";
    private String AIRCON_FIFTH_TEMPERATURE_COMMAND = "26";
    private String irId = "";

    public WidgetAirconService(IODevice iODevice, int i) {
        this.ioDevice = iODevice;
        this.airconCommand = i;
    }

    public void setLinker(IODevice iODevice) {
        this.ioDevice = iODevice;
    }

    public void releaseIR() {
        RestSwitcherAPIStore.requestGetIR(((Remocon) IODeviceHandler.getInstance().getDevice(this.ioDevice.getMacAddress())).getId(), new HttpResponseListHandler() { // from class: kr.switcher.switcherm.service.widget.WidgetAirconService.1
            @Override // kr.switcher.switcherm.network.http.response.HttpResponseListHandler
            public void onSuccess(List list) {
                WidgetAirconService.this.irCommandList = IODeviceMapper.parseGetIR(list);
                WidgetAirconService widgetAirconService = WidgetAirconService.this;
                widgetAirconService.matchCommand(widgetAirconService.irCommandList);
                WidgetAirconService.this.releaseIRData();
            }

            @Override // kr.switcher.switcherm.network.http.response.HttpResponseListHandler
            public void onFailure(String str, String str2) {
                IOUtil.showToast("링커의 연결이 끊겨있습니다. 링커의 전원을 확인해 주세요.");
                new WidgetPreference().setWidgetAliveLinker("");
                IOUtil.sendBroadcastToAirconWidget();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void matchCommand(List<IRCommand> list) {
        switch (this.airconCommand) {
            case 0:
                this.irId = findIrId(this.AIRCON_ON_COMMAND);
                break;
            case 1:
                this.irId = findIrId(this.AIRCON_OFF_COMMAND);
                break;
            case 2:
                this.irId = findIrId(this.AIRCON_FIRST_TEMPERATURE_COMMAND);
                break;
            case 3:
                this.irId = findIrId(this.AIRCON_SECOND_TEMPERATURE_COMMAND);
                break;
            case 4:
                this.irId = findIrId(this.AIRCON_THIRD_TEMPERATURE_COMMAND);
                break;
            case 5:
                this.irId = findIrId(this.AIRCON_FOURTH_TEMPERATURE_COMMAND);
                break;
            case 6:
                this.irId = findIrId(this.AIRCON_FIFTH_TEMPERATURE_COMMAND);
                break;
        }
    }

    private String findIrId(String str) {
        for (IRCommand iRCommand : this.irCommandList) {
            if (iRCommand.getName().equals(str)) {
                return iRCommand.getId();
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void releaseIRData() {
        String str = this.irId;
        if (str != null) {
            RestSwitcherAPIStore.requestPostRelease(str, new HttpResponseHandler() { // from class: kr.switcher.switcherm.service.widget.WidgetAirconService.2
                @Override // kr.switcher.switcherm.network.http.response.HttpResponseHandler
                public void onFailure(String str2, String str3) {
                }

                @Override // kr.switcher.switcherm.network.http.response.HttpResponseHandler
                public void onSuccess(HttpAPIResponse httpAPIResponse) {
                    String name = "";
                    for (IRCommand iRCommand : WidgetAirconService.this.irCommandList) {
                        if (iRCommand.getId() == WidgetAirconService.this.irId) {
                            name = iRCommand.getName();
                        }
                    }
                    if (!name.equals("ON") && !name.equals(IOConfig.OFF)) {
                        name = name + "도";
                    }
                    IOUtil.showToast(name + " 명령어를 전송하였습니다.");
                }
            });
        } else {
            IOUtil.showToast("명령어를 받아오지 못했습니다.");
        }
    }

    public void refreshWidget() {
        new GetCurrentSensorValueForWidgetInteractor().getAliveLinker(new GetCurrentSensorValueForWidgetInteractor.OnGetAliveLinkerListener() { // from class: kr.switcher.switcherm.service.widget.WidgetAirconService.3
            @Override // kr.switcher.switcherm.ui.widget.interactor.GetCurrentSensorValueForWidgetInteractor.OnGetAliveLinkerListener
            public void onError() {
            }

            @Override // kr.switcher.switcherm.ui.widget.interactor.GetCurrentSensorValueForWidgetInteractor.OnGetAliveLinkerListener
            public void onFindAliveLinker(String str) {
                new WidgetPreference().setWidgetAliveLinker(str);
                IOUtil.sendBroadcastToAirconWidget();
            }
        });
    }

    public void getTemperature(String str, final int i) {
        new GetCurrentSensorValueForWidgetInteractor().getCurrentSensorValueListener(str, new GetCurrentSensorValueForWidgetInteractor.OnGetCurrentSensorValueListener() { // from class: kr.switcher.switcherm.service.widget.WidgetAirconService.4
            @Override // kr.switcher.switcherm.ui.widget.interactor.GetCurrentSensorValueForWidgetInteractor.OnGetCurrentSensorValueListener
            public void onFind(String str2) {
                new WidgetPreference().setWidgetLinkerTemperature(i, str2.substring(0, str2.indexOf(46) + 2));
            }
        });
    }
}
