package cis.travel.eg.User;

import cis.travel.eg.Main.Ticket;
import cis.travel.eg.Main.Voucher;
import cis.travel.eg.Service.Hotels.Reservation.hotelReservation;
import cis.travel.eg.Service.helpingMethods.helpingMethods;
import cis.travel.eg.Trip.Trip;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.IntStream;

import static cis.travel.eg.Service.helpingMethods.helpingMethods.confirm;


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
        return 1;

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
        // My profile(edit_info, Voucher) , ticket, view booked , book a ticket(display trips ,....), edit , delete ,
        Scanner INPUT = new Scanner(System.in);
        System.out.println("\t\t\t\t\t\t\t-------------------------------------------------------------------------------------------------------");
        System.out.println("\t\t\t\t\t\t\t                                                                                              Exit[0]  ");
        System.out.println("\t\t\t\t\t\t\t                                             __ Welcome __                                             ");
        System.out.println("\t\t\t\t\t\t\t                                                                                                       ");
        System.out.println("\t\t\t\t\t\t\t  My Profile  [1]  |  Book a ticket [2]  |  View Booked trips  [3]  |  Log out  [4]  ");
        System.out.println("\t\t\t\t\t\t\t                                                                                                       ");
        System.out.println("\t\t\t\t\t\t\t                                                                                                       ");
        System.out.println("\t\t\t\t\t\t\t                                                                                                       ");
        System.out.println("\t\t\t\t\t\t\t                                                                                                       ");
        System.out.print("\n\n\t\t\t\t\t\t\t   ");

        int Case = input(0, 6);
        while (Case > 0 && Case < 5) {

            switch (Case) {
                case 1:
                    // Display_profile
                    Case = Display_Profile(Admins, Customers, Managers, TourGuides);
                    break;
                case 2: // Book_a_ticket

                    break;
                case 3:  //view_booked_trips
                    break;
                case 4: //
                    break;
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
    public void bookHotelRoom(Ticket ticket, boolean editHotel) {
        helpingMethods methods = new helpingMethods(); //make it static
        Scanner in = new Scanner(System.in);

        ArrayList<hotelReservation> availableHotels = new ArrayList<>();
        // filtering hotels for the customer
        int avaHotels = hotelReservation.hotelsFiltrationForBooking(availableHotels, ticket);
        int hotelChoice = -1;
        if (avaHotels == 0) {
            System.out.println("No available hotels right now");
            return;
        } else {
            // customer choose the suitable hotel
            hotelChoice = hotelReservation.customerChooseHotel(availableHotels, ticket);
            // customer customizes the food board according to his needs
            hotelReservation.customerChooseFoodBoard(availableHotels.get(hotelChoice - 1), ticket);
        }
        ///////////////// BOOKING CONFIRMATION ////////////////////////////
        System.out.println(" Choosing details has ended successfully");
        System.out.println(" Here is your booking details");
        availableHotels.get(hotelChoice - 1).displayHotelForBooking(-1, ticket.numberOfSeats > 2, ticket.numberOfSeats, true);
        System.out.println(" Do you want to confirm? (Y/N)");
        if (confirm(in.next().charAt(0))) {
            if (editHotel) {
                hotelReservation.deleteHotelReservation(ticket);
            }
            ticket.hotelReservation = true;
            ticket.Hotel = availableHotels.get(hotelChoice - 1);
            ticket.price += availableHotels.get(hotelChoice - 1).totalPayments;
            System.out.println("_____________________________________________");
            System.out.println("     PROCESS HAS BEEN MADE SUCCESSFULLY");
            System.out.println("_____________________________________________");
            hotelReservation.saveHotelReservationForAgency(ticket);
        } else {
            System.out.println("Nothing changed in the ticket, thank you!\n");
        }
        ///////////////// BOOKING CONFIRMATION END STAGE ////////////////////////////
    }
    public void customerEditHotelBooking(Ticket ticket) {
        Scanner in = new Scanner(System.in);
        System.out.println("Are you sure you want to edit hotel booking ? (y/n) \n note that: You will choose the hotel from the beginning and your current booking will be cancelled.\n");
        if (confirm(in.next().charAt(0))) {
            bookHotelRoom(ticket, true);
        } else {
            System.out.println("You will be directed to home page\n");
            //customer will be directed to the page where he chose to edit hotel
        }
    }
    public void customerCancelHotelBooking(Ticket Ticket) {
        Scanner in = new Scanner(System.in);
        System.out.println("Are you sure you want to cancel this hotel booking ? (y/n)\n");
        if (confirm(in.next().charAt(0))) {
            hotelReservation.deleteHotelReservation(Ticket);
        } else {
            System.out.println("Nothing cancelled,thank you!\n");
        }
    }
    public void displayTicketsForCustomer(){
        System.out.println(" 1. All tickets\n 2. Last ticket booked");
        switch (helpingMethods.choice(1,2)){
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

