package cis.travel.eg.User;

import cis.travel.eg.Main.Main;
import cis.travel.eg.Main.Ticket;
import cis.travel.eg.Trip.Trip;
import cis.travel.eg.User.TourGuideDetails.TourGuide;

import java.io.Serializable;
import java.util.ArrayList;

import static cis.travel.eg.Main.Main.in;
import static cis.travel.eg.Main.Main.input;

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


    /////////Methods//////////
    public boolean HomePage(ArrayList<Admin> Admins, ArrayList<Customer> Customers, ArrayList<TourGuide> TourGuides, ArrayList<Manager> Managers, ArrayList<Trip> Trips_system) {
        // After login:
        // home page(edit profile , view profile, add/ create(tourGuide account || admin account || customer account), All customer, All tourGuide,Trip , Hotel , car rental ,logout)
        int Case = 0;
        do {
            System.out.println("\t\t\t\t\t\t\t╔══════════════════════════════════════════════════════════════════════════════════════════════════════╗");
            System.out.println("\t\t\t\t\t\t\t║                                                                                            Exit[0]   ║");
            System.out.println("\t\t\t\t\t\t\t║                                                                                                      ║");
            System.out.println("\t\t\t\t\t\t\t║                                                                                                      ║");
            System.out.println("\t\t\t\t\t\t\t║                                  Welcome " + super.getFirstName() + " " + super.getLastName());
            System.out.println("\t\t\t\t\t\t\t║                                                                                                      ║");
            System.out.println("\t\t\t\t\t\t\t║ My Profile  [1]  |  Create account [2]  |  All Customer [3]  |  All TourGuide [4]  |   Log out  [5]  ║");
            System.out.println("\t\t\t\t\t\t\t║                                                                                                      ║");
            System.out.println("\t\t\t\t\t\t\t║                                                                                                      ║");
            System.out.println("\t\t\t\t\t\t\t║                                                                                                      ║");
            System.out.println("\t\t\t\t\t\t\t║                                                                                                      ║");
            System.out.print("\n\n\t\t\t\t\t\t\t   ");

            Case = input(0, 5);
            while (Case > 0 && Case < 5) {
                design_homePage(Case);
                switch (Case) {
                    case 1:
                        Case = Display_Profile(Admins, Customers, Managers, TourGuides);
                        break;
                    case 2:
                        System.out.println(" Choose one of them you want to create an account for : ");
                        System.out.print("\n\n\t\t\t\t\t\t\t    1. Admin \n\n\t\t\t\t\t\t\t    2. Customer  \n\n\t\t\t\t\t\t\t    3. TourGuide \n\n\t\t\t\t\t\t\t     ");
                        Case = createAccount(in.nextInt(), Admins, Customers, Managers, TourGuides);
                        break;
                    case 3:  //All customer
                        break;
                    case 4: //All tourGuide
                        break;
                    case 5: Case = 5;
                        break;
                }
            }
        } while (Case == -1);
        return Case == 0;  // if Case == 0 --> return true else(Case == 5) return 0;
        // return true; --> Exit  , return false;  --> Log out
    }

    public void Register(ArrayList<Admin> Admins, ArrayList<Customer> Customers, ArrayList<Manager> Managers, ArrayList<TourGuide> TourGuides) {

        // Register Page
        System.out.println("\u001B[34m╭───────────────────────────────────────────────────────────╮");
        System.out.println("\u001B[34m│          " + Main.ANSI_COLORS[16] + "               Register       " + Main.ANSI_COLORS[5] + "                   │");
        System.out.println("\u001B[34m├───────────────────────────────────────────────────────────┤");
        System.out.print("\u001B[34m│ First Name: ");
        super.setFirstName(in.next());
        System.out.println("\u001B[34m├───────────────────────────────────────────────────────────┤");
        System.out.print("\u001B[34m│ Last Name: ");
        super.setLastName(in.next());
        System.out.println("\u001B[34m├───────────────────────────────────────────────────────────┤");
        System.out.print("\u001B[34m│ Username: ");
        super.setUsername(in.next(), Admins, Customers, Managers, TourGuides);
        System.out.println("\u001B[34m├───────────────────────────────────────────────────────────┤");
        while (true) {
            System.out.print("\u001B[34m│ password: ");
            String pass = in.next();
            System.out.println("\u001B[34m├───────────────────────────────────────────────────────────┤");
            System.out.print("\u001B[34m│ Confirmation Password: ");
            if (super.setPassword(pass, in.next())) break;
        }
        System.out.println("\u001B[34m├───────────────────────────────────────────────────────────┤");
        while (true) {
            System.out.print("│ Phone Number: ");
            if (super.setPhoneNumber(in.next()))
                break;
        }
        System.out.println("\u001B[34m├───────────────────────────────────────────────────────────┤");
        System.out.print("│ Email (example@gmail.com): ");
        while (true) {
            if (super.setEmail(in.next())) break;
        }
        System.out.println("\u001B[34m├───────────────────────────────────────────────────────────┤");
        System.out.print("│ Gender (M/F) ");
        super.setGender(in.next().charAt(0));
        System.out.println("\u001B[34m├───────────────────────────────────────────────────────────┤");
        System.out.print("│ Age: ");
        while (true) {
            if (super.setAge(input(10, 100))) break;
        }
        System.out.println("\u001B[34m├───────────────────────────────────────────────────────────┤");
        System.out.print("│ Company Name: ");
        setCompanyName(in.next());
        System.out.println("\u001B[34m╰───────────────────────────────────────────────────────────╯\u001B[0m");



        // setCompanyID(); Static int count = 0;
        //count++ inside constructor
    }

    public static int Is_login_successfully(String username, String password, ArrayList<Admin> admin) {

        for (int i = 0; i < admin.size(); i++) {
            if (admin.get(i).getUsername().equals(username) && admin.get(i).getUsername().equals(password)) {
                return i; // Login is successfully
            }
        }
        return -1;
    }

    public static int FoundUsername(String username, ArrayList<Admin> admin) {
        //another solution --> Stream APIs

        for (int i = 0; i < admin.size(); i++) {
            if (admin.get(i).getUsername().equals(username)) {
                return i;    // return index
            }
        }
        return -1;
    }

    public int Display_Profile(ArrayList<Admin> admin, ArrayList<Customer> customer, ArrayList<Manager> manager, ArrayList<TourGuide> tourGuide) {
        // view profile
        System.out.println("╔════════════════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║                                    My Profile                                      ║");
        System.out.println("║════════════════════════════════════════════════════════════════════════════════════║");
        System.out.println("║                                                                                    ║");
        System.out.println("║       ════════════════════════                                                     ║");
        System.out.println("║      ║      First Name        ║      " + super.getFirstName());
        System.out.println("║       ════════════════════════                                                     ║");
        System.out.println("║                                                                                    ║");
        System.out.println("║       ════════════════════════                                                     ║");
        System.out.println("║      ║       Last Name        ║      " + super.getLastName());
        System.out.println("║       ════════════════════════                                                     ║");
        System.out.println("║                                                                                    ║");
        System.out.println("║       ════════════════════════                                                     ║");
        System.out.println("║      ║        Username        ║      " + super.getUsername());
        System.out.println("║       ════════════════════════                                                     ║");
        System.out.println("║                                                                                    ║");
        System.out.println("║       ════════════════════════                                                     ║");
        System.out.println("║      ║      Phone number      ║      " + super.getPhoneNumber());
        System.out.println("║       ════════════════════════                                                     ║");
        System.out.println("║                                                                                    ║");
        System.out.println("║       ════════════════════════                                                     ║");
        System.out.println("║      ║         Email          ║      " + super.getEmail());
        System.out.println("║       ════════════════════════                                                     ║");
        System.out.println("║                                                                                    ║");
        System.out.println("║       ════════════════════════                                                     ║");
        System.out.print("║      ║       Gender (M/F)     ║      ");
        if (super.getGender() == 'F') {
            System.out.println("Female");
        } else {
            System.out.println("Male");
        }
        System.out.println("║       ════════════════════════                                                     ║");
        System.out.println("║                                                                                    ║");
        System.out.println("║       ════════════════════════                                                     ║");
        System.out.println("║      ║          Age           ║      " + super.getAge());
        System.out.println("║       ════════════════════════                                                     ║");
        System.out.println("║                                                                                    ║");
        System.out.println("║       ════════════════════════                                                     ║");
        System.out.println("║      ║      Company Name      ║      " + getCompanyName());
        System.out.println("║       ════════════════════════                                                     ║");
        System.out.println("║                                                                                    ║");
        System.out.println("║                                                                                    ║");
        System.out.println("╚════════════════════════════════════════════════════════════════════════════════════╝");

        System.out.println("       1. Edit your Profile \n       2. Home page \n       3. Exit");
        int choice = in.nextInt();
        if (choice == 1) return Edit_Profile(admin, customer, manager, tourGuide);
        else return (choice == 2 ? -1 : 0);

    }

    public int Edit_Profile(ArrayList<Admin> admin, ArrayList<Customer> customer, ArrayList<Manager> manager, ArrayList<TourGuide> tourguide) {
        String pass1, pass2;
        do {
            System.out.println("welcome " + super.getUsername());
            System.out.println("choose which option you want to change ");
            System.out.println(" 1)  first name \n2) Last name \n 3) Password \n 4) Company Name \n 5) Age \n 6) Email \n 7) Phone number ");
            switch (input(1, 6)) {
                case 1:
                    System.out.println("please enter your first name ");
                    super.setFirstName(in.next());//????????????
                    System.out.println("Done successfully " + super.getFirstName());
                    break;
                case 2:
                    System.out.println("please enter your last name ");
                    super.setLastName(in.next());
                    System.out.println("Done sussefully " + super.getLastName());
                    break;
                case 3:
                    System.out.println("please enter your new password");
                    pass1 = in.next();
                    System.out.println("Write again");
                    pass2 = in.next();
                    super.setPassword(pass1, pass2);
                    System.out.println("Done successfully ");
                    break;
                case 4:
                    System.out.println(" Enter your new company name ");
                    setCompanyName(in.next());
                    System.out.println("Done successfully your new company name now is " + getCompanyName());
                    break;
                case 5:
                    System.out.println(" Enter your age ");
                    super.setAge(input(10, 100));
                    System.out.println("Done successfully");
                    break;
                case 6: System.out.println(" Enter your Email ");
                        super.setEmail(in.next());
                    System.out.println("Done successfully your new Email now is " + getEmail());
                   break;
                case 7: System.out.println(" Enter your phone number ");
                    super.setPhoneNumber(in.next());
                    System.out.println("Done successfully your new phone number now is " + getPhoneNumber());
                    break;
            }
            System.out.println("Do you want to make another change(y,n)?");

        } while (confirm(in.next().charAt(0)));

        System.out.println("1. Display Profile \n        2. Home page \n       3. Exit");
        int option = input(1, 3);
        return ( option == 1 ? 1 : (option == 2) ? -1 : 0);

    }

    public int createAccount(int userType, ArrayList<Admin> Admins, ArrayList<Customer> Customers, ArrayList<Manager> Managers, ArrayList<TourGuide> TourGuides) {
        //Switch (case 1: admin, case 2: customer, case 3: tourGuide)
        switch (userType) {
            case 1:
                Admins.add(new Admin());
                Admins.get(Admins.size() - 1).Register(Admins, Customers, Managers, TourGuides);
                break;
            case 2:
                Customers.add(new Customer());
                Customers.get(Customers.size() - 1).Register(Admins, Customers, Managers, TourGuides);
                break;
            case 3:
                TourGuides.add(new TourGuide());
                TourGuides.get(TourGuides.size() - 1).Register(Admins, Customers, Managers, TourGuides);
                break;
        }
        System.out.println(Main.ANSI_COLORS[3] + "            * Created Successfully *" + Main.ANSI_COLORS[0]);
        System.out.println("       1. Create another account \n       2. Home page \n       3. Exit");
        int choice = input(1, 3);
        return (choice == 1 ? 2 : (choice == 2) ? -1 : 0);
    }

    public void design_homePage(int Case) {
        System.out.println("\t\t\t\t\t\t\t╔══════════════════════════════════════════════════════════════════════════════════════════════════════╗");
        System.out.println("\t\t\t\t\t\t\t║                                                                                             Exit[0]  ║");
        System.out.println("\t\t\t\t\t\t\t║                                  Welcome " + super.getFirstName() + " " + super.getLastName());
        System.out.println("\t\t\t\t\t\t\t║                                                                                                     ║");

        switch (Case) {
            case 1:
                System.out.println("\t\t\t\t\t\t\t  " + Main.ANSI_COLORS[5] + "My Profile  [1]" + Main.ANSI_COLORS[0] + "  |  Create account [2]  |  All Customer [3]  |  All TourGuide [4]  |   Log out  [5] ║");
                break;
            case 2:
                System.out.println("\t\t\t\t\t\t\t║ My Profile  [1]  |  " + Main.ANSI_COLORS[5] + "Create account [2]" + Main.ANSI_COLORS[0] + "  |  All Customer [3]  |  All TourGuide [4]  |   Log out  [5] ║");
                break;
            case 3:
                System.out.println("\t\t\t\t\t\t\t║ My Profile  [1]  |  Create account [2]  |  " + Main.ANSI_COLORS[5] + "All Customer [3]" + Main.ANSI_COLORS[0] + "  |  All TourGuide [4]  |   Log out  [5] ║");
                break;
            case 4:
                System.out.println("\t\t\t\t\t\t\t║ My Profile  [1]  |  Create account [2]  |  All Customer [3]  |  " + Main.ANSI_COLORS[5] + "All TourGuide [4]" + Main.ANSI_COLORS[0] + "  |   Log out  [5] ║");
                break;
            case 5:
                System.out.println("\t\t\t\t\t\t\t║ My Profile  [1]  |  Create account [2]  |  All Customer [3]  |  All TourGuide [4]  |   " + Main.ANSI_COLORS[5] + "Log out  [5]" + Main.ANSI_COLORS[0] + " ║");
                break;
        }

        System.out.println("\t\t\t\t\t\t\t║                                                                                                     ║");
        System.out.println("\t\t\t\t\t\t\t║                                                                                                     ║");
        System.out.println("\t\t\t\t\t\t\t║                                                                                                     ║");
        System.out.println("\t\t\t\t\t\t\t║                                                                                                     ║");
        System.out.print("\n\n\t\t\t\t\t\t\t   ");

    }

    public boolean confirm(char ans) {
        if (ans == 'N' || ans == 'n') {
            return false;
        } else if (ans == 'Y' || ans == 'y') {
            return true;
        } else {
            System.out.println("invalid input, enter again: \n ");
            return confirm(in.next().charAt(0));
        }
    }
//    public static void moveToPosition(int x, int y) {
//        // Move to the beginning of the line
//        System.out.print("\r");
//
//        // Move down y lines
//        for (int i = 0; i < y; i++) {
//            System.out.println();
//        }
//
//        // Move to the right x characters
//        for (int i = 0; i < x; i++) {
//            System.out.print(" ");
//        }
//    }

}
