package com.google.android.gms.internal.gtm;

import com.google.android.gms.internal.gtm.zzbax;
import com.google.android.gms.internal.gtm.zzbay;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public abstract class zzbay<MessageType extends zzbay<MessageType, BuilderType>, BuilderType extends zzbax<MessageType, BuilderType>> implements zzbgs {
    protected int zzc = 0;

    /* JADX WARN: Multi-variable type inference failed */
    protected static void zzS(Iterable iterable, List list) {
        zzbfq.zze(iterable);
        if (list instanceof ArrayList) {
            ((ArrayList) list).ensureCapacity(list.size() + iterable.size());
        }
        int size = list.size();
        for (Object obj : iterable) {
            if (obj == null) {
                String str = "Element at index " + (list.size() - size) + " is null.";
                int size2 = list.size();
                while (true) {
                    size2--;
                    if (size2 < size) {
                        throw new NullPointerException(str);
                    }
                    list.remove(size2);
                }
            } else {
                list.add(obj);
            }
        }
    }

    int zzQ() {
        throw null;
    }

    @Override // com.google.android.gms.internal.gtm.zzbgs
    public final zzbbw zzR() {
        try {
            int iZzY = zzY();
            zzbbw zzbbwVar = zzbbw.zzb;
            byte[] bArr = new byte[iZzY];
            zzbcj zzbcjVarZzL = zzbcj.zzL(bArr);
            zzau(zzbcjVarZzL);
            if (zzbcjVarZzL.zzb() == 0) {
                return new zzbbt(bArr);
            }
            throw new IllegalStateException("Did not write as much data as expected.");
        } catch (IOException e) {
            throw new RuntimeException("Serializing " + getClass().getName() + " to a ByteString threw an IOException (should never happen).", e);
        }
    }

    void zzT(int i) {
        throw null;
    }

    public final void zzU(OutputStream outputStream) throws IOException {
        zzbcj zzbcjVarZzM = zzbcj.zzM(outputStream, zzbcj.zzG(zzY()));
        zzau(zzbcjVarZzM);
        zzbcjVarZzM.zzR();
    }
}
