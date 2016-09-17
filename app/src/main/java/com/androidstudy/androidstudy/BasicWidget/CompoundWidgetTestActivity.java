package com.androidstudy.androidstudy.BasicWidget;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.androidstudy.androidstudy.R;

public class CompoundWidgetTestActivity extends AppCompatActivity {
    ImageTextView itv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compound_widget_test);

        itv=(ImageTextView)findViewById(R.id.view);
        itv.setOnImageClickListener(new ImageTextView.OnImageClickListener() {
            @Override
            public void onImageClick(View v, ImageTextData d) {

            }
        });
        initData();
    }
    private void initData(){
        ImageTextData data = new ImageTextData();
        data.imageId=R.drawable.bug;
        data.name="compound widget";
        itv.setImageText(data);
    }
}
