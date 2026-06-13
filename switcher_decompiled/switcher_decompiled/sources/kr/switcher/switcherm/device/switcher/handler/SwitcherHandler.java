package kr.switcher.switcherm.device.switcher.handler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kr.switcher.device.IODevice;
import kr.switcher.device.switcher.Switcher;
import kr.switcher.device.switcher.ble.SwitcherBLE;
import kr.switcher.device.switcher.interfaces.IODeviceCallbacks;
import kr.switcher.device.switcher.linker.SwitcherLinker;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.util.IOLog;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.device.IODeviceHandler;
import kr.switcher.switcherm.device.IODeviceJsonParser;
import kr.switcher.switcherm.network.http.RestErrorCode;
import kr.switcher.switcherm.network.http.RestResponseHandler;
import kr.switcher.switcherm.network.http.RestSwitcherAPIStore;
import kr.switcher.switcherm.network.http.response.DeviceAPIResponse;
import kr.switcher.switcherm.network.http.response.HttpAPIResponse;
import kr.switcher.switcherm.network.http.response.HttpResponseHandler;
import kr.switcher.switcherm.network.http.response.HttpResponseListHandler;
import kr.switcher.switcherm.network.http.response.ProductReturnAPIResponse;
import kr.switcher.switcherm.preference.OAuthToken;
import kr.switcher.switcherm.preference.SwitcherVersion;
import kr.switcher.switcherm.ui.switcherInfo.adapter.PaymentCardItem;
import kr.switcher.switcherm.ui.switcherInfo.helper.SwitcherInfoJsonParser;

/* JADX INFO: loaded from: classes2.dex */
public class SwitcherHandler {
    private static final String TAG = "SwitcherHandler";
    private static volatile SwitcherHandler instance;
    private HashMap<String, IODevice> ioDeviceMap;
    private SwitcherDBProvider dbProvider = new SwitcherDBProvider();
    private SwitcherCreator creator = new SwitcherCreator();

    public SwitcherHandler(HashMap<String, IODevice> map) {
        this.ioDeviceMap = map;
    }

    public static SwitcherHandler getInstance() {
        if (instance == null) {
            synchronized (SwitcherHandler.class) {
            }
        }
        return instance;
    }

    public void create(IODevice iODevice, boolean z, IODeviceHandler.OnCreateIODeviceListener onCreateIODeviceListener) {
        this.creator.create(iODevice, z, onCreateIODeviceListener);
    }

    public List<Switcher> getSwitcherAll() {
        ArrayList arrayList = new ArrayList();
        for (String str : this.ioDeviceMap.keySet()) {
            if (isSwitcherClass(this.ioDeviceMap.get(str))) {
                arrayList.add((Switcher) this.ioDeviceMap.get(str));
            }
        }
        return arrayList;
    }

    public List<Switcher> getMySwitcherAll() {
        ArrayList arrayList = new ArrayList();
        for (String str : this.ioDeviceMap.keySet()) {
            IODevice iODevice = this.ioDeviceMap.get(str);
            if (isSwitcherClass(iODevice) && !iODevice.isMine()) {
                arrayList.add((Switcher) this.ioDeviceMap.get(str));
            }
        }
        return arrayList;
    }

    private boolean isSwitcherClass(IODevice iODevice) {
        return iODevice.getClass().equals(SwitcherBLE.class) || iODevice.getClass().equals(SwitcherLinker.class);
    }

    public void update(Switcher switcher) {
        if (this.ioDeviceMap.containsKey(switcher.getMacAddress())) {
            IODeviceHandler.getInstance().addDevice(switcher);
        }
    }

    public Switcher getSwitcher(String str) {
        try {
            IODevice device = IODeviceHandler.getInstance().getDevice(str);
            if (device == null) {
                Switcher switcherInfoFromDB = this.dbProvider.getSwitcherInfoFromDB(str);
                this.ioDeviceMap.put(switcherInfoFromDB.getMacAddress(), switcherInfoFromDB);
                return switcherInfoFromDB;
            }
            return (Switcher) device;
        } catch (Exception unused) {
            return null;
        }
    }

    public List<Switcher> getConnectedSwitcherList() {
        ArrayList arrayList = new ArrayList();
        for (Switcher switcher : getSwitcherAll()) {
            if (switcher.getConnectionState().equals(Switcher.ConnectionState.CONNECTED)) {
                arrayList.add(switcher);
            }
        }
        return arrayList;
    }

