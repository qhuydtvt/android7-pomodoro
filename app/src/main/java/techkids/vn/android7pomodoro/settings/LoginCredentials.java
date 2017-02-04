package techkids.vn.android7pomodoro.settings;

/**
 * Created by apple on 1/14/17.
 */

public class LoginCredentials {

    private String username;
    private String password;
    private String accessToken;

//    public LoginCredentials(String username, String password) {
//        this.username = username;
//        this.password = password;
//    }

    public LoginCredentials(String username, String password, String accessToken) {
        this.username = username;
        this.password = password;
        this.accessToken = accessToken;
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

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    @Override
    public String toString() {
        return "LoginCredentials{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", accessToken='" + accessToken + '\'' +
                '}';
    }
}