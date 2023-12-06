package cis.travel.eg.User.TourGuide;

import cis.travel.eg.Main.Main;
import cis.travel.eg.Trip.Couple_Tour;
import cis.travel.eg.Trip.Family_Tour;
import cis.travel.eg.Trip.General_Tour;
import cis.travel.eg.Trip.Trip;
import cis.travel.eg.User.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class TourGuide extends User implements TourGuideFunctionalities {

    Scanner in = new Scanner(System.in);
    private String country;
    private ArrayList<Trip> History_Current_trips;
    private ArrayList<Trip> Complainttrips;
    private final ArrayList<String> LanguageOptions= new ArrayList<>(Arrays.asList("English","Arabic","Spanish","French","Deutsch","Hindi"));
    private ArrayList<String> Languages = new ArrayList<String>();
    private double salary;

    private double Salary_per_day;

    public TourGuide() {
        super();
        country=null;

    }

    public ArrayList<Trip> getHistorytrips() {

        return History_Current_trips;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setHistorytrips(ArrayList<Trip> historytrips) {
        History_Current_trips = historytrips;
    }

    public void setComplainttrips(ArrayList<Trip> complainttrips) {
        Complainttrips = complainttrips;
    }

    public double getSalary() {
        return salary;
    }


    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getSalary_per_day() {
        return Salary_per_day;
    }

    public void setSalary_per_day(double salary_per_day) {
        Salary_per_day = salary_per_day;
    }

    public ArrayList<Trip> getComplainttrips() {

        return Complainttrips;
    }

    static public int Is_login_successfully(String username, String password, ArrayList<TourGuide> guide) {
        for (int i = 0; i < guide.size(); i++) {
            TourGuide guides = guide.get(i);
            if (guides.getUsername().equals(username) && guides.getPassword().equals(password)) {
                return i;
            }
        }
        return -1;
    }

    void Display_languages_choose()
    {
        // if used in edit, make sure to empty the Languages array!!
        System.out.println("   ╔═══════════════════════════════════════════╗");
        System.out.println("   ║    " + Main.ANSI_COLORS[13] + "  Choose_Languages: "+ Main.ANSI_COLORS[16]+"║");
        System.out.println("   ╠═══════════════════════════════════════════╣");
        int i=1;
        for(String language: LanguageOptions)
        {
            System.out.println("   ║    "+i+")"+language+"  ║");
            i++;
        }
        System.out.println("   ╚═══════════════════════════════════════════╝");

        System.out.println("Enter number of Languages you wish to choose: ");
        int number=Main.Input(1,LanguageOptions.size());

        while(number!=0)
        {
             int choice=Main.Input(1,LanguageOptions.size());
             if(Languages.contains(LanguageOptions.get(choice-1)))
             {
                 System.out.println("You already chose it before!");
             }
             else {
                 number--;
                 Languages.add(LanguageOptions.get(choice-1));
             }
        }

    }

    public void Register(ArrayList<Admin> Admins, ArrayList<Customer> Customers, ArrayList<Manager> Managers, ArrayList<TourGuide> TourGuides) {

        System.out.print("Enter your first name: ");
        super.setFirstName(in.next());
        System.out.print("Enter your last name: ");
        super.setLastName(in.next());
        while(true) {
            System.out.print("Enter username: ");
            String user = in.next();
            if(!super.setUsername(user, Admins, Customers, Managers, TourGuides)) {
                System.out.println("Username already Used");
            }else break;
        }
        super.Password="123";
/*        while(true) {
            System.out.print("Enter password: ");
            String p1=in.next();
            System.out.print("Enter password again: ");
            String p2=in.next();
            if(super.setPassword(p1,p2))
            {
                break;
            }
        }

        while(true) {
           System.out.print("Enter your PhoneNumber: ");
            if(super.setPhoneNumber(in.next()))
            {
                break;
            }
        }

        while(true) {
            System.out.print("Enter your Email: ");
            if(!super.setEmail(in.next()))
            {
                System.out.println("Invalid email!");
            }else break;
        }
*/
        while(true) {
            System.out.print("Enter your Age: ");
            if(super.setAge(in.nextInt())) break;
        }

        while(true){

            System.out.print("Enter your Gender (f/m): ");
             String gender= in.next();
             gender=gender.toLowerCase();
            if(gender.equals("f") || gender.equals("m"))
            {
                super.setGender(gender.charAt(0));
                break;
            }else {
                System.out.println("invalid input");
            }

        }
        System.out.print("Enter your Country: ");
        super.setLastName(in.next());
        System.out.print("Enter your Salary per day: ");
        setSalary_per_day(in.nextDouble());

        Display_languages_choose();

    }

    @Override
    public boolean HomePage(ArrayList<Admin> Admins, ArrayList<Customer> Customers, ArrayList<TourGuide> TourGuides, ArrayList<Manager> Managers, ArrayList<Trip> Trips_system) {

        System.out.println("   ╔═══════════════════════════════════════════╗");
        System.out.println("   ║    " + Main.ANSI_COLORS[13] + "  Welcome " + super.getFirstName() + Main.ANSI_COLORS[16]+"║");
        System.out.println("   ╠═══════════════════════════════════════════╣");
        System.out.println("   ║    1)View trips (accept or decline them)  ║");
        System.out.println("   ║    2)update travel history                ║");
        System.out.println("   ║    3)view statistics of salary monthly    ║");
        System.out.println("   ║    4)view profile                         ║");
        System.out.println("   ║    5)edit profile                         ║");
        System.out.println("   ║    6)logout                               ║");
        System.out.println("   ║    7)exit                                 ║");
        System.out.println("   ║                                           ║");
        System.out.println("   ╚═══════════════════════════════════════════╝");


        int Int_theReturn =1;

       int choice=Main.Input(1,7);

       switch (choice){
           case 1:
               Int_theReturn=ViewTrips_Complaints();
               break;
           case 2:
               Int_theReturn=update_TravelHistory();
               break;
           case 3:
               Int_theReturn=view_statistics_SalaryMonthly();
               break;
           case 4:
               Int_theReturn=Display_Profile(Admins, Customers,  Managers, TourGuides);
               break;
           case 5:
               Int_theReturn=Edit_Profile( Admins, Customers, Managers, TourGuides);
               break;
           case 6:
               Int_theReturn=0;
               break;
           case 7:
               Int_theReturn=1;
               break;
       }

       if(Int_theReturn==0)
       {
           return false;
       }
       else if(Int_theReturn==1) return true;
       else return this.HomePage(Admins,Customers,TourGuides,Managers,Trips_system);  //uncertain

    }


    public int Logout_exist()
    {

        System.out.println("   ╔══════════════════════════╗");
        System.out.println("   ║    1)Return to Homepage  ║");
        System.out.println("   ║    2)Logout              ║");
        System.out.println("   ║    3)Exit                ║");
        System.out.println("   ╚══════════════════════════╝");

        int choice=Main.Input(1,3);

        if(choice==3) return 3;
        else if(choice==2) return 0;
        else return 1;
    }
    @Override
    public int Display_Profile(ArrayList<Admin> admin, ArrayList<Customer> customer, ArrayList<Manager> manager, ArrayList<TourGuide> tourguide) {

         ///donot display trips, it's useless, we got view trips options, we only want to display account  info
        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("**********WELCOME**********");
        System.out.println("your first name " + super.getFirstName());
        System.out.println("-----------------------------------------");
        System.out.println("your last name " + super.getLastName());
        System.out.println("-----------------------------------------");
        System.out.println("your country " + getCountry());
        System.out.println("╚═══════════════════════════════════════════╝");

        //will go to edit info from the scenario told me.

        return 0;
    }

    @Override
    public int Edit_Profile(ArrayList<Admin> admin, ArrayList<Customer> customer, ArrayList<Manager> manager, ArrayList<TourGuide> tourguide) {
        String choice,fname,lname,country,pass1,pass2;
        int option,age;
        do {
            System.out.println("welcome " + super.getUsername());
            System.out.println("choose which option you want to change ");
            System.out.println(" 1)  first name \n2) Last name \n 3) Password \n 4) Country \n  5) Age \n");
            option = in.nextInt();
            switch(option){
                case 1 :
                    System.out.println("please enter your first name ");
                    fname=in.next();
                    super.setFirstName(fname);//????????????
                    System.out.println("Done successfully "+super.getFirstName());
                    break;
                case 2:
                    System.out.println("please enter your last name ");
                    lname=in.next();
                    super.setLastName(lname);
                    System.out.println("Done successfully "+super.getLastName());
                    break;
                case 3:
                    System.out.println("please enter your new password");
                    pass1=in.next();
                    System.out.println("Write again");
                    pass2=in.next();
                    super.setPassword(pass1,pass2);
                    System.out.println("Done successfully ");
                    break;
                case 4:
                    System.out.println("please enter your new country ");
                    country=in.next();
                    setCountry(country);
                    System.out.println("Done successfully your new country now is "+getCountry());
                    break;
                case 5:
                    System.out.println("please enter your age ");
                    age=in.nextInt();
                    super.setAge(age);
                    System.out.println("Done successfully");
                    break;
                default:
                    System.out.println(" invalid choice try again ");
                    option=in.nextInt();
            }
            System.out.println("Do you want to make another change ? ");
            choice = in.next();
        }while(choice.equalsIgnoreCase("yes"));

        //check it out and tell mariam gharib to add trips array in abstract method in user
         return Logout_exist();

    }

    static public int FoundUsername(String username, ArrayList<TourGuide> guides) {
        return IntStream.range(0,guides.size())
                .filter(i ->guides.get(i).getUsername().equals(username))
                .findFirst()
                .orElse(-1);
    }


   public double calculateMonthlySalary(int year, int month,ArrayList<Trip> History_Current_trips) {
        double monthlySalary=0.0;
       for (Trip trip : History_Current_trips) {
           LocalDate startDate = LocalDate.parse(trip.getStartDate());
           LocalDate endDate = LocalDate.parse(trip.getEndDate());
           int tripYear = endDate.getYear();
           int tripMonth = endDate.getMonthValue();

           long  tripNumberOfDays;
           tripNumberOfDays = Trip.calculateDaysBetweenDates(startDate,endDate);


           if (tripYear == year && tripMonth == month) {
                monthlySalary+=tripNumberOfDays*this.salary;
           }
       }
       return monthlySalary;
   }

   public int view_statistics_SalaryMonthly(){
       double maxSalary = Integer.MIN_VALUE;
       LocalDate currentDate = LocalDate.now();
       int currentYear = currentDate.getYear();
       int currentMonth = currentDate.getMonthValue();
       int year = currentYear;
       int month = currentMonth;
       char seeAnotheextInt;
       do {
           // Find the maximum salary among the months
           for (int i = 0; i < 12; i++) {
               double monthlySalary = calculateMonthlySalary(year, i + 1, History_Current_trips);
               if (monthlySalary > maxSalary) {
                   maxSalary = monthlySalary;
               }
           }
           ArrayList<String> months = new ArrayList<>(Arrays.asList("Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"));
           // Display the visually enhanced horizontal bar chart
           System.out.println("Monthly Salary Statistics for "+year+" :");
           for (int i = 0; i < month; i++) {
               String monthName = months.get(i);
               double monthlySalary = calculateMonthlySalary(year, i + 1, History_Current_trips);
               int barLength = (int) (100.0 * monthlySalary / maxSalary); //if you want the bars to be longer increase the number

               System.out.printf("%10s ║", monthName);

               // Print spaces for alignment
               for (int j = 0; j < 3; j++) {
                   System.out.print(" ");
               }

               // Print the bar chart using ASCII characters between the name and salary
               for (int j = 0; j < barLength; j++) {
                   if (i % 3 == 0) {
                       System.out.print("█");
                   } else if (i % 3 == 1) {
                       System.out.print("▓");
                   } else {
                       System.out.print("▒");
                   }
               }
               System.out.println("    $" + salary);
           }
           System.out.println("           ══════════════════════════════════════════════════════════════════════════════════════════════════");
           System.out.println("If you want to see the salary statistics of another year enter 'y' or 'Y'.");
           seeAnotheextInt = in.next().charAt(0);
           if (seeAnotheextInt == 'Y' || seeAnotheextInt=='y'){
               System.out.println("Enter the year :");
               year=in.nextInt();
               month=12;
           }
       }while (seeAnotheextInt == 'Y' || seeAnotheextInt=='y');
       return Logout_exist();
   }



   public int update_TravelHistory(){
       LocalDate currentDate = LocalDate.now();

       System.out.println("   ╔═══════════════════════════╗");
       System.out.println("   ║    1)View last 4 trips    ║");
       System.out.println("   ║    2)View All trips       ║");
       System.out.println("   ║    3)View by date of trip ║");
       System.out.println("   ║    4)View by Type of trip ║");
       System.out.println("   ║    5)Clear history        ║");
       System.out.println("   ╚═══════════════════════════╝");

       int choice = Main.Input(1, 5);

       switch (choice) {

           case 1:

               int number = 4;
               for (int i = History_Current_trips.size() - 1; i >= 0; i--) {
                   History_Current_trips.get(i).displayDetails();
                   number--;
                   if (number == 0) break;
               }

               if (number == 4) System.out.println("History is empty.");

               break;
           case 2:
               for (int i = History_Current_trips.size() - 1; i >= 0; i--) {
                   History_Current_trips.get(i).displayDetails();
               }

               break;
           case 3:

               System.out.print("Enter Month number: ");
               int Month =Main.Input(1,12);

               System.out.print("Enter Year number: ");
               int Year =Main.Input(1000,3000);


               for (Trip trip:History_Current_trips) {

                   LocalDate startDate = LocalDate.parse(trip.getStartDate());
                   LocalDate endDate = LocalDate.parse(trip.getEndDate());
                   int tripYear = endDate.getYear();
                   int tripMonth = endDate.getMonthValue();

                   if (tripYear == Year && tripMonth == Month) {
                      trip.displayDetails();
                   }

               }

               break;
           case 4:

               System.out.println("   ╔═══════════════════════════╗");
               System.out.println("   ║    1)Couple Tours         ║");
               System.out.println("   ║    2)Family Tours         ║");
               System.out.println("   ║    3)General Tours        ║");
               System.out.println("   ╚═══════════════════════════╝");

               int TripType = Main.Input(1, 3);


               for (Trip trip : History_Current_trips) {

                   if (trip instanceof Couple_Tour && TripType == 1) {
                       trip.displayDetails();
                   } else if (trip instanceof Family_Tour && TripType == 2) {
                       trip.displayDetails();
                   } else if (trip instanceof General_Tour && TripType == 3) {
                       trip.displayDetails();
                   }
               }

               break;
           case 5:

               for (int i = History_Current_trips.size() - 1; i >= 0; i--) {

                   LocalDate endDate = LocalDate.parse(History_Current_trips.get(i).getEndDate());
                   if (endDate.isBefore(currentDate)) {
                       History_Current_trips.remove(i);
                   }

               }
               System.out.println("Everything has been successfully cleared!!");
               break;

       }


       System.out.print("Do you wish do another operation? 1-->yes | 0-->No");
       choice = Main.Input(0, 1);
       if (choice == 1) return this.update_TravelHistory();
       else return Logout_exist();
   }

   //count the available tour guides for the next week
    public int Number_availableGuides(ArrayList<TourGuide> TourGuides){
        LocalDate currentDate = LocalDate.now();
        LocalDate afterWeekDate = currentDate.plusWeeks(1);
        long count = TourGuides.stream()
                .filter(tourGuide -> tourGuide.isAvailable(currentDate.toString(),afterWeekDate.toString()))
                .count();

        return (int) count;
    }

    //count the available tour guides for a certain trip
    public int Number_availableGuides(Trip trip, ArrayList<TourGuide> TourGuides){

       long count = TourGuides.stream()
               .filter(tourGuide -> tourGuide.isAvailable(trip.getStartDate(), trip.getEndDate()))
               .count();

       return (int) count;
   }

    public boolean isAvailable(String startDate, String endDate){
        LocalDate tripStartDate = LocalDate.parse(startDate);
        LocalDate tripEndDate = LocalDate.parse(endDate);
        for (Trip trip : History_Current_trips) {
            LocalDate guideTripStartDate = LocalDate.parse(trip.getStartDate());
            LocalDate guideTripEndDate = LocalDate.parse(trip.getEndDate());
            if (!(tripEndDate.isBefore(guideTripStartDate) || tripStartDate.isAfter(guideTripEndDate))){
                return false;
            }
        }
        return true;
    }

    public int ViewTrips_Complaints()
    {
        LocalDate currentDate = LocalDate.now();
        ArrayList<Integer> indexs_Current_trips= new ArrayList<>();
        int counter_display=1,index_in_Array=0;

        for (Trip trip : History_Current_trips) {

            LocalDate startDate = LocalDate.parse(trip.getStartDate());

            if (startDate.isAfter(currentDate)) {
                System.out.print(counter_display + ")");
                trip.displayDetails();
                indexs_Current_trips.add(index_in_Array);
                counter_display++;
            }
            index_in_Array++;
        }

        System.out.println("   ╔═══════════════════════════╗");
        System.out.println("   ║    1)Complaint on a trip  ║");
        System.out.println("   ║    2)Exit page            ║");
        System.out.println("   ╚═══════════════════════════╝");

        int choice=Main.Input(1,2);

        if(choice==1)
        {
            int number;
            while (true) {

                System.out.print("Enter the number of trips that you have a problem with: ");
                 number = Main.Input(1, indexs_Current_trips.size());
                if(number!=indexs_Current_trips.size())
                {
                    break;
                }else {
                    System.out.println("Constantly griping on every journey doesn't exactly scream 'tour guide extraordinaire' now, does it? :3");
                }
            }

            while(number!=0)
            {
                int index=Main.Input(1,indexs_Current_trips.size());

                if(getComplainttrips().contains(History_Current_trips.get(indexs_Current_trips.get(index))))
                {
                    System.out.println("it already exists!");
                }
                else {
                    number--;
                    getComplainttrips().add(History_Current_trips.get(indexs_Current_trips.get(index)));
                }

            }

        }

        return Logout_exist();
    }


    public void setLanguages(ArrayList<String> languages) {
        Languages = languages;
    }
}