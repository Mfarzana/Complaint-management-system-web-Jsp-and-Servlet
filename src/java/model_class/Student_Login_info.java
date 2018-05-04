/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model_class;

/**
 *
 * @author farzana
 */
public class Student_Login_info {
    private String userName;
    private String password;
    
    public void setUserName(String userName){
    this.userName=userName;
    }  
    public void setPassword(String password ){
    this.password=password;
    }  
     public String getUserName(){
    return userName;
    }  
    public String getPassword(  ){
    return password;
    }  
}
