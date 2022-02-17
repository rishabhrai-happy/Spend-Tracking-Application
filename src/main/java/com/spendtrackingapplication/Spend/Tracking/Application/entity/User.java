package com.spendtrackingapplication.Spend.Tracking.Application.entity;

import javax.persistence.*;

@Entity
@Table(name = "user_enqua")
public class User {
    @Id
    String id;
    String First_name;
    String last_name;
    String password;
    String role_id;
    String email;
    String created_date;
    String updated_date;
    String wallet_id;
    String mobile_no;
    String city;
    String active;

    public User(String id, String firstname, String lastname, String password, String roleid, String email, String createddate, String updated_date, String walletid, String mobileno, String city, String active) {
        this.id = id;
        First_name = firstname;
        this.last_name = lastname;
        this.password = password;
        this.role_id = roleid;
        this.email = email;
        this.created_date = createddate;
        this.updated_date = updated_date;
        this.wallet_id = walletid;
        this.mobile_no = mobileno;
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

    public String getFirstname() {
        return First_name;
    }

    public void setFirstname(String firstname) {
        First_name = firstname;
    }

    public String getLastname() {
        return last_name;
    }

    public void setLastname(String lastname) {
        this.last_name = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoleid() {
        return role_id;
    }

    public void setRoleid(String roleid) {
        this.role_id = roleid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCreateddate() {
        return created_date;
    }

    public void setCreateddate(String createddate) {
        this.created_date = createddate;
    }

    public String getUpdated_date() {
        return updated_date;
    }

    public void setUpdated_date(String updated_date) {
        this.updated_date = updated_date;
    }

    public String getWalletid() {
        return wallet_id;
    }

    public void setWalletid(String walletid) {
        this.wallet_id = walletid;
    }

    public String getMobileno() {
        return mobile_no;
    }

    public void setMobileno(String mobileno) {
        this.mobile_no = mobileno;
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
