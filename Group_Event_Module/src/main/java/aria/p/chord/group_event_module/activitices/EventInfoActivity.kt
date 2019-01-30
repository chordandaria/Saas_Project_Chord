package aria.p.chord.group_event_module.activitices

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.view.View
import aria.p.chord.group_event_module.R
import aria.p.chord.group_event_module.fragments.EventInfoFragment
import aria.p.chord.group_event_module.fragments.EventSignFragment
import aria.p.chord.group_event_module.viewmodule.EventInfoViewModule
import aria.p.chord.myutilslibrary.BaseActivity
import kotlinx.android.synthetic.main.activity_event_info.*

class EventInfoActivity : BaseActivity() {
    private var viewModule:EventInfoViewModule?=null
    private val info:EventInfoFragment= EventInfoFragment()
    private val sign:EventSignFragment= EventSignFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event_info)
        viewModule=ViewModelProviders.of(this).get(EventInfoViewModule::class.java)
        viewModule!!.pos.observe(this, Observer {
            when(it){
                1->supportFragmentManager.beginTransaction().replace(R.id.fl_event,info).commit()
                2->supportFragmentManager.beginTransaction().replace(R.id.fl_event,sign).commit()
            }
        })
        setBackButton(View.OnClickListener {
            when(viewModule!!.pos.value){
                1->finish()
                2->viewModule!!.pos.value=1
            }
        })
        viewModule!!.initViewModule(this)
        viewModule!!.requestInfo(intent.getIntExtra("id",-1))
    }
}
