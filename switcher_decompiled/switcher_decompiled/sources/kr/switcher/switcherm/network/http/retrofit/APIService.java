package kr.switcher.switcherm.network.http.retrofit;

import java.util.List;
import kr.switcher.switcherm.common.ga.GALogger;
import kr.switcher.switcherm.database.DBReservationDAO;
import kr.switcher.switcherm.database.DBUserDAO;
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
import kr.switcher.switcherm.network.http.response.HashingKeyAPIResponse;
import kr.switcher.switcherm.network.http.response.IRAPIResponse;
import kr.switcher.switcherm.network.http.response.IRReleaseAPIResponse;
import kr.switcher.switcherm.network.http.response.ModifyRemoconMaintenanceAPIResponse;
import kr.switcher.switcherm.network.http.response.NewShareCodeAPIResponse;
import kr.switcher.switcherm.network.http.response.PostSubscriptionsMeAPIResponse;
import kr.switcher.switcherm.network.http.response.PostSurveillanceAPIResponse;
import kr.switcher.switcherm.network.http.response.PreparingAPIResponse;
import kr.switcher.switcherm.network.http.response.PricingModelAPIResponse;
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
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

/* JADX INFO: loaded from: classes2.dex */
public interface APIService {
    @DELETE("checkers/{mac_address}/surveillance/{surveillance_id}/")
    Call<DeleteCheckersSurveillanceAPIResponse> deleteCheckersSurveillance(@Header("Authorization") String str, @Path("mac_address") String str2, @Path("surveillance_id") String str3);

    @DELETE("devices/me/{mac_address}/")
    Call<DeleteDeviceMeAPIResponse> deleteDeviceMe(@Header("Authorization") String str, @Path("mac_address") String str2);

    @DELETE("ir/{ir_id}/")
    Call<DeleteIRCommandAPIResponse> deleteIRCommand(@Header("Authorization") String str, @Path("ir_id") String str2);

    @DELETE("appliances/{appliance_id}/")
    Call<DeleteRemoconAPIResponse> deleteRemocon(@Header("Authorization") String str, @Path("appliance_id") String str2);

    @DELETE("appliances/maintenance/{maintenance_id}/")
    Call<DeleteRemoconMaintenanceAPIResponse> deleteRemoconMaintenance(@Header("Authorization") String str, @Path("maintenance_id") String str2);

    @DELETE("ir/reservations/{mac_address}/week-time/{week_time}/")
    Call<DeleteRemoconReservationAPIResponse> deleteRemoconReservation(@Header("Authorization") String str, @Path("mac_address") String str2, @Path("week_time") String str3);

    @DELETE("customers/fcm/subscriptions/{subscription_id}/")
    Call<DeleteSubscriptionsMeAPIResponse> deleteSubscriptionsMe(@Header("Authorization") String str, @Path("subscription_id") String str2);

    @GET("access-tokens/{access_token_id}/")
    Call<AccessTokensAPIResponse> getAccessToken(@Path("access_token_id") String str, @Query("authentication_number") String str2);

    @GET("addresses/me/")
    Call<List<AddressListMeAPIResponse>> getAddressesMe(@Header("Authorization") String str);

    @GET("appliances/me/")
    Call<List<AppliancesAPIResponse>> getAppliances(@Header("Authorization") String str);

    @GET("remote-controllers/{remote_controller_id}/brands/")
    Call<List<BrandsAPIResponse>> getBrands(@Header("Authorization") String str, @Path("remote_controller_id") String str2);

    @GET("credit-cards/companies/")
    Call<List<CardCompaniesAPIResponse>> getCardCompanies(@Header("Authorization") String str);

    @GET("checkers/{mac_address}/transitions/days/{days}/")
    Call<CheckerHistoriesAPIResponse> getCheckerHistories(@Header("Authorization") String str, @Path("mac_address") String str2, @Path("days") int i);

    @GET("checkers/{mac_address}/surveillance/")
    Call<List<PostSurveillanceAPIResponse>> getCheckersSurveillance(@Header("Authorization") String str, @Path("mac_address") String str2);

    @GET("consignments/{consignment_id}/")
    Call<ConsignmentAPIResponse> getConsignment(@Header("Authorization") String str, @Path("consignment_id") int i);

    @GET("contracts/{contract_id}/")
    Call<ContractAPIResponse> getContract(@Header("Authorization") String str, @Path("contract_id") int i);

    @GET("credit-cards/me/")
    Call<List<CreditCardInfoAPIResponse>> getCreditCardInfo(@Header("Authorization") String str);

    @GET("credit-cards/me/signals/")
    Call<CreditCardSignalAPIResponse> getCreditCardSignal(@Header("Authorization") String str);

    @GET("customers/me/")
    Call<CustomerMeAPIResponse> getCustomersMe(@Header("Authorization") String str);

    @GET("devices/{macAddress}/")
    Call<DeviceAPIResponse> getDeviceInfo(@Header("Authorization") String str, @Path("macAddress") String str2);

