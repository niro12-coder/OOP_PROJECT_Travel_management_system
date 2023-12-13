package cis.travel.eg.User;

import cis.travel.eg.Main.Main;
import cis.travel.eg.Trip.Trip;
import cis.travel.eg.User.TourGuideDetails.TourGuide;

import java.io.Serializable;
import java.util.ArrayList;

import static cis.travel.eg.Main.Main.in;

public class Admin extends User implements Serializable {


    private String companyName;
    private int companyID;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getCompanyID() {
        return companyID;
    }

    public void setCompanyID(int companyID) {
        this.companyID = companyID;
    }


    static int input(int a, int b) {

        int number = in.nextInt();
        if (number < a && number > b) {
            System.out.print(" Invalid input \n ");
            number = input(a, b);
        }
        return number;
    }

    /////////Methods//////////
    public boolean HomePage(ArrayList<Admin> Admins, ArrayList<Customer> Customers, ArrayList<TourGuide> TourGuides, ArrayList<Manager> Managers, ArrayList<Trip> Trips_system) {
        // After login:
        // home page(edit profile , view profile, add/ create(tourGuide account || admin account || customer account), All customer, All tourGuide,Trip , Hotel , car rental ,logout)

        System.out.println("\t\t\t\t\t\t\t-------------------------------------------------------------------------------------------------------");
        System.out.println("\t\t\t\t\t\t\t                                                                                              Exit[0]  ");
        System.out.println("\t\t\t\t\t\t\t                                             __ Welcome __                                             ");
        System.out.println("\t\t\t\t\t\t\t                                                                                                       ");
        System.out.println("\t\t\t\t\t\t\t  My Profile  [1]  |  Create account [2]  |  All Customer [3]  |  All TourGuide [4]  |   Log out  [5]  ");
        System.out.println("\t\t\t\t\t\t\t                                                                                                       ");
        System.out.println("\t\t\t\t\t\t\t                                                                                                       ");
        System.out.println("\t\t\t\t\t\t\t                                                                                                       ");
        System.out.println("\t\t\t\t\t\t\t                                                                                                       ");

        System.out.print("\n\n\t\t\t\t\t\t\t   ");

        int Case = input(0, 6);
            while (Case > 0 && Case < 5) {
                design_homePage(Case);
                switch (Case) {
                    case 1:
                        Case = Display_Profile(Admins, Customers, Managers, TourGuides);
                        break;
                    case 2:
                        System.out.println(" Choose one of them you want to create an account for : ");
                        System.out.print("\n\n\t\t\t\t\t\t\t    1. Admin \n\n\t\t\t\t\t\t\t    2. Customer  \n\n\t\t\t\t\t\t\t    3. TourGuide \n\n\t\t\t\t\t\t\t     ");
                        Case = createAccount(in.nextInt());
                        break;
                    case 3:  //All customer
                        break;
                    case 4: //All tourGuide
                        break;
                    default:
                        System.out.println(" Invalid input \n");
                        Case = in.nextInt();
                        break;
                }
            }

        return Case == 0;  // if Case == 0 --> return true else(Case == 5) return 0;
       // return true; --> Exit  , return false;  --> Log out
    }

    public void Register(ArrayList<Admin> admin, ArrayList<Customer> customer, ArrayList<Manager> manager, ArrayList<TourGuide> tourguide) {


        // Register Page
        System.out.println(" ");
        setFirstName(in.next());
        System.out.println(" ");
        setLastName(in.next());
        System.out.println(" ");
        setUsername(in.next(), admin, customer, manager, tourguide);
        System.out.println(" ");
        String pass = in.next();
        System.out.println(" confirm");
        setPassword(pass, in.next());
        System.out.println(" ");
        setPhoneNumber(in.next());
        System.out.println(" ");
        setEmail(in.next());
        System.out.println(" ");
        // setGender();
        System.out.println(" ");
        setCompanyName(in.next());
        System.out.println(" ");
        setCompanyID(in.nextInt());
    }

     public static int Is_login_successfully(String username, String password, ArrayList<Admin> admin) {

        for(int i = 0; i < admin.size(); i++){
            if(admin.get(i).getUsername().equals(username) && admin.get(i).getUsername().equals(password)){
                return i; // Login is successfully
            }
        }
        return -1;
    }

    public static int FoundUsername(String username, ArrayList<Admin> admin) {
        //another solution --> Stream APIs

        for(int i = 0; i < admin.size(); i++){
            if(admin.get(i).getUsername().equals(username)){
                return i;    // return index
            }
        }
        return -1;
    }

    public int Display_Profile(ArrayList<Admin> admin, ArrayList<Customer> customer, ArrayList<Manager> manager, ArrayList<TourGuide> tourguide) {
        // View Profile

        System.out.println("       1. Edit your Profile \n       2. Home page \n       3. Exit" );
        int choice = in.nextInt();
        if(choice == 1) return Edit_Profile( admin,  customer, manager, tourguide);
        else return (choice == 2 ? 1 : 0);

    }

