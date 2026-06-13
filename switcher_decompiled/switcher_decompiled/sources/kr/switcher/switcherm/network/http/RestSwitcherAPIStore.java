package kr.switcher.switcherm.network.http;

import android.os.Handler;
import android.util.ArrayMap;
import com.loopj.android.http.RequestParams;
import cz.msebera.android.httpclient.HttpStatus;
import java.util.List;
import kr.switcher.device.checker.Checker;
import kr.switcher.device.remocon.Remocon;
import kr.switcher.switcherm.common.util.IOLog;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.database.DBReservationDAO;
import kr.switcher.switcherm.database.DBUserDAO;
import kr.switcher.switcherm.domain.entity.UserDeviceInfo;
import kr.switcher.switcherm.network.http.data.ReservationData;
import kr.switcher.switcherm.network.http.microservice.AdminMicroService;
import kr.switcher.switcherm.network.http.microservice.CheckerMicroService;
import kr.switcher.switcherm.network.http.microservice.MobileMicroService;
import kr.switcher.switcherm.network.http.response.AccessTokensAPIResponse;
import kr.switcher.switcherm.network.http.response.AddressListMeAPIResponse;
import kr.switcher.switcherm.network.http.response.AddressMeAPIResponse;
import kr.switcher.switcherm.network.http.response.AppliancesAPIResponse;
import kr.switcher.switcherm.network.http.response.BrandsAPIResponse;
import kr.switcher.switcherm.network.http.response.CardCompaniesAPIResponse;
import kr.switcher.switcherm.network.http.response.CheckerHistoriesAPIResponse;
import kr.switcher.switcherm.network.http.response.ConsignmentAPIResponse;
import kr.switcher.switcherm.network.http.response.ContractAPIResponse;
import kr.switcher.switcherm.network.http.response.CreateApplianceMeAPIResponse;
import kr.switcher.switcherm.network.http.response.CreateAppliancesDatabasesAPIResponse;
import kr.switcher.switcherm.network.http.response.CreateDeviceMeAPIResponse;
import kr.switcher.switcherm.network.http.response.CreateIRDBConfirmAPIResponse;
import kr.switcher.switcherm.network.http.response.CreateIRDBRequestAPIResponse;
import kr.switcher.switcherm.network.http.response.CreateIRDBTestAPIResponse;
import kr.switcher.switcherm.network.http.response.CreateModifyIRInfoAPIResponse;
import kr.switcher.switcherm.network.http.response.CreditCardInfoAPIResponse;
import kr.switcher.switcherm.network.http.response.CreditCardSignalAPIResponse;
import kr.switcher.switcherm.network.http.response.CreditCardUpdateAPIResponse;
import kr.switcher.switcherm.network.http.response.CustomerMeAPIResponse;
import kr.switcher.switcherm.network.http.response.DeleteCheckersSurveillanceAPIResponse;
import kr.switcher.switcherm.network.http.response.DeleteDeviceMeAPIResponse;
import kr.switcher.switcherm.network.http.response.DeleteIRCommandAPIResponse;
import kr.switcher.switcherm.network.http.response.DeleteRemoconAPIResponse;
import kr.switcher.switcherm.network.http.response.DeleteRemoconMaintenanceAPIResponse;
import kr.switcher.switcherm.network.http.response.DeleteRemoconReservationAPIResponse;
import kr.switcher.switcherm.network.http.response.DeleteSubscriptionsMeAPIResponse;
import kr.switcher.switcherm.network.http.response.DeviceAPIResponse;
import kr.switcher.switcherm.network.http.response.DevicesMeAPIResponse;
import kr.switcher.switcherm.network.http.response.EmptyAPIResponse;
import kr.switcher.switcherm.network.http.response.FCMTokenRegisterationAPIResponse;
import kr.switcher.switcherm.network.http.response.FreeTrialAPIResponse;
import kr.switcher.switcherm.network.http.response.HttpResponseHandler;
import kr.switcher.switcherm.network.http.response.HttpResponseListHandler;
import kr.switcher.switcherm.network.http.response.IRAPIResponse;
import kr.switcher.switcherm.network.http.response.IRReleaseAPIResponse;
import kr.switcher.switcherm.network.http.response.ModifyRemoconMaintenanceAPIResponse;
import kr.switcher.switcherm.network.http.response.NewShareCodeAPIResponse;
import kr.switcher.switcherm.network.http.response.PostSubscriptionsMeAPIResponse;
import kr.switcher.switcherm.network.http.response.PostSurveillanceAPIResponse;
import kr.switcher.switcherm.network.http.response.PreparingAPIResponse;
import kr.switcher.switcherm.network.http.response.ProductReturnAPIResponse;
import kr.switcher.switcherm.network.http.response.RegisterAirconReservationResponse;
import kr.switcher.switcherm.network.http.response.RemoconMaintenanceAPIResponse;
import kr.switcher.switcherm.network.http.response.RemoconReservationAPIResponse;
import kr.switcher.switcherm.network.http.response.RemoteControllersAPIResponse;
import kr.switcher.switcherm.network.http.response.SensorsForLastOneAPIResponse;
import kr.switcher.switcherm.network.http.response.SensorsLatestAPIResponse;
import kr.switcher.switcherm.network.http.response.SignalFeatureAPIResponse;
import kr.switcher.switcherm.network.http.response.SignalMarketingAPIResponse;
import kr.switcher.switcherm.network.http.response.SubscriptionsMeAPIResponse;
import kr.switcher.switcherm.network.http.response.WalletsMeAPIResponse;
import kr.switcher.switcherm.network.http.retrofit.APIService;
import kr.switcher.switcherm.network.http.retrofit.HttpLogger;
import kr.switcher.switcherm.ui.setting.interactor.FindRecentCheckerHistoryInteractor;
import kr.switcher.switcherm.user.User;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import org.json.JSONObject;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/* JADX INFO: loaded from: classes2.dex */
public class RestSwitcherAPIStore {
    private static final String ARG_MAC_ADDRESS = "macAddress";
    private static final String ARG_MODEL_TYPE = "modelType";
    private static final String ARG_NAME = "name";
    private static final String ARG_PAY_PLAN = "payPlan";
    private static final String ARG_PHONE_NUMBER = "phoneNumber";
    private static final String ARG_PKEY = "pKey";
    private static final String ARG_REQUEST_ID = "requestId";
    private static final String ARG_RESERVATIONS = "reservations";
    private static final String ARG_SIGNAL_STATUS = "status";
    private static final String ARG_SIGNAL_TYPE = "type";
    private static final String TAG = "RestSwitcherAPIStore";
    private static APIService switcherAPIService = (APIService) new Retrofit.Builder().baseUrl(new MobileMicroService().getBaseUrl()).client(new HttpLogger().createOkHttpClient()).addConverterFactory(GsonConverterFactory.create()).build().create(APIService.class);
    private static APIService adminAPIService = (APIService) new Retrofit.Builder().baseUrl(new AdminMicroService().getBaseUrl()).client(new HttpLogger().createOkHttpClient()).addConverterFactory(GsonConverterFactory.create()).build().create(APIService.class);
    private static APIService checkerAPIService = (APIService) new Retrofit.Builder().baseUrl(new CheckerMicroService().getBaseUrl()).client(new HttpLogger().createOkHttpClient()).addConverterFactory(GsonConverterFactory.create()).build().create(APIService.class);
    public static String PRODUCTS_KEY = "products/";
    public static String PAY_PLAN = "payPlan/";
    public static String PRODUCT_KEY = "product/";
    public static String PROUDCT_FIRMWARE_LINK = PRODUCT_KEY + "firmwareLink/";
    public static String AUTH_LEGACY = "auth/legacy/";
    public static String POST_CODE = "io-inc.github.io/postcode/";
    public static String REQUEST = "requests/";
    public static String MODEL = "model/";
    public static String RESERVATION = "reservation";

