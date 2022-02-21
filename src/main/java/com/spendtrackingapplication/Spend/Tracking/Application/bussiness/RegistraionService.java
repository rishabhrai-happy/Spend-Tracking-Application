package com.spendtrackingapplication.Spend.Tracking.Application.bussiness;

import com.spendtrackingapplication.Spend.Tracking.Application.entity.Role;
import com.spendtrackingapplication.Spend.Tracking.Application.entity.User;
import com.spendtrackingapplication.Spend.Tracking.Application.entity.UserWallet;
import com.spendtrackingapplication.Spend.Tracking.Application.entity.Wallet;
import com.spendtrackingapplication.Spend.Tracking.Application.enums.RoleType;
import com.spendtrackingapplication.Spend.Tracking.Application.enums.WalletType;
import com.spendtrackingapplication.Spend.Tracking.Application.repository.RoleRepository;
import com.spendtrackingapplication.Spend.Tracking.Application.repository.UserRepository;
import com.spendtrackingapplication.Spend.Tracking.Application.repository.UserWalletRepository;
import com.spendtrackingapplication.Spend.Tracking.Application.repository.WalletRepository;
import com.spendtrackingapplication.Spend.Tracking.Application.request.RegistrationRequest;
import com.spendtrackingapplication.Spend.Tracking.Application.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistraionService {
    @Autowired
    private WalletRepository walletRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserWalletRepository userWalletRepository;
    public void register(RegistrationRequest registrationRequest) {
        User user = new User();
        user.setId(CommonUtils.generateUUID());
        user.setEmail(registrationRequest.getEmail());
        user.setPassword(registrationRequest.getPassword());
        user.setFirstName(registrationRequest.getFirstName());
        user.setLastName(registrationRequest.getLastName());
        user.setCity(registrationRequest.getCity());
        user.setMobilenNo(registrationRequest.getMobileNo());
        user.setActive("true");
        CommonUtils.setCreateEntityFields(user);
        CommonUtils.setUpdateEntityFields(user);
       //Wallet wallet=walletRepository.findById(registrationRequest.getWalletId()).get();
        Wallet wallet=walletRepository.getProductByName(WalletType.BASIC.getName());
        Role role=roleRepository.getRoleByName(RoleType.END_USER.name());
        user.setRole(role);
        user.setWallet(wallet);
        userRepository.save(user);
        UserWallet userWallet= new UserWallet();
        userWallet.setId(CommonUtils.generateUUID());
        userWallet.setBalance(wallet.getAmount());
        userWallet.setUser(user);
        userWallet.setWallet(wallet);
        userWalletRepository.save(userWallet);
    }
}


