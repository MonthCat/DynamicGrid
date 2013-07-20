package com.monthcat.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.monthcat.dao.ObjectDaoI;
import com.monthcat.model.User;

@Service("userService")
@Transactional
public class UserService {
	@Autowired
	private ObjectDaoI<User> userDaoI;

	public void addUser(User user) {
		userDaoI.save(user);
	}

	public void updateUser(User user) {
		userDaoI.update(user);
	}

	public void deleteUser(User user) {
		userDaoI.delete(user);
	}

	public User findUserById(Integer id) {
		return userDaoI.findById(User.class, id);
	}

	public Collection<User> findAllUser() {
		return userDaoI.findAll(User.class);
	}

	public Collection<User> findUserByProperty(String propertyName, Object value) {
		return userDaoI.findByProperty(User.class, propertyName, value);
	}

	public Collection<User> findByPropertyAndLimit(String propertyName,
			Object value, Integer start, Integer limit) {
		return userDaoI.findByPropertyAndLimit(User.class, propertyName, value,
				start, limit);
	}
}
