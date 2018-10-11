package com.example.aceahmer.taskfive;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Delete extends AppCompatActivity {
    EditText id_edt;
    DataModel dm;
    Button delete_btn;
    DataBaseHelper db;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        initializeViews();
        initializeClasses();
        setListeners();
        intent=getIntent();
        DataModel dm=intent.getExtras().getParcelable("data");
        id_edt.setText(String.valueOf(dm.getId()));
    }
    public void initializeViews(){
        id_edt=(EditText)findViewById(R.id.id_edt);
        delete_btn=(Button)findViewById(R.id.delete_btn);
    }
    public boolean setErrors(){
        boolean check=true;
        if(dm.getId()==-1){
            id_edt.setError("Required");
            check=false;
        }
        return check;
    }
    public void setListeners(){
        delete_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getValues();
                if(setErrors()){
                    if(db.deleteData(String.valueOf(dm.getId()))) {
                        Intent intent = new Intent(getApplicationContext(), retreive.class);
                        startActivity(intent);
                    }
                    else
                        Toast.makeText(getApplicationContext(),"Deleted",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    public void getValues(){
        try {
            dm.setId(Integer.parseInt(id_edt.getText().toString()));
        }
        catch (Exception exp){

        }
    }
    public void initializeClasses(){
        dm=new DataModel();
        db=new DataBaseHelper(Delete.this);
    }
}
