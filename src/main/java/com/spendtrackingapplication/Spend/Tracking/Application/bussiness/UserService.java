package com.spendtrackingapplication.Spend.Tracking.Application.bussiness;

import com.spendtrackingapplication.Spend.Tracking.Application.entity.Product;
import com.spendtrackingapplication.Spend.Tracking.Application.entity.User;
import com.spendtrackingapplication.Spend.Tracking.Application.entity.UserWallet;
import com.spendtrackingapplication.Spend.Tracking.Application.model.Purchase;
import com.spendtrackingapplication.Spend.Tracking.Application.mongoRepository.PurchaseRepository;
import com.spendtrackingapplication.Spend.Tracking.Application.repository.ProductRepo;
import com.spendtrackingapplication.Spend.Tracking.Application.repository.UserRepository;
import com.spendtrackingapplication.Spend.Tracking.Application.repository.UserWalletRepository;
import com.spendtrackingapplication.Spend.Tracking.Application.request.RegistrationRequest;
import com.spendtrackingapplication.Spend.Tracking.Application.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.xml.bind.ValidationException;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserWalletRepository userWalletRepository;

    @Autowired
    private ProductRepo productRepo;

    private PurchaseRepository purchaseRepository;

    public List<Product> getByCategories(String categories){
        List<Product> list=(List<Product>) productRepo.getByCategories(categories);
        return list;
    }

    public UserWallet viewWallet(String id) {
        Optional<User> user = (Optional<User>)userRepository.findById(id);
        User userDetails = user.get();
        UserWallet userWallet= userWalletRepository.getUserWallet(userDetails.getId());
        return userWallet;
    }

    public void updateProfile(RegistrationRequest registrationRequest,String email) throws ValidationException {
        Optional<User> user = Optional.ofNullable(userRepository.getUserByemail(email));
        User userDetails = user.get();
        if(!user.isPresent()){
            throw new ValidationException(String.valueOf(HttpStatus.BAD_REQUEST.value()), "configuration does not exists for email::" + email);
        }
        if (!(userDetails.getEmail().equals(registrationRequest.getEmail()) )) {
            userDetails.setEmail(registrationRequest.getEmail());
        }
        if (!(userDetails.getFirstName().equals(registrationRequest.getFirstName()) )) {
            userDetails.setFirstName(registrationRequest.getFirstName());
        }
        if (!(userDetails.getLastName().equals(registrationRequest.getLastName()) )) {
            userDetails.setLastName(registrationRequest.getLastName());
        }
        if (!(userDetails.getEmail().equals(registrationRequest.getEmail()) )) {
            userDetails.setEmail(registrationRequest.getEmail());
        }
        if (!(userDetails.getPassword().equals(registrationRequest.getPassword()) )) {
            userDetails.setPassword(registrationRequest.getPassword());
        }
        if (!(userDetails.getMobilenNo().equals(registrationRequest.getMobileNo()) )) {
            userDetails.setMobilenNo(registrationRequest.getMobileNo());
        }
        if (!(userDetails.getCity().equals(registrationRequest.getCity()) )) {
            userDetails.setCity(registrationRequest.getCity());
        }
        if (!(userDetails.getActive().equals(registrationRequest.getActive()) )) {
            userDetails.setActive(registrationRequest.getActive());
        }

        CommonUtils.setUpdateEntityFields(user);
        userRepository.save(userDetails);
    }

    public List<User> registrationRequest(){
        List<User> list=(List<User>) userRepository.findAll();
        return list;
    }

//    public List<Purchase> getAllPurchases() {
//        List<Purchase> listOfPurchases = purchaseRepository.findAll();
//        return listOfPurchases;
//    }
}
