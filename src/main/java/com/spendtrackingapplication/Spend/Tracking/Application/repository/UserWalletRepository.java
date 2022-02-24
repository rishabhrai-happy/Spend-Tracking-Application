package com.spendtrackingapplication.Spend.Tracking.Application.repository;

import com.spendtrackingapplication.Spend.Tracking.Application.entity.UserWallet;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserWalletRepository extends CrudRepository<UserWallet,String> {

    @Query(value = "From UserWallet where user_id=:id")
    UserWallet getUserWallet(@Param("id") String id);
}