package com.neovisionaries.bluetooth.ble.advertising;

/* JADX INFO: loaded from: classes.dex */
class TxPowerLevelBuilder implements ADStructureBuilder {
    TxPowerLevelBuilder() {
    }

    @Override // com.neovisionaries.bluetooth.ble.advertising.ADStructureBuilder
    public ADStructure build(int i, int i2, byte[] bArr) {
        return new TxPowerLevel(i, i2, bArr);
    }
}
