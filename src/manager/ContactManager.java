package manager;

import model.CheckInfo;
import model.Contact;
import view.DisplayMenu;
import java.util.ArrayList;
import java.util.Scanner;

public class ContactManager {
    Scanner sc = new Scanner(System.in);

    public void displayAll(ArrayList<Contact> arrayList) {
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println("--------------------------------------");
            System.out.println("Full name: " + arrayList.get(i).getFullName());
            System.out.println("Phone number: " + arrayList.get(i).getPhoneNumber());
            System.out.println("Gender: " + arrayList.get(i).getGender());
            System.out.println("Group: " + arrayList.get(i).getGroup());
            System.out.println("Address: " + arrayList.get(i).getAddress());
            System.out.println("--------------------------------------");
        }
        DisplayMenu.displayMenu();
    }

    public void addContact(ArrayList<Contact> arrayList) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Full name: ");
        String fullName = sc.nextLine();
        System.out.println("Phone Number(9 number): ");
        String number = "";
        int phoneNumber = 0;
        do{
            System.out.println("Enter your phone");
            number = sc.nextLine();
            phoneNumber = Integer.parseInt(number);
        }while (!number.matches(CheckInfo.CHECKPHONE));
        System.out.println("Enter Group: ");
        String group = sc.nextLine();
        System.out.println("Enter Gender: ");
        String gender = sc.nextLine();
        System.out.println("Enter Address: ");
        String address = sc.nextLine();
        System.out.println("Enter Mail (Format Gmail-Example: nguyenvhieu@gmail.com): ");
        String mail = "";
        do{
            System.out.println("Enter mail:");
             mail = sc.nextLine();
        } while (!mail.matches(String.valueOf(CheckInfo.CHECKMAIL)));
        System.out.println("Enter Date Of Birth: ");
        String dateOfBirth = sc.nextLine();
        System.out.println("--------------------------------------");
        String result = this.checkInformation(fullName, phoneNumber, group, gender, address, mail, dateOfBirth);
        if (result.equals("Save Successfully")) {
            System.out.println(result);
            Contact contact = new Contact(fullName, phoneNumber, group, gender, address, mail, dateOfBirth);
            arrayList.add(contact);
        } else {
            System.out.println(result);
            this.addContact(arrayList);
        }
        DisplayMenu.displayMenu();

    }

    public String checkInformation(String fullName, int phoneNumber, String group, String gender, String address, String mail, String dateOfBirth) {
        String result = "";
        if (fullName.equals("") || group.equals("") || gender.equals("") || address.equals("") || dateOfBirth.equals("")) {
            result = "Dont leave information blank";
        } else if (!CheckInfo.checkPhone(String.valueOf(phoneNumber))) {
            result = "Your input wrong phone format";
        } else if (!CheckInfo.checkMail(mail)) {
            result = "Your input wroong mail format";
        } else {
            result = "Save Successfully";
        }
        return result;

    }

    public void editContact(int phone, ArrayList<Contact> arrayList) {
        if (this.checkPhone(phone, arrayList) != -1) {
            System.out.println("Found phone number, Please enter your information");
            int index = this.checkPhone(phone, arrayList);
            System.out.println("Full name: ");
            String fullName = sc.nextLine();
            System.out.println("Phone Number: ");
            int phoneNumber = Integer.parseInt(sc.nextLine());
            System.out.println("Group: ");
            String group = sc.nextLine();
            System.out.println("Gender: ");
            String gender = sc.nextLine();
            System.out.println("Address: ");
            String address = sc.nextLine();
            System.out.println("mail: ");
            String mail = sc.nextLine();
            System.out.println("Year Of Birth: ");
            String dateOfBirth = sc.nextLine();
            String result = this.checkInformation(fullName, phoneNumber, group, gender, address, mail, dateOfBirth);
            if (result.equals("Save Successfully")) {
                System.out.println("Update successfully");
                Contact contact = new Contact(fullName, phoneNumber, group, gender, address, mail, dateOfBirth);
                arrayList.set(index, contact);
            } else {
                System.out.println(result);
            }
            DisplayMenu.displayMenu();


        } else {
            System.out.println("Dont find your phone");
            System.out.println("Invite you to re-enter");
            int reCheckPhone = sc.nextInt();
            if (reCheckPhone != 0) {
                this.editContact(reCheckPhone, arrayList);
            } else {
                DisplayMenu.displayMenu();
            }

        }
    }

    public void delete(int phone, ArrayList<Contact> arrayList) {
        if (checkPhone(phone, arrayList) != -1) {
            System.out.println("Do you want to delete");
            String accept = sc.nextLine();
            if (accept.equals("YES")) {
                int index = checkPhone(phone, arrayList);
                System.out.println("Delete successfully");
                arrayList.remove(index);
            } else DisplayMenu.displayMenu();

        } else {
            System.out.println("Dont find to your phone");
            System.out.println("Invite you phone to re-enter");
            int rePhone = sc.nextInt();
            if (rePhone != 0) {
                delete(rePhone, arrayList);
            } else DisplayMenu.displayMenu();

        }

    }

    public int checkName(String name, ArrayList<Contact> arrayList) {
        int indexName = -1;
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i).getFullName().equals(name)) {
                indexName = i;
                break;
            }
        }
        return indexName;
    }

    public void search(ArrayList<Contact> arrayList) {
        System.out.println("Please enter the search function: ");
        System.out.println("1.Search by phone number");
        System.out.println("2.Search by name");
        int choice = Integer.parseInt(sc.nextLine());
        if (choice == 1) {
            System.out.println("Please enter your phone number");
            int phoneSearch = Integer.parseInt(sc.nextLine());
            if (checkPhone(phoneSearch, arrayList) != -1) {
                int indexPhone = checkPhone(phoneSearch, arrayList);
                displayContact(indexPhone, arrayList);
            } else System.out.println("Done find");
        } else if (choice == 2) {
            System.out.println("Please enter your name");
            String nameSearch = sc.nextLine();
            if (checkName(nameSearch, arrayList) != -1) {
                int indexName = checkName(nameSearch, arrayList);
                displayContact(indexName, arrayList);
            } else System.out.println("Dont find");
        }
    }

    public int checkPhone(int phoneNumber, ArrayList<Contact> arrayList) {
        int indexPhone = -1;
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i).getPhoneNumber() == phoneNumber) {
                indexPhone = i;
                break;
            }
        }
        return indexPhone;
    }

    public void displayContact(int index, ArrayList<Contact> arrayList) {
        System.out.println("--------------------------------------");
        System.out.println("Full name: " + arrayList.get(index).getFullName());
        System.out.println("Phone number: " + arrayList.get(index).getPhoneNumber());
        System.out.println("Gender: " + arrayList.get(index).getGender());
        System.out.println("Group: " + arrayList.get(index).getGroup());
        System.out.println("Address: " + arrayList.get(index).getAddress());
        System.out.println("--------------------------------------");
        DisplayMenu.displayMenu();
    }

}
