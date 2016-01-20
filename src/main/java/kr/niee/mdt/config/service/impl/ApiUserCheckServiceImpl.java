package kr.niee.mdt.config.service.impl;

import java.util.List;
import java.util.Map;

import kr.niee.mdt.config.dao.ApiUserCheckServiceDAO;
import kr.niee.mdt.config.service.ApiUserCheckService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("apiUserCheckService")
@Transactional(readOnly=true)
public class ApiUserCheckServiceImpl implements ApiUserCheckService{

	@Autowired
	private ApiUserCheckServiceDAO apiUserCheckServiceDAO;
	
	@Override
	public boolean getApiUser(String userKey, String origin) {
		// TODO Auto-generated method stub
		Map<String, Object> map = apiUserCheckServiceDAO.getApiUser(userKey, origin); 
		return map!=null?true:false;
	}

	@Override
	public List<Map<String, Object>> getApiUsers() {
		// TODO Auto-generated method stub
		return apiUserCheckServiceDAO.getApiUsers();
	}
	
}
