package com.spendtrackingapplication.Spend.Tracking.Application.entity;

import javax.persistence.*;

@Entity
@Table(name = "role_table")
public class Role {
    @Id
    String id;
    String name;
    String discription;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }
}
