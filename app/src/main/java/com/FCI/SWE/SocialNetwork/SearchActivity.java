package com.FCI.SWE.SocialNetwork;

import com.FCI.SWE.Controllers.Application;
import com.FCI.SWE.Controllers.UserController;
import com.FCI.SWE.RESTServices.SearchForUser;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;


/**
 * Created by root on 08/04/15.
 */
public class SearchActivity extends Activity implements OnClickListener {
    EditText Email;
    EditText Name;
    Button searchButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchuser);
        Email = (EditText) findViewById(R.id.EmailText);
        Name = (EditText) findViewById(R.id.NameText);
        searchButton = (Button) findViewById(R.id.Search);
        searchButton.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
        if(Name.getText().toString()!=" " && Email.getText().toString()==" "){
            new SearchForUser().execute(Name.getText().toString());

        }else {
            new SearchForUser().execute(Email.getText().toString());
        }
        Intent returnIntent = new Intent();
        setResult(RESULT_OK, returnIntent);
        finish();
    }

}
