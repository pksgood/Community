package com.pack.spring;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class OneDAO {

	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	public int insert(Map<String, Object> map) {
		return this.sqlSessionTemplate.insert("member.insert", map);
	}
	
	  //아이디 체크
	public int idChk(String uId) { 
		return this.sqlSessionTemplate.selectOne("member.idChk", uId);
	}
	
	//우편번호 체크
	public List<Map<String, Object>> zipChk(String area3){
		return this.sqlSessionTemplate.selectList("member.zipChk", area3);
	}
	//로그인
	public int login(Map<String, Object> map) {
		return this.sqlSessionTemplate.selectOne("member.login", map);
	}
	//회원정보수정
	public Map<String, Object> memberMod(String uId) {
		return this.sqlSessionTemplate.selectOne("member.memberMod", uId);
	}
	
	public int memberMod2(Map<String, Object> map){
		return this.sqlSessionTemplate.update("member.memberUp", map);
	}
	
	public int memberDelete(String uId) {
		return this.sqlSessionTemplate.delete("member.memberDel", uId);
	}
	
}
