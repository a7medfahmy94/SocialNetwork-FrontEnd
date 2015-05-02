package com.FCI.SWE.SocialNetwork;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.FCI.SWE.Listeners.GetNotificationsListener;
import com.FCI.SWE.Models.FriendRequestNotification;
import com.FCI.SWE.Models.MessageNotification;
import com.FCI.SWE.Models.Notification;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class HomeActivity extends Activity {
    private int SEND_MESSAGE = 1;
    private int WRITE_POST = 2;
    private int CREATE_GROUP = 3;
    private int JOIN_GROUP = 4;
	TextView helloTextView;
    Button logout;
    Button joinGroupBtn;
    Button createGroupBtn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);

        //edited by rania sayed
        logout =  (Button)findViewById(R.id.logoutButton);
         //if user click logout back to main page and delete current user data from file
        logout.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View arg0) {
               SharedPreferences preferences = getSharedPreferences("login_file",MODE_PRIVATE);
               SharedPreferences.Editor editor = preferences.edit();
               editor.clear();
               editor.commit();
               Intent logoutIntent = new Intent(getApplicationContext(),MainActivity.class);
               startActivity(logoutIntent);
               finish();
           }
        });


        Button notifications_btn = (Button) findViewById(R.id.notifications_btn);
        notifications_btn.setOnClickListener(new GetNotificationsListener());

        Button SendMessageBtn = (Button) findViewById(R.id.sendMessageBtn);
        SendMessageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sendMessageActivity = new Intent(getApplicationContext(),
                        MessageActivity.class);
                startActivityForResult(sendMessageActivity,SEND_MESSAGE);
            }
        });




        /*
        @author Rania Sayed
         */
        joinGroupBtn = (Button)findViewById(R.id.joinGroupBtn);
        joinGroupBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent joinGroupIntent = new Intent(getApplicationContext(),JoinGroupActivity.class);
                startActivity(joinGroupIntent); //must be startActivityForResult
                finish();
            }
        });

        createGroupBtn = (Button)findViewById(R.id.createGroupBtn);
        createGroupBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent createGroupIntent = new Intent(getApplicationContext(),
                        CreateGroupActivity.class);
                startActivityForResult(createGroupIntent);//must be startActivityForResult

            }
        });



	}

    protected void onActivityResult(int requestCode,int resultCode,Intent data){
        if(requestCode == SEND_MESSAGE){
            Toast.makeText(getApplicationContext(), "message sent!!! =)",
                    Toast.LENGTH_LONG).show();
        }
        else if(requestCode == WRITE_POST){
            Toast.makeText(getApplicationContext(), "post has been written",
                    Toast.LENGTH_LONG).show();
        }
    }

}
