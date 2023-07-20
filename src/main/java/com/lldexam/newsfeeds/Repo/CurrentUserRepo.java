package com.lldexam.newsfeeds.Repo;

import com.lldexam.newsfeeds.models.CurrentLoginUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrentUserRepo extends JpaRepository<CurrentLoginUser,Long> {
    @Override
    CurrentLoginUser save(CurrentLoginUser currentLoginUser);
    CurrentLoginUser findTopByOrderByIdDesc();
}
