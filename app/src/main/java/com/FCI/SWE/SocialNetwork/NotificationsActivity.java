package com.FCI.SWE.SocialNetwork;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.FCI.SWE.Listeners.NotificationListListener;
import com.FCI.SWE.Models.FriendRequestNotification;
import com.FCI.SWE.Models.MessageNotification;
import com.FCI.SWE.Models.Notification;

import java.util.ArrayList;

/**
 * Created by root on 4/5/15.
 */
public class NotificationsActivity extends ListActivity {
    public static ListView lv;
    private static ArrayList<Notification> notifications;
    private static ArrayAdapter<Notification> adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        notifications = new ArrayList<Notification>();
        adapter = new ArrayAdapter<Notification>(this,R.layout.list_item, R.id.label, notifications);
        this.setListAdapter(adapter);

        this.lv = getListView();
        this.lv.setOnItemClickListener(new NotificationListListener());
    }

    public static void addItem(Notification n){
        notifications.add(n);
        adapter.notifyDataSetChanged();
    }

}
