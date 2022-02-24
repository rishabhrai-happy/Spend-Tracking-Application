package com.spendtrackingapplication.Spend.Tracking.Application.init;

import com.spendtrackingapplication.Spend.Tracking.Application.entity.Role;
import com.spendtrackingapplication.Spend.Tracking.Application.entity.User;
import com.spendtrackingapplication.Spend.Tracking.Application.entity.Wallet;
import com.spendtrackingapplication.Spend.Tracking.Application.enums.RoleType;
import com.spendtrackingapplication.Spend.Tracking.Application.enums.WalletType;
import com.spendtrackingapplication.Spend.Tracking.Application.repository.RoleRepository;
import com.spendtrackingapplication.Spend.Tracking.Application.repository.UserRepository;
import com.spendtrackingapplication.Spend.Tracking.Application.repository.WalletRepository;
import com.spendtrackingapplication.Spend.Tracking.Application.utils.CommonUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Component
public class BootstrapData implements InitializingBean {

    private static final Logger LOG
            = Logger.getLogger(BootstrapData.class.toString());

    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private WalletRepository walletRepository;

    @Autowired
    private UserRepository userRepository;


    @Override
    public void afterPropertiesSet() throws Exception {

        if (roleRepository.findAll().isEmpty()) {

            List<Role> roleList = new ArrayList<>();
            Role endUser = new Role();
            endUser.setId(CommonUtils.generateUUID());
            endUser.setName(RoleType.END_USER.name());
            endUser.setDiscription("This is End User Role");
            roleList.add(endUser);
            Role admin = new Role();
            admin.setId(CommonUtils.generateUUID());
            admin.setName(RoleType.SYSTEM_ADMIN.name());
            admin.setDiscription("This ia admin");
            roleList.add(admin);
            roleRepository.saveAll(roleList);
        }

        if (walletRepository.findAll().isEmpty()) {

            List<Wallet> walletList = new ArrayList<>();
            Wallet basic = new Wallet();
            basic.setId(CommonUtils.generateUUID());
            basic.setAmount(WalletType.BASIC.getAmount().toString());
            basic.setWalletType(WalletType.BASIC.getName());
            basic.setDescription("This is basic amount");
            walletList.add(basic);
            Wallet standard = new Wallet();
            standard.setId(CommonUtils.generateUUID());
            standard.setAmount(WalletType.STANDARD.getAmount().toString());
            standard.setWalletType(WalletType.STANDARD.getName());
            standard.setDescription("This is standard amount");
            walletList.add(standard);
            Wallet premium = new Wallet();
            premium.setId(CommonUtils.generateUUID());
            premium.setAmount(WalletType.PREMIUM.getAmount().toString());
            premium.setWalletType(WalletType.PREMIUM.getName());
            premium.setDescription("This is premium amount");
            walletList.add(premium);
            walletRepository.saveAll(walletList);
        }

        if(userRepository.findAll().isEmpty()) {
            User user = new User();
            Role role = roleRepository.getRoleByName(RoleType.SYSTEM_ADMIN.name());
            user.setFirstName("Rishabh");
            user.setMobilenNo("9616239145");
            user.setId(CommonUtils.generateUUID());
            user.setCity("mathura");
            user.setLastName("Rai");
            user.setActive("true");
            user.setEmail("rishabhrai980@gmail.com");
            user.setPassword("123456789");
            CommonUtils.setCreateEntityFields(user);
            CommonUtils.setUpdateEntityFields(user);
            user.setRole(role);
            userRepository.save(user);
        }


    }
}
