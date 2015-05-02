package com.FCI.SWE.SocialNetwork;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by ranya on 26/04/2015.
 */
public class JoinGroupActivity extends Activity {
    TextView groupIdTxtView;
    EditText groupIdEdtTxt;
    Button join;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join_group);
        groupIdTxtView = (TextView)findViewById(R.id.groupIdEdtTxt);
        groupIdEdtTxt = (EditText)findViewById(R.id.groupIdEdtTxt);
        join = (Button)findViewById(R.id.joinBtn);

    }
}
