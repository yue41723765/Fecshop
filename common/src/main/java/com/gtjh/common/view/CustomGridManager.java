package com.gtjh.common.view;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.util.AttributeSet;

/**
 * Created by android on 2018/8/6.
 */

public class CustomGridManager extends GridLayoutManager {
    private boolean isScrollEnabled = true;

    public CustomGridManager(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public CustomGridManager(Context context, int spanCount) {
        super(context, spanCount);
    }

    public CustomGridManager(Context context, int spanCount, int orientation, boolean reverseLayout) {
        super(context, spanCount, orientation, reverseLayout);
    }

    public void setScrollEnabled(boolean flag) {
        this.isScrollEnabled = flag;
    }

    @Override
    public boolean canScrollVertically() {
       // return super.canScrollVertically();
        return isScrollEnabled && super.canScrollVertically();
    }
}
