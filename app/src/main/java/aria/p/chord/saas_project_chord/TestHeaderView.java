package aria.p.chord.saas_project_chord;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Create by Chord on 2019/7/9
 */
public class TestHeaderView extends LinearLayout {
    private TextView keyView;
    private TextView valueView;
    private Context context;

    public TestHeaderView(Context context) {
        super(context);
        this.context = context;
        initView(context);
    }

    public TestHeaderView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        initView(context);
        initAttrs(context,attrs);
    }

    public TestHeaderView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        initView(context);
        initAttrs(context,attrs);
    }

    public TestHeaderView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        this.context = context;
        initView(context);
        initAttrs(context,attrs);
    }

    private void initView(Context context) {
        LayoutInflater.from(context).inflate(R.layout.view_header_bar,this,true);
        keyView = findViewById(R.id.tv_key);
        valueView = findViewById(R.id.tv_value);
    }

    private void initAttrs(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs,R.styleable.TestHeaderView);
        String keyStr = typedArray.getString(R.styleable.TestHeaderView_key_text);
        if (!TextUtils.isEmpty(keyStr)){
            keyView.setText(keyStr);
        }

        String valueStr = typedArray.getString(R.styleable.TestHeaderView_value_text);
        if (!TextUtils.isEmpty(valueStr)){
            valueView.setText(valueStr);
        }

        keyView.setTextColor(typedArray.getColor(R.styleable.TestHeaderView_key_text_color, Color.BLACK));
        valueView.setTextColor(typedArray.getColor(R.styleable.TestHeaderView_value_text_color,Color.BLACK));
    }

    public void setKey(String s) {
        keyView.setText(s);
    }

    public void setValue(String s) {
        valueView.setText(s);
    }
}
