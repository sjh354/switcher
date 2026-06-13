package kr.switcher.switcherm.common.fcm;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import kr.switcher.switcherm.common.notification.NotificationUtil;
import kr.switcher.switcherm.common.util.IOLog;
import kr.switcher.switcherm.network.http.RestSwitcherAPIStore;
import kr.switcher.switcherm.network.http.microservice.MobileMicroService;
import kr.switcher.switcherm.network.http.response.HttpAPIResponse;
import kr.switcher.switcherm.network.http.response.HttpResponseHandler;
import kr.switcher.switcherm.preference.FCMPreference;

/* JADX INFO: loaded from: classes2.dex */
public class FirebaseInstanceIDService extends FirebaseMessagingService {
    private static final String TAG = "FirebaseInstanceIDService";

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public void onNewToken(String str) {
        super.onNewToken(str);
        if (MobileMicroService.ACCESS_TOKEN.equals("")) {
            return;
        }
        RestSwitcherAPIStore.requestPostFCMMobileDevices(str, new HttpResponseHandler() { // from class: kr.switcher.switcherm.common.fcm.FirebaseInstanceIDService.1
            @Override // kr.switcher.switcherm.network.http.response.HttpResponseHandler
            public void onSuccess(HttpAPIResponse httpAPIResponse) {
                IOLog.i(FirebaseInstanceIDService.TAG, "Updating token to server was success");
            }

            @Override // kr.switcher.switcherm.network.http.response.HttpResponseHandler
            public void onFailure(String str2, String str3) {
                IOLog.i(FirebaseInstanceIDService.TAG, "Updating token to server was failed");
            }
        });
        IOLog.i(TAG, "newToken was published : " + str);
        new FCMPreference().setFCMPreference(str);
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public void onMessageReceived(RemoteMessage remoteMessage) {
        if (remoteMessage != null) {
            NotificationUtil.sendNotification(getApplicationContext(), remoteMessage);
        }
    }
}
