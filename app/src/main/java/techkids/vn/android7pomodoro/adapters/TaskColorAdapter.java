package techkids.vn.android7pomodoro.adapters;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
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

    private int selectedPosition;

    private static String TAG = "TaskColorAdapter";

    @Override
    public TaskColorViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.item_task_color, parent, false);
        return new TaskColorViewHolder(itemView);
    }

    public String getSelectedColor() {
        return TaskColor.COLORS[selectedPosition];
    }

    public void setSelectedColor(String color) {
        selectedPosition = 0;
        for (int colorIndex = 0 ; colorIndex < TaskColor.COLORS.length; colorIndex ++) {
            if (TaskColor.COLORS[colorIndex].equalsIgnoreCase(color)) {
                selectedPosition = colorIndex;
            }
        }

        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(TaskColorViewHolder holder, final int position) {
        String color = TaskColor.COLORS[position];
        holder.bind(color);

        if (selectedPosition == position) {
            // display check mark
            holder.setCheck(true);
        } else {
            holder.setCheck(false);
            // hide check mark
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick:");
                selectedPosition = position;
                notifyDataSetChanged();// request redraw
            }
        });
    }

    @Override
    public int getItemCount() {
        return TaskColor.COLORS.length;
    }
}
