package com.lldexam.newsfeeds.Service;

import com.lldexam.newsfeeds.Repo.CurrentUserRepo;
import com.lldexam.newsfeeds.Repo.UserRepository;
import com.lldexam.newsfeeds.models.CurrentLoginUser;
import com.lldexam.newsfeeds.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;
    private CurrentUserRepo currentUserRepo;

    @Autowired
    public UserService(UserRepository userRepository,CurrentUserRepo currentUserRepo){
        this.userRepository=userRepository;
        this.currentUserRepo=currentUserRepo;

    }
    public User SignUpUser(String name, String password){
        User user=new User();
        user.setUserName(name);
        user.setPassword(password);
        return userRepository.save(user);
    }
    public User LoginUser(String name, String password){
        Optional<User> getUser=userRepository.findByUserNameAndPassword(name,password);
        if(getUser.isEmpty()){
            System.out.println("INVALID USERNAME OR PASSWORD!");
            return null;
        }
        User user= getUser.get();
        CurrentLoginUser currentLoginUser=new CurrentLoginUser();
        currentLoginUser.setCurrentUser(user);
        currentUserRepo.save(currentLoginUser);

        return user;
    }

}