    public static void requestPostDeviceLog(String str, String str2, UserDeviceInfo userDeviceInfo, String str3, String str4, RestResponseHandler restResponseHandler) {
    }

    public static void requestPostReservationLog(String str, List<ReservationData> list, RestResponseHandler restResponseHandler) {
    }

    public static void requestPostAuthNumber(User user, HttpResponseHandler httpResponseHandler) {
        switcherAPIService.postAccessToken(user.getPhoneNumber()).enqueue(new AccessTokensAPIResponse().response(httpResponseHandler));
    }

    public static void requestGetAuthInfo(String str, String str2, HttpResponseHandler httpResponseHandler) {
        switcherAPIService.getAccessToken(str, str2).enqueue(new AccessTokensAPIResponse().response(httpResponseHandler));
    }

    public static void requestGetCustomerMe(HttpResponseHandler httpResponseHandler) {
        switcherAPIService.getCustomersMe(MobileMicroService.ACCESS_TOKEN).enqueue(new CustomerMeAPIResponse().response(httpResponseHandler));
    }

    public static void requestGetAddressesMe(HttpResponseListHandler httpResponseListHandler) {
        switcherAPIService.getAddressesMe(MobileMicroService.ACCESS_TOKEN).enqueue(new AddressListMeAPIResponse().responseList(httpResponseListHandler));
    }

