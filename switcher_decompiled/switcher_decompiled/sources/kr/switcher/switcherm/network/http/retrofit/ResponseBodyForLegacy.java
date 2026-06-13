package kr.switcher.switcherm.network.http.retrofit;

/* JADX INFO: loaded from: classes2.dex */
public class ResponseBodyForLegacy {
    String code;
    ResultRepo data;
    String message;
    String status;

    public class ResultRepo {
        String result;

        public ResultRepo() {
        }

        public String getResult() {
            return this.result;
        }
    }

    public ResultRepo getData() {
        return this.data;
    }

    public String getStatus() {
        return this.status;
    }

    public String getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }
}
