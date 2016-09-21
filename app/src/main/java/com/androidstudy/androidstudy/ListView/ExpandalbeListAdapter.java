package com.androidstudy.androidstudy.ListView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by phs on 2016-09-19 0019.
 */
public class ExpandalbeListAdapter extends BaseExpandableListAdapter {
    ArrayList<ExpandableListGroupItemData> items = new ArrayList<ExpandableListGroupItemData>();
    Context mContext;

    public ExpandalbeListAdapter(Context context){mContext = context;}

    @Override
    public int getGroupCount(){
        return items.size();
    }
    @Override
    public Object getGroup(int groupPosition){
        return items.get(groupPosition);
    }
    @Override
    public long getGroupId(int groupPosition){
        return groupPosition;
    }
    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent){
        TextView tv;
        if(convertView == null){
            tv = (TextView) LayoutInflater.from(mContext).inflate(android.R.layout.simple_list_item_1,null);
            tv.setPadding(50,0,0,0);
        }
        else{
            tv = (TextView)convertView;
        }
        tv.setText(items.get(groupPosition).groupTitle);
        return tv;
    }
    @Override
    public boolean hasStableIds(){
        return true;
    }
    @Override
    public int getChildrenCount(int groupPosition){
        return items.get(groupPosition).children.size();
    }
    @Override
    public Object getChild(int groupPosition, int childPosition){
        return items.get(groupPosition).children.get(childPosition);
    }
    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }
    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent){
        TextView tv;
        if(convertView == null){
            tv = (TextView)LayoutInflater.from(mContext).inflate(android.R.layout.simple_list_item_1,null);
        }
        else{
            tv = (TextView)convertView;
        }
        tv.setText(items.get(groupPosition).children.get(childPosition).title);
        return tv;
    }
    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition){
        return true;
    }

    public void add(String groupKey, ExpandableListChildItemData data){
        ExpandableListGroupItemData group = null;
        for(ExpandableListGroupItemData item : items){
            if(item.groupTitle.equals(groupKey)){
                group = item;
                break;
            }
        }
        if(group == null){
            group = new ExpandableListGroupItemData();
            group.groupTitle = groupKey;
            items.add(group);
        }
        group.children.add(data);
        notifyDataSetChanged();
    }

}
