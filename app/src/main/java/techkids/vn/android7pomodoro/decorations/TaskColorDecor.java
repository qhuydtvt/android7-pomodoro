package techkids.vn.android7pomodoro.decorations;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by huynq on 2/15/17.
 */

public class TaskColorDecor extends RecyclerView.ItemDecoration {

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.top = 16;
        outRect.right = 16;
    }
}
