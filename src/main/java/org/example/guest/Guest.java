package org.example.guest;



public class Guest {
    private int id;
    private String name;
    private String surname;
    private String email;
    private int phone;
    private String password;

    public Guest(String name, String surname, String email, int phone, int id, String password){
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }
    public int getId() {
        return this.id;
    }
    public String getName() {
        return this.name;
    }
    public String getSurname(){
        return this.surname;
    }
    public String getEmail(){
        return this.email;
    }
    public int getPhone(){
        return this.phone;
    }
    public String getPassword(){
        return this.password;
    }

}
