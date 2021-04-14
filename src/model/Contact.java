package model;

import java.io.Serializable;

public class Contact implements Serializable {
    private String fullName;
    private int phoneNumber;
    private String group;
    private String gender;
    private String address;
    private String mail;
    private String dateOfBirth;

    public Contact(String fullName, int phoneNumber, String group, String gender, String address, String mail, String dateOfBirth) {
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.group = group;
        this.gender = gender;
        this.address = address;
        this.mail = mail;
        this.dateOfBirth = dateOfBirth;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "" +
                "fullName='" + fullName + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", group='" + group + '\'' +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", mail='" + mail + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' + "\n";
    }
}