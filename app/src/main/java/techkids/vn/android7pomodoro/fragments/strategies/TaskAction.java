package techkids.vn.android7pomodoro.fragments.strategies;

import techkids.vn.android7pomodoro.databases.models.Task;

/**
 * Created by huynq on 2/18/17.
 */

public interface TaskAction {
    void excute(Task task);
}
