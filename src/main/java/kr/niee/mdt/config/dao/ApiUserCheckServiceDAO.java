package kr.niee.mdt.config.dao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("apiUserCheckServiceDAO")
public class ApiUserCheckServiceDAO {
	
	@Autowired
	private JdbcTemplate template;
	
	public Map<String, Object> getApiUser(String userKey, String origin){
		Map<String, Object> result= null;
		try{
			result = template.queryForMap("select * from apiuser where userKey = ? and origin = ?",userKey, origin);
		}catch(EmptyResultDataAccessException erdae){
			erdae.printStackTrace();
		}
		return result;
	}
	
}
