package cis.travel.eg.User;

import cis.travel.eg.Main.Main;
import cis.travel.eg.Service.Activity;
import cis.travel.eg.Service.CarRental.Car;
import cis.travel.eg.Service.FlightSystem.Airport;
import cis.travel.eg.Service.Hotels.DetailsForSystem.HotelForAgency;
import cis.travel.eg.Service.Hotels.HotelDetails.doubleRooms;
import cis.travel.eg.Service.Hotels.HotelDetails.generalRooms;
import cis.travel.eg.Service.Hotels.HotelDetails.singleRooms;
import cis.travel.eg.Service.helpingMethods.helpingMethods;
import cis.travel.eg.Trip.Couple_Tour;
import cis.travel.eg.Trip.Family_Tour;
import cis.travel.eg.Trip.General_Tour;
import cis.travel.eg.Trip.Trip;
import cis.travel.eg.User.CustomerDetails.Customer;
import cis.travel.eg.User.TourGuideDetails.TourGuide;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.IntStream;

import static cis.travel.eg.Main.Main.in;
import static cis.travel.eg.User.TourGuideDetails.TourGuide.AvailableGuides;
import static cis.travel.eg.User.TourGuideDetails.TourGuide.Number_availableGuides;

public class Manager extends User implements Serializable {
//    public Manager() {
//
//    }
        public Manager(ArrayList<Admin> Admins, ArrayList<Customer> Customers, ArrayList<Manager> Managers, ArrayList<TourGuide> TourGuides) {
        setAge(18);setEmail("Hager@gmail.com");
        setUsername("h",Admins,Customers,Managers,TourGuides);setPassword("#1hagerNouran","#1hagerNouran");
        setPhoneNumber("01254545336");setGender('f');
        setFirstName("hagar");setLastName("Mahmoud");
    }
    //    public Manager(String username, String firstName, String lastName, String password, String phoneNumber, String email, char gender, int age){
//        super(username,firstName,lastName,password,phoneNumber,email,gender,age);
//    }

    public static int Is_login_successfully(String username, String password, ArrayList<Manager> mange) {
        for (int i = 0; i < mange.size(); i++) {
            Manager manager = mange.get(i);  //to get the current Customer object from the ArrayList.
            if (manager.getUsername().equals(username) && manager.getPassword().equals(password)) {
                System.out.println("login successfully " + username);
                return i;
            } else
                System.out.println("login failed");
        }
        return -1;
    }
    static public int FoundUsername(String username, ArrayList<Manager> managers) {
        return IntStream.range(0, managers.size())
                .filter(i -> managers.get(i).getUsername().equals(username))
                .findFirst()
                .orElse(-1);
    }

    //    public void Edit_Profile() {
//        String choice,fname,lname,country,pass1,pass2;
//        int option,age;
//        do {
//            System.out.println("welcome " + super.getUsername());
//            System.out.println("choose which option you want to change ");
//            System.out.println(" 1)  first name \n2) Last name \n 3) Password \n  4) Age \n");
//            option = in.nextInt();
//            switch(option){
//                case 1 :
//                    System.out.println("please enter your first name ");
//                    fname=in.next();
//                    super.setFirstName(fname);//????????????
//                    System.out.println("Done successfully "+super.getFirstName());
//                    break;
//                case 2:
//                    System.out.println("please enter your last name ");
//                    lname=in.next();
//                    super.setLastName(lname);
//                    System.out.println("Done sussefully "+super.getLastName());
//                    break;
//                case 3:
//                    System.out.println("please enter your new password");
//                    pass1=in.next();
//                    System.out.println("Write again");
//                    pass2=in.next();
//                    super.setPassword(pass1,pass2);
//                    System.out.println("Done sussefully ");
//                    break;
//                case 4:
//                    System.out.println("please enter your age ");
//                    age=in.nextInt();
//                    super.setAge(age);
//                    System.out.println("Done succefully");
//                    break;
//                default:
//                    System.out.println(" invalid choice try again ");
//                    option=in.nextInt();
//            }
//            System.out.println("Do you want to make another change ? ");
//            choice = in.next();
//        }while(choice.toLowerCase().equals("yes"));
//    }
    public void Register(ArrayList<Admin> Admins, ArrayList<Customer> Customers, ArrayList<Manager> Managers, ArrayList<TourGuide> TourGuides) {
        System.out.println("Enter your first name ");
        super.setFirstName(in.next());
        System.out.println("Enter your last name ");
        super.setLastName(in.next());
        System.out.println("Enter username ");
        String user = in.next();
        super.setUsername(user, Admins, Customers, Managers, TourGuides);
        System.out.println(" Enter Your Email ");
        String Email = in.next();
        setEmail(Email);
        System.out.println("Enter password ");
        String pass = in.next();
        System.out.println("Enter confirm password ");
        String confirmPass = in.next();
        super.setPassword(pass, confirmPass);
        System.out.println("Enter your  Age ");
        super.setAge(in.nextInt());
        System.out.println("Enter Phone Number ");
        super.setPhoneNumber(in.next());
        System.out.println("Enter your  Gender ");
        super.setGender(in.next().charAt(0));

    }

