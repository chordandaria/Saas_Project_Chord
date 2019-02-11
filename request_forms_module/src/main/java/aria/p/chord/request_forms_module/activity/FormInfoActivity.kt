package aria.p.chord.request_forms_module.activity

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import aria.p.chord.myutilslibrary.BaseActivity
import aria.p.chord.request_forms_module.R
import aria.p.chord.request_forms_module.adapter.FormInfoPagerAdapter
import aria.p.chord.request_forms_module.fragments.FormFragment
import aria.p.chord.request_forms_module.fragments.FormInfoFragment
import aria.p.chord.request_forms_module.viewmodule.InfoViewModule
import kotlinx.android.synthetic.main.activity_form_info.*

class FormInfoActivity : BaseActivity() {
    private var fragments= arrayListOf<Fragment>()
    private var viewModule:InfoViewModule?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_info)
        viewModule=ViewModelProviders.of(this).get(InfoViewModule::class.java)
        viewModule!!.initViewModule(this)
        viewModule!!.requestInfo(intent.getIntExtra("id",-1))
        fragments.add(FormInfoFragment())
        fragments.add(FormFragment())
        vp_form.setNoScroll(false)
        vp_form.adapter=FormInfoPagerAdapter(supportFragmentManager,fragments)

    }
}
