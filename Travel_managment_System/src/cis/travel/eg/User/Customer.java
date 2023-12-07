package cis.travel.eg.User;

import java.util.List;

import cis.travel.eg.Main.Ticket;
import cis.travel.eg.Main.Voucher;
import cis.travel.eg.Trip.Trip;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.IntStream;

import cis.travel.eg.Service.Activity;


public class Customer extends User {
    Scanner in = new Scanner(System.in);
    private String confiremedpass;
    private String country;
    private String preferedcurrency;
    private String preferedlanguage;
    private String preferedpayment;
    private int totaltrips;
    private ArrayList<Ticket> tickets;
    private ArrayList<Voucher> vouchers;
    private List<Activity> allActivities; // All activities added
    private List<Activity> familyActivities; // Activities suitable for family trip
    private List<Activity> coupleActivities; // Activities suitable for couple trip
    private List<Activity> generalActivities; // Activities suitable for general trip
    private ArrayList<Trip> trip;

    public Customer() {
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

    static int input(int a, int b) {
        Scanner INPUT = new Scanner(System.in);
        int number = INPUT.nextInt();
        if (number < a && number > b) {
            System.out.print(" Invalid input \n ");
            number = input(a, b);
        }
        return number;
    }

    public int Edit_Profile(ArrayList<Admin> admin, ArrayList<Customer> customer, ArrayList<Manager> manager, ArrayList<TourGuide> tourguide) {
        String choice, fname, lname, country, pass1, pass2;
        int option, age;
        do {
            System.out.println("welcome " + super.getUsername());
            System.out.println("choose which option you want to change ");
            System.out.println(" 1)  first name \n2) Last name \n 3) Password \n 4) Country \n  5) Age \n");
            option = in.nextInt();
            switch (option) {
                case 1:
                    System.out.println("please enter your first name ");
                    fname = in.next();
                    super.setFirstName(fname);//????????????
                    System.out.println("Done successfully " + super.getFirstName());
                    break;
                case 2:
                    System.out.println("please enter your last name ");
                    lname = in.next();
                    super.setLastName(lname);
                    System.out.println("Done sussefully " + super.getLastName());
                    break;
                case 3:
                    System.out.println("please enter your new password");
                    pass1 = in.next();
                    System.out.println("Write again");
                    pass2 = in.next();
                    super.setPassword(pass1, pass2);
                    System.out.println("Done sussefully ");
                    break;
                case 4:
                    System.out.println("please enter your new country ");
                    country = in.next();
                    setCountry(country);
                    System.out.println("Done sussefully your new country now is " + getCountry());
                    break;
                case 5:
                    System.out.println("please enter your age ");
                    age = in.nextInt();
                    super.setAge(age);
                    System.out.println("Done sussefully");
                    break;
                default:
                    System.out.println(" invalid choice try again ");
                    option = in.nextInt();
            }
            System.out.println("Do you want to make another change ? ");
            choice = in.next();
        } while (choice.toLowerCase().equals("yes"));


        System.out.println("       1. Home page \n       2. Exit");
        option = input(1, 2);
        return (option == 1 ? 1 : 0);

    }

    public int Display_Profile(ArrayList<Admin> admin, ArrayList<Customer> customer, ArrayList<Manager> manager, ArrayList<TourGuide> tourguide) {
        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("**********WELCOME**********");
        System.out.println("your first name " + super.getFirstName());
        System.out.println("-----------------------------------------");
        System.out.println("your last name " + super.getLastName());
        System.out.println("-----------------------------------------");
        System.out.println("your country " + getCountry());
        System.out.println("-----------------------------------------");
        System.out.println("you made trips of number " + getTotaltrips());
        System.out.println("-----------------------------------------");
        System.out.println("you get vouchers of number " + getVouchers());
        System.out.println("╚═══════════════════════════════════════════╝");

        Scanner input = new Scanner(System.in);
        System.out.println("       1. Edit your Profile \n       2. Home page \n       3. Exit");
        int choice = input.nextInt();
        if (choice == 1) return Edit_Profile(admin, customer, manager, tourguide);
        else return (choice == 2 ? 1 : 0);

    }

    public boolean HomePage(ArrayList<Admin> Admins, ArrayList<Customer> Customers, ArrayList<TourGuide> TourGuides, ArrayList<Manager> Managers, ArrayList<Trip> Trips_system) {

        Scanner INPUT = new Scanner(System.in);
        System.out.println("\t\t__ Welcome _");
        System.out.println("\t\t 1)My Profile");
        System.out.println("\t\t 2)book a ticket");
        System.out.println("\t\t 3)view booked tickets");
        System.out.println("\t\t 4)cancel booking");
        System.out.println("\t\t 5)edit travel");
        System.out.println("\t\t 6)reschedule booking");
        System.out.println("\t\t 7) check discount ticket");
        System.out.println("\t\t 8)FeedbackTrinp_calc_localtime");
        System.out.println("\t\t9)log out ");

        int Case = input(1, 9);
        while (Case > 0 && Case < 10) {

            switch (Case) {
                case 1:

                default:
                    System.out.println(" Invalid input \n");
                    Case = INPUT.nextInt();
                    break;
            }
        }
        return true;

    }

    public void Register(ArrayList<Admin> Admins, ArrayList<Customer> Customers, ArrayList<Manager> Managers, ArrayList<TourGuide> TourGuides) {

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

    public static int Is_login_successfully(String username, String password, ArrayList<Customer> cust) {
        for (int i = 0; i < cust.size(); i++) {
            Customer customer = cust.get(i);  //to get the current Customer object from the ArrayList.
            if (customer.getUsername().equals(username) && customer.getPassword().equals(password)) {
                return i;
            }
        }
        return -1;
    }

    static public int FoundUsername(String username, ArrayList<Customer> Customers) {
        return IntStream.range(0, Customers.size())
                .filter(i -> Customers.get(i).getUsername().equals(username))
                .findFirst()
                .orElse(-1);
    }

    public void displayAllActivities() {
        System.out.println("All Activities:");
        for (Activity activity : allActivities) {
            System.out.println(activity.getName() + " - " + activity.getSuitableFor());
            activity.displayActivityDetails();
        }
    }

    public void displayActivitiesByTripType(String tripType) {
        System.out.println("Activities suitable for " + tripType + " trip:");
        List<Activity> activities = null;
        switch (tripType) {
            case "Family":
                activities = familyActivities;
                break;
            case "Couple":
                activities = coupleActivities;
                break;
            case "General":
                activities = generalActivities;
                break;
            default:
                System.out.println("Invalid trip type!");
        }
        int count = 0;
        if (activities != null) {
            for (Activity activity : activities) {
                System.out.println(activity.getName());
                activity.setActivityindex(++count);
                System.out.print(count + ". ");
                activity.displayActivityDetails();
            }
        }


    }
        public int Book_Tickect (ArrayList < Trip > trip, ArrayList < Ticket > ticket){
            System.out.println("what is your destination ?");
            String destination = in.next();
            System.out.println("  which tour type do you want ?");
            System.out.println("  1. couple tour \n 2.family tour \n 3. general tour ");
            String TourType = null;
            switch (input(1, 3)) {
                case 1:
                    TourType = "couple";
                    break;
                case 2:
                    TourType = "family";
                    break;
                case 3:
                    TourType = "general";
                    break;
            }
            System.out.println("do you want choose by a certain time");
            String choice = in.next();
            if (choice.toLowerCase().equals('y')) {
                System.out.println(" 1. Day \n 2. Date");
                if(input(1, 2) == 1){
                    // dayDisplay();
                    //calenderDate();
                   // displayTripByDate();
                }
                else {
                    // displayTripByDate();
                }

            } else {
                displayTripByDestination_Type(trip,destination,TourType);
            }
            System.out.println(" Now , Choose the activity you want : ");
            displayActivitiesByTripType(TourType);
            System.out.println(" Enter the number of the activity you want: ");

            return 1;

        }
//        public void displayTripByDestination_Type (ArrayList < Trip > trip, String destination, String TourType ){
//                    IntStream.range(0,trip.size())
//                    .filter(i-> trip.get(i).getDestination().equals(destination) && trip.get(i).getTripType().equals(TourType))
//                    .forEach(trips -> trip.);
//
//        }
    public void displayTripByDestination_Type(ArrayList<Trip> trips, String destination, String tourType) {
        IntStream.range(0, trips.size())
                .filter(i -> trips.get(i).getDestination().equals(destination) && trips.get(i).getTripType().equals(tourType))
                .forEach(i -> {
                    trips.get(i).displayDetails();
                });
    }

}




        /*void reference_time(int year2, int day1, int& day2)
{
    const int year1 = 2021; // el reference beta3y
    day2 = (year2 - year1) + ((year2 - year1) / 4);
    day2 %= 7;
    day2 = (day1 - day2);
    if (day2 <= 0) day2 += 7;
}
void leap_year(int YEAR)
{
    if ((YEAR % 4 == 0) && (YEAR % 100 != 0) || (YEAR % 400 == 0)) month_value[1] = 29;
    else month_value[1] = 28; // Leap Year
*/

/*


String calender_date(string* day_name, int& DAY, int& MONTH, int& YEAR, int& w__day)
{
    int w_day;
    leap_year(YEAR);
    w_day = dayy(*day_name);

    if (w_day >= (w__day))
        DAY += (w_day - (w__day));
    else
        DAY += (7 - (w__day)) + w_day;
    if (DAY > month_value[MONTH - 1])
    {
        DAY %= month_value[MONTH - 1];
        MONTH = (MONTH)+1;
        if (MONTH > 12)
        {
            YEAR++;
            MONTH %= 12;
        }
    }
    w__day = w_day;
    date = "yyyy-mm-dd'
    retun date;
}

 */


//    public void BookTickets(ArrayList<Ticket> ticket){
//        System.out.println("How many seats do you want ? ");
//        Scanner in = new Scanner(System.in);
//        int seats=in.nextInt();
//        if(seats<=ticket.checkAvailableSeats())
//        {
//            ticket.add();
//            System.out.println("Do you want to reserve a flight ");
//            String choice=in.next();
//            if(choice.equals("yes") ||choice.equals("Yes"))
//            {
//                Flight f1 = new Flight();
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
//}

