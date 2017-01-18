package techkids.vn.android7pomodoro.networks.jsonmodels;

import com.google.gson.annotations.SerializedName;

/**
 * Created by apple on 1/18/17.
 */

public class LoginBodyJson {
    @SerializedName("username")
    private String username;

    @SerializedName("password")
    private String password;

    public LoginBodyJson(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginBodyJson{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
