package com.FCI.SWE.RESTServices;

import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

import com.FCI.SWE.Controllers.Application;
import com.FCI.SWE.Controllers.UserController;
import com.FCI.SWE.Models.UserEntity;
import com.FCI.SWE.SocialNetwork.HomeActivity;
import com.FCI.SWE.SocialNetwork.LoginActivity;
import com.FCI.SWE.SocialNetwork.MainActivity;
import com.FCI.SWE.SocialNetwork.R;
import com.FCI.SWE.SocialNetwork.RegistrationActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by root on 4/5/15.
 */
public class SignUpService extends AsyncTask<String, String, String> {
    final String base = Application.getAppContext().getString(R.string.host_base_url);
    final String path = Application.getAppContext().getString(R.string.signup_service);
    final String fullUrl = base.concat(path);

    private String email , password , name;


    @Override
    protected String doInBackground(String... params) {
        this.name = params[0];
        this.email = params[1];
        this.password = params[2];

        URL url;
        String urlParameters;
        //make URL
        urlParameters = "uname=" + params[0] + "&email=" + params[1] + "&password=" + params[2];
        //connect to server
        HttpURLConnection connection;
        try {
            url = new URL(this.fullUrl);

            connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setInstanceFollowRedirects(false);
            connection.setRequestMethod("POST");
            connection.setConnectTimeout(60000); // 60 Seconds
            connection.setReadTimeout(60000); // 60 Seconds

            connection.setRequestProperty("Content-Type",
                    "application/x-www-form-urlencoded;charset=UTF-8");
            OutputStreamWriter writer = new OutputStreamWriter(
                    connection.getOutputStream());
            writer.write(urlParameters);
            writer.flush();
            String line, retJson = "";
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));

            while ((line = reader.readLine()) != null) {
                retJson += line;
            }
            return retJson;

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;

    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        try {
            JSONObject object = new JSONObject(result);

            if(!object.has("Status") || object.getString("Status").equals("Failed")){

                return;
            }
            //set user that signUp in server to current active user
            UserController.setCurrentActiveUser(new UserEntity(name, email, password));
            Intent homeIntent = new Intent(Application.getAppContext(),
                    HomeActivity.class);

            homeIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

            Application.getAppContext().startActivity(homeIntent);

            return;

        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
