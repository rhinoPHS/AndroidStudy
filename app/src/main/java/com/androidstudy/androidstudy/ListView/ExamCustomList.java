package com.androidstudy.androidstudy.ListView;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.androidstudy.androidstudy.R;

public class ExamCustomList extends AppCompatActivity {
    ListView listView;
    MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam_custom_list);

        listView = (ListView)findViewById(R.id.listView);
        myAdapter = new MyAdapter(this);

        myAdapter.setOnAdapterLikeListener(new MyAdapter.OnAdapterLikeListener(){
            @Override
            public void onAdapterLike(MyAdapter adapter, View view, CustomListData data){
                Toast.makeText(ExamCustomList.this,"Like Item Click",Toast.LENGTH_SHORT).show();
            }
        });
        listView.setAdapter(myAdapter);
        ininData();
    }
    private void ininData(){
        for(int i = 0; i<20; i++){
            CustomListData d = new CustomListData();
            d.imageId = R.drawable.android;
            d.name = "item "+i;
            d.desc = "desc "+i;
            d.likeCount = i;
            myAdapter.add(d);
        }
    }
}
