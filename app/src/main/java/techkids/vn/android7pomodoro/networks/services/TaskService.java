package techkids.vn.android7pomodoro.networks.services;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import techkids.vn.android7pomodoro.databases.models.Task;
import techkids.vn.android7pomodoro.networks.jsonmodels.TaskJson;

/**
 * Created by huynq on 2/22/17.
 */

public interface TaskService {
    @GET("task")
    Call<List<TaskJson>> getAllTasks();
}
