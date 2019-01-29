package aria.p.chord.group_event_module

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import aria.p.chord.group_event_module.adapters.EventMainPagerAdapter
import aria.p.chord.group_event_module.fragments.EventAllFragment
import aria.p.chord.group_event_module.fragments.EventOnActiveFragment
import aria.p.chord.group_event_module.fragments.EventOutActiveFragment
import aria.p.chord.myutilslibrary.BaseActivity
import kotlinx.android.synthetic.main.activity_group_event.*

class GroupEventActivity : BaseActivity() {
    private var fragments= arrayListOf<Fragment>()
    private var titles= arrayListOf<String>()
    private var mAdapter:EventMainPagerAdapter?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_group_event)
        setBackButton()
        setActoinBarTitle("团体活动")
        titles.add("全部")
        titles.add("进行中")
        titles.add("已结束")
        fragments.add(EventAllFragment())
        fragments.add(EventOnActiveFragment())
        fragments.add(EventOutActiveFragment())
        mAdapter=EventMainPagerAdapter(supportFragmentManager,fragments,titles)
        fl_event.adapter=mAdapter
        tab_event.setupWithViewPager(fl_event)
    }
}
