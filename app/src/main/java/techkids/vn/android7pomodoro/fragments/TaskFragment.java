package techkids.vn.android7pomodoro.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import techkids.vn.android7pomodoro.R;
import techkids.vn.android7pomodoro.activities.TaskActivity;
import techkids.vn.android7pomodoro.adapters.TaskAdapter;
import techkids.vn.android7pomodoro.databases.DbContext;
import techkids.vn.android7pomodoro.databases.models.Task;
import techkids.vn.android7pomodoro.fragments.strategies.AddTaskAction;
import techkids.vn.android7pomodoro.fragments.strategies.EditTaskAction;
import techkids.vn.android7pomodoro.networks.NetContext;
import techkids.vn.android7pomodoro.networks.jsonmodels.TaskJson;
import techkids.vn.android7pomodoro.networks.services.TaskService;

/**
 * A simple {@link Fragment} subclass.
 */
public class TaskFragment extends Fragment {

    @BindView(R.id.rv_task)
    RecyclerView rvTask;

    private TaskAdapter taskAdapter;

    private static String TAG = "TaskFragment";


    public TaskFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_task, container, false);
        setupUI(view);
        downloadTasks();
        return view;
    }

    private void downloadTasks() {
        NetContext.instance
                .create(TaskService.class)
                .getAllTasks()
                .enqueue(new Callback<List<TaskJson>>() {
                    @Override
                    public void onResponse(Call<List<TaskJson>> call, Response<List<TaskJson>> response) {
                        List<TaskJson> taskJsonList = response.body();
                        if (taskJsonList != null) {
                            DbContext.instance.clearAllTasks();
                            for (TaskJson taskJson : taskJsonList) {
                                Task newTask = new Task(
                                        taskJson.getName(),
                                        taskJson.getColor(),
                                        (float) taskJson.getPaymentPerHour()
                                );
                                DbContext.instance.addTask(newTask);
                                taskAdapter.notifyDataSetChanged();
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<List<TaskJson>> call, Throwable t) {
                        Log.d(TAG, "onFailure: ");
                    }
                });
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

    }

    private void setupUI(View view) {
        ButterKnife.bind(this, view);

        taskAdapter = new TaskAdapter();
        rvTask.setAdapter(taskAdapter);
        rvTask.setLayoutManager(new LinearLayoutManager(this.getContext()));

        taskAdapter.setTaskItemClickListener(new TaskAdapter.TaskItemClickListener() {
            @Override
            public void onItemClick(Task task) {
                Log.d(TAG, String.format("onItemClick: %s", task));
                TaskDetailFragment taskDetailFragment = new TaskDetailFragment();

                taskDetailFragment.setTitle("Edit task");
                taskDetailFragment.setTask(task);
                taskDetailFragment.setTaskAction(new EditTaskAction());

                //TODO: Make TaskActivity and Fragment independent
                ((TaskActivity) getActivity()).replaceFragment(taskDetailFragment, true);
            }
        });

        taskAdapter.setTaskTimerListener(new TaskAdapter.TaskTimerListener() {
            @Override
            public void onStart(Task task) {
                Log.d(TAG, "onStart: starting timer");
                ((TaskActivity) getActivity()).replaceFragment(new TimerFragment(), true);
            }
        });

        AppCompatActivity appCompatActivity = (AppCompatActivity) getActivity();
        appCompatActivity.getSupportActionBar().setTitle(R.string.tasks);

        //menu options

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this.getContext(), DividerItemDecoration.VERTICAL);
        rvTask.addItemDecoration(dividerItemDecoration);

        setHasOptionsMenu(true);
    }

    @OnClick(R.id.fab)
    void onFabClick() {
        TaskDetailFragment taskDetailFragment = new TaskDetailFragment();
        taskDetailFragment.setTitle("Add new task");
        taskDetailFragment.setTaskAction(new AddTaskAction());

        //TODO: Make TaskActivity and Fragment independent
        ((TaskActivity) getActivity()).replaceFragment(taskDetailFragment, true);
    }
}
