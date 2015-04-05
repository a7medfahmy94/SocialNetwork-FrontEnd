package com.FCI.SWE.SocialNetwork;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.FCI.SWE.Models.FriendRequestNotification;
import com.FCI.SWE.Models.MessageNotification;
import com.FCI.SWE.Models.Notification;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class HomeActivity extends Activity {

	TextView helloTextView;
    Button logout;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);

        //edited by rania sayed
        logout =  (Button)findViewById(R.id.logoutButton);

        logout.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View arg0) {
             // TODO Auto-generated method stub
              //delete SharedPreference
              SharedPreferences preferences = getSharedPreferences("login_file",MODE_PRIVATE);
              SharedPreferences.Editor editor = preferences.edit();
              editor.clear();
              editor.commit();
              Intent logoutIntent = new Intent(getApplicationContext(),MainActivity.class);
                 startActivity(logoutIntent);
           }
        });


        Button notifications_btn = (Button) findViewById(R.id.notifications_btn);
        final ArrayList<Notification> notifications = new ArrayList<Notification>();
        notifications.add(new MessageNotification("Message"));
        notifications.add(new FriendRequestNotification("Friend Request"));

        notifications_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent notiIntent = new Intent(getApplicationContext(), NotificationsActivity.class);
                notiIntent.putExtra("notifications", notifications);
                startActivity(notiIntent);
            }
        });

	}

}
