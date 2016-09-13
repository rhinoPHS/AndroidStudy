package com.androidstudy.androidstudy;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
                    super.onCreate(savedInstanceState);
                    setContentView(R.layout.activity_main);

                    Button btn = (Button) findViewById(R.id.btn_toast);
                    btn.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            Toast.makeText(MainActivity.this, "시작 버튼이 눌렸어요.", Toast.LENGTH_SHORT).show();
                        }
                    });
                    btn = (Button) findViewById(R.id.btn_goole);
                    btn.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
                            startActivity(myIntent);
                        }
                    });
                    btn = (Button) findViewById(R.id.btn_tel);
                    btn.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:010-1234-5678"));
                            startActivity(myIntent);
                        }
                     });
                    Button startBtn = (Button) findViewById(R.id.btn_start);
                    startBtn.setOnClickListener(new View.OnClickListener(){
                        public void onClick(View v){
                            Toast.makeText(getApplicationContext(),"시작 버튼이 눌려썽요",1000).show();

                            Intent myIntent = new Intent(MainActivity.this,MyActivity.class);
                            startActivity(myIntent);
                        }
                    });
            }
        }
