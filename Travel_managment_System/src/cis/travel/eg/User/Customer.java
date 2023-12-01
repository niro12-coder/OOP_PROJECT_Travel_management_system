package cis.travel.eg.User;
import cis.travel.eg.Main.*;
import cis.travel.eg.Service.*;
import java.util.ArrayList;
import java.util.Scanner;
public class Customer {
    private String country;
    private String preferedcurrency;
    private String preferedlanguage;
    private String preferedpayment;
    private int totaltrips;
    private ArrayList <Ticket> tickets;
    private ArrayList <Voucher> vouchers;
    public Customer(){};
    public Customer(String country){

        this.country=country;
    }

    public Customer(String country,String preferedcurrency,String preferedlanguage,String preferedpayment){
        this(country);
        this.preferedcurrency=preferedcurrency;
        this.preferedlanguage=preferedlanguage;
        this.preferedpayment=preferedpayment;
    }
    public Customer(String username,String firstname,String lastname,String password,int phone ,int age,String country,String prefeeredcurrency,String preferedlanguage,String preferedpayment){
        super(username,firstname,lastname,password,phone,age);
        this.country=country;
        this.preferedcurrency=preferedcurrency;
        this.preferedlanguage=preferedlanguage;
        this.preferedpayment=preferedpayment;
    }
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

    //override method
    public void Edit_Profile(String fname,String lname,String username,String password){
        super.FirstName=fname;
        super.LastName=lname;
        super.Username=username;
        super.Password=password;
    }
    public void Edit_Profile(String preferedpayment,String prefeeredcurrency,String preferedlanguage){
        this.preferedpayment=preferedpayment;
        this.prefeeredcurrency=prefeeredcurrency;
        this.preferedlanguage=preferedlanguage;
    }
    public void Edit_Profile(String fname,String lname,String username,String password,String preferedpayment,String prefeeredcurrency,String preferedlanguage){
        super.FirstName=fname;
        super.LastName=lname;
        super.Username=username;
        super.Password=password;
        this.preferedpayment=preferedpayment;
        this.preferedcurrency=preferedcurrency;
        this.preferedlanguage=preferedlanguage;
    }

     public int Is_login_successfully(ArrayList<Customer> cust,String username,String password)
     {
         for(int i=0;i< cust.size();i++)
         {
             Customer customer=cust.get(i);  //to get the current Customer object from the ArrayList.
             if(customer.GetUsername().equals(username) && customer.GetPassword().equals(password))
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
        System.out.println("your country "+getCountry());
        System.out.println("you made trips of number "+getTotaltrips());
        System.out.println("you get vouchers of number "+getVouchers());
    }
    public void Home_Page(){

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
//        }
//    }
}