    @Override
    public boolean HomePage(ArrayList<Admin> Admins, ArrayList<Customer> Customers, ArrayList<TourGuide> TourGuides, ArrayList<Manager> Managers, ArrayList<Trip> Trips_system) {
        int ans;
        do {

//            System.out.println("\t\t   ╠═══════════════════════╣");
//            System.out.println("\t\t   ║         TRIP          ║");
//            System.out.println("\t\t   ╠═══════════════════════╣");
//            System.out.println("\t\t   ║      ACTIVITIES       ║");
//            System.out.println("\t\t   ╠═══════════════════════╣");
//            System.out.println("\t\t   ║        HOTELS         ║");
//            System.out.println("\t\t   ╠═══════════════════════╣");
//            System.out.println("\t\t   ║      CAR_RENTALS      ║");
//            System.out.println("\t\t   ╠═══════════════════════╣");
//            System.out.println("\t\t   ║   AIRPORTS_FLIGHTS    ║");
//            System.out.println("\t\t   ╠═══════════════════════╣");
//            System.out.println("\t\t   ║ TOUR_GUIDE COMPLAINTS ║");
//            System.out.println("\t\t   ╠═══════════════════════╣");
//            System.out.println("\t\t   ║        PROFILE        ║");
//            System.out.println("\t\t   ╠═══════════════════════╣");
//            System.out.println("\t\t   ║        LOGOUT         ║");
//            System.out.println("\t\t   ╠═══════════════════════╣");
            System.out.println(Main.ANSI_COLORS[16] + "   ╔══════════════════════════════════════════════════════════════════╗  ");
            System.out.print("   ║" + Main.ANSI_COLORS[14] + "               ✈ Welcome ");
            System.out.println(Main.ANSI_COLORS[15] + "                                  " +
                    "       ╣");
            System.out.println("   ╔══════════════════════════════════════════════════════════════════╗");
            System.out.println("   ║                                                                  ║");
            System.out.println("   ║     ╔═══════════════════════╗      ╔═══════════════════════╗     ║");
            System.out.println("   ║     ║       1.TRIP          ║      ║  2.AIRPORTS_FLIGHTS   ║     ║");
            System.out.println("   ║     ╠═══════════════════════╣      ╠═══════════════════════╣     ║");
            System.out.println("   ║     ║       3.HOTELS        ║      ║4.TOUR_GUIDE COMPLAINTS║     ║");
            System.out.println("   ║     ╠═══════════════════════╣      ╠═══════════════════════╣     ║");
            System.out.println("   ║     ║     5.CAR_RENTALS     ║      ║      6.PROFILE        ║     ║");
            System.out.println("   ║     ╠═══════════════════════╣      ╠═══════════════════════╣     ║");
            System.out.println("   ║     ║      7.ACTIVITY       ║      ║       8.LOGOUT        ║     ║");
            System.out.println("   ║     ╚═══════════════╔═══════╝══════╚═══════╔═══════════════╝     ║");
            System.out.println("   ║                     ║        9.EXIT        ║                     ║");
            System.out.println("   ║                     ╚══════════════════════╝                     ║");
            System.out.println("   ║                                                                  ║");
            System.out.println("   ╚══════════════════════════════════════════════════════════════════╝");


            //            System.out.println(Main.ANSI_COLORS[16]+"   ╔═══════════════════════════════════════════╗");
//            System.out.print("   ║" + Main.ANSI_COLORS[14] + "           ✈ Welcome " );
//            System.out.printf("%-10s ", getFirstName());
//            System.out.println(Main.ANSI_COLORS[16]+"          ║");
//            System.out.println("   ╠═══════════════════════════════════════════╣");
//            System.out.println("   ║    "+Main.ANSI_COLORS[14]+"1)"+Main.ANSI_COLORS[16]+"Add new trip                            ║");
//            System.out.println("   ║    "+Main.ANSI_COLORS[14]+"2)"+Main.ANSI_COLORS[16]+"Edit a trip                             ║");
//            System.out.println("   ║    "+Main.ANSI_COLORS[14]+"3)"+Main.ANSI_COLORS[16]+"delete a trip                           ║");
//            System.out.println("   ║    "+Main.ANSI_COLORS[14]+"4)"+Main.ANSI_COLORS[16]+"Add new Car_Rent                        ║");
//            System.out.println("   ║    "+Main.ANSI_COLORS[14]+"5)"+Main.ANSI_COLORS[16]+"Edit  Car_Rent                          ║");
//            System.out.println("   ║    "+Main.ANSI_COLORS[14]+"3)"+Main.ANSI_COLORS[16]+"Delete Car_Rental                       ║");
//            System.out.println("   ║    "+Main.ANSI_COLORS[14]+"4)"+Main.ANSI_COLORS[16]+"Add new Airport                         ║");
//            System.out.println("   ║    "+Main.ANSI_COLORS[14]+"5)"+Main.ANSI_COLORS[16]+"Edit Airports and flights               ║");
//            System.out.println("   ║    "+Main.ANSI_COLORS[14]+"6)"+Main.ANSI_COLORS[16]+"delete Airport                          ║");
//            System.out.println("   ║    "+Main.ANSI_COLORS[14]+"7)"+Main.ANSI_COLORS[16]+"Add a new hotel                         ║");
//            System.out.println("   ║    "+Main.ANSI_COLORS[14]+"8)"+Main.ANSI_COLORS[16]+"Edit a hotel                            ║");
//            System.out.println("   ║    "+Main.ANSI_COLORS[14]+"9)"+Main.ANSI_COLORS[16]+"Delete hotel                            ║");
//            System.out.println("   ║    "+Main.ANSI_COLORS[14]+"10)"+Main.ANSI_COLORS[16]+"view tour                           ║");
//            System.out.println("   ║    "+Main.ANSI_COLORS[14]+"11)"+Main.ANSI_COLORS[16]+"Logout                                 ║");
//            System.out.println("   ║    "+Main.ANSI_COLORS[14]+"9)"+Main.ANSI_COLORS[16]+"Display Profile                         ║");
//            System.out.println("   ║    "+Main.ANSI_COLORS[14]+"10)"+Main.ANSI_COLORS[16]+"Edit Profile                           ║");
//            System.out.println("   ║    "+Main.ANSI_COLORS[14]+"11)"+Main.ANSI_COLORS[16]+"Logout                                 ║");
//            System.out.println("   ║    "+Main.ANSI_COLORS[14]+"12)"+Main.ANSI_COLORS[16]+"Exit                                   ║");
//            System.out.println("   ║                                           ║");
//            System.out.println("   ╚═══════════════════════════════════════════╝");


            ans = helpingMethods.choice(1, 9);
            switch (ans) {
                case 1:
                    TripDetails(Trips_system, TourGuides, Customers);
                    break;
                case 2:
                    AirportDetails(Customers);
                    break;

                case 3:
                    HotelDetails(Customers);
                    break;
                case 4:
                    checkTourGuideComplaints(TourGuides, Customers);
                    break;
                case 5:
                    CarRentalDetails(Customers);
                    break;

                case 6:

                    int ReturnFromProfile =Display_Profile(Admins, Customers, Managers, TourGuides);
                    if (ReturnFromProfile==3)
                    {
                        return true;
                    }
                    break;
                case 7:
                    ActivityDetails(Customers);
                    break;
            }
            if (ans == 8) {
                return false;
            }

        } while (ans != 9);

        return true;
    }

    public void TripDetails(ArrayList<Trip> trips, ArrayList<TourGuide> tourGuides, ArrayList<Customer> customers) {

        System.out.println("\t\t   ╠═══════════════════════╣");
        System.out.println("\t\t   ║      1. ADD TRIP      ║");
        System.out.println("\t\t   ╠═══════════════════════╣");
        System.out.println("\t\t   ║      2. EDIT TRIP     ║");
        System.out.println("\t\t   ╠═══════════════════════╣");
        System.out.println("\t\t   ║     3. DELETE TRIP    ║");
        System.out.println("\t\t   ╠═══════════════════════╣");
        int ans = helpingMethods.choice(1, 3);
        switch (ans) {
            case 1:
                addNewTrip(trips, tourGuides, customers);
                break;
            case 2:
                EditTrip(trips, customers);
                break;
            case 3:
                managerDeleteTrip(trips, customers);
                break;
        }

    }

