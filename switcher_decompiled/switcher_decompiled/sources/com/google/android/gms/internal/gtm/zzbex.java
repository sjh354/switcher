package com.google.android.gms.internal.gtm;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
abstract class zzbex {
    private static final Logger zza = Logger.getLogger(zzbcj.class.getName());
    private static final String zzb = "com.google.android.gms.internal.gtm.zzbbk";

    zzbex() {
    }

    static zzbep zzb(Class cls) {
        String str;
        ClassLoader classLoader = zzbex.class.getClassLoader();
        if (cls.equals(zzbep.class)) {
            str = zzb;
        } else {
            if (!cls.getPackage().equals(zzbex.class.getPackage())) {
                throw new IllegalArgumentException(cls.getName());
            }
            str = String.format("%s.BlazeGenerated%sLoader", cls.getPackage().getName(), cls.getSimpleName());
        }
        try {
            try {
                try {
                    try {
                        return (zzbep) cls.cast(((zzbex) Class.forName(str, true, classLoader).getConstructor(new Class[0]).newInstance(new Object[0])).zza());
                    } catch (IllegalAccessException e) {
                        throw new IllegalStateException(e);
                    }
                } catch (InvocationTargetException e2) {
                    throw new IllegalStateException(e2);
                }
            } catch (InstantiationException e3) {
                throw new IllegalStateException(e3);
            } catch (NoSuchMethodException e4) {
                throw new IllegalStateException(e4);
            }
        } catch (ClassNotFoundException unused) {
            Iterator it = ServiceLoader.load(zzbex.class, classLoader).iterator();
            ArrayList arrayList = new ArrayList();
            while (it.hasNext()) {
                try {
                    arrayList.add(cls.cast(((zzbex) it.next()).zza()));
                } catch (ServiceConfigurationError e5) {
                    zza.logp(Level.SEVERE, "com.google.protobuf.GeneratedExtensionRegistryLoader", "load", "Unable to load ".concat(String.valueOf(cls.getSimpleName())), (Throwable) e5);
                }
            }
            if (arrayList.size() == 1) {
                return (zzbep) arrayList.get(0);
            }
            if (arrayList.size() == 0) {
                return null;
            }
            try {
                return (zzbep) cls.getMethod("combine", Collection.class).invoke(null, arrayList);
            } catch (IllegalAccessException e6) {
                throw new IllegalStateException(e6);
            } catch (NoSuchMethodException e7) {
                throw new IllegalStateException(e7);
            } catch (InvocationTargetException e8) {
                throw new IllegalStateException(e8);
            }
        }
    }

    protected abstract zzbep zza();
}
