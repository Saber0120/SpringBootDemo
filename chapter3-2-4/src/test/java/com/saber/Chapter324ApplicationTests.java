package com.saber;

import com.saber.entity.p.User;
import com.saber.entity.s.Message;
import com.saber.repository.p.UserRepository;
import com.saber.repository.s.MessageRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Chapter324ApplicationTests {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private MessageRepository messageRepository;

	@Test
	public void contextLoads() {
	}

	@Before
	public void setUp() {
		userRepository.deleteAll();
		messageRepository.deleteAll();
	}

	@Test
	public void testJpaMultiDataSource() {
		userRepository.save(new User("aa", 18));
		userRepository.save(new User("bb", 19));
		Assert.assertEquals(userRepository.findAll().size(), 2);

		messageRepository.save(new Message("cc", "cccontent"));
		messageRepository.save(new Message("dd", "ddcontent"));
		messageRepository.save(new Message("ee", "eecontent"));
		Assert.assertEquals(messageRepository.findAll(), 3);
	}
}
