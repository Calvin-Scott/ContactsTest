package uk.ac.lincoln.students.calvinscott13458203.contactstest;

/**
 * Created by calvi_000 on 02/04/2016.
 */
public class ContactsDB {

    //private variables
    int _id;
    String _firstname;
    String _lastname;
    String _email;
    String _mobilenumber;
    String _address;

    // Empty constructor
    public ContactsDB(){

    }
    // constructor
    public ContactsDB(int id, String firstName,String lastName,String email,
                   String mobileNumber, String address){
        this._id = id;
        this._firstname = firstName;
        this._lastname = lastName;
        this._email = email;
        this._mobilenumber = mobileNumber;
        this._address = address;

    }

    // constructor
    public ContactsDB(String firstName,String lastName,String email,
                     String mobileNumber, String address){
        this._firstname = firstName;
        this._lastname = lastName;
        this._email = email;
        this._mobilenumber = mobileNumber;
        this._address = address;
    }
    // getters and setters
    public int getID(){
        return this._id;
    }

    public void setID(int id){
        this._id = id;
    }


    public String getFirstName()
    {
        return this._firstname;
    }


    public void setfirstName(String firstName)
    {
        this._firstname = firstName;
    }

    public String getLastName()
    {
        return this._lastname;
    }


    public void setLastName(String lastName){
        this._lastname = lastName;
    }

    public String getEmail(){
        return this._email;
    }


    public void setEmail(String email){
        this._email = email;
    }


    public String getMobileNumber(){
        return this._mobilenumber;
    }


    public void setMobileNumber(String mobileNumber)
    {
        this._mobilenumber = mobileNumber;
    }

    public String getAddress(){
        return this._address;
    }


    public void setAddress(String address)
    {
        this._address = address;
    }


}


