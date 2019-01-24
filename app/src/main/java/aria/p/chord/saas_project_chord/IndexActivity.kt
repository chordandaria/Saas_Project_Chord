package aria.p.chord.saas_project_chord

import android.os.Bundle
import aria.p.chord.saas_project_chord.common_utils.BaseActivity

class IndexActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_index)
        setActoinBarTitle("首页")
    }
}
