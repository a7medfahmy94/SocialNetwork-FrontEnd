package com.FCI.SWE.RESTServices;

import android.os.AsyncTask;
import android.util.Log;

import com.FCI.SWE.Controllers.Application;
import com.FCI.SWE.Controllers.UserController;
import com.FCI.SWE.Models.FriendRequestNotification;
import com.FCI.SWE.Models.MessageNotification;
import com.FCI.SWE.Models.UserEntity;
import com.FCI.SWE.SocialNetwork.NotificationsActivity;
import com.FCI.SWE.SocialNetwork.R;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
/**
 * Created by root on 08/04/15.
 */
public class SearchForUser extends AsyncTask<String, String, String>  {
    final String base = Application.getAppContext().getString(R.string.host_base_url);
    final String path = Application.getAppContext().getString(R.string.searchForUser_service);
    String fullUrl = base.concat(path);

    protected String doInBackground(String... params){
        try {

            UserEntity e = UserController.getCurrentActiveUser();
            fullUrl += e.getEmail();
            //------------------>>
            HttpGet httpget = new HttpGet(fullUrl);
            HttpClient httpclient = new DefaultHttpClient();
            HttpResponse response = httpclient.execute(httpget);

            // StatusLine stat = response.getStatusLine();
            int status = response.getStatusLine().getStatusCode();

            if (status == 200) {
                HttpEntity entity = response.getEntity();
                String data = EntityUtils.toString(entity);
                return data;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    protected void onPostExecute(String result){
        try {
            JSONObject json = new JSONObject(result);
            JSONArray messages_emails = json.getJSONArray("messages_emails");
            JSONArray messages_text = json.getJSONArray("messages_text");
            JSONArray friend_requests_emails = json.getJSONArray("friend_requests_emails");
            for(int i = 0 ; i < messages_emails.length(); ++i) {
                NotificationsActivity.addItem(new MessageNotification(
                        messages_emails.getString(i),messages_text.getString(i)
                ));
                Log.i("noti" , messages_emails.getString(i));
                Log.i("noti" , messages_text.getString(i));

            }
            for(int i = 0 ; i < friend_requests_emails.length(); ++i){
                NotificationsActivity.addItem(new FriendRequestNotification(
                        friend_requests_emails.getString(i)
                ));
                Log.i("noti" , friend_requests_emails.getString(i));
            }
            Log.i("noti" , "hopa");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}