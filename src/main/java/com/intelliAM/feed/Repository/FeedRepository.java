package com.intelliAM.feed.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.intelliAM.feed.Entity.Feed;

@Repository
public interface FeedRepository extends JpaRepository<Feed, Long>{

	
	// Custom query to be added if needed
	//@Query(value = "SELECT * from Feed f where f.user_id= ?1" , nativeQuery = true)
	// We are using inbuild queryGenerator by following naming convention
	public List<Feed> findAllByUserId(Long id);
}
