package com.FCI.SWE.SocialNetwork;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View.OnClickListener;

import com.FCI.SWE.Controllers.UserController;
import com.FCI.SWE.RESTServices.PostService;
import com.FCI.SWE.RESTServices.SendMessageService;

/**
 * Created by ranya on 11/04/2015.
 */
public class PostActivity extends Activity implements OnClickListener {

    EditText writePost;
    EditText friendEmail;
    Button postBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_post);
        writePost = (EditText)findViewById(R.id.postEditText);
        postBtn = (Button)findViewById(R.id.postBtn);

        friendEmail = (EditText)findViewById(R.id.emailEditText);

     //   postBtn.setOnClickListener(this);



    }

    @Override
    public void onClick(View view) {
        //call post service
    /*    new PostService().execute(friendEmail.getText().toString(),writePost.getText().toString());
        Intent returnIntent = new Intent();
        setResult(RESULT_OK, returnIntent);
        finish();*/

    }
}
