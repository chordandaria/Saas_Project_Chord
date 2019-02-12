package aria.p.chord.exam_module

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import aria.p.chord.exam_module.adapter.ListPagerAdapter
import aria.p.chord.exam_module.fragment.ActiveFragment
import aria.p.chord.exam_module.fragment.InactiveFragment
import aria.p.chord.exam_module.fragment.TotalFragment
import aria.p.chord.exam_module.viewmodule.ListViewModule
import aria.p.chord.myutilslibrary.BaseActivity
import kotlinx.android.synthetic.main.activity_exam_list.*

class ExamListActivity : BaseActivity() {
    private var fragments= arrayListOf<Fragment>()
    private var viewModule:ListViewModule?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exam_list)
        setActoinBarTitle("知识闯关")
        setBackButton()
        viewModule=ViewModelProviders.of(this).get(ListViewModule::class.java)
        viewModule!!.initViewModule(this)
        fragments.add(TotalFragment())
        fragments.add(ActiveFragment())
        fragments.add(InactiveFragment())
        fl_exam.adapter=ListPagerAdapter(supportFragmentManager,fragments)
        tab_exam.setupWithViewPager(fl_exam)
    }
}
