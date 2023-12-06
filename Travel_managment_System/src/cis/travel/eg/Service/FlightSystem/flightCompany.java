package cis.travel.eg.Service.FlightSystem;

import java.util.ArrayList;

public class flightCompany {
    public String airportID;
    public static int airportNumber; //order of hotel openning
    public String airportName;
    public String airportLocation;
    public String contactNumber;
    public ArrayList<Flight> flights;
    public flightCompany(){
        airportNumber++;
        airportID="AP"+airportNumber;
    }
}
