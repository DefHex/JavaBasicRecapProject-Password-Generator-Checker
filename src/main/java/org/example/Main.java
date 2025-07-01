package org.example;
import java.util.*;

public class Main {
    public static String[] COMMONPASSWORDS={"Passwort1","Aa345678"};
    public static void main(String[] args) {
        int choice;
        do{
            System.out.println("Input 1 to check your password strength\nInput 2 to generate a strong password.\nType 0 to exit:");
            Scanner input =new Scanner(System.in);
            choice=input.nextInt();
            switch (choice){
                case 1:{
                    boolean check;
                    do{
                        check=passwordChecker();
                    }while(!check);
                }break;

                case 2:{
                    Random random=new Random();
                    StringBuilder generatedPassword= new StringBuilder();
                    passwordMaker(generatedPassword,random);
                }break;

            }
        } while (choice==1||choice==2);

    }
    public static boolean passwordChecker(){
        System.out.println("Type in a password to check its strength:");
        Scanner input=new Scanner(System.in);
        String password=input.nextLine();
        if(!checkIfPasswordIsLongerThanEightChar(password)){
            System.out.println("Make sure that the password is longer than 8 characters.");
            return false;
        }else if(!checkIfNumsAreIncluded(password)){
            System.out.println("Make sure that the password has numbers in it.");
            return false;
        } else if (!checkBigAndSmallChar(password)) {
            System.out.println("Make sure that the password includes capital and lowercase letters.");
            return false;
        } else if (commonPassword(password)) {
            System.out.println("The given password is not secure. Please use another one.");
            return false;
        } else if (!specialChar(password)) {
            System.out.println("Make sure that the password include special characters.");
            return false;
        } else if (spaceNewLineTab(password)) {
            System.out.println("Make sure that the password doesn't include spaces, tabs and is in one line.");
            return false;
        }else {
            System.out.println("Your password "+password+" is secure");
            return true;
        }
    }

    public static void passwordMaker(StringBuilder password, Random random){
        if(!checkIfNumsAreIncluded(password.toString())){
            password.append(random.nextInt(10));
            passwordMaker(password,random);
        } else if (!checkBigAndSmallChar(password.toString())) {
            for (int i = 1; i < 1+random.nextInt(5); i++) {
                password.append((char) ('a'+random.nextInt(26)))
                        .append((char) ('A'+random.nextInt(26)));
            }
            passwordMaker(password,random);
        }  else if (!specialChar(password.toString())) {
            String specialChars = "!@#$%^&*()-_=+[]{};:,.<>?/|";
            for (int i = 1; i < 1+random.nextInt(3); i++) {
                password.append(specialChars.charAt(random.nextInt(specialChars.length())));    
            }
            passwordMaker(password,random);
        }else if(!checkIfPasswordIsLongerThanEightChar(password.toString())){
            for (int i = 1; i < 1+random.nextInt(5); i++) {
                password.append((char) ('a'+random.nextInt(26)))
                        .append((char) ('A'+random.nextInt(26)));
            }
            passwordMaker(password,random);
        }else if (commonPassword(password.toString())) {
            password.setLength(0);
            passwordMaker(password,random);
        } else {
            List<Character> chars = new ArrayList<>();
            for (int i = 0; i < password.length(); i++) {
                chars.add(password.charAt(i));
            }
            Collections.shuffle(chars, random);
            password.setLength(0);
            for (char c : chars) {
                password.append(c);
            }
            System.out.println("Your password "+password+" is secure");
        }
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
    public static boolean spaceNewLineTab(String password){
        return password.matches(".*[ \\n\\t].*");
    }
}