    public static void requestDevicesMe(HttpResponseListHandler httpResponseListHandler) {
        switcherAPIService.getDevicesMe(MobileMicroService.ACCESS_TOKEN).enqueue(new DevicesMeAPIResponse().responseList(httpResponseListHandler));
    }

    public static void requestGetAppliances(HttpResponseListHandler httpResponseListHandler) {
        switcherAPIService.getAppliances(MobileMicroService.ACCESS_TOKEN).enqueue(new AppliancesAPIResponse().responseList(httpResponseListHandler));
    }

    public static void requestGetIR(String str, HttpResponseListHandler httpResponseListHandler) {
        switcherAPIService.getIR(MobileMicroService.ACCESS_TOKEN, str).enqueue(new IRAPIResponse().responseList(httpResponseListHandler));
    }

    public static void requestGetDevice(String str, HttpResponseHandler httpResponseHandler) {
        switcherAPIService.getDeviceInfo(MobileMicroService.ACCESS_TOKEN, IOUtil.makeBackendMacAddressFormat(str)).enqueue(new DeviceAPIResponse().response(httpResponseHandler));
    }

    public static void requestGetWalletsMe(HttpResponseHandler httpResponseHandler) {
        switcherAPIService.getWalletsMe(MobileMicroService.ACCESS_TOKEN).enqueue(new WalletsMeAPIResponse().response(httpResponseHandler));
    }

    public static void requestGetPreparing(HttpResponseHandler httpResponseHandler) {
        switcherAPIService.getPreparing(MobileMicroService.ACCESS_TOKEN).enqueue(new PreparingAPIResponse().response(httpResponseHandler));
    }

    public static void requestGetCreditCardMe(HttpResponseListHandler httpResponseListHandler) {
        switcherAPIService.getCreditCardInfo(MobileMicroService.ACCESS_TOKEN).enqueue(new CreditCardInfoAPIResponse().responseList(httpResponseListHandler));
    }

    public static void requestGetSubscriptionsMe(HttpResponseListHandler httpResponseListHandler) {
        switcherAPIService.getSubscriptionsMe(MobileMicroService.ACCESS_TOKEN).enqueue(new SubscriptionsMeAPIResponse().responseList(httpResponseListHandler));
    }

    public static void requestDeleteSubscriptionsMe(int i, HttpResponseHandler httpResponseHandler) {
        switcherAPIService.deleteSubscriptionsMe(MobileMicroService.ACCESS_TOKEN, String.valueOf(i)).enqueue(new DeleteSubscriptionsMeAPIResponse().response(httpResponseHandler));
    }

    public static void requestPostSubscriptionsMe(String str, HttpResponseHandler httpResponseHandler) {
        switcherAPIService.postSubscriptionsMe(MobileMicroService.ACCESS_TOKEN, str).enqueue(new PostSubscriptionsMeAPIResponse().response(httpResponseHandler));
    }

    public static void requestGetCreditCardSignal(HttpResponseHandler httpResponseHandler) {
        switcherAPIService.getCreditCardSignal(MobileMicroService.ACCESS_TOKEN).enqueue(new CreditCardSignalAPIResponse().response(httpResponseHandler));
    }

