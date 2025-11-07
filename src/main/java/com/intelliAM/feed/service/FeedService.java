package com.intelliAM.feed.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intelliAM.feed.Entity.Feed;
import com.intelliAM.feed.Repository.FeedRepository;

@Service
public class FeedService {

	@Autowired
	private FeedRepository feedRepository;
	
	//post new feed
	/**
	 * @param feedObj
	 * @return
	 */
	public Feed saveFeed(Feed feedObj) {
		Feed fObj = feedRepository.save(feedObj);
		return fObj;
	}
	
	/**
	 * @param feedId
	 */
	public void deleteFeed(long feedId) {
		feedRepository.deleteById(feedId);
	}
	
	/**
	 * @param feedId
	 * @return feed object 
	 */
	public Feed getFeedById(long feedId) {
		Feed fObj = feedRepository.getReferenceById(feedId);
		return fObj;
	}
	
	// TODO: update Feed
	
	
	
	/**
	 * This method is useful in two scenarios. 
	 * 
	 * 1. User own Feed history
	 * 2. To populate timeline of another user 
	 * note: timeline population logic. 
	 * If user1 is following user2 and user3.
	 * - pull all feeds of user2 and user3 using below method.
	 * - sort by timestamp when displaying, don't forget to filter from timeline by checking viewedFlag
	 * - clean up timeline table consistently by deleting entry from it based timestamp.
	 * -(later on we can create timeline table on demand when user session is active and drop table when session timed out.)
	 * @param userId
	 * @return List of all feed by particular users.
	 */
	public List<Feed> getAllFeedByUserID(long userId){
		 List<Feed> feedList = feedRepository.findAllByUserId(userId);
		 return feedList;
	}
}
