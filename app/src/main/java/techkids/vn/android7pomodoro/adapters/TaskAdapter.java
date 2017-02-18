package techkids.vn.android7pomodoro.adapters;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import techkids.vn.android7pomodoro.R;
import techkids.vn.android7pomodoro.adapters.viewholders.TaskViewHolder;
import techkids.vn.android7pomodoro.databases.DbContext;
import techkids.vn.android7pomodoro.databases.models.Task;

/**
 * Created by huynq on 2/8/17.
 */

public class TaskAdapter extends RecyclerView.Adapter<TaskViewHolder> {

    private static final String TAG = "TaskAdapter";

    public interface TaskItemClickListener {
        void onItemClick(Task task);
    }

    public interface TaskTimerListener {
        void onStart(Task task);
    }

    private TaskItemClickListener taskItemClickListener;
    private TaskTimerListener taskTimerListener;

    public void setTaskItemClickListener(TaskItemClickListener taskItemClickListener) {
        this.taskItemClickListener = taskItemClickListener;
    }

    public void setTaskTimerListener(TaskTimerListener taskTimerListener) {
        this.taskTimerListener = taskTimerListener;
    }

    @Override
    public TaskViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //1: Create View
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.item_task, parent, false);

        //2: Create ViewHolder
        TaskViewHolder taskViewHolder = new TaskViewHolder(itemView);
        return taskViewHolder;
    }

    @Override
    public void onBindViewHolder(TaskViewHolder holder, final int position) {
        //1: Get data based on position
        final Task task = DbContext.instance.allTasks().get(position);

        //2: Bind data into view
        holder.bind(task);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // send event to outside
                if (taskItemClickListener != null) {
                    taskItemClickListener.onItemClick(task);
                }
            }
        });

        Log.d(TAG, "onBindViewHolder:");

        holder.ibStartTimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: ibStartTimer");
                if(taskTimerListener != null) {
                    taskTimerListener.onStart(task);
                }
            }
        });

        holder.vTaskColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                task.flipDone();
//                notifyDataSetChanged();
                TaskAdapter.this.notifyItemChanged(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return DbContext.instance.allTasks().size();
    }
}