    @GET("devices/me/")
    Call<List<DevicesMeAPIResponse>> getDevicesMe(@Header("Authorization") String str);

    @GET("free-trials/{free_trial_id}/")
    Call<FreeTrialAPIResponse> getFreeTrial(@Header("Authorization") String str, @Path("free_trial_id") int i);

    @GET("products/hashingKey/{macAddress}/{shareCode}")
    Call<HashingKeyAPIResponse> getHashingKey(@Header("Authorization") String str, @Path("macAddress") String str2, @Path("shareCode") String str3);

    @GET("appliances/{applianceId}/ir/")
    Call<List<IRAPIResponse>> getIR(@Header("Authorization") String str, @Path("applianceId") String str2);

    @GET("checkers/mac-address/{mac-address}/transitions/days/{days}/")
    Call<CheckerHistoriesAPIResponse> getNextPageCheckerHistories(@Header("Authorization") String str, @Path("mac-address") String str2, @Path("days") String str3, @Query("page") String str4);

    @GET("free-trials/preparing/")
    Call<PreparingAPIResponse> getPreparing(@Header("Authorization") String str);

    @GET("pricingModels/")
    Call<PricingModelAPIResponse> getPricingModel(@Header("Authorization") String str);

    @GET("appliances/{appliance_id}/maintenance/")
    Call<List<RemoconMaintenanceAPIResponse>> getRemoconReservation(@Header("Authorization") String str, @Path("appliance_id") String str2);

    @GET("ir/reservations/{mac_address}/appliances/{appliance_id}/")
    Call<List<RemoconReservationAPIResponse>> getRemoconReservation(@Header("Authorization") String str, @Path("mac_address") String str2, @Path("appliance_id") String str3);

    @GET("remote-controllers/")
    Call<RemoteControllersAPIResponse> getRemoteControllers(@Header("Authorization") String str);

    @GET("devices/{mac_address}/sensors/last/one/hour/")
    Call<SensorsForLastOneAPIResponse> getSensorsForLastOne(@Header("Authorization") String str, @Path("mac_address") String str2);

    @GET("devices/{mac_address}/sensors/last/one/day/")
    Call<SensorsForLastOneAPIResponse> getSensorsForLastOneDay(@Header("Authorization") String str, @Path("mac_address") String str2);

    @GET("devices/{mac_address}/sensors/latest/")
    Call<SensorsLatestAPIResponse> getSensorsLatest(@Header("Authorization") String str, @Path("mac_address") String str2);

    @GET("devices/{mac_address}/access-token/")
    Call<EmptyAPIResponse> getShareCode(@Header("Authorization") String str, @Path("mac_address") String str2);

    @GET("devices/{mac_address}/signal/")
    Call<SignalFeatureAPIResponse> getSignalFeature(@Header("Authorization") String str, @Path("mac_address") String str2);

    @GET("notices/me/")
    Call<SignalMarketingAPIResponse> getSignalMarketing(@Header("Authorization") String str);

    @GET("customers/fcm/subscriptions/me/")
    Call<List<SubscriptionsMeAPIResponse>> getSubscriptionsMe(@Header("Authorization") String str);

    @GET("cash/wallets/me/")
    Call<WalletsMeAPIResponse> getWalletsMe(@Header("Authorization") String str);

    @FormUrlEncoded
    @POST("access-tokens/")
    Call<AccessTokensAPIResponse> postAccessToken(@Field(DBUserDAO.COLUMN_PHONE_NUMBER) String str);

    @FormUrlEncoded
    @POST("addresses/")
    Call<AddressMeAPIResponse> postAddressMe(@Header("Authorization") String str, @Field("main_address") String str2, @Field("sub_address") String str3, @Field("postal_code") String str4);

    @POST("ir/reservations/{mac_address}/appliances/{appliance_id}/")
    Call<RegisterAirconReservationResponse> postAirconReservation(@Header("Authorization") String str, @Path("mac_address") String str2, @Path("appliance_id") String str3, @Body RequestBody requestBody);

    @FormUrlEncoded
    @POST("appliances/{appliance_id}/databases/")
    Call<CreateAppliancesDatabasesAPIResponse> postAppliancesDatabases(@Header("Authorization") String str, @Path("appliance_id") String str2, @Field("remote_controller_id") String str3, @Field("brand_id") String str4);

    @FormUrlEncoded
    @POST("appliances/{appliance_id}/maintenance/")
    Call<ModifyRemoconMaintenanceAPIResponse> postAppliancesMaintenance(@Header("Authorization") String str, @Path("appliance_id") String str2, @Field(DBReservationDAO.COLUMN_TITLE) String str3, @Field("is_enabled") String str4, @Field("goal_temperature") String str5, @Field("week_days") String str6, @Field("start_time_at") String str7, @Field("end_time_at") String str8);

    @FormUrlEncoded
    @POST("appliances/me/")
    Call<CreateApplianceMeAPIResponse> postAppliancesMe(@Header("Authorization") String str, @Field("name") String str2);

