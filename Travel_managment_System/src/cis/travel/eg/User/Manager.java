package cis.travel.eg.User;

import cis.travel.eg.Service.CarRental.Car;
import cis.travel.eg.Service.FlightSystem.Airport;
import cis.travel.eg.Service.Hotels.Agency.Agency;
import cis.travel.eg.Service.Hotels.DetailsForSystem.HotelForAgency;
import cis.travel.eg.Service.Hotels.HotelDetails.doubleRooms;
import cis.travel.eg.Service.Hotels.HotelDetails.generalRooms;
import cis.travel.eg.Service.Hotels.HotelDetails.singleRooms;
import cis.travel.eg.Service.helpingMethods.helpingMethods;
import cis.travel.eg.Trip.Trip;

//import javafx.scene.input.Mnemonic;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.stream.IntStream;

import static cis.travel.eg.Main.Main.in;

public class Manager extends User implements Serializable {

    public Manager(){};
    public static int Is_login_successfully(String username, String password,ArrayList<Manager> mange)
    {
        for(int i=0;i< mange.size();i++)
        {
            Manager manager=mange.get(i);  //to get the current Customer object from the ArrayList.
            if(manager.getUsername().equals(username) && manager.getPassword().equals(password))
            {
                System.out.println("login successfully "+username);
                return i;
            }
            else
                System.out.println("login failed");
        }
        return -1;
    }
    public void Display_Profile() {
        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("**********WELCOME**********");
        System.out.println("your first name " + super.getFirstName());
        System.out.println("-----------------------------------------");
        System.out.println("your last name " + super.getLastName());
        System.out.println("-----------------------------------------");
        //can add one his methods
        System.out.println("╚═══════════════════════════════════════════╝");
    }
    public void Edit_Profile() {
        String choice,fname,lname,country,pass1,pass2;
        int option,age;
        do {
            System.out.println("welcome " + super.getUsername());
            System.out.println("choose which option you want to change ");
            System.out.println(" 1)  first name \n2) Last name \n 3) Password \n  4) Age \n");
            option = in.nextInt();
            switch(option){
                case 1 :
                    System.out.println("please enter your first name ");
                    fname=in.next();
                    super.setFirstName(fname);//????????????
                    System.out.println("Done successfully "+super.getFirstName());
                    break;
                case 2:
                    System.out.println("please enter your last name ");
                    lname=in.next();
                    super.setLastName(lname);
                    System.out.println("Done sussefully "+super.getLastName());
                    break;
                case 3:
                    System.out.println("please enter your new password");
                    pass1=in.next();
                    System.out.println("Write again");
                    pass2=in.next();
                    super.setPassword(pass1,pass2);
                    System.out.println("Done sussefully ");
                    break;
                case 4:
                    System.out.println("please enter your age ");
                    age=in.nextInt();
                    super.setAge(age);
                    System.out.println("Done sussefully");
                    break;
                default:
                    System.out.println(" invalid choice try again ");
                    option=in.nextInt();
            }
            System.out.println("Do you want to make another change ? ");
            choice = in.next();
        }while(choice.toLowerCase().equals("yes"));
    }
    public void Register(ArrayList<Admin> Admins, ArrayList<Customer> Customers, ArrayList<Manager> Managers,ArrayList<TourGuide> TourGuides) {
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

    @Override
    public boolean HomePage(ArrayList<Admin> Admins, ArrayList<Customer> Customers, ArrayList<TourGuide> TourGuides, ArrayList<Manager> Managers, ArrayList<Trip> Trips_system) {
        return false;
    }

    @Override
    public int Display_Profile(ArrayList<Admin> admin, ArrayList<Customer> customer, ArrayList<Manager> manager, ArrayList<TourGuide> tourguide) {
        return 0;
    }

    @Override
    public int Edit_Profile(ArrayList<Admin> admin, ArrayList<Customer> customer, ArrayList<Manager> manager, ArrayList<TourGuide> tourguide) {
        return 0;
    }

    static public int FoundUsername(String username, ArrayList<Manager> managers) {
        return IntStream.range(0,managers.size())
                .filter(i ->managers.get(i).getUsername().equals(username))
                .findFirst()
                .orElse(-1);
    }
// hotels
    public void AddNewHotel(){
        Agency.hotels.add(new HotelForAgency());
        System.out.println("     <<Fill these details, please.>>");
        int hotelRating;

        System.out.println(" Hotel name: ");
        Agency.hotels.get(Agency.hotels.size() - 1).setHotelName(in.next());
        System.out.println(" Hotel Location: ");
        Agency.hotels.get(Agency.hotels.size() - 1).setHotelLocation(in.next());
        System.out.println(" Hotel Rating [1-5]: ");
        do{
            hotelRating= in.nextInt();
            if(hotelRating<1|| hotelRating>5){
                System.out.println("Invalid input, please enter a number from 1 to 5./n");
            }
        }while(hotelRating<1|| hotelRating>5);
        Agency.hotels.get(Agency.hotels.size() - 1).setHotelRating(hotelRating);
        System.out.println(" Contact number: ");
        Agency.hotels.get(Agency.hotels.size() - 1).setContactNumber(in.next()); //check number
        System.out.println("Is there aqua park? Y/N ");
        Agency.hotels.get(Agency.hotels.size() - 1).setAquaPark(helpingMethods.confirm(in.next().charAt(0)));
        System.out.println(" NEXT STAGE: you will enter room details\n");
        managerEnterRoomDetails();
        System.out.println("Do you want to confirm this hotel and add it to your Agency?");
        if(!helpingMethods.confirm(in.next().charAt(0))){ //if not confirm
            Agency.hotels.remove(Agency.hotels.size()-1);
        }
    }
    public void managerEnterRoomDetails(){
        singleRooms tempSingleRoom= new singleRooms();
        tempSingleRoom.assignRoomDetailsForHotel(Agency.hotels.get(Agency.hotels.size()-1));
        doubleRooms tempDoubleRoom= new doubleRooms();
        tempDoubleRoom.assignRoomDetailsForHotel(Agency.hotels.get(Agency.hotels.size()-1));
        generalRooms tempFamilyRoom= new generalRooms();
        tempFamilyRoom.assignRoomDetailsForHotel(Agency.hotels.get(Agency.hotels.size()-1));
    }
    public void updateHotelInformation() {

        System.out.println(" Are you sure that you want to edit certain hotel?\n Note that : Any changes happen, will be applied to new booking only." );
        if(helpingMethods.confirm(in.next().charAt(0))){
            displayBasicHotelDetails();
            System.out.println("\n Choose the hotel you want to edit");
            int choice= helpingMethods.choice(1, Agency.hotels.size());
            System.out.println(" what do you ant to edit?\n 1- Single rooms\n 2- Double rooms\n 3 General rooms\n 4- Rating of the hotel");
            int editChoice= helpingMethods.choice(1,3);
            switch(editChoice){
                case 1:
                    singleRooms tempRoom=new singleRooms();
                    tempRoom.updateRoomDetailsForHotel(Agency.hotels.get(choice-1));
                    break;
                case 2:
                    doubleRooms tempRoom2=new doubleRooms();
                    tempRoom2.updateRoomDetailsForHotel(Agency.hotels.get(choice-1));
                    break;
                case 3:
                    generalRooms tempRoom3=new generalRooms();
                    tempRoom3.updateRoomDetailsForHotel(Agency.hotels.get(choice-1));
                    break;
                case 4:
                    int newRating= in.nextInt();
                    System.out.println("Confirm new rating to the hotel?");
                    if(helpingMethods.confirm(in.next().charAt(0))){
                        Agency.hotels.get(choice - 1).setHotelRating(newRating);
                    }
                    break;
            }
        }else {
            System.out.println(" you will be directed to the homepage.");
        }
    }
    public void displayBasicHotelDetails(){
        System.out.println("<<Hotels available in your agency>>");
        System.out.println(" ");
        System.out.println("____________________________________");
        for(int h = 0; h< Agency.hotels.size(); h++){
            System.out.println(" "+(h+1)+"| "+ Agency.hotels.get(h).getHotelName());
            System.out.println(" Rating: "+ Agency.hotels.get(h).getHotelRating() +" stars");
            System.out.println(" Location: "+ Agency.hotels.get(h).getHotelLocation());
            System.out.println(" Contact number: "+ Agency.hotels.get(h).getContactNumber());
            System.out.println("____________________________________");
        }
    }
    public void deleteHotel(ArrayList<Customer> Customers){

        System.out.println(" 1- Delete certain hotel\n 2- Delete all hotels");
        int choice = helpingMethods.choice(1,2);
        switch(choice){
            case 1:
                displayBasicHotelDetails();
                System.out.println("\n Choose the hotel you want to delete");
                choice= helpingMethods.choice(1, Agency.hotels.size());
                System.out.println(" Are you sure ?(y/n)");
                if(helpingMethods.confirm(in.next().charAt(0))){
                    for(Customer Customer: Customers){
                        for(int i = 0; i< Customer.getTickets().size(); i++){
                            if(Customer.getTickets().get(i).Hotel.getHotelID().equals(Agency.hotels.get(choice - 1).getHotelID())){
                                Customer.getTickets().get(i).price-= Customer.getTickets().get(i).Hotel.totalPayments;
                                Customer.getTickets().get(i).Hotel=null;
                            }
                        }
                    }
                    Agency.hotels.remove(choice-1);
                }else {
                    System.out.println(" Nothing changed, thank you !");
                }
                break;
            case 2:
                System.out.println(" Are you sure ?(y/n)");
                if(helpingMethods.confirm(in.next().charAt(0))){
                    for(Customer customer: Customers){
                        for(int i = 0; i< customer.getTickets().size(); i++){
                            customer.getTickets().get(i).price-= customer.getTickets().get(i).Hotel.totalPayments;
                            customer.getTickets().get(i).Hotel=null;
                        }
                    }
                    Agency.hotels.clear();
                }else {
                    System.out.println(" Nothing changed, thank you !");
                }
                break;
        }
    }
    public void displayHotelsInAgency(){

        displayBasicHotelDetails();
        System.out.println("Do you want to display certain hotel in details?(y/n)");
        if(helpingMethods.confirm(in.next().charAt(0))){
            System.out.println("Please enter the number of hotel (1,2,3,..,etc)");
            int num=helpingMethods.choice(1, Agency.hotels.size());
            HotelForAgency.hotelDetails(Agency.hotels.get(num-1));
        }else {
            System.out.println(" You will be directed to the homepage");
        }

    }

    // flights
    public void AddNewAirPort() {
       Airport tempAirport=new Airport();
       tempAirport.AddNewAirport();
       Airport.Airports.add(tempAirport);
    }
    public void EditAirport(ArrayList<Customer> customers){
        System.out.println("Please enter the number for Airport you want to Edit ");
       int indexOfAirportYouWantToEdit= DisplayAirportDetails();
       Airport.Airports.get(indexOfAirportYouWantToEdit).EditAirport(customers);
    }
    public void DeleteAnAirport(){
        System.out.println("Please enter the number for Airport you want to delete ");
        int indexOfAirportYouWantToEdit= DisplayAirportDetails();
        Airport.Airports.remove(indexOfAirportYouWantToEdit);

    }
    public int  DisplayAirportDetails(){
        int c=1;
        for (Airport airport: Airport.Airports) {
            System.out.print(c);
            System.out.println( airport);
            c++;
        }
        int ans =helpingMethods.choice(1,Airport.Airports.size());
        ans--;
        return ans;
    }

// cars
    public void AddNewCar() {
        Car temp =new Car();
        temp.AddNewCar();
        Car.cars.add(temp);
    }
    public void EditCarDetails(ArrayList<Customer> customers){
        System.out.println("Please enter the number for Airport you want to Edit ");
        int indexOfCarYouWantToEdit= DisplayAllCars();
        Car.cars.get(indexOfCarYouWantToEdit).editCarData(customers);
    }
    public void DeleteCar(){
        System.out.println("Please enter the number for Airport you want to delete ");
        int indexOfCarYouWantToEdit= DisplayAllCars();
        Car.cars.remove(indexOfCarYouWantToEdit);

    }
    public int DisplayAllCars(){
        for (int i = 0; i < Car.cars.size(); i++) {
            System.out.print(i+1);
            System.out.println(Car.cars);
        }
        int ans =helpingMethods.choice(1,Car.cars.size());
        ans--;
        return ans;
    }
}
