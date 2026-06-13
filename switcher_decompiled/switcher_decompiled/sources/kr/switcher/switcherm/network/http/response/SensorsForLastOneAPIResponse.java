package kr.switcher.switcherm.network.http.response;

import java.util.List;
import retrofit2.Callback;

/* JADX INFO: loaded from: classes2.dex */
public class SensorsForLastOneAPIResponse extends HttpAPIResponse {
    public List<CommandsForLastOne> command_list;
    public List<HeartBeatsForLastOne> heart_beat_list;

    @Override // kr.switcher.switcherm.network.http.response.HttpAPIResponse
    public Callback<SensorsForLastOneAPIResponse> response(HttpResponseHandler httpResponseHandler) {
        return super.response(httpResponseHandler);
    }

    public class HeartBeatsForLastOne {
        public String created_at;
        public String decibel;
        public String illumination_intensity;
        public String temperature;

        public HeartBeatsForLastOne() {
        }
    }

    public class CommandsForLastOne {
        public String command_no;
        public String created_at;
        public String name;
        public int value;

        public CommandsForLastOne() {
        }
    }
}
