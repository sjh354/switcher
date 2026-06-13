package com.neovisionaries.bluetooth.ble.advertising;

/* JADX INFO: loaded from: classes.dex */
public class Flags extends ADStructure {
    private static final int CONTROLLER_SIMULTANEITY_SUPPORTED_BIT = 8;
    private static final int GENERAL_DISCOVERABLE_BIT = 2;
    private static final int HOST_SIMULTANEITY_SUPPORTED_BIT = 16;
    private static final int LEGACY_NOT_SUPPORTED_BIT = 4;
    private static final int LIMITED_DISCOVERABLE_BIT = 1;
    private static final String STRING_FORMAT = "Flags(LimitedDiscoverable=%s,GeneralDiscoverable=%s,LegacySupported=%s,ControllerSimultaneitySupported=%s,HostSimultaneitySupported=%s)";
    private static final long serialVersionUID = 2;
    private boolean mControllerSimultaneitySupported;
    private boolean mGeneralDiscoverable;
    private boolean mHostSimultaneitySupported;
    private boolean mLegacySupported;
    private boolean mLimitedDiscoverable;

    public Flags() {
        this(2, 1, new byte[]{0});
    }

    public Flags(int i, int i2, byte[] bArr) {
        super(i, i2, bArr);
        parse(bArr);
    }

    public boolean isLimitedDiscoverable() {
        return this.mLimitedDiscoverable;
    }

    public void setLimitedDiscoverable(boolean z) {
        this.mLimitedDiscoverable = z;
        setBit(0, 1, z);
    }

    public boolean isGeneralDiscoverable() {
        return this.mGeneralDiscoverable;
    }

    public void setGeneralDiscoverable(boolean z) {
        this.mGeneralDiscoverable = z;
        setBit(0, 2, z);
    }

    public boolean isLegacySupported() {
        return this.mLegacySupported;
    }

    public void setLegacySupported(boolean z) {
        this.mLegacySupported = z;
        setBit(0, 4, !z);
    }

    public boolean isControllerSimultaneitySupported() {
        return this.mControllerSimultaneitySupported;
    }

    public void setControllerSimultaneitySupported(boolean z) {
        this.mControllerSimultaneitySupported = z;
        setBit(0, 8, z);
    }

    public boolean isHostSimultaneitySupported() {
        return this.mHostSimultaneitySupported;
    }

    public void setHostSimultaneitySupported(boolean z) {
        this.mHostSimultaneitySupported = z;
        setBit(0, 16, z);
    }

    private void parse(byte[] bArr) {
        if (bArr != null) {
            if (bArr.length < 1) {
                return;
            }
            byte b = bArr[0];
            this.mLimitedDiscoverable = (b & 1) != 0;
            this.mGeneralDiscoverable = (b & 2) != 0;
            this.mLegacySupported = (b & 4) == 0;
            this.mControllerSimultaneitySupported = (b & 8) != 0;
            this.mHostSimultaneitySupported = (b & 16) != 0;
        }
    }

    private void setBit(int i, int i2, boolean z) {
        byte[] data;
        if (i < 0 || i2 < 0 || 7 < i2 || (data = getData()) == null || data.length <= i) {
            return;
        }
        if (z) {
            data[i] = (byte) (((1 << i2) | data[i]) & 255);
        } else {
            data[i] = (byte) ((~(1 << i2)) & data[i] & 255);
        }
    }

    @Override // com.neovisionaries.bluetooth.ble.advertising.ADStructure
    public String toString() {
        return String.format(STRING_FORMAT, Boolean.valueOf(this.mLimitedDiscoverable), Boolean.valueOf(this.mGeneralDiscoverable), Boolean.valueOf(this.mLegacySupported), Boolean.valueOf(this.mControllerSimultaneitySupported), Boolean.valueOf(this.mHostSimultaneitySupported));
    }
}
