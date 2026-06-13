package kr.switcher.switcherm.signal;

import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import kr.switcher.switcherm.ui.dialog.IODialogController;

/* JADX INFO: loaded from: classes2.dex */
public class SignalFragment extends Fragment {
    private boolean isAlive;

    public interface OnSignalListener {
        void onStartSignal();
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.isAlive = true;
        IOSignal.setContext(getContext());
        startSignal();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        clearSignal();
        this.isAlive = false;
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.isAlive = false;
    }

    public OnSignalListener getFinishDialogListener() {
        return new OnSignalListener() { // from class: kr.switcher.switcherm.signal.SignalFragment.1
            @Override // kr.switcher.switcherm.signal.SignalFragment.OnSignalListener
            public void onStartSignal() {
                new Handler().postDelayed(new Runnable() { // from class: kr.switcher.switcherm.signal.SignalFragment.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SignalFragment.this.startSignal();
                    }
                }, 500L);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startSignal() {
        IOSignal.start();
    }

    private void clearSignal() {
        IOSignal.clear();
    }

    public void onSignal(String str, SignalData signalData) {
        AppCompatActivity appCompatActivity;
        if (this.isAlive && (appCompatActivity = (AppCompatActivity) getActivity()) != null) {
            IODialogController.showSignalTypeDialog(appCompatActivity, str, signalData, getFinishDialogListener());
        }
    }
}
