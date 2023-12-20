package cis.travel.eg.User;

import cis.travel.eg.Main.Main;
import cis.travel.eg.Trip.Trip;
import cis.travel.eg.User.CustomerDetails.Customer;
import cis.travel.eg.User.TourGuideDetails.TourGuide;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.stream.IntStream;

import static cis.travel.eg.Main.Main.*;
import static cis.travel.eg.Service.helpingMethods.helpingMethods.confirm;

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
            System.out.println(ANSI_COLORS[16] + "\t\t\t\t\t\t\t╭─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────╮");
            System.out.println("\t\t\t\t\t\t\t│                                                                                                            Exit[0]      │");
            System.out.println("\t\t\t\t\t\t\t│                                                                                                                         │");
            System.out.println("\t\t\t\t\t\t\t│                                                                                                                         │");
            System.out.println("\t\t\t\t\t\t\t│                                  " + ANSI_COLORS[14] + "Welcome " + super.getFirstName() + " " + super.getLastName() + ANSI_COLORS[16]);
            System.out.println("\t\t\t\t\t\t\t│                                                                                                                         │");
            System.out.println("\t\t\t\t\t\t\t│ My Profile [1]  |  Create account [2]  |  All Customer [3]  |  All TourGuide [4]  |  All Managers [5]  | Log out  [6]   │");
            System.out.println("\t\t\t\t\t\t\t│                                                                                                                         │");
            System.out.println("\t\t\t\t\t\t\t│                                                                                                                         │");
            System.out.println("\t\t\t\t\t\t\t│                                                                                                                         │");
            System.out.println("\t\t\t\t\t\t\t│                                                                                                                         │");
            System.out.println("\t\t\t\t\t\t\t╰─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────╯");

            System.out.print("Enter choice: ");
            Case = input(0, 6);
            cls();
