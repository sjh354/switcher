package kr.switcher.switcherm.network.http.retrofit;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.HTTP;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/* JADX INFO: loaded from: classes2.dex */
public interface APIServiceForLegacy {
    @FormUrlEncoded
    @Headers({"Accept: application/json"})
    @HTTP(hasBody = true, method = "DELETE", path = "products/purchase")
    Call<ResponseBodyForLegacy> deleteRegister(@Header("Authorization") String str, @Field("macAddress") String str2);

    @FormUrlEncoded
    @POST("products/device")
    Call<ResponseBodyForLegacy> postDeviceInfo(@Header("Authorization") String str, @Field("macAddress") String str2, @Field("phoneNumber") String str3, @Field("phoneModel") String str4, @Field("os") String str5, @Field("disk") String str6, @Field("ram") String str7, @Field("type") String str8, @Field("errorCode") String str9);
}
