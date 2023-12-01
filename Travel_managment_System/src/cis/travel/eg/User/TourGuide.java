package cis.travel.eg.User;

import cis.travel.eg.Trip.Trip;

import java.util.ArrayList;
import java.util.Scanner;

public class TourGuide {
    private ArrayList <Trip> Historytrips;
    private ArrayList<Trip> Complainttrips;
    private double salary;
    public TourGuide(){};
    public TourGuide(){

    }

    public ArrayList<Trip> getHistorytrips() {
        return Historytrips;
    }

    public void setHistorytrips(ArrayList<Trip> historytrips) {
        Historytrips = historytrips;
    }

    public ArrayList<Trip> getComplainttrips() {
        return Complainttrips;
    }

    public void setComplainttrips(ArrayList<Trip> complainttrips) {
        Complainttrips = complainttrips;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    public int Is_login_successfully(ArrayList<TourGuide> guide,String username,String password)
    {
        for(int i=0;i< guide.size();i++)
        {
            TourGuide guides=guide.get(i);  //to get the current Customer object from the ArrayList.
            if(guides.GetUsername().equals(username) && guides.GetPassword().equals(password))
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
        System.out.println("your first name "+super.GetFirstName());
        System.out.println("your last name "+super.GetLastName());
        System.out.println("your country "+getHistorytrips());
        System.out.println("you made trips of number "+getComplainttrips());
    }
    public void Register(String username,String firstname,String lastname,String password,int phone ,int age){ //ha pass object wla la??
        Scanner in=new Scanner(System.in);
        System.out.println("Enter your first name ");
        String name=in.next();
        super.SetFirstName(name);
        System.out.println("Enter your last name ");
        String n=in.next();
        super.SetLastName(name);
        System.out.println("Enter username ");
        String user=in.next();
        super.SetLastName(user);
        ystem.out.println("Enter password ");
        String pass=in.next();
        super.SetLastName(pass);
    }
}
