package com.pack.spring;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OneServiceImp implements OneService{
	
	@Autowired
	OneDAO dao;
	//메인페이지 시작~~~~~~~~~~~~~~~~~~~~~~~
	@Override
	public String index() {
		return null;
	}
	//메인페이지 끝~~~~~~~~~~~~~~~~~~~~~~
	//회원가입 시작~~~~~~~~~~~~~~~~~~
	@Override
	public boolean create(Map<String, Object> map) {
		boolean res = false;
		int cnt = this.dao.insert(map);
		if (cnt == 1) res = true;
		return res;
	}
	//회원가입 끝~~~~~~~~~~~~~~~~~~~~~~~~~
	@Override
	public boolean idChk(String uId) {
		boolean res = false;
		int cnt =  this.dao.idChk(uId);
		if (cnt == 1) res = true;
		return res;
	}
	@Override
	public List<Map<String, Object>> zipChk(String area3) {
		List<Map<String, Object>> list = this.dao.zipChk(area3);
		return list;
	}
	
	@Override
	public boolean login(Map<String, Object> map) {
		boolean res = false;
		int cnt =  this.dao.login(map);
		if (cnt == 1) res = true;
		return res; 
	}
	
	@Override
	public Map<String, Object> memberMod(String uId) {
		Map<String, Object> map  = this.dao.memberMod(uId);
		return map;
	}
	@Override
	public boolean memberMod2(Map<String, Object> map) {
		boolean res = false;
		int cnt =  this.dao.memberMod2(map);
		if (cnt == 1) res = true;
		return res;
	}
	
	@Override
	public boolean memberDelete(String uId) {
		boolean res = false;
		int cnt =  this.dao.memberDelete(uId);
			if (cnt == 1) res = true;
		return res;
	}
}
