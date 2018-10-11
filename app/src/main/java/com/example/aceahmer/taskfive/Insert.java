
package com.example.aceahmer.taskfive;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.github.siyamed.shapeimageview.CircularImageView;

public class Insert extends Activity {

    EditText name_edt, occupation_edt, lastname_edt,about_me_edt,age_edt;
    DataModel dm;
    Button insert_btn;
    DataBaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
        initializeViews();
        initializeClasses();
        setListeners();

    }

    public void initializeViews() {
        name_edt = (EditText) findViewById(R.id.firstname_edt);
        occupation_edt = (EditText) findViewById(R.id.occupation_edt);
        lastname_edt = (EditText) findViewById(R.id.lastname_edt);
        about_me_edt=(EditText)findViewById(R.id.about_me_edt);
        age_edt=(EditText)findViewById(R.id.age_edt);
        insert_btn = (Button) findViewById(R.id.insert_btn);
    }

    public boolean setErrors() {
        boolean check = true;
        if (dm.getFirstName().toString().trim().equals("")) {
            name_edt.setError("Required!");
            check = false;
        }
        if (dm.getSecondName().toString().trim().equals("")) {
            lastname_edt.setError("Required!");
            check = false;
        }
        if (dm.getOccupation().toString().trim().equals("")) {
            occupation_edt.setError("Required!");
            check = false;
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
        insert_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getValues();
                if (setErrors()) {
                    if (db.insertData(dm.firstName, dm.secondName, dm.Occupation,dm.getAge(),dm.getAboutme())){
                        Intent in=new Intent(getApplicationContext(),retreive.class);
                        startActivity(in);
                    }

                    else
                        Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
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
        db = new DataBaseHelper(Insert.this);
    }
}
