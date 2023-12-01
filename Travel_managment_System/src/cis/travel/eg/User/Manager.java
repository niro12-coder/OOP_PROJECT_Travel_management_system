package cis.travel.eg.User;

import java.util.ArrayList;

public class Manager {
        public Manager(){};
    public int Is_login_successfully(ArrayList<Manager> mange, String username, String password)
    {
        for(int i=0;i< mange.size();i++)
        {
            Manager manager=mange.get(i);  //to get the current Customer object from the ArrayList.
            if(manager.GetUsername().equals(username) && manager.GetPassword().equals(password))
            {
                System.out.println("login successfully "+username);
                return i;
            }
            else
                System.out.println("login failed");
        }
        return -1;
    }
    public void Display_Profile(){
        System.out.println("your first name "+super.GetFirstName());
        System.out.println("your last name "+super.GetLastName());
        System.out.println("your last name "+super.GetUsername());
    }
    public void Home_Page(){

    }

}
