package cis.travel.eg.User;
import java.util.ArrayList;

public class Admin extends User{


    @Override
    public void Register(ArrayList<Admin> Admins, ArrayList<Customer> Customers, ArrayList<Manager> Managers,ArrayList<TourGuide> TourGuides) {

    }

    @Override
    public void Login() {

    }

    @Override
    public void LogOut() {

    }



    @Override
    public void Display_Profile() {

    }

    @Override
    public void Edit_Profile() {

    }
    static public int Is_login_successfully(String username,String password, ArrayList<Admin> admin) {

        return 1;
    }
    static public int FoundUsername(String username, ArrayList<Admin> admins){

        return 1;
    }
}
