package com.user.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.user.model.User;


@Repository
public class UserDao {
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Transactional
	public int saveUser(User user) {
		int id = (Integer) this.hibernateTemplate.save(user);
		return id;
	}
		
	public boolean searchUser(String name, String password) {
        boolean isValidUser = false;
		
		User user = new User();
	    user.setName(name);
	    user.setPassword(password);

	    List<User> existUserObj = this.hibernateTemplate.findByExample(user);
	    
	    if(existUserObj != null && existUserObj.size() > 0)
	    {
	    	isValidUser = true;
	    }
	    return isValidUser;
    }
	
	public boolean searchEmail(String email) {
        boolean isValidUser = false;
		
		User user = new User();
	    user.setEmail(email);

	    List<User> existUserObj = this.hibernateTemplate.findByExample(user);
	    if(existUserObj != null && existUserObj.size() > 0)
	    {
	    	isValidUser = true;
	    }
	    return isValidUser;
    }
}