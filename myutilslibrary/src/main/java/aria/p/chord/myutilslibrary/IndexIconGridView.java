package aria.p.chord.myutilslibrary;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

public class IndexIconGridView extends GridView {
    public IndexIconGridView(Context context) {
        super(context);
    }

    public IndexIconGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public IndexIconGridView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public IndexIconGridView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec=MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
                MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}
