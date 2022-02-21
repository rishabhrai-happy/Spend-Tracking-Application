package com.spendtrackingapplication.Spend.Tracking.Application.entity;

import javax.persistence.*;

@Entity
@Table(name = "productstock")
public class ProductStock extends ParentEntity{

    @Id
    String id;
    String quantity;

    @OneToOne
    @JoinColumn(name="product_id")
    private Product product;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

}
