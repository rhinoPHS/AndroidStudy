package com.androidstudy.androidstudy.ListView;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.androidstudy.androidstudy.R;

import java.util.ArrayList;
import java.util.Random;

public class ArrayAdapterActivity extends AppCompatActivity {

    ListView listView;
    ArrayAdapter<String > mAdapter;
    EditText inputView;
    TextView messageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_array_adapter);

        listView = (ListView)findViewById(R.id.listVie1);
        mAdapter  = new ArrayAdapter<String>(this,android.R.layout.select_dialog_multichoice);
        listView.setAdapter(mAdapter);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        initData();

        inputView = (EditText) findViewById(R.id.edit_input);
        messageView = (TextView)findViewById(R.id.text_message);

       /* listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Person p = (Person)listView.getItemAtPosition(position);
                messageView.setText(p.name);
            }
        });*/

        Button btn = (Button)findViewById(R.id.btn_delete);
            btn.setOnClickListener(new View.OnClickListener(){
                public void onClick(View v){
                    if(listView.getChoiceMode() == ListView.CHOICE_MODE_MULTIPLE){
                        SparseBooleanArray array = listView.getCheckedItemPositions();
                        ArrayList<String> select = new ArrayList<String>();
                        for(int index = 0; index < array.size(); index++){
                            int position = array.keyAt(index);
                            if(array.get(position)) {
                                select.add((String) listView.getItemAtPosition(position));
                            }
                        }
                        for(String s : select){
                            mAdapter.remove(s);
                        }
                    }
                }
            });
    }

    private void initData(){
        String[] items = getResources().getStringArray(R.array.list_item);
        for(String s : items){
            mAdapter.add(s);
        }
    }
}
