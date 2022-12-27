package com.pack.spring;

import java.util.List;
import java.util.Map;

public interface OneService {
	
	String index();
	
	boolean create(Map<String, Object> map);
	
	boolean idChk(String uId);
	
	List<Map<String, Object>> zipChk(String area3);
	
	boolean login(Map<String, Object> map);
	
	Map<String, Object> memberMod(String uId);
	
	boolean memberMod2(Map<String, Object> map);
	
	boolean memberDelete(String uId);
	
}
