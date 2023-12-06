package cis.travel.eg.Service.Hotels.person;

import cis.travel.eg.Service.Hotels.Reservation.hotelReservation;
import cis.travel.eg.Service.otherClasses.helpingMethods;
import cis.travel.eg.Service.otherClasses.ticket;

import java.util.ArrayList;
import java.util.Scanner;


public class customer {

    public static void bookHotelRoom(ticket ticket) {
        helpingMethods methods=new helpingMethods(); //make it static
        Scanner in= new Scanner(System.in);
        int mealNum=-1;
//        int hotelCounter=0; //for family mode
        //hotels array in person.manager class
        //start and end of the trip
        ArrayList<hotelReservation> availableHotels = new ArrayList<>();
        int avaHotels=0;
        int hotelChoice=-1;
        if (ticket.numberOfSeats == 1) {
            for (int i = 0; i < manager.hotels.size(); i++) {
                if(manager.hotels.get(i).hotelLocation.equals(ticket.trip.Location)){
                    for (int j = 0; i < manager.hotels.get(i).numberOfSingleRooms; j++)
                    {
                        int reservationArraySize= manager.hotels.get(i).singleRoom.get(j).Reservations.size();
                        if(reservationArraySize==0){
                            availableHotels.add(new hotelReservation(manager.hotels.get(i)));
                            availableHotels.get(avaHotels).assignAvailableRoom(manager.hotels.get(i).singleRoom.get(j),ticket.trip.start,ticket.trip.end);
                            avaHotels++;
                            break;
                        }
                        else {
                            for (int k = 0; k < reservationArraySize; k+=2) {
                                //case 1, the end date is before the first reservation
                                //case 2 , the start date is after the last reservation
                                //case 3 the date is in between
                                //in this case we check diTimes
                                //check conflicts instead of that
                                if( ((k==0)&&(ticket.trip.end.isBefore( manager.hotels.get(i).singleRoom.get(j).Reservations.get(k))))||
                                        (ticket.trip.start.isAfter( manager.hotels.get(i).singleRoom.get(j).Reservations.get(k))&&
                                                (ticket.trip.end.isBefore( manager.hotels.get(i).singleRoom.get(j).Reservations.get(k+1))))||
                                        ((k== reservationArraySize-1) &&(ticket.trip.start.isAfter( manager.hotels.get(i).singleRoom.get(j).Reservations.get(k)))) ){
                                    availableHotels.add(new hotelReservation(manager.hotels.get(i)));
                                    availableHotels.get(avaHotels).assignAvailableRoom(manager.hotels.get(i).singleRoom.get(j),ticket.trip.start,ticket.trip.end);
                                    avaHotels++;
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }
        else if (ticket.numberOfSeats == 2){
            for (int i = 0; i < manager.hotels.size(); i++) {
                if(manager.hotels.get(i).hotelLocation.equals(ticket.trip.Location)){
                    for (int j = 0; i < manager.hotels.get(i).numberOfDoubleRooms; j++)
                    {
                        int reservationArraySize= manager.hotels.get(i).doubleRoom.get(j).Reservations.size();
                        if(reservationArraySize==0){
                            availableHotels.add(new hotelReservation(manager.hotels.get(i)));
                            availableHotels.get(avaHotels).assignAvailableRoom(manager.hotels.get(i).doubleRoom.get(j),ticket.trip.start,ticket.trip.end);
                            avaHotels++;
                            break;
                        }
                        else {
                            for (int k = 0; k < reservationArraySize; k+=2) {
                                //case 1, the end date is before the first reservation
                                //case 2 , the start date is after the last reservation
                                //case 3 the date is in between
                                //in this case we check diTimes
                                if( ((k==0)&&(ticket.trip.end.isBefore( manager.hotels.get(i).doubleRoom.get(j).Reservations.get(k))))||
                                        (ticket.trip.start.isAfter( manager.hotels.get(i).doubleRoom.get(j).Reservations.get(k))&&
                                                (ticket.trip.end.isBefore( manager.hotels.get(i).doubleRoom.get(j).Reservations.get(k+1))))||
                                        ((k== reservationArraySize-1) &&(ticket.trip.start.isAfter( manager.hotels.get(i).doubleRoom.get(j).Reservations.get(k)))) ){
                                    availableHotels.add(new hotelReservation(manager.hotels.get(i)));
                                    availableHotels.get(avaHotels).assignAvailableRoom(manager.hotels.get(i).doubleRoom.get(j),ticket.trip.start,ticket.trip.end);
                                    avaHotels++;
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }
        else {
            for (int i = 0; i < manager.hotels.size(); i++) {

                int numberOfRoomsRequired;

                if((ticket.numberOfSeats%manager.hotels.get(i).familyRoom.get(0).roomLimit)==0){
                    numberOfRoomsRequired=ticket.numberOfSeats/manager.hotels.get(i).familyRoom.get(0).roomLimit;
                } else {   numberOfRoomsRequired=(ticket.numberOfSeats/manager.hotels.get(i).familyRoom.get(0).roomLimit)+1; }

                if(manager.hotels.get(i).hotelLocation.equals(ticket.trip.Location)){
                    int counter=0;
                    for (int j = 0; i < manager.hotels.get(i).numberOfFamilyRooms; j++)
                    {
                        int reservationArraySize= manager.hotels.get(i).familyRoom.get(j).Reservations.size();
                        if(reservationArraySize==0){
                            if(counter==0){ availableHotels.add(new hotelReservation(manager.hotels.get(i)));}

                            availableHotels.get(avaHotels).assignAvailableRoom(manager.hotels.get(i).familyRoom.get(j),ticket.trip.start,ticket.trip.end,counter);
                            counter++;
                            if(counter>=numberOfRoomsRequired-1){
                                avaHotels++;
                                break;
                            }
                        }
                        else {
                            for (int k = 0; k < reservationArraySize; k+=2) {
                                //case 1, the end date is before the first reservation
                                //case 2 , the start date is after the last reservation
                                //case 3 the date is in between
                                //in this case we check diTimes
                                if(  ((k==0)&&(ticket.trip.end.isBefore( manager.hotels.get(i).familyRoom.get(j).Reservations.get(k))))||
                                     (ticket.trip.start.isAfter( manager.hotels.get(i).familyRoom.get(j).Reservations.get(k))&&
                                     (ticket.trip.end.isBefore( manager.hotels.get(i).familyRoom.get(j).Reservations.get(k+1))))||
                                     ((k== reservationArraySize-1) &&(ticket.trip.start.isAfter( manager.hotels.get(i).familyRoom.get(j).Reservations.get(k)))) )
                                {
                                        if(counter==0){ availableHotels.add(new hotelReservation(manager.hotels.get(i)));}
                                        availableHotels.get(avaHotels).assignAvailableRoom(manager.hotels.get(i).familyRoom.get(j),ticket.trip.start,ticket.trip.end,counter);
                                        counter++;
                                        if(counter>=numberOfRoomsRequired-1){
                                            avaHotels++;
                                            break;
                                        }
                                }
                            }
                        }
                    }
                    if(counter<numberOfRoomsRequired){ availableHotels.remove(availableHotels.size()-1);}
                }
            }
        }
        ///////////////////////// //  CHOOSING HOTEL STAGE (GENERAL STEP FOR ALL ROOM TYPES  /////////////////////////////////////////
        if(avaHotels==0){
            System.out.println("No available hotels right now");
            return;
        }
        else {
            ////////////// IF HOTELS ARE AVAILABLE ///////////////
                System.out.println("Choose the suitable hotel for you!");
                for(int i = 0 ;i<availableHotels.size();i++ ) {
                    availableHotels.get(i).displayAndChooseHotel(i, ticket.numberOfSeats > 2,ticket.numberOfSeats,false);
                }
                System.out.println("Your Choice: ");
                hotelChoice= helpingMethods.choice(1,availableHotels.size());
                System.out.println("The hotel you chose: /n");
                availableHotels.get(hotelChoice-1).displayAndChooseHotel(hotelChoice-1,ticket.numberOfSeats > 2,ticket.numberOfSeats,false);
        ///////////////////////// //  CHOOSING HOTEL STAGE END (GENERAL STEP FOR ALL ROOM TYPES) /////////////////////////////////////////

            ///////////////////////// //  FOOD BOARD STAGE (GENERAL STEP FOR ALL ROOM TYPES)  /////////////////////////////////////////

            System.out.println("Do you want to change the food board ?");
            if( ticket.numberOfSeats>2){
                System.out.println("***Note that: All rooms will have the same food board***");
            }
            char answer= in.next().charAt(0);
            int[] meals=new int[3]; //array list
            if(methods.confirm(answer)){
                do {
                    mealNum=-1;
                    System.out.println("Enter how many meal do you want from the food board: [1-3] ");
                    mealNum = helpingMethods.choice(0, 3);
                    if (mealNum == 0) {
                        System.out.println(" Are you sure that you do not want any meal from the food board?");
                        answer = in.next().charAt(0);
                        if (methods.confirm(answer)) {
                            System.out.println(" Food board will be removed from the total price right now.");
                        }
                    }
                    else {
                        System.out.println("<< Food board>>/n 1. Breakfast /n 2. Lunch/n 3. Dinner /n Your choice: ");
                        for(int m=0;m<mealNum;m++){
                            System.out.println("Meal number: ");
                            meals[m]= helpingMethods.choice(1,3)-1;
                            /* he wants 2 meals  break 0 dinner 2 meal[0]=3-1=2   meal[1]=1-1=0 */
                        }
                        System.out.println("Do you want to confirm:");
                        answer = in.next().charAt(0);
                        if (methods.confirm(answer)) {
                            System.out.println("changes saved!/n");
                            availableHotels.get(hotelChoice - 1).foodBoard(meals,ticket.numberOfSeats > 2,ticket.numberOfSeats, true);
                        }
                        else {
                            System.out.println("changes not saved./n 1. Choose again./n2. Keep all meals/n");
                            int change= helpingMethods.choice(1, 2);
                            if(change ==1){
                                mealNum=0;
                                answer='N';
                            }
                            else {
                                meals[0]=0;
                                meals[1]=1;
                                meals[2]=2;
                                availableHotels.get(hotelChoice - 1).foodBoard(meals,ticket.numberOfSeats > 2,ticket.numberOfSeats,false);
                                System.out.println("Changes not saved, all meals are kept./n");
                                break;
                            }
                        }
                    }
                }while((mealNum==0) && (!methods.confirm(answer)));
            } else {
                meals[0]=0;
                meals[1]=1;
                meals[2]=2;
                availableHotels.get(hotelChoice - 1).foodBoard(meals,ticket.numberOfSeats > 2,ticket.numberOfSeats,true);
                System.out.println("All meals are kept./n");
            }
            ///////////////////////// //  FOOD BOARD STAGE END (GENERAL STEP FOR ALL ROOM TYPES) /////////////////////////////////////////
        }
                            ///////////////// BOOKING CONFIRMATION ////////////////////////////
        System.out.println(" Choosing booking details have ended successfully");
        System.out.println(" Here is your booking details");
        availableHotels.get(hotelChoice - 1).displayAndChooseHotel(-1,ticket.numberOfSeats > 2,ticket.numberOfSeats,true);
        System.out.println(" Do you want to confirm? (Y/N)");
        if (methods.confirm(in.next().charAt(0))){
            ticket.hotelReservation= true;
            ticket.Hotel=availableHotels.get(hotelChoice - 1);
            ticket.price+=availableHotels.get(hotelChoice - 1).totalPayments;
            System.out.println("_____________________________________________");
            System.out.println("     BOOKING HAS BEEN MADE SUCCESSFULLY");
            System.out.println("_____________________________________________");

         hotelReservation.saveReservation(ticket);
        }
                          ///////////////// BOOKING CONFIRMATION END STAGE ////////////////////////////
    }
}
