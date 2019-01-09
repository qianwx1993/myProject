package com.qwx.myProject;

import com.qwx.myProject.mapper.CityMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MyProjectApplication.class)
public class MyProjectApplicationTests {

	@Autowired
	@Qualifier("primaryJdbcTemplate")
	private JdbcTemplate jdbcTemplate1;

	@Autowired
	@Qualifier("secondaryJdbcTemplate")
	private JdbcTemplate jdbcTemplate2;

	@Autowired
	private CityMapper cityMapper;

	@Test
	public void contextLoads() {
		SqlRowSet sqlRowSet = jdbcTemplate1.queryForRowSet("select *from city");
		System.out.println("####################"+sqlRowSet.toString());
	}

	@Test
	public void findCityByName(){

	}
}
