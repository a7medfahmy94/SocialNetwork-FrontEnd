package com.FCI.SWE.Models;

import android.util.Log;

/**
 * Created by root on 4/5/15.
 */
public class MessageNotification extends Notification {
    public String sender_email;
    public String text;
    @Override
    public void execute() { Log.i("noti" , "opened chat");
    }

    public MessageNotification(String sender_email,String text){
        super("Message from " + sender_email);
        this.sender_email = sender_email;
        this.text = text;
    }
}
