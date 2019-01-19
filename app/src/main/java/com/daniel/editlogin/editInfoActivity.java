package com.daniel.editlogin;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class editInfoActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText txtName;
    private EditText txtLastName;
    private EditText txtEmail;
    private EditText txtPhone;
    private Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        txtName = findViewById(R.id.name);
        txtLastName = findViewById(R.id.lastName);
        txtEmail = findViewById(R.id.email);
        txtPhone = findViewById(R.id.phone);
        btnSave = findViewById(R.id.btnSave);

        btnSave.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnSave) {
            String name = txtName.getText().toString();
            String lastName = txtLastName.getText().toString();
            String phone = txtPhone.getText().toString();
            String email = txtEmail.getText().toString();
            Intent intent = new Intent();
            intent.putExtra("NAME", name);
            intent.putExtra("LASTNAME", lastName);
            intent.putExtra("PHONE", phone);
            intent.putExtra("EMAIL", email);
            setResult(RESULT_OK, intent);
            SharedPreferences sp = getSharedPreferences("DATA", MODE_PRIVATE);
            SharedPreferences.Editor editor = sp.edit();
            editor.putString("NAME", name);
            editor.putString("LASTNAME", lastName);
            editor.putString("EMAIL", email);
            editor.putString("PHONE", phone);
            editor.apply();
            finish();

        }
    }



}
