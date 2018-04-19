package com.saber;

import com.saber.service.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Chapter321ApplicationTests {

	@Autowired
	private UserService userService;

	@Test
	public void contextLoads() {
	}

	@Before
	public void setUp() {
		userService.deleteAll();
	}

	@Test
	public void testUserService() {
		userService.create("a", 18);
		userService.create("b", 19);
		userService.create("c", 18);
		userService.create("d", 18);
		userService.create("e", 18);

		Assert.assertEquals(userService.getUserCount().intValue(), 5);

		userService.deleteByName("a");
		userService.deleteByName("b");

		Assert.assertEquals(userService.getUserCount().intValue(), 3);
	}
}
