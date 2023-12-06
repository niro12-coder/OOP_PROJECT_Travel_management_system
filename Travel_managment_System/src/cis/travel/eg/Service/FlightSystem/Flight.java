package cis.travel.eg.Service.FlightSystem;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Flight {
   int flightNumber;
   String departure;
   String arrival;
   String flightWeekDay;
   LocalDate flightDate;
   DayOfWeek flightDayOfWeek;
   LocalTime flightTime;
   int availableSeats;
   double flightPrice;
   String classLevel;
   boolean roundFlight;
   public ArrayList<Boolean> bookedSeats=new ArrayList<>();

   public Flight(int flightNumber, String departure, String arrival, String flightWeekDay, LocalDate flightDate, DayOfWeek flightDayOfWeek, LocalTime flightTime, int availableSeats, double flightPrice, String classLevel, boolean roundFlight) {
      this.flightNumber = flightNumber;
      this.departure = departure;
      this.arrival = arrival;
      this.flightWeekDay = flightWeekDay;
      this.flightDate = flightDate;
      this.flightDayOfWeek = flightDayOfWeek;
      this.flightTime = flightTime;
      this.availableSeats = availableSeats;
      this.flightPrice = flightPrice;
      this.classLevel = classLevel;
      this.roundFlight = roundFlight;
      bookedSeats=new ArrayList<>(availableSeats);

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

   public String getFlightWeekDay() {
      return flightWeekDay;
   }

   public void setFlightWeekDay(String flightWeekDay) {
      this.flightWeekDay = flightWeekDay;
   }

   public LocalDate getFlightDate() {
      return flightDate;
   }

   public void setFlightDate(LocalDate flightDate) {
      this.flightDate = flightDate;
   }

   public LocalTime getFlightTime() {
      return flightTime;
   }

   public void setFlightTime(LocalTime flightTime) {
      this.flightTime = flightTime;
   }

   public int getAvailableSeats() {
      return availableSeats;
   }

   public void setAvailableSeats(int availableSeats) {
      this.availableSeats = availableSeats;
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

   public boolean isRoundFlight() {
      return roundFlight;
   }

   public void setRoundFlight(boolean roundFlight) {
      this.roundFlight = roundFlight;
   }

   public DayOfWeek getFlightDayOfWeek() {
      return flightDayOfWeek;
   }

   public void setFlightDayOfWeek(DayOfWeek flightDayOfWeek) {
      this.flightDayOfWeek = flightDayOfWeek;
   }

   @Override
   public String toString() {
      return "Flight{" +
              "flightNumber=" + flightNumber +
              ", departure='" + departure + '\'' +
              ", arrival='" + arrival + '\'' +
              ", flightWeekDay='" + flightWeekDay + '\'' +
              ", flightDate=" + flightDate +
              ", flightDayOfWeek=" + flightDayOfWeek +
              ", flightTime=" + flightTime +
              ", availableSeats=" + availableSeats +
              ", flightPrice=" + flightPrice +
              ", classLevel='" + classLevel + '\'' +
              '}';
   }
}
