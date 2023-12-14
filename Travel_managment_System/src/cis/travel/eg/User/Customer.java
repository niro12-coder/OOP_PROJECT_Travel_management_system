package cis.travel.eg.User;

import java.io.Serializable;
import java.time.LocalDate;

import cis.travel.eg.Main.Main;
import cis.travel.eg.Main.Ticket;
import cis.travel.eg.Main.Voucher;
import cis.travel.eg.Trip.Trip;

import java.util.ArrayList;
import java.util.stream.IntStream;

import cis.travel.eg.Service.Activity;
import cis.travel.eg.User.TourGuideDetails.TourGuide;

import static cis.travel.eg.Main.Main.in;
import static cis.travel.eg.Main.Main.input;


public class Customer extends User implements Serializable {
    private String confiremedpass;
    private String country; //register
    private String preferedcurrency; //register
    private String preferedlanguage; //register
    private String preferedpayment; //register
    private int totaltrips;
    private ArrayList<Ticket> tickets = new ArrayList<>();
    private ArrayList<Voucher> vouchers = new ArrayList<>();
    private ArrayList<Activity> savedActivities = new ArrayList<>();
    private ArrayList<Activity> allActivities = new ArrayList<>();
    private ArrayList<Activity> familyActivities = new ArrayList<>();
    private ArrayList<Activity> coupleActivities = new ArrayList<>();
    private ArrayList<Activity> generalActivities = new ArrayList<>();
    private ArrayList<Trip> trip = new ArrayList<>();
    private ArrayList<String> feedback = new ArrayList<String>();
    private ArrayList<Trip> suitableTrip = new ArrayList<Trip>(); // saved for the customer


