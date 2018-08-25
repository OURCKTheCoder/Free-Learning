package yiban.dorm.spring.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import yiban.dorm.dao.TagsRepository;
import yiban.dorm.dao.UserRepository;
import yiban.dorm.service.UserInfoMgr;

@Configuration
public class DefaultDataSourceConfig {
	
	@Bean
	public DataSource usersDataSource() {
		BasicDataSource ds = new BasicDataSource();
		ds.setUrl("jdbc:mysql://127.0.0.1:3306/dom_recommend?useSSL=false");
		ds.setUsername("root");
		ds.setPassword("voidPwd039");
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		return ds;
	}
	
	@Bean
	@Autowired
	public JdbcTemplate jdbcTemplate(DataSource ds) {
		return new JdbcTemplate(ds);
	}
	
	// Different repositories.
	
	@Bean
	public UserRepository userRepository(JdbcTemplate jdbcTemplate) {
		return new UserRepository(jdbcTemplate);
	}
	
	@Bean
	public TagsRepository tagsRepository(JdbcTemplate jdbcTemplate) {
		return new TagsRepository(jdbcTemplate);
	}
	
	@Bean
	public UserInfoMgr userInfoMgr() {
		return new UserInfoMgr();
	}
}
