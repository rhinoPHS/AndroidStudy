package com.androidstudy.androidstudy.BasicWidget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.androidstudy.androidstudy.R;

public class ImageTextView extends LinearLayout{
    public interface OnImageClickListener{
        public void onImageClick(View v, ImageTextData d);
    }
    OnImageClickListener mImageClickListener;
    public void setOnImageClickListener(OnImageClickListener listener){
        mImageClickListener = listener;
    }


    public ImageTextData getImageText(){
        return mData;
    }
    public Drawable getImage(){
        return iconView.getDrawable();
    }
    public String getText(){
        return nameView.getText().toString();
    }
    public ImageTextView(Context context){
        super(context);
        init();
    }
    public ImageTextView(Context context, AttributeSet attrs, int defStyleAttr){
        super(context,attrs,defStyleAttr);
        init();
    }
    public ImageTextView(Context context, AttributeSet attrs){
        super(context,attrs);
        init();
    }

    ImageTextData mData;
    public void setImageText(ImageTextData data){
        mData = data;
        iconView.setImageResource(data.imageId);
        nameView.setText(data.name);
    }

    ImageView iconView;
    TextView nameView;
    private void init(){
        setOrientation(LinearLayout.HORIZONTAL);
    }
    private void init(AttributeSet attrs) {
        LayoutInflater.from(getContext()).inflate(R.layout.activity_compound_widget,this);
        iconView = (ImageView)findViewById(R.id.image_icon);
        nameView = (TextView)findViewById(R.id.text_name);
        iconView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(mImageClickListener!=null){
                    mImageClickListener.onImageClick(ImageTextView.this,mData);
                }
            }
        });
        if(attrs!=null){
            TypedArray ta = getContext().obtainStyledAttributes(attrs,R.styleable.ImageTextView);
            String name = ta.getString(R.styleable.ImageTextView_name);
            nameView.setText(name);
            int resId = ta.getResourceId(R.styleable.ImageTextView_image,R.drawable.bug);
            iconView.setImageResource(resId);
            ta.recycle();
        }
    }
}
