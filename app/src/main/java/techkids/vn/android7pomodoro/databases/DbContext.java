package techkids.vn.android7pomodoro.databases;

import java.util.ArrayList;
import java.util.List;

import techkids.vn.android7pomodoro.databases.models.Task;

/**
 * Created by huynq on 2/8/17.
 */

public class DbContext {

    public static final DbContext instance = new DbContext();

    public List<Task> allTasks() {
        //Fake data (dummy data)
        //1: Create array list
        ArrayList<Task> tasks = new ArrayList<>();

        //2: Add some tassk and return
        tasks.add(new Task("Study recyclerview", "#EF5350"));
        tasks.add(new Task("Practice recyclerview", "#8E24AA"));
        tasks.add(new Task("Practice networking", "#3949AB"));
        tasks.add(new Task("Party End-lectures", "#26C6DA"));
        tasks.add(new Task("Study API", "#D4E157"));

        return tasks;
    }
}
