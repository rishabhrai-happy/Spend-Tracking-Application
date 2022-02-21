package com.spendtrackingapplication.Spend.Tracking.Application.repository;

import com.spendtrackingapplication.Spend.Tracking.Application.entity.User;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<User,String> {

}
//"select balance from user_wallet_table join users_data where users_data.id=user_wallet_table.user_id"