/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arslorem.hamzah.util;

import java.util.regex.Pattern;

/**
 *
 * @author user
 */
public class VlidatePassword {

    private String Password1;
    private String Password2;
    private String Status = "";
    private final Pattern hasUppercase = Pattern.compile("[A-Z]");
    private final Pattern hasLowercase = Pattern.compile("[a-z]");
    private final Pattern hasNumber = Pattern.compile("\\d");
    private final Pattern hasSpace = Pattern.compile("\\s");

    private final Pattern hasSpecialChar = Pattern.compile("[^a-zA-Z0-9 ]");

    public boolean validateNewPass() {
        Status = "";
        System.out.println("" + Status.length());
        if (Password1 == null || Password2 == null) {
            Status = Status + "One or both passwords are null";
            return false;
        }

        if (Password1.isEmpty() || Password2.isEmpty()) {
            Status = Status + "Empty fields ";
//            System.out.println("Empty fields ");
            return false;
        }

        if (Password1.equals(Password2)) {

            if (Password1.length() < 8) {
                System.out.println("");
                Status = Status + "Password is too short. Needs to have 11 characters";
            }

            if (!hasUppercase.matcher(Password1).find()) {
                Status = Status + "Password needs an upper case";
//                System.out.println("Password needs an upper case");
            }

            if (!hasLowercase.matcher(Password1).find()) {
                Status = Status + "Password needs a lowercase";
//                System.out.println("Password needs a lowercase");
            }

            if (!hasNumber.matcher(Password1).find()) {
                Status = Status + "Password needs a number";
//                System.out.println("Password needs a number");
            }
            if (hasSpace.matcher(Password1).find()) {
                Status = Status + "Password must not contain Space";
//                System.out.println("Password must not contain Space");
            }

            if (!hasSpecialChar.matcher(Password1).find()) {
                Status = Status + "Password needs a special character i.e. !,@,#, etc.";
//                System.out.println("Password needs a special character i.e. !,@,#, etc.");
            }
        } else {
            Status = Status + "Passwords don't match";
//            System.out.println("Passwords don't match");
            return false;
        }
        if (Status.length() == 0) {
            Status = Status + "Success";
//            System.out.println("Success");
            return true;
        }
        return false;
    }

    public String getPassword1() {
        return Password1;
    }

    public void setPassword1(String Password1) {
        this.Password1 = Password1;
    }

    public String getPassword2() {
        return Password2;
    }

    public void setPassword2(String Password2) {
        this.Password2 = Password2;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

}
