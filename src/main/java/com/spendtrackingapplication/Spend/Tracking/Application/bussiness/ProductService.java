package com.spendtrackingapplication.Spend.Tracking.Application.bussiness;

import com.spendtrackingapplication.Spend.Tracking.Application.entity.ParentEntity;
import com.spendtrackingapplication.Spend.Tracking.Application.entity.Product;
import com.spendtrackingapplication.Spend.Tracking.Application.entity.ProductStock;
import com.spendtrackingapplication.Spend.Tracking.Application.entity.User;
import com.spendtrackingapplication.Spend.Tracking.Application.exception.ValidationException;
import com.spendtrackingapplication.Spend.Tracking.Application.repository.ProductRepo;
import com.spendtrackingapplication.Spend.Tracking.Application.repository.ProductStockRepo;
import com.spendtrackingapplication.Spend.Tracking.Application.request.ProductRequest;
import com.spendtrackingapplication.Spend.Tracking.Application.request.RegistrationRequest;
import com.spendtrackingapplication.Spend.Tracking.Application.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private ProductStockRepo productStockRepo;


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

    public void deleteProduct(String id){
        Optional<Product> product = productRepo.findById(id);
        Product product1=product.get();
        if (!product.isPresent()) {
            throw new ValidationException(HttpStatus.BAD_REQUEST.value(), "product does not exists for id::" + id);
        } else {
           productRepo.deleteById(id);
        }
    }

    public void updateProfile(ProductRequest productRequest, String id) throws javax.xml.bind.ValidationException {
        Optional<Product> product= productRepo.findById(id);
        Product product1 = product.get();
        if(!product.isPresent()){
            throw new javax.xml.bind.ValidationException(String.valueOf(HttpStatus.BAD_REQUEST.value()), "configuration does not exists for name::" + id);
        }
        if (!(product1.getName().equals(productRequest.getName()) )) {
            product1.setName(productRequest.getName());
        }
        if (!(product1.getCategory().equals(productRequest.getCategory()))) {
            product1.setCategory(productRequest.getCategory());
        }
        if (!(product1.getDescription().equals(productRequest.getDescription()))) {
            product1.setDescription(productRequest.getDescription());
        }
        if (!(product1.getPrice().equals(productRequest.getPrice()))) {
            product1.setPrice(productRequest.getPrice());
        }

        //CommonUtils.setUpdateEntityFields();
//        userRepository.save(userDetails);
        productRepo.save(product1);
    }


}
