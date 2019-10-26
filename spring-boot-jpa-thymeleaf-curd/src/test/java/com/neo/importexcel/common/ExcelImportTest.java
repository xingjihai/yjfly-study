package com.neo.importexcel.common;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ExcelImportTest {
	@Autowired
	ApplicationContext applicationContext;

	@Test
	public void contextLoads() {
		System.out.println("Hello Spring Boot 2.0!");
	}

	@Test
	public void getBeans(){
		Map<String, TableFieldInterface> map = applicationContext.getBeansOfType(TableFieldInterface.class);
		System.out.println(map);
	}
}
