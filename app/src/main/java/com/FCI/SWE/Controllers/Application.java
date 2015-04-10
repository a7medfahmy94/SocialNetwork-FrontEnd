package com.FCI.SWE.Controllers;

import android.content.Context;
import android.content.SharedPreferences;


public class Application extends android.app.Application {

	private static Context context;
	private static UserController userController;
    public static final String prefsName = "login_file";
    public static SharedPreferences data ;

    public void onCreate(){
        super.onCreate();
        data = getSharedPreferences(prefsName, Context.MODE_PRIVATE);
        Application.context = getApplicationContext();
        Application.userController = UserController.getInstance();
    }

    public static Context getAppContext() {
        return Application.context;
    }
    
    public static UserController getUserController(){
    	return Application.userController;
    }
}
