package com.spendtrackingapplication.Spend.Tracking.Application.bussiness;

import com.spendtrackingapplication.Spend.Tracking.Application.entity.ParentEntity;
import com.spendtrackingapplication.Spend.Tracking.Application.entity.Product;
import com.spendtrackingapplication.Spend.Tracking.Application.entity.ProductStock;
import com.spendtrackingapplication.Spend.Tracking.Application.entity.User;
import com.spendtrackingapplication.Spend.Tracking.Application.repository.ProductRepo;
import com.spendtrackingapplication.Spend.Tracking.Application.repository.ProductStockRepo;
import com.spendtrackingapplication.Spend.Tracking.Application.request.ProductRequest;
import com.spendtrackingapplication.Spend.Tracking.Application.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private ProductStockRepo productStockRepo;

    private ParentEntity parentEntity;


    public void product(ProductRequest productRequest){

        Product product=new Product();
        product.setId(CommonUtils.generateUUID());
        product.setName(productRequest.getName());
        product.setCategory(productRequest.getCategory());
        product.setPrice(productRequest.getPrice());
        product.setDescription(productRequest.getDescription());

        productRepo.save(product);

        ProductStock productStock=new ProductStock();
        productStock.setId(CommonUtils.generateUUID());
        productStock.setProduct(product);
        productStock.setQuantity("100");
        CommonUtils.setCreateEntityFields(productStock);
        CommonUtils.setUpdateEntityFields(productStock);
        productStockRepo.save(productStock);



    }


}