    public void AirportDetails(ArrayList<Customer> customers) {

        System.out.println("\t\t   ╠═══════════════════════╣");
        System.out.println("\t\t   ║    1. ADD Airport     ║");
        System.out.println("\t\t   ╠═══════════════════════╣");
        System.out.println("\t\t   ║    2. EDIT Airport    ║");
        System.out.println("\t\t   ╠═══════════════════════╣");
        System.out.println("\t\t   ║  3. Display Airport   ║");
        System.out.println("\t\t   ╠═══════════════════════╣");
        System.out.println("\t\t   ║   4. DELETE Airport   ║");
        System.out.println("\t\t   ╠═══════════════════════╣");
        int ans = helpingMethods.choice(1, 4);
        switch (ans) {
            case 1:
                AddNewAirPort();
                break;
            case 2:
                EditAirport(customers);
                break;
            case 3:
                DisplayAirportDetailsMethod();
                break;
            case 4:
                DeleteAnAirport();
                break;
        }

    }

    public void CarRentalDetails(ArrayList<Customer> customers) {

        System.out.println("\t\t   ╠═══════════════════════╣");
        System.out.println("\t\t   ║      1. ADD Car       ║");
        System.out.println("\t\t   ╠═══════════════════════╣");
        System.out.println("\t\t   ║      2. EDIT Car      ║");
        System.out.println("\t\t   ╠═══════════════════════╣");
        System.out.println("\t\t   ║    3. Display Car     ║");
        System.out.println("\t\t   ╠═══════════════════════╣");
        System.out.println("\t\t   ║     4. DELETE Car     ║");
        System.out.println("\t\t   ╠═══════════════════════╣");
        int ans = helpingMethods.choice(1, 34);
        switch (ans) {
            case 1:
                AddNewCar();
                break;
            case 2:
                EditCarDetails(customers);
                break;
            case 3:
                DisplayAllCarsMethod();
                break;
            case 4:
                DeleteCar();
                break;
        }

    }

    public void HotelDetails(ArrayList<Customer> customers) {

        System.out.println("\t\t   ╠═══════════════════════╣");
        System.out.println("\t\t   ║  1. ADD Hotel         ║");
        System.out.println("\t\t   ╠═══════════════════════╣");
        System.out.println("\t\t   ║  2. EDIT Hotel        ║");
        System.out.println("\t\t   ╠═══════════════════════╣");
        System.out.println("\t\t   ║  3. DELETE Hotel      ║");
        System.out.println("\t\t   ╠═══════════════════════╣");
        System.out.println("\t\t   ║  4. Display Hotels    ║");
        System.out.println("\t\t   ╠═══════════════════════╣");
        //displayHotelsInAgency()
        int ans = helpingMethods.choice(1, 4);
        switch (ans) {
            case 1:
                AddNewHotel();
                break;
            case 2:
                updateHotelInformation();
                break;
            case 3:
                deleteHotel(customers);
                break;
            case 4:
                displayHotelsInAgency();
                break;
        }

    }

    public void ActivityDetails(ArrayList<Customer> customers) {

        System.out.println("\t\t   ╠═══════════════════════╣");
        System.out.println("\t\t   ║   1. ADD ACTIVITY     ║");
        System.out.println("\t\t   ╠═══════════════════════╣");
        System.out.println("\t\t   ║  2. EDIT ACTIVITY     ║");
        System.out.println("\t\t   ╠═══════════════════════╣");
        System.out.println("\t\t   ║  3. DELETE ACTIVITY   ║");
        System.out.println("\t\t   ╠═══════════════════════╣");
        System.out.println("\t\t   ║  4.Display ACTIVITY   ║");
        System.out.println("\t\t   ╠═══════════════════════╣");
        //displayHotelsInAgency()
        int ans = helpingMethods.choice(1, 4);
        switch (ans) {
            case 1:
                addNewActivity();
                break;
            case 2:
                EditActivity(customers);
                break;
            case 3:
                deleteActivity(customers);
                break;
            case 4:
                Activity.DisplayActivities();
                break;
        }

    }

    @Override
    public int Display_Profile(ArrayList<Admin> admin, ArrayList<Customer> customer, ArrayList<Manager> manager, ArrayList<TourGuide> tourguide) {
        System.out.println("╔═══════════════════════════════════════════════");
        System.out.println("║   UserName |" + super.getUsername());
        System.out.println("║------------|----------------------------------");
        System.out.println("║     Name   |" + super.getFirstName() + " " + super.getLastName());
        System.out.println("║------------|----------------------------------");
        System.out.println("║    Email   |" + super.getEmail());
        System.out.println("║------------|----------------------------------");
        System.out.println("║    Phone   |" + super.getPhoneNumber());
        System.out.println("║------------|-----------------------------------");
        System.out.println("║     Age    |" + super.getAge());
        System.out.println("╚════════════════════════════════════════════════");

        System.out.println("       1. Edit your Profile \n       2. Home page \n       3. Exit");
        int choice = in.nextInt();
        if (choice == 1) {
            return Edit_Profile(admin, customer, manager, tourguide);
        } else if (choice == 2) {
            return 2;
        } else {
            return 3;
        }

    }

