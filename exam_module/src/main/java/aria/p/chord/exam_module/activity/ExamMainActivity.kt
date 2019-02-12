package aria.p.chord.exam_module.activity


import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import aria.p.chord.exam_module.R
import aria.p.chord.exam_module.adapter.ExamPagerAdapter
import aria.p.chord.exam_module.fragment.ExamFragment
import aria.p.chord.exam_module.fragment.ExamInitFragment
import aria.p.chord.exam_module.viewmodule.ExamViewModule
import aria.p.chord.myutilslibrary.BaseActivity
import kotlinx.android.synthetic.main.activity_exam_main.*

class ExamMainActivity : BaseActivity() {
    private var fragments= arrayListOf<Fragment>()
    private var viewModule:ExamViewModule?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exam_main)
        viewModule=ViewModelProviders.of(this).get(ExamViewModule::class.java)
        viewModule!!.initViewModule(this)
        viewModule!!.requsetInfo(intent.getIntExtra("id",-1))
        fragments.add(ExamInitFragment())
        fragments.add(ExamFragment())
        vp_exam.setNoScroll(false)
        vp_exam.adapter=ExamPagerAdapter(supportFragmentManager,fragments)
        viewModule!!.pos.observe(this, Observer {
            when(it){
                0->vp_exam.setCurrentItem(0,true)
                1->vp_exam.setCurrentItem(1,true)
            }
        })
        setBackButton {
            when(viewModule!!.pos.value){
                0->finish()
                1->viewModule!!.pos.value=0
            }
        }

    }
}
