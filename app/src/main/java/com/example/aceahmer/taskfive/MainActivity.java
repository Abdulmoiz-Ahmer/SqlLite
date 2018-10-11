package com.example.aceahmer.taskfive;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
CardView update_card,retreive_card,subtract_card,add_card;
    Toolbar toolbar;
    CollapsingToolbarLayout collapsingToolbarLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       initializeViews();
       setTitles();
       setListeners();
    }

    public void initializeViews() {
        toolbar=(Toolbar)findViewById(R.id.toolbar);
        collapsingToolbarLayout=(CollapsingToolbarLayout)findViewById(R.id.collapsing_Toolbar);
        update_card=(CardView)findViewById(R.id.update_card);
        retreive_card=(CardView)findViewById(R.id.retreive_card);
        subtract_card=(CardView)findViewById(R.id.subtract_card);
        add_card=(CardView)findViewById(R.id.add_card);
    }

    public void setTitles(){
        toolbar.setTitle("Dashboard");
        collapsingToolbarLayout.setTitle("Collapsable Dashboard");
    }

    public void setListeners(){
        update_card.setOnClickListener(this);
        add_card.setOnClickListener(this);
        retreive_card.setOnClickListener(this);
        subtract_card.setOnClickListener(this);
    }

    public void intent(Class c){
        Intent in=new Intent(MainActivity.this,c);
        startActivity(in);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.add_card:
                intent(Insert.class);
                break;
            case R.id.retreive_card:
                intent(retreive.class);
                break;
            case R.id.update_card:
              intent(Update.class);
                break;
            case R.id.subtract_card:
                intent(Delete.class);
                break;
        }
    }
}
