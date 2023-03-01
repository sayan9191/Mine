package com.example.ecom;

public class EmployeeInfo {
    private String firstName;
    private String lastName;
    private String emailId;

    EmployeeInfo(){

    }

    EmployeeInfo(String firstName, String lastName, String emailId){
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
    }

    public void Userinfo(){

    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName=firstName;
    }

    public String getLastName(){
        return  lastName;
    }
    public void setLastName(String lastName){
        this.lastName= lastName;
    }
    public String getEmailId(){
        return emailId;
    }
    public void setEmailId(String emailId){
        this.emailId=emailId;
    }
}