    @FormUrlEncoded
    @POST("checkers/{mac_address}/surveillance/")
    Call<PostSurveillanceAPIResponse> postCheckersSurveillance(@Header("Authorization") String str, @Path("mac_address") String str2, @Field("is_active") String str3, @Field("level") String str4, @Field("trespass_duration_min") String str5, @Field("alarm_duration_min") String str6, @Field("week_days") String str7, @Field("start_at") String str8, @Field("end_at") String str9, @Field(DBReservationDAO.COLUMN_TITLE) String str10);

    @FormUrlEncoded
    @POST("devices/me/")
    Call<CreateDeviceMeAPIResponse> postDevicesMe(@Header("Authorization") String str, @Field("mac_address") String str2, @Field("name") String str3);

    @FormUrlEncoded
    @POST("devices/you/")
    Call<EmptyAPIResponse> postDevicesYou(@Header("Authorization") String str, @Field("mac_address") String str2, @Field("access_token") String str3);

    @FormUrlEncoded
    @POST("customers/fcm/mobile-devices/")
    Call<FCMTokenRegisterationAPIResponse> postFCMMobileDevices(@Header("Authorization") String str, @Field("registration_id") String str2);

    @FormUrlEncoded
    @POST("commands/ir/db/confirm/")
    Call<CreateIRDBConfirmAPIResponse> postIRDBConfirm(@Header("Authorization") String str, @Field("ir_id") String str2);

    @FormUrlEncoded
    @POST("commands/ir/db/request/")
    Call<CreateIRDBRequestAPIResponse> postIRDBRequest(@Header("Authorization") String str, @Field("name") String str2);

    @FormUrlEncoded
    @POST("commands/ir/db/test/")
    Call<CreateIRDBTestAPIResponse> postIRDBTest(@Header("Authorization") String str, @Field("ir_id") String str2);

    @FormUrlEncoded
    @POST("commands/ir/release/")
    Call<IRReleaseAPIResponse> postIRRelease(@Header("Authorization") String str, @Field("ir_id") String str2);

    @FormUrlEncoded
    @POST("migrations/customers/")
    Call<EmptyAPIResponse> postMigration(@Field("key") String str, @Field("value") String str2);

    @FormUrlEncoded
    @POST("devices/{mac_address}/return/")
    Call<ProductReturnAPIResponse> postProductReturn(@Header("Authorization") String str, @Path("mac_address") String str2, @Field("deadline") String str3);

    @FormUrlEncoded
    @POST("customers/fcm/subscriptions/")
    Call<PostSubscriptionsMeAPIResponse> postSubscriptionsMe(@Header("Authorization") String str, @Field("sub_type") String str2);

    @FormUrlEncoded
    @PUT("appliances/maintenance/{maintenance_id}/")
    Call<ModifyRemoconMaintenanceAPIResponse> putAppliancesMaintenance(@Path("maintenance_id") String str, @Field("appliance") String str2, @Field("is_enabled") String str3, @Field("goal_temperature") String str4, @Field("week_days") String str5, @Field("start_time_at") String str6, @Field("end_time_at") String str7);

    @FormUrlEncoded
    @PUT("checkers/{mac_address}/surveillance/{surveillance_id}/")
    Call<ModifyRemoconMaintenanceAPIResponse> putCheckersSurveillance(@Header("Authorization") String str, @Path("mac_address") String str2, @Path("surveillance_id") String str3, @Field("is_active") String str4, @Field("level") String str5, @Field("week_days") String str6, @Field("start_at") String str7, @Field("end_at") String str8, @Field(DBReservationDAO.COLUMN_TITLE) String str9);

    @FormUrlEncoded
    @PUT("credit-cards/{credit_card_id}/")
    Call<CreditCardUpdateAPIResponse> putCreditCardInfo(@Header("Authorization") String str, @Path("credit_card_id") int i, @Field("key") String str2, @Field("value") String str3);

    @FormUrlEncoded
    @PUT("ir/{ir_id}/")
    Call<CreateModifyIRInfoAPIResponse> putModifiyIRInfo(@Header("Authorization") String str, @Path("ir_id") String str2, @Field("key") String str3, @Field("value") String str4);

    @FormUrlEncoded
    @PUT("devices/{mac_address}/access-token/")
    Call<NewShareCodeAPIResponse> putNewShareCode(@Header("Authorization") String str, @Path("mac_address") String str2, @Field("access_token") String str3);

    @FormUrlEncoded
    @PUT("devices/{mac_address}/signal/")
    Call<EmptyAPIResponse> putSignalFeature(@Header("Authorization") String str, @Path("mac_address") String str2, @Field("instance_id") int i, @Field(GALogger.CATEGORY_ACTION) String str3);

    @FormUrlEncoded
    @PUT("notices/me/")
    Call<EmptyAPIResponse> putSignalMarketing(@Header("Authorization") String str, @Field("instance_id") int i, @Field(GALogger.CATEGORY_ACTION) String str2);
}
