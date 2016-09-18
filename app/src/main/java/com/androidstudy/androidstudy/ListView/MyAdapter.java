package com.androidstudy.androidstudy.ListView;

import android.content.Context;
import android.support.v7.view.menu.MenuView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by phs on 2016-09-18 0018.
 */
public class MyAdapter extends BaseAdapter implements CustomListView.OnLikeClickListener {
    ArrayList<CustomListData> items = new ArrayList<CustomListData>();
    Context mContext;

    public MyAdapter(Context context){
        mContext = context;
    }
    public void add(CustomListData item){
        items.add(item);
        notifyDataSetChanged();
    }
    public void addAll(List<CustomListData> items){
        this.items.addAll(items);
        notifyDataSetChanged();
    }
    @Override
    public int getCount(){
        return items.size();
    }
    @Override
    public Object getItem(int position){
        return items.get(position);
    }
    @Override
    public long getItemId(int position){
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        CustomListView v;
        if(convertView == null){
            v = new CustomListView(mContext);
            v.setOnLikeClickListener(this);
        }
        else{
            v=(CustomListView)convertView;
        }
        v.setItemData(items.get(position));
        return v;
    }
    public interface OnAdapterLikeListener{
        public void onAdapterLike(MyAdapter adapter,View view, CustomListData data);
    }
    OnAdapterLikeListener mListener;
    public void setOnAdapterLikeListener(OnAdapterLikeListener listener){
        mListener = listener;
    }
    @Override
    public void onLikeClick(View view ,CustomListData data){
        if(mListener != null){
            mListener.onAdapterLike(this,view,data);
        }
    }

}
