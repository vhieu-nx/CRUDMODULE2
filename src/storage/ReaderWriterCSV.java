package storage;

import model.Contact;

import java.io.*;
import java.util.ArrayList;

public class ReaderWriterCSV {
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";
    public static final String FILEPATH = "data/contacts.csv";
    File file = new File(FILEPATH);
    public void writeFile(ArrayList<Contact> arrayList){
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (int i = 0; i < arrayList.size(); i++) {
                String name = arrayList.get(i).getFullName();
                int phone = arrayList.get(i).getPhoneNumber();
                String group = arrayList.get(i).getGroup();
                String gender = arrayList.get(i).getGender();
                String address = arrayList.get(i).getAddress();
                String mail = arrayList.get(i).getMail();
                String dateOfBirth = arrayList.get(i).getDateOfBirth();
                String line = name + COMMA_DELIMITER + phone + COMMA_DELIMITER + group + COMMA_DELIMITER
                        + gender + COMMA_DELIMITER + address + COMMA_DELIMITER + mail + COMMA_DELIMITER
                        + dateOfBirth + NEW_LINE_SEPARATOR;
                bufferedWriter.write(line);
            }
            bufferedWriter.flush();
            bufferedWriter.close();
            fileWriter.close();
            System.out.println("Lưu thành công");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Contact> readFile() {
        ArrayList<Contact> contacts = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(FILEPATH);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                Contact contact = splitString(line);
                contacts.add(contact);
            }
            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contacts;
    }
    public static Contact splitString(String string) {
        String[] splitData = string.split(COMMA_DELIMITER);
        String fullName = splitData[0];
        int phoneNumber = Integer.parseInt(splitData[1]);
        String group = splitData[2];
        String gender = splitData[3];
        String address = splitData[4];
        String mail = splitData[5];
        String dateOfBirth = splitData[6];
        Contact contact = new Contact(fullName, phoneNumber, group, gender, address, mail, dateOfBirth);
        return contact;
    }

}