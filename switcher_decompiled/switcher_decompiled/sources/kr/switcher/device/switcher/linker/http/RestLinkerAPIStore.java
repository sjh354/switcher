package kr.switcher.device.switcher.linker.http;

import kr.switcher.device.common.DeviceUtil;
import kr.switcher.device.switcher.linker.http.microservice.MobileLinkerMicroService;
import kr.switcher.device.switcher.linker.http.response.BatteryLevelAPIResponse;
import kr.switcher.device.switcher.linker.http.response.CommandResultAPIResponse;
import kr.switcher.device.switcher.linker.http.response.ControlAPIResponse;
import kr.switcher.device.switcher.linker.http.response.EmptyAPIResponse;
import kr.switcher.device.switcher.linker.http.response.FingerLengthReadAPIResponse;
import kr.switcher.device.switcher.linker.http.response.FingerLengthTestAPIResponse;
import kr.switcher.device.switcher.linker.http.response.FingerLengthWriteAPIResponse;
import kr.switcher.device.switcher.linker.http.response.HttpResponseHandler;
import kr.switcher.device.switcher.linker.http.response.ReservationReadAPIResponse;
import kr.switcher.device.switcher.linker.http.response.ReservationWriteAPIResponse;
import kr.switcher.device.switcher.linker.http.response.ThingAPIResponse;
import kr.switcher.device.switcher.linker.http.retrofit.APIService;
import kr.switcher.device.switcher.linker.http.retrofit.HttpLogger;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/* JADX INFO: loaded from: classes2.dex */
public class RestLinkerAPIStore {
    private static final String ARG_DEVICE_MAC_ADDRESS = "mac_address";
    private static final String ARG_TYPE = "type";
    private static String BATTERY_LEVEL = "battery-level/";
    private static String COMMANDS = "commands/";
    private static String CUSTOMERS = "customers/";
    private static String DEVICES = "devices/";
    private static String GET_COMMAND_RESULT_API = "command/result/";
    private static String LINKERS = "linkers/";
    private static final String TAG = "RestLinkerAPIStore";
    private static APIService apiService = (APIService) new Retrofit.Builder().baseUrl(new MobileLinkerMicroService().getBaseUrl()).client(new HttpLogger().createOkHttpClient()).addConverterFactory(GsonConverterFactory.create()).build().create(APIService.class);

    public static void requestGetDevice(String str, HttpResponseHandler httpResponseHandler) {
        apiService.getDeviceInfo(MobileLinkerMicroService.ACCESS_TOKEN, DeviceUtil.makeBackendMacAddressFormat(str)).enqueue(new ThingAPIResponse().response(httpResponseHandler));
    }

    public static void requestPostCommand(String str, int i, HttpResponseHandler httpResponseHandler) {
        apiService.postControl(MobileLinkerMicroService.ACCESS_TOKEN, DeviceUtil.makeBackendMacAddressFormat(str), i).enqueue(new ControlAPIResponse().response(httpResponseHandler));
    }

    public static void requestPostBatteryLevel(String str, HttpResponseHandler httpResponseHandler) {
        apiService.postBatteryLevel(MobileLinkerMicroService.ACCESS_TOKEN, DeviceUtil.makeBackendMacAddressFormat(str)).enqueue(new BatteryLevelAPIResponse().response(httpResponseHandler));
    }

    public static void requestPostFingerLengthRead(String str, HttpResponseHandler httpResponseHandler) {
        apiService.postFingerLengthRead(MobileLinkerMicroService.ACCESS_TOKEN, DeviceUtil.makeBackendMacAddressFormat(str)).enqueue(new FingerLengthReadAPIResponse().response(httpResponseHandler));
    }

    public static void requestPostFingerLengthTest(String str, int i, HttpResponseHandler httpResponseHandler) {
        apiService.postFingerLengthTest(MobileLinkerMicroService.ACCESS_TOKEN, DeviceUtil.makeBackendMacAddressFormat(str), i).enqueue(new FingerLengthTestAPIResponse().response(httpResponseHandler));
    }

    public static void requestPostFingerLengthWrite(String str, int i, HttpResponseHandler httpResponseHandler) {
        apiService.postFingerLengthWrite(MobileLinkerMicroService.ACCESS_TOKEN, DeviceUtil.makeBackendMacAddressFormat(str), i).enqueue(new FingerLengthWriteAPIResponse().response(httpResponseHandler));
    }

    public static void requestGetCommandResult(String str, HttpResponseHandler httpResponseHandler) {
        apiService.getCommandResult(MobileLinkerMicroService.ACCESS_TOKEN, str).enqueue(new CommandResultAPIResponse().response(httpResponseHandler));
    }

    public static void requestPostReservationWrite(String str, String str2, HttpResponseHandler httpResponseHandler) {
        apiService.postReservationWrite(MobileLinkerMicroService.ACCESS_TOKEN, DeviceUtil.makeBackendMacAddressFormat(str), str2).enqueue(new ReservationWriteAPIResponse().response(httpResponseHandler));
    }

    public static void requestPostReservationDelete(String str, String str2, HttpResponseHandler httpResponseHandler) {
        apiService.postReservationDelete(MobileLinkerMicroService.ACCESS_TOKEN, DeviceUtil.makeBackendMacAddressFormat(str), str2).enqueue(new ReservationWriteAPIResponse().response(httpResponseHandler));
    }

    public static void requestPostReservationRead(String str, HttpResponseHandler httpResponseHandler) {
        apiService.postReservationRead(MobileLinkerMicroService.ACCESS_TOKEN, DeviceUtil.makeBackendMacAddressFormat(str)).enqueue(new ReservationReadAPIResponse().response(httpResponseHandler));
    }

    public static void requestPostMainThing(String str, HttpResponseHandler httpResponseHandler) {
        apiService.postMainThing(MobileLinkerMicroService.ACCESS_TOKEN, DeviceUtil.makeBackendMacAddressFormat(str)).enqueue(new EmptyAPIResponse().response(httpResponseHandler));
    }
}
