package com.androidstudy.androidstudy.ListView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidstudy.androidstudy.R;

/**
 * Created by phs on 2016-09-18 0018.
 */
public class CustomListView extends FrameLayout {
    public CustomListView(Context context){
        super(context);
        init();
    }
    public CustomListView(Context context, AttributeSet attrs){
        super(context, attrs);
        init();
    }
    public interface OnLikeClickListener{
        public void onLikeClick(View view, CustomListData data);
    }
    OnLikeClickListener mListener;
    public void setOnLikeClickListener(OnLikeClickListener listener){
        mListener = listener;
    }

    ImageView iconView;
    TextView nameView, descView, likeView;
    private void init(){
        LayoutInflater.from(getContext()).inflate(R.layout.activity_custom_list,this);
        iconView = (ImageView)findViewById(R.id.image_icon);
        nameView = (TextView)findViewById(R.id.text_name);
        descView = (TextView)findViewById(R.id.text_desc);
        likeView = (TextView)findViewById(R.id.text_like);

        likeView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(mListener != null){
                    mListener.onLikeClick(CustomListView.this,cData);
                }
            }
        });
    }
    CustomListData cData;
    public void setItemData(CustomListData data){
        cData = data;
        iconView.setImageResource(data.imageId);
        nameView.setText(data.name);
        descView.setText(data.desc);
        likeView.setText("like :"+data.likeCount);
    }
}