    @Override
    public int Edit_Profile(ArrayList<Admin> admin, ArrayList<Customer> customer, ArrayList<Manager> manager, ArrayList<TourGuide> tourGuides) {
        do {
            System.out.println(" Edit:");
            System.out.println(" 1- Name\n 2- Username\n 3- Password\n 4- Phone number\n 5- Email\n 6- Gender\n 7- Age");
            System.out.println(" Choice: ");
            int Choice = helpingMethods.choice(1, 7);
            switch (Choice) {
                case 1:
                    String fName = in.next();
                    String lName = in.next();
                    System.out.println(" Do you want to confirm? \n The name you entered: " + fName + " " + lName);
                    if (helpingMethods.confirm(in.next().charAt(0))) {
                        this.setFirstName(fName);
                        this.setLastName(lName);
                        System.out.println("changes saved!");
                    } else {
                        System.out.println(" Nothing changed.");
                    }
                    break;
                case 2:
                    System.out.println(" Enter the new username: ");
                    String Username = in.next();
                    String oldUsername = this.getUsername();
                    if (setUsername(Username, admin, customer, manager, tourGuides)) {
                        System.out.println(" Do you want to confirm ( Y | N ) ?");
                        if (helpingMethods.confirm(in.next().charAt(0))) {
                            System.out.println("changes saved!");
                        } else {
                            this.setUsername(oldUsername, admin, customer, manager, tourGuides);
                            System.out.println(" Nothing changed.");
                        }
                    }
                    break;
                case 3:
                    boolean cont = false;
                    do {
                        System.out.println(" Enter the new Password: ");
                        String Password = in.next();
                        String oldPassword = this.getPassword();
                        if (setPassword(Password, oldPassword)) {
                            System.out.println(" Do you want to confirm ( Y | N )?");
                            if (helpingMethods.confirm(in.next().charAt(0))) {
                                System.out.println("changes saved!");
                            } else {
                                setPassword(Password, oldPassword);
                                System.out.println(" Nothing changed.");
                            }
                        } else {
                            System.out.println(" Do you want to Enter Password again");
                            cont = helpingMethods.confirm(in.next().charAt(0));
                        }
                    } while (cont);

                    break;
                case 4:
                    boolean loopAgain = false;
                    System.out.println(" your current phone is " + this.getPhoneNumber());
                    String OldPhone = this.getPhoneNumber();
                    do {
                        System.out.println(" Enter your new number");
                        if (setPhoneNumber(in.next())) {
                            System.out.println(" Do you want to confirm?");
                            if (helpingMethods.confirm(in.next().charAt(0))) {
                                System.out.println("changes saved!");
                            } else {
                                this.setPhoneNumber(OldPhone);
                                System.out.println(" Nothing changed.");
                            }
                        } else {
                            loopAgain = true;
                        }
                    } while (loopAgain);
                    break;
                case 5:
                    boolean EnterEmailAgain = false;
                    do {
                        System.out.println(" Enter the new Email: ");
                        String Email = in.next();
                        String oldEmail = this.getEmail();
                        if (setEmail(Email)) {
                            System.out.println(" Do you want to confirm ( Y | N )?");
                            if (helpingMethods.confirm(in.next().charAt(0))) {
                                System.out.println("changes saved!");
                                setEmail(oldEmail);
                            } else {
                                System.out.println(" Nothing changed.");
                            }
                        } else {
                            System.out.println(" Do you want to Enter Email again");
                            EnterEmailAgain = helpingMethods.confirm(in.next().charAt(0));
                        }
                    } while (EnterEmailAgain);
                    break;
                case 6:
                    System.out.println(" Are you sure you want to change the gender?");
                    if (helpingMethods.confirm(in.next().charAt(0))) {
                        if (this.getGender() == 'f') {
                            this.setGender('m');
                        } else {
                            this.setGender('f');
                        }
                        System.out.println(" changes saved");
                    } else {
                        System.out.println(" Nothing changed");
                    }
                    break;
                case 7:
                    boolean EnterAgeAgain = false;
                    do {
                        System.out.println(" Enter the new Age: ");
                        int age = in.nextInt();
                        int oldAge = this.getAge();
                        if (setAge(age)) {
                            System.out.println(" Do you want to confirm ( Y | N ) ?");
                            if (helpingMethods.confirm(in.next().charAt(0))) {
                                System.out.println("changes saved!");
                            } else {
                                setAge(oldAge);
                                System.out.println(" Nothing changed.");
                            }
                        } else {
                            System.out.println(" Do you want to Enter Age again ( Y | N )");
                            EnterAgeAgain = helpingMethods.confirm(in.next().charAt(0));
                        }
                    } while (EnterAgeAgain);

                    break;
            }
            System.out.println(" Do you to edit another info? (y/n)");
        } while (helpingMethods.confirm(in.next().charAt(0)));
        this.Display_Profile(admin, customer, manager, tourGuides);
        return 0;
    }

    // hotels
    public void AddNewHotel() {
        HotelForAgency.hotels.add(new HotelForAgency());
        System.out.println("     <<Fill these details, please.>>");
        float hotelRating;

        System.out.println(" Hotel name: ");
        HotelForAgency.hotels.get(HotelForAgency.hotels.size() - 1).setHotelName(in.next());
        System.out.println(" Hotel Location: ");
        HotelForAgency.hotels.get(HotelForAgency.hotels.size() - 1).setHotelLocation(in.next());
        System.out.println(" Hotel Rating [1-5]: ");
        do {
            hotelRating = in.nextFloat();
            if (hotelRating < 1 || hotelRating > 5) {
                System.out.println("Invalid input, please enter a number from 1 to 5./n");
            }
        } while (hotelRating < 1 || hotelRating > 5);
        HotelForAgency.hotels.get(HotelForAgency.hotels.size() - 1).setHotelRating(hotelRating);
        System.out.println(" Contact number: ");
        HotelForAgency.hotels.get(HotelForAgency.hotels.size() - 1).setContactNumber(in.next()); //check number
        System.out.println("Is there aqua park? Y/N ");
        HotelForAgency.hotels.get(HotelForAgency.hotels.size() - 1).setAquaPark(helpingMethods.confirm(in.next().charAt(0)));
        System.out.println(" NEXT STAGE: you will enter room details\n");
        managerEnterRoomDetails();
        System.out.println("Do you want to confirm this hotel and add it to your Agency?");
        if (!helpingMethods.confirm(in.next().charAt(0))) { //if not confirm
            HotelForAgency.hotels.remove(HotelForAgency.hotels.size() - 1);
        }
    }
    public void managerEnterRoomDetails() {
        singleRooms tempSingleRoom = new singleRooms();
        tempSingleRoom.assignRoomDetailsForHotel(HotelForAgency.hotels.get(HotelForAgency.hotels.size() - 1));
        doubleRooms tempDoubleRoom = new doubleRooms();
        tempDoubleRoom.assignRoomDetailsForHotel(HotelForAgency.hotels.get(HotelForAgency.hotels.size() - 1));
        generalRooms tempFamilyRoom = new generalRooms();
        tempFamilyRoom.assignRoomDetailsForHotel(HotelForAgency.hotels.get(HotelForAgency.hotels.size() - 1));
    }
    public void updateHotelInformation() {

        System.out.println(" Are you sure that you want to edit certain hotel?\n Note that : Any changes happen, will be applied to new booking only.");
        if (helpingMethods.confirm(in.next().charAt(0))) {
            displayBasicHotelDetails();
            System.out.println("\n Choose the hotel you want to edit");
            int choice = helpingMethods.choice(1, HotelForAgency.hotels.size());
            System.out.println(" what do you ant to edit?\n 1- Single rooms\n 2- Double rooms\n 3 General rooms\n 4- Rating of the hotel");
            int editChoice = helpingMethods.choice(1, 3);
            switch (editChoice) {
                case 1:
                    singleRooms tempRoom = new singleRooms();
                    tempRoom.updateRoomDetailsForHotel(HotelForAgency.hotels.get(choice - 1));
                    break;
                case 2:
                    doubleRooms tempRoom2 = new doubleRooms();
                    tempRoom2.updateRoomDetailsForHotel(HotelForAgency.hotels.get(choice - 1));
                    break;
                case 3:
                    generalRooms tempRoom3 = new generalRooms();
                    tempRoom3.updateRoomDetailsForHotel(HotelForAgency.hotels.get(choice - 1));
                    break;
                case 4:
                    int newRating = in.nextInt();
                    System.out.println("Confirm new rating to the hotel?");
                    if (helpingMethods.confirm(in.next().charAt(0))) {
                        HotelForAgency.hotels.get(choice - 1).setHotelRating(newRating);
                    }
                    break;
            }
        } else {
            System.out.println(" you will be directed to the homepage.");
        }
    }
    public void displayBasicHotelDetails() {
        System.out.println("<<Hotels available cars your agency>>");
        System.out.println(" ");
        System.out.println("____________________________________");
        for (int h = 0; h < HotelForAgency.hotels.size(); h++) {
            System.out.println(" " + (h + 1) + "| " + HotelForAgency.hotels.get(h).getHotelName());
            System.out.println(" Rating: " + HotelForAgency.hotels.get(h).getHotelRating() + " stars");
            System.out.println(" Location: " + HotelForAgency.hotels.get(h).getHotelLocation());
            System.out.println(" Contact number: " + HotelForAgency.hotels.get(h).getContactNumber());
            System.out.println("____________________________________");
        }

    }
    public void deleteHotel(ArrayList<Customer> Customers) {

        System.out.println(" 1- Delete certain hotel\n 2- Delete all hotels");
        int choice = helpingMethods.choice(1, 2);
        switch (choice) {
            case 1:
                displayBasicHotelDetails();
                System.out.println("\n Choose the hotel you want to delete");
                choice = helpingMethods.choice(1, HotelForAgency.hotels.size());
                System.out.println(" Are you sure ?(y/n)");
                if (helpingMethods.confirm(in.next().charAt(0))) {
                    for (Customer Customer : Customers) {
                        for (int i = 0; i < Customer.getTickets().size(); i++) {
                            if (Customer.getTickets().get(i).Hotel.getHotelID().equals(HotelForAgency.hotels.get(choice - 1).getHotelID())) {
                                Customer.getTickets().get(i).updateTicketPrice(Customer.getTickets().get(i).Hotel.totalPayments * -1);
                                Customer.getTickets().get(i).Hotel = null;
                            }
                        }
                    }
                    HotelForAgency.hotels.remove(choice - 1);
                } else {
                    System.out.println(" Nothing changed, thank you !");
                }
                break;
            case 2:
                System.out.println(" Are you sure ?(y/n)");
                if (helpingMethods.confirm(in.next().charAt(0))) {
                    for (Customer customer : Customers) {
                        for (int i = 0; i < customer.getTickets().size(); i++) {
                            customer.getTickets().get(i).updateTicketPrice(customer.getTickets().get(i).Hotel.totalPayments * -1);
                            customer.getTickets().get(i).Hotel = null;
                        }
                    }
                    HotelForAgency.hotels.clear();
                } else {
                    System.out.println(" Nothing changed, thank you !");
                }
                break;
        }
    }
    public void displayHotelsInAgency() {

        displayBasicHotelDetails();
        System.out.println("Do you want to display certain hotel details?(y/n)");
        if (helpingMethods.confirm(in.next().charAt(0))) {
            System.out.println("Please enter the number of hotel (1,2,3,..,etc)");
            int num = helpingMethods.choice(1, HotelForAgency.hotels.size());
            HotelForAgency.hotelDetails(HotelForAgency.hotels.get(num - 1));
        } else {
            System.out.println(" You will be directed to the homepage");
        }

    }

