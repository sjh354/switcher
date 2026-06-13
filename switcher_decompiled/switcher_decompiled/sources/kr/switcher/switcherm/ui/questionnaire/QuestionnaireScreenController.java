package kr.switcher.switcherm.ui.questionnaire;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.util.IOLog;
import kr.switcher.switcherm.preference.OAuthToken;
import kr.switcher.switcherm.ui.questionnaire.fragment.AnalysisFragment;
import kr.switcher.switcherm.ui.questionnaire.fragment.QuestionnaireEditFragment;
import kr.switcher.switcherm.ui.questionnaire.fragment.QuestionnaireFragment;
import kr.switcher.switcherm.ui.questionnaire.fragment.SummaryFragment;

/* JADX INFO: loaded from: classes2.dex */
public class QuestionnaireScreenController {
    public static void moveQuestionnaireFragment(AppCompatActivity appCompatActivity, String str) {
        moveFragment(appCompatActivity, QuestionnaireFragment.newInstance(str), "QuestionnaireFragment");
    }

    public static void moveSummaryFragment(AppCompatActivity appCompatActivity, String str) {
        moveFragment(appCompatActivity, SummaryFragment.newInstance(str), "SummaryFragment");
    }

    public static void moveQuestionEditFragment(AppCompatActivity appCompatActivity, int i, String str) {
        moveFragment(appCompatActivity, QuestionnaireEditFragment.newInstance(i, str), "QuestionnaireEditFragment");
    }

    public static void moveAnalysisFragment(AppCompatActivity appCompatActivity, String str) {
        moveFragment(appCompatActivity, AnalysisFragment.newInstance(str), "AnalysisFragment");
    }

    private static void moveFragment(AppCompatActivity appCompatActivity, Fragment fragment, String str) {
        FragmentTransaction fragmentTransactionBeginTransaction = appCompatActivity.getSupportFragmentManager().beginTransaction();
        fragmentTransactionBeginTransaction.replace(R.id.container, fragment, str);
        try {
            fragmentTransactionBeginTransaction.commit();
        } catch (Exception e) {
            IOLog.error("ContentValues", new OAuthToken().getOAuthToken(), "moveWifiConnectFragment", e);
        }
    }
}
