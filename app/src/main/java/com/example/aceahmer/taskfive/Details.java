
package com.example.aceahmer.taskfive;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Details extends AppCompatActivity {
   TextView name_txt,age_txt,occupation_txt,about_me_txt;
   Button update_btn;
   Intent intent;
   DataModel dm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        initializeViews();
        initializeClass();
        getObject();
        setViews();
        update_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),Update.class);
                i.putExtra("data",dm);
                startActivity(i);
            }
        });
    }
    public void initializeViews(){
        name_txt=(TextView)findViewById(R.id.name_txt);
        age_txt=(TextView)findViewById(R.id.age_txt);
        occupation_txt=(TextView)findViewById(R.id.occupation_txt);
        about_me_txt=(TextView)findViewById(R.id.about_me_txt);
        update_btn=(Button) findViewById(R.id.update_btn);
    }
    public void initializeClass(){
        dm=new DataModel();
    }
    public void getObject(){
        intent=getIntent();
        dm= intent.getExtras().getParcelable("data");
    }
    public void setViews(){
        age_txt.setText("Age: "+String.valueOf(dm.getAge()));
        about_me_txt.setText("About Me: "+dm.getAboutme());
        name_txt.setText("Name: "+dm.getFirstName()+" "+dm.getSecondName());
        occupation_txt.setText("Occupation: "+dm.getOccupation());
    }
}
