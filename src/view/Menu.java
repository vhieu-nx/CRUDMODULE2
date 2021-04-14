package view;

import manager.ContactManager;
import model.Contact;
import storage.ReaderWriterCSV;
import java.util.ArrayList;
import java.util.Scanner;

import static view.DisplayMenu.displayMenu;

public class Menu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Contact> contacts = new ArrayList<>();
        ContactManager contactManager = new ContactManager();
        ReaderWriterCSV readerWriterCSV = new ReaderWriterCSV();
        displayMenu();
        int choice = -1;
        do {
            System.out.println("Please your choice: ");
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Your input the wrong date type");;
            }
            switch (choice) {
                case 1:
                    contactManager.displayAll(contacts);
                    break;
                case 2:
                    contactManager.addContact(contacts);
                    break;
                case 3:
                    System.out.println("Enter your phone: ");
                    int phone = Integer.parseInt(sc.nextLine());
                    contactManager.editContact(phone, contacts);
                    break;
                case 4:
                    System.out.println("Enter your phone delete: ");
                    int phoneDelete = Integer.parseInt(sc.nextLine());
                    contactManager.delete(phoneDelete, contacts);
                    break;
                case 5:
                    contactManager.search(contacts);
                    break;
                case 6:
                    readerWriterCSV.writeFile(contacts);
                    break;
                case 7:
                    contacts = readerWriterCSV.readFile();
                    System.out.println(contacts);
                    break;
                case 8:
                    System.exit(0);
                    break;
            }
        } while (choice != 0);
    }


}