    // flights
    public void AddNewAirPort() {
        Airport tempAirport = new Airport();
        tempAirport.AddNewAirport();
        Airport.Airports.add(tempAirport);
    }
    public void EditAirport(ArrayList<Customer> customers) {
        if (Airport.Airports.isEmpty())
        {
            System.out.println("You Don't have Airports to Edit ");
            return;
        }
        System.out.println("Please enter the number for Airport you want to Edit ");
        int indexOfAirportYouWantToEdit = DisplayAirportDetails();
        Airport.Airports.get(indexOfAirportYouWantToEdit).EditAirport(customers);
    }
    public void DeleteAnAirport() {
        System.out.println("Please enter the number for Airport you want to delete ");
        int indexOfAirportYouWantToEdit = DisplayAirportDetails();
        Airport.Airports.remove(indexOfAirportYouWantToEdit);

    }
    public int DisplayAirportDetails() {
        int c = 1;
        for (Airport airport : Airport.Airports) {
            System.out.print(c);
            airport.DisplayAirport();
            c++;
        }
        int ans = helpingMethods.choice(1, Airport.Airports.size());
        ans--;
        return ans;
    }
    public void DisplayAirportDetailsMethod() {
        int c = 1;
        for (Airport airport : Airport.Airports) {
            System.out.print(c);
            airport.DisplayAirport();
            c++;
        }

    }

    // cars
    public void AddNewCar() {
        Car temp = new Car();
        temp.AddNewCar();
        Car.cars.add(temp);
    }
    public void EditCarDetails(ArrayList<Customer> customers) {
        if (Car.cars.isEmpty())
        {
            System.out.println("You Don't have Cars to Edit ");
            return;
        }
        System.out.println("Please enter the number for Car you want to Edit ");
        int indexOfCarYouWantToEdit = DisplayAllCars();
        Car.cars.get(indexOfCarYouWantToEdit).editCarData(customers);
    }

    public void DeleteCar() {
        System.out.println("Please enter the number for Airport you want to delete ");
        int indexOfCarYouWantToEdit = DisplayAllCars();
        Car.cars.remove(indexOfCarYouWantToEdit);

    }

    public int DisplayAllCars() {
        for (int i = 0; i < Car.cars.size(); i++) {
            System.out.print(i + 1);
            Car.cars.get(i).DisplayCar();
        }
        int ans = helpingMethods.choice(1, Car.cars.size());
        ans--;
        return ans;
    }
    public void DisplayAllCarsMethod() {
        for (int i = 0; i < Car.cars.size(); i++) {
            System.out.print(i + 1);
            Car.cars.get(i).DisplayCar();
        }

    }

