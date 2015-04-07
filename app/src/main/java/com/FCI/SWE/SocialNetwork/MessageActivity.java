package com.FCI.SWE.SocialNetwork;
import com.FCI.SWE.Controllers.Application;
import com.FCI.SWE.Controllers.UserController;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by root on 03/04/15.
 */
public class MessageActivity extends Activity implements OnClickListener {
    EditText MessageFriend;
    EditText EmailFriend;
    Button sendButton;

    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        MessageFriend = (EditText) findViewById(R.id.message);
        EmailFriend = (EditText) findViewById(R.id.Email);
        sendButton = (Button) findViewById(R.id.send);
        sendButton.setOnClickListener(this);


    }
    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        String email=UserController.getCurrentUserEmail();
        UserController controller = Application.getUserController();
        controller.sendMessage(email,EmailFriend.getText().toString(),MessageFriend.getText().toString());

    }
}
