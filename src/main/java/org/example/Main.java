package org.example;

import java.util.Arrays;

public class Main {
    public static String[] COMMONPASSWORDS={"Passwort1","Aa345678"};
    public static void main(String[] args) {
        System.out.println("Initial Commit");
    }
    public static boolean checkIfPasswordIsLongerThanEightChar(String password){
        return password.length()>8;
    }
    public static boolean checkIfNumsAreIncluded(String password){
        return password.matches(".*\\d.*");
    }
    public static boolean checkBigAndSmallChar(String password){
        return password.matches(".*[A-Z].*") && password.matches(".*[a-z].*");
    }
    public static boolean commonPassword(String password){
        return Arrays.asList(COMMONPASSWORDS).contains(password);
    }
    public static boolean specialChar(String password){
        return password.matches(".*[^A-Za-z0-9].*");
    }
}