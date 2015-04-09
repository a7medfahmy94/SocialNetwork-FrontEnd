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

    EditText emailEditText;
    EditText passwordEditText;
    Button loginButton;
    public static final String prefsName = "login_file";
    SharedPreferences data ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);

            data = getSharedPreferences(prefsName, Context.MODE_PRIVATE);
            setContentView(R.layout.activity_login);
            emailEditText = (EditText) findViewById(R.id.email);
            passwordEditText = (EditText) findViewById(R.id.password);
            loginButton = (Button) findViewById(R.id.loginButton);
            loginButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        // TODO Auto-generated method stub
        UserController controller = Application.getUserController();
        controller.login(emailEditText.getText().toString(), passwordEditText
                .getText().toString());


        //save the data to file
        if (data.getString("email","").equals("")) {
            data = getSharedPreferences(prefsName, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = data.edit();
            editor.putString("email", emailEditText.getText().toString());
            editor.putString("password", passwordEditText
                    .getText().toString());
            editor.commit();
        }

    }
}
