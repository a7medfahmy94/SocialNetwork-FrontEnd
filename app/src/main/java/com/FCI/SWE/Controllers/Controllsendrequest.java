package com.FCI.SWE.Controllers;

import android.content.Intent;
import android.os.AsyncTask;
import android.widget.EditText;
import android.widget.Toast;

import com.FCI.SWE.Models.FriendRequestEntity;
import com.FCI.SWE.SocialNetwork.HomeActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Leila Sa3eed on 04/04/2015.
 */
public class Controllsendrequest {
    private static FriendRequestEntity currentActiveUser;
    private static Controllsendrequest userController;
    public static Controllsendrequest getInstance() {
        if (userController == null)
            userController = new Controllsendrequest();
        return userController;
    }
    public void sendFriendRequest(String email) {
        String base = "http://socialnetwork-harle.appspot.com";
        String path = "/rest/SendFriendRequest";
        String url = base.concat(path);
        String serviceName = "SendFriendRequest/{user_one}&{user_two}";
        new Connection().execute(url, email , serviceName);
    }
    static private class Connection extends AsyncTask<String, String, String> {

        String serviceType;

        @Override
        protected String doInBackground(String... params) {
            // TODO Auto-generated method stub
            URL url;
            serviceType = params[params.length - 1];
            String urlParameters = null;
            if (serviceType.equals("SendFriendRequest/{user_one}&{user_two}"))
                urlParameters = "email=" + params[1] ;


            HttpURLConnection connection;
            try {
                url = new URL(params[0]);

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
            // TODO Auto-generated method stub
            super.onPostExecute(result);
            try {
                JSONObject object = new JSONObject(result);

                if(!object.has("Status") || object.getString("Status").equals("Failed")){
                    Toast.makeText(Application.getAppContext(), "Error occured", Toast.LENGTH_LONG).show();
                    return;
                }

                if (serviceType.equals("SendFriendRequest/{user_one}&{user_two}")) {

                    currentActiveUser = FriendRequestEntity.createLoginUser(result);

                    Intent homeIntent = new Intent(Application.getAppContext(),
                            HomeActivity.class);
                    System.out.println("--- " + serviceType + "IN LOGIN " + object.getString("Status"));

                    homeIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
					/* here you should initialize user entity */
                    homeIntent.putExtra("status", object.getString("Status"));
                    homeIntent.putExtra("name", object.getString("name"));

                    Application.getAppContext().startActivity(homeIntent);
                }
                else{
                    Intent homeIntent = new Intent(Application.getAppContext(),
                            HomeActivity.class);
                    homeIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    homeIntent.putExtra("status", "Registered successfully");
                    Application.getAppContext().startActivity(homeIntent);
                }

            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }

    }
}
