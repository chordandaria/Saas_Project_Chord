package aria.p.chord.myutilslibrary;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;

public class MyActionBar extends LinearLayout {
    public MyActionBar(Context context) {
        super(context);
    }

    public MyActionBar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyActionBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void init() {

    }
}
