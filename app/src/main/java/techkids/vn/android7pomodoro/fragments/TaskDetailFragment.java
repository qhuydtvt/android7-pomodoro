package techkids.vn.android7pomodoro.fragments;


import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import techkids.vn.android7pomodoro.R;
import techkids.vn.android7pomodoro.activities.TaskActivity;
import techkids.vn.android7pomodoro.adapters.TaskColorAdapter;
import techkids.vn.android7pomodoro.databases.DbContext;
import techkids.vn.android7pomodoro.databases.models.Task;
import techkids.vn.android7pomodoro.decorations.TaskColorDecor;

/**
 * A simple {@link Fragment} subclass.
 */
public class TaskDetailFragment extends Fragment {

    private static String TAG = "TaskDetailFragment";

    @BindView(R.id.rv_task_color)
    RecyclerView rvTaskColor;

    @BindView(R.id.et_task_name)
    EditText etTaskName;

    @BindView(R.id.et_payment_per_hour)
    EditText etPaymentPerHour;

    private TaskColorAdapter taskColorAdapter;

    private String title;
    private Task task;

    public TaskDetailFragment() {
        // Required empty public constructor
        setHasOptionsMenu(true);
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_task_detail, container, false);
        setupUI(view);
        return view;
    }

    private void setupUI(View view) {
        ButterKnife.bind(this, view);

        taskColorAdapter = new TaskColorAdapter();

        rvTaskColor.setLayoutManager(new GridLayoutManager(this.getContext(), 4));
        rvTaskColor.setAdapter(taskColorAdapter);
        rvTaskColor.addItemDecoration(new TaskColorDecor());

        if(getActivity() instanceof TaskActivity) {
            ((TaskActivity) getActivity()).getSupportActionBar().setTitle(title);
        }

        if (task != null) {
            // Edit
            etTaskName.setText(task.getName());
            etPaymentPerHour.setText(String.format("%.1f", task.getPaymentPerHour()));
            taskColorAdapter.setSelectedColor(task.getColor());
        }
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_edit_task, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Log.d(TAG, "onOptionsItemSelected: ");

        if (item.getItemId() == R.id.mni_ok) {
            Log.d(TAG, "onOptionsItemSelected: OK clicked");

            // 1: Get data from UI
            String taskName = etTaskName.getText().toString();
            float paymentPerHour = Float.parseFloat(etPaymentPerHour.getText().toString());
            String color = taskColorAdapter.getSelectedColor();



//            // 2: Create new TASK
//            Task newTask = new Task(taskName, color, paymentPerHour);
//
//            // 3: Add to database
//            DbContext.instance.addTask(newTask);

            getActivity().onBackPressed();
        }
        return false;
    }
}
