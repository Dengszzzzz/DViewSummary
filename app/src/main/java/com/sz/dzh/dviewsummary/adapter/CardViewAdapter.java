package com.sz.dzh.dviewsummary.adapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.widget.ContentLoadingProgressBar;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sz.dzh.dviewsummary.R;
import com.sz.dzh.dviewsummary.bean.CardViewBean;

import java.util.List;

/**
 * Created by Dengzh
 * on 2019/7/31 0031
 *
 * 演示 SwipeRefreshLayout 的上拉加载
 */
public class CardViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final static int TYPE_CONTENT=0;//正常内容
    private final static int TYPE_FOOTER=1;//下拉刷新

    private Context mContext;
    private List<CardViewBean> mList;

    public CardViewAdapter(Context context,List<CardViewBean> list) {
        mContext = context;
        mList = list;
    }

    @Override
    public int getItemViewType(int position) {
        if (position==mList.size()){
            return TYPE_FOOTER;
        }
        return TYPE_CONTENT;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        if (viewType==TYPE_FOOTER){ //底部布局
            View view = LayoutInflater.from(mContext).inflate(R.layout.view_refresh_footer, viewGroup, false);
            return new FootViewHolder(view);
        }else{ //正文内容布局
            View view = LayoutInflater.from(mContext).inflate(R.layout.item_cardview, viewGroup, false);
            return new ContentViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        if (getItemViewType(position)==TYPE_FOOTER){

        }else{
            ContentViewHolder mViewHolder = (ContentViewHolder) viewHolder;
            mViewHolder.tv_desc.setText(mList.get(position).getDesc());
        }
    }

    @Override
    public int getItemCount() {
        if(mList.size()%10==0){ //此处以10个数据判断是否还有更多数据，满足此条件，可以显示footer布局
            return mList.size()+1;
        }else{
            return mList.size();
        }
    }


    private class ContentViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_desc;
        private CardView card_view;
        public ContentViewHolder(View itemView) {
            super(itemView);
            card_view = itemView.findViewById(R.id.card_view);
            tv_desc = itemView.findViewById(R.id.tv_desc);
        }
    }

    private class FootViewHolder extends RecyclerView.ViewHolder{
        private ContentLoadingProgressBar progressBar;
        public FootViewHolder(View itemView) {
            super(itemView);
            progressBar=itemView.findViewById(R.id.progressBar);
        }
    }
}
