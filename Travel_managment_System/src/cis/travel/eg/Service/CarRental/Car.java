package cis.travel.eg.Service.CarRental;

import java.io.Serializable;
import java.util.ArrayList;


public class Car implements Serializable {
    public static int numberOfCars = 0;
    public static ArrayList <Car> cars=new ArrayList<>();
    public ArrayList<Renting> rentingCars;
    String Id; // ahg 123
    String Make;
    String model;
    String colour;
    int yearOfManufacture;
    int fuelLevel;
    String location;
    float rentalRatePerDay;


    public Car(String id, String make, String model, String colour, int yearOfManufacture, int fuelLevel, float rentalRatePerDay, String location) {
        Id = id;
        Make = make;
        this.model = model;
        this.colour = colour;
        this.yearOfManufacture = yearOfManufacture;
        this.fuelLevel = fuelLevel;
        this.rentalRatePerDay = rentalRatePerDay;
        this.location = location;
        this.rentingCars = new ArrayList<>();
        numberOfCars++;
    }
    public Car(Car c) {
        Id = c.getId();
        Make = c.getMake();
        this.model = c.getModel();
        this.colour =c.getColour();
        this.yearOfManufacture =c.getYearOfManufacture();
        this.fuelLevel = c.getFuelLevel();
        this.rentalRatePerDay = c.rentalRatePerDay;
        this.location = c.location;
        this.rentingCars = new ArrayList<>();
    }


    public boolean IsCarAvailableForRenting(Date pickupDate, Date returnDate) {

        int numberOfCarRenting = rentingCars.size();
        //    (end1.isBefore(start2) || start1.isAfter(end2))
        // start 1 pickupDate , end 1 returnDate
        // start 2 rentingCars.get(i).getPickupDate() , end 2 rentingCars.get(i).getReturnDate()
        for (Renting rentingCar : rentingCars) {

            if ((returnDate.getDate().isBefore(rentingCar.PickUpDate.getDate()) || pickupDate.getDate().isAfter(rentingCar.PickUpDate.getDate()))) {
                return false;
            }
        }
        return true;
    }

    public void AddRenting (Date pickupDate, Date returnDate) {

        rentingCars.add(new Renting( pickupDate, returnDate));
        long NumberOfRentingDays = rentingCars.get(rentingCars.size() - 1).getNumberOfRentingDays();
        rentingCars.get(rentingCars.size() - 1).setTotalCostForRenting(NumberOfRentingDays * this.rentalRatePerDay);
    }

    public void DisplayAvailableCarsForRenting(Date pickupDate, Date returnDate,String location) {
        if (IsCarAvailableForRenting(pickupDate, returnDate) && this.location.equals(location))
            System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "Car{" +
                "Id='" + Id + '\'' +
                ", Make='" + Make + '\'' +
                ", model='" + model + '\'' +
                ", colour='" + colour + '\'' +
                ", yearOfManufacture=" + yearOfManufacture +
                ", fuelLevel=" + fuelLevel +
                ", rentalRatePerDay=" + rentalRatePerDay +
                '}';
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getMake() {
        return Make;
    }

    public void setMake(String make) {
        Make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setYearOfManufacture(int yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

    public int getFuelLevel() {
        return fuelLevel;
    }

    public void setFuelLevel(int fuelLevel) {
        this.fuelLevel = fuelLevel;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public float getRentalRatePerDay() {
        return rentalRatePerDay;
    }




    public void setRentalRatePerDay(float rentalRatePerDay) {
        this.rentalRatePerDay = rentalRatePerDay;
    }
}
