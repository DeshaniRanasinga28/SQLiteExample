package com.contect.countryapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.contect.countryapp.db.DBManager;

public class AddCountryActivity extends AppCompatActivity  implements View.OnClickListener {
    private Button addBtn;
    private EditText subjectTxt, descTxt;

    private DBManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_country);

        setTitle("Add Record");

        subjectTxt = (EditText) findViewById(R.id.subject_editText);
        descTxt = (EditText) findViewById(R.id.desc_editText);
        addBtn = (Button) findViewById(R.id.addRecode_btn);

        dbManager = new DBManager(this);
        dbManager.open();

        addBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.addRecode_btn:
                final String subject = subjectTxt.getText().toString();

                final String desc = descTxt.getText().toString();

                if(subject.isEmpty()){
                    subjectTxt.setError("Please Enter subject");
                    subjectTxt.requestFocus();
                }
                else if(desc.isEmpty()){
                    descTxt.setError("Please Enter Description");
                    descTxt.requestFocus();
                }
                else
                    {
                    dbManager.insert(subject, desc);
                    Toast.makeText(this, "Add recode Successfull", Toast.LENGTH_LONG).show();

                    Intent main = new Intent(this, MainActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(main);
                    break;
                }


        }

    }
}
