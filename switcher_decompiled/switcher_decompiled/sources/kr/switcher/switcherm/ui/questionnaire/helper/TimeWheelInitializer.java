package kr.switcher.switcherm.ui.questionnaire.helper;

import android.content.Context;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.ui.questionnaire.pager.QuestionWheelAdapter;

/* JADX INFO: loaded from: classes2.dex */
public class TimeWheelInitializer {
    public static QuestionWheelAdapter initAmPm(Context context) {
        QuestionWheelAdapter questionWheelAdapter = new QuestionWheelAdapter(context);
        questionWheelAdapter.add(IOUtil.getStringResource(R.string.am));
        questionWheelAdapter.add(IOUtil.getStringResource(R.string.pm));
        return questionWheelAdapter;
    }

    public static QuestionWheelAdapter initHour(Context context) {
        QuestionWheelAdapter questionWheelAdapter = new QuestionWheelAdapter(context);
        int i = 0;
        while (i < 12) {
            i++;
            questionWheelAdapter.add(IOUtil.convertNumberAddZero(i));
        }
        return questionWheelAdapter;
    }

    public static QuestionWheelAdapter initMin(Context context) {
        QuestionWheelAdapter questionWheelAdapter = new QuestionWheelAdapter(context);
        for (int i = 0; i < 60; i++) {
            questionWheelAdapter.add(IOUtil.convertNumberAddZero(i));
        }
        return questionWheelAdapter;
    }
}
