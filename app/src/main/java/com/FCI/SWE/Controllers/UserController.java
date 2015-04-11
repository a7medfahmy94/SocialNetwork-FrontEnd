package com.FCI.SWE.Controllers;

import com.FCI.SWE.Models.UserEntity;
import com.FCI.SWE.RESTServices.LogInService;
import com.FCI.SWE.RESTServices.SignUpService;
import com.FCI.SWE.SocialNetwork.R;

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

        new LogInService().execute(email,password);
	}

	public void signUp(String userName, String email, String password) {
        new SignUpService().execute(userName,email, password);
	}

}
