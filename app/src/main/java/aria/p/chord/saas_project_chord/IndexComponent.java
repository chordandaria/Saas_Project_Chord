package aria.p.chord.saas_project_chord;


import javax.inject.Singleton;

import aria.p.chord.myutilslibrary.module.RetrofitModule;
import dagger.Component;

/**
 * Create by Chord on 2019/6/17
 */
@Singleton
@Component(modules = RetrofitModule.class)
public interface IndexComponent {
    void inject(IndexActivity indexActivity);
}

