package com.sz.dzh.dviewsummary.module.v5_6_view;


import android.os.Bundle;
import androidx.annotation.Nullable;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.sz.dzh.dviewsummary.R;
import com.sz.dzh.dviewsummary.base.BaseActivity;
import com.sz.dzh.dviewsummary.base.BaseListAdapter;
import com.sz.dzh.dviewsummary.bean.ClazzBean;
import com.sz.dzh.dviewsummary.module.ConstraintActivity;
import com.sz.dzh.dviewsummary.module.v5_6_view.coordinator.CoordinatorLayoutActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Android 5.0 6.0新增控件
 */
public class V5ViewListActivity extends BaseActivity {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.tv_desc)
    TextView tvDesc;

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

    private void initData() {

        addClazzBean("ConstraintLayout", ConstraintActivity.class);
        addClazzBean("ToolBar", ToolBarActivity.class);
        addClazzBean("CardView、SwipeRefreshLayout", CardViewActivity.class);
        addClazzBean("FloatingActionBtn", FABAndSnackBarActivity.class);
        addClazzBean("NavigationView", NavigationViewActivity.class);
        addClazzBean("TextInputLayout、TextInputEt", TextInputLtActivity.class);
        addClazzBean("TabLayout", TabLayoutActivity.class);
        addClazzBean("折叠布局", CoordinatorLayoutActivity.class);

    }

    private void initView() {
        tvDesc.setText("Android 5.0、6.0新增控件");

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


    protected void addClazzBean(String name, Class clazz) {
        mList.add(new ClazzBean(name, clazz));
    }

}
