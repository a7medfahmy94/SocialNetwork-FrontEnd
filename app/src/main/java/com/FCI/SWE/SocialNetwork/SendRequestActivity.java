package com.FCI.SWE.SocialNetwork;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.FCI.SWE.RESTServices.SendRequestService;

public class SendRequestActivity extends Activity implements OnClickListener {

    Button send;
    EditText text;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sendrequest);
        text = (EditText) findViewById(R.id.email_btn);
        send = (Button) findViewById(R.id.send_btn);
        send.setOnClickListener(this);
    }
    public void onClick(View v) {
        new SendRequestService().execute(text.getText().toString());
        Intent returnIntent = new Intent();
        setResult(RESULT_OK, returnIntent);
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_sendrequest, menu);
        return true;
    }
}
