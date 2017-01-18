package techkids.vn.android7pomodoro.networks.services;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import techkids.vn.android7pomodoro.networks.jsonmodels.LoginResponseJson;

/**
 * Created by apple on 1/18/17.
 */

public interface LoginService {
    @POST("login")
    Call<LoginResponseJson> login(@Body RequestBody body);
}
