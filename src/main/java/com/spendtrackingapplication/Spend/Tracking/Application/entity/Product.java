package com.spendtrackingapplication.Spend.Tracking.Application.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "producttable")
public class Product {

    @Id
    String id ;
    String name;
    String category;
    String price;
    String description;

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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String discription) {
        this.description = discription;
    }
}