    public static void requestPostAddressMe(String str, String str2, String str3, HttpResponseHandler httpResponseHandler) {
        switcherAPIService.postAddressMe(MobileMicroService.ACCESS_TOKEN, str, str2, str3).enqueue(new AddressMeAPIResponse().response(httpResponseHandler));
    }

    public static void requestPostProductReturn(String str, String str2, HttpResponseHandler httpResponseHandler) {
        switcherAPIService.postProductReturn(MobileMicroService.ACCESS_TOKEN, IOUtil.makeBackendMacAddressFormat(str), str2).enqueue(new ProductReturnAPIResponse().response(httpResponseHandler));
    }

    public static void requestPostReservationData(String str, String str2, Remocon.RemoconReservation remoconReservation, HttpResponseHandler httpResponseHandler) {
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put("week_time", remoconReservation.weekTime);
        arrayMap.put(DBReservationDAO.COLUMN_TITLE, remoconReservation.title);
        arrayMap.put("ir_id_list", remoconReservation.irIdList);
        arrayMap.put("is_enabled", remoconReservation.isEnabled);
        arrayMap.put("tag", remoconReservation.tag);
        switcherAPIService.postAirconReservation(MobileMicroService.ACCESS_TOKEN, IOUtil.makeBackendMacAddressFormat(str), str2, RequestBody.create(MediaType.parse("application/json; charset=utf-8"), new JSONObject(arrayMap).toString())).enqueue(new RegisterAirconReservationResponse().response(httpResponseHandler));
    }

    public static void requestPutCreditCard(final int i, final String str, final String str2, final String str3, final String str4, final HttpResponseHandler httpResponseHandler) {
        new Handler().postDelayed(new Runnable() { // from class: kr.switcher.switcherm.network.http.RestSwitcherAPIStore.1
            @Override // java.lang.Runnable
            public void run() {
                RestSwitcherAPIStore.switcherAPIService.putCreditCardInfo(MobileMicroService.ACCESS_TOKEN, i, "company_name", str).enqueue(new CreditCardUpdateAPIResponse().response(httpResponseHandler));
            }
        }, 0);
        new Handler().postDelayed(new Runnable() { // from class: kr.switcher.switcherm.network.http.RestSwitcherAPIStore.2
            @Override // java.lang.Runnable
            public void run() {
                RestSwitcherAPIStore.switcherAPIService.putCreditCardInfo(MobileMicroService.ACCESS_TOKEN, i, "card_number", str2).enqueue(new CreditCardUpdateAPIResponse().response(httpResponseHandler));
            }
        }, HttpStatus.SC_MULTIPLE_CHOICES);
        new Handler().postDelayed(new Runnable() { // from class: kr.switcher.switcherm.network.http.RestSwitcherAPIStore.3
            @Override // java.lang.Runnable
            public void run() {
                RestSwitcherAPIStore.switcherAPIService.putCreditCardInfo(MobileMicroService.ACCESS_TOKEN, i, "expiration_year", str4).enqueue(new CreditCardUpdateAPIResponse().response(httpResponseHandler));
            }
        }, 600);
        new Handler().postDelayed(new Runnable() { // from class: kr.switcher.switcherm.network.http.RestSwitcherAPIStore.4
            @Override // java.lang.Runnable
            public void run() {
                RestSwitcherAPIStore.switcherAPIService.putCreditCardInfo(MobileMicroService.ACCESS_TOKEN, i, "expiration_month", str3).enqueue(new CreditCardUpdateAPIResponse().response(httpResponseHandler));
            }
        }, 900);
    }

    public static void requestPutNewShareCode(String str, String str2, HttpResponseHandler httpResponseHandler) {
        switcherAPIService.putNewShareCode(MobileMicroService.ACCESS_TOKEN, IOUtil.makeBackendMacAddressFormat(str), str2).enqueue(new NewShareCodeAPIResponse().response(httpResponseHandler));
    }

