package com.androidstudy.androidstudy.ListView;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import com.androidstudy.androidstudy.R;

public class ExpandableList extends AppCompatActivity {
    ExpandableListView listView;
    ExpandalbeListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expandalbe_list);

        listView = (ExpandableListView)findViewById(R.id.expandableListView);
        TextView headerView = new TextView(this);
        headerView.setText("Header View");
        listView.addHeaderView(headerView,null,false);
        mAdapter = new ExpandalbeListAdapter(this);

        listView.setAdapter(mAdapter);

        listView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                ExpandableListChildItemData data =(ExpandableListChildItemData)mAdapter.getChild(groupPosition,childPosition);
                Toast.makeText(ExpandableList.this,"GroupPosition : "+groupPosition+",child : "+data.title,Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        listView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                ExpandableListGroupItemData group = (ExpandableListGroupItemData)mAdapter.getGroup(groupPosition);
                return false;
            }
        });
        listView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {

            }
        });
        listView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int groupPosition) {
                listView.expandGroup(groupPosition);
            }
        });
        initData();
    }
    private void initData(){
        for(int i =0; i<5; i++){
            ExpandableListChildItemData d = new ExpandableListChildItemData();
            d.title = "child"+i;
            mAdapter.add("group"+i,d);
        }
    }

}
