package com.myntra.myntra.Entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "User_ID")
    private int userId;

    @Column(name = "First_Name")
    private String firstName;

    @Column(name = "Last_Name")
    private String lastName;

    @Column(name = "Email_Address")
    private String email;

    @Column(name = "Password_Hash")
    private String passwordHash;

    @Column(name = "Phone_Number")
    private String phoneNumber;

    @Column(name = "Billing_Address")
    private String billingAddress;

    @Column(name = "Shipping_Address")
    private String shippingAddress;

    @Column(name = "Date_Of_Birth")
    private Date dateOfBirth;

    @Lob
    @Column(name = "Profile_Picture")
    private byte[] profilePicture;

    public UserEntity() {
    }

    public UserEntity(int userId, String firstName, String lastName, String email, String passwordHash, String phoneNumber, String billingAddress, String shippingAddress, Date dateOfBirth, byte[] profilePicture) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.passwordHash = passwordHash;
        this.phoneNumber = phoneNumber;
        this.billingAddress = billingAddress;
        this.shippingAddress = shippingAddress;
        this.dateOfBirth = dateOfBirth;
        this.profilePicture = profilePicture;
    }


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {

        this.userId = userId;
    }

    public String getFirstName() {

        return firstName;
    }

    public void setFirstName(String firstName) {

        this.firstName = firstName;
    }

    public String getLastName() {

        return lastName;
    }

    public void setLastName(String lastName) {

        this.lastName = lastName;
    }

    public String getEmail() {

        return email;
    }

    public void setEmail(String email) {

        this.email = email;
    }

    public String getPasswordHash() {

        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {

        this.passwordHash = passwordHash;
    }

    public String getPhoneNumber() {

        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {

        this.phoneNumber = phoneNumber;
    }

    public String getBillingAddress() {

        return billingAddress;
    }

    public void setBillingAddress(String billingAddress) {

        this.billingAddress = billingAddress;
    }

    public String getShippingAddress() {

        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {

        this.shippingAddress = shippingAddress;
    }

    public Date getDateOfBirth() {

        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {

        this.dateOfBirth = dateOfBirth;
    }

    public byte[] getProfilePicture() {

        return profilePicture;
    }

    public void setProfilePicture(byte[] profilePicture) {

        this.profilePicture = profilePicture;
    }
}