    // Trip Details
    public void addNewTrip(ArrayList<Trip> trips, ArrayList<TourGuide> tourGuide, ArrayList<Customer> customers) {
        char addAnotherTrip;
        do {

            Trip newTrip = null;

            Scanner input = new Scanner(System.in);

            System.out.println("What is the type of the Trip \n1 General\n2 Family\n3 Couple");

            int NumberForTripType = helpingMethods.choice(1, 3);

            switch (NumberForTripType) {
                case 1:
                    newTrip = new General_Tour();
                    newTrip.setTripType("General Tour");
                    break;
                case 2:
                    newTrip = new Family_Tour();
                    newTrip.setTripType("Family Tour");
                    break;
                case 3:
                    newTrip = new Couple_Tour();
                    newTrip.setTripType("Couple Tour");
                    break;
            }


            // Enter Start Date and End Date
            boolean AvailableTourGuide = true;
            do {
                boolean validDate = false;
                while (!validDate) {
                    try {
                        System.out.println("Enter the trip start date (YYYY-MM-DD):");
                        newTrip.setStartDate(input.nextLine());
                        LocalDate startDate = LocalDate.parse(newTrip.getStartDate());
                        validDate = true;
                        if (startDate.isBefore(LocalDate.now())) {
                            System.out.println("Invalid date !! The start date is before the current date.");
                            validDate = false;
                        }
                    } catch (DateTimeParseException e) {
                        System.out.println("Invalid date format. Please enter the date cars the format YYYY-MM-DD.");
                    }

                }

                boolean validEndDate = false;
                while (!validEndDate) {
                    try {
                        System.out.println("Enter the trip end date (YYYY-MM-DD):");
                        LocalDate startDate = LocalDate.parse(newTrip.getStartDate());
                        newTrip.setEndDate(input.nextLine());
                        LocalDate endDate = LocalDate.parse(newTrip.getEndDate());

                        validEndDate = true;

                        if (endDate.isBefore(startDate)) { // || startDate.isAfter(endDate)
                            validEndDate = false;
                            System.out.println("The End Date should be after the Start Date, try again");
                        }

                    } catch (DateTimeParseException e) {
                        System.out.println("Invalid date format. Please enter the date cars the format YYYY-MM-DD.");
                        validEndDate = false;
                    }
                    if (Number_availableGuides(newTrip, tourGuide) == 0) {
                        System.out.println(" No tour guides are available at that time.");
                        System.out.println(" 1- Change start and end date of the trip\n 2- cancel this trip");
                        int choice = helpingMethods.choice(1, 2);
                        if (choice == 1) {
                            AvailableTourGuide = false;
                        } else {
                            System.out.println(" The trip is cancelled successfully.");
                            return;
                        }
                    }
                }

            } while (!AvailableTourGuide);

            System.out.println(" Enter the Name of the trip:");
            newTrip.setTripName(input.nextLine());

            System.out.println(" Enter the Description of the trip:");
            newTrip.setDescription(input.nextLine());

            System.out.println(" Enter the Destination of the trip:");
            newTrip.setDestination(input.nextLine());

            System.out.println(" Enter the number of available Seats:");
            newTrip.setAvailableSeats(input.nextInt());

            System.out.println(" Enter the price per seat:");
            newTrip.setPricePerSeat(input.nextDouble());

            newTrip.displayDetails();
            System.out.println(" This is the details of the Trip.");

            System.out.println(" Now assign the tour guide :");
            AssignTourGuide(newTrip, tourGuide, false, customers);

            char addTrip;
            do {
                System.out.println("if everything is ok and you want to add this Trip enter 'A' or 'a'.");
                addTrip = input.next().charAt(0);
                if (addTrip == 'a' || addTrip == 'A') {
                    trips.add(newTrip);
                } else {
                    System.out.println("Invalid character!");
                }
            } while (addTrip != 'a' && addTrip != 'A');

            System.out.println("The trip has been added successfully");
            //assign tour guide

            System.out.println("Do you want to add another trip ?");
            System.out.println("If you want to add another trip enter 'y' or 'Y'.");
            addAnotherTrip = input.next().charAt(0);
        } while (addAnotherTrip == 'Y' || addAnotherTrip == 'y');

    }
    public void EditTrip(ArrayList<Trip> trips, ArrayList<Customer> customers) {
        System.out.println(" Note that: You can only change Time(start/end time) or available seats, or the price per seat");
        System.out.println(" Otherwise , it is better to delete the trip and add a new one instead");
        System.out.println(" 1- Accept rules and edit a current trip. ");
        System.out.println(" 2- Back to homepage");
        System.out.println(" Your choice:");
        int Choice = helpingMethods.choice(1, 2);
        int choice;
        switch (Choice) {
            case 1:
                System.out.println("  Here are all the trips you added before:");
                System.out.println("-------------------------------------------");
                char EditAnotherTrip;
                do {
                    int NumberOfTrips = trips.size();
                    for (int i = 0; i < NumberOfTrips; i++) {
                        System.out.println(i + 1 + " .");
                        trips.get(i).displayDetails();
                    }
                    System.out.println(" Enter the the number of the trip you want to edit:");
                    choice = helpingMethods.choice(1, trips.size());
                    choice--;

                    Scanner input = new Scanner(System.in);

                    System.out.println("What do you want to edit \n1 start date \n2 end date \n3 available Seats\n4 Price Per Seat ");

                    int ChoiceForChanges = helpingMethods.choice(1, 4);

                    switch (ChoiceForChanges) {
                        case 1:
                            boolean validDate = false;
                            String newDate = null;
                            while (!validDate) {
                                try {
                                    System.out.println("Enter the trip start date (YYYY-MM-DD):");
                                    newDate = input.nextLine();
                                    LocalDate startDate = LocalDate.parse(newDate);
                                    validDate = true; //
                                    if (startDate.isBefore(LocalDate.now()) || startDate.isAfter(LocalDate.parse(trips.get(choice).getEndDate()))) {
                                        System.out.println("The start date is invalid.\nPlease enter valid one ( upcoming date and is before the end date of the trip \" " + trips.get(choice).getEndDate() + "\"");
                                        validDate = false;
                                    }
                                } catch (DateTimeParseException e) {
                                    System.out.println("Invalid date format. Please enter the date cars the format YYYY-MM-DD.");
                                }
                                System.out.println(" Do you want to confirm changes?");
                                char SDconfirmation = in.next().charAt(0);
                                if (helpingMethods.confirm(SDconfirmation)) {
                                    System.out.println(" changes saved!");
                                    trips.get(choice).setStartDate(newDate);
                                } else {
                                    System.out.println("No changes saved");
                                }
                            }
                            break;
                        case 2:
                            boolean validEndDate = false;
                            String newEndDate = null;

                            while (!validEndDate) {
                                try {
                                    System.out.println("Enter the trip end date (YYYY-MM-DD):");
                                    newEndDate = input.nextLine();
                                    LocalDate endDate = LocalDate.parse(newEndDate);
                                    validEndDate = true;

                                    if (endDate.isBefore(LocalDate.parse(trips.get(choice).getStartDate()))) {
                                        validEndDate = false;
                                        System.out.println("The End Date should be after the Start Date, try again");
                                    }
                                } catch (DateTimeParseException e) {
                                    System.out.println("Invalid date format. Please enter the date cars the format YYYY-MM-DD.");
                                }
                            }
                            System.out.println(" Do you want to confirm changes?");
                            char EDconfirmation = in.next().charAt(0);
                            if (helpingMethods.confirm(EDconfirmation)) {
                                System.out.println(" changes saved!");
                                trips.get(choice).setEndDate(newEndDate);
                            } else {
                                System.out.println("No changes saved");
                            }
                            break;
                        case 3:
                            boolean SeatsNumberValid = true;
                            int oldAvailableSeats = trips.get(choice).getAvailableSeats();
                            int newSeats;
                            do {
                                System.out.println("Enter the number of available Seats:");
                                newSeats = helpingMethods.checkIntInput();
                                SeatsNumberValid = newSeats >= 1;
                            } while (!SeatsNumberValid);
                            System.out.println(" Do you want to confirm changes?");
                            char AVASconfirmation = in.next().charAt(0);
                            if (helpingMethods.confirm(AVASconfirmation)) {
                                trips.get(choice).setAvailableSeats(newSeats);
                                System.out.println(" changes saved!");
                            } else {
                                System.out.println("No changes saved");
                            }
                            break;
                        case 4:
                            double oldPrice = trips.get(choice).getPricePerSeat();
                            System.out.println("Enter the price per seat:");
                            double newPrice = helpingMethods.checkFeesInput();
                            System.out.println(" Do you want to confirm ?");
                            char priceConfirmation = in.next().charAt(0);
                            if (helpingMethods.confirm(priceConfirmation)) {
                                trips.get(choice).setPricePerSeat(newPrice);
                                System.out.println(" changes saved!");
                                //cancel function
                            } else {
                                System.out.println("No changes saved");
                            }
                            break;
                    }

                    trips.get(choice).displayDetails();
                    System.out.println("This is the updated details of the Trip.");
                    System.out.println("Do you want to edit another trip ( Y / N ) ?");
                    EditAnotherTrip = input.next().charAt(0);
                } while (EditAnotherTrip == 'Y' || EditAnotherTrip == 'y');
                System.out.println("The trips has changed  successfully");
                break;

            case 2:

        }

    }

