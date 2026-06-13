package kr.switcher.switcherm.ui.main.helper;

/* JADX INFO: loaded from: classes2.dex */
public class LatestSensorValue {
    public String created_at;
    public String decibel;
    public String id;
    public String illumination_intensity;
    public String mac_address;
    public String temperature;

    public String getIllumination_intensity() {
        return this.illumination_intensity;
    }

    public void setIllumination_intensity(String str) {
        this.illumination_intensity = str;
    }

    public String getTemperature() {
        return this.temperature;
    }

    public void setTemperature(String str) {
        this.temperature = str;
    }

    public String getDecibel() {
        return this.decibel;
    }

    public void setDecibel(String str) {
        this.decibel = str;
    }
}
