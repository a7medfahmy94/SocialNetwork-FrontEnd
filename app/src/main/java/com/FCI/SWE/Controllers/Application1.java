package com.FCI.SWE.Controllers;

import android.content.Context;

/**
 * Created by Leila Sa3eed on 04/04/2015.
 */
public class Application1 {
    private static Context context;
    private static Controllsendrequest userController;
    private Context applicationContext;

    public void onCreate() {
        Application1.context = getApplicationContext();
        Application1.userController = Controllsendrequest.getInstance();
    }

    public static Context getAppContext() {
        return Application1.context;
    }

    public static Controllsendrequest getUserController(){
        return Application1.userController;
    }

    public Context getApplicationContext() {
        return applicationContext;
    }
}
