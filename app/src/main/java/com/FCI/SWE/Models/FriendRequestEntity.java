package com.FCI.SWE.Models;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Leila Sa3eed on 24/03/2015.
 */
public class FriendRequestEntity {
    private String email;

    private FriendRequestEntity(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public static FriendRequestEntity createLoginUser(String json) {


        JSONObject object;
        try {
            object = new JSONObject(json);
            return  new FriendRequestEntity(object.get("email").toString());

        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return null;

    }

}
