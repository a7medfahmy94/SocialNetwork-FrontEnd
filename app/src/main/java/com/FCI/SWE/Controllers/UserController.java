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
<<<<<<< HEAD
<<<<<<< HEAD
        String base = Application.getAppContext().getString(R.string.host_base_url);
        String path = Application.getAppContext().getString(R.string.login_service);
        String url = base.concat(path);
        String serviceName = "LoginService";
        new Connection().execute(url, email, password, serviceName);
    }
=======
        new LogInService().execute(email,password);
	}
>>>>>>> 65dc6034e7af354be8f335997814d15663e7a31b
=======

        new LogInService().execute(email,password);
	}
>>>>>>> c8361fb017db0e7c70aba59bcea2073b2b7bb8ad

	public void signUp(String userName, String email, String password) {
        new SignUpService().execute(userName,email, password);
	}

}
