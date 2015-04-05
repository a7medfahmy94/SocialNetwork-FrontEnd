package com.FCI.SWE.Controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

import com.FCI.SWE.Models.UserEntity;
import com.FCI.SWE.SocialNetwork.HomeActivity;
import com.FCI.SWE.SocialNetwork.R;
import android.content.Context;

public class UserController {

	private static UserEntity currentActiveUser;
	private static UserController userController;

	public static UserController getInstance() {
		if (userController == null)
			userController = new UserController();
		return userController;
	}

    public static UserEntity getCurrentActiveUser(){
        if(currentActiveUser == null){
            currentActiveUser = new UserEntity("default","default","default");
        }
        return currentActiveUser;
    }

    public static void setCurrentActiveUser(UserEntity e){
        currentActiveUser = e;
    }

	private UserController() {

	}

	public void login(String email, String password) {
        String base = Application.getAppContext().getString(R.string.host_base_url);
        String path = Application.getAppContext().getString(R.string.login_service);
        String url = base.concat(path);
        String serviceName = "LoginService";
        new Connection().execute(url, email,password, serviceName);
	}

	public void signUp(String userName, String email, String password) {
        String base = Application.getAppContext().getString(R.string.host_base_url);
        String path = Application.getAppContext().getString(R.string.signup_service);
		String url = base.concat(path);
        String serviceName = "RegistrationService";
        new Connection().execute(url, userName,email, password, serviceName);
	}

}
