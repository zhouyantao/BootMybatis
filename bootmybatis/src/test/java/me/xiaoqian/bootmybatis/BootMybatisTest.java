package me.xiaoqian.bootmybatis;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import me.xiaoqian.bootmybatis.model.User;
import me.xiaoqian.bootmybatis.model.UserMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes=BootMybatisApplication.class)
public class BootMybatisTest {
	@Autowired
	private UserMapper userMapper;
	
	@Test
	@Rollback
	public void findByName() throws Exception {
		userMapper.insert("周燕涛",20);
		User user = userMapper.findByName("周燕涛");
		Assert.assertEquals(20,user.getAge().intValue());
		
	}
}
