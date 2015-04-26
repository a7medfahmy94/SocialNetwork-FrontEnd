package com.FCI.SWE.SocialNetwork;
import com.FCI.SWE.Controllers.Application;
import com.FCI.SWE.Controllers.UserController;
import com.FCI.SWE.RESTServices.SendMessageService;
import com.FCI.SWE.RESTServices.UserPost;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
/**
 * Created by root on 24/04/15.
 */
public class PostActivity extends Activity  {

    protected void onCreate(Bundle savedInstanceState) {
        Button userPost = (Button) findViewById(R.id.userPostBtn);
        userPost.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent userPostActivity = new Intent(getApplicationContext(),
                        UserPostActivity.class);
                startActivity(userPostActivity);
            }
        });

        Button friendPost=(Button) findViewById(R.id.friendPostBtn);
        friendPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent friendPostActivity = new Intent(getApplicationContext(),
                        FriendPostActivity.class);
                startActivity(friendPostActivity);
            }
        });
    }

}

