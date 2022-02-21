package com.spendtrackingapplication.Spend.Tracking.Application.repository;

import com.spendtrackingapplication.Spend.Tracking.Application.entity.Role;
import com.spendtrackingapplication.Spend.Tracking.Application.entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface WalletRepository extends JpaRepository<Wallet,String> {

    @Query(value="From Wallet where walletType=:walletType")
    Wallet getProductByName(@Param("walletType") String name);
}
