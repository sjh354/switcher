package cz.msebera.android.httpclient.entity;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes2.dex */
public interface ContentProducer {
    void writeTo(OutputStream outputStream) throws IOException;
}
