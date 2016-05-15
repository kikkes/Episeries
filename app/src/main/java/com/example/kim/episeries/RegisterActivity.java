package com.example.kim.episeries;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

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

                String email  = etEmail.getText().toString();
                String password  = etPassword.getText().toString();
                User newUser = new User(email,password);

                final RegisterService registerService = RegisterService.retrofit.create(RegisterService.class);
                final Call<String> call =
                        registerService.sendUserData(email,password);


                call.enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Response<String> response, Retrofit retrofit) {
                            if(response.body().toString().equalsIgnoreCase("true")) {
                                Log.w("succesfull add ", response.body().toString());
                                Toast.makeText(getBaseContext(), "Succesfully created account!", Toast.LENGTH_LONG).show();
                                finish();
                            }



                    }

                    @Override
                    public void onFailure(Throwable t) {
                        Log.w("faal", t.toString());
                        Toast.makeText(getApplicationContext(), "Could not create account!", Toast.LENGTH_LONG).show();
                    }
                });


            }
        });
    }
}