    public static void requestGetShareCodeOwner(String str, HttpResponseHandler httpResponseHandler) {
        switcherAPIService.getShareCode(MobileMicroService.ACCESS_TOKEN, IOUtil.makeBackendMacAddressFormat(str)).enqueue(new EmptyAPIResponse().response(httpResponseHandler));
    }

    public static void requestPostGuestDevice(String str, String str2, HttpResponseHandler httpResponseHandler) {
        switcherAPIService.postDevicesYou(MobileMicroService.ACCESS_TOKEN, IOUtil.makeBackendMacAddressFormat(str), str2).enqueue(new EmptyAPIResponse().response(httpResponseHandler));
    }

    public static void requestGetFreeTrial(int i, HttpResponseHandler httpResponseHandler) {
        switcherAPIService.getFreeTrial(MobileMicroService.ACCESS_TOKEN, i).enqueue(new FreeTrialAPIResponse().response(httpResponseHandler));
    }

    public static void requestGetContract(int i, HttpResponseHandler httpResponseHandler) {
        switcherAPIService.getContract(MobileMicroService.ACCESS_TOKEN, i).enqueue(new ContractAPIResponse().response(httpResponseHandler));
    }

    public static void requestGetConsignment(int i, HttpResponseHandler httpResponseHandler) {
        switcherAPIService.getConsignment(MobileMicroService.ACCESS_TOKEN, i).enqueue(new ConsignmentAPIResponse().response(httpResponseHandler));
    }

    public static void requestGetCardCompanies(HttpResponseListHandler httpResponseListHandler) {
        switcherAPIService.getCardCompanies(MobileMicroService.ACCESS_TOKEN).enqueue(new CardCompaniesAPIResponse().responseList(httpResponseListHandler));
    }

    public static void requestPostRegisterSwitcher(String str, String str2, HttpResponseHandler httpResponseHandler) {
        switcherAPIService.postDevicesMe(MobileMicroService.ACCESS_TOKEN, IOUtil.makeBackendMacAddressFormat(str), str2).enqueue(new CreateDeviceMeAPIResponse().response(httpResponseHandler));
    }

    public static void requestDeleteDeviceMe(String str, HttpResponseHandler httpResponseHandler) {
        switcherAPIService.deleteDeviceMe(MobileMicroService.ACCESS_TOKEN, IOUtil.makeBackendMacAddressFormat(str)).enqueue(new DeleteDeviceMeAPIResponse().response(httpResponseHandler));
    }

    public static void requestDeleteReservation(String str, String str2, HttpResponseHandler httpResponseHandler) {
        switcherAPIService.deleteRemoconReservation(MobileMicroService.ACCESS_TOKEN, str, str2).enqueue(new DeleteRemoconReservationAPIResponse().response(httpResponseHandler));
    }

    public static void requestDeleteMaintenance(String str, HttpResponseHandler httpResponseHandler) {
        switcherAPIService.deleteRemoconMaintenance(MobileMicroService.ACCESS_TOKEN, str).enqueue(new DeleteRemoconMaintenanceAPIResponse().response(httpResponseHandler));
    }

    public static void requestPostMigration(String str, HttpResponseHandler httpResponseHandler) {
        adminAPIService.postMigration(DBUserDAO.COLUMN_PHONE_NUMBER, str).enqueue(new EmptyAPIResponse().response(httpResponseHandler));
    }

    public static void requestGetSignalBySwitcher(String str, HttpResponseHandler httpResponseHandler) {
        switcherAPIService.getSignalFeature(MobileMicroService.ACCESS_TOKEN, IOUtil.makeBackendMacAddressFormat(str)).enqueue(new SignalFeatureAPIResponse().response(httpResponseHandler));
    }

    public static void requestPutSignalForFeature(String str, int i, String str2, HttpResponseHandler httpResponseHandler) {
        switcherAPIService.putSignalFeature(MobileMicroService.ACCESS_TOKEN, IOUtil.makeBackendMacAddressFormat(str), i, str2).enqueue(new EmptyAPIResponse().response(httpResponseHandler));
    }

    public static void requestGetSignalForMarketing(HttpResponseHandler httpResponseHandler) {
        switcherAPIService.getSignalMarketing(MobileMicroService.ACCESS_TOKEN).enqueue(new SignalMarketingAPIResponse().response(httpResponseHandler));
    }

