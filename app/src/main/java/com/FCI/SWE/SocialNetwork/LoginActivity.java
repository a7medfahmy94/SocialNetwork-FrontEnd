package com.FCI.SWE.SocialNetwork;

import com.FCI.SWE.Controllers.Application;
import com.FCI.SWE.Controllers.UserController;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
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

    EditText emailEditText;
    EditText passwordEditText;
    Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);
        //get email form EditText
        emailEditText = (EditText) findViewById(R.id.email);
        //get password form EditText
        passwordEditText = (EditText) findViewById(R.id.password);
        loginButton = (Button) findViewById(R.id.loginButton);
        loginButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        // TODO Auto-generated method stub
        //call function login from UserController
        UserController controller = Application.getUserController();
        controller.login(emailEditText.getText().toString(), passwordEditText
                .getText().toString());

    }

}
