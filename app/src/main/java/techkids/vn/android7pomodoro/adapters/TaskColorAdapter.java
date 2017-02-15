package techkids.vn.android7pomodoro.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import techkids.vn.android7pomodoro.R;
import techkids.vn.android7pomodoro.adapters.viewholders.TaskColorViewHolder;
import techkids.vn.android7pomodoro.databases.models.TaskColor;

/**
 * Created by huynq on 2/15/17.
 */

public class TaskColorAdapter extends RecyclerView.Adapter<TaskColorViewHolder> {

    @Override
    public TaskColorViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.item_task_color, parent, false);
        return new TaskColorViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(TaskColorViewHolder holder, int position) {
        String color = TaskColor.COLORS[position];
        holder.bind(color);
    }

    @Override
    public int getItemCount() {
        return TaskColor.COLORS.length;
    }
}
