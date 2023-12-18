package cis.travel.eg.Service.CarRental;

import cis.travel.eg.Service.Payment;
import cis.travel.eg.Service.helpingMethods.helpingMethods;
import cis.travel.eg.User.Customer;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;


public class Car implements Serializable, Payment {

    public static int numberOfCars = 0;
    public static ArrayList<Car> cars = new ArrayList<>();
    public ArrayList<Renting> rentingCars = new ArrayList<>();
    private String Id; // ahg 123
    private String Make;
    private String model;
    private String colour;
    private int yearOfManufacture;
    private int fuelLevel;
    private String location;
    private float rentalRatePerDay;

    public Car() {

    }

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
        this.colour = c.getColour();
        this.yearOfManufacture = c.getYearOfManufacture();
        this.fuelLevel = c.getFuelLevel();
        this.rentalRatePerDay = c.rentalRatePerDay;
        this.location = c.location;
        this.rentingCars = new ArrayList<>();
    }

    public void AddNewCar() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter car ID: ");
        this.Id = in.nextLine();
        for (int i = 0; i < Car.cars.size(); i++) {
            if (this.Id.equals(Car.cars.get(i).Id)) {
                System.out.println("sorry this car already exist ");
                return;
            }
        }

        System.out.print("Enter car make: ");
        this.Make = in.nextLine();

        System.out.print("Enter car model: ");
        this.model = in.nextLine();

        System.out.print("Enter car colour: ");
        this.colour = in.nextLine();

        System.out.print("Enter year of manufacture: ");
        this.yearOfManufacture = in.nextInt();
        in.nextLine(); // consume the newline character

        System.out.print("Enter fuel level: ");
        this.fuelLevel = in.nextInt();
        in.nextLine(); // consume the newline character

        System.out.print("Enter car location: ");
        this.location = in.nextLine();

        System.out.print("Enter rental rate per day: ");
        this.rentalRatePerDay = in.nextFloat();
    }

    public void editCarData(ArrayList<Customer> customers) {

        LocalDate currentDate = LocalDate.now();
        boolean editAnotherThing;
        do {
            Scanner in = new Scanner(System.in);
            System.out.println("Select a field to edit:");
            System.out.println("1. Car Make");
            System.out.println("2. Car Model");
            System.out.println("3. Car Colour");
            System.out.println("4. Year of Manufacture");
            System.out.println("5. Fuel Level");
            System.out.println("6. Car Location");
            System.out.println("7. Rental Rate Per Day");

            System.out.print("Enter your choice: ");
            int choice = helpingMethods.choice(1, 7);

            switch (choice) {
                case 1:
                    System.out.print("Enter new car make: ");
                    this.Make = in.nextLine();
                    break;
                case 2:
                    System.out.print("Enter new car model: ");
                    this.model = in.nextLine();
                    break;
                case 3:
                    System.out.print("Enter new car colour: ");
                    this.colour = in.nextLine();
                    break;
                case 4:
                    System.out.print("Enter new year of manufacture: ");
                    this.yearOfManufacture = in.nextInt();
                    in.nextLine(); // consume the newline character
                    break;
                case 5:
                    System.out.print("Enter new fuel level: ");
                    this.fuelLevel = in.nextInt();
                    in.nextLine(); // consume the newline character
                    break;
                case 6:
                    System.out.print("Enter new car location: ");
                    this.location = in.nextLine();
                    break;
                case 7:
                    System.out.print("Enter new rental rate per day: ");
                    this.rentalRatePerDay = in.nextFloat();
                    in.nextLine(); // consume the newline character
                    break;
                default:
                    System.out.println("Invalid choice. No changes made.");
            }
            System.out.println("do you want to edit something else");
            ArrayList<Integer> CustomerIndex = new ArrayList<>();
            ArrayList<Integer> TicketIndex = new ArrayList<>();
            char continueorNot = in.next().charAt(0);
            editAnotherThing = helpingMethods.confirm(continueorNot);
            if (choice == 7) {
                for (int customerIndex = 0; customerIndex < customers.size(); customerIndex++) {
                    Customer c = customers.get(customerIndex);
                    for (int ticketIndex = 0; ticketIndex < c.getTickets().size(); ticketIndex++) {
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

                        LocalDate tripDate = LocalDate.parse(c.getTickets().get(ticketIndex).getTrip().getStartDate(), formatter);

                        if (c.getTickets().get(ticketIndex).isRentCar() && c.getTickets().get(ticketIndex).getCar().getId().equals(this.Id) && currentDate.isBefore(tripDate)) {
                            CustomerIndex.add(customerIndex);
                            TicketIndex.add(ticketIndex);
                        }
                    }

                }
            }

            for (int i = 0; i < CustomerIndex.size(); i++) {
                // sent emails for customer
                Car c = customers.get(CustomerIndex.get(i)).getTickets().get(TicketIndex.get(i)).getCar();
                customers.get(CustomerIndex.get(i)).getTickets().get(TicketIndex.get(i)).cancelRentedCar();
            }
        } while (editAnotherThing);
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

    public void AddRenting(Date pickupDate, Date returnDate) {

        rentingCars.add(new Renting(pickupDate, returnDate));
        long NumberOfRentingDays = rentingCars.get(rentingCars.size() - 1).getNumberOfRentingDays();
        calculateTotalPriceForTotalPeriod(NumberOfRentingDays);
        //rentingCars.get(rentingCars.size() - 1).setTotalCostForRenting(NumberOfRentingDays * this.rentalRatePerDay);
    }

    public void calculateTotalPriceForTotalPeriod(long NumberOfRentingDays) {
        rentingCars.get(rentingCars.size() - 1).setTotalCostForRenting(NumberOfRentingDays * this.rentalRatePerDay);
    }

    public void DisplayAvailableCarsForRenting(Date pickupDate, Date returnDate, String location) {
        if (IsCarAvailableForRenting(pickupDate, returnDate) && this.location.equals(location))
            System.out.println(this);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(Id, car.Id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id);
    }

    @Override
    public String toString() {
        return "Car{" +
                "rentingCars=" + rentingCars +
                ", Id='" + Id + '\'' +
                ", Make='" + Make + '\'' +
                ", model='" + model + '\'' +
                ", colour='" + colour + '\'' +
                ", yearOfManufacture=" + yearOfManufacture +
                ", fuelLevel=" + fuelLevel +
                ", location='" + location + '\'' +
                ", rentalRatePerDay=" + rentalRatePerDay +
                '}';
    }
}
