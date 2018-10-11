package com.example.aceahmer.taskfive;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Update extends AppCompatActivity {
    EditText  name_edt, occupation_edt, lastname_edt,about_me_edt,age_edt;
    DataModel dm;
    DataBaseHelper db;
    Button update_btn;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        initializeViews();
        initializeClasses();
        setListeners();
        intent=getIntent();
        dm=intent.getExtras().getParcelable("data");
        setViews();
    }

    public void setViews(){

        age_edt.setText(String.valueOf(dm.getAge()));
        about_me_edt.setText(dm.getAboutme());
        name_edt.setText(dm.getFirstName());
        lastname_edt.setText(dm.getSecondName());
        occupation_edt.setText(dm.getOccupation());
    }

    public void initializeViews() {
        name_edt = (EditText) findViewById(R.id.firstname_edt);
        occupation_edt = (EditText) findViewById(R.id.occupation_edt);
        lastname_edt = (EditText) findViewById(R.id.lastname_edt);
        about_me_edt=(EditText)findViewById(R.id.about_me_edt);
        age_edt=(EditText)findViewById(R.id.age_edt);
        update_btn = (Button) findViewById(R.id.update_btn);
    }

    public boolean setErrors() {
        boolean check=true;
        if (dm.getFirstName().toString().trim().equals("")) {
            name_edt.setError("Required!");
            check=false;
        }
        if (dm.getSecondName().toString().trim().equals("")) {
            lastname_edt.setError("Required!");
            check=false;
        }
        if (dm.getOccupation().toString().trim().equals("")) {
            occupation_edt.setError("Required!");
            check=false;
        }

        if (dm.getAboutme().toString().trim().equals("")) {
            about_me_edt.setError("Required!");
            check = false;
        }
        if (dm.getAge()==-1) {
            lastname_edt.setError("Required!");
            check = false;
        }
        return check;
    }

    public void setListeners() {
        update_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getValues();
                if(setErrors()){
                    if(db.updateData(dm.getId(),dm.getFirstName(),dm.getSecondName(),dm.getOccupation(),dm.getAge(),dm.getAboutme())) {
                        Intent intent = new Intent(getApplicationContext(), retreive.class);
                        startActivity(intent);
                    }
                    else
                        Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void getValues() {
        dm.setFirstName(name_edt.getText().toString());
        dm.setSecondName(lastname_edt.getText().toString());
        dm.setOccupation(occupation_edt.getText().toString());
        dm.setAboutme(about_me_edt.getText().toString());
        dm.setAge(Integer.parseInt(age_edt.getText().toString()));
    }

    public void initializeClasses() {
        dm = new DataModel();
        db = new DataBaseHelper(Update.this);
    }
}
