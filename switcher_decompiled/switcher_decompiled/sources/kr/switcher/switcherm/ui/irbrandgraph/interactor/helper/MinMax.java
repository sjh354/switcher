package kr.switcher.switcherm.ui.irbrandgraph.interactor.helper;

/* JADX INFO: loaded from: classes2.dex */
public class MinMax {
    private float max;
    private float min;

    public MinMax() {
        this.min = -1.0f;
        this.max = -1.0f;
    }

    public MinMax(float f, float f2) {
        this.min = f;
        this.max = f2;
    }

    public float getMin() {
        return this.min;
    }

    public float getMax() {
        return this.max;
    }
}