//            while (Case > 0 && Case < 5) {
            //design_homePage(Case);
            switch (Case) {
                case 0:
                    Case = 1;
                    break;
                case 1:
                    Case = Display_Profile(Admins, Customers, Managers, TourGuides);
                    break;
                case 2:
                    Case = createAccount(Admins, Customers, Managers, TourGuides);
                    break;
                case 3:  //All customer
                    if (Customers.isEmpty()) {
                        System.out.println("There is no Customers ¯\\_(ツ)_/¯");
                        sleep();
                    }
                    do {
                        int i = 1;
                        for (Customer customer : Customers) {
                            System.out.println(i + ")");
                            System.out.println("\u001B[34m╭──────────────────────────────────────────────────╮");
                            System.out.println("│              " + ANSI_COLORS[16] + "     **WELCOME**       " + ANSI_COLORS[5] + "           │");
                            System.out.println("├──────────────────────────────────────────────────┤");
                            System.out.println("│ Your First Name: " + ANSI_COLORS[16] + customer.getFirstName() + ANSI_COLORS[5]);
                            System.out.println("├──────────────────────────────────────────────────┤");
                            System.out.println("│ Your Last Name: " + ANSI_COLORS[16] + customer.getLastName() + ANSI_COLORS[5]);
                            System.out.println("├──────────────────────────────────────────────────┤");
                            System.out.println("│ Your Country: " + ANSI_COLORS[16] + customer.getCountry() + ANSI_COLORS[5]);
                            System.out.println("├──────────────────────────────────────────────────┤");
                            System.out.println("│ Your Gender: " + ANSI_COLORS[16] + customer.getGender() + ANSI_COLORS[5]);
                            System.out.println("├──────────────────────────────────────────────────┤");
                            System.out.println("│ Your Age: " + ANSI_COLORS[16] + customer.getAge() + ANSI_COLORS[5]);
                            System.out.println("├──────────────────────────────────────────────────┤");
                            System.out.println("│ Your Preferred Language: " + ANSI_COLORS[16] + customer.getPreferredLanguage() + ANSI_COLORS[5]);
                            System.out.println("├──────────────────────────────────────────────────┤");
                            System.out.println("│ Your Preferred Payment: " + ANSI_COLORS[16] + customer.getPreferredPayment() + ANSI_COLORS[5]);
                            System.out.println("├──────────────────────────────────────────────────┤");
                            System.out.println("│ Your Preferred Currency: " + ANSI_COLORS[16] + customer.getPreferredCurrency() + ANSI_COLORS[5]);
                            System.out.println("├──────────────────────────────────────────────────┤");
                            System.out.println("│ Trips Made: " + ANSI_COLORS[16] + customer.getTotaltrips() + ANSI_COLORS[5]);
                            System.out.println("├──────────────────────────────────────────────────┤");
                            System.out.println("│ Vouchers: " + ANSI_COLORS[16] + customer.getVouchers() + ANSI_COLORS[5]);
                            System.out.println("╰──────────────────────────────────────────────────╯\u001B[0m");
                            i++;
                        }

                        if (Customers.isEmpty()) {
                            break;
                        }
                        System.out.println(Main.ANSI_COLORS[16] + "   ╔══════════════════════════╗");
                        System.out.println("   ║ " + Main.ANSI_COLORS[12] + "   1)" + Main.ANSI_COLORS[16] + "Delete Customer     ║");
                        System.out.println("   ║  " + Main.ANSI_COLORS[12] + "  2)" + Main.ANSI_COLORS[16] + "Edit Customer       ║");
                        System.out.println("   ║  " + Main.ANSI_COLORS[12] + "  3)" + Main.ANSI_COLORS[16] + "Return Home Page    ║");
                        System.out.println("   ║  " + Main.ANSI_COLORS[12] + "  4)" + Main.ANSI_COLORS[16] + "Exit                ║");
                        System.out.println("   ╚══════════════════════════╝");
                        int option = input(1, 4);
                        if (option == 1) {
                            System.out.print("Enter The Customer number that you want to delete:");
                            int cNo = input(1, Customers.size());
                            Customers.remove(cNo - 1);
                        } else if (option == 2) {
                            System.out.print("Enter The Customer number that you want to edit:");
                            int cNo = input(1, Customers.size());
                            edit_customer(Customers.get(cNo - 1), Admins, Customers, TourGuides, Managers, Trips_system);
                        } else if (option == 3) {
                            break;
                        } else {
                            Case = 1;
                            break;
                        }
                        cls();

                    } while (true);
                    break;
                case 4: //All tourGuide
                    if (TourGuides.isEmpty()) {
                        System.out.println("There is no Tour Guides ¯\\_(ツ)_/¯");
                        sleep();
                    }
                    do {
                        int i = 1;
                        for (TourGuide tourGuide : TourGuides) {
                            System.out.println(i + ")");
                            System.out.print("  ");
                            tourGuide.DisplayTourGuide();
                            System.out.println();
                            i++;
                        }
                        if (TourGuides.isEmpty()) {
                            break;
                        }
                        System.out.println(Main.ANSI_COLORS[16] + "   ╔══════════════════════════╗");
                        System.out.println("   ║ " + Main.ANSI_COLORS[12] + "   1)" + Main.ANSI_COLORS[16] + "Delete Tour Guide   ║");
                        System.out.println("   ║  " + Main.ANSI_COLORS[12] + "  2)" + Main.ANSI_COLORS[16] + "Edit Tour Guide     ║");
                        System.out.println("   ║  " + Main.ANSI_COLORS[12] + "  3)" + Main.ANSI_COLORS[16] + "Return Home Page    ║");
                        System.out.println("   ║  " + Main.ANSI_COLORS[12] + "  4)" + Main.ANSI_COLORS[16] + "Exit                ║");
                        System.out.println("   ╚══════════════════════════╝");
                        int option = input(1, 4);
                        if (option == 1) {
                            System.out.print("Enter The Tour Guide number that you want to delete:");
                            int cNo = input(1, TourGuides.size());
                            TourGuides.remove(cNo - 1);
                        } else if (option == 2) {
                            System.out.print("Enter The Tour Guide number that you want to edit:");
                            int cNo = input(1, TourGuides.size());
                            edit_TourGuide(TourGuides.get(cNo - 1), Admins, Customers, TourGuides, Managers, Trips_system);
                            //TourGuides.get(cNo - 1).Edit_Profile(Admins, Customers, Managers, TourGuides);
                        } else if (option == 3) {
                            break;
                        } else {
                            Case = 1;
                            break;
                        }
                        cls();
                    } while (true);
                    break;
                case 5: // All Managers
                    if (Managers.isEmpty()) {
                        System.out.println("There is no Managers ¯\\_(ツ)_/¯");
                        sleep();
                    }
                    int i = 1;
                    do {
                        for (Manager manager : Managers) {
                            System.out.println(i + ")");
                            System.out.println("╔═══════════════════════════════════════════════");
                            System.out.println("║   UserName |" + manager.getUsername());
                            System.out.println("║------------|----------------------------------");
                            System.out.println("║     Name   |" + manager.getFirstName() + " " + manager.getLastName());
                            System.out.println("║------------|----------------------------------");
                            System.out.println("║    Email   |" + manager.getEmail());
                            System.out.println("║------------|----------------------------------");
                            System.out.println("║    Phone   |" + manager.getPhoneNumber());
                            System.out.println("║------------|-----------------------------------");
                            System.out.println("║     Age    |" + manager.getAge());
                            System.out.println("╚════════════════════════════════════════════════");
                            System.out.println();
                            i++;
                        }
                        if (Managers.isEmpty()) {
                            break;
                        }
                        System.out.println(Main.ANSI_COLORS[16] + "   ╔══════════════════════════╗");
                        System.out.println("   ║ " + Main.ANSI_COLORS[12] + "   1)" + Main.ANSI_COLORS[16] + "Delete Tour Guide   ║");
                        System.out.println("   ║  " + Main.ANSI_COLORS[12] + "  2)" + Main.ANSI_COLORS[16] + "Edit Tour Guide     ║");
                        System.out.println("   ║  " + Main.ANSI_COLORS[12] + "  3)" + Main.ANSI_COLORS[16] + "Return Home Page    ║");
                        System.out.println("   ║  " + Main.ANSI_COLORS[12] + "  4)" + Main.ANSI_COLORS[16] + "Exit                ║");
                        System.out.println("   ╚══════════════════════════╝");
                        int option = input(1, 4);
                        if (option == 1) {
                            System.out.print("Enter The Manger number that you want to delete:");
                            int cNo = input(1, Managers.size());
                            Managers.remove(cNo - 1);
                        } else if (option == 2) {
                            System.out.print("Enter The Manger number that you want to edit:");
                            int cNo = input(1, Managers.size());
                            edit_Manager(Managers.get(cNo - 1), Admins, Customers, TourGuides, Managers, Trips_system);
                        } else if (option == 3) {
                            break;
                        } else {
                            Case = 1;
                            break;
                        }
                        cls();
                    } while (true);
                    break;
                case 6:
                    Case = 0;
                    break;
            }

            cls();
        } while (Case != 0 && Case != 1);

        cls();
        if (Case == 0) return false;
        else if (Case == 1) return true;

        // return Case == 0;  // if Case == 0 --> return true else(Case == 5) return 0;
        // return true; --> Exit  , return false;  --> Log out
        return true;  //leave it
    }

    public void Register(ArrayList<Admin> Admins, ArrayList<Customer> Customers, ArrayList<Manager> Managers, ArrayList<TourGuide> TourGuides) {

        // Register Page
        System.out.println("\u001B[34m╭───────────────────────────────────────────────────────────╮");
        System.out.println("\u001B[34m│          " + ANSI_COLORS[16] + "               Register       " + ANSI_COLORS[5] + "                   │");
        System.out.println("\u001B[34m├───────────────────────────────────────────────────────────┤");
        System.out.print("\u001B[34m│ First Name: ");
        super.setFirstName(in.next());
        System.out.println("\u001B[34m├───────────────────────────────────────────────────────────┤");
        System.out.print("\u001B[34m│ Last Name: ");
        super.setLastName(in.next());
        System.out.println("\u001B[34m├───────────────────────────────────────────────────────────┤");
        while (true) {

            System.out.print("\u001B[34m│ Username: ");
            String user = in.next();

            if (!super.setUsername(user, Admins, Customers, Managers, TourGuides)) {
                System.out.println(ANSI_COLORS[10] + "  Username already Used." + ANSI_COLORS[16]);
            } else break;
        }
//        System.out.print("\u001B[34m│ Username: ");
//        super.setUsername(in.next(), Admins, Customers, Managers, TourGuides);
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

        cls();

        // setCompanyID(); Static int count = 0;
        //count++ inside constructor
    }

    public static int Is_login_successfully(String username, String password, ArrayList<Admin> admin) {

//        for (int i = 0; i < admin.size(); i++) {
//             Admin a = admin.get(i);
//            if (a.getUsername().equals(username) && a.getUsername().equals(password)) {
//                return i; // Login is successfully
//            }
//        }
//        return -1;

        for (int i = 0; i < admin.size(); i++) {
            Admin admins = admin.get(i);
            if (admins.getUsername().equals(username) && admins.getPassword().equals(password)) {
                return i;
            }
        }
        return -1;
    }

    static public int FoundUsername(String username, ArrayList<Admin> Admins) {
        return IntStream.range(0, Admins.size())
                .filter(i -> Admins.get(i).getUsername().equals(username))
                .findFirst()
                .orElse(-1);
    }

    public int Display_Profile(ArrayList<Admin> admin, ArrayList<Customer> customer, ArrayList<Manager> manager, ArrayList<TourGuide> tourGuide) {
        // view profile
        System.out.println(ANSI_COLORS[5] + "\t\t\t\t\t\t\t╭─────────────────────────────────────────────────────────────────────╮");
        System.out.println("\t\t\t\t\t\t\t├                              My Profile                             ├");
        System.out.println("\t\t\t\t\t\t\t├─────────────────────────────────────────────────────────────────────┤");
        System.out.println("\t\t\t\t\t\t\t├                                                                     ├");
        System.out.println("\t\t\t\t\t\t\t├      ╭─────────────────────────╮                                    ├");
        System.out.println("\t\t\t\t\t\t\t│      │      First Name         │      " + getFirstName());
        System.out.println("\t\t\t\t\t\t\t├      ╰─────────────────────────╯                                    ├");
        System.out.println("\t\t\t\t\t\t\t├                                                                     ├");
        System.out.println("\t\t\t\t\t\t\t├      ╭─────────────────────────╮                                    ├");
        System.out.println("\t\t\t\t\t\t\t│      │       Last Name         │     " + getLastName());
        System.out.println("\t\t\t\t\t\t\t├      ╰─────────────────────────╯                                    ├");
        System.out.println("\t\t\t\t\t\t\t├                                                                     ├");
        System.out.println("\t\t\t\t\t\t\t├      ╭─────────────────────────╮                                    ├");
        System.out.println("\t\t\t\t\t\t\t│      │        Username         │      " + getUsername());
        System.out.println("\t\t\t\t\t\t\t├      ╰─────────────────────────╯                                    ├");
        System.out.println("\t\t\t\t\t\t\t├                                                                     ├");
        System.out.println("\t\t\t\t\t\t\t├      ╭─────────────────────────╮                                    ├");
        System.out.println("\t\t\t\t\t\t\t│      │      Phone number       │      " + getPhoneNumber());
        System.out.println("\t\t\t\t\t\t\t├      ╰─────────────────────────╯                                    ├");
        System.out.println("\t\t\t\t\t\t\t├                                                                     ├");
        System.out.println("\t\t\t\t\t\t\t├      ╭─────────────────────────╮                                    ├");
        System.out.println("\t\t\t\t\t\t\t│      │         Email           │      " + getEmail());
        System.out.println("\t\t\t\t\t\t\t├      ╰─────────────────────────╯                                    ├");
        System.out.println("\t\t\t\t\t\t\t├                                                                     ├");
        System.out.println("\t\t\t\t\t\t\t├      ╭─────────────────────────╮                                    ├");
        System.out.print("\t\t\t\t\t\t\t│      │       Gender (M/F)      │      ");
        if (super.getGender() == 'F') {
            System.out.println("Female");
        } else {
            System.out.println("Male");
        }
        System.out.println("\t\t\t\t\t\t\t├      ╰─────────────────────────╯                                    ├");
        System.out.println("\t\t\t\t\t\t\t├                                                                     ├");
        System.out.println("\t\t\t\t\t\t\t├      ╭─────────────────────────╮                                    ├");
        System.out.println("\t\t\t\t\t\t\t├      │          Age            │      " + getAge());
        System.out.println("\t\t\t\t\t\t\t├      ╰─────────────────────────╯                                    ├");
        System.out.println("\t\t\t\t\t\t\t├                                                                     ├");
        System.out.println("\t\t\t\t\t\t\t├      ╭─────────────────────────╮                                    ├");
        System.out.println("\t\t\t\t\t\t\t├      │      Company Name       │      " + getCompanyName());
        System.out.println("\t\t\t\t\t\t\t├      ╰─────────────────────────╯                                    ├");
        System.out.println("\t\t\t\t\t\t\t├                                                                     ├");
        System.out.println("\t\t\t\t\t\t\t├                                                                     ├");
        System.out.println("\t\t\t\t\t\t\t╰─────────────────────────────────────────────────────────────────────╯" + ANSI_COLORS[0]);

        System.out.println(Main.ANSI_COLORS[16] + "   ╔══════════════════════════╗");
        System.out.println("   ║ " + Main.ANSI_COLORS[12] + "   1)" + Main.ANSI_COLORS[16] + "Edit your Profile   ║");
        System.out.println("   ║  " + Main.ANSI_COLORS[12] + "  2)" + Main.ANSI_COLORS[16] + "Home Page           ║");
        System.out.println("   ║  " + Main.ANSI_COLORS[12] + "  3)" + Main.ANSI_COLORS[16] + "Exit                ║");
        System.out.println("   ╚══════════════════════════╝");
        //System.out.println("       1. Edit your Profile \n       2. Home page \n       3. Exit");
        System.out.print("Enter your choice: ");
        int choice = input(1, 3);
        cls();
        if (choice == 1) return Edit_Profile(admin, customer, manager, tourGuide);
        else if (choice == 2) return 2;
        else return 1;

    }

    public int Edit_Profile(ArrayList<Admin> admin, ArrayList<Customer> customer, ArrayList<Manager> manager, ArrayList<TourGuide> tourguide) {
//        String pass1, pass2;
//        do {
//            System.out.println("welcome " + super.getUsername());
//            System.out.println("choose which option you want to change ");
//            System.out.println(" 1)  first name \n 2) Last name \n 3) Password \n 4) Company Name \n 5) Age \n 6) Email \n 7) Phone number ");
//            switch (input(1, 6)) {
//                case 1:
//                    System.out.println("please enter your first name ");
//                    super.setFirstName(in.next());//????????????
//                    System.out.println("Done successfully " + super.getFirstName());
//                    break;
//                case 2:
//                    System.out.println("please enter your last name ");
//                    super.setLastName(in.next());
//                    System.out.println("Done sussefully " + super.getLastName());
//                    break;
//                case 3:
//                    System.out.println("please enter your new password");
//                    pass1 = in.next();
//                    System.out.println("Write again");
//                    pass2 = in.next();
//                    super.setPassword(pass1, pass2);
//                    System.out.println("Done successfully ");
//                    break;
//                case 4:
//                    System.out.println(" Enter your new company name ");
//                    setCompanyName(in.next());
//                    System.out.println("Done successfully your new company name now is " + getCompanyName());
//                    break;
//                case 5:
//                    System.out.println(" Enter your age ");
//                    super.setAge(input(10, 100));
//                    System.out.println("Done successfully");
//                    break;
//                case 6: System.out.println(" Enter your Email ");
//                        super.setEmail(in.next());
//                    System.out.println("Done successfully your new Email now is " + getEmail());
//                   break;
//                case 7: System.out.println(" Enter your phone number ");
//                    super.setPhoneNumber(in.next());
//                    System.out.println("Done successfully your new phone number now is " + getPhoneNumber());
//                    break;
//            }
//            System.out.println("Do you want to make another change(y,n)?");
//
//        } while (confirm(in.next().charAt(0)));

        int option1;
        char ans;
        do {
            System.out.println(Main.ANSI_COLORS[16] + "   ╔══════════════════════════╗");
            System.out.println("   ║    " + Main.ANSI_COLORS[13] + "Edit Profile " + Main.ANSI_COLORS[16] + "         ║");
            System.out.println("   ╠══════════════════════════╣");
            System.out.println("   ║  " + Main.ANSI_COLORS[12] + "  1)" + Main.ANSI_COLORS[16] + "First name.         ║");
            System.out.println("   ║  " + Main.ANSI_COLORS[12] + "  2)" + Main.ANSI_COLORS[16] + "Last name.          ║");
            System.out.println("   ║  " + Main.ANSI_COLORS[12] + "  3)" + Main.ANSI_COLORS[16] + "Username.           ║");
            System.out.println("   ║   " + Main.ANSI_COLORS[12] + " 4)" + Main.ANSI_COLORS[16] + "Password.           ║");
            System.out.println("   ║  " + Main.ANSI_COLORS[12] + "  5)" + Main.ANSI_COLORS[16] + "Age.                ║");
            System.out.println("   ║   " + Main.ANSI_COLORS[12] + " 6)" + Main.ANSI_COLORS[16] + "Phone number.       ║");
            System.out.println("   ║  " + Main.ANSI_COLORS[12] + "  7)" + Main.ANSI_COLORS[16] + "Email.              ║");
            System.out.println("   ║   " + Main.ANSI_COLORS[12] + " 8)" + Main.ANSI_COLORS[16] + "Gender.             ║");
            System.out.println("   ║   " + Main.ANSI_COLORS[12] + " 9)" + Main.ANSI_COLORS[16] + "Company Name.       ║");

            System.out.println("   ╚══════════════════════════╝\n");

//            System.out.println(Main.ANSI_COLORS[16]+"   ╔═══════════════════════════╗");
//            System.out.println("   ║  "+Main.ANSI_COLORS[12]+"  10)"+Main.ANSI_COLORS[10]+"Exit page "+Main.ANSI_COLORS[16]+"          ║");
//            System.out.println("   ╚═══════════════════════════╝");


            System.out.print(Main.ANSI_COLORS[16] + "Enter your choice: ");
            option1 = Main.input(1, 9);
            Main.cls();

            switch (option1) {
                case 1:
                    System.out.print("Enter your first name: ");
                    this.setFirstName(in.next());
                    break;


                case 2:

                    System.out.print("Enter your last name: ");
                    super.setLastName(in.next());

                    break;
                case 3:

                    while (true) {

                        System.out.print("Enter username: ");
                        String user = in.next();

                        if (!super.setUsername(user, admin, customer, manager, tourguide)) {
                            System.out.println(Main.ANSI_COLORS[10] + "Username already Used." + Main.ANSI_COLORS[16]);
                        } else break;
                    }

                    break;
                case 4:

                    while (true) {

                        System.out.print(Main.ANSI_COLORS[16] + "Enter password: ");
                        String p1 = in.next();
                        System.out.print("Enter password again: ");
                        String p2 = in.next();

                        if (super.setPassword(p1, p2)) {
                            break;
                        }
                    }

                    break;
                case 5:

                    while (true) {
                        System.out.print(Main.ANSI_COLORS[16] + "Enter your Age: ");
                        if (super.setAge(in.nextInt())) break;
                    }

                    break;
                case 6:
                    while (true) {

                        System.out.print(Main.ANSI_COLORS[16] + "Enter your PhoneNumber: ");
                        if (super.setPhoneNumber(in.next())) {
                            break;
                        }
                    }
                    break;
                case 7:
                    while (true) {

                        System.out.print(Main.ANSI_COLORS[16] + "Enter your Email:  ");
                        if (!super.setEmail(in.next())) {
                            System.out.println(Main.ANSI_COLORS[10] + "Invalid email." + Main.ANSI_COLORS[16]);
                        } else break;
                    }

                    break;
                case 8:
                    while (true) {

                        System.out.print(Main.ANSI_COLORS[16] + "Enter your Gender (f/m):  ");
                        String gender = in.next();
                        gender = gender.toLowerCase();

                        if (gender.equals("f") || gender.equals("m")) {
                            super.setGender(gender.charAt(0));
                            break;
                        } else {
                            System.out.println(Main.ANSI_COLORS[10] + "Invalid input." + Main.ANSI_COLORS[16]);
                        }

                    }
                    break;
                case 9:

                    System.out.print(Main.ANSI_COLORS[16] + "Enter your Company Name: ");
                    this.setCompanyName(in.next());

                    break;
//                case 10:
//                    Main.cls();
//                    return Logout_exist();
            }

            Main.cls();

            System.out.println(Main.ANSI_COLORS[12] + "Changes have been successfully saved...");
            System.out.print(Main.ANSI_COLORS[16] + "Do you want to make another change?(Y/N) :");
            ans = in.next().charAt(0);
            Main.cls();
        } while (confirm(ans));


        System.out.println(Main.ANSI_COLORS[16] + "   ╔══════════════════════════╗");
        System.out.println("   ║ " + Main.ANSI_COLORS[12] + "   1)" + Main.ANSI_COLORS[16] + "Display Profile     ║");
        System.out.println("   ║  " + Main.ANSI_COLORS[12] + "  2)" + Main.ANSI_COLORS[16] + "Home Page           ║");
        System.out.println("   ║  " + Main.ANSI_COLORS[12] + "  3)" + Main.ANSI_COLORS[16] + "Exit                ║");
        System.out.println("   ╚══════════════════════════╝");

        System.out.print("Enter your choice: ");
        int option = input(1, 3);
        cls();
        if (option == 1) {
            return Display_Profile(admin, customer, manager, tourguide);
        } else if (option == 2) {
            return 2;
        } else return 1;
    }

    public static int createAccount(ArrayList<Admin> Admins, ArrayList<Customer> Customers, ArrayList<Manager> Managers, ArrayList<TourGuide> TourGuides) {
        //System.out.println("                                                                 /-\\|                 |/-\\                                                                                 ");
        System.out.println("   ╔═══════════════════════════╗");
        System.out.println("   ║   " + ANSI_COLORS[13] + "Create Account for:" + ANSI_COLORS[16]);
        System.out.println("   ╠═══════════════════════════╣");
        System.out.println("   ║      1) Admin             ║");
        System.out.println("   ║      2) Tour guide        ║");
        System.out.println("   ║      3) Customer          ║");
        System.out.println("   ║      4) Manager           ║");
        System.out.println("   ╚═══════════════════════════╝");
        System.out.print("\nEnter your choice: " + ANSI_COLORS[16]);
        int userType = input(1, 4);
        //Switch (case 1: admin, case 2: customer, case 3: tourGuide)
        switch (userType) {
            case 1:
                Admin admin = new Admin();
                admin.Register(Admins, Customers, Managers, TourGuides);
                Admins.add(admin);
                break;
            case 2:
                TourGuide tourGuide = new TourGuide();
                tourGuide.Register(Admins, Customers, Managers, TourGuides);
                TourGuides.add(tourGuide);
                break;
            case 3:
                Customer customer = new Customer();
                customer.Register(Admins, Customers, Managers, TourGuides);
                Customers.add(customer);
                break;
            case 4:
                Manager manager = new Manager(Admins, Customers, Managers, TourGuides);
                manager.Register(Admins, Customers, Managers, TourGuides);
                Managers.add(manager);
                break;
        }
        System.out.println(ANSI_COLORS[3] + "            * Created Successfully *" + ANSI_COLORS[0]);

        sleep();
        cls();
        System.out.println(Main.ANSI_COLORS[16] + "   ╔══════════════════════════════╗");
        System.out.println("   ║ " + Main.ANSI_COLORS[12] + "   1)" + Main.ANSI_COLORS[16] + "Create another account  ║");
        System.out.println("   ║  " + Main.ANSI_COLORS[12] + "  2)" + Main.ANSI_COLORS[16] + "Home Page               ║");
        System.out.println("   ║  " + Main.ANSI_COLORS[12] + "  3)" + Main.ANSI_COLORS[16] + "Exit                    ║");
        System.out.println("   ╚══════════════════════════════╝");
        //System.out.println("       1. Create another account \n       2. Home page \n       3. Exit");
        System.out.print("Enter your choice: ");
        int choice = input(1, 3);

        cls();
        if (choice == 1) {
            return createAccount(Admins, Customers, Managers, TourGuides);
        } else if (choice == 2) {
            return 2;
        } else return 1;

    }

    public void design_homePage(int Case) {
        System.out.println("\t\t\t\t\t\t\t╭──────────────────────────────────────────────────────────────────────────────────────────────────────╮");
        System.out.println("\t\t\t\t\t\t\t│                                                                                             Exit[0]  │");
        System.out.println("\t\t\t\t\t\t\t│                                  Welcome " + super.getFirstName() + " " + super.getLastName());
        System.out.println("\t\t\t\t\t\t\t│                                                                                                      │");

        switch (Case) {
            case 1:
                System.out.println("\t\t\t\t\t\t\t  " + ANSI_COLORS[5] + "My Profile  [1]" + ANSI_COLORS[0] + "  |  Create account [2]  |  All Customer [3]  |  All TourGuide [4]  |   All Managers [5]  |   Log out  [6] │");
                break;
            case 2:
                System.out.println("\t\t\t\t\t\t\t│ My Profile  [1]  |  " + ANSI_COLORS[5] + "Create account [2]" + ANSI_COLORS[0] + "  |  All Customer [3]  |  All TourGuide [4]  |   All Managers [5]  |   Log out  [6] │");
                break;
            case 3:
                System.out.println("\t\t\t\t\t\t\t│ My Profile  [1]  |  Create account [2]  |  " + ANSI_COLORS[5] + "All Customer [3]" + ANSI_COLORS[0] + "  |  All TourGuide [4]  |   All Managers [5]  |   Log out  [6] │");
                break;
            case 4:
                System.out.println("\t\t\t\t\t\t\t│ My Profile  [1]  |  Create account [2]  |  All Customer [3]  |  " + ANSI_COLORS[5] + "All TourGuide [4]" + ANSI_COLORS[0] + "   All Managers [5]  |   Log out  [6] │");
                break;
            case 5:
                System.out.println("\t\t\t\t\t\t\t│ My Profile  [1]  |  Create account [2]  |  All Customer [3]  |  All TourGuide [4]  |   " + ANSI_COLORS[5] + "All Manager  [5]" + ANSI_COLORS[0] + "  |   Log out  [6] │");
                break;
        }

        System.out.println("\t\t\t\t\t\t\t│                                                                                                     │");
        System.out.println("\t\t\t\t\t\t\t│                                                                                                     │");
        System.out.println("\t\t\t\t\t\t\t│                                                                                                     │");
        System.out.println("\t\t\t\t\t\t\t│                                                                                                     │");


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

    void edit_TourGuide(TourGuide tour, ArrayList<Admin> admin, ArrayList<Customer> customer, ArrayList<TourGuide> tourguide, ArrayList<Manager> manager, ArrayList<Trip> Trips_system) {

        int option;
        char ans;
        do {
            System.out.println(Main.ANSI_COLORS[16] + "   ╔══════════════════════════╗");
            System.out.println("   ║    " + Main.ANSI_COLORS[13] + "Edit Profile " + Main.ANSI_COLORS[16] + "         ║");
            System.out.println("   ╠══════════════════════════╣");
            System.out.println("   ║  " + Main.ANSI_COLORS[12] + "  1)" + Main.ANSI_COLORS[16] + "First name.         ║");
            System.out.println("   ║  " + Main.ANSI_COLORS[12] + "  2)" + Main.ANSI_COLORS[16] + "Last name.          ║");
            System.out.println("   ║  " + Main.ANSI_COLORS[12] + "  3)" + Main.ANSI_COLORS[16] + "Username.           ║");
            System.out.println("   ║   " + Main.ANSI_COLORS[12] + " 4)" + Main.ANSI_COLORS[16] + "Password.           ║");
            System.out.println("   ║  " + Main.ANSI_COLORS[12] + "  5)" + Main.ANSI_COLORS[16] + "Age.                ║");
            System.out.println("   ║   " + Main.ANSI_COLORS[12] + " 6)" + Main.ANSI_COLORS[16] + "Phone number.       ║");
            System.out.println("   ║  " + Main.ANSI_COLORS[12] + "  7)" + Main.ANSI_COLORS[16] + "Email.              ║");
            System.out.println("   ║   " + Main.ANSI_COLORS[12] + " 8)" + Main.ANSI_COLORS[16] + "Gender.             ║");
            System.out.println("   ║   " + Main.ANSI_COLORS[12] + " 9)" + Main.ANSI_COLORS[16] + "Country.            ║");
            System.out.println("   ║   " + Main.ANSI_COLORS[12] + " 10)" + Main.ANSI_COLORS[16] + "Salary per day.    ║");
            System.out.println("   ║   " + Main.ANSI_COLORS[12] + " 11)" + Main.ANSI_COLORS[16] + "Languages.         ║");
            System.out.println("   ╚══════════════════════════╝\n");

            System.out.println(Main.ANSI_COLORS[16] + "   ╔═══════════════════════════╗");
            System.out.println("   ║  " + Main.ANSI_COLORS[12] + "  12)" + Main.ANSI_COLORS[10] + "Exit page " + Main.ANSI_COLORS[16] + "          ║");
            System.out.println("   ╚═══════════════════════════╝");


            System.out.print(Main.ANSI_COLORS[16] + "Enter your choice: ");
            option = Main.input(1, 12);
            Main.cls();

            switch (option) {
                case 1:
                    System.out.print("Enter your first name: ");
                    tour.setFirstName(in.next());
                    break;


                case 2:

                    System.out.print("Enter your last name: ");
                    tour.setLastName(in.next());

                    break;
                case 3:

                    while (true) {

                        System.out.print("Enter username: ");
                        String user = in.next();

                        if (!tour.setUsername(user, admin, customer, manager, tourguide)) {
                            System.out.println(Main.ANSI_COLORS[10] + "Username already Used." + Main.ANSI_COLORS[16]);
                        } else break;
                    }

                    break;
                case 4:

                    while (true) {

                        System.out.print(Main.ANSI_COLORS[16] + "Enter password: ");
                        String p1 = in.next();
                        System.out.print("Enter password again: ");
                        String p2 = in.next();

                        if (tour.setPassword(p1, p2)) {
                            break;
                        }
                    }

                    break;
                case 5:

                    while (true) {
                        System.out.print(Main.ANSI_COLORS[16] + "Enter your Age: ");
                        if (tour.setAge(in.nextInt())) break;
                    }

                    break;
                case 6:
                    while (true) {

                        System.out.print(Main.ANSI_COLORS[16] + "Enter your PhoneNumber: ");
                        if (tour.setPhoneNumber(in.next())) {
                            break;
                        }
                    }
                    break;
                case 7:
                    while (true) {

                        System.out.print(Main.ANSI_COLORS[16] + "Enter your Email:  ");
                        if (!tour.setEmail(in.next())) {
                            System.out.println(Main.ANSI_COLORS[10] + "Invalid email." + Main.ANSI_COLORS[16]);
                        } else break;
                    }

                    break;
                case 8:
                    while (true) {

                        System.out.print(Main.ANSI_COLORS[16] + "Enter your Gender (f/m):  ");
                        String gender = in.next();
                        gender = gender.toLowerCase();

                        if (gender.equals("f") || gender.equals("m")) {
                            tour.setGender(gender.charAt(0));
                            break;
                        } else {
                            System.out.println(Main.ANSI_COLORS[10] + "Invalid input." + Main.ANSI_COLORS[16]);
                        }

                    }
                    break;
                case 9:

                    System.out.print(Main.ANSI_COLORS[16] + "Enter your Country: ");
                    tour.setCountry(in.next());

                    break;
                case 10:
                    System.out.print(Main.ANSI_COLORS[16] + "Enter your Salary per day: ");
                    tour.setSalary_per_day(in.nextDouble());

                    break;

                case 11:

                    System.out.println(Main.ANSI_COLORS[16] + "Re-choose your languages!\n\n");
                    tour.getLanguages().clear();


                    System.out.println(Main.ANSI_COLORS[16] + "                  ╔═══════════════════════════════════════════╗");
                    System.out.println("                  ║           " + Main.ANSI_COLORS[12] + "  Choose Languages  " + Main.ANSI_COLORS[16] + "            ║");
                    System.out.println("                  ╠═══════════════════════════════════════════╣");
                    int i = 1;
                    for (String language : tour.getLanguageOptions()) {
                        System.out.print(Main.ANSI_COLORS[16] + "                  ║        " + Main.ANSI_COLORS[12] + i + ") " + Main.ANSI_COLORS[13]);
                        System.out.printf("%-10s ", language);
                        System.out.println(Main.ANSI_COLORS[16] + "                     ║");
                        i++;
                    }
                    System.out.println("                  ╚═══════════════════════════════════════════╝");

                    System.out.print("Enter number of Languages you wish to choose: ");
                    int number = Main.input(1, tour.getLanguageOptions().size());

                    while (number != 0) {
                        System.out.print("Enter your choice:");
                        int choice = Main.input(1, tour.getLanguageOptions().size());
                        if (tour.getLanguages().contains(tour.getLanguageOptions().get(choice - 1))) {
                            System.out.println(Main.ANSI_COLORS[10] + "You already chose it before!" + Main.ANSI_COLORS[16]);
                        } else {
                            number--;
                            tour.getLanguages().add(tour.getLanguageOptions().get(choice - 1));
                        }
                    }

                    break;
                case 12:
                    Main.cls();
                    return;

            }

            Main.cls();

            System.out.println(Main.ANSI_COLORS[12] + "Changes have been successfully saved...");
            System.out.print(Main.ANSI_COLORS[16] + "Do you want to make another change?(Y/N) :");
            ans = Confirm();
            Main.cls();
        } while (ans == 'y');


    }

    void edit_customer(Customer cust, ArrayList<Admin> admin, ArrayList<Customer> customer, ArrayList<TourGuide> tourguide, ArrayList<Manager> manager, ArrayList<Trip> Trips_system) {

        int option;
        char ans;
        do {
            System.out.println(Main.ANSI_COLORS[16] + "   ╔═════════════════════════════╗");
            System.out.println("   ║    " + Main.ANSI_COLORS[13] + "Edit Profile " + Main.ANSI_COLORS[16] + "          ║");
            System.out.println("   ╠════════════════════════════╣");
            System.out.println("   ║  " + Main.ANSI_COLORS[12] + "  1)" + Main.ANSI_COLORS[16] + "First name.          ║");
            System.out.println("   ║  " + Main.ANSI_COLORS[12] + "  2)" + Main.ANSI_COLORS[16] + "Last name.           ║");
            System.out.println("   ║  " + Main.ANSI_COLORS[12] + "  3)" + Main.ANSI_COLORS[16] + "Username.            ║");
            System.out.println("   ║   " + Main.ANSI_COLORS[12] + " 4)" + Main.ANSI_COLORS[16] + "Password.            ║");
            System.out.println("   ║  " + Main.ANSI_COLORS[12] + "  5)" + Main.ANSI_COLORS[16] + "Age.                 ║");
            System.out.println("   ║   " + Main.ANSI_COLORS[12] + " 6)" + Main.ANSI_COLORS[16] + "Phone number.        ║");
            System.out.println("   ║  " + Main.ANSI_COLORS[12] + "  7)" + Main.ANSI_COLORS[16] + "Email.               ║");
            System.out.println("   ║   " + Main.ANSI_COLORS[12] + " 8)" + Main.ANSI_COLORS[16] + "Gender.              ║");
            System.out.println("   ║   " + Main.ANSI_COLORS[12] + " 9)" + Main.ANSI_COLORS[16] + "Country.             ║");
            System.out.println("   ║   " + Main.ANSI_COLORS[12] + " 10)" + Main.ANSI_COLORS[16] + "Preferred Language. ║");
            System.out.println("   ║   " + Main.ANSI_COLORS[12] + " 11)" + Main.ANSI_COLORS[16] + "Preferred Payment.  ║");
            System.out.println("   ║   " + Main.ANSI_COLORS[12] + " 12)" + Main.ANSI_COLORS[16] + "Preferred Currency. ║");
            System.out.println("   ╚══════════════════════════════╝\n");

            System.out.println(Main.ANSI_COLORS[16] + "   ╔═══════════════════════════╗");
            System.out.println("   ║  " + Main.ANSI_COLORS[12] + "  13)" + Main.ANSI_COLORS[10] + "Exit page " + Main.ANSI_COLORS[16] + "          ║");
            System.out.println("   ╚═══════════════════════════╝");


            System.out.print(Main.ANSI_COLORS[16] + "Enter your choice: ");
            option = Main.input(1, 13);
            Main.cls();

            switch (option) {
                case 1:
                    System.out.print("Enter your first name: ");
                    cust.setFirstName(in.next());
                    break;


                case 2:

                    System.out.print("Enter your last name: ");
                    cust.setLastName(in.next());

                    break;
                case 3:

                    while (true) {

                        System.out.print("Enter username: ");
                        String user = in.next();

                        if (!cust.setUsername(user, admin, customer, manager, tourguide)) {
                            System.out.println(Main.ANSI_COLORS[10] + "Username already Used." + Main.ANSI_COLORS[16]);
                        } else break;
                    }

                    break;
                case 4:

                    while (true) {

                        System.out.print(Main.ANSI_COLORS[16] + "Enter password: ");
                        String p1 = in.next();
                        System.out.print("Enter password again: ");
                        String p2 = in.next();

                        if (cust.setPassword(p1, p2)) {
                            break;
                        }
                    }

                    break;
                case 5:

                    while (true) {
                        System.out.print(Main.ANSI_COLORS[16] + "Enter your Age: ");
                        if (cust.setAge(in.nextInt())) break;
                    }

                    break;
                case 6:
                    while (true) {

                        System.out.print(Main.ANSI_COLORS[16] + "Enter your PhoneNumber: ");
                        if (cust.setPhoneNumber(in.next())) {
                            break;
                        }
                    }
                    break;
                case 7:
                    while (true) {

                        System.out.print(Main.ANSI_COLORS[16] + "Enter your Email:  ");
                        if (!cust.setEmail(in.next())) {
                            System.out.println(Main.ANSI_COLORS[10] + "Invalid email." + Main.ANSI_COLORS[16]);
                        } else break;
                    }

                    break;
                case 8:
                    while (true) {

                        System.out.print(Main.ANSI_COLORS[16] + "Enter your Gender (f/m):  ");
                        String gender = in.next();
                        gender = gender.toLowerCase();

                        if (gender.equals("f") || gender.equals("m")) {
                            cust.setGender(gender.charAt(0));
                            break;
                        } else {
                            System.out.println(Main.ANSI_COLORS[10] + "Invalid input." + Main.ANSI_COLORS[16]);
                        }

                    }
                    break;
                case 9:

                    System.out.print(Main.ANSI_COLORS[16] + "Enter your Country: ");
                    cust.setCountry(in.next());

                    break;

                case 10:

                    System.out.print(Main.ANSI_COLORS[16] + "Enter your Preferred Language: ");
                    cust.setPreferredLanguage(in.next());

                    break;

                case 11:

                    System.out.print(Main.ANSI_COLORS[16] + "Enter your Preferred Payment: ");
                    cust.setPreferredPayment(in.next());

                    break;
                case 12:
                    System.out.print(Main.ANSI_COLORS[16] + "Enter your Preferred Currency: ");
                    cust.setPreferredCurrency(in.next());

                case 13:
                    Main.cls();
                    return;
            }

            Main.cls();

            System.out.println(Main.ANSI_COLORS[12] + "Changes have been successfully saved...");
            System.out.print(Main.ANSI_COLORS[16] + "Do you want to make another change?(Y/N) :");
            ans = Confirm();
            Main.cls();
        } while (ans == 'y');

    }


    char Confirm() {
        while (true) {
            String input = in.next();
            input = input.toLowerCase();

            if (input.equals("y") || input.equals("n")) return input.charAt(0);

            System.out.println(Main.ANSI_COLORS[10] + "Invalid input." + Main.ANSI_COLORS[16]);

        }

    }

    public void edit_Manager(Manager mngr, ArrayList<Admin> admin, ArrayList<Customer> customer, ArrayList<TourGuide> tourguide, ArrayList<Manager> manager, ArrayList<Trip> Trips_system) {

        int option;
        char ans;
        do {
            System.out.println(Main.ANSI_COLORS[16] + "   ╔══════════════════════════╗");
            System.out.println("   ║    " + Main.ANSI_COLORS[13] + "Edit Profile " + Main.ANSI_COLORS[16] + "         ║");
            System.out.println("   ╠══════════════════════════╣");
            System.out.println("   ║  " + Main.ANSI_COLORS[12] + "  1)" + Main.ANSI_COLORS[16] + "First name.         ║");
            System.out.println("   ║  " + Main.ANSI_COLORS[12] + "  2)" + Main.ANSI_COLORS[16] + "Last name.          ║");
            System.out.println("   ║  " + Main.ANSI_COLORS[12] + "  3)" + Main.ANSI_COLORS[16] + "Username.           ║");
            System.out.println("   ║   " + Main.ANSI_COLORS[12] + " 4)" + Main.ANSI_COLORS[16] + "Password.           ║");
            System.out.println("   ║  " + Main.ANSI_COLORS[12] + "  5)" + Main.ANSI_COLORS[16] + "Age.                ║");
            System.out.println("   ║   " + Main.ANSI_COLORS[12] + " 6)" + Main.ANSI_COLORS[16] + "Phone number.       ║");
            System.out.println("   ║  " + Main.ANSI_COLORS[12] + "  7)" + Main.ANSI_COLORS[16] + "Email.              ║");
            System.out.println("   ║   " + Main.ANSI_COLORS[12] + " 8)" + Main.ANSI_COLORS[16] + "Gender.             ║");
            System.out.println("   ╚══════════════════════════╝\n");

            System.out.println(Main.ANSI_COLORS[16] + "   ╔═══════════════════════════╗");
            System.out.println("   ║  " + Main.ANSI_COLORS[12] + "  9)" + Main.ANSI_COLORS[10] + "Exit page " + Main.ANSI_COLORS[16] + "          ║");
            System.out.println("   ╚═══════════════════════════╝");


            System.out.print(Main.ANSI_COLORS[16] + "Enter your choice: ");
            option = Main.input(1, 9);
            Main.cls();

            switch (option) {
                case 1:
                    System.out.print("Enter your first name: ");
                    mngr.setFirstName(in.next());
                    break;


                case 2:

                    System.out.print("Enter your last name: ");
                    mngr.setLastName(in.next());

                    break;
                case 3:

                    while (true) {

                        System.out.print("Enter username: ");
                        String user = in.next();

                        if (!mngr.setUsername(user, admin, customer, manager, tourguide)) {
                            System.out.println(Main.ANSI_COLORS[10] + "Username already Used." + Main.ANSI_COLORS[16]);
                        } else break;
                    }

                    break;
                case 4:

                    while (true) {

                        System.out.print(Main.ANSI_COLORS[16] + "Enter password: ");
                        String p1 = in.next();
                        System.out.print("Enter password again: ");
                        String p2 = in.next();

                        if (mngr.setPassword(p1, p2)) {
                            break;
                        }
                    }

                    break;
                case 5:

                    while (true) {
                        System.out.print(Main.ANSI_COLORS[16] + "Enter your Age: ");
                        if (mngr.setAge(in.nextInt())) break;
                    }

                    break;
                case 6:
                    while (true) {

                        System.out.print(Main.ANSI_COLORS[16] + "Enter your PhoneNumber: ");
                        if (mngr.setPhoneNumber(in.next())) {
                            break;
                        }
                    }
                    break;
                case 7:
                    while (true) {

                        System.out.print(Main.ANSI_COLORS[16] + "Enter your Email:  ");
                        if (!mngr.setEmail(in.next())) {
                            System.out.println(Main.ANSI_COLORS[10] + "Invalid email." + Main.ANSI_COLORS[16]);
                        } else break;
                    }

                    break;
                case 8:
                    while (true) {

                        System.out.print(Main.ANSI_COLORS[16] + "Enter your Gender (f/m):  ");
                        String gender = in.next();
                        gender = gender.toLowerCase();

                        if (gender.equals("f") || gender.equals("m")) {
                            mngr.setGender(gender.charAt(0));
                            break;
                        } else {
                            System.out.println(Main.ANSI_COLORS[10] + "Invalid input." + Main.ANSI_COLORS[16]);
                        }

                    }
                    break;

                case 9:
                    Main.cls();
                    return;

            }

            Main.cls();

            System.out.println(Main.ANSI_COLORS[12] + "Changes have been successfully saved...");
            System.out.print(Main.ANSI_COLORS[16] + "Do you want to make another change?(Y/N) :");
            ans = Confirm();
            Main.cls();
        } while (ans == 'y');


    }
}
