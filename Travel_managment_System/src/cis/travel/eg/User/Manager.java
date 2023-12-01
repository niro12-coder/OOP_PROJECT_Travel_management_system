package cis.travel.eg.User;

import java.util.ArrayList;
import java.util.Scanner;

public class Manager extends User {
    public Manager(){};
    public static int Is_login_successfully(String username, String password,ArrayList<Manager> mange)
    {
        for(int i=0;i< mange.size();i++)
        {
            Manager manager=mange.get(i);  //to get the current Customer object from the ArrayList.
            if(manager.getUsername().equals(username) && manager.getPassword().equals(password))
            {
                System.out.println("login successfully "+username);
                return i;
            }
            else
                System.out.println("login failed");
        }
        return -1;
    }
    public void Display_Profile(){
        System.out.println("your first name "+super.getFirstName());
        System.out.println("your last name "+super.getLastName());
        System.out.println("your last name "+super.getUsername());
    }
    public boolean Home_Page(){
        return true;
    };
    public void Register(ArrayList<Admin> Admins, ArrayList<Customer> Customers, ArrayList<Manager> Managers,ArrayList<TourGuide> TourGuides) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter your first name ");
        super.setFirstName(in.next());
        System.out.println("Enter your last name ");
        super.setLastName(in.next());
        System.out.println("Enter username ");
        String user = in.next();
        super.setUsername(in.next(), Admins, Customers, Managers, TourGuides);
        System.out.println("Enter password ");
        String pass;
        super.setPassword(in.next(), in.next());
    }
    public void Edit_Profile(){

    };

    static public int FoundUsername(String username, ArrayList<Manager> Managers)
    {

    }


}
