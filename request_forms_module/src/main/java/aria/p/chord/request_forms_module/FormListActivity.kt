package aria.p.chord.request_forms_module

import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import aria.p.chord.myutilslibrary.BaseActivity
import aria.p.chord.request_forms_module.adapter.FormListPagerAdapter
import aria.p.chord.request_forms_module.fragments.ActiveFragment
import aria.p.chord.request_forms_module.fragments.InactiveFragment
import aria.p.chord.request_forms_module.fragments.TotalFragment
import aria.p.chord.request_forms_module.viewmodule.ListViewModule
import kotlinx.android.synthetic.main.activity_form_list.*

class FormListActivity : BaseActivity() {
    private var fragments = arrayListOf<Fragment>()
    private var viewModule:ListViewModule?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_list)
        setBackButton()
        setActoinBarTitle("问卷调查")
        viewModule=ViewModelProviders.of(this).get(ListViewModule::class.java)
        viewModule!!.initViewModule(this)
        fragments.add(TotalFragment())
        fragments.add(ActiveFragment())
        fragments.add(InactiveFragment())
        fl_form.adapter=FormListPagerAdapter(supportFragmentManager,fragments)
        tab_form.setupWithViewPager(fl_form)



    }
}
