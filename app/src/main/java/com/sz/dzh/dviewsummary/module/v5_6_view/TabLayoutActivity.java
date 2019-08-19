package com.sz.dzh.dviewsummary.module.v5_6_view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.socks.library.KLog;
import com.sz.dzh.dviewsummary.R;
import com.sz.dzh.dviewsummary.adapter.MyFrPagerAdapter;
import com.sz.dzh.dviewsummary.base.BaseActivity;
import com.sz.dzh.dviewsummary.bean.TabBean;
import com.sz.dzh.dviewsummary.fragment.SimpleFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Dengzh
 * on 2019/8/1 0001
 */
public class TabLayoutActivity extends BaseActivity {

    @BindView(R.id.tabLayout)
    TabLayout mTabLayout;
    @BindView(R.id.tabLayout2)
    TabLayout mTabLayout2;
    @BindView(R.id.viewPager)
    ViewPager viewPager;

    private List<TabBean> mTypeList = new ArrayList<>();
    private MyFrPagerAdapter<SimpleFragment> myPagerAdapter;
    private ArrayList<SimpleFragment> fragments = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_tab_layout);
        ButterKnife.bind(this);
        initToolBar("TabLayout");
        initTab();
        initTabAndVp();
    }



    private void initTab(){
        for (int i = 0;i<3;i++){
            mTabLayout.addTab(mTabLayout.newTab().setText("收藏" + i).setIcon(R.drawable.ic_stars_black_24dp));
        }
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                //选中Tab
                KLog.e(TAG, "onTabSelected--" + tab.getText());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                //未选中Tab(上一个选中的Tab，没有就不执行)
                KLog.e(TAG, "onTabUnselected--" + tab.getText());
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                //再次选中tab
                KLog.e(TAG, "onTabReselected--" + tab.getText());
            }
        });
    }

    /**
     * 接受数据后
     * 填充tab 数据
     */
    private void initData(){
        for(int i = 0;i<5;i++){
            mTypeList.add(new TabBean(i,"类型" + i,""));
        }
        for(int i = 0;i<mTypeList.size();i++){
            fragments.add(SimpleFragment.newInstance(mTypeList.get(i).getId()+""));
        }
    }

    /**
     * TabLayout 和 ViewPager关联
     */
    private void initTabAndVp(){
        initData();
        //关联数据
        myPagerAdapter = new MyFrPagerAdapter<>(getSupportFragmentManager(),fragments);
        viewPager.setAdapter(myPagerAdapter);
        /**
         * TabLayout.setupWithViewPager(viewPager)，将TabLayout和Viewpager两者绑定在一起。
         * 实际上，是setupWithViewPager()方法底部调用PagerAdapter中的getPageTitle()方法实现联系。
         *
         * 注意：setupWithViewPager 会执行 removeAllTabs,然后重新new Tab，所以要在关联之后。
         *      调用TabLayout.getTabAt(i)方法来设置title。或者在PagerAdapter的getPageTitle()返回标题。
         * */
        mTabLayout2.setupWithViewPager(viewPager);
        //设置样式
        for(int i = 0;i<mTypeList.size();i++){
            mTabLayout2.getTabAt(i).setText(mTypeList.get(i).getTypename());
            //自定义样式
            mTabLayout2.getTabAt(i).setCustomView(getTabView(mTypeList.get(i).getTypename(),mTypeList.get(i).getPicture()));
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
        // GlideUtils.loadImg(this,typeIv,url);
        return view;
    }
}
