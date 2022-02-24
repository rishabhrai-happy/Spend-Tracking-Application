package com.spendtrackingapplication.Spend.Tracking.Application.bussiness;

import com.spendtrackingapplication.Spend.Tracking.Application.entity.Product;
import com.spendtrackingapplication.Spend.Tracking.Application.entity.User;
import com.spendtrackingapplication.Spend.Tracking.Application.model.Purchase;
import com.spendtrackingapplication.Spend.Tracking.Application.mongoRepository.PurchaseRepository;
import com.spendtrackingapplication.Spend.Tracking.Application.repository.ProductRepo;
import com.spendtrackingapplication.Spend.Tracking.Application.repository.UserRepository;
import com.spendtrackingapplication.Spend.Tracking.Application.request.PurchaseRequest;
import com.spendtrackingapplication.Spend.Tracking.Application.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseService {

    @Autowired
    private UserRepository userRepository;
     @Autowired
    private PurchaseRepository purchaseRepository;

     @Autowired
    private ProductRepo productRepo;

    public void madePurchase(PurchaseRequest purchaseRequest) {
        Purchase purchase = new Purchase();
        purchase.setPurchaseId(CommonUtils.generateUUID());
        CommonUtils.setCreateEntityFields(purchase);
        CommonUtils.setUpdateEntityFields(purchase);
        purchase.setAddress(purchaseRequest.getAddress());
        User user= userRepository.findById(purchaseRequest.getUserId()).get();
        purchase.setUser(user);
        Product product= productRepo.findById(purchaseRequest.getProductId()).get();
        purchase.setProduct(product);
        purchaseRepository.save(purchase);
    }
}
