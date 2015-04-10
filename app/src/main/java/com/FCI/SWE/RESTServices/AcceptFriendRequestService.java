package com.FCI.SWE.RESTServices;

import android.os.AsyncTask;
import android.widget.Toast;

import com.FCI.SWE.Controllers.Application;
import com.FCI.SWE.Controllers.UserController;
import com.FCI.SWE.SocialNetwork.R;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 4/8/15.
 */
public class AcceptFriendRequestService extends AsyncTask<String,String,String> {
    final String base = Application.getAppContext().getString(R.string.host_base_url);
    final String path = Application.getAppContext().getString(R.string.acceptFriendRequestService);
    String fullUrl = base.concat(path);

    @Override
    protected String doInBackground(String... strings) {
        HttpClient httpclient = new DefaultHttpClient();
        // specify the URL you want to post to
        HttpPost httppost = new HttpPost(fullUrl);
        try {
            // create a list to store HTTP variables and their values
            List nameValuePairs = new ArrayList();
            // add an HTTP variable and value pair
            nameValuePairs.add(new BasicNameValuePair("user_one",
                    UserController.getCurrentActiveUser().getEmail()));
            nameValuePairs.add(new BasicNameValuePair("user_two", strings[0]));
            httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
            // send the variable and value, in other words post, to the URL
            HttpResponse response = httpclient.execute(httppost);
            HttpEntity entity = response.getEntity();
            String data = EntityUtils.toString(entity);
            return data;
        } catch (ClientProtocolException e) {
            e.printStackTrace();
            // process execption
        } catch (IOException e) {
            e.printStackTrace();
            // process execption
        }
        return null;
    }

    @Override
    protected void onPostExecute(String s){
        try {
            JSONObject obj = new JSONObject(s);
            if(obj.getString("Status").equals("OK")){
                Toast.makeText(Application.getAppContext(), "You're now friends!!! =)",
                        Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(Application.getAppContext(), "Sorry something went wrong!!! =(",
                        Toast.LENGTH_LONG).show();
            }
        }catch (Exception e){

        }
    }
}
