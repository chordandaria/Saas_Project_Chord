package aria.p.chord.saas_project_chord;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import com.github.zackratos.ultimatebar.UltimateBar;

/**
 * Create by Chord on 2019/6/17
 */
public class CommonApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle bundle) {
                UltimateBar.newColorBuilder()
                        .applyNav(false)
                        .statusColor(getColor(aria.p.chord.myutilslibrary.R.color.red_holo))
                        .build(activity)
                        .apply();
            }

            @Override
            public void onActivityStarted(Activity activity) {

            }

            @Override
            public void onActivityResumed(Activity activity) {

            }

            @Override
            public void onActivityPaused(Activity activity) {

            }

            @Override
            public void onActivityStopped(Activity activity) {

            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {

            }

            @Override
            public void onActivityDestroyed(Activity activity) {

            }
        });
    }
}
