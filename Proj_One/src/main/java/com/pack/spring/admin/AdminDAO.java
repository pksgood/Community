package com.pack.spring.admin;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AdminDAO {
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	
	public List<Map<String, Object>> m_selectList(Map<String, Object> map){
		return this.sqlSessionTemplate.selectList("admin.m_list", map);
	}
	
	public int mc_list() {
		return this.sqlSessionTemplate.selectOne("admin.mc_list");
	}
	

	public Map<String, Object> m_detail(int num) {
		 return this.sqlSessionTemplate.selectOne("admin.m_detail", num);
	}
	
	
	
	
	/**
	 * 공지게시판 전체 조회
	 * @param map
	 * @return
	 */
	public List<Map<String, Object>> a_selectList(Map<String, Object> map) {
		return this.sqlSessionTemplate.selectList("admin.a_list", map);
	}
	
	
	/**
	 * 게시글 작성
	 * @param map
	 * @return
	 */
	public int a_insert(Map<String, Object> map) {
		return this.sqlSessionTemplate.insert("admin.a_insert", map);
	}
	
	
	/**
	 * 아이디로 이름 찾기
	 * @param uId
	 * @return
	 */
	public String getName(String uId) {
		return this.sqlSessionTemplate.selectOne("admin.getName", uId);
	}
	
	
	/**
	 * ref 최대값 찾기
	 * @param map
	 * @return
	 */
	public int getMaxNum(Map<String, Object> map) {
		return this.sqlSessionTemplate.selectOne("admin.getMaxNum", map);
	}
	
	
	
	
	/**
	 * 게시글 상세보기
	 * @param map
	 * @return
	 */
	public Map<String, Object> a_selectDetail(int num) {
		 return this.sqlSessionTemplate.selectOne("admin.detail", num);
	}
	
	
	/**
	 * 게시글 삭제
	 * @param num
	 * @return
	 */
	public int a_delete(int num) {
		return this.sqlSessionTemplate.delete("admin.delete", num);
	}
	
	
	/**
	 * 게시글 수정
	 * @param map
	 * @return
	 */
	public int a_update(Map<String, Object> map) {
		return this.sqlSessionTemplate.update("admin.update", map);
	}
	
	
	/**
	 * 조회수 증가
	 * @param num
	 * @return
	 */
	public int a_upCnt(int num) {
		return this.sqlSessionTemplate.update("admin.upCnt",num);
	}
	
	
	/**
	 * 전체 레코드 수 조회
	 * @return
	 */
	public int countList() {
		return this.sqlSessionTemplate.selectOne("admin.c_list");
	}
	
	
	/**
	 * 커멘트 리스트
	 * @param num
	 * @return
	 */
	public List<Map<String, Object>> CommentsList(int num){
		return this.sqlSessionTemplate.selectList("admin.Commentslist", num);
	}
	
	
	
	/**
	 * 커멘트 작성하기
	 * @param map
	 * @return
	 */
	public int insertCom(Map<String, Object> map){
		return this.sqlSessionTemplate.insert("admin.insertCom", map);
	}
}
