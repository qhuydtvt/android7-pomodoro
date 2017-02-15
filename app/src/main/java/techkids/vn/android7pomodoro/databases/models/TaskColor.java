package techkids.vn.android7pomodoro.databases.models;

/**
 * Created by huynq on 2/15/17.
 */

public class TaskColor {

    private String colorString;
    private boolean isChecked;

    public TaskColor(String colorString, boolean isChecked) {
        this.colorString = colorString;
        this.isChecked = isChecked;
    }

    public String getColorString() {
        return colorString;
    }

    public void setColorString(String colorString) {
        this.colorString = colorString;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    @Override
    public String toString() {
        return "TaskColor{" +
                "isChecked=" + isChecked +
                ", colorString='" + colorString + '\'' +
                '}';
    }

    public static String[] COLORS = new String[] {
            "#0091EA",
            "#00C853",
            "#FFD600",
            "#DD2C00",
            "#AA00FF",
            "#757575",
            "#F50057"
    };
}
