package com.contect.countryapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.contect.countryapp.R;
import com.contect.countryapp.db.DBManager;

public class ModifyRecodsActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText subEdText, descEdText;
    private Button updateBtn, deleteBtn;

    private int _id;

    DBManager dbManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_recods);

        dbManager = new DBManager(this);
        dbManager.open();

        subEdText = (EditText) findViewById(R.id.subjectEditText);
        descEdText = (EditText) findViewById(R.id.descEditText);
        updateBtn = (Button) findViewById(R.id.updateBtn);
        deleteBtn = (Button) findViewById(R.id.deleteBtn);

        updateBtn.setOnClickListener(this);
        deleteBtn.setOnClickListener(this);

        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        String sub = intent.getStringExtra("sub");
        String des = intent.getStringExtra("desc");

        _id = Integer.parseInt(id);

        subEdText.setText(sub);
        descEdText.setText(des);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.updateBtn :
                String sub = subEdText.getText().toString();
                String desc = descEdText.getText().toString();

                dbManager.update(_id, sub, desc);
                this.returnHome();
                break;

            case R.id.deleteBtn :
                dbManager.delete(_id);
                this.returnHome();
                break;
        }
    }

    public void returnHome(){
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }
}