    public Customer() { //if admin make a new account and want to copy details?

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


    public boolean compare(Trip t1, Trip t2) {

        return t1.getTripType().equals(t2.getTripType()) && t1.getStartDate().equals(t2.getStartDate())
                && t1.getEndDate().equals(t2.getEndDate()) && t1.getAvailableSeats() == t2.getAvailableSeats()
                && t1.getPricePerSeat() == t2.getPricePerSeat() && t1.getDestination().equals(t2.getDestination());
    }

    public void setVouchers(ArrayList<Voucher> vouchers) {
        this.vouchers = vouchers;
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
            System.out.println("Do you want to make another change(y,n)?");
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

        System.out.println("       1. Edit your Profile \n       2. Home page \n       3. Exit");
        int choice = in.nextInt();
        if (choice == 1) return Edit_Profile(admin, customer, manager, tourguide);
        else return (choice == 2 ? 1 : 0);

    }

    public boolean HomePage(ArrayList<Admin> Admins, ArrayList<Customer> Customers, ArrayList<TourGuide> TourGuides, ArrayList<Manager> Managers, ArrayList<Trip> Trips_system) {
        int Case;
        do {

            System.out.println("\t\t__ Welcome _");
            System.out.println("\t\t [0] Exit ");
            System.out.println("\t\t 1) My Profile");
            System.out.println("\t\t 2) book a ticket");
            System.out.println("\t\t 3) view booked tickets");
            System.out.println("\t\t 4) cancel booking");
            System.out.println("\t\t 5) edit travel");
            System.out.println("\t\t 6) view travel services");
            System.out.println("\t\t 7) Feedback and Rating");
            System.out.println("\t\t8) log out ");

            feedback();
            Case = input(0, 9);
            while (Case > 0 && Case < 8) {

                switch (Case) {
                    case 1:
                        Case = Display_Profile(Admins, Customers, Managers, TourGuides);
                        break;
                    case 2:
                        Case = bookTicket();
                        break;
                    case 3:
                       // Case = viewBookedTicket(); // nouran
                        break;
                    case 4:
                        cancelTicket();
                        System.out.println(" 1. HomePage \n 2. Exit");
                        Case = (input(1, 2) == 1 ? -1 : 0);
                        break;
                    case 5:
                        Case = editTicket();
                        break;
                    case 6:
                        Case = viewTravelServices();
                        break;
                    case 7:
                        feedback();
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
  
  ///////////////////MANAGER CODE////////////////////////////////////////////////

//    public void bookHotelRoom(Ticket ticket, boolean editHotel) {
//        helpingMethods methods = new helpingMethods(); //make it static
//
//        ArrayList<hotelReservation> availableHotels = new ArrayList<>();
//        // filtering hotels for the customer
//        int avaHotels = hotelReservation.hotelsFiltrationForBooking(availableHotels, ticket);
//        int hotelChoice = -1;
//        if (avaHotels == 0) {
//            System.out.println("No available hotels right now");
//            return;
//        } else {
//            // customer choose the suitable hotel
//            hotelChoice = hotelReservation.customerChooseHotel(availableHotels, ticket);
//            // customer customizes the food board according to his needs
//            hotelReservation.customerChooseFoodBoard(availableHotels.get(hotelChoice - 1), ticket);
//        }
//        ///////////////// BOOKING CONFIRMATION ////////////////////////////
//        System.out.println(" Choosing details has ended successfully");
//        System.out.println(" Here is your booking details");
//        availableHotels.get(hotelChoice - 1).displayHotelForBooking(-1, ticket.getNumberOfSeats() > 2, ticket.getNumberOfSeats() , true);
//        System.out.println(" Do you want to confirm? (Y/N)");
//        if (confirm(in.next().charAt(0))) {
//            if (editHotel) {
//                hotelReservation.deleteHotelReservation(ticket);
//            }
//            ticket.hotelReservation = true;
//            ticket.Hotel = availableHotels.get(hotelChoice - 1);
//            ticket.price += availableHotels.get(hotelChoice - 1).totalPayments;
//            System.out.println("_____________________________________________");
//            System.out.println("     PROCESS HAS BEEN MADE SUCCESSFULLY");
//            System.out.println("_____________________________________________");
//            hotelReservation.saveHotelReservationForAgency(ticket);
//        } else {
//            System.out.println("Nothing changed in the ticket, thank you!\n");
//        }
//        }
//
//      ///////////////// BOOKING CONFIRMATION END STAGE ////////////////////////////
//    public void customerEditHotelBooking(Ticket ticket) {
//
//        System.out.println("Are you sure you want to edit hotel booking ? (y/n) \n note that: You will choose the hotel from the beginning and your current booking will be cancelled.\n");
//        if (confirm(in.next().charAt(0))) {
//            bookHotelRoom(ticket, true);
//        } else {
//            System.out.println("You will be directed to home page\n");
//            //customer will be directed to the page where he chose to edit hotel
//        }
//    }
//    public void customerCancelHotelBooking(Ticket Ticket) {
//        System.out.println("Are you sure you want to cancel this hotel booking ? (y/n)\n");
//        if (confirm(in.next().charAt(0))) {
//            hotelReservation.deleteHotelReservation(Ticket);
//        } else {
//            System.out.println("Nothing cancelled,thank you!\n");
//        }
//    }
//    public void displayTicketsForCustomer(){
//        System.out.println(" 1. All tickets\n 2. Last ticket booked");
//        switch (helpingMethods.choice(1,2)){
//            case 1:
//                int counter=0;
//                System.out.println(" >> Your booked tickets <<");
//                System.out.println(" ");
//                System.out.println(" =====================================");
//                for(Ticket ticket : tickets){
//                    counter++;
//                    System.out.println(" >> Ticket "+counter );
//                    System.out.println(" - - - - - - - - - - - - - - - - - - -");
//                    ticket.ticketDetails(false);
//                    System.out.println(" =====================================");
//                }
//                System.out.println(" For displaying whole ticket details, you will choose the ticket you want then.");
//                System.out.println(" 1. Choose ticket to display\n 2. Go to homepage");
//                switch(helpingMethods.choice(1,2)){
//                    case 1:
//                        System.out.println(" Enter number of ticket");
//                        int choice =helpingMethods.choice(1,tickets.size())-1;
//                        tickets.get(choice).ticketDetails(true);
//                        //display trip booked
//                        //display activities if exist
//                        if(tickets.get(choice).isRentCar()){}//display car details
//                        if(tickets.get(choice).hotelReservation) {
//                            tickets.get(choice).Hotel.displayHotelForBooking( 0 , tickets.get(choice).numberOfSeats > 2,tickets.get(choice).numberOfSeats, true);
//                        }
//                        if(tickets.get(choice).OneWayFlight){}
//                        else if (tickets.get(choice).RoundFlight) {} //display  flight
//                        break;
//                    case 2: // return to homepage
//                        break;
//                }
//                break;
//            case 2:
//                System.out.println(" >> Your last booked ticket <<");
//                System.out.println(" ");
//                System.out.println(" =====================================");
//                tickets.get(tickets.size()-1).ticketDetails(true);
//                System.out.println(" =====================================");
//                System.out.println("           >> Services <<");
//                //display trip booked
//                //display activities if exist
//                if(tickets.get(tickets.size()-1).isRentCar()){}//display car details
//                if(tickets.get(tickets.size()-1).hotelReservation) {
//                    tickets.get(tickets.size()-1).Hotel.displayHotelForBooking( 0 , tickets.get(tickets.size()-1).numberOfSeats > 2,tickets.get(tickets.size()-1).numberOfSeats, true);
//                }
//                if(tickets.get(tickets.size()-1).OneWayFlight){}
//                else if (tickets.get(tickets.size()-1).RoundFlight) {} //display  flight
//                break;
//        }
//    }
//}

///////////////////////////////////////////////////////////////////////


    public void displayActivities(String tripType, String ticketType) { //by tripType & ticketType
        System.out.println("Activities suitable for " + tripType + " trip:");
        ArrayList<Activity> activities = null;
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

        try {
            for (Activity activity : activities) {
                if (activity != null && activity.getTicketType().equals(ticketType)) {
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
    }

    public void displayActivities(String tripType, String ticketType, String activityType) {  //by tripType & ticketType & activityType
        ArrayList<Activity> activities = null;
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
        try {
            for (Activity activity : activities) {
                if (activity != null && activity.getTicketType().equals(ticketType) && activity.getActivityType().equals(activityType)) {
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

            System.out.println("Do you want to edit another Activity(Y,N)?");

        } while (confirm(in.next().charAt(0)));

    }


    public void delete_travel_itinerary_By_Name(String activityName, ArrayList<Activity> activities) {
        String option;
        do {
            try {
                System.out.println("Write the name of the Activity you want to remove: ");
                for (Activity activity : savedActivities) {
                    if (activity.getName().equalsIgnoreCase(activityName)) {
                        activities.remove(activity);
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


    public int bookTicket() {
        maxBooking();

        tickets.add(new Ticket());
        bookTrip();      // indexOfTrip --> suitableTrip , date, type_trip, destination , numOfSeats
        System.out.println("What type of ticket do you want to book?");
        System.out.println("1. Silver ticket \n2. Golden ticket\n3. Platinum ticket ");

        switch (input(1, 3)) {
            case 1:
                tickets.get(tickets.size() - 1).setTicketType("Silver");
                break;
            case 2:
                tickets.get(tickets.size() - 1).setTicketType("Golden");
                break;
            case 3:
                tickets.get(tickets.size() - 1).setTicketType("Platinum");
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
            switch (assignToTicket) {
                case 1: //book activities function
                    System.out.println("Now, Choose the Activity you want: ");
                    displayActivities(tickets.get(tickets.size() - 1).trip.getTripType(), tickets.get(tickets.size() - 1).getTicketType()); // savedActivities
                    break;
                case 2: //book a flight function
                    break;
                case 3: //rent car function
                    break;
                case 4:
                    //customer.bookHotelRoom(ticket, false);
                    break;
                case 5:
                    finish = true;
                    break;
            }

            if (!finish) {
                System.out.println("Service is added to your ticket successfully");
                System.out.println("Do you want to assign another service to your ticket(Y,N)?");
            } else
                break;

        } while (confirm(in.next().charAt(0)));

        System.out.println(" Do you want to confirm this ticket?");
        if (confirm(in.next().charAt(0))) {
            tickets.get(tickets.size() - 1).setCustomerLocation(country);
            tickets.get(tickets.size() - 1).setConfirmationNumber(tickets.get(tickets.size() - 1).getConfirmationNumber() + tickets.get(tickets.size() - 1).trip.getTripID());
            System.out.println(" Ticket is added to your bookings successfully!");
            //saved activity in ticket
            //displayTicket and send an email
        } else {
            tickets.remove(tickets.size() - 1);
            System.out.println(" Ticket not saved.");
            System.out.println(" you will be directed to the home page now.");
        }

        System.out.println("       1. Home page \n       2. Exit");
        return (input(1, 2) == 1 ? -1 : 0);
    }

    public void bookTrip() {
        int indexOfTrip;
        LocalDate dateOfTrip;
        System.out.println("what is your destination ?");
        String destination = in.next();  //  String destination = destinationDisplay();
        System.out.println("  which tour type do you want ?");
        System.out.println("  1. couple tour \n 2.family tour \n 3. general tour ");
        String TourType = null;
        switch (input(1, 3)) {
            case 1:

                int counter=0;
                System.out.println(" >> Your booked tickets <<");
                System.out.println(" ");
                System.out.println(" =====================================");
                for(Ticket ticket : tickets){
                    counter++;
                    System.out.println(" >> Ticket "+counter );
                    System.out.println(" - - - - - - - - - - - - - - - - - - -");
                    ticket.ticketDetails(false);
                    System.out.println(" =====================================");
                }
                System.out.println(" For displaying whole ticket details, you will choose the ticket you want then.");
                System.out.println(" 1. Choose ticket to display\n 2. Go to homepage");
                switch(helpingMethods.choice(1,2)){
                    case 1:
                        System.out.println(" Enter number of ticket");
                        int choice =helpingMethods.choice(1,tickets.size())-1;
                        tickets.get(choice).ticketDetails(true);
                        //display trip booked
                        //display activities if exist
                        if(tickets.get(choice).isRentCar()){}//display car details
                        if(tickets.get(choice).hotelReservation) {
                            tickets.get(choice).Hotel.displayHotelForBooking( 0 , tickets.get(choice).numberOfSeats > 2,tickets.get(choice).numberOfSeats, true);
                        }
                        if(tickets.get(choice).OneWayFlightGoing||tickets.get(choice).OneWayFlightReturn){}
                        else if (tickets.get(choice).RoundFlight) {} //display  flight
                        break;
                    case 2: // return to homepage
                        break;
                }
                break;
            case 2:
                System.out.println(" >> Your last booked ticket <<");
                System.out.println(" ");
                System.out.println(" =====================================");
                tickets.get(tickets.size()-1).ticketDetails(true);
                System.out.println(" =====================================");
                System.out.println("           >> Services <<");
                //display trip booked
                //display activities if exist
                if(tickets.get(tickets.size()-1).isRentCar()){}//display car details
                if(tickets.get(tickets.size()-1).hotelReservation) {
                    tickets.get(tickets.size()-1).Hotel.displayHotelForBooking( 0 , tickets.get(tickets.size()-1).numberOfSeats > 2,tickets.get(tickets.size()-1).numberOfSeats, true);
                }
                if(tickets.get(tickets.size()-1).OneWayFlightGoing||tickets.get(tickets.size()-1).OneWayFlightReturn){}
                else if (tickets.get(tickets.size()-1).RoundFlight) {} //display  flight

                break;
        }

        System.out.println("Do you want choose by a certain time ? (y/n)");
        String choice = in.next();
        if (confirm(in.next().charAt(0))) {
            System.out.println(" 1. Day \n 2. Date");
            if (input(1, 2) == 1) {
                String dayName = dayDisplay();
                dateOfTrip = calender_date(dayName);
            } else {
                dateOfTrip = inputDate();
            }
            indexOfTrip = displayTrip(dateOfTrip, destination, TourType);  // after display trips by filters , // Enter the suitable number : , return input(a, b)}
        } else {
            indexOfTrip = displayTrip(destination, TourType);
        }

        //save in ticket
        tickets.get(tickets.size() - 1).trip = suitableTrip.get(indexOfTrip);

        System.out.println("Now, Enter the suitable number of seats : ");
        tickets.get(tickets.size() - 1).setNumberOfSeats(input(1, tickets.get(tickets.size() - 1).trip.getAvailableSeats()));
    }

    public int displayTrip(LocalDate date, String destination, String tripType) { // by date , destination, tourType
        int count = 0;
        try {
            IntStream.range(0, trip.size())
                    .filter(i -> LocalDate.parse(trip.get(i).getStartDate()).equals(date) && trip.get(i).getDestination().equals(destination))
                    .forEach(i -> {
                        suitableTrip.add(trip.get(i));
                        System.out.print((i + 1) + ". ");
                        trip.get(i).displayDetails();
                    });
            System.out.println("Enter the suitable number : ");
        } catch (NullPointerException e) {
            System.out.println("No trip was found! " + e.getMessage());
        } finally {
            return input(1, suitableTrip.size() + 1) - 1; //1-based
        }
    }


    public int displayTrip(String destination, String tourType) { //by destination and tourType
        int count = 0;
        try {
            IntStream.range(0, trip.size())
                    .filter(i -> trip.get(i).getDestination().equals(destination) && trip.get(i).getTripType().equals(tourType))
                    .forEach(i -> {
                        suitableTrip.add(trip.get(i));
                        System.out.print((i + 1) + ". ");
                        trip.get(i).displayDetails();
                    });
            System.out.println("Enter the suitable number : ");
            return input(1, suitableTrip.size() + 1) - 1; //1-based
        } catch (NullPointerException e) {
            System.out.println("No trip was found! " + e.getMessage());
        } finally {
            return input(1, suitableTrip.size() + 1) - 1; //1-based
        }
    }


    public boolean isTripFound(Trip t1) {
        for (Trip t2 : trip) {
            if (compare(t1, t2))
                return true;
        }
        return false;
    }


    public int displayTrip(Trip t, String destination) { // by Destination only
        int count = 0;
        try {
            IntStream.range(0, trip.size())
                    .filter(i -> trip.get(i).getStartDate().equals(t.getStartDate()) && trip.get(i).getTripType().equals(t.getTripType())  && trip.get(i).getDestination().equals(destination) && trip.get(i).getAvailableSeats() == t.getAvailableSeats())
                    .forEach(i -> {
                        suitableTrip.add(trip.get(i));
                        System.out.print((i + 1) + ". ");
                        trip.get(i).displayDetails();
                    });
            System.out.println("Enter the suitable number : ");
        }
        catch (NullPointerException e){
            System.out.println("No trip was found! " + e.getMessage());
        }
        finally {
            return input(1, suitableTrip.size() + 1) - 1; //1-based
        }
    }
    public int displayTrip(LocalDate date,Trip t) { // by date only
        int count = 0;
        try {
            IntStream.range(0, trip.size())
                    .filter(i -> LocalDate.parse(trip.get(i).getStartDate()).equals(date) && trip.get(i).getTripType().equals(t.getTripType())  && trip.get(i).getDestination().equals(t.getDestination()) && trip.get(i).getAvailableSeats() ==t.getAvailableSeats())
                    .forEach(i -> {
                        suitableTrip.add(trip.get(i));
                        System.out.print((i + 1) + ". ");
                        trip.get(i).displayDetails();
                    });
            System.out.println("Enter the suitable number : ");
        }
        catch (NullPointerException e){
            System.out.println("No trip was found! " + e.getMessage());
        }
        finally {
            return input(1, suitableTrip.size() + 1) - 1; //1-based
        }
    }


    public int editTicket() {
        do {
            viewBookedAllTicket();
            System.out.println("Enter the number of the ticket you want to edit: ");
            int indexOfTicket = input(1, tickets.size()) - 1;
            System.out.println("What do you want edit ? ");
            System.out.println("1. Trip / 2. Activity / 3. Hotels / 4. Car Rentals / 5. Flights");
            switch (input(1, 5)) {
                case 1:
                    editTrip(indexOfTicket);
                    break;
                case 2:
                    System.out.println("Enter the new Activity Type: ");
                    String newActivityType = in.next();
                    displayActivities(tickets.get(indexOfTicket).trip.getTripType(), tickets.get(indexOfTicket).getTicketType(), newActivityType);
                    //saved activity in ticket
                    break;
                case 3: // editHotel
                    break;
                case 4: // editCar
                    break;
                case 5: // editFlight
                    break;
            }
            System.out.println("Do you want to edit another ticket (y,n)?");
        }while(confirm(in.next().charAt(0)));
        System.out.println("       1. Home page \n       2. Exit");
        return (input(1, 2) == 1 ? -1 : 0);
    }

    public void editTrip(int indexOfTicket) {
        // type / destination / numOfSeats(cancel / date(yes , no)
        Trip t = tickets.get(indexOfTicket).trip;
        do {
            System.out.println("What do you want to edit:");
            System.out.println("1. Type of Trip \n 2. Destination \n 3. Number of Seats \n 4. Date");
            switch (input(1, 4)) {
                case 1:
                    System.out.println("Enter the new trip type: ");
                    String newType = in.next();
                    t.setTripType(newType);
                    if (isTripFound(t)) {
                        System.out.println("the trip type has been updated successfully!");
                        tickets.get(indexOfTicket).trip.setTripType(newType); //save edit
                    } else {
                        System.out.println("no trips were found by the new trip type you wanted!");
                    }

                    break;
                case 2:
                    System.out.println("Enter the new Destination: ");
                    String newDestination = in.next();
                    t.setDestination(newDestination);
                    if (isTripFound(t)) {
                        System.out.println("the trip destination has been updated successfully!");
                        tickets.get(indexOfTicket).trip.setTripType(newDestination); //save edit
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
                            tickets.get(indexOfTicket).trip.setAvailableSeats(tickets.get(indexOfTicket).trip.getAvailableSeats() + (tickets.get(indexOfTicket).getNumberOfSeats() - newNumOfSeats));
                            tickets.get(indexOfTicket).setNumberOfSeats(newNumOfSeats);
                            System.out.println("The number of seats has been updated successfully");
                        } else if (newNumOfSeats > tickets.get(indexOfTicket).getNumberOfSeats()) {
                            if (newNumOfSeats <= tickets.get(indexOfTicket).trip.getAvailableSeats()) {
                                tickets.get(indexOfTicket).trip.setAvailableSeats(tickets.get(indexOfTicket).trip.getAvailableSeats() - newNumOfSeats);
                                tickets.get(indexOfTicket).setNumberOfSeats(newNumOfSeats);
                                System.out.println("The number of seats has been updated successfully");
                            } else {
                                System.out.println("No seats are available");
                                System.out.println("The number of available seats: " + tickets.get(indexOfTicket).trip.getAvailableSeats());
                                System.out.println("Do you want to enter another number of seats(y ,n)?");
                            }
                        } else {
                            System.out.println("are you serious !");
                        }
                    } while (confirm(in.next().charAt(0)));
                    break;
                case 4: // Date
                    LocalDate newDate = inputDate();
                    t.setStartDate(newDate.toString());
                    if (isTripFound(t)) {
                        System.out.println("the trip date has been updated successfully!");
                        tickets.get(indexOfTicket).trip.setTripType(newDate.toString()); //save edit
                    } else
                        System.out.println("no trips were found by the new date you wanted!");
                    break;
            }
            System.out.println("Do you want to continue editing(y,n)?");
        } while(confirm(in.next().charAt(0)));
    }

    public void editActivity() {

    }

    public String dayDisplay() {
        String days[] = {"Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
        for (int i = 0; i < 10; i++) {
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
        String Destinations[] = {" ", " ", " "}; //10
        for (int i = 0; i < 10; i++) {
            System.out.println((i + 1) + ". " + Destinations[i]);
        }
        return Destinations[input(1, 10) - 1]; // 0-based
    }

    public LocalDate calender_date(String day_name) {
        String days[] = {"Saturday", "Sunday", "Monday", "Tuesday",
                "Wednesday", "Thursday", "Friday"};
        int month_value[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        LocalDate DATE;
        LocalDate currentDate = LocalDate.now();
        int DAY = currentDate.getDayOfMonth();
        int MONTH = currentDate.getMonthValue();
        int YEAR = currentDate.getYear();

        int w__day = 2; // ?!!
//        for (int i = 0; i < 7; i++) {
//            if (days[i].equals(day_name)) {
//                w__day = i + 1;
//                break;
//            }
//        }
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
        w__day = w_day;
        //int to string
        LocalDate date = LocalDate.of(YEAR, MONTH, DAY); // 01 / 02
        return date;
    }

    public int viewTravelServices() {
        boolean hasDiscount = CheckDiscount_tickect(trip);
        if (hasDiscount) {
            System.out.println("congratulation you have a discount ");
            Voucher v = new Voucher();
            vouchers.add(v); //added a new voucher to customer array
           // v.DisplayInfo();//private fe voucher // nouran
        } else
            System.out.println("you don't have a discount yet ");

        System.out.println("       1. Home page \n       2. Exit");
        return (input(1, 2) == 1 ? -1 : 0);
    }

    public void cancelTicket() { // cancel ticket

        viewBookedAllTicket();
        System.out.println("Enter the number of the ticket you want cancel : ");
        tickets.remove((input(1, tickets.size())) - 1);
        viewBookedAllTicket();
        System.out.println("Do you want to cancel another ticket ?");
        if(confirm(in.next().charAt(0)))
            cancelTicket();
    }

    public int viewBookedAllTicket() {  //team ticket

        expiredTicket();
        if (tickets.isEmpty())
            System.out.println("you haven't booked any tickets yet");
        else {

            for (int i = 0; i < tickets.size(); i++){
                System.out.println( i + 1 +".  ");
                System.out.println("   your trip name : " + tickets.get(i).trip.getTripName());
                System.out.println("   your trip type: " + tickets.get(i).trip.getTripType());
                System.out.println("   Trip destination: " + tickets.get(i).trip.getDestination());
                System.out.println("   trip ends on day: ");
                System.out.println(tickets.get(i).trip.getEndDate());
                System.out.println("   trip description:  " + tickets.get(i).trip.getDescription());
                //System.out.println("" + t.);

            }
        }
        System.out.println("       1. Home page \n       2. Exit");
        return (input(1, 2) == 1 ? -1 : 0);
    }
    public void expiredTicket(){
        LocalDate currentDate = LocalDate.now();
        for (Ticket t : tickets) {
            if (t.trip.getEndDate().equals(currentDate)) {
                tickets.remove(t);
            }
        }
    }


    //check trip , discount , viewTravelServices
    public void maxBooking() //added
    {
        if (totaltrips <= 10)
            totaltrips++;
        else
            System.out.println("you reached the maximum number of trips reservation");

    }

    public boolean CheckDiscount_tickect(ArrayList<Trip> trip) {//added
        long uniquedestinationcount = trip.stream()
                .map(Trip::getDestination)//is used to extract the destination from trip array
                .distinct()
                .count();
        return uniquedestinationcount > 2;
    }

    //rating
    public void feedback() {
        LocalDate currentDate = LocalDate.now();

        for (Ticket t : tickets) {
            if (t.trip.getEndDate().equals(currentDate)) {
                System.out.println("Enter your feedback : ");
                feedback.add(in.next());
                inputRate();
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

    public void displayRating(int avgRate) {
        for (int i = 1; i <= avgRate; i++) {

            System.out.println( Main.ANSI_COLORS[5] + "* ");

        }
        System.out.println(Main.ANSI_COLORS[0] + " \n");
    }

    public void inputRate() {
        LocalDate currentDate = LocalDate.now();

        for (Trip t : trip) {
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


//    public void arrange(){
//
//        trip.stream()
//                .sorted()
//    }
//
//}
}



//
//    void arrange(doc doctor[], int last_doc_array) // c= a+b ///a=c-a; b=c-a;
//    {
//         trips.
//        for (int i = last_doc_array - 1; i >= 0; i--)
//        {
//            for (int j = last_doc_array - 1; j >= 0; j--)
//                if (doctor[i].avg_rates > doctor[j].avg_rates)
//                {
//                    doc a = doctor[i];
//                    doctor[i] = doctor[j];
//                    doctor[j] = a;
//                }
//        }
//    }
//    void rating(doc suitable_doctor[], int index_doctor, int current_patient, int last_doc_array)
//    {
//        cout << "  Enter rate ";
//        suitable_doctor[index_doctor].rate[current_patient] = input(0, 5);
//        //cin.ignore(); //repeat rating
//        cout << "       "; RATING(float(suitable_doctor[index_doctor].rate[current_patient]));
//        suitable_doctor[index_doctor].avg_rates = avg_rates(suitable_doctor, index_doctor, current_patient);
//        //arrange(suitable_doctor, last_doc_array); edit
//    }
//
//    void Rate()
//    {
//        HANDLE h = GetStdHandle(STD_OUTPUT_HANDLE);
//        int rate;
//        cout << "  Enter the rate from 0 to 5 :  ";
//        rate = input(0, 5);
//        cout << "\n\t\t  Your Rate :    ";
//        RATING(rate);
//        SetConsoleTextAttribute(h, 7);
//        cout << "\n\n";
//        cout << "  Thank You for your rating!\n\n  We hope we meet your expectations!\n\n";
//    }

//}

