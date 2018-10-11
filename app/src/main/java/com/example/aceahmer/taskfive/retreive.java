package com.example.aceahmer.taskfive;

import android.content.Intent;
import android.content.res.Configuration;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class retreive extends AppCompatActivity {
    RecyclerView retreive_recycler;
    DataBaseHelper dataBaseHelper;
    DataModel dm=new DataModel();
    List<DataModel> mylist;
    Cursor cursor;
    ImageButton add_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retreive);
        initializeViews();
        bind_and_set_Layoutmanger();
        getCursor();
        add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),Insert.class);
                startActivity(intent);
            }
        });
    }

    public void initializeViews() {
        add_btn=(ImageButton) findViewById(R.id.add_btn);
        retreive_recycler = (RecyclerView) findViewById(R.id.retreive_recycler);
        mylist= new ArrayList<>();
        dataBaseHelper=new DataBaseHelper(retreive.this);
    }

    public void bind_and_set_Layoutmanger() {
        retreive_recycler.setLayoutManager(new LinearLayoutManager(retreive.this));
    }

    public void getCursor(){

        cursor=dataBaseHelper.dataRetreive();
        if(cursor.getCount()<1){
            Toast.makeText(getApplicationContext(),"No Records There",Toast.LENGTH_LONG).show();
        }
        else{
            while(cursor.moveToNext()){
                mylist.add(new DataModel(cursor.getInt(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getInt(4),cursor.getString(5)));
            }
            retreive_recycler.setAdapter(new RecyclerViewImplementation(this,mylist));
        }
    }
}
