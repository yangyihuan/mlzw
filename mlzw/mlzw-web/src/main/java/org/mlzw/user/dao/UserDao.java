package org.mlzw.user.dao;

import java.util.List;

import org.mlzw.user.entity.User;
import org.springframework.stereotype.Repository;

@Repository("userDao")
public interface UserDao {

	public List<User> queryList();
	
}
