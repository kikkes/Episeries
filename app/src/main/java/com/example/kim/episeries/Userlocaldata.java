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
        SharedPreferences.Editor editor = userData.edit();
        editor.putString("email",user.getEmail());
        editor.putString("password",user.getPassword());
        editor.commit();
    }
}
