package cis.travel.eg.User;

abstract public class User {

    private String Username;
    private String FirstName;
    private String LastName;
    private String Password;
    private String PhoneNumber;
    private String Email;
    private int Age;

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username, int SizeOfArray) {
        // for(int i = 0; i < SizeOfArrray; i++){
        //    if(Username == array[i]) {
        //      System.out.println(" ");
        //      this.setUsername(username, sizeOfArray);
        //   }
        // }
        Username = username;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getPassword() {
        return Password;
    }

    public boolean setPassword(String newPassword, String confirmPassword) {
        // cin_password
        if (newPassword == null || confirmPassword == null || newPassword.isEmpty() || confirmPassword.isEmpty())
        {
            System.out.println(" Invalid Password  \n Enter valid password : "); // null
            return false;
        }

        ///////////////////////////////
        int rule_count = 0;
        boolean sizeCheck = newPassword.length() > 7 && newPassword.length() < 30;
        boolean equalCheck = newPassword.equals(confirmPassword);

        boolean upperRule = !newPassword.equals(newPassword.toLowerCase());
        boolean lowerRule = !newPassword.equals(newPassword.toUpperCase());
        boolean numCheck = newPassword.matches("(.*)[0-9](.*)");
        boolean symbolsRule = newPassword.matches("(.*)'#'(.*)") ; // '*', '_', '-'

        rule_count = ((upperRule ? 1 : 0) + (lowerRule ? 1 : 0) + (symbolsRule ? 1 : 0) + (numCheck ? 1 : 0));


        if(!equalCheck) {
            System.out.println("Passwords must match \n");
            return false;

        }
        else if(!sizeCheck || rule_count < 4 || !numCheck){
            System.out.println("Password doesn't follow instructions \n"); //Password must be at least 8 and #, *
            return false;
        }

        Password = newPassword;
        return true;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public boolean setPhoneNumber(String phoneNumber) {
        int rule_count = 0;

        if(phoneNumber == null || phoneNumber.isEmpty()) {
            System.out.println(" Invalid number  \n Enter valid Number : "); // null
            return false;
        }

        boolean sizeCheck = phoneNumber.length() == 11;
        boolean numCheck = phoneNumber.matches("(.*)[0-9](.*)");
        boolean symbolsRule = !phoneNumber.matches("(.*)'#'(.*)") ; // '*', '_', '-'
        boolean Check = false;
        if(phoneNumber.matches("011(.*)") || phoneNumber.matches("010(.*)")
                || phoneNumber.matches("015(.*)") || phoneNumber.matches("012(.*)") ) {
            Check = true;
        }


        rule_count = ((sizeCheck ? 1 : 0) + (numCheck ? 1 : 0) + (symbolsRule ? 1 : 0) + (Check ? 1 : 0));


        if(rule_count > 0) {
            System.out.println("Phone Number doesn't follow instructions \n");
            return false;
        }
        PhoneNumber = phoneNumber;
        return true;
    }

    public String getEmail() {
        return Email;
    }

    public boolean setEmail(String email) {
        boolean Check = email.matches("(.*)@gmail.com");
        boolean nullValue = email.matches("(.*)' '(.*)"); // edit (arraylist)
        boolean upperRule = email.equals(email.toLowerCase());
        if(Check && !nullValue && !upperRule){
            Email = email;
            return true;
        }
        return false;
    }

    public int getAge() {
        return Age;
    }

    public boolean setAge(int age) {
        if(age > 100 || age < 0) {
            System.out.println("Invalid input");
            return false;
        }
        Age = age;
        return true;
    }

    abstract public void Register();
    abstract public void Login();
    abstract public void LogOut();
    abstract public void Home_Page();
    abstract public void Display_Profile();
    abstract public void Edit_Profile();


}
