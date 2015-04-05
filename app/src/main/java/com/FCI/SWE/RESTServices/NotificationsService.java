package com.FCI.SWE.RESTServices;

import android.os.AsyncTask;
import android.util.Log;

import com.FCI.SWE.Controllers.Application;
import com.FCI.SWE.Controllers.UserController;
import com.FCI.SWE.Models.UserEntity;
import com.FCI.SWE.SocialNetwork.NotificationsActivity;
import com.FCI.SWE.SocialNetwork.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by root on 4/5/15.
 */
public class NotificationsService extends AsyncTask<String, String, String> {
    final String base = Application.getAppContext().getString(R.string.host_base_url);
    final String path = Application.getAppContext().getString(R.string.notifications_service);
    final String fullUrl = base.concat(path);

    protected String doInBackground(String... params){
        URL url;
        UserEntity e = UserController.getCurrentActiveUser();
        String urlParameters;
        urlParameters = "email=" + e.getEmail() + "&password=" + e.getPass();

        HttpURLConnection connection;
        try {
            url = new URL(this.fullUrl);

            connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setInstanceFollowRedirects(false);
            connection.setRequestMethod("GET");
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

        } catch (IOException ex) {
            // TODO Auto-generated catch block
            ex.printStackTrace();
        }
        return null;

    }
    protected void onPostExecute(String result){
        if(result == null)result = "nop";
        Log.i("service" , result);
//        NotificationsActivity.addItem();
    }
}
