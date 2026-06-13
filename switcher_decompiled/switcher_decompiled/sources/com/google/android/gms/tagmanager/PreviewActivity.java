package com.google.android.gms.tagmanager;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public class PreviewActivity extends Activity {
    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        try {
            super.onCreate(bundle);
            zzdg.zzb.zzb("Preview activity");
            Uri data = getIntent().getData();
            if (data == null) {
                Log.e("GoogleTagManager", "data is null in PreviewActivity.onCreate");
                return;
            }
            if (!TagManager.getInstance(this).zzd(data)) {
                String str = "Cannot preview the app with the uri: " + data.toString() + ". Launching current version instead.";
                Log.w("GoogleTagManager", str);
                AlertDialog alertDialogCreate = new AlertDialog.Builder(this).create();
                alertDialogCreate.setTitle("Preview failure");
                alertDialogCreate.setMessage(str);
                alertDialogCreate.setButton(-1, "Continue", new zzdy(this));
                alertDialogCreate.show();
            }
            Intent launchIntentForPackage = getPackageManager().getLaunchIntentForPackage(getPackageName());
            if (launchIntentForPackage == null) {
                zzdg.zzb.zzb("No launch activity found for package name: " + getPackageName());
                return;
            }
            zzdg.zzb.zzb("Invoke the launch activity for package name: " + getPackageName());
            startActivity(launchIntentForPackage);
        } catch (Exception e) {
            Log.e("GoogleTagManager", "Calling preview threw an exception: ".concat(String.valueOf(e.getMessage())));
        }
    }
}
