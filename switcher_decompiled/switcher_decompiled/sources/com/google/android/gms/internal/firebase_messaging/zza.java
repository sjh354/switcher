package com.google.android.gms.internal.firebase_messaging;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.messaging.reporting.MessagingClientEvent;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.firebase:firebase-messaging@@23.0.0 */
/* JADX INFO: loaded from: classes.dex */
final class zza implements ObjectEncoder<MessagingClientEvent> {
    static final zza zza = new zza();
    private static final FieldDescriptor zzb;
    private static final FieldDescriptor zzc;
    private static final FieldDescriptor zzd;
    private static final FieldDescriptor zze;
    private static final FieldDescriptor zzf;
    private static final FieldDescriptor zzg;
    private static final FieldDescriptor zzh;
    private static final FieldDescriptor zzi;
    private static final FieldDescriptor zzj;
    private static final FieldDescriptor zzk;
    private static final FieldDescriptor zzl;
    private static final FieldDescriptor zzm;
    private static final FieldDescriptor zzn;
    private static final FieldDescriptor zzo;
    private static final FieldDescriptor zzp;

    static {
        FieldDescriptor.Builder builder = FieldDescriptor.builder("projectNumber");
        zzo zzoVar = new zzo();
        zzoVar.zza(1);
        zzb = builder.withProperty(zzoVar.zzb()).build();
        FieldDescriptor.Builder builder2 = FieldDescriptor.builder("messageId");
        zzo zzoVar2 = new zzo();
        zzoVar2.zza(2);
        zzc = builder2.withProperty(zzoVar2.zzb()).build();
        FieldDescriptor.Builder builder3 = FieldDescriptor.builder("instanceId");
        zzo zzoVar3 = new zzo();
        zzoVar3.zza(3);
        zzd = builder3.withProperty(zzoVar3.zzb()).build();
        FieldDescriptor.Builder builder4 = FieldDescriptor.builder("messageType");
        zzo zzoVar4 = new zzo();
        zzoVar4.zza(4);
        zze = builder4.withProperty(zzoVar4.zzb()).build();
        FieldDescriptor.Builder builder5 = FieldDescriptor.builder("sdkPlatform");
        zzo zzoVar5 = new zzo();
        zzoVar5.zza(5);
        zzf = builder5.withProperty(zzoVar5.zzb()).build();
        FieldDescriptor.Builder builder6 = FieldDescriptor.builder("packageName");
        zzo zzoVar6 = new zzo();
        zzoVar6.zza(6);
        zzg = builder6.withProperty(zzoVar6.zzb()).build();
        FieldDescriptor.Builder builder7 = FieldDescriptor.builder("collapseKey");
        zzo zzoVar7 = new zzo();
        zzoVar7.zza(7);
        zzh = builder7.withProperty(zzoVar7.zzb()).build();
        FieldDescriptor.Builder builder8 = FieldDescriptor.builder("priority");
        zzo zzoVar8 = new zzo();
        zzoVar8.zza(8);
        zzi = builder8.withProperty(zzoVar8.zzb()).build();
        FieldDescriptor.Builder builder9 = FieldDescriptor.builder("ttl");
        zzo zzoVar9 = new zzo();
        zzoVar9.zza(9);
        zzj = builder9.withProperty(zzoVar9.zzb()).build();
        FieldDescriptor.Builder builder10 = FieldDescriptor.builder("topic");
        zzo zzoVar10 = new zzo();
        zzoVar10.zza(10);
        zzk = builder10.withProperty(zzoVar10.zzb()).build();
        FieldDescriptor.Builder builder11 = FieldDescriptor.builder("bulkId");
        zzo zzoVar11 = new zzo();
        zzoVar11.zza(11);
        zzl = builder11.withProperty(zzoVar11.zzb()).build();
        FieldDescriptor.Builder builder12 = FieldDescriptor.builder("event");
        zzo zzoVar12 = new zzo();
        zzoVar12.zza(12);
        zzm = builder12.withProperty(zzoVar12.zzb()).build();
        FieldDescriptor.Builder builder13 = FieldDescriptor.builder("analyticsLabel");
        zzo zzoVar13 = new zzo();
        zzoVar13.zza(13);
        zzn = builder13.withProperty(zzoVar13.zzb()).build();
        FieldDescriptor.Builder builder14 = FieldDescriptor.builder("campaignId");
        zzo zzoVar14 = new zzo();
        zzoVar14.zza(14);
        zzo = builder14.withProperty(zzoVar14.zzb()).build();
        FieldDescriptor.Builder builder15 = FieldDescriptor.builder("composerLabel");
        zzo zzoVar15 = new zzo();
        zzoVar15.zza(15);
        zzp = builder15.withProperty(zzoVar15.zzb()).build();
    }

    private zza() {
    }

    @Override // com.google.firebase.encoders.Encoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        MessagingClientEvent messagingClientEvent = (MessagingClientEvent) obj;
        ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
        objectEncoderContext2.add(zzb, messagingClientEvent.getProjectNumber());
        objectEncoderContext2.add(zzc, messagingClientEvent.getMessageId());
        objectEncoderContext2.add(zzd, messagingClientEvent.getInstanceId());
        objectEncoderContext2.add(zze, messagingClientEvent.getMessageType());
        objectEncoderContext2.add(zzf, messagingClientEvent.getSdkPlatform());
        objectEncoderContext2.add(zzg, messagingClientEvent.getPackageName());
        objectEncoderContext2.add(zzh, messagingClientEvent.getCollapseKey());
        objectEncoderContext2.add(zzi, messagingClientEvent.getPriority());
        objectEncoderContext2.add(zzj, messagingClientEvent.getTtl());
        objectEncoderContext2.add(zzk, messagingClientEvent.getTopic());
        objectEncoderContext2.add(zzl, messagingClientEvent.getBulkId());
        objectEncoderContext2.add(zzm, messagingClientEvent.getEvent());
        objectEncoderContext2.add(zzn, messagingClientEvent.getAnalyticsLabel());
        objectEncoderContext2.add(zzo, messagingClientEvent.getCampaignId());
        objectEncoderContext2.add(zzp, messagingClientEvent.getComposerLabel());
    }
}
