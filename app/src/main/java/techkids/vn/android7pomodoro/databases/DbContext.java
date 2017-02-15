package techkids.vn.android7pomodoro.databases;

import java.util.ArrayList;
import java.util.List;

import techkids.vn.android7pomodoro.databases.models.Task;
import techkids.vn.android7pomodoro.databases.models.TaskColor;

/**
 * Created by huynq on 2/8/17.
 */

public class DbContext {

    public static final DbContext instance = new DbContext();

    ArrayList<Task> tasks;

    public List<Task> allTasks() {
        //Fake data (dummy data)
        //1: Create array list
        if (tasks == null) {
            tasks = new ArrayList<>();

            //2: Add some tassk and return
            tasks.add(new Task("Study recyclerview", TaskColor.COLORS[0], 2.3f));
            tasks.add(new Task("Practice recyclerview", TaskColor.COLORS[1], 1.1f));
            tasks.add(new Task("Practice networking", TaskColor.COLORS[2], 0.5f));
            tasks.add(new Task("Party End-lectures", TaskColor.COLORS[3], 0.9f));
            tasks.add(new Task("Study API", "#D4E157"));
        }

        return tasks;
    }

    public void addTask(Task newTask) {
        tasks.add(newTask);
    }
}
