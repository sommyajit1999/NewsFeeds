package com.lldexam.newsfeeds.showFeedStrategy;

import com.lldexam.newsfeeds.models.Feeds;

import java.util.List;
import java.util.Optional;

public interface showFeedsStrategy {
    List<Feeds> showFeeds(Optional<List<Feeds>> feedsList);
}
