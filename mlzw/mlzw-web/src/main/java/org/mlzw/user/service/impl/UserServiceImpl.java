package org.mlzw.user.service.impl;

import java.util.List;

import org.mlzw.user.dao.UserDao;
import org.mlzw.user.entity.User;
import org.mlzw.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	public List<User> queryList() {
		return userDao.queryList();
	}
}
