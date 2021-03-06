package com.example.kim.episeries;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by kim on 15/03/2016.
 */
public class Userlocaldata {
    public static final String SP_NAME = "userDetails";
    SharedPreferences userData;

    public Userlocaldata(Context context) {
        userData = context.getSharedPreferences(SP_NAME,0);
    }
    public void storeUserData(User user) {
        setLoggedinUser(user);
    }

    public User getLoggedinUser() {
        String email = userData.getString("email", "");
        String password = userData.getString("password","");

        User storedUser = new User(email,password);

        return storedUser;

    }

    public void setLoggedinUser(User user) {
        SharedPreferences.Editor editor = userData.edit();
        editor.putString("email",user.getEmail());
        editor.putString("password", user.getPassword());
        editor.commit();

    }

    public void setLoggedin(boolean loggedin) {
        SharedPreferences.Editor editor = userData.edit();
        editor.putBoolean("loggedin",loggedin);
        editor.commit();

    }

    public boolean getLoggedin() {
        if (userData.getBoolean("loggedin", false)) {
            return false;
        }

        else {
            return true;
        }
        /*String email = userData.getString("email", "");
        String password = userData.getString("password", "");

        User user = new User( email, password); */
    }

    public void clearUserData() {
        SharedPreferences.Editor editor = userData.edit();
        editor.clear();
        editor.commit();

    }
}
