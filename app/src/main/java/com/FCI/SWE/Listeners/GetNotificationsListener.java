package com.FCI.SWE.Listeners;

import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.FCI.SWE.Controllers.Application;
import com.FCI.SWE.Models.FriendRequestNotification;
import com.FCI.SWE.Models.MessageNotification;
import com.FCI.SWE.Models.Notification;
import com.FCI.SWE.RESTServices.NotificationsService;
import com.FCI.SWE.SocialNetwork.NotificationsActivity;

import java.util.ArrayList;

/**
 * Created by root on 4/5/15.
 */
public class GetNotificationsListener implements Button.OnClickListener {
    @Override
    public void onClick(View view) {
        new NotificationsService().execute();
        Intent notiIntent = new Intent(Application.getAppContext(), NotificationsActivity.class);
        notiIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        Application.getAppContext().startActivity(notiIntent);

    }
}
