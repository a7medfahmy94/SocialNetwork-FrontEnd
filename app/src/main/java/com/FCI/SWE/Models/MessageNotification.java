package com.FCI.SWE.Models;

import android.util.Log;

/**
 * Created by root on 4/5/15.
 */
public class MessageNotification extends Notification {

    @Override
    public void execute() {
        Log.i("noti" , "opened chat");
    }

    public MessageNotification(String s){
        super(s);
    }
}
