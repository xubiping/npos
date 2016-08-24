package com.online.goods.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.EditText;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.event.OnClick;
import com.online.goods.R;
import com.online.goods.api.ApiRequest;
import com.online.goods.api.OutPut;
import com.online.goods.fragment.HomeFragment;
import com.online.goods.fragment.HomeQuickFragment;
import com.online.goods.util.ToastUtils;

public class LoginActivity extends BaseActivity{
    private String username;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        ViewUtils.inject(this);
        ToastUtils.init(this);
    }

    public Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Bundle data = msg.getData();
            String val = data.getString("value");
            OutPut outPut = new OutPut();
            outPut.format(val);
            if(outPut.getCode()>0) {
                goPage();
            }else{
                ToastUtils.show(outPut.getTip());
            }
        }
    };

    Runnable runnable = new Runnable(){
        @Override
        public void run() {
            // TODO: http request.
            ApiRequest req = new ApiRequest();
            String val = req.login(username, password, "012345678");
            Message msg = new Message();
            Bundle data = new Bundle();
            data.putString("value",val);
            msg.setData(data);
            handler.sendMessage(msg);
        }
    };

    private void posLogin(){
        EditText et_pos_user = (EditText) this.findViewById(R.id.et_username);
        EditText et_pos_pwd = (EditText) this.findViewById(R.id.et_password);
        username = et_pos_user.getText().toString();
        password = et_pos_pwd.getText().toString();
        if(username.isEmpty()){
            ToastUtils.show("用户名不能为空");
            return;
        }

        if(username.length()<4){
            ToastUtils.show("用户名长度小于4");
            return;
        }

        if(password.isEmpty()){
            ToastUtils.show("密码不能为空");
            return;
        }

        if(password.length()<6){
            ToastUtils.show("密码长度小于6");
            return;
        }

        new Thread(runnable).start();
    }

    @OnClick({R.id.btn_pos_login})
    private void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_pos_login:
                posLogin();
                break;
            default:
                break;
        }
    }

    private void goPage(){
        Intent intent = new Intent(this, HomeActivity.class);
        /**
         * Intent.FLAG_ACTIVITY_CLEAR_TOP:如果在当前Task中，有要启动的Activity，
         * 那么把该Acitivity之前的所有Activity都关掉，并把此Activity置前以避免创建Activity的实例
         */
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}
