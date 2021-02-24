package com.arishin.spring;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

public class StudentJDBCTemplate implements StudentDAO {
   private DataSource dataSource;
   private JdbcTemplate jdbcTemplateObject;
   
   public void setDataSource(DataSource dataSource) {
      this.dataSource = dataSource;
      this.jdbcTemplateObject = new JdbcTemplate(dataSource);
   }
   public Student getStudent(Integer id) {
      SimpleJdbcCall jdbcCall = new 
         SimpleJdbcCall(dataSource).withProcedureName("getRecord");

      SqlParameterSource in = new MapSqlParameterSource().addValue("in_id", id);
      Map<String, Object> out = jdbcCall.execute(in);

      Student student = new Student();
      student.setId(id);
      student.setName((String) out.get("out_name"));
      student.setAge((Integer) out.get("out_age"));
      return student;      
   }
public void create(String name, Integer age) {
	// TODO Auto-generated method stub
	
}
public List<Student> listStudents() {
	// TODO Auto-generated method stub
	return null;
}
}