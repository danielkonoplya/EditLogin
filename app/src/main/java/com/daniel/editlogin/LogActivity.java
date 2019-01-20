package com.daniel.editlogin;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LogActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnLog;
    private EditText txtEmail;
    private EditText txtPass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);

        btnLog = findViewById(R.id.btnLog);
        txtEmail = findViewById(R.id.inpMail);
        txtPass = findViewById(R.id.inpPass);
        btnLog.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btnLog){
            Intent intent = new Intent(this, mainActivity.class);
            startActivity(intent);
}
    }


}
