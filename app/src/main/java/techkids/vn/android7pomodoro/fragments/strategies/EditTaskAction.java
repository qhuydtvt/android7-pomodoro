package techkids.vn.android7pomodoro.fragments.strategies;

import techkids.vn.android7pomodoro.databases.DbContext;
import techkids.vn.android7pomodoro.databases.models.Task;

/**
 * Created by huynq on 2/18/17.
 */

public class EditTaskAction implements TaskAction {

    @Override
    public void excute(Task task) {
        DbContext.instance.edit(task);
    }
}
