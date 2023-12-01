package cis.travel.eg.User;

import cis.travel.eg.Trip.Trip;

import java.util.ArrayList;
import java.util.Scanner;

public class TourGuide extends User{
    private ArrayList <Trip> Historytrips;
    private ArrayList<Trip> Complainttrips;
    private double salary;
    public TourGuide(){};


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
    static public int Is_login_successfully(String username,String password,ArrayList<TourGuide> guide)
    {
        for(int i=0;i< guide.size();i++)
        {
            TourGuide guides=guide.get(i);  //to get the current Customer object from the ArrayList.
            if(guides.getUsername().equals(username) && guides.getPassword().equals(password))
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


    static public int FoundUsername(String username, ArrayList<TourGuide> tourGuides)
    {

    }
    public void Home_Page()
    {

    };
    public void Edit_Profile(String fname,String lname,String username,String password,String confirmPassword,String preferedpayment,String prefeeredcurrency,String preferedlanguage,ArrayList<Admin> Admins, ArrayList<Customer> Customers, ArrayList<Manager> Managers, ArrayList<TourGuide> TourGuide ){
        setFirstName(fname);
        setLastName(lname);
        setUsername(username,Admins , Customers, Managers,TourGuide);
        setPassword(password, confirmPassword);

    }
    public void Register(ArrayList<Admin> Admins, ArrayList<Customer> Customers, ArrayList<Manager> Managers,ArrayList<TourGuide> TourGuides) { //ha pass object wla la??
        Scanner in = new Scanner(System.in);
        System.out.println("Enter your first name ");
        super.setFirstName(in.next());
        System.out.println("Enter your last name ");
        super.setLastName(in.next());
        System.out.println("Enter username ");
        String user = in.next();
        super.setUsername(user,Admins , Customers, Managers,TourGuides);
        System.out.println("Enter password ")
        super.setPassword(in.next(), in.next());
    }
    public void Edit_Profile(){

    };
}
