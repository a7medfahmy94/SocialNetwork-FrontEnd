package com.FCI.SWE.RESTServices;

import android.os.AsyncTask;
import android.widget.Toast;

import com.FCI.SWE.Controllers.Application;
import com.FCI.SWE.Controllers.UserController;

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
import com.FCI.SWE.SocialNetwork.R;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 16/04/15.
 */
public class UserPost extends AsyncTask<String,String,String> {
    protected String doInBackground(String... strings) {
        final String base = Application.getAppContext().getString(R.string.host_base_url);
        final String path = Application.getAppContext().getString(R.string.userPostService);
        String fullUrl = base.concat(path);
        HttpClient httpclient = new DefaultHttpClient();
        // specify the URL you want to post to
        HttpPost httppost = new HttpPost(fullUrl);
        try {
            // create a list to store HTTP variables and their values
            List nameValuePairs = new ArrayList();
            // add an HTTP variable and value pair
            nameValuePairs.add(new BasicNameValuePair("sender",
                    UserController.getCurrentActiveUser().getEmail()));
            nameValuePairs.add(new BasicNameValuePair("text", strings[0]));
            nameValuePairs.add(new BasicNameValuePair("feeling", strings[1]));
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
                Toast.makeText(Application.getAppContext(), "Done ",
                        Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(Application.getAppContext(), "Sorry something went wrong!!! =(",
                        Toast.LENGTH_LONG).show();
            }
        }catch (Exception e){

        }
    }
}
