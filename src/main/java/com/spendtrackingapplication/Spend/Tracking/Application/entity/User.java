package com.spendtrackingapplication.Spend.Tracking.Application.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "users")
public class User extends ParentEntity  {
    @Id
    String id;
    String FirstName;
    String LastName;
    String password;
    String email;
    String MobilenNo;
    String city;
    String active;

    @OneToOne
    @JoinColumn(name="wallet_id")
    private Wallet wallet;

    @OneToOne
    @JoinColumn(name="role_id")
    private Role role;


    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public User(String id, String firstname, String lastname, String password, String email,  String mobileno, String city, String active) {
        this.id = id;
        this.FirstName = firstname;
        this.LastName = lastname;
        this.password = password;
        this.email = email;
        this.MobilenNo = mobileno;
        this.city = city;
        this.active = active;
    }
    public User(){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobilenNo() {
        return MobilenNo;
    }

    public void setMobilenNo(String mobilenNo) {
        MobilenNo = mobilenNo;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }
}
