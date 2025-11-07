package com.intelliAM.user.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.intelliAM.user.Entity.UserFollower;

public interface UserFollowerRepository extends JpaRepository<UserFollower, Long> {

	@Query(value = "SELECT u.followed_id from UserFollower u where u.user_id= ?1" , nativeQuery = true)
	List<Long> findAllFollowedIdByUserid(Long userID); // can be empty
}
