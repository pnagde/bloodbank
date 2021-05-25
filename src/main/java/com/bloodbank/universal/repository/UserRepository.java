package com.bloodbank.universal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bloodbank.universal.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> 
{
	public User findByUserEmail(String userEmail);
}
