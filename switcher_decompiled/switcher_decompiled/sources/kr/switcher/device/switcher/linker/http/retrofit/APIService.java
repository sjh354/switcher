package kr.switcher.device.switcher.linker.http.retrofit;

import kr.switcher.device.switcher.linker.http.response.BatteryLevelAPIResponse;
import kr.switcher.device.switcher.linker.http.response.CommandResultAPIResponse;
import kr.switcher.device.switcher.linker.http.response.ControlAPIResponse;
import kr.switcher.device.switcher.linker.http.response.EmptyAPIResponse;
import kr.switcher.device.switcher.linker.http.response.FingerLengthReadAPIResponse;
import kr.switcher.device.switcher.linker.http.response.FingerLengthTestAPIResponse;
import kr.switcher.device.switcher.linker.http.response.FingerLengthWriteAPIResponse;
import kr.switcher.device.switcher.linker.http.response.ReservationReadAPIResponse;
import kr.switcher.device.switcher.linker.http.response.ReservationWriteAPIResponse;
import kr.switcher.device.switcher.linker.http.response.ThingAPIResponse;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

/* JADX INFO: loaded from: classes2.dex */
public interface APIService {
    @GET("commands/results/{command_id}/")
    Call<CommandResultAPIResponse> getCommandResult(@Header("Authorization") String str, @Path("command_id") String str2);

    @GET("devices/{macAddress}/")
    Call<ThingAPIResponse> getDeviceInfo(@Header("Authorization") String str, @Path("macAddress") String str2);

    @FormUrlEncoded
    @POST("commands/battery-level/")
    Call<BatteryLevelAPIResponse> postBatteryLevel(@Header("Authorization") String str, @Field("thing_mac_address") String str2);

    @FormUrlEncoded
    @POST("commands/control/switcher/")
    Call<ControlAPIResponse> postControl(@Header("Authorization") String str, @Field("thing_mac_address") String str2, @Field("value") int i);

    @FormUrlEncoded
    @POST("commands/finger-length/read/")
    Call<FingerLengthReadAPIResponse> postFingerLengthRead(@Header("Authorization") String str, @Field("thing_mac_address") String str2);

    @FormUrlEncoded
    @POST("commands/finger-length/test/")
    Call<FingerLengthTestAPIResponse> postFingerLengthTest(@Header("Authorization") String str, @Field("thing_mac_address") String str2, @Field("finger_length") int i);

    @FormUrlEncoded
    @POST("commands/finger-length/write/")
    Call<FingerLengthWriteAPIResponse> postFingerLengthWrite(@Header("Authorization") String str, @Field("thing_mac_address") String str2, @Field("finger_length") int i);

    @POST("devices/{mac_address}/temporary-mains/")
    Call<EmptyAPIResponse> postMainThing(@Header("Authorization") String str, @Path("mac_address") String str2);

    @FormUrlEncoded
    @POST("commands/reservation/delete/")
    Call<ReservationWriteAPIResponse> postReservationDelete(@Header("Authorization") String str, @Field("thing_mac_address") String str2, @Field("value") String str3);

    @FormUrlEncoded
    @POST("commands/reservation/read/")
    Call<ReservationReadAPIResponse> postReservationRead(@Header("Authorization") String str, @Field("thing_mac_address") String str2);

    @FormUrlEncoded
    @POST("commands/reservation/write/")
    Call<ReservationWriteAPIResponse> postReservationWrite(@Header("Authorization") String str, @Field("thing_mac_address") String str2, @Field("value") String str3);
}