    public static void requestPutSignalForMarketing(int i, String str, HttpResponseHandler httpResponseHandler) {
        switcherAPIService.putSignalMarketing(MobileMicroService.ACCESS_TOKEN, i, str).enqueue(new EmptyAPIResponse().response(httpResponseHandler));
    }

    public static void requestPostApplianceMe(String str, HttpResponseHandler httpResponseHandler) {
        switcherAPIService.postAppliancesMe(MobileMicroService.ACCESS_TOKEN, str).enqueue(new CreateApplianceMeAPIResponse().response(httpResponseHandler));
    }

    public static void requestPostIRDBRequest(String str, HttpResponseHandler httpResponseHandler) {
        switcherAPIService.postIRDBRequest(MobileMicroService.ACCESS_TOKEN, str).enqueue(new CreateIRDBRequestAPIResponse().response(httpResponseHandler));
    }

    public static void requestPostIRDBTest(String str, HttpResponseHandler httpResponseHandler) {
        switcherAPIService.postIRDBTest(MobileMicroService.ACCESS_TOKEN, str).enqueue(new CreateIRDBTestAPIResponse().response(httpResponseHandler));
    }

    public static void putModifyIRInfo(String str, String str2, String str3, HttpResponseHandler httpResponseHandler) {
        switcherAPIService.putModifiyIRInfo(MobileMicroService.ACCESS_TOKEN, str, str2, str3).enqueue(new CreateModifyIRInfoAPIResponse().response(httpResponseHandler));
    }

    public static void requestPostIRDBConfirm(String str, HttpResponseHandler httpResponseHandler) {
        switcherAPIService.postIRDBConfirm(MobileMicroService.ACCESS_TOKEN, str).enqueue(new CreateIRDBConfirmAPIResponse().response(httpResponseHandler));
    }

    public static void requestDeleteIRCommand(String str, HttpResponseHandler httpResponseHandler) {
        switcherAPIService.deleteIRCommand(MobileMicroService.ACCESS_TOKEN, str).enqueue(new DeleteIRCommandAPIResponse().response(httpResponseHandler));
    }

    public static void requestPostRelease(String str, HttpResponseHandler httpResponseHandler) {
        switcherAPIService.postIRRelease(MobileMicroService.ACCESS_TOKEN, str).enqueue(new IRReleaseAPIResponse().response(httpResponseHandler));
    }

    public static void requestDeleteRemocon(String str, HttpResponseHandler httpResponseHandler) {
        switcherAPIService.deleteRemocon(MobileMicroService.ACCESS_TOKEN, str).enqueue(new DeleteRemoconAPIResponse().response(httpResponseHandler));
    }

    public static void requestGetRemoteControllers(HttpResponseHandler httpResponseHandler) {
        switcherAPIService.getRemoteControllers(MobileMicroService.ACCESS_TOKEN).enqueue(new RemoteControllersAPIResponse().response(httpResponseHandler));
    }

    public static void requestGetBrands(Remocon.ControllerID controllerID, HttpResponseListHandler httpResponseListHandler) {
        switcherAPIService.getBrands(MobileMicroService.ACCESS_TOKEN, String.valueOf(controllerID.getValue())).enqueue(new BrandsAPIResponse().responseList(httpResponseListHandler));
    }

    public static void requestGetRemoconReservation(String str, String str2, HttpResponseListHandler httpResponseListHandler) {
        switcherAPIService.getRemoconReservation(MobileMicroService.ACCESS_TOKEN, str, str2).enqueue(new RemoconReservationAPIResponse().responseList(httpResponseListHandler));
    }

    public static void requestGetRemoconMaintenance(String str, HttpResponseListHandler httpResponseListHandler) {
        switcherAPIService.getRemoconReservation(MobileMicroService.ACCESS_TOKEN, str).enqueue(new RemoconMaintenanceAPIResponse().responseList(httpResponseListHandler));
    }

