package com.spendtrackingapplication.Spend.Tracking.Application.entity;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "userwallet")

public class UserWallet{

    @Id
    String id;
    String balance;

    @OneToOne
    @JoinColumn(name="user_id")
    private User user;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="wallet_id")
    private Wallet wallet;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserWallet(String id, String balance) {
        this.id = id;
        this.balance = balance;
    }

    public UserWallet() {
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }
}