    public void disconnectAll() {
        Iterator<String> it = SwitcherUtil.getConnectedDeviceAddress().iterator();
        while (it.hasNext()) {
            Switcher switcher = getSwitcher(it.next());
            if (switcher != null) {
                IOLog.i(TAG, "disconnect switcher (mac address:" + switcher.getMacAddress() + ")");
                switcher.disconnect();
            }
        }
        Iterator<Switcher> it2 = getConnectedSwitcherList().iterator();
        while (it2.hasNext()) {
            it2.next().disconnect();
        }
        IOUtil.sendBroadcastToOneButtonWidget();
        IOUtil.sendBroadcastToTwoButtonWidget();
    }

    public void getCreditCardMeFromRestServer(final String str, final IODeviceCallbacks.UpdateCreditCardMeResultResponseCallback updateCreditCardMeResultResponseCallback) {
        RestSwitcherAPIStore.requestGetCreditCardMe(new HttpResponseListHandler() { // from class: kr.switcher.switcherm.device.switcher.handler.SwitcherHandler.1
            @Override // kr.switcher.switcherm.network.http.response.HttpResponseListHandler
            public void onSuccess(List list) {
                try {
                    PaymentCardItem getMainPaymentCard = SwitcherInfoJsonParser.parseGetMainPaymentCard(list);
                    if (getMainPaymentCard == null) {
                        throw new Exception();
                    }
                    IODeviceHandler.getInstance().getDevice(str).getOption().setPaymentCardInfo(getMainPaymentCard.getCardId(), getMainPaymentCard.getPaymentCardName(), getMainPaymentCard.getCardNumber(), getMainPaymentCard.getExpireDate());
                    updateCreditCardMeResultResponseCallback.onUpdateCreditCardMeResult(true);
                } catch (Exception e) {
                    IOLog.error(SwitcherHandler.TAG, new OAuthToken().getOAuthToken(), "getCreditCardMeFromRestServer - onSuccess", e);
                    updateCreditCardMeResultResponseCallback.onUpdateCreditCardMeResult(false);
                }
            }

            @Override // kr.switcher.switcherm.network.http.response.HttpResponseListHandler
            public void onFailure(String str2, String str3) {
                IOLog.error(SwitcherHandler.TAG, new OAuthToken().getOAuthToken(), "requestGetCreditCardMe", new Exception("code:" + str2 + ", message:" + str3));
                updateCreditCardMeResultResponseCallback.onUpdateCreditCardMeResult(false);
            }
        });
    }

    public void changePayPlanToRestServer(String str, int i, final IODeviceCallbacks.OnChangePaymentPlanInfoResultCallback onChangePaymentPlanInfoResultCallback) {
        RestSwitcherAPIStore.requestPostPaymentPlan(str, String.valueOf(i), new RestResponseHandler() { // from class: kr.switcher.switcherm.device.switcher.handler.SwitcherHandler.2
            @Override // kr.switcher.switcherm.network.http.RestResponseHandler
            public void onSuccess(String str2) {
                onChangePaymentPlanInfoResultCallback.onPaymentPlanResult(true);
            }

            @Override // kr.switcher.switcherm.network.http.RestResponseHandler
            public void onFailure(String str2, String str3) {
                onChangePaymentPlanInfoResultCallback.onPaymentPlanResult(false);
            }
        });
    }

    public void getCardCompaniesFromRestServer(final IODeviceCallbacks.OnGetCardCompaniesCallback onGetCardCompaniesCallback) {
        RestSwitcherAPIStore.requestGetCardCompanies(new HttpResponseListHandler() { // from class: kr.switcher.switcherm.device.switcher.handler.SwitcherHandler.3
            @Override // kr.switcher.switcherm.network.http.response.HttpResponseListHandler
            public void onSuccess(List list) {
                try {
                    onGetCardCompaniesCallback.onCardCompaniesResult(SwitcherInfoJsonParser.parseGetCardCompanies(list));
                } catch (Exception e) {
                    IOLog.error(SwitcherHandler.TAG, new OAuthToken().getOAuthToken(), "getCardCompaniesFromRestServer - requestGetCardCompanies - onSuccess", e);
                }
            }

            @Override // kr.switcher.switcherm.network.http.response.HttpResponseListHandler
            public void onFailure(String str, String str2) {
                IOLog.error(SwitcherHandler.TAG, new OAuthToken().getOAuthToken(), "requestGetCardCompanies", new Exception("code:" + str + ", message:" + str2));
                ArrayList arrayList = new ArrayList();
                arrayList.add("우리카드");
                arrayList.add("현대");
                arrayList.add("국민");
                onGetCardCompaniesCallback.onCardCompaniesResult(arrayList);
            }
        });
    }

