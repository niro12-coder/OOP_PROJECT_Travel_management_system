package cis.travel.eg.Service.Hotels.Reservation;
import cis.travel.eg.Main.Ticket;
import cis.travel.eg.Service.Hotels.DetailsForSystem.*;
import cis.travel.eg.Service.Payment;
import cis.travel.eg.Service.helpingMethods.helpingMethods;
import cis.travel.eg.Service.Hotels.HotelDetails.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import static cis.travel.eg.Main.Main.in;

public class hotelReservation extends Hotel implements Serializable, Payment {
    //basicRoomDetails roomAvailable;
    public ArrayList<basicRoomDetails> roomAvailable = new ArrayList<>();
    public LocalDate startDate;
    public LocalDate endDate;
    public double[] finalFoodBoard = new double[3];
    public double totalPayments;
    long totalDaysOfTrip;

    public hotelReservation(Hotel hotel) {
        this.setHotelID(hotel.getHotelID());
        this.setHotelName(hotel.getHotelName());
        this.setHotelRating(hotel.getHotelRating());
        this.setHotelLocation(hotel.getHotelLocation());
        this.setContactNumber(hotel.getContactNumber());
        this.setAquaPark(hotel.isAquaPark());
    }
    public static int hotelsFiltrationForBooking(ArrayList<hotelReservation> availableHotels, Ticket ticket) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate tripStartDate = LocalDate.parse(ticket.getTrip().getStartDate(), formatter);
        LocalDate tripEndDate = LocalDate.parse(ticket.getTrip().getEndDate(), formatter);
        int avaHotels = 0;
        if (ticket.getNumberOfSeats() == 1) {
            for (int i = 0; i < HotelForAgency.hotels.size(); i++) {
                if (HotelForAgency.hotels.get(i).getHotelLocation().equals(ticket.getTrip().getDestination())) {
                    for (int j = 0; i < HotelForAgency.hotels.get(i).getNumberOfSingleRooms(); j++) {
                        int reservationArraySize = HotelForAgency.hotels.get(i).singleRoom.get(j).Reservations.size();
                        if (reservationArraySize == 0) {
                            availableHotels.add(new hotelReservation(HotelForAgency.hotels.get(i)));
                            availableHotels.get(avaHotels).assignAvailableRoom(HotelForAgency.hotels.get(i).singleRoom.get(j), tripStartDate, tripEndDate);
                            avaHotels++;
                            break;
                        } else {
                            for (int k = 0; k < reservationArraySize; k += 2) {
                                //case 1, the end date is before the first reservation
                                //case 2 , the start date is after the last reservation
                                //case 3 the date is cars between
                                //cars this case we check diTimes
                                //check conflicts instead of that
                                if (((k == 0) && (tripEndDate.isBefore(HotelForAgency.hotels.get(i).singleRoom.get(j).Reservations.get(k)))) ||
                                        (tripStartDate.isAfter(HotelForAgency.hotels.get(i).singleRoom.get(j).Reservations.get(k)) &&
                                                (tripEndDate.isBefore(HotelForAgency.hotels.get(i).singleRoom.get(j).Reservations.get(k + 1)))) ||
                                        ((k == reservationArraySize - 1) && (tripStartDate.isAfter(HotelForAgency.hotels.get(i).singleRoom.get(j).Reservations.get(k))))) {
                                    availableHotels.add(new hotelReservation(HotelForAgency.hotels.get(i)));
                                    availableHotels.get(avaHotels).assignAvailableRoom(HotelForAgency.hotels.get(i).singleRoom.get(j), tripStartDate, tripEndDate);
                                    avaHotels++;
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        } else if (ticket.getNumberOfSeats() == 2) {
            for (int i = 0; i < HotelForAgency.hotels.size(); i++) {
                if (HotelForAgency.hotels.get(i).getHotelLocation().equals(ticket.getTrip().getDestination())) {
                    for (int j = 0; i < HotelForAgency.hotels.get(i).getNumberOfDoubleRooms(); j++) {
                        int reservationArraySize = HotelForAgency.hotels.get(i).doubleRoom.get(j).Reservations.size();
                        if (reservationArraySize == 0) {
                            availableHotels.add(new hotelReservation(HotelForAgency.hotels.get(i)));
                            availableHotels.get(avaHotels).assignAvailableRoom(HotelForAgency.hotels.get(i).doubleRoom.get(j), tripStartDate, tripEndDate);
                            avaHotels++;
                            break;
                        } else {
                            for (int k = 0; k < reservationArraySize; k += 2) {
                                //case 1, the end date is before the first reservation
                                //case 2 , the start date is after the last reservation
                                //case 3 the date is cars between
                                //cars this case we check diTimes
                                if (((k == 0) && (tripEndDate.isBefore(HotelForAgency.hotels.get(i).doubleRoom.get(j).Reservations.get(k)))) ||
                                        (tripStartDate.isAfter(HotelForAgency.hotels.get(i).doubleRoom.get(j).Reservations.get(k)) &&
                                                (tripEndDate.isBefore(HotelForAgency.hotels.get(i).doubleRoom.get(j).Reservations.get(k + 1)))) ||
                                        ((k == reservationArraySize - 1) && (tripStartDate.isAfter(HotelForAgency.hotels.get(i).doubleRoom.get(j).Reservations.get(k))))) {
                                    availableHotels.add(new hotelReservation(HotelForAgency.hotels.get(i)));
                                    availableHotels.get(avaHotels).assignAvailableRoom(HotelForAgency.hotels.get(i).doubleRoom.get(j), tripStartDate, tripEndDate);
                                    avaHotels++;
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        } else {
            for (int i = 0; i < HotelForAgency.hotels.size(); i++) {

                int numberOfRoomsRequired;

                if ((ticket.getNumberOfSeats() % HotelForAgency.hotels.get(i).familyRoom.get(0).getRoomLimit()) == 0) {
                    numberOfRoomsRequired = ticket.getNumberOfSeats() / HotelForAgency.hotels.get(i).familyRoom.get(0).getRoomLimit();
                } else {
                    numberOfRoomsRequired = (ticket.getNumberOfSeats() / HotelForAgency.hotels.get(i).familyRoom.get(0).getRoomLimit()) + 1;
                }

                if (HotelForAgency.hotels.get(i).getHotelLocation().equals(ticket.getTrip().getDestination())) {
                    int counter = 0;
                    for (int j = 0; i < HotelForAgency.hotels.get(i).getNumberOfFamilyRooms(); j++) {
                        int reservationArraySize = HotelForAgency.hotels.get(i).familyRoom.get(j).Reservations.size();
                        if (reservationArraySize == 0) {
                            if (counter == 0) {
                                availableHotels.add(new hotelReservation(HotelForAgency.hotels.get(i)));
                            }

                            availableHotels.get(avaHotels).assignAvailableRoom(HotelForAgency.hotels.get(i).familyRoom.get(j), tripStartDate, tripEndDate, counter);
                            counter++;
                            if (counter >= numberOfRoomsRequired - 1) {
                                avaHotels++;
                                break;
                            }
                        } else {
                            for (int k = 0; k < reservationArraySize; k += 2) {
                                //case 1, the end date is before the first reservation
                                //case 2 , the start date is after the last reservation
                                //case 3 the date is cars between
                                //cars this case we check diTimes
                                if (((k == 0) && (tripEndDate.isBefore(HotelForAgency.hotels.get(i).familyRoom.get(j).Reservations.get(k)))) ||
                                        (tripStartDate.isAfter(HotelForAgency.hotels.get(i).familyRoom.get(j).Reservations.get(k)) &&
                                                (tripEndDate.isBefore(HotelForAgency.hotels.get(i).familyRoom.get(j).Reservations.get(k + 1)))) ||
                                        ((k == reservationArraySize - 1) && (tripStartDate.isAfter(HotelForAgency.hotels.get(i).familyRoom.get(j).Reservations.get(k))))) {
                                    if (counter == 0) {
                                        availableHotels.add(new hotelReservation(HotelForAgency.hotels.get(i)));
                                    }
                                    availableHotels.get(avaHotels).assignAvailableRoom(HotelForAgency.hotels.get(i).familyRoom.get(j), tripStartDate, tripEndDate, counter);
                                    counter++;
                                    if (counter >= numberOfRoomsRequired - 1) {
                                        avaHotels++;
                                        break;
                                    }
                                }
                            }
                        }
                    }
                    if (counter < numberOfRoomsRequired) {
                        availableHotels.remove(availableHotels.size() - 1);
                    }
                }
            }
        }
        return avaHotels;
    }

    public static int customerChooseHotel(ArrayList<hotelReservation> availableHotels, Ticket ticket) {
        int hotelChoice = -1;
        System.out.println("Choose the suitable hotel for you!");
        for (int i = 0; i < availableHotels.size(); i++) {
            availableHotels.get(i).displayHotelForBooking(i, ticket.getNumberOfSeats() > 2, ticket.getNumberOfSeats(), false);
        }
        System.out.println("Your Choice: ");
        hotelChoice = helpingMethods.choice(1, availableHotels.size());
        System.out.println("The hotel you chose: \n");
        availableHotels.get(hotelChoice - 1).displayHotelForBooking(hotelChoice - 1, ticket.getNumberOfSeats() > 2, ticket.getNumberOfSeats(), false);
        return hotelChoice;
    }

    public static void customerChooseFoodBoard(hotelReservation hotelChosen, Ticket ticket) {

        int mealNum = -1;
        System.out.println("Do you want to make changes on the food board ?");
        if (ticket.getNumberOfSeats() > 2) {
            System.out.println("***Note that: All rooms will have the same food board***");
        }
        char answer = in.next().charAt(0);
        int[] meals = new int[3]; //array list
        if (helpingMethods.confirm(answer)) {
            do {
                mealNum = -1;
                System.out.println("Enter how many meal do you want from the food board: [0-3] ");
                mealNum = helpingMethods.choice(0, 3);
                if (mealNum == 0) {
                    System.out.println(" Are you sure that you do not want any meal from the food board?");
                    answer = in.next().charAt(0);
                    if (helpingMethods.confirm(answer)) {
                        System.out.println(" Food board will be removed from the total price right now.");
                    }
                } else {
                    System.out.println("<< Food board>>\n 1. Breakfast \n 2. Lunch\n 3. Dinner \n Your choice: ");
                    for (int m = 0; m < mealNum; m++) {
                        System.out.println("Meal number " + m + 1 + " :");
                        meals[m] = helpingMethods.choice(1, 3) - 1;
                        /* he wants 2 meals  break 0 dinner 2 meal[0]=3-1=2   meal[1]=1-1=0 */
                    }
                    System.out.println("Do you want to confirm:");
                    answer = in.next().charAt(0);
                    if (helpingMethods.confirm(answer)) {
                        System.out.println("changes saved!\n");
                        hotelChosen.foodBoard(meals, ticket.getNumberOfSeats() > 2, ticket.getNumberOfSeats(), true);
                    } else {
                        System.out.println("changes not saved.\n 1. Choose again.\n2. Keep the three meals\n");
                        int change = helpingMethods.choice(1, 2);
                        if (change == 1) {
                            mealNum = 0;
                            answer = 'N';
                        } else {
                            meals[0] = 0;
                            meals[1] = 1;
                            meals[2] = 2;
                            hotelChosen.foodBoard(meals, ticket.getNumberOfSeats() > 2, ticket.getNumberOfSeats(), false);
                            System.out.println("All meals are kept.\n");
                            break;
                        }
                    }
                }
            } while ((mealNum == 0) && (!helpingMethods.confirm(answer)));
        } else {
            meals[0] = 0;
            meals[1] = 1;
            meals[2] = 2;
            hotelChosen.foodBoard(meals, ticket.getNumberOfSeats() > 2, ticket.getNumberOfSeats(), true);
            System.out.println("All meals are kept.\n");
        }

    }

    public static void saveHotelReservationForAgency(Ticket ticket) {
        ticket.HotelReservation = true;
        for (int h = 0; h < HotelForAgency.hotels.size(); h++) {
            if (HotelForAgency.hotels.get(h).getHotelID().equals(ticket.Hotel.getHotelID())) {
                switch (ticket.getNumberOfSeats()) {
                    case 1:
                        for (int r = 0; r < HotelForAgency.hotels.get(h).getNumberOfSingleRooms(); r++) {
                            if (HotelForAgency.hotels.get(h).singleRoom.get(r).getRoomId().equals(ticket.Hotel.roomAvailable.get(0).getRoomId())) {
                                HotelForAgency.hotels.get(h).singleRoom.get(r).addNewReservation(ticket.Hotel.startDate, ticket.Hotel.endDate);
                                break;
                            }
                        }
                        break;
                    case 2:
                        for (int r = 0; r < HotelForAgency.hotels.get(h).getNumberOfDoubleRooms(); r++) {
                            if (HotelForAgency.hotels.get(h).doubleRoom.get(r).getRoomId().equals(ticket.Hotel.roomAvailable.get(0).getRoomId())) {
                                HotelForAgency.hotels.get(h).doubleRoom.get(r).addNewReservation(ticket.Hotel.startDate, ticket.Hotel.endDate);
                                break;
                            }
                        }
                        break;
                    default:
                        for (int n = 0; n < ticket.Hotel.roomAvailable.size(); n++) {
                            for (int r = 0; r < HotelForAgency.hotels.get(h).getNumberOfFamilyRooms(); r++) {
                                if (HotelForAgency.hotels.get(h).familyRoom.get(r).getRoomId().equals(ticket.Hotel.roomAvailable.get(n).getRoomId())) {
                                    HotelForAgency.hotels.get(h).familyRoom.get(r).addNewReservation(ticket.Hotel.startDate, ticket.Hotel.endDate);
                                    break;
                                }
                            }
                        }
                }
            }
        }
    }

    public static void deleteHotelReservationForAgency(Ticket ticket) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate tripStartDate = LocalDate.parse(ticket.getTrip().getStartDate(), formatter);
        LocalDate tripEndDate = LocalDate.parse(ticket.getTrip().getEndDate(), formatter);
        ticket.HotelReservation = false;
        ticket.updateTicketPrice(ticket.Hotel.totalPayments * -1);
        for (int h = 0; h < HotelForAgency.hotels.size(); h++) {
            if (HotelForAgency.hotels.get(h).getHotelID().equals(ticket.Hotel.getHotelID())) {
                switch (ticket.getNumberOfSeats()) {
                    case 1:
                        for (int r = 0; r < HotelForAgency.hotels.get(h).getNumberOfSingleRooms(); r++) {
                            if (HotelForAgency.hotels.get(h).singleRoom.get(r).getRoomId().equals(ticket.Hotel.roomAvailable.get(0).getRoomId())) {
                                HotelForAgency.hotels.get(h).singleRoom.get(r).Reservations.remove(tripStartDate);
                                HotelForAgency.hotels.get(h).singleRoom.get(r).Reservations.remove(tripEndDate);
                                break;
                            }
                        }
                        break;
                    case 2:
                        for (int r = 0; r < HotelForAgency.hotels.get(h).getNumberOfDoubleRooms(); r++) {
                            if (HotelForAgency.hotels.get(h).doubleRoom.get(r).getRoomId().equals(ticket.Hotel.roomAvailable.get(0).getRoomId())) {
                                HotelForAgency.hotels.get(h).doubleRoom.get(r).Reservations.remove(tripStartDate);
                                HotelForAgency.hotels.get(h).doubleRoom.get(r).Reservations.remove(tripEndDate);
                                break;
                            }
                        }
                        break;
                    default:
                        for (int n = 0; n < ticket.Hotel.roomAvailable.size(); n++) {
                            for (int r = 0; r < HotelForAgency.hotels.get(h).getNumberOfFamilyRooms(); r++) {
                                if (HotelForAgency.hotels.get(h).familyRoom.get(r).getRoomId().equals(ticket.Hotel.roomAvailable.get(n).getRoomId())) {
                                    HotelForAgency.hotels.get(h).familyRoom.get(r).Reservations.remove(tripStartDate);
                                    HotelForAgency.hotels.get(h).familyRoom.get(r).Reservations.remove(tripEndDate);
                                    break;
                                }
                            }
                        }
                }
            }
        }
        ticket.Hotel = null;
    }

    public void assignAvailableRoom(singleRooms avaRoom, LocalDate start, LocalDate end) {
        roomAvailable.add(new basicRoomDetails());
        roomAvailable.get(0).setRoomId(avaRoom.getRoomId());
        roomAvailable.get(0).setRoomType(avaRoom.getRoomType());
        roomAvailable.get(0).setNumberOfBeds(avaRoom.getNumberOfBeds());
        roomAvailable.get(0).setRoomLimit(avaRoom.getRoomLimit());
        roomAvailable.get(0).setRoomPrice(avaRoom.getRoomPrice());
        roomAvailable.get(0).foodBoardPrice = avaRoom.foodBoardPrice;
        this.startDate = start;
        this.endDate = end;
        totalDaysOfTrip = ChronoUnit.DAYS.between(start, end);
    }

    public void assignAvailableRoom(doubleRooms avaRoom, LocalDate start, LocalDate end) {
        roomAvailable.add(new basicRoomDetails());
        roomAvailable.get(0).setRoomId(avaRoom.getRoomId());
        roomAvailable.get(0).setRoomType(avaRoom.getRoomType());
        roomAvailable.get(0).setNumberOfBeds(avaRoom.getNumberOfBeds());
        roomAvailable.get(0).setRoomLimit(avaRoom.getRoomLimit());
        roomAvailable.get(0).setRoomPrice(avaRoom.getRoomPrice());
        roomAvailable.get(0).foodBoardPrice = avaRoom.foodBoardPrice;
        this.startDate = start;
        this.endDate = end;
        totalDaysOfTrip = ChronoUnit.DAYS.between(start, end);
    }

    public void assignAvailableRoom(generalRooms avaRoom, LocalDate start, LocalDate end, int index) {
        roomAvailable.add(new basicRoomDetails());
        roomAvailable.get(index).setRoomId(avaRoom.getRoomId());
        roomAvailable.get(index).setRoomType(avaRoom.getRoomType());
        roomAvailable.get(index).setNumberOfBeds(avaRoom.getNumberOfBeds());
        roomAvailable.get(index).setRoomLimit(avaRoom.getRoomLimit());
        roomAvailable.get(index).setRoomPrice(avaRoom.getRoomPrice());
        roomAvailable.get(index).foodBoardPrice = avaRoom.foodBoardPrice;
        this.startDate = start;
        this.endDate = end;
        totalDaysOfTrip = ChronoUnit.DAYS.between(start, end);
    }

    public void displayHotelForBooking(int i, boolean familyRoom, int numberOfSeats, boolean confirmation) {
        System.out.println("___________________________________________________");
        if (!confirmation) {
            if (i < 9) {
                System.out.println("[0" + (i + 1) + "] " + this.getHotelName());
            } else {
                System.out.println("[" + (i + 1) + "] " + this.getHotelName());
            }
        } else {
            System.out.println("  >>>" + this.getHotelName() + "Hotel <<<");
        }
        System.out.println("___________________________________________________");
        System.out.println(" - Type: " + roomAvailable.get(0).getRoomType());
        System.out.println(" - Room Limit: " + roomAvailable.get(0).getRoomLimit());
        if (familyRoom && !confirmation) {
            System.out.println(" *You will be required to book " + numberOfRoomsRequired(numberOfSeats) + " rooms./n");
        }
        System.out.println(" - Room fees (without food board): " + roomAvailable.get(0).getRoomPrice() + " $ per day");
        System.out.println(" - Beds: " + roomAvailable.get(0).getNumberOfBeds() + " bed/s");
        System.out.println("___________________________________________________");
        System.out.println("            <Food board fees>");
        if (!confirmation) {
            System.out.println("*you can choose only one or two choices.");
        }

        System.out.println(" - Breakfast: " + roomAvailable.get(0).foodBoardPrice[0] + " $ per day");
        System.out.println(" - Lunch: " + roomAvailable.get(0).foodBoardPrice[1] + " $ per day");
        System.out.println(" - Dinner: " + roomAvailable.get(0).foodBoardPrice[2] + " $ per day");
        System.out.println("----------------------------------------------------");
        calculateTotalPriceForTotalPeriod(ChronoUnit.DAYS.between(startDate, endDate));
        System.out.println("====================================================");
        //OPTION :  write total price with and without food board
        // total = (room+ food)*no of rooms
    }

    public void foodBoard(int[] meals, boolean familyRoom, int numberOfSeats, boolean confirmation) {
// meal[0]=3-1=2
        for (int number : meals) {

            /*
            index    0 1,2,3
            array 1= 1 2 3 4
            array 2 = 1 2 3 4
             */
            this.finalFoodBoard[number] = roomAvailable.get(0).foodBoardPrice[number];
        }
        if (familyRoom && confirmation) {
            int numberOfRooms = numberOfRoomsRequired(numberOfSeats);
            for (int i = 1; i < numberOfRooms; i++) {
                roomAvailable.get(i).foodBoardPrice = this.finalFoodBoard;
            }
        } else if (confirmation) {
            roomAvailable.get(0).foodBoardPrice = this.finalFoodBoard;
        }
    }

    public int numberOfRoomsRequired(int numberOfSeats) {
        int numberOfRoomsRequired;
        if ((numberOfSeats % roomAvailable.get(0).getRoomLimit()) == 0) {
            numberOfRoomsRequired = numberOfSeats / roomAvailable.get(0).getRoomLimit();
        } else {
            numberOfRoomsRequired = (numberOfSeats / roomAvailable.get(0).getRoomLimit()) + 1;
        }
        return numberOfRoomsRequired;
    }

    //interface method
    public void calculateTotalPriceForTotalPeriod(long TotalDaysOfTrip) {
        double totalPriceForRoomPerDay = roomAvailable.get(0).getRoomPrice();
        for (int i = 0; i < 3; i++) {
            totalPriceForRoomPerDay += roomAvailable.get(0).foodBoardPrice[i];
        }
        this.totalPayments = TotalDaysOfTrip * (totalPriceForRoomPerDay * roomAvailable.size());
        System.out.println(" - Total price for room per day: " + totalPriceForRoomPerDay);
        System.out.println(" - Total price for all rooms per day: " + (totalPriceForRoomPerDay * roomAvailable.size()));
        System.out.println(" - Total payments for Whole days: " + totalPayments);
    }

}
