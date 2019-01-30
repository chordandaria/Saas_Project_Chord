package aria.p.chord.group_event_module

import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import aria.p.chord.group_event_module.adapters.EventMainPagerAdapter
import aria.p.chord.group_event_module.fragments.EventAllFragment
import aria.p.chord.group_event_module.fragments.EventOnActiveFragment
import aria.p.chord.group_event_module.fragments.EventOutActiveFragment
import aria.p.chord.group_event_module.viewmodule.EventListViewModule
import aria.p.chord.myutilslibrary.BaseActivity
import kotlinx.android.synthetic.main.activity_group_event.*

class GroupEventActivity : BaseActivity() {
    private var fragments= arrayListOf<Fragment>()
    private var titles= arrayListOf<String>()
    private var mAdapter:EventMainPagerAdapter?=null
    private var viewModule:EventListViewModule?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_group_event)
        setBackButton()
        setActoinBarTitle("团体活动")
        viewModule=ViewModelProviders.of(this).get(EventListViewModule::class.java)
        viewModule!!.initViewModele(this)
        titles.add("全部")
        titles.add("进行中")
        titles.add("已结束")
        fragments.add(EventAllFragment())
        fragments.add(EventOnActiveFragment())
        fragments.add(EventOutActiveFragment())
        mAdapter=EventMainPagerAdapter(supportFragmentManager,fragments,titles)
        fl_event.adapter=mAdapter
        tab_event.setupWithViewPager(fl_event)
        sr_refresh.setOnRefreshListener {
            refresh(tab_event.selectedTabPosition)
            sr_refresh.finishRefresh()
        }
        sr_refresh.setOnLoadMoreListener {
            load(tab_event.selectedTabPosition)
            sr_refresh.finishLoadMore()
        }

    }
    fun refresh(pos:Int){
        when(pos){
            0->{
                var all:EventAllFragment= fragments[pos] as EventAllFragment
                all.refreshList()
            }
            1->{
                var active=fragments[pos] as EventOnActiveFragment
                active.refreshList()
            }
            2->{
                var inactive=fragments[pos] as EventOutActiveFragment
                inactive.refreshList()
            }
        }
    }
    fun load(pos: Int){
        when(pos){
            0->{
                var all:EventAllFragment= fragments[pos] as EventAllFragment
                all.loadList()
            }
            1->{
                var active=fragments[pos] as EventOnActiveFragment
                active.loadList()
            }
            2->{
                var inactive=fragments[pos] as EventOutActiveFragment
                inactive.loadList()
            }
        }
    }
}
