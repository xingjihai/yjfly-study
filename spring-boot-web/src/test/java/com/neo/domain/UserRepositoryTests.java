package com.neo.domain;

import java.text.DateFormat;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.neo.Application;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTests {

	@Autowired
	private UserRepository userRepository;

	@Test
	public void test() throws Exception {
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);        
		String formattedDate = dateFormat.format(date);

//		userRepository.save(new User( "aa@126.com","aa1",  "aa123456","aa",formattedDate));
//		userRepository.save(new User( "bb@126.com","bb2",  "bb123456","bb",formattedDate));
//		userRepository.save(new User( "cc@126.com","cc3",  "cc123456","cc",formattedDate));


//		Assert.assertEquals(9, userRepository.findAll().size());
		Assert.assertEquals("bb2", userRepository.findByUserNameOrEmail("bb", "bb@126.com").getNickName());
		userRepository.delete(userRepository.findByUserName("aa"));
	}

}