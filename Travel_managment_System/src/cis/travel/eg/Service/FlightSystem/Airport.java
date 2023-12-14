package cis.travel.eg.Service.FlightSystem;

import cis.travel.eg.Service.helpingMethods.helpingMethods;
import cis.travel.eg.User.Customer;

import java.io.Serializable;
import java.util.ArrayList;

import static cis.travel.eg.Main.Main.in;

public class Airport  implements Serializable  {
    public static ArrayList <Airport> Airports =new ArrayList<>();
    public static int numberOfAirports =0;
    public String airportID;
    public String airportName;
    public String airportLocation;
    public String contactNumber;
    public ArrayList<Flight> flights=new ArrayList<>();

    public Airport(String airportName, String airportLocation, String contactNumber, ArrayList<Flight> flights) {
        this.airportID="AP"+ numberOfAirports;
        numberOfAirports++;
        this.airportName = airportName;
        this.airportLocation = airportLocation;
        this.contactNumber = contactNumber;
        this.flights = flights;
    }

    public Airport() {

    }

    public void AddNewAirport() {

        this.airportID="AP"+ numberOfAirports;
        numberOfAirports++;

        System.out.print("Enter Airport Name: ");
        this.airportName = in.nextLine();

        System.out.print("Enter Airport Location: ");
        this.airportLocation = in.nextLine();

        System.out.print("Enter Contact Number: ");
        this.contactNumber = in.nextLine();

        System.out.println("Do You Want to Add a new Flight Detail ( y : n )");
        char ans=in.next().charAt(0);
        ans= helpingMethods.InputYesOrNo(ans);
        do
        {
            if (ans=='y'||ans=='Y')
            {
                System.out.println("Enter Flights details : ");
                Flight f=new Flight();
                f.AddNewFlight();
                this.flights.add(f);
            }
            else
            {
                break;
            }
            System.out.println("Do You Want to Add another Flight Detail ( y : n )");
             ans=in.next().charAt(0);
            ans= helpingMethods.InputYesOrNo(ans);
        }while (ans=='Y'||ans=='y');

    }

    public void EditAirport(ArrayList<Customer> customers) {
        boolean editAnotherthing;
        do {

        Scanner scanner=new Scanner(System.in);
        System.out.print("choose the number for what you want to edit \n1 airportName \n2 airportLocation  \n3 contactNumber");

        int choice;
        if (this.flights.isEmpty())
        {
            choice=helpingMethods.choice(1,3);
            System.out.print("\n");
        }
        else
        {
            System.out.println("\n4 flights");
            choice=helpingMethods.choice(1,4);
        }
        switch (choice)
        {
            case 1:
                System.out.print("Enter Airport Name: ");
                this.airportName = in.nextLine();
                break;
            case 2:
                System.out.print("Enter Airport Location: ");
                this.airportLocation = in.nextLine();
                break;
            case 3:
                System.out.print("Enter Contact Number: ");
                this.contactNumber = in.nextLine();
                break;
            case 4:
                int ans ;
                for (int i = 0; i < flights.size(); i++) {
                    System.out.print(i+1);
                    System.out.println(flights.get(i));
                }
                System.out.println("Enter number of flight you want to change");
                ans=helpingMethods.choice(1,flights.size());
                ans--;
                this.flights.get(ans).EditFlightDetails(customers);

        }
            System.out.println("do you want to edit something else");

            char continueorNot=scanner.next().charAt(0);
            editAnotherthing=helpingMethods.confirm(continueorNot);

        }while(editAnotherthing);

    }

    public static ArrayList<Airport> getAirports() {
        return Airports;
    }

    public static void setAirports(ArrayList<Airport> airports) {
        Airports = airports;
    }

    public static int getNumberOfAirports() {
        return numberOfAirports;
    }

    public static void setNumberOfAirports(int numberOfAirports) {
        Airport.numberOfAirports = numberOfAirports;
    }

    public String getAirportID() {
        return airportID;
    }

    public void setAirportID(String airportID) {
        this.airportID = airportID;
    }

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    public String getAirportLocation() {
        return airportLocation;
    }

    public void setAirportLocation(String airportLocation) {
        this.airportLocation = airportLocation;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public ArrayList<Flight> getFlights() {
        return flights;
    }

    public void setFlights(ArrayList<Flight> flights) {
        this.flights = flights;
    }

    @Override
    public String toString() {
        return "Airport{" +
                "airportID='" + airportID + '\'' +
                ", airportName='" + airportName + '\'' +
                ", airportLocation='" + airportLocation + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", flights=" + flights +
                '}';
    }
}
