package com.FCI.SWE.SocialNetwork;
import com.FCI.SWE.RESTServices.FriendPostService;
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
public class FriendPostActivity extends Activity implements OnClickListener {
    EditText post;
    EditText email;
    Button sendButton;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friendpost);
        post = (EditText) findViewById(R.id.postText);
        email = (EditText) findViewById(R.id.emailText);
        sendButton = (Button) findViewById(R.id.sendBtn);
        sendButton.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        new FriendPostService().execute(post.getText().toString(),
                email.getText().toString());
        Intent returnIntent = new Intent();
        setResult(RESULT_OK, returnIntent);
        finish();
    }
}

