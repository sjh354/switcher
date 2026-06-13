package kr.switcher.switcherm.network.http.response;

import java.util.List;
import retrofit2.Callback;

/* JADX INFO: loaded from: classes2.dex */
public class RegisterAirconReservationResponse extends HttpAPIResponse {
    public String appliance_id;
    public List<CommandType> commands;
    public String created_at;
    public String is_enabled;
    public String mac_address;
    public String tag;
    public String time;
    public String title;
    public String week;
    public String week_time;

    public class CommandType {
        public String access_token;
        public String command_no;
        public String ir_id;
        public String type;

        public CommandType() {
        }
    }

    @Override // kr.switcher.switcherm.network.http.response.HttpAPIResponse
    public Callback<RegisterAirconReservationResponse> response(HttpResponseHandler httpResponseHandler) {
        return super.response(httpResponseHandler);
    }
}
