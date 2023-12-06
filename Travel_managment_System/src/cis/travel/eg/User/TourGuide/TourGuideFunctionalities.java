package cis.travel.eg.User.TourGuide;

import cis.travel.eg.Trip.Trip;
import cis.travel.eg.User.Admin;
import cis.travel.eg.User.Customer;
import cis.travel.eg.User.Manager;
import cis.travel.eg.User.TourGuide.TourGuide;

import java.util.ArrayList;

public interface TourGuideFunctionalities {

double calculateMonthlySalary(int year, int month, ArrayList<Trip> Trips);  // yyyy-mm-dd
// method to calc percentage of price taken from each trip according to days
int ViewTripsWithApproval();
int update_TravelHistory();   //trips
int complaint();
int Number_availableGuides(int year, int month, ArrayList<TourGuide> TourGuides);  //tourguides date of trip
int Number_availableGuides();    //tourguides from now till next 7 days
int view_statistics_SalaryMonthly();
int Logout_exist(ArrayList<Admin> Admins, ArrayList<Customer> Customers, ArrayList<TourGuide> TourGuides, ArrayList<Manager> Managers, ArrayList<Trip> Trips_system)


}
