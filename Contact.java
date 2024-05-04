package com.exmple.phonebookproject;

import java.util.Comparator;

// Class for contact details in the phonebook
public class Contact {
    private String firstName;
    private String lastName;
    private String landline;
    private String phoneNumber;
    private String workplace;
    private String email;

    // Default constructor
    public Contact() {
    }
    // Parameterized constructor
    public Contact (String firstName, String lastName, String landline, String phoneNumber, String workplace, String email){
        this.firstName=firstName;
        this.lastName=lastName;
        this.landline=landline;
        this.phoneNumber=phoneNumber;
        this.workplace=workplace;
        this.email=email;
    }

    // Getters and setters for instance variables

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getLandline() {
        return landline;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getWorkplace() {
        return workplace;
    }

    public String getEmail() {
        return email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setLandline(String landline) {
        this.landline = landline;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setWorkplace(String workplace) {
        this.workplace = workplace;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Prints the contact details
    public void printContact(){
        System.out.println( "First name: " + getFirstName() + "\n" +
                "Last Name: " + getLastName() + "\n" +
                "Landline: " + getLandline() + "\n" +
                "Phone Number: " + getPhoneNumber() + "\n" +
                "Workplace: " + getWorkplace() + "\n" +
                "Email: " + getEmail() + "\n");
    }

    // Comparator for sorting contacts by lexicographic order
    public static Comparator<Contact> contactComparator = new Comparator<Contact>() {
        @Override
        public int compare(Contact o1, Contact o2) {
            String name1 = o1.getFirstName() + " " + o1.getLastName();
            String name2 = o2.getFirstName() + " " + o2.getLastName();
            return name1.compareToIgnoreCase(name2);
        }
    };

    // Comparator for sorting contacts by phone number in descending order
    public static Comparator<Contact> phoneNumberDescendingComparator = new Comparator<Contact>() {
        @Override
        public int compare(Contact o1, Contact o2) {
            return o2.getPhoneNumber().compareTo(o1.getPhoneNumber());
        }
    };
}
