package com.spendtrackingapplication.Spend.Tracking.Application.repository;

import com.spendtrackingapplication.Spend.Tracking.Application.entity.ProductStock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductStockRepo extends JpaRepository<ProductStock,String> {

}
