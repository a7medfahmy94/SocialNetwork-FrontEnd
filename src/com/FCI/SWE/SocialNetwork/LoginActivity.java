package com.FCI.SWE.SocialNetwork;

import com.FCI.SWE.Controllers.Application;
import com.FCI.SWE.Controllers.UserController;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class LoginActivity extends Activity implements OnClickListener {

	EditText userNameEditText;
	EditText passwordEditText;
	Button loginButton;
    public static final String prefsName = "login_file";
    SharedPreferences data ;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);


        data = getSharedPreferences(prefsName, Context.MODE_PRIVATE);


        if (!data.getString("name","").equals("")) {

            UserController controller = Application.getUserController();
            //load data from file
            String userName = data.getString("name", "Error name!");
            String password = data.getString("password", "Error password!");
            controller.login(userName, password);
            setContentView(R.layout.activity_home);
        } else {
            data = getSharedPreferences(prefsName, Context.MODE_PRIVATE);
            setContentView(R.layout.activity_login);
            userNameEditText = (EditText) findViewById(R.id.username);
            passwordEditText = (EditText) findViewById(R.id.password);
            loginButton = (Button) findViewById(R.id.loginButton);
            loginButton.setOnClickListener(this);
        }
    }

    @Override
	public void onClick(View v) {

		// TODO Auto-generated method stub
		UserController controller = Application.getUserController();
		controller.login(userNameEditText.getText().toString(), passwordEditText
						.getText().toString());


        //save the data to file
        SharedPreferences.Editor editor = data.edit();
        editor.putString("name",userNameEditText.getText().toString());
        editor.putString("password",passwordEditText
                .getText().toString());
        editor.commit();


    }
}