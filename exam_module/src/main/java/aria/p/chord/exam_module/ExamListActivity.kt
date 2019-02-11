package aria.p.chord.exam_module

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import aria.p.chord.myutilslibrary.BaseActivity

class ExamListActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exam_list)
        setActoinBarTitle("知识闯关")
        setBackButton()
    }
}
