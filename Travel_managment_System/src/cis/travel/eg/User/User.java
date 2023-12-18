package cis.travel.eg.User;

import cis.travel.eg.Main.Main;
import cis.travel.eg.Trip.Trip;
import cis.travel.eg.User.TourGuideDetails.TourGuide;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

abstract public class User implements Serializable {
    private String Username;
    private String FirstName;
    private String LastName;
    private String Password;
    private String PhoneNumber;
    private String Email;
    private char Gender;
    private int Age;

//    public User(String username, String firstName, String lastName, String password, String phoneNumber, String email, char gender, int age) {
//        Username = username;
//        FirstName = firstName;
//        LastName = lastName;
//        Password = password;
//        PhoneNumber = phoneNumber;
//        Email = email;
//        Gender = gender;
//        Age = age;
//    }

    public static String encryptedPassword(String Password) {

        String encryptedPassword = null;
        try {
            // MessageDigest instance for MD5.
            MessageDigest m = MessageDigest.getInstance("MD5");

            // Add plain-text password bytes to digest using MD5 update() method.
            m.update(Password.getBytes());

            // Convert the hash value into bytes
            byte[] bytes = m.digest();

            // The bytes array has bytes cars decimal form. Converting it into hexadecimal format.
            StringBuilder s = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                s.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }

            // Complete hashed password cars hexadecimal format
            encryptedPassword = s.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        // Save encrypted password cars database.

        System.out.println("Encrypted password using MD5: " + encryptedPassword);
        return encryptedPassword;
    }

    public String getUsername() {
        return Username;
    }

    public boolean setUsername(String username, ArrayList<Admin> admin, ArrayList<Customer> customer, ArrayList<Manager> manager, ArrayList<TourGuide> tourGuide) {
        //another solution --> Stream APIs

        for (int i = 0; i < admin.size(); i++) {
            if (admin.get(i).getUsername().equals(username)) {
                return false;
            }
        }
        for (int i = 0; i < customer.size(); i++) {
            if (customer.get(i).getUsername().equals(username)) {
                return false;
            }
        }
        for (int i = 0; i < manager.size(); i++) {
            if (manager.get(i).getUsername().equals(username)) {
                return false;
            }
        }
        for (int i = 0; i < tourGuide.size(); i++) {
            if (tourGuide.get(i).getUsername().equals(username)) {
                return false;
            }
        }
        Username = username;
        return true;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getPassword() {
        return Password;
    }

    public boolean setPassword(String newPassword, String confirmPassword) {
        // cin_password
        if (newPassword == null || confirmPassword == null || newPassword.isEmpty() || confirmPassword.isEmpty()) {
            System.out.println(Main.ANSI_COLORS[2] + " Invalid Password  \n " + Main.ANSI_COLORS[0] + "Enter valid password : "); // null
            return false;
        }

        ///////////////////////////////
        int rule_count = 0;
        boolean sizeCheck = newPassword.length() > 7 && newPassword.length() < 30;
        boolean equalCheck = newPassword.equals(confirmPassword);
        boolean upperRule = !newPassword.equals(newPassword.toLowerCase());
        boolean lowerRule = !newPassword.equals(newPassword.toUpperCase());
        boolean numCheck = newPassword.matches("(.*)[0-9](.*)");
        boolean symbolsRule = newPassword.matches("(.*)#(.*)") || newPassword.matches("(.*)-(.*)") || newPassword.matches("(.*)_(.*)") || newPassword.matches("(.*)@(.*)"); // '#', '_', '-'

        rule_count = ((upperRule ? 1 : 0) + (lowerRule ? 1 : 0) + (symbolsRule ? 1 : 0) + (numCheck ? 1 : 0));

        if (!equalCheck) {
            System.out.println(Main.ANSI_COLORS[2] + "Passwords must match \n" + Main.ANSI_COLORS[0]);
            return false;
        } else if (!sizeCheck || rule_count < 4 || !numCheck) {
            System.out.println(Main.ANSI_COLORS[2] + "Password doesn't follow instructions \n ( '#' or '_' or '*' or capital and small letter) and  At least 8 characters " + Main.ANSI_COLORS[0]); //Password must be at least 8 and #, *
            return false;
        }
        Password = encryptedPassword(newPassword);
        return true;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public boolean setPhoneNumber(String phoneNumber) {
        int rule_count = 0;

        if (phoneNumber == null || phoneNumber.isEmpty()) {
            System.out.println(" Invalid number  \n Enter valid Number : "); // null
            return false;
        }

        boolean sizeCheck = phoneNumber.length() == 11;
        boolean numCheck = phoneNumber.matches("(.*)[0-9](.*)");
        boolean symbolsRule = !phoneNumber.matches("(.*)'#'(.*)"); // '*', '_', '-'
        boolean Check = phoneNumber.matches("011(.*)") || phoneNumber.matches("010(.*)")
                || phoneNumber.matches("015(.*)") || phoneNumber.matches("012(.*)");

        rule_count = ((sizeCheck ? 1 : 0) + (numCheck ? 1 : 0) + (symbolsRule ? 1 : 0) + (Check ? 1 : 0));


        if (rule_count > 0 && rule_count < 4) {
            System.out.println("Phone Number doesn't follow instructions \n");
            return false;
        }
        PhoneNumber = phoneNumber;
        return true;
    }

    public String getEmail() {
        return Email;
    }

    public boolean setEmail(String email) {
        boolean Check = email.matches("(.*)@gmail.com");
        boolean nullValue = email.matches("(.*)' '(.*)"); // edit
        boolean upperRule = email.equals(email.toLowerCase());
        if (Check && !nullValue && !upperRule) {
            Email = email;
            return true;
        }
        return false;
    }

    public char getGender() {
        return Gender;
    }

    public void setGender(char gender) {
        Gender = gender;
    }

    public int getAge() {
        return Age;
    }

    public boolean setAge(int age) {
        if (age > 110 || age < 14) {
            System.out.println(Main.ANSI_COLORS[2] + "Invalid input" + Main.ANSI_COLORS[0]);
            return false;
        }
        Age = age;
        return true;
    }

    ///////Abstract Methods///////
    abstract public void Register(ArrayList<Admin> Admin, ArrayList<Customer> customer, ArrayList<Manager> manager, ArrayList<TourGuide> tourguide);

    abstract public boolean HomePage(ArrayList<Admin> Admins, ArrayList<Customer> Customers, ArrayList<TourGuide> TourGuides, ArrayList<Manager> Managers, ArrayList<Trip> Trips_system);

    abstract public int Display_Profile(ArrayList<Admin> admin, ArrayList<Customer> customer, ArrayList<Manager> manager, ArrayList<TourGuide> tourguide);

    abstract public int Edit_Profile(ArrayList<Admin> admin, ArrayList<Customer> customer, ArrayList<Manager> manager, ArrayList<TourGuide> tourguide);


}


