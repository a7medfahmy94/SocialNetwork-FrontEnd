package com.FCI.SWE.Models;

import android.util.Log;

import com.FCI.SWE.RESTServices.AcceptFriendRequestService;

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
        new AcceptFriendRequestService().execute(sender_email);
        Log.i("noti", "talked to server for accepting friend request");
    }
}
