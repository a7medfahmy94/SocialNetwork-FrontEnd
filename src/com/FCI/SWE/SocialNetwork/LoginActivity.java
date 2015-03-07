package com.FCI.SWE.SocialNetwork;

import com.FCI.SWE.Controllers.Application;
import com.FCI.SWE.Controllers.UserController;

import android.app.Activity;
import android.content.Context;
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
//to check if user did'nt logout in the previous time
    public Boolean isFileExsist(String filepath) {
        File file ;
        try {
             file = new File(filepath);
            return file.exists();
        }
        finally {
        }
    }
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

        //if user log in from previous time he can enter his account directly "Still not working"
        if(isFileExsist("C:\\login_file.txt")){
            System.out.println("hello there");
        }
        else {
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
        //to take the data returned from db in a file in mobile
        String FILENAME = "login_file";
        String  loginInfo =userNameEditText.getText().toString()+ passwordEditText.getText().toString();

        FileOutputStream fos = null;
        try {
            fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);
            System.out.print("file dir = ");
            File file = new File("C:\\login_file.txt");
            String absolutePath = file.getAbsolutePath();
         /*   String filePath = absolutePath.
                    substring(0,absolutePath.lastIndexOf(File.separator));*/

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if (fos == null) throw new AssertionError();
        try {
            fos.write(loginInfo.getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