    public void setCreditCardToRestServer(int i, String str, String str2, String str3, String str4, final IODeviceCallbacks.OnSetCreditCardCallback onSetCreditCardCallback) {
        RestSwitcherAPIStore.requestPutCreditCard(i, str, str2, str3, str4, new HttpResponseHandler() { // from class: kr.switcher.switcherm.device.switcher.handler.SwitcherHandler.4
            @Override // kr.switcher.switcherm.network.http.response.HttpResponseHandler
            public void onSuccess(HttpAPIResponse httpAPIResponse) {
                IOUtil.showToast(IOUtil.getStringResource(R.string.changed_card_info_message));
                onSetCreditCardCallback.onCreditCardResult(true);
            }

            @Override // kr.switcher.switcherm.network.http.response.HttpResponseHandler
            public void onFailure(String str5, String str6) {
                IOLog.error(SwitcherHandler.TAG, new OAuthToken().getOAuthToken(), "requestPutCreditCardMe", new Exception("code:" + str5 + ", message:" + str6));
                onSetCreditCardCallback.onCreditCardResult(false);
            }
        });
    }

    public int returnSwitcher(final String str, String str2, String str3, String str4, final String str5, final IODeviceCallbacks.ReturnResultResponseCallback returnResultResponseCallback) {
        IOLog.i(TAG, "macaddress:" + str + ", address:" + str2 + " " + str3 + " " + str4 + ", refund date:" + str5);
        RestSwitcherAPIStore.requestPostAddressMe(str2, str3, str4, new HttpResponseHandler() { // from class: kr.switcher.switcherm.device.switcher.handler.SwitcherHandler.5
            @Override // kr.switcher.switcherm.network.http.response.HttpResponseHandler
            public void onSuccess(HttpAPIResponse httpAPIResponse) {
                SwitcherHandler.this.requestPostProductReturn(str, str5, returnResultResponseCallback);
            }

            @Override // kr.switcher.switcherm.network.http.response.HttpResponseHandler
            public void onFailure(String str6, String str7) {
                IOLog.error(SwitcherHandler.TAG, new OAuthToken().getOAuthToken(), "requestPostAddressMe", new Exception("code:" + str6 + ", message:" + str7));
                if (str6.equals(RestErrorCode.DUPLICATED_ADDRESS)) {
                    SwitcherHandler.this.requestPostProductReturn(str, str5, returnResultResponseCallback);
                }
            }
        });
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestPostProductReturn(String str, String str2, final IODeviceCallbacks.ReturnResultResponseCallback returnResultResponseCallback) {
        RestSwitcherAPIStore.requestPostProductReturn(str, str2, new HttpResponseHandler() { // from class: kr.switcher.switcherm.device.switcher.handler.SwitcherHandler.6
            @Override // kr.switcher.switcherm.network.http.response.HttpResponseHandler
            public void onSuccess(HttpAPIResponse httpAPIResponse) {
                IOLog.i(SwitcherHandler.TAG, "response get return json : " + httpAPIResponse);
                try {
                    returnResultResponseCallback.onReturnResult(IODeviceJsonParser.parseReturnInvoiceResult((ProductReturnAPIResponse) httpAPIResponse));
                } catch (Exception e) {
                    IOLog.error(SwitcherHandler.TAG, new OAuthToken().getOAuthToken(), "returnSwitcher - requestPostProductReturn - onSuccess", e);
                    returnResultResponseCallback.onReturnResult(null);
                }
            }

            @Override // kr.switcher.switcherm.network.http.response.HttpResponseHandler
            public void onFailure(String str3, String str4) {
                IOLog.error(SwitcherHandler.TAG, new OAuthToken().getOAuthToken(), "requestPostProductReturn", new Exception("code:" + str3 + ", message:" + str4));
                returnResultResponseCallback.onReturnResult(null);
            }
        });
    }

    public void getLastVersion(final IODeviceCallbacks.FirmwareVersionResultCallback firmwareVersionResultCallback) {
        RestSwitcherAPIStore.requestGetFirmwareLink(new RestResponseHandler() { // from class: kr.switcher.switcherm.device.switcher.handler.SwitcherHandler.7
            @Override // kr.switcher.switcherm.network.http.RestResponseHandler
            public void onSuccess(String str) {
                IOLog.i(SwitcherHandler.TAG, str);
                try {
                    ArrayList<String> firmwareInfoResult = IODeviceJsonParser.parseFirmwareInfoResult(str);
                    new SwitcherVersion().setLastVersion(firmwareInfoResult.get(0));
                    new SwitcherVersion().setLink(firmwareInfoResult.get(1));
                    firmwareVersionResultCallback.onFirmwareVersion(firmwareInfoResult.get(0));
                } catch (Exception e) {
                    IOLog.error(SwitcherHandler.TAG, new OAuthToken().getOAuthToken(), "getLastVersion", e);
                    firmwareVersionResultCallback.onFirmwareVersion(null);
                }
            }

            @Override // kr.switcher.switcherm.network.http.RestResponseHandler
            public void onFailure(String str, String str2) {
                IOLog.error(SwitcherHandler.TAG, new OAuthToken().getOAuthToken(), "requestGetFirmwareLink", new Exception("code:" + str + ", message:" + str2));
                firmwareVersionResultCallback.onFirmwareVersion(null);
            }
        });
    }

    public int getAllSwitcherReservationSize() {
        int size = 0;
        for (Switcher switcher : getMySwitcherAll()) {
            if (switcher.sResrvs != null) {
                size += switcher.sResrvs.size();
            }
        }
        return size;
    }

    public int getBatteryFromDB(String str) {
        return this.dbProvider.getLastBattery(str);
    }

    public void setBatteryToDB(String str, int i) {
        this.dbProvider.setLastBattery(str, i);
    }

    public static final class Builder {
        public SwitcherHandler build(HashMap<String, IODevice> map) {
            SwitcherHandler unused = SwitcherHandler.instance = new SwitcherHandler(map);
            return SwitcherHandler.instance;
        }
    }

    class SwitcherCreator {
        SwitcherCreator() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void create(final IODevice iODevice, final boolean z, final IODeviceHandler.OnCreateIODeviceListener onCreateIODeviceListener) {
            RestSwitcherAPIStore.requestGetDevice(iODevice.getMacAddress(), new HttpResponseHandler() { // from class: kr.switcher.switcherm.device.switcher.handler.SwitcherHandler.SwitcherCreator.1
                @Override // kr.switcher.switcherm.network.http.response.HttpResponseHandler
                public void onSuccess(HttpAPIResponse httpAPIResponse) {
                    Switcher switcher = (Switcher) IODeviceJsonParser.parseGetDevice((DeviceAPIResponse) httpAPIResponse, iODevice.getMacAddress());
                    switcher.setName(SwitcherHandler.this.dbProvider.getSwitcherName(switcher));
                    if (!z) {
                        switcher.beGuest();
                        switcher.setShareCode(iODevice.getShareCode());
                    }
                    SwitcherHandler.this.dbProvider.setSwitcherInfoToDB(switcher);
                    IODeviceHandler.OnCreateIODeviceListener onCreateIODeviceListener2 = onCreateIODeviceListener;
                    if (onCreateIODeviceListener2 != null) {
                        onCreateIODeviceListener2.onSuccess(switcher);
                    }
                }

                @Override // kr.switcher.switcherm.network.http.response.HttpResponseHandler
                public void onFailure(String str, String str2) {
                    IODeviceHandler.OnCreateIODeviceListener onCreateIODeviceListener2 = onCreateIODeviceListener;
                    if (onCreateIODeviceListener2 != null) {
                        onCreateIODeviceListener2.onFailure(str, str2);
                    }
                    IOLog.error(SwitcherHandler.TAG, new OAuthToken().getOAuthToken(), "requestGetDevice()", new Exception("code:" + str + ", message:" + str2));
                }
            });
        }
    }
}
