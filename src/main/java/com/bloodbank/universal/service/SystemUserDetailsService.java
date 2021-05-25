package com.bloodbank.universal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bloodbank.universal.model.SystemUserDetails;
import com.bloodbank.universal.model.User;
import com.bloodbank.universal.repository.UserRepository;



@Service
public class SystemUserDetailsService implements UserDetailsService
{
	@Autowired
	UserRepository userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException 
	{
		System.out.println("Email"+userEmail);
		User user = userRepo.findByUserEmail(userEmail);
		System.out.println("user : "+user);
		
		return new SystemUserDetails(user);
	}

	
	
}
