package com.example.kim.episeries;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    Button bRegister;
    EditText etEmail,etPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        final Context context = (this);

        bRegister=(Button)findViewById(R.id.register);
        etEmail=(EditText)findViewById(R.id.editText);
        etPassword=(EditText)findViewById(R.id.editText2);


        bRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String mail  = etEmail.getText().toString();
                String password  = etPassword.getText().toString();
                User newUser = new User(mail,password);

                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);

            }
        });
    }
}


