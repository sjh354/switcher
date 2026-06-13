package kr.switcher.switcherm.ui.questionnaire;

import kr.switcher.switcherm.preference.QuestionnairePreference;

/* JADX INFO: loaded from: classes2.dex */
public class QuestionnaireData {
    public static final String EMPTY = "";
    public static final int NO = 2;
    public static final int NONE = 0;
    public static final int YES = 1;
    private QuestionnairePreference preference = new QuestionnairePreference();

    public void initialize() {
        this.preference.initialize();
    }

    public void setQuestion1Data(Question1Data question1Data) {
        this.preference.setQuestion1Data(question1Data);
    }

    public void setQuestion2Data(Question2Data question2Data) {
        this.preference.setQuestion2Data(question2Data);
    }

    public void setQuestion3Data(Question3Data question3Data) {
        this.preference.setQuestion3Data(question3Data);
    }

    public void setQuestion4Data(Question4Data question4Data) {
        this.preference.setQuestion4Data(question4Data);
    }

    public void setQuestion5Data(Question5Data question5Data) {
        this.preference.setQuestion5Data(question5Data);
    }

    public boolean isFull() {
        return (getQuestion1Data() == null || getQuestion2Data() == null || getQuestion3Data() == null || getQuestion4Data() == null || getQuestion5Data() == null) ? false : true;
    }

    public Question1Data getQuestion1Data() {
        return this.preference.getQuestion1Data();
    }

    public Question2Data getQuestion2Data() {
        return this.preference.getQuestion2Data();
    }

    public Question3Data getQuestion3Data() {
        return this.preference.getQuestion3Data();
    }

    public Question4Data getQuestion4Data() {
        return this.preference.getQuestion4Data();
    }

    public Question5Data getQuestion5Data() {
        return this.preference.getQuestion5Data();
    }

    public static class Question1Data {
        private String ampm;
        private int hour;
        private int min;

        public Question1Data(String str, int i, int i2) {
            this.ampm = str;
            this.hour = i;
            this.min = i2;
        }

        public void setAmpm(String str) {
            this.ampm = str;
        }

        public void setHour(int i) {
            this.hour = i;
        }

        public void setMin(int i) {
            this.min = i;
        }

        public String getAmpm() {
            return this.ampm;
        }

        public int getHour() {
            return this.hour;
        }

        public int getMin() {
            return this.min;
        }
    }

    public static class Question2Data {
        private String ampm;
        private int hour;
        private int min;

        public Question2Data(String str, int i, int i2) {
            this.ampm = str;
            this.hour = i;
            this.min = i2;
        }

        public void setAmpm(String str) {
            this.ampm = str;
        }

        public void setHour(int i) {
            this.hour = i;
        }

        public void setMin(int i) {
            this.min = i;
        }

        public String getAmpm() {
            return this.ampm;
        }

        public int getHour() {
            return this.hour;
        }

        public int getMin() {
            return this.min;
        }
    }

    public static class Question3Data {
        private int yn;

        public Question3Data(int i) {
            this.yn = i;
        }

        public void setYn(int i) {
            this.yn = i;
        }

        public int getYn() {
            return this.yn;
        }
    }

    public static class Question4Data {
        private int yn;

        public Question4Data(int i) {
            this.yn = i;
        }

        public void setYn(int i) {
            this.yn = i;
        }

        public int getYn() {
            return this.yn;
        }
    }

    public static class Question5Data {
        private String ampm;
        private int hour;
        private int min;

        public Question5Data(String str, int i, int i2) {
            this.ampm = str;
            this.hour = i;
            this.min = i2;
        }

        public void setAmpm(String str) {
            this.ampm = str;
        }

        public void setHour(int i) {
            this.hour = i;
        }

        public void setMin(int i) {
            this.min = i;
        }

        public String getAmpm() {
            return this.ampm;
        }

        public int getHour() {
            return this.hour;
        }

        public int getMin() {
            return this.min;
        }
    }
}
