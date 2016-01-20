package kr.niee.mdt.config.service;

import java.util.List;
import java.util.Map;

public interface ApiUserCheckService {
	public boolean getApiUser(String userKey, String origin);
	public List<Map<String, Object>> getApiUsers();
}
