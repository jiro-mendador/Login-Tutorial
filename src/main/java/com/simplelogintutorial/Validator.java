/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.simplelogintutorial;

/**
 *
 * @author Jiro Mendador
 */
public class Validator {
    
    String username = "admin";
    String password = "admin123";
    
    String enteredUsername;
    String enteredPassword;

    public Validator(String enteredUsername, String enteredPassword) {
        this.enteredUsername = enteredUsername;
        this.enteredPassword = enteredPassword;
    }
    
    public boolean validate() {
        return (enteredUsername.equals(username) && enteredPassword.equals(password));
    }
    
}
