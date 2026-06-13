package no.nordicsemi.android.log;

import android.content.Context;
import android.net.Uri;

/* JADX INFO: loaded from: classes2.dex */
public interface ILogSession {
    Context getContext();

    Uri getSessionContentUri();

    Uri getSessionEntriesUri();

    Uri getSessionUri();
}
