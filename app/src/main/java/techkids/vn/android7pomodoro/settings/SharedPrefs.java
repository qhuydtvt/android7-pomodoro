package techkids.vn.android7pomodoro.settings;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

/**
 * Created by apple on 1/14/17.
 */

public class SharedPrefs {
    private static final String SHARED_PREFS_NAME = "SP";
    private static final String LOGIN_KEY = "login";

    private static SharedPrefs instance;

    public static SharedPrefs getInstance() {
        return instance;
    }

    public static void init(Context context) {
        instance = new SharedPrefs(context);
    }

    private SharedPreferences sharedPreferences;
    private Gson gson;

    public SharedPrefs(Context context) {
        this.sharedPreferences = context.getSharedPreferences(
                SHARED_PREFS_NAME,
                Context.MODE_PRIVATE
        );

        this.gson = new Gson();
    }

    public void put(LoginCredentials loginCredentials) {
        // 1. Convert object to string
        String loginJSON = gson.toJson(loginCredentials);

        // 2. Put
        this.sharedPreferences.edit().putString(LOGIN_KEY, loginJSON).commit();
    }

    public LoginCredentials getLoginCredendials() {
        // 1. Get String
        String loginJSON = this.sharedPreferences.getString(LOGIN_KEY, null);

        // 2. Convert string to object
        if(loginJSON == null) return null;
        LoginCredentials loginCredentials = gson.fromJson(loginJSON, LoginCredentials.class);
        return loginCredentials;
    }
}
