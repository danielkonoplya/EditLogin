package com.daniel.editlogin;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class mainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnEdit;
    private TextView txtName;
    private TextView txtLastName;
    private TextView txtEmail;
    private TextView txtPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnEdit = findViewById(R.id.btnEdit);
        txtName = findViewById(R.id.name);
        txtLastName = findViewById(R.id.lastName);
        txtEmail = findViewById(R.id.email);
        txtPhone = findViewById(R.id.phone);
        btnEdit.setOnClickListener(this);
        load();

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnEdit) {
            Intent intent = new Intent(this, editInfoActivity.class);
            startActivityForResult(intent, 1);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (resultCode == RESULT_OK && requestCode == 1) {
            txtName.setText(data.getStringExtra("NAME"));
            txtLastName.setText(data.getStringExtra("LASTNAME"));
            txtEmail.setText(data.getStringExtra("EMAIL"));
            txtPhone.setText(data.getStringExtra("PHONE"));
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void load() {
        SharedPreferences sp = getSharedPreferences("DATA", MODE_PRIVATE);
        String name = sp.getString("NAME", "");
        String lastName = sp.getString("LASTNAME", "");
        String email = sp.getString("EMAIL", "");
        String phone = sp.getString("PHONE", "");
        txtName.setText(name);
        txtLastName.setText(lastName);
        txtEmail.setText(email);
        txtPhone.setText(phone);
    }

}
