package aria.p.chord.saas_project_chord

import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.util.Log
import aria.p.chord.myutilslibrary.BaseActivity
import aria.p.chord.saas_project_chord.adapters.IndexViewPagerAdapter

import aria.p.chord.saas_project_chord.fragments.IndexFragment
import aria.p.chord.saas_project_chord.fragments.InfoFragment
import aria.p.chord.myutilslibrary.ShareHelper
import aria.p.chord.saas_project_chord.viewmodel.IndexViewModel
import kotlinx.android.synthetic.main.activity_index.*;


class IndexActivity : BaseActivity() {
    private var fragments: ArrayList<Fragment> = ArrayList<Fragment>()
    private var titles:ArrayList<String> = ArrayList<String>()
    private var mAdapter: IndexViewPagerAdapter? = null
    private var viewModel: IndexViewModel? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_index)
        titles.add("首页")
        titles.add("个人信息")
        setActoinBarTitle(titles[0])
        var fg_index=IndexFragment()
        var fg_info=InfoFragment()
        viewModel = ViewModelProviders.of(this).get(IndexViewModel::class.java)
        viewModel!!.initViewModel(this)
        fragments.add(fg_index)
        fragments.add(fg_info)
        mAdapter= IndexViewPagerAdapter(supportFragmentManager,fragments,titles)
        vp_index.adapter=mAdapter
        tl_index.setupWithViewPager(vp_index)
        if (!ShareHelper(this).checkLogined()) {
            startActivity(Intent(this@IndexActivity,LoginActivity::class.java))
        }else{
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


    }
}
