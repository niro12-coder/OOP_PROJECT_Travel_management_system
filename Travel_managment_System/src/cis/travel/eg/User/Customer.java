package cis.travel.eg.User;

import java.time.LocalDate;
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
    private String country; //register
    private String preferedcurrency; //register
    private String preferedlanguage; //register
    private String preferedpayment; //register
    private int totaltrips;
    private ArrayList<Ticket> tickets;
    private ArrayList<Voucher> vouchers;
    private ArrayList<Activity> savedActivities;
    private ArrayList<Activity> allActivities;
    private ArrayList<Activity> familyActivities;
    private ArrayList<Activity> coupleActivities;
    private ArrayList<Activity> generalActivities;
    private ArrayList<Trip> trip;
    private ArrayList<Trip> suitableTrip = new ArrayList<Trip>(); // saved for the customer

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
        System.out.println("\t\t [0] Exit ");
        System.out.println("\t\t 1)My Profile");
        System.out.println("\t\t 2)book a ticket");
        System.out.println("\t\t 3)view booked tickets");
        System.out.println("\t\t 4)cancel booking");
        System.out.println("\t\t 5)edit travel");
        System.out.println("\t\t 6)reschedule booking");
        System.out.println("\t\t 7) check discount ticket");
        System.out.println("\t\t 8)Feedback and Rating");
        System.out.println("\t\t9)log out ");

        int Case = input(1, 9);
        while (Case > 0 && Case < 10) {

            switch (Case) {
                case 1:  Display_Profile(Admins, Customers, Managers, TourGuides);
                    break;
                case 2: bookTicket();
                    break;
                case 3:  // view booked tickets
                    break;
                case 4: //cancel trip
                    break;
                case 5:
                    editTicket( tickets.get(tickets.size()-1).trip.getTripType());
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;

            }
        }
        return Case == 0;
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



    public void displayActivitiesByTripType(String tripType, String ticketType) {
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
        }
        catch ( NullPointerException e) {
           System.out.println(e.getMessage());
        }

         do {
            System.out.println("Enter the Activity number:");
            int indexYourActivity = input(1, count);
            savedActivities.add(activities.get(indexYourActivity - 1));

            System.out.println("Do you want to choose another Activity(Y/N)?");

        } while (confirm(in.next().charAt(0)));
    }

