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

<<<<<<< HEAD
            data = getSharedPreferences(prefsName, Context.MODE_PRIVATE);
            setContentView(R.layout.activity_login);
            emailEditText = (EditText) findViewById(R.id.email);
            passwordEditText = (EditText) findViewById(R.id.password);
            loginButton = (Button) findViewById(R.id.loginButton);
            loginButton.setOnClickListener(this);
=======
        setContentView(R.layout.activity_login);
        emailEditText = (EditText) findViewById(R.id.email);
        passwordEditText = (EditText) findViewById(R.id.password);
        loginButton = (Button) findViewById(R.id.loginButton);
        loginButton.setOnClickListener(this);
>>>>>>> 65dc6034e7af354be8f335997814d15663e7a31b
    }

    @Override
    public void onClick(View v) {

        // TODO Auto-generated method stub
        UserController controller = Application.getUserController();
        controller.login(emailEditText.getText().toString(), passwordEditText
                .getText().toString());

    }

}
