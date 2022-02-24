package com.spendtrackingapplication.Spend.Tracking.Application.mongoRepository;

import com.spendtrackingapplication.Spend.Tracking.Application.model.Purchase;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PurchaseRepository extends MongoRepository<Purchase,String>{
}
