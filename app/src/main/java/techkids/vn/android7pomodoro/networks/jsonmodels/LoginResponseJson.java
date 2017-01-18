package techkids.vn.android7pomodoro.networks.jsonmodels;

import com.google.gson.annotations.SerializedName;

/**
 * Created by apple on 1/18/17.
 */

public class LoginResponseJson {
    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("token")
    private String token;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getToken() {
        return token;
    }

    @Override
    public String toString() {
        return "LoginResponseJson{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
