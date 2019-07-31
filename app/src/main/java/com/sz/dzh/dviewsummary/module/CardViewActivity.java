package com.sz.dzh.dviewsummary.module;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.sz.dzh.dviewsummary.R;
import com.sz.dzh.dviewsummary.adapter.CardViewAdapter;
import com.sz.dzh.dviewsummary.base.BaseActivity;
import com.sz.dzh.dviewsummary.bean.CardViewBean;
import com.sz.dzh.dviewsummary.utils.recyclerView.OnLoadMoreListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Dengzh
 * CardView、RecyclerView、SwipeRefreshLayout的演示
 * 1.知道这三个是什么东西，能做什么效果。
 * 2.简单的使用方式。
 *
 * 注意：
 * 1.CardView 是带圆角和阴影的布局。
 * 2.SwipeRefreshLayout做加载，可以考虑监听子View的滚动情况来做。
 */
public class CardViewActivity extends BaseActivity {

    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    @BindView(R.id.refreshLayout)
    SwipeRefreshLayout mRefreshLayout;

    private CardViewAdapter mAdapter;
    private List<CardViewBean> mList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_card_view);
        ButterKnife.bind(this);
        initToolBar("CardView");
        initView();
    }

    private void initView(){
        for (int i=0;i<10;i++){
            mList.add(new CardViewBean("描述" + i));
        }

        //Adapter
        mAdapter = new CardViewAdapter(this,mList);

        //recyclerView
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.addOnScrollListener(new OnLoadMoreListener() {
            @Override
            protected void onLoading(int countItem, int lastItem) {
                handleLoadMore();
            }
        });
        //SwipeRefreshLayout
        initSwipeRefreshLayout();
    }

    /**
     * SwipeRefreshLayout
     * 系统提供的下拉刷新控件，可以设置刷新的样式。
     */
    private void initSwipeRefreshLayout(){

        //下拉刷新的圆圈是否显示
        mRefreshLayout.setRefreshing(false);

        //设置下拉时圆圈的颜色（可以由多种颜色拼成）
        mRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_light,
                android.R.color.holo_red_light,
                android.R.color.holo_orange_light);

        //设置下拉时圆圈的背景颜色（这里设置成白色）
        mRefreshLayout.setProgressBackgroundColorSchemeResource(android.R.color.white);

        //设置下拉刷新时的操作
        mRefreshLayout.setOnRefreshListener(() -> {
            handleRefresh();
        });
    }

    /**
     * 刷新——模拟网络请求
     */
    private void handleRefresh(){
        new Thread(() -> {
            try {
                Thread.sleep(2000);
                mList.clear();
                for (int i=0;i<10;i++){
                    mList.add(new CardViewBean("刷新" + i));
                }
                runOnUiThread(() -> {
                    mRefreshLayout.setRefreshing(false);
                    mAdapter.notifyDataSetChanged();
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    /**
     * 加载——模拟网络请求
     */
    private void handleLoadMore(){
        new Thread(() -> {
            try {
                Thread.sleep(2000);
                for (int i=10;i<20;i++){
                    mList.add(new CardViewBean("加载" + i));
                }
                runOnUiThread(() -> mAdapter.notifyDataSetChanged());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