    public static void requestPutRemoconMaintenance(Remocon.RemoconMaintenanceTemperature remoconMaintenanceTemperature, HttpResponseHandler httpResponseHandler) {
        switcherAPIService.putAppliancesMaintenance(String.valueOf(remoconMaintenanceTemperature.id), String.valueOf(remoconMaintenanceTemperature.appliances), String.valueOf(remoconMaintenanceTemperature.is_enabled), String.valueOf(remoconMaintenanceTemperature.goal_temperature), remoconMaintenanceTemperature.weekdays, remoconMaintenanceTemperature.start_time_at, remoconMaintenanceTemperature.end_time_at).enqueue(new ModifyRemoconMaintenanceAPIResponse().response(httpResponseHandler));
    }

    public static void requestPostRemoconMaintenance(String str, Remocon.RemoconMaintenanceTemperature remoconMaintenanceTemperature, HttpResponseHandler httpResponseHandler) {
        switcherAPIService.postAppliancesMaintenance(MobileMicroService.ACCESS_TOKEN, str, remoconMaintenanceTemperature.title, String.valueOf(remoconMaintenanceTemperature.is_enabled), String.valueOf(remoconMaintenanceTemperature.goal_temperature), remoconMaintenanceTemperature.weekdays, remoconMaintenanceTemperature.start_time_at, remoconMaintenanceTemperature.end_time_at).enqueue(new ModifyRemoconMaintenanceAPIResponse().response(httpResponseHandler));
    }

    public static void requestPostAppliancesDatabases(String str, Remocon.ControllerID controllerID, String str2, HttpResponseHandler httpResponseHandler) {
        switcherAPIService.postAppliancesDatabases(MobileMicroService.ACCESS_TOKEN, str, String.valueOf(controllerID.getValue()), str2).enqueue(new CreateAppliancesDatabasesAPIResponse().response(httpResponseHandler));
    }

    public static void requestGetSensorsForLastOneHour(String str, HttpResponseHandler httpResponseHandler) {
        switcherAPIService.getSensorsForLastOne(MobileMicroService.ACCESS_TOKEN, IOUtil.makeBackendMacAddressFormat(str)).enqueue(new SensorsForLastOneAPIResponse().response(httpResponseHandler));
    }

    public static void requestGetSensorsForLastOneDay(String str, HttpResponseHandler httpResponseHandler) {
        switcherAPIService.getSensorsForLastOneDay(MobileMicroService.ACCESS_TOKEN, IOUtil.makeBackendMacAddressFormat(str)).enqueue(new SensorsForLastOneAPIResponse().response(httpResponseHandler));
    }

    public static void requestGetSensorsLatest(String str, HttpResponseHandler httpResponseHandler) {
        switcherAPIService.getSensorsLatest(MobileMicroService.ACCESS_TOKEN, IOUtil.makeBackendMacAddressFormat(str)).enqueue(new SensorsLatestAPIResponse().response(httpResponseHandler));
    }

    public static void requestGetHistory(String str, int i, HttpResponseHandler httpResponseHandler) {
        switcherAPIService.getCheckerHistories(MobileMicroService.ACCESS_TOKEN, IOUtil.makeBackendMacAddressFormat(str), i).enqueue(new CheckerHistoriesAPIResponse().response(httpResponseHandler));
    }

    public static void requestGetNextPageHistory(FindRecentCheckerHistoryInteractor.CheckerURLinfo checkerURLinfo, HttpResponseHandler httpResponseHandler) {
        checkerAPIService.getNextPageCheckerHistories(MobileMicroService.ACCESS_TOKEN, checkerURLinfo.getMacAddress(), checkerURLinfo.getDays(), checkerURLinfo.getPage()).enqueue(new CheckerHistoriesAPIResponse().response(httpResponseHandler));
    }

    public static void requestPostCheckerSurveillance(String str, Checker.Surveillance surveillance, HttpResponseHandler httpResponseHandler) {
        switcherAPIService.postCheckersSurveillance(MobileMicroService.ACCESS_TOKEN, str, String.valueOf(surveillance.isActive), String.valueOf(surveillance.level), String.valueOf(surveillance.trespass_duration_min), String.valueOf(surveillance.alarm_duration_min), surveillance.weekDays, surveillance.startAt, surveillance.endAt, surveillance.title).enqueue(new PostSurveillanceAPIResponse().response(httpResponseHandler));
    }

