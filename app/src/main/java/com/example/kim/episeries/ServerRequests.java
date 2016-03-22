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

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

class POSTRequest extends AsyncTask<String, String, JSONObject> {
    JSONParser jsonParser = new JSONParser();
    Context context;

    private ProgressDialog pDialog;

    private static final String LOGIN_URL = "localhost:8000/register.php";

    private static final String TAG_SUCCESS = "success";
    private static final String TAG_MESSAGE = "message";


    public POSTRequest(Context context) {


    }
    @Override
    protected void onPreExecute() {
        pDialog = new ProgressDialog(this.context);
        pDialog.setMessage("Attempting login...");
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(true);
        pDialog.show();
    }

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
    Context context;
    JSONParser jsonParser = new JSONParser();

    private ProgressDialog pDialog;

    private static final String LOGIN_URL = "localhost:8000/login.php";

    private static final String TAG_SUCCESS = "success";
    private static final String TAG_MESSAGE = "message";


    public GETRequest(Context context) {


    }

    @Override
    protected void onPreExecute() {
        pDialog = new ProgressDialog(this.context);
        pDialog.setMessage("Attempting login...");
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(true);
        pDialog.show();
    }

    @Override
    protected JSONObject doInBackground(String... args) {

        try {

            HashMap<String, String> params = new HashMap<>();
            params.put("email", args[0]);
            params.put("password", args[1]);

            Log.d("request", "starting");

            JSONObject json = jsonParser.makeHttpRequest(
                    LOGIN_URL, "GET", params);

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

