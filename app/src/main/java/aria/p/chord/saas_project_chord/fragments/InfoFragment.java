package aria.p.chord.saas_project_chord.fragments;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import aria.p.chord.myutilslibrary.ShareHelper;
import aria.p.chord.saas_project_chord.R;
import aria.p.chord.saas_project_chord.bean.InfoDataBean;
import aria.p.chord.saas_project_chord.viewmodel.IndexViewModel;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class InfoFragment extends Fragment {
    @BindView(R.id.tv_username)
    TextView username;
    @BindView(R.id.tv_department)
    TextView department;
    @BindView(R.id.tv_mail)
    TextView mail;
    @BindView(R.id.tv_birth)
    TextView birth;
    @BindView(R.id.tv_realname)
    TextView realname;
    @BindView(R.id.tv_phone)
    TextView phone;
    @BindView(R.id.tv_id)
    TextView id;
    @BindView(R.id.tv_sex)
    TextView sex;
    Unbinder unbinder;
    private IndexViewModel viewModel;
    private boolean isLogin;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel= ViewModelProviders.of(getActivity()).get(IndexViewModel.class);
        isLogin=new ShareHelper(getContext()).checkLogined();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=LayoutInflater.from(getContext()).inflate(R.layout.fragment_info,container,false);
        unbinder= ButterKnife.bind(this,view);
        viewModel.getInfoData().observe(this, new Observer<InfoDataBean>() {
            @Override
            public void onChanged(@Nullable InfoDataBean infoDataBean) {
                username.setText(infoDataBean.getUsername());
                department.setText(infoDataBean.getCompanyInfo().getDepartment_string());
                mail.setText(infoDataBean.getCompanyInfo().getEmail());
                phone.setText(infoDataBean.getCompanyInfo().getPhone());
                String[] b=infoDataBean.getCompanyInfo().getBirthday().split(" ");
                birth.setText(b[0]);
                realname.setText(infoDataBean.getCompanyInfo().getName());
                id.setText(String.valueOf(infoDataBean.getCompanyInfo().getId()));
                sex.setText(infoDataBean.getCompanyInfo().getSex());
            }
        });
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
