package com.saber;

import com.saber.config.UserConfiguration;
import com.saber.config.UserProperties;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Chapter211ApplicationTests {

	@Autowired
	private UserProperties userProperties;

	@Autowired
	private UserConfiguration userConfiguration;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testProperties() {
		Assert.assertEquals(userProperties.getName(), "saber");
		Assert.assertEquals(userProperties.getAddress(), "shanghai");
		Assert.assertEquals(userProperties.getDesc(), "saber正在努力学习springboot");
	}

	@Test
	public void testConfiguration() {
		Assert.assertEquals(userConfiguration.getName(), "saber");
		Assert.assertEquals(userConfiguration.getAddress(), "shanghai");
		Assert.assertEquals(userConfiguration.getDesc(), "saber正在努力学习springboot");
	}
}
