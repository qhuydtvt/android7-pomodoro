package techkids.vn.android7pomodoro.adapters.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import techkids.vn.android7pomodoro.R;
import techkids.vn.android7pomodoro.utils.Utils;

/**
 * Created by huynq on 2/15/17.
 */
public class TaskColorViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.v_task_color)
    View vTaskColor;

    @BindView(R.id.iv_check)
    ImageView ivCheck;


    public TaskColorViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(String color) {
        Utils.setSolidColor(vTaskColor, color);
    }

    public void setCheck(boolean check) {
        if(check) {
            ivCheck.setVisibility(View.VISIBLE);
        } else {
            ivCheck.setVisibility(View.INVISIBLE);
        }
    }
}
