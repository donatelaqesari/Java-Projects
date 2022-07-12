package com.betaplan.donatela.loginandregistration.services;

import com.betaplan.donatela.loginandregistration.models.User;
import com.betaplan.donatela.loginandregistration.repositories.UserRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository uRepo;

    public List<User> getAllUsers() {
        return this.uRepo.findAll();
    }

    public User getOneUser(Long id) {
        return this.uRepo.findById(id).orElse(null);
    }

    public User registerUser(User user) {
        //Generate the hash
        String hash = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        //Set the hashed password on the users password field
        user.setPassword(hash);
        //Save that new user password and user object to the database
        return this.uRepo.save(user);
    }

    //FOr the login of the user
    public boolean authenticateUser(String email, String password) {
        //Query the user by email
        User user = this.uRepo.findByEmail(email);

        if (user == null) {
            return false;
        }
        //step 2 check provided email against email in database
        return BCrypt.checkpw(password, user.getPassword());
    }

    public User getUserByEmail(String email) {
        return this.uRepo.findByEmail(email);
    }
}
