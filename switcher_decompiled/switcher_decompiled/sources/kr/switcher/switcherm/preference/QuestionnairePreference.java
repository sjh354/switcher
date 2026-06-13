package kr.switcher.switcherm.preference;

import kr.switcher.switcherm.ui.questionnaire.QuestionnaireData;

/* JADX INFO: loaded from: classes2.dex */
public class QuestionnairePreference extends PreferenceHelper {
    private static final String FILE_NAME = "QUESTIONNAIRE";
    private String KEY_QUESTION1_DATA = "QUESTION1_DATA";
    private String KEY_QUESTION2_DATA = "QUESTION2_DATA";
    private String KEY_QUESTION3_DATA = "QUESTION3_DATA";
    private String KEY_QUESTION4_DATA = "QUESTION4_DATA";
    private String KEY_QUESTION5_DATA = "QUESTION5_DATA";
    private String PARM_AM_PM = "AM_PM";
    private String PARM_HOUR = "HOUR";
    private String PARM_MIN = "MIN";
    private String PARM_YN = "YN";

    @Override // kr.switcher.switcherm.preference.PreferenceHelper
    public String getFileName() {
        return FILE_NAME;
    }

    public void initialize() {
        setQuestion1Data(new QuestionnaireData.Question1Data("", 0, 0));
        setQuestion2Data(new QuestionnaireData.Question2Data("", 0, 0));
        setQuestion3Data(new QuestionnaireData.Question3Data(0));
        setQuestion4Data(new QuestionnaireData.Question4Data(0));
        setQuestion5Data(new QuestionnaireData.Question5Data("", 0, 0));
    }

    public void setQuestion1Data(QuestionnaireData.Question1Data question1Data) {
        if (context != null) {
            setString(this.KEY_QUESTION1_DATA + "." + this.PARM_AM_PM, question1Data.getAmpm());
            setInt(this.KEY_QUESTION1_DATA + "." + this.PARM_HOUR, question1Data.getHour());
            setInt(this.KEY_QUESTION1_DATA + "." + this.PARM_MIN, question1Data.getMin());
        }
    }

    public void setQuestion2Data(QuestionnaireData.Question2Data question2Data) {
        if (context != null) {
            setString(this.KEY_QUESTION2_DATA + "." + this.PARM_AM_PM, question2Data.getAmpm());
            setInt(this.KEY_QUESTION2_DATA + "." + this.PARM_HOUR, question2Data.getHour());
            setInt(this.KEY_QUESTION2_DATA + "." + this.PARM_MIN, question2Data.getMin());
        }
    }

    public void setQuestion3Data(QuestionnaireData.Question3Data question3Data) {
        if (context != null) {
            setInt(this.KEY_QUESTION3_DATA + "." + this.PARM_YN, question3Data.getYn());
        }
    }

    public void setQuestion4Data(QuestionnaireData.Question4Data question4Data) {
        if (context != null) {
            setInt(this.KEY_QUESTION4_DATA + "." + this.PARM_YN, question4Data.getYn());
        }
    }

    public void setQuestion5Data(QuestionnaireData.Question5Data question5Data) {
        if (context != null) {
            setString(this.KEY_QUESTION5_DATA + "." + this.PARM_AM_PM, question5Data.getAmpm());
            setInt(this.KEY_QUESTION5_DATA + "." + this.PARM_HOUR, question5Data.getHour());
            setInt(this.KEY_QUESTION5_DATA + "." + this.PARM_MIN, question5Data.getMin());
        }
    }

    public QuestionnaireData.Question1Data getQuestion1Data() {
        QuestionnaireData.Question1Data question1Data = new QuestionnaireData.Question1Data("", 0, 0);
        if (context != null) {
            question1Data.setAmpm(getString(this.KEY_QUESTION1_DATA + "." + this.PARM_AM_PM, ""));
            if (question1Data.getAmpm().equals("")) {
                return null;
            }
            question1Data.setHour(getInt(this.KEY_QUESTION1_DATA + "." + this.PARM_HOUR, 0));
            question1Data.setMin(getInt(this.KEY_QUESTION1_DATA + "." + this.PARM_MIN, 0));
        }
        return question1Data;
    }

    public QuestionnaireData.Question2Data getQuestion2Data() {
        QuestionnaireData.Question2Data question2Data = new QuestionnaireData.Question2Data("", 0, 0);
        if (context != null) {
            question2Data.setAmpm(getString(this.KEY_QUESTION2_DATA + "." + this.PARM_AM_PM, ""));
            if (question2Data.getAmpm().equals("")) {
                return null;
            }
            question2Data.setHour(getInt(this.KEY_QUESTION2_DATA + "." + this.PARM_HOUR, 0));
            question2Data.setMin(getInt(this.KEY_QUESTION2_DATA + "." + this.PARM_MIN, 0));
        }
        return question2Data;
    }

    public QuestionnaireData.Question3Data getQuestion3Data() {
        QuestionnaireData.Question3Data question3Data = new QuestionnaireData.Question3Data(0);
        if (context == null) {
            return question3Data;
        }
        question3Data.setYn(getInt(this.KEY_QUESTION3_DATA + "." + this.PARM_YN, 0));
        if (question3Data.getYn() == 0) {
            return null;
        }
        return question3Data;
    }

    public QuestionnaireData.Question4Data getQuestion4Data() {
        QuestionnaireData.Question4Data question4Data = new QuestionnaireData.Question4Data(0);
        if (context == null) {
            return question4Data;
        }
        question4Data.setYn(getInt(this.KEY_QUESTION4_DATA + "." + this.PARM_YN, 0));
        if (question4Data.getYn() == 0) {
            return null;
        }
        return question4Data;
    }

    public QuestionnaireData.Question5Data getQuestion5Data() {
        QuestionnaireData.Question5Data question5Data = new QuestionnaireData.Question5Data("", 0, 0);
        if (context != null) {
            question5Data.setAmpm(getString(this.KEY_QUESTION5_DATA + "." + this.PARM_AM_PM, ""));
            if (question5Data.getAmpm().equals("")) {
                return null;
            }
            question5Data.setHour(getInt(this.KEY_QUESTION5_DATA + "." + this.PARM_HOUR, 0));
            question5Data.setMin(getInt(this.KEY_QUESTION5_DATA + "." + this.PARM_MIN, 0));
        }
        return question5Data;
    }
}
