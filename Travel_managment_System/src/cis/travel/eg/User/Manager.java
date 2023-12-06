package cis.travel.eg.User;

import cis.travel.eg.Trip.Trip;
import javafx.scene.input.Mnemonic;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Manager extends User {
    Scanner in =new Scanner(System.in);
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
    public void Display_Profile() {
        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("**********WELCOME**********");
        System.out.println("your first name " + super.getFirstName());
        System.out.println("-----------------------------------------");
        System.out.println("your last name " + super.getLastName());
        System.out.println("-----------------------------------------");
        //can add one his methods
        System.out.println("╚═══════════════════════════════════════════╝");
    }
    public void Edit_Profile() {
        String choice,fname,lname,country,pass1,pass2;
        int option,age;
        do {
            System.out.println("welcome " + super.getUsername());
            System.out.println("choose which option you want to change ");
            System.out.println(" 1)  first name \n2) Last name \n 3) Password \n  4) Age \n");
            option = in.nextInt();
            switch(option){
                case 1 :
                    System.out.println("please enter your first name ");
                    fname=in.next();
                    super.setFirstName(fname);//????????????
                    System.out.println("Done successfully "+super.getFirstName());
                    break;
                case 2:
                    System.out.println("please enter your last name ");
                    lname=in.next();
                    super.setLastName(lname);
                    System.out.println("Done sussefully "+super.getLastName());
                    break;
                case 3:
                    System.out.println("please enter your new password");
                    pass1=in.next();
                    System.out.println("Write again");
                    pass2=in.next();
                    super.setPassword(pass1,pass2);
                    System.out.println("Done sussefully ");
                    break;
                case 4:
                    System.out.println("please enter your age ");
                    age=in.nextInt();
                    super.setAge(age);
                    System.out.println("Done sussefully");
                    break;
                default:
                    System.out.println(" invalid choice try again ");
                    option=in.nextInt();
            }
            System.out.println("Do you want to make another change ? ");
            choice = in.next();
        }while(choice.toLowerCase().equals("yes"));
    }
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

    @Override
    public boolean HomePage(ArrayList<Admin> Admins, ArrayList<Customer> Customers, ArrayList<TourGuide> TourGuides, ArrayList<Manager> Managers, ArrayList<Trip> Trips_system) {
        return false;
    }

    @Override
    public int Display_Profile(ArrayList<Admin> admin, ArrayList<Customer> customer, ArrayList<Manager> manager, ArrayList<TourGuide> tourguide) {
        return 0;
    }

    @Override
    public int Edit_Profile(ArrayList<Admin> admin, ArrayList<Customer> customer, ArrayList<Manager> manager, ArrayList<TourGuide> tourguide) {
        return 0;
    }

    static public int FoundUsername(String username, ArrayList<Manager> managers) {
        return IntStream.range(0,managers.size())
                .filter(i ->managers.get(i).getUsername().equals(username))
                .findFirst()
                .orElse(-1);
    }
}
