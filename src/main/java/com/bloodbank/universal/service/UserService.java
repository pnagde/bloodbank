package com.bloodbank.universal.service;

import java.util.List;

import javax.persistence.EntityManagerFactory;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bloodbank.universal.model.User;
import com.bloodbank.universal.repository.UserRepository;

@Service
public class UserService 
{
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private EntityManagerFactory entityManagerFactory;

	public Session giveSession() 
	{
		SessionFactory sessionFactory = entityManagerFactory.unwrap(SessionFactory.class);
		Session ss = sessionFactory.openSession();
		return ss;
	}
	
	public boolean saveUser(User user) 
	{
		user.setActiveStatus(true);
        user.setVerifyStatus(false);
        user.setRoles("ROLE_DONOR");
        	User u = userRepository.save(user);
    		user.setUserId(u.getUserId());
    		System.out.println(user.toString());
		return true;
	}
	
	public boolean updateUser(User user) 
	{		
		userRepository.save(user);
		return true;
	}
	
	public User checkUser(String email, String password) 
    {
        Session session = giveSession();
        Query<User> query = session.createQuery("from User where userEmail=:em and userPassword=:pd");
        query.setParameter("em", email);
        query.setParameter("pd", password);        
        Object ob = query.uniqueResult();
                
        session.close();        
        if(ob==null)
            return null;
        else
            return (User)ob;        
    }
	
	public List<User> search(String bloodgroup)
    {
        Session session = giveSession();
        Query query = session.createQuery("from User where userBloodGroup=:bg"
              + " and activeStatus=true order by userName");
        query.setString("bg",bloodgroup);      
     
        return query.list();       
    }

	public boolean changePassword(int userId, String oldpass, String newpass) 
	{
		User user = userRepository.getOne(userId);
		if(user!=null) {
			if(user.getPassword().equals(oldpass)) 
			{
				user.setPassword(newpass);
				userRepository.save(user);
				return true;
			}
		}
		return false;
	}

}
