package cis.travel.eg.Main;

import cis.travel.eg.Trip.Trip;
import cis.travel.eg.User.*;

import javax.sound.midi.Soundbank;
import java.io.*;
import java.util.ArrayList;


public class Main {


  //// all classes must  'implements Serializable' and have toString function
    public static void ReadingData(ArrayList<Admin> Admins,ArrayList<Customer> Customers,ArrayList<TourGuide> TourGuides,ArrayList<Manager> Managers,ArrayList<Trip> Trips_system)
    {

        String filePath = "Data.txt";
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filePath))) {
            Admins.addAll((ArrayList<Admin>) inputStream.readObject());
            Customers.addAll((ArrayList<Customer>) inputStream.readObject());
            TourGuides.addAll((ArrayList<TourGuide>) inputStream.readObject());
            Managers.addAll((ArrayList<Manager>) inputStream.readObject());
            Trips_system.addAll((ArrayList<Trip>) inputStream.readObject());

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }
    }
    public static void WritingData(ArrayList<Admin> Admins,ArrayList<Customer> Customers,ArrayList<TourGuide> TourGuides,ArrayList<Manager> Managers,ArrayList<Trip> Trips_system)
    {

        String filePath = "Data.txt";
        //auto closeable
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filePath))) {
            outputStream.writeObject(Admins);
            outputStream.writeObject(Customers);
            outputStream.writeObject(TourGuides);
            outputStream.writeObject(Managers);
            outputStream.writeObject(Trips_system);
        } catch (IOException e) {
            System.out.println("File Not Fount!");
        }

    }


/*+LoginMenu_ForgotPass_Register(): void   //display
+Forgot_Password(): void
+Register_choice(): void
+FeedbackTrip_calc_localtime():void         //display option feedback
 */

    public static void main(String[] args) throws IOException {

        ArrayList<Admin> Admins = new ArrayList<Admin>();             //must add at least one
        ArrayList<Customer> Customers = new ArrayList<Customer>();
        ArrayList<TourGuide> TourGuides = new ArrayList<TourGuide>();
        ArrayList<Manager> Managers = new ArrayList<Manager>();       //must add at least one

        // for login
        Admin CurrentAdmin_index = new Admin();
        Customer CurrentCustomer_index = new Customer();
        TourGuide CurrentTourGuide_index = new TourGuide();
        Manager CurrentManager_index = new Manager();

        ArrayList<Trip> Trips_system = new ArrayList<Trip>();

        ReadingData(Admins, Customers, TourGuides, Managers, Trips_system);

        ///exiting program
     WritingData(Admins, Customers, TourGuides, Managers, Trips_system);
    }

}