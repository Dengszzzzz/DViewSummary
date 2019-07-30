package com.sz.dzh.dviewsummary;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.sz.dzh.dviewsummary.base.BaseListAdapter;
import com.sz.dzh.dviewsummary.base.BaseActivity;
import com.sz.dzh.dviewsummary.bean.ClazzBean;
import com.sz.dzh.dviewsummary.module.CardViewActivity;
import com.sz.dzh.dviewsummary.module.ConstraintActivity;
import com.sz.dzh.dviewsummary.module.TestActivity;
import com.sz.dzh.dviewsummary.module.ToolBarActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 *
 */
public class MainActivity extends BaseActivity {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    protected List<ClazzBean> mList = new ArrayList<>();
    protected BaseListAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initData();
        initView();
    }

    private void initData(){
        addClazzBean("ConstraintLayout", ConstraintActivity.class);
        addClazzBean("ToolBar", ToolBarActivity.class);
        addClazzBean("CardView、SwipeRefreshLayout", CardViewActivity.class);
    }

    private void initView(){
        mAdapter = new BaseListAdapter(mList);
        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                startActivity(mList.get(position).getClazz());
            }
        });
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(mAdapter);
    }



    protected void addClazzBean(String name, Class clazz){
        mList.add(new ClazzBean(name,clazz));
    }

}
