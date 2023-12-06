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
    private ArrayList<Trip> Historytrips;
    private ArrayList<Trip> Complainttrips;
    private ArrayList<String> LanguageOptions= new ArrayList<>(Arrays.asList("English","Arabic","Spanish","French","Deutsch","Hindi"));
    private ArrayList<String> Languages;
    private double salary;

    private double Salary_per_day;

    public TourGuide() {
        super();
        country=null;
    }

    public ArrayList<Trip> getHistorytrips() {

        return Historytrips;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setHistorytrips(ArrayList<Trip> historytrips) {
        Historytrips = historytrips;
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
             if(LanguageOptions.contains(LanguageOptions.get(choice-1)))
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
        while(true) {

            System.out.print("Enter password: ");
            String pass;
            if(super.setPassword(in.next(), in.next()))
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
               Int_theReturn=ViewTripsWithApproval();
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


    public int Logout_exist(ArrayList<Admin> Admins, ArrayList<Customer> Customers, ArrayList<TourGuide> TourGuides, ArrayList<Manager> Managers, ArrayList<Trip> Trips_system)
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

         ///donot display trips, its useless, we got view trips options, we only want to display account  info
        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("**********WELCOME**********");
        System.out.println("your first name " + super.getFirstName());
        System.out.println("-----------------------------------------");
        System.out.println("your last name " + super.getLastName());
        System.out.println("-----------------------------------------");
        System.out.println("your country " + getCountry());
        System.out.println("╚═══════════════════════════════════════════╝");

        //will go to edit info from the scenario told to me.

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
        }while(choice.toLowerCase().equals("yes"));

        //check it out and tell mariam gharib to add trips array in abstract method in user
         return Logout_exist( admin,  customer, tourguide,manager,Trips_System);

    }

    static public int FoundUsername(String username, ArrayList<TourGuide> guides) {
        return IntStream.range(0,guides.size())
                .filter(i ->guides.get(i).getUsername().equals(username))
                .findFirst()
                .orElse(-1);
    }


   public double calculateMonthlySalary(int year, int month,ArrayList<Trip> Trips) {
        double monthlySalary=0.0;
       for (Trip trip : Trips) {
           LocalDate startDate = LocalDate.parse(trip.getStartDate());
           LocalDate endDate = LocalDate.parse(trip.getEndDate());
           int tripYear = endDate.getYear();
           int tripMonth = endDate.getMonthValue();

           long  tripNumberOfDays;
           tripNumberOfDays = trip.calculateDaysBetweenDates(startDate,endDate);


           if (tripYear == year && tripMonth == month) {
                monthlySalary+=tripNumberOfDays*this.salary;
           }
       }
       return monthlySalary;
   }

   public int view_statistics_SalaryMonthly(int year, ArrayList<Trip>Trips){
       double maxSalary = Integer.MIN_VALUE;

       // Find the maximum salary among the monthes
       for (int i = 0; i < 12; i++ ) {
           double monthlySalary = calculateMonthlySalary(year,0,Trips);
           if (monthlySalary > maxSalary) {
               maxSalary = monthlySalary;
           }
       }
        ArrayList<String> monthes=new ArrayList(Arrays.asList("Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"));
       // Display the visually enhanced horizontal bar chart
       System.out.println("Monthly Salary Statistics for You:");
       for (int i =0 ; i < 12; i++ ) {
           String month =monthes.get(i);
           double salary = calculateMonthlySalary(year,0,Trips);
           int barLength = (int) (40.0 * salary / maxSalary);

           System.out.printf("%-10s |", month);

           // Print spaces for alignment
           for (int j = 0; j < 3; j++) {
               System.out.print(" ");
           }

           // Print the bar chart using ASCII characters between the name and salary
           for (int j = 0; j < barLength; j++) {
               System.out.print("█"); // You can use any character for the bar, e.g., '=' or '█'
           }

           System.out.println(" $" + salary);
       }
   }



   public int update_TravelHistory(ArrayList<Admin> Admins, ArrayList<Customer> Customers, ArrayList<TourGuide> TourGuides, ArrayList<Manager> Managers, ArrayList<Trip> Trips_system) {

       LocalDate currentDate= LocalDate.now();

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
               for (int i =Historytrips.size() - 1; i >= 0; i--) {
                   Historytrips.get(i).displayDetails();
                   number--;
                   if (number == 0) break;
               }

               if(number==4) System.out.println("History is empty.");

               break;
           case 2:
               for (int i =Historytrips.size() - 1; i >= 0; i--) {
                   Historytrips.get(i).displayDetails();
               }

               break;
           case 3:





               break;
           case 4:

               System.out.println("   ╔═══════════════════════════╗");
               System.out.println("   ║    1)Couple Tours         ║");
               System.out.println("   ║    2)Family Tours         ║");
               System.out.println("   ║    3)General Tours        ║");
               System.out.println("   ╚═══════════════════════════╝");

               int TripType=Main.Input(1,3);


               for (Trip trip : Historytrips) {

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

               for (int i =Historytrips.size() - 1; i >= 0; i--) {

                   LocalDate startDate = LocalDate.parse(Historytrips.get(i).getStartDate());
                   LocalDate endDate = LocalDate.parse(Historytrips.get(i).getEndDate());
                   int tripYear = endDate.getYear();
                   int tripMonth = endDate.getMonthValue();

                   long  tripNumberOfDays;
                   tripNumberOfDays = Historytrips.get(i).calculateDaysBetweenDates(startDate,endDate);



               }



               System.out.println("Everything has been successfully cleared!!");
               break;

       }


       System.out.print("Do you wish do another operation? 1-->yes | 0-->No");
       choice = Main.Input(0, 1);
       if(choice==1) return this.update_TravelHistory();
       else return Logout_exist( Admins, Customers, TourGuides, Managers,  Trips_system);

}