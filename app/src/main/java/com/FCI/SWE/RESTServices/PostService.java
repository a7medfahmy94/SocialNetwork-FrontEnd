package com.FCI.SWE.RESTServices;

import android.os.AsyncTask;
import android.util.Log;

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

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ranya on 11/04/2015.
 */
public class PostService extends AsyncTask<String , String ,String>{

    final String base = Application.getAppContext().getString(R.string.host_base_url);
    final String path = Application.getAppContext().getString(R.string.post_service);
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
            nameValuePairs.add(new BasicNameValuePair("sender",
                    UserController.getCurrentActiveUser().getEmail()));
            nameValuePairs.add(new BasicNameValuePair("receiver", strings[0]));
            nameValuePairs.add(new BasicNameValuePair("text", strings[1]));
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
    protected void onPostExecute(String response){
        if(response == null)response = "null";
        Log.i("Post", response);
    }
}
