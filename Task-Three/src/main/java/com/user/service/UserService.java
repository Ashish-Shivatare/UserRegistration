package com.user.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.dao.UserDao;
import com.user.model.User;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;

	public int createUser(User user) {
		return this.userDao.saveUser(user);
	}

	public boolean login(String name, String password){
		System.out.println(this.userDao.searchUser(name, password)+ "search usr");
		return this.userDao.searchUser(name, password);
	}

	public boolean findEmail(String email){
		return this.userDao.searchEmail(email);
	}

}
