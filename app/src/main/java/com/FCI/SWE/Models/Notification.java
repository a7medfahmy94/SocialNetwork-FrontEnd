package com.FCI.SWE.Models;

import java.io.Serializable;

/**
 * Created by root on 4/5/15.
 */
abstract public class Notification implements Serializable{
    public String text;

    public Notification(String s){
        this.text = s;
    }


    abstract public void execute();

    @Override
    public String toString(){
        return this.text;
    }

}
