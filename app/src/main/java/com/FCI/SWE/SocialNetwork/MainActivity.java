package com.FCI.SWE.SocialNetwork;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.FCI.SWE.Controllers.Application;
import com.FCI.SWE.Controllers.UserController;
import com.FCI.SWE.Models.UserEntity;

public class MainActivity extends Activity {

	
	Button login,signUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
<<<<<<< HEAD
        //edited by rania sayed
        data = getSharedPreferences(prefsName, Context.MODE_PRIVATE);
=======
>>>>>>> 65dc6034e7af354be8f335997814d15663e7a31b

        //if data saved in the file load data
        // from file and not make user to login again

        if (!Application.data.getString("email","").equals("")) {

            UserController controller = Application.getUserController();
            //load data from file
<<<<<<< HEAD
            String email = data.getString("email", "Error name!");
            String password = data.getString("password", "Error password!");
            controller.login(email, password);
            setContentView(R.layout.activity_home);
        }
            else if (data.getString("email","").equals("")){
            //if data not saved go to main activity to signup or login
                setContentView(R.layout.activity_main);
                login = (Button) findViewById(R.id.login);
                signUp = (Button) findViewById(R.id.signUp);
                login.setOnClickListener(new OnClickListener() {
=======
            String email = Application.data.getString("email", "Error name!");
            String password = Application.data.getString("password", "Error password!");
            String name = Application.data.getString("name" , "name error");
            UserController.setCurrentActiveUser(new UserEntity(name,email,password));
>>>>>>> 65dc6034e7af354be8f335997814d15663e7a31b

            Intent intent = new Intent(Application.getAppContext() , HomeActivity.class);
            startActivity(intent);
            finish();
        }else{
            setContentView(R.layout.activity_main);
            login = (Button) findViewById(R.id.login);
            signUp = (Button) findViewById(R.id.signUp);
            login.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View arg0) {
                    // TODO Auto-generated method stub
                    Intent loginIntent = new Intent(getApplicationContext(), LoginActivity.class);
                    startActivity(loginIntent);

                }
            });
            signUp.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    Intent registerationIntent = new Intent(getApplicationContext(), RegistrationActivity.class);
                    startActivity(registerationIntent);
                }
            });
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
