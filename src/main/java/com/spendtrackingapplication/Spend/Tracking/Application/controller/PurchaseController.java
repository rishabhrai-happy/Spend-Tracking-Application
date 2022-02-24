package com.spendtrackingapplication.Spend.Tracking.Application.controller;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spendtrackingapplication.Spend.Tracking.Application.bussiness.PurchaseService;
import com.spendtrackingapplication.Spend.Tracking.Application.bussiness.UserService;
import com.spendtrackingapplication.Spend.Tracking.Application.model.Purchase;
import com.spendtrackingapplication.Spend.Tracking.Application.mongoRepository.PurchaseRepository;
import com.spendtrackingapplication.Spend.Tracking.Application.request.PurchaseRequest;
import com.spendtrackingapplication.Spend.Tracking.Application.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PurchaseController {

    //private MongoOperations mongoOperations = new MongoTemplate(new MongoClient(), "local");

    @Autowired
    PurchaseRepository purchaseMongoRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private PurchaseService purchaseService;

    @PostMapping(value = "/user/createPurchase")
    public String createPurchase(@RequestBody PurchaseRequest purchaseRequest)
    {
        purchaseService.madePurchase( purchaseRequest);
        return "New Purchase is made";
    }

    @JsonIgnore
    @GetMapping(value = "/user/allPurchases")
    public List<Purchase> getAllPurchases() {
//        List<Purchase> response = new ArrayList<>();
//        Document query = new Document();
//        Document projection = new Document();
//        projection.put(_ID, 0);
//        List<Document> result = purchaseRepository.findList(Purchase, query, projection);
        List<Purchase> listOfPurchases = purchaseMongoRepository.findAll();
        return listOfPurchases;
    }
}
