package com.bw.com.mvp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;
import com.bw.com.adapter.GoodsAdapter;
import com.bw.com.bean.MyBean;
import com.bw.com.presenter.Mypresenter;
import com.bw.com.view.MyView;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MyView{
    private View view;
    private RecyclerView recyclerView;
    private Mypresenter persenter;
    private GoodsAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        Mypresenter mypresenter=new Mypresenter();
        mypresenter.attachView(this);
        mypresenter.getGoodsList();
    }
    ////绑定布局的方法
    @Override
    public int bindLayout() {
        return R.layout.activity_main;
    }
    private void initView() {
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
    }
    //设置监听的方法
    @Override
    public void bindEvent() {

    }

    @Override
    public void showGoodsData(List<MyBean.ResultsBean> data) {
        adapter = new GoodsAdapter(MainActivity.this,data);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void showError(String error) {
        Toast.makeText(MainActivity.this, error, Toast.LENGTH_SHORT).show();
    }
}
