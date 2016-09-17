package com.androidstudy.androidstudy;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethod;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MyActivity extends AppCompatActivity {

    EditText emailView;
    EditText passwordView;
    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    InputMethodManager mIMM;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        emailView = (EditText)findViewById(R.id.edit_email);
        passwordView = (EditText)findViewById(R.id.editPassword) ;
        mIMM = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);

        passwordView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId == EditorInfo.IME_ACTION_SEND){
                    String email = emailView.getText().toString();
                    if(email.matches(EMAIL_PATTERN)){
                        Toast.makeText(MyActivity.this,"서버 전송",Toast.LENGTH_SHORT).show();
                        mIMM.hideSoftInputFromWindow(passwordView.getWindowToken(),InputMethodManager.HIDE_NOT_ALWAYS);
                    }
                    else{
                        Toast.makeText(MyActivity.this,"형식 불일치",Toast.LENGTH_SHORT).show();
                    }
                }
                return true;
            }
        });

        Button backBtn = (Button) findViewById(R.id.btn_back);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MyActivity.this,"돌아가기 버튼이 눌렸어요.",Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        passwordView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String text = s.toString();
                if(text.length()<8){
                    passwordView.setTextColor(Color.RED);
                }
                else{
                    passwordView.setTextColor(Color.BLACK);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}
