package aria.p.chord.saas_project_chord.common_utils;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.zackratos.ultimatebar.UltimateBar;
import aria.p.chord.saas_project_chord.R;

public abstract class BaseActivity extends AppCompatActivity {
    private  android.support.v7.app.ActionBar actionBar;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        actionBar=getSupportActionBar();
        UltimateBar.newColorBuilder()
                .applyNav(false)
                .statusColor(getColor(R.color.red_holo))
                .build(this)
                .apply();
        actionBar.setBackgroundDrawable(getDrawable(R.drawable.my_actionbar));
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        actionBar.setCustomView(R.layout.my_actionbar);


    }

    public void setActoinBarTitle(String t) {
        TextView title=actionBar.getCustomView().findViewById(R.id.txt_title);
        title.setText(t);
    }

    public void setBackButton(View.OnClickListener listener) {
        ImageView backBtn=actionBar.getCustomView().findViewById(R.id.iv_back);
        backBtn.setVisibility(View.VISIBLE);
        backBtn.setOnClickListener(listener);
    }


}
