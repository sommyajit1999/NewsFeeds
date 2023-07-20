package com.lldexam.newsfeeds.Service;

import com.lldexam.newsfeeds.Repo.CurrentUserRepo;
import com.lldexam.newsfeeds.Repo.UserRepository;
import com.lldexam.newsfeeds.models.CurrentLoginUser;
import com.lldexam.newsfeeds.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public void followUser(String name){
        CurrentLoginUser currentLoginUser=currentUserRepo.findTopByOrderByIdDesc();
        Optional<User> follower=userRepository.findById(currentLoginUser.getCurrentUser().getId());
        if(follower.isEmpty()){
            System.out.println("No Current User..Kindly Login");
            return;
        }
        Optional<User> following =userRepository.findByUserName(name);
        if(following.isEmpty()){
            System.out.println("No Such Account found");
            return;
        }

        User followers=follower.get();
        User followings=following.get();
        ArrayList<User> list=new ArrayList<>();
        list.add(followings);
        followers.setFollowing(list);
        list=new ArrayList<>();
        list.add(followers);
        followings.setFollowers(list);
        User user1=userRepository.save(followers);
        User user2=userRepository.save(followings);

        return;
    }

}
