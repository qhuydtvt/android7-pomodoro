package techkids.vn.android7pomodoro.adapters.viewholders;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import techkids.vn.android7pomodoro.R;
import techkids.vn.android7pomodoro.databases.models.Task;
import techkids.vn.android7pomodoro.utils.Utils;

/**
 * Created by huynq on 2/8/17.
 */

public class TaskViewHolder extends RecyclerView.ViewHolder {

    private static final String DEFAULT_COLOR = "#0000FF";
    @BindView(R.id.v_task_color)
    public View vTaskColor;

    @BindView(R.id.tv_task_name)
    public TextView tvTaskName;

    @BindView(R.id.ib_start_timer)
    public ImageButton ibStartTimer;

    @BindView(R.id.iv_check)
    ImageView ivCheck;

    public TaskViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(Task task) {
        //1: Bind Color
//        vTaskColor.setBackgroundColor(Color.parseColor(task.getColor()));
        if (task.getColor() != null) {
            Utils.setSolidColor(vTaskColor, task.getColor());
        }else {
            Utils.setSolidColor(vTaskColor, DEFAULT_COLOR);
        }

        //2: Bind Task name
        tvTaskName.setText(task.getName());

        if(task.isDone()) {
            ivCheck.setVisibility(View.VISIBLE);
        } else {
            ivCheck.setVisibility(View.INVISIBLE);
        }
    }
}
