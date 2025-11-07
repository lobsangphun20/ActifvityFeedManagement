package com.intelliAM.feed.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.intelliAM.feed.Entity.Feed;
import com.intelliAM.feed.service.FeedService;

@RestController
@RequestMapping("/api/feed")
public class FeedController {
	
	@Autowired
	private FeedService feedService;

	/**
	 * @param feedObj
	 * @return
	 */
	@PostMapping
	public ResponseEntity<Feed> saveFeed(@RequestBody Feed feedObj) {
		Feed savedFeedObj = feedService.saveFeed(feedObj);
		return new ResponseEntity<>(savedFeedObj, HttpStatus.CREATED);
	}
	
	@GetMapping 
	public ResponseEntity<Feed> getFeed(@RequestParam long feedId) {
		Feed feedObj = feedService.getFeedById(feedId);
		return new ResponseEntity<>(feedObj, HttpStatus.OK);
	}
	
	@DeleteMapping("/{feedId}")
	public ResponseEntity<Void> deleteById(long feedId){
		feedService.deleteFeed(feedId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/getTimeline/{userId}")
	public ResponseEntity<List<Feed>> getTimeLine(long userId){
		/*
		 *  TODO: pagination to return few records at time
		 *  1. 
		 *  1. query = "select f. from Feed f
		 *  
		 */
		return null;
		
	}
}
