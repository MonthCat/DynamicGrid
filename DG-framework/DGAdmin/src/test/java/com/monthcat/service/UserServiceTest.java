package com.monthcat.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.fail;

import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.AssertThrows;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.monthcat.model.User;

@ContextConfiguration(locations = {
		"classpath:config/spring-config/spring.xml",
		"classpath:config/spring-config/spring-mvc.xml",
		"classpath:config/spring-config/spring-hibernate.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
@Transactional
public class UserServiceTest {

	@Before
	public void setUp() throws Exception {
	}

	@Autowired
	private UserService userService;

	@Test
	public void testAddUser() {
		User user = new User("nima", "bde");
		userService.addUser(user);
		assertNotEquals(0, user.getId());
	}

	@Test
	public void testUpdateUser() {
		User user = new User(2, "ad", "hj", 0, "fefe");
		userService.updateUser(user);
		assertEquals("fefe", userService.findUserById(2).getWebkey());
	}

	@Test
	public void testDeleteUser() {
		User user = new User(222, "ad", "hj", 0, null);
		userService.deleteUser(user);
		try {
			User newUser = userService.findUserById(222);
			assertEquals(null, newUser);
		} catch (Exception e) {
			assertEquals(org.hibernate.ObjectNotFoundException.class,
					e.getClass());
		}
	}

	@Test
	public void testFindUserById() {
		User u = userService.findUserById(0);
		assertEquals(0, u.getId());
	}

	@Test
	public void testFindAllUser() {
		Collection<User> u = userService.findAllUser();
		assertNotEquals(null, u);
		assertNotEquals(0, u.size());
	}

	@Test
	public void testFindUserByProperty() {
		Collection<User> u = userService.findUserByProperty("username", "ad");
		assertNotEquals(null, u);
		assertNotEquals(0, u.size());
	}

	@Test
	public void testFindByPropertyAndLimit() {
		Collection<User> u = userService.findByPropertyAndLimit("username",
				"ad", 0, 10);
		assertNotEquals(null, u);
		assertNotEquals(0, u.size());
	}

}
