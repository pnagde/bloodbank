package com.bloodbank.universal.service;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManagerFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bloodbank.universal.model.BloodRequest;
import com.bloodbank.universal.repository.BloodRequestRepository;

@Service
public class BloodRequestService 
{
	@Autowired
	private BloodRequestRepository bloodRequestRepository;
	
	@Autowired
	private EntityManagerFactory entityManagerFactory;

	public Session giveSession() 
	{
		SessionFactory sessionFactory = entityManagerFactory.unwrap(SessionFactory.class);
		Session ss = sessionFactory.openSession();
		return ss;
	}
	
	public boolean save(BloodRequest ob) 
    {      
         ob.setSendDate(new Date());
         ob.setStatus(true);
         bloodRequestRepository.save(ob);
         return true;
    }
	
	 public List<BloodRequest> getAll() 
     {
		 List<BloodRequest> list  = bloodRequestRepository.findAll();   
		 return list;
	 }
}
