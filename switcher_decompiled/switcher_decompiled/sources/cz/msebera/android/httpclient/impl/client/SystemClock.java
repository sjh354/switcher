package cz.msebera.android.httpclient.impl.client;

/* JADX INFO: loaded from: classes2.dex */
class SystemClock implements Clock {
    SystemClock() {
    }

    @Override // cz.msebera.android.httpclient.impl.client.Clock
    public long getCurrentTime() {
        return System.currentTimeMillis();
    }
}
