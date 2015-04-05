package com.FCI.SWE.Models;

import android.util.Log;

/**
 * Created by root on 4/5/15.
 */
public class FriendRequestNotification extends Notification {
    public FriendRequestNotification(String s){
        super(s);
    }

    @Override
    public void execute() {
        Log.i("noti", "talked to server for accepting friend request");
    }
}
