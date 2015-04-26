package com.FCI.SWE.SocialNetwork;
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
public class UserPostActivity  extends Activity implements OnClickListener {
    EditText post;
    EditText feeling;
    EditText privacy;
    Button sendButton;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userpost);
        post = (EditText) findViewById(R.id.postText);
        feeling = (EditText) findViewById(R.id.feelingText);
        privacy = (EditText) findViewById(R.id.privacyText);

        sendButton = (Button) findViewById(R.id.sendBtn);
        sendButton.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        new UserPost().execute(post.getText().toString(),
                feeling.getText().toString(),privacy.getText().toString());
        Intent returnIntent = new Intent();
        setResult(RESULT_OK, returnIntent);
        finish();
    }
}


