package com.spendtrackingapplication.Spend.Tracking.Application.repository;

import com.spendtrackingapplication.Spend.Tracking.Application.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepo extends JpaRepository<Product,String> {

     //@Query(value = "SELECT * FROM spend_tracking.producttable where category=categories",nativeQuery = true)
     @Query(value="From Product where category=:categories")
    List<Product> getByCategories(@Param("categories") String categories);

//     @Query(value = "FROM Product where name=:name")
//     Product getProductByName(@Param("name") String name);

//     @Query(value = "delete name from producttable where id=id",nativeQuery = true)
//     void deleteProductByName(@Param("id") String id);

}
