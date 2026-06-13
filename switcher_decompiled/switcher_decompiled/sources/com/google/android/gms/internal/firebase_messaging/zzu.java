package com.google.android.gms.internal.firebase_messaging;

import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.ValueEncoder;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: com.google.firebase:firebase-messaging@@23.0.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzu implements ObjectEncoderContext {
    private static final Charset zza = Charset.forName("UTF-8");
    private static final FieldDescriptor zzb;
    private static final FieldDescriptor zzc;
    private static final ObjectEncoder<Map.Entry<Object, Object>> zzd;
    private OutputStream zze;
    private final Map<Class<?>, ObjectEncoder<?>> zzf;
    private final Map<Class<?>, ValueEncoder<?>> zzg;
    private final ObjectEncoder<Object> zzh;
    private final zzy zzi = new zzy(this);

    static {
        FieldDescriptor.Builder builder = FieldDescriptor.builder("key");
        zzo zzoVar = new zzo();
        zzoVar.zza(1);
        zzb = builder.withProperty(zzoVar.zzb()).build();
        FieldDescriptor.Builder builder2 = FieldDescriptor.builder("value");
        zzo zzoVar2 = new zzo();
        zzoVar2.zza(2);
        zzc = builder2.withProperty(zzoVar2.zzb()).build();
        zzd = new ObjectEncoder() { // from class: com.google.android.gms.internal.firebase_messaging.zzt
            @Override // com.google.firebase.encoders.Encoder
            public final void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
                zzu.zzg((Map.Entry) obj, objectEncoderContext);
            }
        };
    }

    zzu(OutputStream outputStream, Map<Class<?>, ObjectEncoder<?>> map, Map<Class<?>, ValueEncoder<?>> map2, ObjectEncoder<Object> objectEncoder) {
        this.zze = outputStream;
        this.zzf = map;
        this.zzg = map2;
        this.zzh = objectEncoder;
    }

    static /* synthetic */ void zzg(Map.Entry entry, ObjectEncoderContext objectEncoderContext) throws IOException {
        objectEncoderContext.add(zzb, entry.getKey());
        objectEncoderContext.add(zzc, entry.getValue());
    }

    private static int zzh(FieldDescriptor fieldDescriptor) {
        zzs zzsVar = (zzs) fieldDescriptor.getProperty(zzs.class);
        if (zzsVar != null) {
            return zzsVar.zza();
        }
        throw new EncodingException("Field has no @Protobuf config");
    }

    private final <T> long zzi(ObjectEncoder<T> objectEncoder, T t) throws IOException {
        zzp zzpVar = new zzp();
        try {
            OutputStream outputStream = this.zze;
            this.zze = zzpVar;
            try {
                objectEncoder.encode(t, this);
                this.zze = outputStream;
                long jZza = zzpVar.zza();
                zzpVar.close();
                return jZza;
            } catch (Throwable th) {
                this.zze = outputStream;
                throw th;
            }
        } catch (Throwable th2) {
            try {
                zzpVar.close();
            } catch (Throwable unused) {
            }
            throw th2;
        }
    }

    private static zzs zzj(FieldDescriptor fieldDescriptor) {
        zzs zzsVar = (zzs) fieldDescriptor.getProperty(zzs.class);
        if (zzsVar != null) {
            return zzsVar;
        }
        throw new EncodingException("Field has no @Protobuf config");
    }

    private final <T> zzu zzk(ObjectEncoder<T> objectEncoder, FieldDescriptor fieldDescriptor, T t, boolean z) throws IOException {
        long jZzi = zzi(objectEncoder, t);
        if (z && jZzi == 0) {
            return this;
        }
        zzn((zzh(fieldDescriptor) << 3) | 2);
        zzo(jZzi);
        objectEncoder.encode(t, this);
        return this;
    }

    private final <T> zzu zzl(ValueEncoder<T> valueEncoder, FieldDescriptor fieldDescriptor, T t, boolean z) throws IOException {
        this.zzi.zza(fieldDescriptor, z);
        valueEncoder.encode(t, this.zzi);
        return this;
    }

    private static ByteBuffer zzm(int i) {
        return ByteBuffer.allocate(i).order(ByteOrder.LITTLE_ENDIAN);
    }

    private final void zzn(int i) throws IOException {
        while ((i & (-128)) != 0) {
            this.zze.write((i & 127) | 128);
            i >>>= 7;
        }
        this.zze.write(i & 127);
    }

    private final void zzo(long j) throws IOException {
        while (((-128) & j) != 0) {
            this.zze.write((((int) j) & 127) | 128);
            j >>>= 7;
        }
        this.zze.write(((int) j) & 127);
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final ObjectEncoderContext add(FieldDescriptor fieldDescriptor, double d) throws IOException {
        zza(fieldDescriptor, d, true);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final ObjectEncoderContext inline(Object obj) throws IOException {
        zzf(obj);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final ObjectEncoderContext nested(FieldDescriptor fieldDescriptor) throws IOException {
        throw new EncodingException("nested() is not implemented for protobuf encoding.");
    }

    final ObjectEncoderContext zza(FieldDescriptor fieldDescriptor, double d, boolean z) throws IOException {
        if (z && d == 0.0d) {
            return this;
        }
        zzn((zzh(fieldDescriptor) << 3) | 1);
        this.zze.write(zzm(8).putDouble(d).array());
        return this;
    }

    final ObjectEncoderContext zzb(FieldDescriptor fieldDescriptor, float f, boolean z) throws IOException {
        if (z && f == 0.0f) {
            return this;
        }
        zzn((zzh(fieldDescriptor) << 3) | 5);
        this.zze.write(zzm(4).putFloat(f).array());
        return this;
    }

    final ObjectEncoderContext zzc(FieldDescriptor fieldDescriptor, Object obj, boolean z) throws IOException {
        if (obj == null) {
            return this;
        }
        if (obj instanceof CharSequence) {
            CharSequence charSequence = (CharSequence) obj;
            if (z && charSequence.length() == 0) {
                return this;
            }
            zzn((zzh(fieldDescriptor) << 3) | 2);
            byte[] bytes = charSequence.toString().getBytes(zza);
            zzn(bytes.length);
            this.zze.write(bytes);
            return this;
        }
        if (obj instanceof Collection) {
            Iterator it = ((Collection) obj).iterator();
            while (it.hasNext()) {
                zzc(fieldDescriptor, it.next(), false);
            }
            return this;
        }
        if (obj instanceof Map) {
            Iterator it2 = ((Map) obj).entrySet().iterator();
            while (it2.hasNext()) {
                zzk(zzd, fieldDescriptor, (Map.Entry) it2.next(), false);
            }
            return this;
        }
        if (obj instanceof Double) {
            zza(fieldDescriptor, ((Double) obj).doubleValue(), z);
            return this;
        }
        if (obj instanceof Float) {
            zzb(fieldDescriptor, ((Float) obj).floatValue(), z);
            return this;
        }
        if (obj instanceof Number) {
            zze(fieldDescriptor, ((Number) obj).longValue(), z);
            return this;
        }
        if (obj instanceof Boolean) {
            zzd(fieldDescriptor, ((Boolean) obj).booleanValue() ? 1 : 0, z);
            return this;
        }
        if (obj instanceof byte[]) {
            byte[] bArr = (byte[]) obj;
            if (z && bArr.length == 0) {
                return this;
            }
            zzn((zzh(fieldDescriptor) << 3) | 2);
            zzn(bArr.length);
            this.zze.write(bArr);
            return this;
        }
        ObjectEncoder<?> objectEncoder = this.zzf.get(obj.getClass());
        if (objectEncoder != null) {
            zzk(objectEncoder, fieldDescriptor, obj, z);
            return this;
        }
        ValueEncoder<?> valueEncoder = this.zzg.get(obj.getClass());
        if (valueEncoder != null) {
            zzl(valueEncoder, fieldDescriptor, obj, z);
            return this;
        }
        if (obj instanceof zzq) {
            zzd(fieldDescriptor, ((zzq) obj).getNumber(), true);
            return this;
        }
        if (obj instanceof Enum) {
            zzd(fieldDescriptor, ((Enum) obj).ordinal(), true);
            return this;
        }
        zzk(this.zzh, fieldDescriptor, obj, z);
        return this;
    }

    final zzu zzd(FieldDescriptor fieldDescriptor, int i, boolean z) throws IOException {
        if (z && i == 0) {
            return this;
        }
        zzs zzsVarZzj = zzj(fieldDescriptor);
        zzr zzrVar = zzr.DEFAULT;
        int iOrdinal = zzsVarZzj.zzb().ordinal();
        if (iOrdinal == 0) {
            zzn(zzsVarZzj.zza() << 3);
            zzn(i);
        } else if (iOrdinal == 1) {
            zzn(zzsVarZzj.zza() << 3);
            zzn((i + i) ^ (i >> 31));
        } else if (iOrdinal == 2) {
            zzn((zzsVarZzj.zza() << 3) | 5);
            this.zze.write(zzm(4).putInt(i).array());
        }
        return this;
    }

    final zzu zze(FieldDescriptor fieldDescriptor, long j, boolean z) throws IOException {
        if (z && j == 0) {
            return this;
        }
        zzs zzsVarZzj = zzj(fieldDescriptor);
        zzr zzrVar = zzr.DEFAULT;
        int iOrdinal = zzsVarZzj.zzb().ordinal();
        if (iOrdinal == 0) {
            zzn(zzsVarZzj.zza() << 3);
            zzo(j);
        } else if (iOrdinal == 1) {
            zzn(zzsVarZzj.zza() << 3);
            zzo((j >> 63) ^ (j + j));
        } else if (iOrdinal == 2) {
            zzn((zzsVarZzj.zza() << 3) | 1);
            this.zze.write(zzm(8).putLong(j).array());
        }
        return this;
    }

    final zzu zzf(Object obj) throws IOException {
        if (obj == null) {
            return this;
        }
        ObjectEncoder<?> objectEncoder = this.zzf.get(obj.getClass());
        if (objectEncoder != null) {
            objectEncoder.encode(obj, this);
            return this;
        }
        String strValueOf = String.valueOf(obj.getClass());
        String.valueOf(strValueOf).length();
        throw new EncodingException("No encoder for ".concat(String.valueOf(strValueOf)));
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final ObjectEncoderContext add(FieldDescriptor fieldDescriptor, float f) throws IOException {
        zzb(fieldDescriptor, f, true);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final ObjectEncoderContext nested(String str) throws IOException {
        return nested(FieldDescriptor.of(str));
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final /* synthetic */ ObjectEncoderContext add(FieldDescriptor fieldDescriptor, int i) throws IOException {
        zzd(fieldDescriptor, i, true);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final /* synthetic */ ObjectEncoderContext add(FieldDescriptor fieldDescriptor, long j) throws IOException {
        zze(fieldDescriptor, j, true);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final ObjectEncoderContext add(FieldDescriptor fieldDescriptor, Object obj) throws IOException {
        zzc(fieldDescriptor, obj, true);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final /* synthetic */ ObjectEncoderContext add(FieldDescriptor fieldDescriptor, boolean z) throws IOException {
        zzd(fieldDescriptor, z ? 1 : 0, true);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final ObjectEncoderContext add(String str, double d) throws IOException {
        zza(FieldDescriptor.of(str), d, true);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final ObjectEncoderContext add(String str, int i) throws IOException {
        zzd(FieldDescriptor.of(str), i, true);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final ObjectEncoderContext add(String str, long j) throws IOException {
        zze(FieldDescriptor.of(str), j, true);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final ObjectEncoderContext add(String str, Object obj) throws IOException {
        zzc(FieldDescriptor.of(str), obj, true);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final ObjectEncoderContext add(String str, boolean z) throws IOException {
        zzd(FieldDescriptor.of(str), z ? 1 : 0, true);
        return this;
    }
}
