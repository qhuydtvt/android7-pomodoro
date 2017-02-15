package techkids.vn.android7pomodoro.utils;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;

/**
 * Created by huynq on 2/15/17.
 */

public class Utils {
    public static void setSolidColor(View v, String colorString) {
        GradientDrawable drawable = (GradientDrawable)v.getBackground();
        drawable.setColor(Color.parseColor(colorString));
    }
}
