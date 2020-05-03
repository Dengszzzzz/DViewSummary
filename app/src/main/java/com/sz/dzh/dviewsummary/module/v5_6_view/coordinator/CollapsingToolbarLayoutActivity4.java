package com.sz.dzh.dviewsummary.module.v5_6_view.coordinator;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;
import com.sz.dzh.dviewsummary.R;
import com.sz.dzh.dviewsummary.adapter.MyFrPagerAdapter;
import com.sz.dzh.dviewsummary.base.BaseActivity;
import com.sz.dzh.dviewsummary.base.BaseFragment;
import com.sz.dzh.dviewsummary.bean.TabBean;
import com.sz.dzh.dviewsummary.fragment.SimpleFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Dengzh
 * on 2019/8/1 0001
 * CollapsingToolbarLayout
 * <p>
 * 需求：
 * 1、图片置顶，滚动到顶部，标题栏出现。
 * 2、标题下面的TAB 类似吸附效果。
 * 3、ViewPager + Fragment + RecyclerView
 * <p>
 * 用法：
 * <p>
 * CollapsingToolbarLayout
 * statusBarScrim：状态栏纱布，完全折叠后的状态栏颜色。
 * contentScrim：内容纱布，完全折叠后的背景色。
 * scroll | exitUntilCollapsed：当这个View要往上逐渐“消逝”时，会一直往上滑动，直到剩下的的高度达到它的
 * 最小高度后，再响应ScrollView的内部滑动事件。
 * expandedTitleMarginStart: 完全展开标题的边距
 * <p>
 * ToolBar
 * app:contentInsetStart:边上文字到左边的距离
 * app:layout_collapseMode="pin":折叠后，此布局将固定在顶部。默认“off”，还有“parallax”。
 * <p>
 * NestedScrollView
 * android:fillViewport="true" ,使得子布局撑满整个屏幕。
 */
public class CollapsingToolbarLayoutActivity4 extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.appbar)
    AppBarLayout appbar;
    @BindView(R.id.rl_head)
    RelativeLayout rlHead;
    @BindView(R.id.tabLayout)
    TabLayout mTabLayout;
    @BindView(R.id.viewPager)
    ViewPager viewPager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_collapsing_toolbar_layout4);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        //initToolBar("CollapsingToolbarLayout 简单演示");

        initHeadView();
        initTabAndVp();
    }

    private void initHeadView() {
        appbar.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (verticalOffset <= -rlHead.getHeight() / 2) {
                    //当偏移量小于高度一半
                    tvName.setText("");
                    tvTitle.setText("小幸运");
                } else {
                    tvName.setText("小草");
                    tvTitle.setText("");
                }
            }
        });
    }


    /************************** ViewPager TabLayout 联动******************************/
    private List<TabBean> mTypeList = new ArrayList<>();
    private MyFrPagerAdapter<BaseFragment> myPagerAdapter;
    private ArrayList<BaseFragment> fragments = new ArrayList<>();
    private void initData(){
        mTypeList.add(new TabBean(0,"歌词",""));
        mTypeList.add(new TabBean(1,"列表",""));

        fragments.add(CollapsingFragment1.newInstance());
        fragments.add(CollapsingFragment2.newInstance());

    }

    private void initTabAndVp(){
        initData();
        //关联数据
        myPagerAdapter = new MyFrPagerAdapter<>(getSupportFragmentManager(),fragments);
        viewPager.setAdapter(myPagerAdapter);
        mTabLayout.setupWithViewPager(viewPager);
        //设置样式
        for(int i = 0;i<mTypeList.size();i++){
            mTabLayout.getTabAt(i).setText(mTypeList.get(i).getTypename());
            //自定义样式
            //mTabLayout.getTabAt(i).setCustomView(getTabView(mTypeList.get(i).getTypename(),mTypeList.get(i).getPicture()));
        }
        viewPager.setCurrentItem(0,false);
    }

    /**
     * 自定义 tabView
     * @param name
     * @param url
     * @return
     */
    public View getTabView(String name, String url) {
        View view = getLayoutInflater().inflate(R.layout.item_tab_pager_top,null);
        TextView typeNameTv = view.findViewById(R.id.typeNameTv);
        typeNameTv.setText(name);
        ImageView typeIv =  view.findViewById(R.id.typeIv);
        return view;
    }
}
