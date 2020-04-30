package com.android.scientificcalculator;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

public class CalculationActivity extends AppCompatActivity{

    ListView list;
    DatabaseHandler db;
    int i=0;
    String history[]=new String[5000];
    String history1[]=new String[5000];
    Button button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showcalculation);

        list=(ListView)findViewById(R.id.listview);
        db=new DatabaseHandler(this);
        button=(Button)findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(in);
            }
        });

        Cursor res=db.getData();
        while(res.moveToNext()){
            history[i]=res.getString(1);
            i++;
        }

        for(int i=0;i<5000;i++)
            history1[i]="";

        if(i!=0) {
            for (int j = i - 1, k = 0; j >= 0; j--, k++) {
                history1[k] = history[j];
            }
        }

        ListAdapter historyAdapater=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,history1);
        list.setAdapter(historyAdapater);
    }
}
