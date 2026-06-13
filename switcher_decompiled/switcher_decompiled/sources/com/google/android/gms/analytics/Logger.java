package com.google.android.gms.analytics;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public interface Logger {

    /* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
    @Deprecated
    public static class LogLevel {
        public static final int ERROR = 3;
        public static final int INFO = 1;
        public static final int VERBOSE = 0;
        public static final int WARNING = 2;
    }

    @Deprecated
    void error(Exception exc);

    @Deprecated
    void error(String str);

    @Deprecated
    int getLogLevel();

    @Deprecated
    void info(String str);

    @Deprecated
    void setLogLevel(int i);

    @Deprecated
    void verbose(String str);

    @Deprecated
    void warn(String str);
}
