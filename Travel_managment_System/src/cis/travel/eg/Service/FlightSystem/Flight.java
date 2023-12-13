package cis.travel.eg.Service.FlightSystem;

import cis.travel.eg.Service.CarRental.Date;
import cis.travel.eg.Service.helpingMethods.helpingMethods;

import java.io.Serializable;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Flight  implements Serializable {
   public static ArrayList<Airport> flights=new ArrayList<>();
   Scanner scanner =new Scanner(System.in);
   int flightNumber;
   String departure;
   String arrival;
   Date FlightDate=new Date();
   DayOfWeek flightDayOfWeek;
   LocalTime flightTime;
   int numberOfAvailableSeats=0;
   double flightPrice;
   String classLevel;
   int numberOfBookedSeat=0;
   //boolean roundFlight;
   public ArrayList<Boolean> bookedSeats=new ArrayList<>();
   public Flight(int flightNumber, String departure, String arrival,int Day ,int month , int year, LocalTime flightTime, int numberAvailableSeats, double flightPrice, String classLevel) {
      this.flightNumber = flightNumber;
      this.departure = departure;
      this.arrival = arrival;
      this.FlightDate=new Date(Day,month,year);
      this.flightDayOfWeek = this.FlightDate.getDate().getDayOfWeek();
      this.flightTime = flightTime;
      this.numberOfAvailableSeats = numberAvailableSeats;
      this.flightPrice = flightPrice;
      this.classLevel = classLevel;
      for (int i  = 0; i < this.numberOfAvailableSeats; i++) {
         bookedSeats.add(true);
      }
   }
   public Flight() {

   }
   public void AddNewFlight(){


      System.out.print("Enter Flight Number: ");
      this.flightNumber = scanner.nextInt();

      System.out.print("Enter Departure Location: ");
      this.departure = scanner.next();

      System.out.print("Enter Arrival Location: ");
      this.arrival = scanner.next();
      System.out.println("Enter Flight date details");

      this.FlightDate.TakeDateFromUser();

      this.flightDayOfWeek = FlightDate.getDate().getDayOfWeek();

      this.TackFlightTimeFromUser();

      System.out.print("Enter Number of Available Seats: ");
      this.numberOfAvailableSeats = scanner.nextInt();

      while (numberOfAvailableSeats<=0){
            System.out.println("Not an Available Number");
          numberOfAvailableSeats = scanner.nextInt();
      }
      for (int i  = 0; i < this.numberOfAvailableSeats; i++) {
         bookedSeats.add(true);
      }

      System.out.print("Enter Ticket Price: ");
      this.flightPrice = scanner.nextDouble();

   }
   public void TackFlightTimeFromUser(){
   System.out.print("Enter hours (0-23): ");
   int hours = scanner.nextInt();
   hours = helpingMethods.InputValidOrNot(0,24,hours);

   System.out.print("Enter minutes (0-59): ");
   int minutes = scanner.nextInt();
   minutes = helpingMethods.InputValidOrNot(0,59,minutes);

   this.flightTime = LocalTime.of(hours, minutes);
}

   public DayOfWeek getFlightDayOfWeek() {
      return flightDayOfWeek;
   }

   public void setFlightDayOfWeek(DayOfWeek flightDayOfWeek) {
      this.flightDayOfWeek = flightDayOfWeek;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Flight flight = (Flight) o;
      return flightNumber == flight.flightNumber;
   }

   @Override
   public int hashCode() {
      return Objects.hash(flightNumber);
   }
   public void EditFlightDetails(){

      System.out.println("What do you want to edit ");
      System.out.println( "\n1 flightNumber \n2 departure \n3 arrival\n4 FlightDate\n5 flightTime\n6 numberOfAvailableSeats\n7 flightPrice");
      int choice=helpingMethods.choice(1,7);

      switch (choice){
         case 1:
            System.out.print("Enter Flight Number: ");
            this.flightNumber = scanner.nextInt();
            break;
         case 2:
            System.out.print("Enter Departure Location: ");
            this.departure = scanner.next();
            break;
         case 3:
            System.out.print("Enter Arrival Location: ");
            this.arrival = scanner.next();
            break;
         case 4:
            System.out.println("Enter Flight date details");
            this.FlightDate.TakeDateFromUser();
            break;
         case 5:
            this.flightDayOfWeek = FlightDate.getDate().getDayOfWeek();
            this.TackFlightTimeFromUser();
            break;
         case 6:
            System.out.print("Enter Number of  Seats: ");
            this.numberOfAvailableSeats = scanner.nextInt();
            break;
         case 7:
            System.out.print("Enter Ticket Price: ");
            this.flightPrice = scanner.nextDouble();
            break;
      }
   }
   public int getFlightNumber() {
      return flightNumber;
   }

   public void setFlightNumber(int flightNumber) {
      this.flightNumber = flightNumber;
   }

   public String getDeparture() {
      return departure;
   }

   public void setDeparture(String departure) {
      this.departure = departure;
   }

   public String getArrival() {
      return arrival;
   }

   public void setArrival(String arrival) {
      this.arrival = arrival;
   }


   public LocalTime getFlightTime() {
      return flightTime;
   }

   public void setFlightTime(LocalTime flightTime) {
      this.flightTime = flightTime;
   }

   public int getAvailableSeats() {
      return numberOfAvailableSeats;
   }

   public void setAvailableSeats(int availableSeats) {
      this.numberOfAvailableSeats = availableSeats;
   }

   public double getFlightPrice() {
      return flightPrice;
   }

   public void setFlightPrice(double flightPrice) {
      this.flightPrice = flightPrice;
   }

   public String getClassLevel() {
      return classLevel;
   }

   public void setClassLevel(String classLevel) {
      this.classLevel = classLevel;
   }

   public int getNumberOfBookedSeat() {
      return numberOfBookedSeat;
   }

   public void setNumberOfBookedSeat(int numberOfBookedSeat) {
      this.numberOfBookedSeat = numberOfBookedSeat;
   }

   @Override
   public String toString() {
      return "Flight{" +
              "\nflightNumber=" + flightNumber +
              "\n departure='" + departure + '\'' +
              "\n arrival='" + arrival + '\'' +
              "\n FlightDate=" + FlightDate +
              "\n flightDayOfWeek=" + flightDayOfWeek +
              "\n flightTime=" + flightTime +
              "\n numberOfAvailableSeats=" + numberOfAvailableSeats +
              "\n flightPrice=" + flightPrice +
              '}' ;
   }
}
