package com.example.androidmvp.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.androidmvp.R;
import com.example.androidmvp.bean.ZhuBean;
import com.example.androidmvp.presenter.MyPresenter;
import com.example.androidmvp.presenter.MyPresenterView;
import com.example.androidmvp.presenter.ZhuPresenter;
import com.example.androidmvp.presenter.ZhuPresenterView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ZhuCeActivity extends AppCompatActivity implements ZhuView{

    @BindView(R.id.name)
    EditText name;
    @BindView(R.id.pass)
    EditText pass;
    @BindView(R.id.zhu)
    Button zhu;
    private ZhuPresenterView zhuPresenterView;
    private String s;
    private String s1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhu_ce);
        ButterKnife.bind(this);

        //点击事件
        zhu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s = name.getText().toString();
                s1 = pass.getText().toString();
                zhuPresenterView = new ZhuPresenter(ZhuCeActivity.this);
                zhuPresenterView.setNet(s, s1);
            }
        });
    }

    //注册
    @Override
    public void toBackView(ZhuBean value) {
        if(value!=null){

            String msg = value.getMsg();
            Toast.makeText(ZhuCeActivity.this,msg.toString(),Toast.LENGTH_SHORT).show();
            if(msg.equals("注册成功")){
                Intent intent = new Intent(ZhuCeActivity.this,MainActivity.class);
                intent.putExtra("name",s);
                intent.putExtra("pass",s1);
                startActivity(intent);
            }
        }else{
            Toast.makeText(ZhuCeActivity.this,"空的",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(zhuPresenterView!=null){
            zhuPresenterView.onDestory();
            zhuPresenterView=null;
            System.gc();
        }
    }
}
