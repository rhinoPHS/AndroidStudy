package com.androidstudy.androidstudy.BasicWidget;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.androidstudy.androidstudy.R;

public class ImageViewActivity extends AppCompatActivity {

    ImageView image01;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view);

        image01 = (ImageView)findViewById(R.id.imageView2);

        image01.setScaleType(ImageView.ScaleType.CENTER_CROP);
    }
}
