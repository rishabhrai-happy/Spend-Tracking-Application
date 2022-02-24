package com.spendtrackingapplication.Spend.Tracking.Application.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "wallettable")
public class Wallet implements Serializable {

    @Id
    private String id;
    private String amount;
    private String walletType;
    private String discription;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getWalletType() {
        return walletType;
    }

    public void setWalletType(String wallet_type) {
        this.walletType = wallet_type;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDescription(String discription) {
        this.discription = discription;
    }
}
