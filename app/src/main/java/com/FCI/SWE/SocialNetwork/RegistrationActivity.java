package com.FCI.SWE.SocialNetwork;

import com.FCI.SWE.Controllers.Application;
import com.FCI.SWE.Controllers.UserController;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class RegistrationActivity extends Activity implements OnClickListener {

	EditText userNameEditText;
	EditText userEmailEditText;
	EditText passwordEditText;
	Button registrationButton;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_registration);
        //get UserName for EditText
		userNameEditText = (EditText) findViewById(R.id.username_registration);
        //get UserEmail for EditText
        userEmailEditText = (EditText) findViewById(R.id.email_registration);
        //get UserPassword for EditText
        passwordEditText = (EditText) findViewById(R.id.password_registration);
		registrationButton = (Button) findViewById(R.id.RegistrationButton);
		registrationButton.setOnClickListener(this);
	
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
        //call function signUp from UserController
		UserController controller = Application.getUserController();
		controller.signUp(userNameEditText.getText().toString(), userEmailEditText.getText().toString(), passwordEditText
						.getText().toString());
		
	}

}
