package com.FCI.SWE.Listeners;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;

import com.FCI.SWE.Models.Notification;
import com.FCI.SWE.SocialNetwork.NotificationsActivity;

/**
 * Created by root on 4/5/15.
 */
public class NotificationListListener implements AdapterView.OnItemClickListener{
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Notification n = (Notification)NotificationsActivity.lv.getItemAtPosition(i);
        n.execute();
    }
}
