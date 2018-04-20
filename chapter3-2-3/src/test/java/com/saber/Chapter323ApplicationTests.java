package com.saber;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Chapter323ApplicationTests {

	@Autowired
	@Qualifier("primaryJdbcTemplate")
	private JdbcTemplate primaryJdbcTemplate;

	@Autowired
	@Qualifier("secondaryJdbcTemplate")
	private JdbcTemplate secondaryJdbcTemplate;

	@Test
	public void contextLoads() {
	}

	@Before
	public void setUp() {
		primaryJdbcTemplate.update("DELETE FROM USER ");
		secondaryJdbcTemplate.update("DELETE FROM USER ");
	}

	@Test
	public void testMultiJdbcTemplate() {
		primaryJdbcTemplate.update("INSERT INTO USER (name,age) VALUES (?,?)", "aa", 18);
		primaryJdbcTemplate.update("INSERT INTO USER (name,age) VALUES (?,?)", "bb", 19);

		secondaryJdbcTemplate.update("INSERT INTO USER (name,age) VALUES (?,?)", "cc", 20);
		secondaryJdbcTemplate.update("INSERT INTO USER (name,age) VALUES (?,?)", "dd", 21);
		secondaryJdbcTemplate.update("INSERT INTO USER (name,age) VALUES (?,?)", "ee", 22);

		Assert.assertEquals(primaryJdbcTemplate.queryForObject("SELECT count(1) FROM USER", String.class), "2");
		Assert.assertEquals(secondaryJdbcTemplate.queryForObject("SELECT count(1) FROM USER", String.class), "3");
	}
}
