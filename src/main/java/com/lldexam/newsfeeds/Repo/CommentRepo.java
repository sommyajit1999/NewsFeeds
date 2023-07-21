package com.lldexam.newsfeeds.Repo;

import com.lldexam.newsfeeds.models.Comments;
import com.lldexam.newsfeeds.models.Feeds;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentRepo extends JpaRepository<Comments,Long> {
    @Override
    Comments save(Comments comments);
    Optional<List<Comments>> findAllByFeeds(Feeds feeds);
}
