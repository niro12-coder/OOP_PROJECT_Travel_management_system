package cis.travel.eg.User.CustomerDetails;

import java.io.Serializable;
import java.time.DayOfWeek;
import java.time.LocalDate;

import cis.travel.eg.Main.Ticket;
import cis.travel.eg.Main.Voucher;
import cis.travel.eg.Service.Hotels.Reservation.hotelReservation;
import cis.travel.eg.Trip.Family_Tour;
import cis.travel.eg.Trip.General_Tour;
import cis.travel.eg.Trip.Couple_Tour;
import cis.travel.eg.Trip.Trip;

import java.util.ArrayList;
import java.util.stream.IntStream;

import cis.travel.eg.Service.*;
import cis.travel.eg.User.Admin;
import cis.travel.eg.User.Manager;
import cis.travel.eg.User.TourGuideDetails.TourGuide;
import cis.travel.eg.User.User;

import static cis.travel.eg.Main.Main.*;


public class Customer extends User implements CustomerInterface, Serializable {


    private String country;
    private String preferredCurrency;
    private String preferredLanguage;
    private String preferredPayment;
    private int totaltrips;
    private ArrayList<Ticket> tickets = new ArrayList<>();
    private ArrayList<Voucher> vouchers = new ArrayList<>();
    private ArrayList<Activity> savedActivities = new ArrayList<>();
    private ArrayList<String> feedback = new ArrayList<String>();
    private ArrayList<Trip> suitableTrip = new ArrayList<Trip>(); // saved for the customer


