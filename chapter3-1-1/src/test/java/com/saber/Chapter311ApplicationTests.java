package com.saber;

import com.saber.controller.UserController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Chapter311ApplicationTests {

	MockMvc mvc = null;

	@Before
	public void setUp() throws Exception {
		mvc = MockMvcBuilders.standaloneSetup(new UserController()).build();
	}

	@Test
	public void contextLoads() {
	}

	@Test
	public void testUser() throws Exception {
		// 1.检查get接口
		mvc.perform(MockMvcRequestBuilders.get("/users")).
				andExpect(status().isOk()).
				andExpect(content().string(equalTo("[]")));

		// 2.post提交一个user
		mvc.perform(MockMvcRequestBuilders.post("/users").
				param("id", "1").
				param("name", "Saber").
				param("age", "28")
		).andExpect(status().isOk()).andExpect(content().string(equalTo("success")));

		// 3.查询刚才插入的数据
		mvc.perform(MockMvcRequestBuilders.get("/users")).
				andExpect(status().isOk()).
				andExpect(content().string(equalTo("[{\"id\":1,\"name\":\"Saber\",\"age\":28}]")));

		// 4.get获取一个用户信息
		mvc.perform(MockMvcRequestBuilders.get("/users/1")).
				andExpect(status().isOk()).
				andExpect(content().string(equalTo("{\"id\":1,\"name\":\"Saber\",\"age\":28}")));

		// 5.put修改一个用户信息
		mvc.perform(MockMvcRequestBuilders.put("/users/1")).
				andExpect(status().isOk()).
				andExpect(content().string(equalTo("success")));

		// 6.delete删除一个用户
		mvc.perform(MockMvcRequestBuilders.delete("/users/1")).
				andExpect(status().isOk()).
				andExpect(content().string(equalTo("success")));

		// 6.
	}
}