    public void managerDeleteTrip(ArrayList<Trip> trips, ArrayList<Customer> customers) {

        do {
            System.out.println("  Here are all the trips you added before:");
            System.out.println("-------------------------------------------");
            int NumberOfTrips = trips.size();
            for (int i = 0; i < NumberOfTrips; i++) {
                System.out.println(i + 1 + " .");
                trips.get(i).displayDetails();
            }
            System.out.println(" Enter the the number of the trip you want to delete:");
            int choice = helpingMethods.choice(1, trips.size());
            CancelTripReservation(trips.get(choice - 1), customers);
            trips.remove(choice - 1);
            System.out.println(" DO you want to delete another trip?");
        } while (helpingMethods.confirm(in.next().charAt(0)));
    }

    public void CancelTripReservation(Trip trip, ArrayList<Customer> customers) {
        int NumberOfCustomer = customers.size();
        for (Customer customer : customers) {
            int NumberOfTickets = customer.getTickets().size();
            for (int j = 0; j < NumberOfTickets; j++) {
                if (trip.getTripID() == customer.getTickets().get(j).getTrip().getTripID()) {
                    customer.getTickets().get(j).CancelTicket();
                }
            }
        }
    }

    //Activity details
    public void addNewActivity() {

        char addAnotherActivity;
        do {
            // Start Add Activity Code
            Activity newActivity = new Activity();

            Scanner input = new Scanner(System.in);

            System.out.println("Enter the Name of the Activity:");
            newActivity.setName(input.nextLine());

            System.out.println("Choose the type of the Activity: \n1Sightseeing\n2 Water Activities,\n3 Cultural Experiences\n4 Culinary Tours\n5 Adventure Activities\n6 Wildlife Encounters\n7 Relaxation and Wellness\n8 Entertainment and Nightlife\n9 Shopping\n10 Educational Tours\n11 Photography Tours\n12 Sports Activities ");

            int NumberOfTripType = helpingMethods.choice(1, 12);

            switch (NumberOfTripType) {
                case 1:
                    newActivity.setActivityType("Sightseeing");

                    break;
                case 2:
                    newActivity.setActivityType("Water Activities");

                    break;
                case 3:
                    newActivity.setActivityType("Cultural Experiences");

                    break;
                case 4:
                    newActivity.setActivityType("Culinary Tours");

                    break;
                case 5:
                    newActivity.setActivityType("Adventure Activities");

                    break;
                case 6:
                    newActivity.setActivityType("Wildlife Encounters");

                    break;
                case 7:
                    newActivity.setActivityType("Relaxation and Wellness");

                    break;
                case 8:
                    newActivity.setActivityType("Entertainment and Nightlife");

                    break;
                case 9:
                    newActivity.setActivityType("Shopping");

                    break;
                case 10:
                    newActivity.setActivityType("Educational Tours");

                    break;
                case 11:
                    newActivity.setActivityType("Photography Tours");

                    break;
                case 12:
                    newActivity.setActivityType("Sports Activities");
                    break;
                default:
                    System.out.println("Invalid Activity Type, Please enter one of the types above");
            }


            System.out.println("Is the activity suitable for \n1 children\n2 couple \n3 for everyone ");


            int NumberOfInput = helpingMethods.choice(1, 3);


            switch (NumberOfInput) {
                case 1:
                    newActivity.setSuitableFor("Family");
                    break;
                case 2:
                    newActivity.setSuitableFor("Couple");
                    break;
                case 3:
                    newActivity.setSuitableFor("General");
                    break;
                default:

                    System.out.println("Invalid Activity Type, Please enter \"children\", \"couple\" or \"everyone\".");
                    break;
            }


            System.out.println("Enter the Description of the Activity:");
            newActivity.setDescription(input.nextLine());

            boolean validDate = false;
            while (!validDate) {
                try {
                    System.out.println("Enter the Activity Date (YYYY-MM-DD):");
                    newActivity.setDate(input.nextLine());
                    LocalDate startDate = LocalDate.parse(newActivity.getDate());

                    validDate = true;
                } catch (DateTimeParseException e) {
                    System.out.println("Invalid date format. Please enter the date the format YYYY-MM-DD.");
                }
            }


            System.out.println("Enter the location of the Activity:");

            newActivity.setLocation(input.nextLine());

            System.out.println("Enter the Activity's Duration car minutes:");
            int num = helpingMethods.choice(1, 59);
            newActivity.setDuration(num);

            System.out.println("Enter the price per seat:");
            double Price = helpingMethods.checkFeesInput();
            newActivity.setPrice(Price);

            // End Add Activity Code

            newActivity.displayActivityDetails();
            System.out.println("This is the details of the Activity.");
            System.out.println("Do you want to confirm ( Y | N ) ?");
            char answer;
            answer = input.next().charAt(0);
            answer = helpingMethods.InputYesOrNo(answer);
            if (answer == 'Y' || answer == 'y') {
                Activity.Activities.add(newActivity);
                System.out.println("The activity has been added successfully");
            } else {
                return;
            }

            System.out.println("Do you want to add another activity?");
            System.out.println("If you want to add another activity enter 'y' or 'Y'.");
            addAnotherActivity = input.next().charAt(0);
            addAnotherActivity = helpingMethods.InputYesOrNo(addAnotherActivity);
        } while (addAnotherActivity == 'Y' || addAnotherActivity == 'y');
    }

