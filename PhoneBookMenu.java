package com.exmple.phonebookproject;

import java.util.Scanner;

// Class contains the main method that provides menu interface for phone book
public class PhoneBookMenu {

    public static void main(String[] args) {
        // Create a new PhoneBook instance
        PhoneBook phoneBook = new PhoneBook();
        // Create a Scanner object to take user input
        Scanner input = new Scanner(System.in);
        // Variable to control loop exit
        boolean exit = false;

        // Main loop for the phonebook application
        while (!exit) {

            // Display menu options
            displayMenu();

            // Take user input for menu choice
            int userChoice = input.nextInt();
            input.nextLine();

            // Switch case for menu options
            switch (userChoice) {
                case 1: // Add new contact
                    System.out.println("Enter First name: ");
                    String firstName = input.nextLine();
                    System.out.println("Enter Last Name: ");
                    String lastName = input.nextLine();
                    System.out.println("Enter Landline: ");
                    String landline = input.nextLine();
                    System.out.println("Enter Phone Number: ");
                    String phoneNumber = input.nextLine();
                    System.out.println("Enter Workplace: ");
                    String workplace = input.nextLine();
                    System.out.println("Enter Email: ");
                    String email = input.nextLine();
                    phoneBook.addNewContact(firstName, lastName, landline, phoneNumber, workplace, email);
                    break;

                case 2: // Remove a contact
                    System.out.println("Enter the first name of the contact you want to remove: ");
                    String removeContact = input.nextLine();
                    phoneBook.removeContactByName(removeContact);
                    break;

                case 3: // Display all contacts
                    System.out.println("Contacts list in phonebook:");
                    phoneBook.displayContacts();
                    break;

                case 4: // Search contact by first name
                    System.out.println("Enter the first name of the contact you want to search: ");
                    String searchContact = input.nextLine();
                    phoneBook.searchContactByName(searchContact);
                    break;

                case 5: // Sort phonebook in lexicographic order
                    phoneBook.lexicographicalOrder();
                    break;

                case 6: // Sort phonebook by phone number
                    phoneBook.sortByPhoneNumber();
                    break;

                case 7: // Remove duplicate contacts
                    phoneBook.removeDuplicates();
                    break;

                case 8: // Reverse phonebook order
                    phoneBook.reversePhoneBook();
                    break;

                case 9: // Save phonebook data to a file
                    System.out.println("Enter filename to save phonebook data (e.g: file.txt): ");
                    String saveFileName = input.nextLine();
                    phoneBook.saveToFile(saveFileName);
                    break;

                case 10: // Load phonebook data from a file
                    System.out.println("Enter filename to load phonebook data from (e.g: oldtext.txt): ");
                    String loadFileName = input.nextLine();
                    phoneBook.loadFromFile(loadFileName);
                    break;

                case 11: // Exit
                    System.out.println("Goodbye :)");
                    exit=true;
                    break;

                default:
                    System.out.println("Wrong number try again!\n");
                    break;
            }
        }
    }

    // Method to display menu options
    public static void displayMenu(){
        System.out.println("Choose the number of your choice from the menu:");
        System.out.println("1. Add new contact");
        System.out.println("2. Remove a contact");
        System.out.println("3. Display all contacts");
        System.out.println("4. Search contact by first name");
        System.out.println("5. Sort phonebook in lexicographical order");
        System.out.println("6. Sort phonebook by phone number");
        System.out.println("7. Remove duplicate contacts in phonebook");
        System.out.println("8. Sort phonebook in reverse order");
        System.out.println("9. Save phonebook data in a text file");
        System.out.println("10. Load phonebook data from a text file");
        System.out.println("11. Exit");
        System.out.println("\nYour choice: ");
    }
}
