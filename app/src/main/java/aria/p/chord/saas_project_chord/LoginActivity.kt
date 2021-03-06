package aria.p.chord.saas_project_chord

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.LocalBroadcastManager
import android.view.View
import aria.p.chord.myutilslibrary.BaseActivity
import aria.p.chord.myutilslibrary.ShareHelper
import aria.p.chord.saas_project_chord.Constants.retrofit
import aria.p.chord.saas_project_chord.bean.LoginBean
import aria.p.chord.saas_project_chord.interfaces.PostLogin_Interface
import kotlinx.android.synthetic.main.activity_login.*
import org.greenrobot.eventbus.EventBus
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : BaseActivity() {
    private var localBroadcastManager:LocalBroadcastManager?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        setActoinBarTitle("登录")
        localBroadcastManager= LocalBroadcastManager.getInstance(this@LoginActivity)
        btn_login.setOnClickListener(View.OnClickListener { login() })

    }

    fun login(){
        var request : PostLogin_Interface=retrofit.create(PostLogin_Interface::class.java)
        var call : Call<LoginBean> = request.getCall(et_account.text.toString().trim(),et_password.text.toString().trim(),"email-password")
        call.enqueue(object : Callback<LoginBean>{
            override fun onResponse(call: Call<LoginBean>?, response: Response<LoginBean>?) {
                if (response!!.body().isSuccess&&response!!.body().status==200){
                    ShareHelper(this@LoginActivity).auth=response.body().data.token_type+" "+response.body().data.access_token
                    localBroadcastManager!!.sendBroadcast(Intent("login"))
                    EventBus.getDefault().post("login")
                    finish()
                }
            }

            override fun onFailure(call: Call<LoginBean>?, t: Throwable?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        })
    }

    override fun onBackPressed() {
        var backHome :Intent = Intent(Intent.ACTION_MAIN)
        backHome.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        backHome.addCategory(Intent.CATEGORY_HOME)
        startActivity(backHome)
    }


}
