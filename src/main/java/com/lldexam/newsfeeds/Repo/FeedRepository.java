package com.lldexam.newsfeeds.Repo;

import com.lldexam.newsfeeds.models.Feeds;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FeedRepository extends JpaRepository<Feeds,Long> {
    @Override
    Feeds save(Feeds feeds);


    Optional<List<Feeds>> findAllByUserId(Long along);
}
