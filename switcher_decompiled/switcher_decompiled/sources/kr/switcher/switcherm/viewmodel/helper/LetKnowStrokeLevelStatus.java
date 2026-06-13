package kr.switcher.switcherm.viewmodel.helper;

/* JADX INFO: loaded from: classes2.dex */
public class LetKnowStrokeLevelStatus {
    private int savedStrokeLevel;

    public LetKnowStrokeLevelStatus() {
        saveStrokeLevel(1);
    }

    public LetKnowStrokeLevelStatus(int i) {
        saveStrokeLevel(i);
    }

    public void saveStrokeLevel(int i) {
        this.savedStrokeLevel = i;
    }

    public boolean isActivated(int i) {
        return this.savedStrokeLevel == i;
    }

    public int getSavedStrokeLevel() {
        return this.savedStrokeLevel;
    }
}
