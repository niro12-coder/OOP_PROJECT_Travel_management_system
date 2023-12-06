package cis.travel.eg.Service.Hotels.HotelDetails;

import java.util.Scanner;

public class hotelRoom extends roomsForManager {
    @Override
    public void addRoomTypeDetails() {
        int choice;
        hotelRoom tempRoom = new hotelRoom();
        Scanner scanner= new Scanner(System.in);
        System.out.println("Do you want to use the standard details for the 3 room modes, or you will customize your hotel room details?");
        System.out.println("Note that: single and double rooms, pricing only can be customized, other details are constants/n");
        System.out.println("1- customize my hotel rooms /n 2- See standard details");
        do{
            choice = scanner.nextInt();
            if(choice!=1&&choice!=2){
                System.out.println("Invalid input, please enter 1 or 2/n");
            }
        }while(choice!=1&&choice!=2);
        switch (choice) {
            case 1: addRoomTypeDetails(tempRoom);
            break;
            case 2:
        }

    }
    public void addRoomTypeDetails(hotelRoom customeRoom) {
        System.out.println(" Hello,again! Please complete room details:");

    }
    @Override
    public void editRoomTypeDetails() {

    }
    public void displayDefaultRoomDetails(){
        System.out.println("These are the standard details for the 3 room modes:");
        System.out.println("1- Single Room:");
        System.out.println("Type: Single");
        System.out.println("Number of beds: 1");
        System.out.println("Limited count: 1 person/room");
        System.out.println(">> Food board price per day");
        System.out.println("breakfast: 5$");
        System.out.println("Lunch: 5$");
        System.out.println("Dinner: 5$");
        System.out.println("Snacks: 10$");
        System.out.println("------------------------------");

        System.out.println("2- Double Room:");
        System.out.println("Type: Double");
        System.out.println("Number of beds: 1");
        System.out.println("Limited count: 2 person/room");
        System.out.println(">> Food board price per day");
        System.out.println("breakfast: 10$");
        System.out.println("Lunch: 10$");
        System.out.println("Dinner: 10$");
        System.out.println("Snacks: 20$");
        System.out.println("------------------------------");

        System.out.println("3- Genaral Room:");
        System.out.println("Type: General");
        System.out.println("Number of beds: 2");
        System.out.println("Limited count: 4 person/room");
        System.out.println(">> Food board price per day");
        System.out.println("breakfast: 20$");
        System.out.println("Lunch: 20$");
        System.out.println("Dinner: 20$");
        System.out.println("Snacks: 40$");
        System.out.println("------------------------------");
    }
}
