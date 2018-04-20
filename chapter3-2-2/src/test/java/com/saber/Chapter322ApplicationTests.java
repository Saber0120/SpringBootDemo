package com.saber;

import com.saber.entity.User;
import com.saber.repository.UserRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Chapter322ApplicationTests {

	@Autowired
	private UserRepository userRepository;

	@Test
	public void contextLoads() {
	}

	@Before
	public void setUp() {
		userRepository.deleteAll();
	}

	@Test
	public void testUser() {
		userRepository.save(new User("a", 18));
		userRepository.save(new User("b", 18));
		userRepository.save(new User("c", 20));
		userRepository.save(new User("d", 20));
		userRepository.save(new User("e", 22));

		Assert.assertEquals(userRepository.findByName("a").getName(), "a");
		Assert.assertEquals(userRepository.findByNameAndAge("b", 18).getName(), "b");
		Assert.assertEquals(userRepository.findUser("c").getName(), "c");
		Assert.assertEquals(userRepository.findUserByAge(18).size(), 2);
	}
}