    public Customer() { //if admin make a new account and want to copy details?

    }

//    public Customer(Customer c) { //if admin make a new account and want to copy details?
//        this.country = c.country;
//        this.preferredCurrency = c.preferredCurrency;
//        this.preferredPayment = c.preferredPayment;
//        this.preferredLanguage = c.preferredLanguage;
//    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPreferredCurrency() {
        return preferredCurrency;
    }

    public void setPreferredCurrency(String preferredCurrency) {
        this.preferredCurrency = preferredCurrency;
    }

    public String getPreferredLanguage() {
        return preferredLanguage;
    }

    public void setPreferredLanguage(String preferredLanguage) {
        this.preferredLanguage = preferredLanguage;
    }

    public String getPreferredPayment() {
        return preferredPayment;
    }

    public void setPreferredPayment(String preferredPayment) {
        this.preferredPayment = preferredPayment;
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

    public int Edit_Profile(ArrayList<Admin> admin, ArrayList<Customer> customer, ArrayList<Manager> manager, ArrayList<TourGuide> tourguide) {
        String fname, lname, country, pass1, pass2, language, payment, currency;
        int option, age;
        do {
            System.out.println("welcome " + super.getUsername());
            System.out.println("choose which option you want to change ");
            System.out.println(" 1)  first name \n2) Last name \n 3) Password \n 4) Country \n 5) Age \n 6) Preferred Language \n 7) Preferred Payment \n 8) Preferred Currency \n");
            switch (input(1, 8)) {
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
                    System.out.println("Done successfully ");
                    break;
                case 4:
                    System.out.println("please enter your new country ");
                    country = in.next();
                    setCountry(country);
                    System.out.println("Done successfully your new country now is " + getCountry());
                    break;
                case 5:
                    System.out.println("please enter your age ");
                    age = in.nextInt();
                    super.setAge(age);
                    System.out.println("Done successfully");
                    break;
                case 6:
                    System.out.println("please enter your new preferred language ");
                    language = in.next();
                    setPreferredLanguage(language);
                    System.out.println("Done successfully your new preferred language now is " + getPreferredLanguage());
                    break;
                case 7:
                    System.out.println("please enter your new preferred payment ");
                    payment = in.next();
                    setPreferredPayment(payment);
                    System.out.println("Done successfully your new preferred payment now is " + getPreferredPayment());
                    break;
                case 8:
                    System.out.println("please enter your new preferred currency ");
                    currency = in.next();
                    setPreferredCurrency(currency);
                    System.out.println("Done successfully your new preferred currency now is " + getPreferredCurrency());
                    break;
            }
            System.out.println("Do you want to make another change(y,n)?");

        } while (confirm(in.next().charAt(0)));


        System.out.println("1.Display Profile\n2.Home page\n3.Exit");
        option = input(1, 3);
        return ( option == 1 ? 1 : (option == 2) ? -1 : 0);

    }
    public boolean compare(Trip t1, Trip t2) {

        return t1.getTripType().equals(t2.getTripType()) && t1.getStartDate().equals(t2.getStartDate())
                && t1.getEndDate().equals(t2.getEndDate()) && t1.getAvailableSeats() == t2.getAvailableSeats()
                && t1.getPricePerSeat() == t2.getPricePerSeat() && t1.getDestination().equals(t2.getDestination());
    }

    public int Display_Profile(ArrayList<Admin> admin, ArrayList<Customer> customer, ArrayList<Manager> manager, ArrayList<TourGuide> tourguide) {
        System.out.println("\u001B[34m╭──────────────────────────────────────────────────╮");
        System.out.println("│              "+ ANSI_COLORS[16]+"     **WELCOME**       "+ ANSI_COLORS[5]+"           │");
        System.out.println("├──────────────────────────────────────────────────┤");
        System.out.println("│ Your First Name: " + ANSI_COLORS[16] + super.getFirstName() + ANSI_COLORS[5]);
        System.out.println("├──────────────────────────────────────────────────┤");
        System.out.println("│ Your Last Name: " + ANSI_COLORS[16] + super.getLastName() + ANSI_COLORS[5]);
        System.out.println("├──────────────────────────────────────────────────┤");
        System.out.println("│ Your Country: " + ANSI_COLORS[16] + getCountry() + ANSI_COLORS[5]);
        System.out.println("├──────────────────────────────────────────────────┤");
        System.out.println("│ Your Gender: " + ANSI_COLORS[16] + super.getGender() + ANSI_COLORS[5]);
        System.out.println("├──────────────────────────────────────────────────┤");
        System.out.println("│ Your Age: " + ANSI_COLORS[16] + super.getAge() + ANSI_COLORS[5]);
        System.out.println("├──────────────────────────────────────────────────┤");
        System.out.println("│ Your Preferred Language: " + ANSI_COLORS[16] + getPreferredLanguage() + ANSI_COLORS[5]);
        System.out.println("├──────────────────────────────────────────────────┤");
        System.out.println("│ Your Preferred Payment: " + ANSI_COLORS[16] + getPreferredPayment() + ANSI_COLORS[5]);
        System.out.println("├──────────────────────────────────────────────────┤");
        System.out.println("│ Your Preferred Currency: " + ANSI_COLORS[16] + getPreferredCurrency() + ANSI_COLORS[5]);
        System.out.println("├──────────────────────────────────────────────────┤");
        System.out.println("│ Trips Made: " + ANSI_COLORS[16] + getTotaltrips() + ANSI_COLORS[5]);
        System.out.println("├──────────────────────────────────────────────────┤");
        System.out.println("│ Vouchers: " + ANSI_COLORS[16] + getVouchers() + ANSI_COLORS[5]);
        System.out.println("╰──────────────────────────────────────────────────╯\u001B[97m");

        System.out.println("1.Edit your Profile\n2.Home page\n3. Exit");
        int choice = in.nextInt();
        if (choice == 1) return Edit_Profile(admin, customer, manager, tourguide);
        else return (choice == 2 ? -1 : 0);
    }

    public boolean HomePage(ArrayList<Admin> Admins, ArrayList<Customer> Customers, ArrayList<TourGuide> TourGuides, ArrayList<Manager> Managers, ArrayList<Trip> Trips_system) {
        int Case;
        do {

            System.out.println("\u001B[34m" +
                               "╭───────────────────────────────────╮");
            System.out.println("│             * Welcome *           │");
            System.out.println("│   [0]"+ ANSI_COLORS[16] +" Exit        "          + ANSI_COLORS[5] +"                │");
            System.out.println("│   1)"+ ANSI_COLORS[16] +" My Profile   "          + ANSI_COLORS[5] +"                │");
            System.out.println("│   2)"+ ANSI_COLORS[16] +" Book a Ticket  "        + ANSI_COLORS[5] +"              │");
            System.out.println("│   3)"+ ANSI_COLORS[16] +" View Booked Tickets "   + ANSI_COLORS[5] +"         │");
            System.out.println("│   4)"+ ANSI_COLORS[16] +" Canceling           "   + ANSI_COLORS[5] +"         │");
            System.out.println("│   5)"+ ANSI_COLORS[16] +" Edit Travel           " + ANSI_COLORS[5] +"       │");
            System.out.println("│   6)"+ ANSI_COLORS[16] +" View Travel Services   " + ANSI_COLORS[5] +"      │");
            System.out.println("│   7)"+ ANSI_COLORS[16] +" Feedback and Rating     "+ ANSI_COLORS[5] +"     │");
            System.out.println("│   8)"+ ANSI_COLORS[16] +" Log Out                 "+ ANSI_COLORS[5] +"     │");
            System.out.println("╰───────────────────────────────────╯\u001B[97m");
            feedback(Trips_system);
            Case = input(0, 8);
            while (Case > 0 && Case < 9) {

                switch (Case) {
                    case 1:
                        Case = Display_Profile(Admins, Customers, Managers, TourGuides);
                        break;
                    case 2:
                        Case = bookTicket(Trips_system);
                        break;
                    case 3:
                        if(tickets.size()!=0)
                        {Ticket.displayTicketsForCustomer(tickets);}
                        else System.out.println(" no tickets to display");
                        System.out.println(" 1. HomePage \n 2. Exit");
                        Case = (input(1, 2) == 1 ? -1 : 0);
                        break;
                    case 4:
                        canceling();
                        System.out.println(" 1. HomePage \n 2. Exit");
                        Case = (input(1, 2) == 1 ? -1 : 0);
                        break;
                    case 5:
                        Case = editTicket(Trips_system);
                        break;
                    case 6:
                        Case = viewTravelServices(Trips_system);
                        break;
                    case 7:
                        feedback(Trips_system);
                        System.out.println(" 1. HomePage \n 2. Exit");
                        Case = (input(1, 2) == 1 ? -1 : 0);
                        break;
                    case 8:
                        Case = 8;
                        break;

                }
            }
        } while (Case == -1);

        return Case == 0; // if = 0 then return true (exit) , else return false (logout)
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
        System.out.print("│ Email (Example@gmail.com): ");
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
        System.out.print("│ Country: ");
        setCountry(in.next());
        System.out.println("\u001B[34m├───────────────────────────────────────────────────────────┤");
        System.out.print("│ Preferred Language: ");
        setPreferredLanguage(in.next());
        System.out.println("\u001B[34m├───────────────────────────────────────────────────────────┤");
        System.out.print("│ Preferred Currency: ");
        setPreferredCurrency(in.next());
        System.out.println("\u001B[34m├───────────────────────────────────────────────────────────┤");
        System.out.print("│ Preferred Payment: ");
        setPreferredPayment(in.next());
        System.out.println("\u001B[34m╰───────────────────────────────────────────────────────────╯\u001B[97m");

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


    public void displayActivities(String tripType, int index) { //by tripType & ticketType
        System.out.println("Activities suitable for " + tripType + " trip:");
        boolean check;
        ArrayList<Activity> activities = new ArrayList<>();
        Family_Tour f = new Family_Tour();
        Couple_Tour c = new Couple_Tour();
        General_Tour g = new General_Tour();
        do {
            check = true;
            switch (tripType) {
                case "Family Tour":
                    f.addActivity(Activity.Activities);
                    activities = f.getFamilyActivities();
                    break;
                case "Couple Tour":
                    c.addActivity(Activity.Activities);
                    activities = c.getCoupleActivities();
                    break;
                case "General Tour":
                    g.addActivity(Activity.Activities);
                    activities = g.getGeneralActivities();
                    break;
                default:
                    System.out.println("Invalid trip type!");
                    check = false;
            }
        } while (!check);

        int count = 0;

        try {
            for (Activity activity : activities) {
                if (activity != null) {
                    activity.setActivityID(++count);
                    System.out.println(activity.getName());
                    System.out.print(count + ". ");
                    activity.displayActivityDetails();
                }
            }
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }

        do {
            System.out.println("Enter the Activity number:");
            int indexYourActivity = input(1, count);
            savedActivities.add(activities.get(indexYourActivity - 1));
            System.out.println("Do you want to choose another Activity(Y,N)?");

        } while (confirm(in.next().charAt(0)));
        tickets.get(index).setActivities(savedActivities);

    }

    public void displayActivities(String tripType, String activityType, int index) {  //by tripType & ticketType & activityType

        boolean check;
        ArrayList<Activity> activities=null;
        Family_Tour f = new Family_Tour();
        Couple_Tour c =new Couple_Tour();
        General_Tour g=new General_Tour();
        do {
            check = true;
            switch (tripType) {
                case "Family Tour": f.addActivity(Activity.Activities);
                    activities = f.getFamilyActivities();

                    break;
                case "Couple Tour":c.addActivity(Activity.Activities);
                    activities = c.getCoupleActivities();
                    break;
                case "General Tour": g.addActivity(Activity.Activities);
                    activities = g.getGeneralActivities();
                    break;
                default:
                    System.out.println("Invalid trip type, try again!");
                    check = false;
            }
        } while(!check);

        int count = 0;
        try {
            for (Activity activity : activities) {
                if (activity != null ) {
                    activity.setActivityID(++count);
                    System.out.println(activity.getName());
                    System.out.print(count + ". ");
                    activity.displayActivityDetails();
                }
            }
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }

        do {
            System.out.println("Enter the Activity number:");
            int indexYourActivity = input(1, count);
            savedActivities.add(activities.get(indexYourActivity - 1));

            System.out.println("Do you want to choose another Activity(Y,N)?");

        } while (confirm(in.next().charAt(0)));
        tickets.get(index).setActivities(savedActivities);
    }

    public void delete_travel_itinerary_By_Name(int index) {
        do {
            try {
                System.out.println("Write the name of the Activity you want to remove: ");
                String activityName = in.next();
                for (Activity a : tickets.get(index).getActivities()) {
                    if (activityName.equalsIgnoreCase(a.getName())) {
                        tickets.get(index).getActivities().remove(a);
                        System.out.println("Activity '" + activityName + "' removed successfully!");
                        return;
                    } else {
                        System.out.println("Activity '" + activityName + "' not found!");
                    }
                }
            } catch (Exception e) {
                System.out.println("Error deleting Activity from trip: " + e.getMessage());
            }
            System.out.println("Do you want to remove another Activity (Y,N)?");
        } while (confirm(in.next().charAt(0)));
    }


    public int bookTicket(ArrayList<Trip> Trips_system) {

        if(maxBooking()) {
            tickets.add(new Ticket());
            bookTrip(Trips_system);      // indexOfTrip --> suitableTrip , date, type_trip, destination , numOfSeats
            System.out.println("What type of ticket do you want to book?");
            System.out.println("1. Silver ticket\n2. Golden ticket\n3. Platinum ticket ");

            switch (input(1, 3)) {
                case 1:
                    tickets.get(tickets.size() - 1).setType("Silver");
                    break;
                case 2:
                    tickets.get(tickets.size() - 1).setType("Golden");
                    break;
                case 3:
                    tickets.get(tickets.size() - 1).setType("Platinum");
                    break;
            }
            System.out.println("What do you want to do now?");
            boolean finish = false;
            do {
                System.out.println("1. Search for Activities.");
                System.out.println("2. Book a flight.");
                System.out.println("3. Rent a car.");
                System.out.println("4. Search for hotel.");
                System.out.println("5. Finish booking. ");
                System.out.println("Enter the suitable number:  ");
                int assignToTicket = input(1, 5);
                boolean check;
                do {
                    check = true;
                    switch (assignToTicket) {
                        case 1: //book activities function
                            System.out.println("Now, Choose the Activity you want: ");
                            System.out.println(Activity.Activities.get(0).getSuitableFor());
                            displayActivities(tickets.get(tickets.size() - 1).getTrip().getTripType(), tickets.size() - 1); // savedActivities
                            break;
                        case 2:
                            tickets.get(tickets.size() - 1).bookAFlight();

                            break;
                        case 3:
                            tickets.get(tickets.size() - 1).WantToRentCar(tickets.get(tickets.size() - 1).getTrip().getStartDate(), tickets.get(tickets.size() - 1).getTrip().getEndDate(), tickets.get(tickets.size() - 1).getCustomerDestination());//rent car function
                            break;
                        case 4:
                            Ticket.bookHotelRoom(tickets.get(tickets.size() - 1), false);
                            break;
                        case 5:
                            finish = true;
                            break;
                        default:
                            System.out.println("Invalid choice, try again");
                            check = false;
                    }
                } while(!check);

                if (!finish) {
                    System.out.println("Service is added to your ticket successfully");
                    System.out.println("Do you want to assign another service to your ticket(Y,N)?");
                } else
                    break;

            } while (confirm(in.next().charAt(0)));

            System.out.println(" Do you want to confirm this ticket?");
            if (confirm(in.next().charAt(0))) {
                tickets.get(tickets.size() - 1).setCustomerLocation(country);
                tickets.get(tickets.size() - 1).setConfirmationNumber(tickets.get(tickets.size() - 1).getConfirmationNumber() + tickets.get(tickets.size() - 1).getTrip().getTripID());
                System.out.println(" Ticket is added to your bookings successfully!");
                tickets.get(tickets.size() - 1).ticketDetails();
                //send an email
            } else {
                tickets.remove(tickets.size() - 1);
                System.out.println(" Ticket is not saved.");
                System.out.println(" you will be directed to the home page now.");
            }
        }

        System.out.println("       1. Home page \n       2. Exit");
        return (input(1, 2) == 1 ? -1 : 0);
    }

    public void bookTrip(ArrayList<Trip> Trips_system) {
        int indexOfTrip;
        LocalDate dateOfTrip;
        System.out.println("what is your destination ?");
        tickets.get(tickets.size() - 1).setCustomerDestination(destinationDisplay());  //  String destination = destinationDisplay();
        System.out.println("which tour type do you want ?");
        System.out.println("1.Couple Tour\n2.Family Tour\n3.General Tour ");
        String TourType = null;
        boolean check;
        do {
            check = true;
            switch (input(1, 3)) {
                case 1:
                    TourType = "Couple Tour";
                    tickets.get(tickets.size() - 1).setTrip(new Couple_Tour());
                    break;
                case 2:
                    TourType = "Family Tour";
                    tickets.get(tickets.size() - 1).setTrip(new Family_Tour());
                    break;
                case 3:
                    TourType = "General Tour";
                    tickets.get(tickets.size() - 1).setTrip(new General_Tour());
                    break;
                default:
                    System.out.println("Invalid choice, try again!");
                    check = false;
            }
        }while(!check);

        System.out.println("Do you want choose by a certain time ? (y/n)");
        if (confirm(in.next().charAt(0))) {
            System.out.println(" 1. Day \n 2. Date");
            if (input(1, 2) == 1) {
                String dayName = dayDisplay();
                dateOfTrip = calender_date(dayName);
            } else {
                dateOfTrip = inputDate();
            }
            indexOfTrip = displayTrip(dateOfTrip, tickets.get(tickets.size() - 1).getCustomerDestination(), TourType, Trips_system);  // after display trips by filters , // Enter the suitable number : , return input(a, b)}
        } else {
            indexOfTrip = displayTrip(tickets.get(tickets.size() - 1).getCustomerDestination(), TourType, Trips_system);
        }
        // suitableTrip.get(indexOfTrip);
        //save in ticket
        tickets.get(tickets.size() - 1).setTrip(suitableTrip.get(indexOfTrip));

        System.out.println("Now, Enter the suitable number of seats : ");
        tickets.get(tickets.size() - 1).setNumberOfSeats(input(1, tickets.get(tickets.size() - 1).getTrip().getAvailableSeats()));
    }

    public int displayTrip(LocalDate date, String destination, String tourType, ArrayList<Trip> Trips_system) { // by date , destination, tourType
        int count = 0;
        int choice =0;
//temp comment
//        if(tourType.equals("Couple Tour"))
//            Trips_system.add(new Couple_Tour());
//        else if(tourType.equals("General Tour"))
//            Trips_system.add(new General_Tour());
//        else if(tourType.equals("Family Tour"))
//            Trips_system.add(new Family_Tour());

        try {
//            IntStream.range(0, Trips_system.size())
//                    .filter(i -> LocalDate.parse(Trips_system.get(i).getStartDate()).equals(date) && Trips_system.get(i).getDestination().equals(destination) && Trips_system.get(i).getTripType().equals(tourType))
//                    .forEach(i -> {
//                       // suitableTrip.add(Trips_system.get(i));
//                        System.out.print((count + 1) + ". ");
//                        Trips_system.get(i).displayDetails();
//                    });
            for (int i = 0; i < Trips_system.size(); i++) {
                if (LocalDate.parse(Trips_system.get(i).getStartDate()).equals(date) &&
                        Trips_system.get(i).getDestination().equals(destination) &&
                        Trips_system.get(i).getTripType().equals(tourType)) {

                    //suitableTrip.add(Trips_system.get(i));
                    System.out.print((i + 1) + ". ");
                    Trips_system.get(i).displayDetails();
                }
            }
            System.out.println("Enter the suitable number: ");
            choice = input(1, suitableTrip.size()) - 1;
        } catch (NullPointerException e) {
            System.out.println("No trip was found! " + e.getMessage());
        } finally {
            return choice; //1-based --> 0-based
        }
    }


    public int displayTrip(String destination, String tourType, ArrayList<Trip> Trips_system) { //by destination and tourType
        int count = 0;
        int in = 0;

//        if (tourType.equals("Couple Tour"))
//            Trips_system.add(new Couple_Tour());
//        else if (tourType.equals("General Tour"))
//            Trips_system.add(new General_Tour());
//        else if (tourType.equals("Family Tour"))
//            Trips_system.add(new Family_Tour());

        try {
//            IntStream.range(0, Trips_system.size())
//                    .filter(i -> Trips_system.get(i).getDestination().equals(destination) && Trips_system.get(i).getTripType().equals(tourType))
//                    .forEach(i -> {
//                        suitableTrip.add(Trips_system.get(i));
//                        System.out.print((i + 1) + ". ");
//                        Trips_system.get(i).displayDetails();
//                    });

            for (int i = 0; i < Trips_system.size(); i++) {
                if (Trips_system.get(i).getDestination().equals(destination) &&
                        Trips_system.get(i).getTripType().equals(tourType)) {
                    suitableTrip.add(Trips_system.get(i));
                    System.out.print((i + 1) + ". ");
                    Trips_system.get(i).displayDetails();
                }
            }
            System.out.println("Enter the suitable number: ");
            in = input(1, suitableTrip.size()) - 1;
        } catch (NullPointerException e) {
            System.out.println("No trip was found! " + e.getMessage());
        } finally {
            return in; //1-based --> 0-based
        }
    }


    public boolean isTripFound(Trip t1, ArrayList<Trip>Trips_system) {
        for (Trip t2 : Trips_system) {
            if (compare(t1, t2))
                return true;
        }
        return false;
    }

    public int editTicket( ArrayList<Trip>Trips_system) {
        do {
            // Ticket.displayAllTicketsForCustomer(tickets);
            viewBookedAllTicket();
            System.out.println("Enter the number of the ticket you want to edit: ");
            int indexOfTicket = input(1, tickets.size()) - 1;
            System.out.println("What do you want edit ? ");
            System.out.println("1. Trip / 2. Activity / 3. Hotels / 4. Car Rentals / 5. Flights");
            switch (input(1, 5)) {
                case 1:
                    editTrip(indexOfTicket, Trips_system);
                    break;
                case 2:
                    System.out.println("Enter the new Activity Type: ");
                    String newActivityType = in.next();
                    displayActivities(tickets.get(indexOfTicket).getTrip().getTripType(),/* newActivityType,*/ indexOfTicket);
                    break;
                case 3: // editHotel
                    Ticket.customerEditHotelBooking(tickets.get(indexOfTicket));
                    break;
                case 4: // editCar
                    tickets.get(indexOfTicket).EditCarRental();
                    break;
                case 5: // editFlight
                    tickets.get(indexOfTicket).EditBookingForFlight();
                    break;
            }
            System.out.println("Do you want to edit another ticket (y,n)?");
        } while (confirm(in.next().charAt(0)));
        System.out.println("       1. Home page \n       2. Exit");
        return (input(1, 2) == 1 ? -1 : 0);
    }

    public void editTrip(int indexOfTicket, ArrayList<Trip>Trips_system) {
        // type / destination / numOfSeats(cancel / date(yes , no)
        //if(tickets.get(indexOfTicket).getTourType().equals(" "))
        Trip t = tickets.get(indexOfTicket).getTrip();
        do {
            System.out.println("What do you want to edit:");
            System.out.println("1. Type of Trip \n 2. Destination \n 3. Number of Seats \n 4. Date");
            switch (input(1, 4)) {
                case 1:
                    System.out.println("Enter the new trip type: ");
                    String newType = in.next();
                    t.setTripType(newType);
                    if (isTripFound(t, Trips_system)) {
                        System.out.println("the trip type has been updated successfully!");
                        tickets.get(indexOfTicket).getTrip().setTripType(newType); //save edit
                    } else {
                        System.out.println("no trips were found by the new trip type you wanted!");
                    }

                    break;
                case 2:
                    System.out.println("Enter the new Destination: ");
                    String newDestination = in.next();
                    t.setDestination(newDestination);
                    if (isTripFound(t,Trips_system)) {
                        System.out.println("the trip destination has been updated successfully!");
                        tickets.get(indexOfTicket).getTrip().setTripType(newDestination); //save edit
                    } else {
                        System.out.println("no trips were found by the new destination you wanted!");
                    }
                    //save
                    break;
                case 3: // num of seats
                    do {
                        System.out.println("Enter the new number of seats: ");
                        int newNumOfSeats = in.nextInt();
                        if (newNumOfSeats < tickets.get(indexOfTicket).getNumberOfSeats()) {
                            tickets.get(indexOfTicket).getTrip().setAvailableSeats(tickets.get(indexOfTicket).getTrip().getAvailableSeats() + (tickets.get(indexOfTicket).getNumberOfSeats() - newNumOfSeats));
                            tickets.get(indexOfTicket).setNumberOfSeats(newNumOfSeats);
                            System.out.println("The number of seats has been updated successfully");
                        } else if (newNumOfSeats > tickets.get(indexOfTicket).getNumberOfSeats()) {
                            if (newNumOfSeats <= tickets.get(indexOfTicket).getTrip().getAvailableSeats()) {
                                tickets.get(indexOfTicket).getTrip().setAvailableSeats(tickets.get(indexOfTicket).getTrip().getAvailableSeats() - newNumOfSeats);
                                tickets.get(indexOfTicket).setNumberOfSeats(newNumOfSeats);
                                System.out.println("The number of seats has been updated successfully");
                            } else {
                                System.out.println("No seats are available");
                                System.out.println("The number of available seats: " + tickets.get(indexOfTicket).getTrip().getAvailableSeats());
                            }
                        } else {
                            System.out.println("are you serious !");
                        }

                        System.out.println("Do you want to enter another number of seats(y ,n)?");
                    } while (confirm(in.next().charAt(0)));
                    break;
                case 4: // Date
                    LocalDate newDate = inputDate();
                    t.setStartDate(newDate.toString());
                    if (isTripFound(t,Trips_system)) {
                        System.out.println("the trip date has been updated successfully!");
                        tickets.get(indexOfTicket).getTrip().setTripType(newDate.toString()); //save edit
                    } else
                        System.out.println("no trips were found by the new date you wanted!");
                    break;
            }
            System.out.println("Do you want to continue editing(y,n)?");
        } while (confirm(in.next().charAt(0)));
    }


    public String dayDisplay() {
        String days[] = {"SATURDAY", "SUNDAY", "MONDAY", "TUESDAY","WEDNESDAY", "THURSDAY", "FRIDAY"};
        for (int i = 0; i < 7; i++) {
            System.out.println((i + 1) + ". " + days[i]);
        }
        return days[input(1, 7) - 1];
    }

    public LocalDate inputDate() {
        int month_value[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        LocalDate currentDate = LocalDate.now();
        int DAY = currentDate.getDayOfMonth();
        int MONTH = currentDate.getMonthValue();
        int YEAR = currentDate.getYear();

        int year, month, day;
        System.out.println("Enter the suitable year : ");
        year = input(YEAR, 2050);
        //leap_year
        if ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0)) month_value[1] = 29;
        else month_value[1] = 28;

        System.out.println("Enter the suitable month : ");
        if (year == YEAR) {
            month = input(MONTH, 12);
            System.out.println("Enter the suitable day : ");
            if (month == MONTH) {
                day = input(DAY, month_value[month - 1]);//0-based
            } else {
                day = input(1, month_value[month - 1]); //0-based
            }
        } else {
            month = input(1, 12);
            System.out.println("Enter the suitable day : ");
            day = input(1, month_value[month - 1]);
        }
        LocalDate date = LocalDate.of(year, month, day); // 01 / 02
        //String date = year + "-" + month + "-" + day;
        return date;
    }

    public String destinationDisplay() { ////////check destination
        String Destinations[] = {"London", "korea", "japan", "Italy" , "France", "Canada"}; //10
        for (int i = 0; i < 6; i++) {
            System.out.println((i + 1) + ". " + Destinations[i]);
        }
        return Destinations[input(1, 6) - 1]; // 0-based
    }

    public LocalDate calender_date(String day_name) {
        String days[] = {"SATURDAY", "SUNDAY", "MONDAY", "TUESDAY",
                "WEDNESDAY", "THURSDAY", "FRIDAY"};
        int month_value[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        LocalDate DATE;
        LocalDate currentDate = LocalDate.now();
        int DAY = currentDate.getDayOfMonth();
        int MONTH = currentDate.getMonthValue();
        int YEAR = currentDate.getYear();
        DayOfWeek  dayOfWeek =  currentDate.getDayOfWeek();
        int w__day = 0;
        for (int i = 0; i < 7; i++) {
            if (days[i].equals(dayOfWeek.toString())) {
                w__day = i + 1;
                break;
            }
        }
        // leap_year
        if ((YEAR % 4 == 0) && (YEAR % 100 != 0) || (YEAR % 400 == 0)) month_value[1] = 29;
        else month_value[1] = 28; // Leap Year
        //////

        //w_day
        int w_day = 0;
        for (int i = 0; i < 7; i++) {
            if (days[i].equals(day_name)) {
                w_day = i + 1;
                break;
            }
        }
        ///////

        if (w_day >= (w__day))
            DAY += (w_day - (w__day));
        else
            DAY += (7 - (w__day)) + w_day;
        if (DAY > month_value[MONTH - 1]) {
            DAY %= month_value[MONTH - 1];
            MONTH = (MONTH) + 1;
            if (MONTH > 12) {
                YEAR++;
                MONTH %= 12;
            }
        }
        //int to string
        LocalDate date = LocalDate.of(YEAR, MONTH, DAY); // 01 / 02
        return date;
    }

    public int canceling(){

        try {
            //expiredTicket();
            if (tickets.isEmpty())
                System.out.println("you haven't booked any tickets yet");
            else {
                for (int i = 0; i < tickets.size(); i++) {
                    System.out.println(i+1 + ".");
                    tickets.get(i).ticketDetails();
                }
            }
        }catch (NullPointerException e) {
            System.out.println("No tickets are available to cancel!" + e.getMessage());
        }
        System.out.println("Enter the number of the ticket you want: ");
        int index = input(1, tickets.size()) - 1;
        System.out.println("What do you want to delete");
        System.out.println("    1. Ticket   2. Activity   3. Flight    4. car rental    5. Hotel ");
        do{
            try {
                switch (input(1, 4)) {
                    case 1: // delete the whole ticket
                        //cancel for all services

                       // tickets.get(index).CancelTicket();
                        tickets.remove(index);
                        break;
                    case 2: // delete activity
                        delete_travel_itinerary_By_Name(index);
                        break;
                    case 3: // delete flight
                        tickets.get(index).CancelBookingForFlight();
                        break;
                    case 4:// delete car rental
                        tickets.get(index).cancelRentedCar();
                        break;
                    case 5:// delete hotel
                        Ticket.customerCancelHotelBooking(tickets.get(index));
                        break;
                }
            }catch (NullPointerException e) {
                System.out.println(e.getMessage());
            }
            System.out.println("Do you want to cancel anything else ?");
        }while(confirm(in.next().charAt(0)));

        System.out.println("       1. Home page \n       2. Exit");
        return (input(1, 2) == 1 ? -1 : 0);
    }

    public int viewBookedAllTicket() {
        expiredTicket();
        if (tickets.isEmpty())
            System.out.println("you haven't booked any tickets yet");
        else {
            for (int i = 0; i < tickets.size(); i++) {
                tickets.get(i).ticketDetails();
            }
        }
        System.out.println("       1. Home page \n       2. Exit");
        return (input(1, 2) == 1 ? -1 : 0);
    }

    public void expiredTicket() {
        LocalDate currentDate = LocalDate.now();
        for (Ticket t : tickets) {
            if (t.getTrip().getEndDate().equals(currentDate)) {
                tickets.remove(t);
            }
        }
    }


    //check trip , discount , viewTravelServices
    public boolean maxBooking() //added
    {
        if (totaltrips <= 10) {
            totaltrips++;
            return true;
        }
        else {
            System.out.println("you reached the maximum number of trips reservation");
            return false;
        }

    }

    public boolean CheckDiscount_tickect(ArrayList<Trip> trip) {//added
        long uniquedestinationcount = trip.stream()
                .map(Trip::getDestination)//is used to extract the destination from trip array
                .distinct()
                .count();
        return uniquedestinationcount > 2;
    }

    public int viewTravelServices(ArrayList<Trip> Trips_system) {
        boolean hasDiscount = CheckDiscount_tickect(Trips_system);
        if (hasDiscount) {
            System.out.println("congratulation you have a discount ");
            Voucher v = new Voucher();
            vouchers.add(v); //added a new voucher to customer array
            v.DisplayInfo();
        } else
            System.out.println("you don't have a discount yet ");

        System.out.println("       1. Home page \n       2. Exit");
        return (input(1, 2) == 1 ? -1 : 0);
    }

    //rating
    public void feedback(ArrayList<Trip> Trips_system) {
        LocalDate currentDate = LocalDate.now();

        for (Ticket t : tickets) {
            if (t.getTrip().getEndDate().equals(currentDate)) {
                System.out.println("Enter your feedback : ");
                feedback.add(in.next());
                inputRate(Trips_system);
                return;
            }
        }

    }

    public void displayRating(int avgRate) {
        for (int i = 1; i <= avgRate; i++) {

            System.out.println(ANSI_COLORS[5] + "* ");

        }
        System.out.println(ANSI_COLORS[0] + " \n");
    }

    public void inputRate(ArrayList<Trip> Trips_system) {
        LocalDate currentDate = LocalDate.now();

        for (Trip t : Trips_system) {
            if (t.getEndDate().equals(currentDate)) {
                System.out.println("Enter rate : ");
                int avg = t.getAvgRate(); //set first to zero
                avg *= (t.getRate().size() - 1);
                int customerRate = input(1, 5);
                t.setRate(customerRate);
                avg += customerRate;
                avg /= t.getRate().size() - 1;
                t.setAvgRate(avg);
                displayRating(avg);
                return;
            }
        }
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

    public static final String[] ANSI_COLORS = {
            "\u001B[0m",    // Reset     0
            "\u001B[30m",   // Black     1
            "\u001B[31m",   // Red       2
            "\u001B[32m",   // Green     3
            "\u001B[33m",   // Yellow    4
            "\u001B[34m",   // Blue      5
            "\u001B[35m",   // Purple    6
            "\u001B[36m",   // Cyan      7
            "\u001B[37m",   // White     8
            "\u001B[90m",   // Dark Gray 9
            "\u001B[91m",   // Bright Red      10
            "\u001B[92m",   // Bright Green    11
            "\u001B[93m",   // Bright Yellow   12
            "\u001B[94m",   // Bright Blue     13
            "\u001B[95m",   // Bright Purple   14
            "\u001B[96m",   // Bright Cyan     15
            "\u001B[97m"    // Bright White    16
    };
}