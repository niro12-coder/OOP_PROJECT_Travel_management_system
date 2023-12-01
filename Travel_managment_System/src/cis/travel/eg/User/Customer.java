package cis.travel.eg.User;
import cis.travel.eg.Main.*;
import cis.travel.eg.Service.*;
import java.util.ArrayList;
import java.util.Scanner;
public class  Customer extends User{
    Scanner in = new Scanner(System.in);
    private String country;
    private String preferedcurrency;
    private String preferedlanguage;
    private String preferedpayment;
    String confiremedpass;
    private int totaltrips;
    private ArrayList <Ticket> tickets;
    private ArrayList <Voucher> vouchers;
    public Customer(){};
    public Customer(Customer c) { //if admin make a new account and want to copy details?
        this.country = c.country;
        this.preferedcurrency = c.preferedcurrency;
        this.preferedpayment = c.preferedpayment;
        this.preferedlanguage = c.preferedlanguage;
    }
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPrefeeredcurrency() {
        return preferedcurrency;
    }

    public void setPrefeeredcurrency(String prefeeredcurrency) {
        this.preferedcurrency = prefeeredcurrency;
    }

    public String getPreferedlanguage() {
        return preferedlanguage;
    }

    public void setPreferedlanguage(String preferedlanguage) {
        this.preferedlanguage = preferedlanguage;
    }

    public String getPreferedpayment() {
        return preferedpayment;
    }

    public void setPreferedpayment(String preferedpayment) {
        this.preferedpayment = preferedpayment;
    }

    public int getTotaltrips() {
        return totaltrips;
    }

    public void setTotaltrips(int totaltrips) {
        this.totaltrips = totaltrips;
    }

    public ArrayList<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(ArrayList<Ticket> tickets) {
        this.tickets = tickets;
    }

    public ArrayList<Voucher> getVouchers() {
        return vouchers;
    }

    public void setVouchers(ArrayList<Voucher> vouchers) {
        this.vouchers = vouchers;
    }
    public void Edit_Profile(){
        System.out.println("choose which option you want to change ");
        System.out.println(" 1)  first name \n2) Last name \n 3) Password \n 4) Country \n  5) Age \n");
    }

    static public int FoundUsername(String username, ArrayList<Customer> Customers)
    {

    }


    public static int Is_login_successfully(String username,String password,ArrayList<Customer> cust)
     {
         for(int i=0;i< cust.size();i++)
         {
             Customer customer=cust.get(i);  //to get the current Customer object from the ArrayList.
             if(customer.getUsername().equals(username) && customer.getPassword().equals(password))
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
        System.out.println("your country "+getCountry());
        System.out.println("you made trips of number "+getTotaltrips());
        System.out.println("you get vouchers of number "+getVouchers());
    }
    public boolean Home_Page(){
        return true;
    }
    public void Register(ArrayList<Admin> Admins, ArrayList<Customer> Customers, ArrayList<Manager> Managers,ArrayList<TourGuide> TourGuides) {

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
//    public void BookTickets(Ticket t){
//        System.out.println("How many seats you want ? ");
//        Scanner in=new Scanner(System.in);
//        int seats=in.nextInt();
//        if(seats<=t.checkAvailableSeats())
//        {
//            tickets.add(t);
//            System.out.println("Do you want to reserve a flight ");
//            String choice=in.next();
//            if(choice.equals("yes") ||choice.equals("Yes"))
//            {
//                Flight f1=new Flight();
//                System.out.println("what is your destination? ");
//                String ans= in.next();
//                f1.setdestination(ans);
//                System.out.println("what is your depature? ");
//                ans= in.next(); //???????????????
//                f1.setdepature(ans);
//                System.out.println("flight is reserved successfully ");
//                System.out.println("the price is "+f1.calcprice());
//                System.out.println("the arrival time is "+f1.getarrivaltime());
//            }
//            else {
//                System.out.println("Do you want to reserve an hotel ? ");
//                choice=in.next();
//                if(choice.equals("yes") ||choice.equals("Yes")){
//                    Hotel h1=new Hotel();
//                    System.out.println("How many rooms");
//                    int rooms =in.nextInt();
//                    if(h1.availablerooms()==true)
//                        System.out.println("reservation done");
//                    else
//                        System.out.println("no available rooms");
//                    System.out.println("the budget is "+h1.calcprice(rooms));
//                }
//                else {
//                    System.out.println("Do you want to reserve an car ? ");
//                    choice=in.next();
//                    if(choice.equals("yes") ||choice.equals("Yes")){
//
//
//                    }
//                    else
//                        System.out.println("have a nice trip ");
//                }
//            }
//        }
//        else {
//            System.out.println("No seats available try choose another ticket ");
//
       }

