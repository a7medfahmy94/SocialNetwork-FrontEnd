package com.FCI.SWE.SocialNetwork;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.FCI.SWE.Listeners.GetNotificationsListener;


public class HomeActivity extends Activity {
    private int SEND_MESSAGE = 1;
	TextView helloTextView;
    Button logout;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);

        //logout button in home
        logout =  (Button)findViewById(R.id.logoutButton);

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
        //notification button in home
        Button notifications_btn = (Button) findViewById(R.id.notifications_btn);
        notifications_btn.setOnClickListener(new GetNotificationsListener());
        //sendMessage button in home
        Button SendMessageBtn = (Button) findViewById(R.id.sendMessageBtn);
        SendMessageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sendMessageActivity = new Intent(getApplicationContext(),
                        MessageActivity.class);
                startActivityForResult(sendMessageActivity,SEND_MESSAGE);
            }
        });
        //sendRequest button in home
        Button SendRequest_btn = (Button) findViewById(R.id.sendRequest_btn);
        SendRequest_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sendRequestActivity = new Intent(getApplicationContext(),
                        SendRequestActivity.class);
                startActivity(sendRequestActivity);
            }
        });

	}

    protected void onActivityResult(int requestCode,int resultCode,Intent data){
        if(requestCode == SEND_MESSAGE){
            Toast.makeText(getApplicationContext(), "message sent!!! =)",
                    Toast.LENGTH_LONG).show();
        }
    }

}