        public int Edit_Profile(ArrayList<Admin> admin, ArrayList<Customer> customer, ArrayList<Manager> manager, ArrayList<TourGuide> tourguide) {

        int choice;
        // choose one option to edit
        System.out.println("  1. Name \n\n  2. Username \n\n  3. Password  \n\n  4. Age \n\n 5. Phone number \n\n  6. Email ");
        choice = input(1, 6);
        switch (choice){
            case 1:
                System.out.print(" Enter the First Name :  ");
                setFirstName(in.next());
                System.out.print("\n  Enter the Last Name :  ");
                setLastName(in.next());
                break;
            case 2:
                System.out.println("  Enter the new username:  ");
                setUsername(in.next(), admin, customer, manager, tourguide);
                break;
            case 3:

                System.out.println("  Enter new password ");
                String pass = in.next();
                System.out.println(" Enter confirmation password ");
                setPassword(pass, in.next());
                break;
            case 4:
                System.out.println(" Enter your Age");
                setAge(in.nextInt());
                break;
            case 5:
                System.out.println(" Enter new Phone Number : ");
                setPhoneNumber(in.next());
                break;
            case 6:
                System.out.println("Enter new Email : ");
                setEmail(in.next());
                break;
        }

        System.out.println("       1. Home page \n       2. Exit" );
        choice = input(1, 2);
        return (choice == 1 ? 1 : 0);
    }

    public int createAccount(int userType) {
        //Switch (case 1: admin, case 2: customer, case 3: tourGuide)
        switch(userType){
            case 1:  //admin
                break;
            case 2:   // customer
                break;
            case 3:    // TourGuide
                break;
        }
        System.out.println(Main.ANSI_COLORS[3] + "            * Created Successfully *" + Main.ANSI_COLORS[0]);
        System.out.println("       1. Create another account \n       2. Home page \n       3. Exit" );
        int choice = input(1, 3);
        return (choice == 1 ? 2 : (choice == 2) ? 1 : 0);
    }

    public void design_homePage(int Case) {
        System.out.println("\t\t\t\t\t\t\t-------------------------------------------------------------------------------------------------------");
        System.out.println("\t\t\t\t\t\t\t                                                                                              Exit[0]  ");
        System.out.println("\t\t\t\t\t\t\t                                             __ Welcome __                                             ");
        System.out.println("\t\t\t\t\t\t\t                                                                                                       ");

        switch (Case) {
            case 1:
                System.out.println("\t\t\t\t\t\t\t  " + Main.ANSI_COLORS[5] +  "My Profile  [1]" + Main.ANSI_COLORS[0] + "  |  Create account [2]  |  All Customer [3]  |  All TourGuide [4]  |   Log out  [5]  ");
                break;
            case 2:
                System.out.println("\t\t\t\t\t\t\t  My Profile  [1]  |  " + Main.ANSI_COLORS[5] + "Create account [2]" + Main.ANSI_COLORS[0] + "  |  All Customer [3]  |  All TourGuide [4]  |   Log out  [5]  ");
                break;
            case 3:
                System.out.println("\t\t\t\t\t\t\t  My Profile  [1]  |  Create account [2]  |  " + Main.ANSI_COLORS[5] + "All Customer [3]" + Main.ANSI_COLORS[0] + "  |  All TourGuide [4]  |   Log out  [5]  ");
                break;
            case 4:
                System.out.println("\t\t\t\t\t\t\t  My Profile  [1]  |  Create account [2]  |  All Customer [3]  |  " + Main.ANSI_COLORS[5] + "All TourGuide [4]" + Main.ANSI_COLORS[0] + "  |   Log out  [5]  ");
                break;
            case 5:
                System.out.println("\t\t\t\t\t\t\t  My Profile  [1]  |  Create account [2]  |  All Customer [3]  |  All TourGuide [4]  |   " + Main.ANSI_COLORS[5] + "Log out  [5]" + Main.ANSI_COLORS[0] + "  ");
                break;
        }

        System.out.println("\t\t\t\t\t\t\t                                                                                                       ");
        System.out.println("\t\t\t\t\t\t\t                                                                                                       ");
        System.out.println("\t\t\t\t\t\t\t                                                                                                       ");
        System.out.println("\t\t\t\t\t\t\t                                                                                                       ");
         System.out.print("\n\n\t\t\t\t\t\t\t   ");


    }

        public static void moveToPosition(int x, int y) {
        // Move to the beginning of the line
        System.out.print("\r");

        // Move down y lines
        for (int i = 0; i < y; i++) {
            System.out.println();
        }

        // Move to the right x characters
        for (int i = 0; i < x; i++) {
            System.out.print(" ");
        }
    }

}
