package no.nordicsemi.android.dfu.internal.scanner;

/* JADX INFO: loaded from: classes2.dex */
public interface BootloaderScanner {
    public static final int ADDRESS_DIFF = 1;
    public static final long TIMEOUT = 5000;

    String searchFor(String str);
}
