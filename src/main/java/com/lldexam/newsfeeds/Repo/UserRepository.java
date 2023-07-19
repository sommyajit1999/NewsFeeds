package com.lldexam.newsfeeds.Repo;

import com.lldexam.newsfeeds.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    @Override
         User save(User user);
        Optional<User> findByUserNameAndPassword(String name, String password);
}
