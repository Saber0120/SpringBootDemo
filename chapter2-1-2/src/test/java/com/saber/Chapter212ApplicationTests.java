package com.saber;

import com.saber.config.UserConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Chapter212ApplicationTests {

	@Autowired
	private UserConfig config;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testConfig() {
//		Assert.assertEquals(config.getUsername(), "saber");

		Assert.assertEquals(config.getUrl().size(), 2	);
	}
}
