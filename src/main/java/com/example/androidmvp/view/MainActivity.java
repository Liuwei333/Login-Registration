package com.example.androidmvp.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.androidmvp.R;
import com.example.androidmvp.bean.DengBean;
import com.example.androidmvp.presenter.MyPresenter;
import com.example.androidmvp.presenter.MyPresenterView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements LogView {


    @BindView(R.id.name)
    EditText name;
    @BindView(R.id.pass)
    EditText pass;
    @BindView(R.id.btn)
    Button btn;
    @BindView(R.id.zhu)
    Button zhu;
    private MyPresenterView myPresenterView;
    private String s;
    private String s1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        //接受值
        Intent intent = getIntent();
        String zhuName = intent.getStringExtra("name");
        String zhuPass = intent.getStringExtra("pass");
        name.setText(zhuName);
        pass.setText(zhuPass);

        //点击注册跳转
        zhu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ZhuCeActivity.class);
                startActivity(intent);
            }
        });

        //登陆点击事件
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //输入的值
                s = MainActivity.this.name.getText().toString();
                s1 = MainActivity.this.pass.getText().toString();

                //p城进行值得传入
                myPresenterView = new MyPresenter(MainActivity.this);
                myPresenterView.setNet(s, s1);
            }
        });
    }

    public void toBackView(DengBean bean) {

        if (bean != null) {
            String msg = bean.getMsg();
            //判断
            if (msg.equals("登录成功")) {
                Toast.makeText(MainActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this, "登录失败", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(MainActivity.this, "空", Toast.LENGTH_SHORT).show();
        }

    }

    //解除

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (myPresenterView != null) {
            myPresenterView.onDetory();
            myPresenterView = null;
            System.gc();
        }
    }
}
