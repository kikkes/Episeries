package com.example.kim.episeries;

/**
 * Created by kim on 22/03/2016.
 */
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;
import android.content.Intent;
import android.view.View;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

class POSTRequest extends AsyncTask<String, String, JSONObject> {
    JSONParser jsonParser = new JSONParser();
    private Context context;

    private ProgressDialog pDialog;
                                            //"http://10.68.248.51:8000/register.php"
    private static final String LOGIN_URL = "http://192.168.0.104:8000/register.php";

    private static final String TAG_SUCCESS = "success";
    private static final String TAG_MESSAGE = "message";
    private static final String TAG_EMAIL = "email";
    private static final String TAG_PASSWORD = "password";

   /* public POSTRequest(Context context)
    {
        this.context = context;
    }


    @Override
    protected void onPreExecute() {
        pDialog = new ProgressDialog(context);
        pDialog.setMessage("Attempting login...");
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(true);
        pDialog.show();
    }
    */

    @Override
    protected JSONObject doInBackground(String... args) {

        try {

            HashMap<String, String> params = new HashMap<>();
            params.put("email", args[0]);
            params.put("password", args[1]);

            Log.d("request", "starting");
            JSONObject json = jsonParser.makeHttpRequest(
                    LOGIN_URL, "POST", params);

            if (json != null) {
                Log.d("JSON result", json.toString());

                return json;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    protected void onPostExecute(JSONObject json) {

        int success = 0;
        String message = "";

        if (pDialog != null && pDialog.isShowing()) {
            pDialog.dismiss();
        }

        if (json != null) {
            Toast.makeText(this.context, json.toString(),
                    Toast.LENGTH_LONG).show();

            try {
                success = json.getInt(TAG_SUCCESS);
                message = json.getString(TAG_MESSAGE);
                String lel = "hihi"; ///////
                Log.d("lel",lel);   ///////
            } catch (JSONException e) {
                e.printStackTrace();

            }
        }

        if (success == 1) {
            Log.d("Success!", message);
        }else{
            Log.d("Failure", message);
        }
    }

}


class GETRequest extends AsyncTask<String, String, JSONObject> {
    Context context = LoginActivity.getTheContext();
    Userlocaldata userData;
    private boolean loggedin; ///////////////////////////////
    JSONParser jsonParser = new JSONParser();

    private ProgressDialog pDialog;

    private static final String LOGIN_URL = "http://192.168.0.104:8000/login.php";

    private static final String TAG_SUCCESS = "success";
    private static final String TAG_MESSAGE = "message";


   /* @Override
    protected void onPreExecute() {
        pDialog = new ProgressDialog(context.getApplicationContext());
        pDialog.setMessage("Attempting login...");
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(true);
        pDialog.show();
    }
*/
    @Override
    protected JSONObject doInBackground(String... args) {

        try {

            HashMap<String, String> params = new HashMap<>();
            params.put("email", args[0]);
            params.put("password", args[1]);

            Log.d("request", "starting");
                                                                        //////probleem kan niet van string naar jsonobject
            JSONObject json = jsonParser.makeHttpRequest(
                    LOGIN_URL, "GET", params);
            String lel = "hihi"; ///////
            Log.d("lel",lel);   ///////
           // if (json != null) {

                Log.d("JSON result", json.toString());


                return json;
          //  }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    protected void onPostExecute(JSONObject json) {

        int success = 0;
        String message = "";

        if (pDialog != null && pDialog.isShowing()) {
            pDialog.dismiss();
        }

        if (json != null) {
            Toast.makeText(context.getApplicationContext(), json.toString(),
                    Toast.LENGTH_LONG).show();

            try {
                success = json.getInt(TAG_SUCCESS);
                message = json.getString(TAG_MESSAGE);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        if (success == 1) {
            Log.d("Success!", message);
            userData.setLoggedin(loggedin);//////////////////////
        }else{
            Log.d("Failure", message);
        }
    }

}

