package cz.msebera.android.httpclient;

/* JADX INFO: loaded from: classes2.dex */
public interface Header extends NameValuePair {
    HeaderElement[] getElements() throws ParseException;
}
