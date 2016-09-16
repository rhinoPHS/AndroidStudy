package com.androidstudy.androidstudy;

import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.Toast;

public class ScrollviewActivity extends AppCompatActivity {

    ScrollView scrolView01;
    ImageView imageView01;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrollview);

        scrolView01 = (ScrollView)findViewById(R.id.scrollView);
        imageView01 = (ImageView)findViewById(R.id.imageView);
        Button button01 = (Button) findViewById(R.id.button01);

        scrolView01.setHorizontalFadingEdgeEnabled(true);
        Resources res = getResources();

    }
    public void onButtonClick(View v){
        Toast.makeText(this,"버튼이 눌렸어요",Toast.LENGTH_SHORT).show();
    }
}
