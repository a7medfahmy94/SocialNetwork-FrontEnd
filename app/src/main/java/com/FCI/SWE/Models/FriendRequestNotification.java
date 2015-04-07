package com.FCI.SWE.Models;

import android.util.Log;

/**
 * Created by root on 4/5/15.
 */
public class FriendRequestNotification extends Notification {
    public String sender_email;
    public FriendRequestNotification(String sender_email){
        super("Friend request from " + sender_email);
        this.sender_email = sender_email;
    }

    @Override
    public void execute() {
        Log.i("noti", "talked to server for accepting friend request");
    }
}
