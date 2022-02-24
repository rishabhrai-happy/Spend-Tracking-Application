package com.spendtrackingapplication.Spend.Tracking.Application.model;

import com.spendtrackingapplication.Spend.Tracking.Application.entity.ParentEntity;
import com.spendtrackingapplication.Spend.Tracking.Application.entity.Product;
import com.spendtrackingapplication.Spend.Tracking.Application.entity.User;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Document(collection = "purchases")
public class Purchase extends ParentEntity{

        @Id
        private String purchaseId;

        @OneToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "user_id")
        private User user;

        @OneToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "product_id")
        private Product product;

        private String address;

        private String deliveryStatus;

        public Purchase(){
        }

        public String getPurchaseId() {
            return purchaseId;
        }

        public void setPurchaseId(String purchaseId) {
            this.purchaseId = purchaseId;
        }

        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }

        public Product getProduct() {
            return product;
        }

        public void setProduct(Product product) {
            this.product = product;
        }

        public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public String getDeliveryStatus() {
                return deliveryStatus;
            }

            public void setDeliveryStatus(String deliveryStatus) {
                this.deliveryStatus = deliveryStatus;
            }
    }

