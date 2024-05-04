package com.exmple.phonebookproject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

// Class that manages the phonebook
public class PhoneBook {

    // Instance variable to hold contacts
    private ArrayList<Contact> contactList;

    // Constructor to initialize the contact list
    public PhoneBook(){
        contactList = new ArrayList<>();
    }

    // Method to add new contact, check if required fields are empty and check if contact already exists
    public void addNewContact(String firstName, String lastName, String landline, String phoneNumber, String workplace, String email){
        if(firstName.isEmpty() || lastName.isEmpty() || phoneNumber.isEmpty()){
            System.out.println("firstName, lastName and phoneNumber are required fields");
            return;
        }

        Contact newContact = new Contact(firstName, lastName, landline, phoneNumber, workplace, email);
        for(Contact existsContact: contactList){
                if(existsContact.equals(newContact)){
                    System.out.println("Contact already exists\n");
                    return;
            }
        }
        contactList.add(newContact);
        System.out.println("Contact added successfully to the phonebook\n");
    }

    // Method to remove a contact by first name, remove only the first occurrences
    public void removeContactByName(String firstName){
        Iterator<Contact> integer = contactList.iterator();
        boolean find = false;
        while (integer.hasNext()){
            Contact contact = integer.next();
            if (contact.getFirstName().equals(firstName)){
                integer.remove();
                find = true;
                break;
            }
        }
        if (find){
            System.out.println("Contact by Name " + firstName + " removed successfully\n");
        }else {
            System.out.println("Contact by Name " + firstName + " not found\n");
        }
    }

    // Method to display all contacts in the phonebook
    public void displayContacts() {
        if (this.contactList.size() > 0) {
            for (Contact value : this.contactList) {
                value.printContact();
            }
        } else {
            System.out.println("No contacts lists exist\n");
        }
    }

    // Method to search contact by first name, stores all matching contacts in ArrayList then print the details
    public void searchContactByName(String firstName) {
        ArrayList<Contact> foundContacts = new ArrayList<>();
        for (Contact value : contactList) {
            if (value.getFirstName().equals(firstName)) {
                foundContacts.add(value);
                }
            }
            if (foundContacts.isEmpty()) {
                System.out.println("Contact by Name " + firstName + " not found\n");
            }else {
                System.out.println("Found contact: \n");
                for(Contact value : foundContacts){
                    value.printContact();
                }
        }
    }

    // Method to sort the phonebook by lexicographic order
    public void lexicographicalOrder(){
        Collections.sort(contactList, Contact.contactComparator);
        System.out.println("Phonebook sort by lexicographic order\n");
    }

    // Method to sort the phonebook by phone number in descending order
    public void sortByPhoneNumber(){
        Collections.sort(contactList, Contact.phoneNumberDescendingComparator);
        System.out.println("Phonebook sort by phone number in descending order\n");
    }

    // Method to remove duplicate contacts based on first name and phone number
    public void removeDuplicates(){
        ArrayList<Contact> noDuplicateContacts = new ArrayList<>(); // store only contacts without duplicates
        ArrayList<String> duplicates = new ArrayList<>(); // store only duplicate contacts

        for (Contact contact : contactList){
            String key = contact.getFirstName() + " - "+ contact.getPhoneNumber();
            if(!duplicates.contains(key)){
                noDuplicateContacts.add(contact);
                duplicates.add(key);
            }
        }
        if(noDuplicateContacts.size() <contactList.size()){
            contactList.clear();
            contactList.addAll(noDuplicateContacts);
            System.out.println("Duplicates removed successfully\n");
        } else {
            System.out.println("No duplicates found in the phonebook \n");
        }
    }

    // Method to sort the phonebook in reverse order
    public void reversePhoneBook(){
        Collections.reverse(contactList);
        System.out.println("Phonebook sort in reverse order\n");
    }

    // Method to save phonebook data to a text file
    public void saveToFile(String saveFileName){
        try(PrintWriter writer = new PrintWriter(saveFileName)){
            for (Contact contact : contactList){
                writer.println("First name: " + contact.getFirstName() + "\n" +
                        "Last Name: " + contact.getLastName() + "\n" +
                        "Landline: " + contact.getLandline() + "\n" +
                        "Phone Number: " + contact.getPhoneNumber() + "\n" +
                        "Workplace: " + contact.getWorkplace() + "\n" +
                        "Email: " + contact.getEmail() + "\n");
            }
            System.out.println("Phonebook data saved to " + saveFileName + "\n");
        } catch (FileNotFoundException e){
            System.out.println("Error Saving phonebook data to " + saveFileName + ": " + e.getMessage() + "\n");
        }
    }

    // Method to load phonebook data from a text file and loaded it in to the current phonebook
    public void loadFromFile(String loadFileName){
        try(Scanner scanner = new Scanner(new File(loadFileName))){
            while (scanner.hasNextLine()){
                String firstName = "", lastName = "", landline = "", phoneNumber = "", workplace = "", email = "";
                while(scanner.hasNextLine()){
                    String line = scanner .nextLine();
                    if ((line.isEmpty())){
                        break;
                    }
                    String[] parts = line.split(": ");
                if (parts.length == 2){
                    String field = parts[0].trim();
                    String value = parts[1].trim();
                    switch (field) {
                        case "First name":
                            firstName = value;
                            break;
                        case "Last Name":
                            lastName = value;
                            break;
                        case "Landline":
                            landline = value;
                            break;
                        case "Phone Number":
                            phoneNumber = value;
                            break;
                        case "Workplace":
                            workplace = value;
                            break;
                        case "Email":
                            email = value;
                            break;
                        default:
                            System.out.println("Invalid field: " + field);
                            break;
                    }
                } else {
                    System.out.println("Invalid data format: " + line);
                }
            }
            Contact newContact = new Contact(firstName, lastName, landline, phoneNumber, workplace, email);
            contactList.add(newContact);
            }
            System.out.println("Phonebook data loaded from " + loadFileName + "\n");
        }catch (FileNotFoundException e){
            System.out.println("Error loading phonebook data from " + loadFileName +": " +e.getMessage() + "\n");
        }
    }
}