    public void EditActivity(ArrayList<Customer> customers) {

        do {
            if (!Activity.DisplayActivities()) {
                return;
            }
            System.out.println("Choose the number of Activity you want to change ");
            int Index = helpingMethods.choice(1, Activity.Activities.size());
            Index--;
            Activity oldOne = Activity.Activities.get(Index);
            Scanner input = new Scanner(System.in);
            System.out.println(" what do you want to edit? ");
            System.out.println(" 1- people that this activity is suitable for.\n 2- Date\n 3- Duration\n4- Price per seat");
            switch (helpingMethods.choice(1, 4)) {
                case 1:
                    System.out.println("Is the activity suitable for \n1 children\n2 couple \n3 for everyone ");
                    int NumberOfInput = helpingMethods.choice(1, 3);
                    switch (NumberOfInput) {
                        case 1:
                            Activity.Activities.get(Index).setSuitableFor("Family");
                            break;
                        case 2:
                            Activity.Activities.get(Index).setSuitableFor("Couple");
                            break;
                        case 3:
                            Activity.Activities.get(Index).setSuitableFor("General");
                            break;
                    }
                    break;
                case 2:
                    boolean validDate = false;
                    while (!validDate) {
                        try {
                            System.out.println("Enter the Activity new Date (YYYY-MM-DD):");
                            Activity.Activities.get(Index).setDate(input.nextLine());
                            LocalDate Date = LocalDate.parse(Activity.Activities.get(Index).getDate());
                            validDate = true;
                        } catch (DateTimeParseException e) {
                            System.out.println("Invalid date format. Please enter the date the format YYYY-MM-DD.");
                        }
                    }
                    break;
                case 3:
                    System.out.println("Enter the Activity's Duration car minutes:");
                    int num = helpingMethods.choice(1, 59);
                    Activity.Activities.get(Index).setDuration(num);
                    break;
                case 4:
                    System.out.println("Enter the price per seat:");
                    double Price = helpingMethods.checkFeesInput();
                    Activity.Activities.get(Index).setPrice(Price);
                    break;
            }
            cancelActivityFromCustomerTicket(oldOne, customers);
            System.out.println(" All changes saved!");
            System.out.println("This is the new details of the Activity.");
            Activity.Activities.get(Index).displayActivityDetails();
            System.out.println("Do you want to edit another activity?");

        } while (helpingMethods.confirm(in.next().charAt(0)));
    }

    public void cancelActivityFromCustomerTicket(Activity activityToCancel, ArrayList<Customer> customers) {
        for (Customer customer : customers) {
            int NumberOfTickets = customer.getTickets().size();
            for (int j = 0; j < NumberOfTickets; j++) {
                customer.getTickets().get(j).getActivities().remove(activityToCancel);
                customer.getTickets().get(j).updateTicketPrice(activityToCancel.getPrice() * -1);
            }
        }
    }

    public void deleteActivity(ArrayList<Customer> customers) {
        if (Activity.DisplayActivities()) {
            System.out.println(" Enter the number of activity you want to delete");
            int numberOfActivity = helpingMethods.choice(1, Activity.Activities.size());
            cancelActivityFromCustomerTicket(Activity.Activities.get(numberOfActivity - 1), customers);
            Activity.Activities.remove(numberOfActivity - 1);
        }
    }

    public void AssignTourGuide(Trip trip, ArrayList<TourGuide> tourGuides, boolean reAssignTourGuide, ArrayList<Customer> customers) {

        if (Number_availableGuides(trip, tourGuides) == 0) {
            System.out.println(" No tour guides are available at that time.");
            System.out.println(" 1- Change start and end date of the trip\n 2- cancel this trip");
            int ans = helpingMethods.choice(1, 2);
            if (ans == 1) {
                boolean AvailableTourGuide = true;
                do {
                    boolean validDate = false;
                    while (!validDate) {
                        try {
                            System.out.println("Enter the trip start date (YYYY-MM-DD):");
                            trip.setStartDate(in.nextLine());
                            LocalDate startDate = LocalDate.parse(trip.getStartDate());
                            validDate = true;
                            if (startDate.isBefore(LocalDate.now())) {
                                System.out.println("Invalid date !! The start date is before the current date.");
                                validDate = false;
                            }
                        } catch (DateTimeParseException e) {
                            System.out.println("Invalid date format. Please enter the date cars the format YYYY-MM-DD.");
                        }
                    }

                    boolean validEndDate = false;
                    while (!validEndDate) {
                        try {
                            System.out.println("Enter the trip end date (YYYY-MM-DD):");
                            LocalDate startDate = LocalDate.parse(trip.getStartDate());
                            trip.setEndDate(in.nextLine());
                            LocalDate endDate = LocalDate.parse(trip.getEndDate());

                            validEndDate = true;

                            if (endDate.isBefore(startDate)) { // || startDate.isAfter(endDate)
                                validEndDate = false;
                                System.out.println("The End Date should be after the Start Date, try again");
                            }

                        } catch (DateTimeParseException e) {
                            System.out.println("Invalid date format. Please enter the date cars the format YYYY-MM-DD.");
                        }
                        if (Number_availableGuides(trip, tourGuides) == 0) {
                            System.out.println(" No tour guides are available at that time.");
                            System.out.println(" 1- Change start and end date of the trip\n 2- cancel this trip");
                            int choice = helpingMethods.choice(1, 2);
                            if (choice == 1) {
                                AvailableTourGuide = false;
                            } else {
                                System.out.println(" The trip is cancelled successfully.");
                                if (reAssignTourGuide) {
                                    CancelTripReservation(trip, customers);
                                }
                                return;
                            }
                        }
                    }

                } while (!AvailableTourGuide);
            } else {
                System.out.println(" The trip is cancelled successfully.");
                if (reAssignTourGuide) {
                    CancelTripReservation(trip, customers);
                }

            }
        } else {
            ArrayList<TourGuide> AvailableTourGuide = AvailableGuides(trip, tourGuides);
            System.out.println("Pleas choose Number of tour Guide ");
            int choice = helpingMethods.choice(1, AvailableTourGuide.size());
            int Index = tourGuides.indexOf(AvailableTourGuide.get(choice - 1));
            tourGuides.get(Index).getHistorytrips().add(trip);
            trip.setAssignedTourGuides(tourGuides.get(Index).getUsername());

        }
    }

    public void checkTourGuideComplaints(ArrayList<TourGuide> tourGuides, ArrayList<Customer> customers) {
        tourGuides.stream().
                filter(guide -> !guide.getComplainttrips().isEmpty())
                .forEach(TourGuide::DisplayTourGuide);

        boolean found = false;
        for (int i = 0; i < tourGuides.size(); i++) {
            for (int j = 0; j < tourGuides.get(i).getComplainttrips().size(); j++) {
                found = true;
                AssignTourGuide(tourGuides.get(i).getComplainttrips().get(i), tourGuides, true, customers);
            }
        }
        if (found) {
            for (int i = 0; i < tourGuides.size(); i++) {
                for (int j = 0; j < tourGuides.get(i).getComplainttrips().size(); j++) {
                    tourGuides.get(i).getComplainttrips().remove(i);
                }
            }
        } else {
            System.out.println("there are not TourGuide Complaints ");
        }


    }

}
