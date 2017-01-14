package techkids.vn.android7pomodoro;

import android.app.Application;
import android.util.Log;

import techkids.vn.android7pomodoro.settings.SharedPrefs;

/**
 * Created by apple on 1/14/17.
 */

public class PomodoroApplication extends Application {

    private static final String TAG = "PomodoroApplication";

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate: ");
        SharedPrefs.init(this);
    }
}