//    public void displayActivities(String tripType) {
//        System.out.println("Activities suitable for " + tripType + " trip:");
//        ArrayList<Activity> activities = null;
//        switch (tripType) {
//            case "Family":
//                activities = familyActivities;
//                break;
//            case "Couple":
//                activities = coupleActivities;
//                break;
//            case "General":
//                activities = generalActivities;
//                break;
//            default:
//                System.out.println("Invalid trip type!");
//        }
//        String yourChoice;
//        int count = 0;
//        try {
//            for (Activity activity : activities) {
//                if (activities != null) {
//                    activity.setActivityID(++count);
//                    System.out.println(activity.getName());
//                    System.out.print(count + ". ");
//                    activity.displayActivityDetails();
//                }
//            }
//        }
//        catch ( NullPointerException e) {
//            System.out.println(e.getMessage());
//        }
//        do {
//            System.out.println("Enter the Activity number:");
//            int indexYourActivity = input(1, count);
//            savedActivities.add(activities.get(indexYourActivity - 1));
//
//            System.out.println("Do you want to choose another Activity(Y/N)?");
//
//        } while (confirm(in.next().charAt(0)));
//    }

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
        Scanner in= new Scanner(System.in);
        tickets.add(new Ticket());
        bookTrip();      // indexOfTrip --> suitableTrip , date, type_trip, destination , numOfSeats
        System.out.println("What type of ticket do you want to book?");
        System.out.println("1. Silver ticket \n2. Golden ticket\n3. Platinum ticket ");

        switch(input(1, 3)){
            case 1:
                tickets.get(tickets.size()-1).type = "Silver";
                break;
            case 2:
                tickets.get(tickets.size()-1).type = "Golden";
                break;
            case 3:
                tickets.get(tickets.size()-1).type = "Platinum";
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
                      displayActivitiesByTripType(tickets.get(tickets.size()-1).trip.getTripType(), tickets.get(tickets.size()-1).type); // savedActivities
                break;
            case 2: //book a flight function
                break;
            case 3: //rent car function
                break;
            case 4:
                   //customer.bookHotelRoom(ticket, false);
                break;
            case 5: finish = true;
                break;
            }

         if(!finish) {
             System.out.println("Service is added to your ticket successfully");
             System.out.println("Do you want to assign another service to your ticket(Y/N)?");
         }
         else
             break;

        } while(confirm(in.next().charAt(0)));

        System.out.println(" Do you want to confirm this ticket?");
        if(confirm(in.next().charAt(0))){
            tickets.get(tickets.size() - 1).setCustomerLocation(country);
            tickets.get(tickets.size() - 1).confirmationNumber += tickets.get(tickets.size()-1).trip.getTripID();
            System.out.println(" Ticket is added to your bookings successfully!");

            //displayTicket and send an email
        }
        else {
            tickets.remove(tickets.size() - 1);
            System.out.println(" Ticket not saved.");
            System.out.println(" you will be directed to the home page now.");
        }

        System.out.println("       1. Home page \n       2. Exit");
        return (input(1, 2) == 1 ? 1 : 0);
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
            if (input(1, 2) == 1) {
                String dayName = dayDisplay();
                dateOfTrip = calender_date(dayName);
            } else {
                dateOfTrip = inputDate();
            }
            indexOfTrip = displayTripByDate(dateOfTrip, destination,TourType);  // after display trips by filters , // Enter the suitable number : , return input(a, b)}
        } else {
            indexOfTrip = displayTripByDestination_Type(destination, TourType);
        }

       //save in ticket
        tickets.get(tickets.size()-1).trip = suitableTrip.get(indexOfTrip);

        System.out.println("Now, Enter the suitable number of seats : ");
        tickets.get(tickets.size()-1).setNumberOfSeats(input(1, tickets.get(tickets.size()-1).trip.getAvailableSeats()));
    }
    public int displayTripByDate(LocalDate date, String destination, String tripType) {
        int count = 0;
        IntStream.range(0, trip.size())
                .filter(i -> trip.get(i).getStartDate().equals(date) && trip.get(i).getDestination().equals(destination) && trip.get(i).getTripType().equals(tripType))
                .forEach(i -> {
                    suitableTrip.add(trip.get(i));
                    System.out.print((i + 1) + ". ");
                    trip.get(i).displayDetails();
                });
        System.out.println("Enter the suitable number : ");
        return input(1, suitableTrip.size() + 1) - 1; //1-based
    }

    public int displayTripByDestination_Type(String destination, String tourType) {
        int count = 0;
        IntStream.range(0, trip.size())
                .filter(i -> trip.get(i).getDestination().equals(destination) && trip.get(i).getTripType().equals(tourType))
                .forEach(i -> {
                    suitableTrip.add(trip.get(i));
                    System.out.print((i + 1) + ". ");
                    trip.get(i).displayDetails();
                });
        System.out.println("Enter the suitable number : ");
        return input(1, suitableTrip.size() + 1) - 1; //1-based
    }

    public void editTicket(String TourType) {

//        //view booked Ticket //numbers
//        System.out.println("Enter the suitable number : ");
//        input(1, count);
//
        System.out.println("What do you want edit ? ");
        System.out.println("1. Trip / 2. Activity / 3. Hotels / 4. Car Rentals / 5. Flights");
        switch (input(1, 5)){
            case 1:
                //editTrip();
                break;
            case 2:
                //displayActivitiesByTripType(oldType);
                break;
            case 3: // editHotel
                break;
            case 4: // editCar
                break;
            case 5: // editFlight
                break;
        }
    }

    public void editTrip(){
        // type / destination / numOfSeats(cancel / date(yes , no)
        System.out.println("What do you want to edit:");
        System.out.println("1. Type of Trip \n 2. Destination \n 3. Number of Seats \n 4. Date");
        switch (input(1, 4)){
            case 1:
                System.out.println("Enter the new trip type: ");
                String newType = in.next();
                //date (old _ date)
                //displayTripByDate(date , destination ,newType); // old Date and old Destination from the file stream
                //save
                break;
            case 2:
                System.out.println("Enter the new Destination: ");
                String newDestination = in.next();
                //displayTripByDate(date, newDestination, type);
                //save
                break;
            case 3: // num of seats
                break;
            case 4: // Date
               LocalDate newDate = inputDate();
               //displayTripByDate(newDate, destination ,type);
                // save
            default:
                break;
        }
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

    public void viewTravelServices(ArrayList<Trip> trip, ArrayList<Voucher> vouchers) {
        boolean hasDiscount = CheckDiscount_tickect(trip);
        if (hasDiscount) {
            System.out.println("conguratulation you have a discount ");
            Voucher v = new Voucher();
            vouchers.add(v); //added a new voucher to customer array
            v.DisplayInfo();
        } else
            System.out.println("you don't have a discount yet ");
    }

    public void cancelTrip(ArrayList<Trip> trip, int tripid) {
        for (int i = 0; i < trip.size(); i++) {
            if (trip.get(i).getTripID() == tripid) {
                trip.remove(i);
                System.out.println("trip with id " + tripid + "is cancelled successfully");
                return;
            } else
                System.out.println("there is no trip with this id ");
        }
    }
    public void viewBookedTicket(ArrayList<Ticket>tickets){
        if(tickets.isEmpty())
            System.out.println("you haven't booked tickects yet");
            //else
            //ticket info
        else
        {
            for(Ticket t:tickets){


            }

        }

    }
    public void book_trips() //added
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

    public boolean confirm(char ans) {
        Scanner in = new Scanner(System.in);
        if (ans == 'N' || ans == 'n') {
            return false;
        } else if (ans == 'Y' || ans == 'y') {
            return true;
        } else {
            System.out.println("invalid input, enter again: \n ");
            return confirm(in.next().charAt(0));
        }
    }

}






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

