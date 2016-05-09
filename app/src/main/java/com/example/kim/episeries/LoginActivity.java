package com.example.kim.episeries;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    Userlocaldata userData;
    Button bLogin;
    EditText etEmail,etPassword;
    TextView toRegister;
    public  static Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        bLogin=(Button)findViewById(R.id.login);
        etEmail=(EditText)findViewById(R.id.editText);
        etPassword=(EditText)findViewById(R.id.editText2);
        toRegister=(TextView) findViewById(R.id.toRegister);
        userData = new Userlocaldata(this); ///////////////////////////////////////////////////
        bLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //if(etEmail.getText().toString().equals("a") && etPassword.getText().toString().equals("a")) {

                    String email = etEmail.getText().toString();
                    String password = etPassword.getText().toString();
                    User loggonUser = new User(email, password);
                    userData.storeUserData(loggonUser);
                if(userData.getLoggedin()) {
                   // Toast.makeText(getApplicationContext(), "Redirecting...", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent("com.example.kim.episeries.MainActivity");
                    startActivity(intent);
                }
                //}
                //else{
                  //  Toast.makeText(getApplicationContext(), "Wrong Credentials",Toast.LENGTH_SHORT).show();

                //}
            }
        });
        toRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.example.kim.episeries.RegisterActivity");
                startActivity(intent);
            }
        });
    }

    public static Context getTheContext() {

        return context;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    private void displayUserDetails() {
        User user = userData.getLoggedinUser();

        etEmail.setText(user.getEmail());
        etPassword.setText(user.getPassword());
    }

   /* @Override
    protected void onStart() {
        super.onStart();
        if( authenticate()== true) {
            displayUserDetails();
        }
    }

    private boolean authenticate() {
        if (userData.getLoggedin() != null) {
            Intent intent = new Intent("com.example.kim.episeries.MainActivity");
            startActivity(intent);
            return false;
        }
        return true;
    }
    */
}


