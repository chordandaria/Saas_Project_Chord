package aria.p.chord.saas_project_chord

import android.arch.lifecycle.ViewModelProviders
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.content.LocalBroadcastManager
import android.util.Log
import android.widget.Toast
import aria.p.chord.myutilslibrary.BaseActivity
import aria.p.chord.saas_project_chord.adapters.IndexViewPagerAdapter

import aria.p.chord.saas_project_chord.fragments.IndexFragment
import aria.p.chord.saas_project_chord.fragments.InfoFragment
import aria.p.chord.myutilslibrary.ShareHelper
import aria.p.chord.saas_project_chord.viewmodel.IndexViewModel
import kotlinx.android.synthetic.main.activity_index.*;
import kotlinx.coroutines.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode


class IndexActivity : BaseActivity() {
    private var fragments: ArrayList<Fragment> = ArrayList<Fragment>()
    private var titles:ArrayList<String> = ArrayList<String>()
    private var mAdapter: IndexViewPagerAdapter? = null
    private var viewModel: IndexViewModel? = null
//    private var localBroadcastManager:LocalBroadcastManager? =null
//    private var localBroadcastReceiver: LocalReceiver? =null
//    private val job = GlobalScope.launch {
//       while(true){
//           if (viewModel == null){
//               delay(2000)
//           }else{
//               viewModel!!.requestIndex()
//               viewModel!!.requestInfo()
//               break
//           }
//       }
//
//    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_index)
    EventBus.getDefault().register(this)
        titles.add("首页")
        titles.add("个人信息")
        setActoinBarTitle(titles[0])
        var fg_index=IndexFragment()
        var fg_info=InfoFragment()
        viewModel = ViewModelProviders.of(this@IndexActivity).get(IndexViewModel::class.java)
        viewModel!!.initViewModel(this@IndexActivity,this@IndexActivity)
        fragments.add(fg_index)
        fragments.add(fg_info)
        mAdapter= IndexViewPagerAdapter(supportFragmentManager,fragments,titles)
        vp_index.adapter=mAdapter
        tl_index.setupWithViewPager(vp_index)

        if (!ShareHelper(this@IndexActivity).checkLogined()) {
            startActivity(Intent(this@IndexActivity,LoginActivity::class.java))
        }else{
//            job.start()
            viewModel!!.requestIndex()
            viewModel!!.requestInfo()
        }
        tl_index.setOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabReselected(p0: TabLayout.Tab?) {
            }

            override fun onTabUnselected(p0: TabLayout.Tab?) {
            }

            override fun onTabSelected(p0: TabLayout.Tab?) {
                setActoinBarTitle(titles[p0!!.position])
            }
        })

//        localBroadcastManager= LocalBroadcastManager.getInstance(this@IndexActivity)
//        localBroadcastReceiver= LocalReceiver()
//        localBroadcastReceiver!!.initReceiver(viewModel)
//        localBroadcastManager!!.registerReceiver(localBroadcastReceiver!!, IntentFilter("login"))

    }

    override fun onBackPressed() {
        var backHome :Intent = Intent(Intent.ACTION_MAIN)
        backHome.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        backHome.addCategory(Intent.CATEGORY_HOME)
        startActivity(backHome)
    }

    override fun onDestroy() {
//        localBroadcastManager!!.unregisterReceiver(localBroadcastReceiver!!)
        EventBus.getDefault().unregister(this)
//        job.cancel()
        super.onDestroy()
    }

    private class LocalReceiver :BroadcastReceiver(){
        private var viewModel:IndexViewModel?=null

        fun initReceiver(viewModel: IndexViewModel?){
            this.viewModel=viewModel
        }

        override fun onReceive(p0: Context?, p1: Intent?) {
            if(p1!!.action.equals("login")){
                viewModel!!.requestIndex()
                viewModel!!.requestInfo()
            }
        }

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public fun onMessage(event : String){
        if (event.equals("login")){
            Toast.makeText(this@IndexActivity,"event",Toast.LENGTH_SHORT).show()
        }
    }

}
