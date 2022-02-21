package com.spendtrackingapplication.Spend.Tracking.Application.repository;

import com.spendtrackingapplication.Spend.Tracking.Application.entity.UserWallet;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserWalletRepository extends CrudRepository<UserWallet,String> {

    @Query(value = "select balance from tracking.userwallet right join tracking.users on tracking.userwallet.user_id=tracking.users.id;",nativeQuery = true)
    public String balanceUser(@Param("id") String id);

}