    public static void requestGetCheckersSurveillance(String str, HttpResponseListHandler httpResponseListHandler) {
        switcherAPIService.getCheckersSurveillance(MobileMicroService.ACCESS_TOKEN, str).enqueue(new PostSurveillanceAPIResponse().responseList(httpResponseListHandler));
    }

    public static void requestPutCheckersSurveillance(String str, Checker.Surveillance surveillance, HttpResponseHandler httpResponseHandler) {
        switcherAPIService.putCheckersSurveillance(MobileMicroService.ACCESS_TOKEN, str, String.valueOf(surveillance.id), String.valueOf(surveillance.isActive), String.valueOf(surveillance.level), surveillance.weekDays, surveillance.startAt, surveillance.endAt, surveillance.title).enqueue(new ModifyRemoconMaintenanceAPIResponse().response(httpResponseHandler));
    }

    public static void requestDeleteCheckersSurveillance(String str, String str2, HttpResponseHandler httpResponseHandler) {
        switcherAPIService.deleteCheckersSurveillance(MobileMicroService.ACCESS_TOKEN, str, str2).enqueue(new DeleteCheckersSurveillanceAPIResponse().response(httpResponseHandler));
    }

    public static void requestPostFCMMobileDevices(String str, HttpResponseHandler httpResponseHandler) {
        switcherAPIService.postFCMMobileDevices(MobileMicroService.ACCESS_TOKEN, str).enqueue(new FCMTokenRegisterationAPIResponse().response(httpResponseHandler));
    }

    public static void requestPostPaymentPlan(String str, String str2, RestResponseHandler restResponseHandler) {
        String str3 = TAG;
        IOLog.d(str3, "requestPostPaymentPlan()");
        if (!IOUtil.isConnectedInternet()) {
            IOLog.d(str3, "is not connected to the internet");
            return;
        }
        RequestParams requestParams = new RequestParams();
        requestParams.put(ARG_PAY_PLAN, str2);
        RestSwitcher.post(PRODUCT_KEY + PAY_PLAN + str, requestParams, restResponseHandler);
    }

    public static void requestGetFirmwareLink(RestResponseHandler restResponseHandler) {
        String str = TAG;
        IOLog.d(str, "requestGetFirmwareLink()");
        if (!IOUtil.isConnectedInternet()) {
            IOLog.d(str, "is not connected to the internet");
        } else {
            RestSwitcher.get(PROUDCT_FIRMWARE_LINK, null, restResponseHandler);
        }
    }

    public static void requestPostAuthLegacy(String str, RestResponseHandler restResponseHandler) {
        String str2 = TAG;
        IOLog.d(str2, "requestPostAuthLegacy()");
        if (!IOUtil.isConnectedInternet()) {
            IOLog.d(str2, "is not connected to the internet");
            return;
        }
        RequestParams requestParams = new RequestParams();
        requestParams.put(ARG_PHONE_NUMBER, str);
        RestSwitcher.post(AUTH_LEGACY, requestParams, restResponseHandler);
    }

    public static String getPostCodeURL() {
        return "https://" + POST_CODE;
    }

    public static void requestGetRequestDetail(int i, RestResponseHandler restResponseHandler) {
        String str = TAG;
        IOLog.d(str, "requestGetRequestDetail()");
        if (!IOUtil.isConnectedInternet()) {
            IOLog.d(str, "is not connected to the internet");
        } else {
            RestSwitcher.get(REQUEST + i, null, restResponseHandler);
        }
    }

    public static void requestPutModelType(int i, int i2, RestResponseHandler restResponseHandler) {
        String str = TAG;
        IOLog.d(str, "requestPutModelType()");
        if (!IOUtil.isConnectedInternet()) {
            IOLog.d(str, "is not connected to the internet");
            return;
        }
        RequestParams requestParams = new RequestParams();
        requestParams.put(ARG_REQUEST_ID, i);
        requestParams.put(ARG_MODEL_TYPE, i2);
        RestSwitcher.put(REQUEST + MODEL, requestParams, restResponseHandler);
    }
}
