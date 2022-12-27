package com.pack.spring.bbs;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BbsDAO {
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	/**
	 * 게시글 작성
	 * @param map
	 * @return
	 */
	public int b_insert(Map<String, Object> map) {
		return this.sqlSessionTemplate.insert("bbs.b_insert", map);
	}
	
	
	/**
	 * 아이디로 이름 찾기
	 * @param uId
	 * @return
	 */
	public String getName(String uId) {
		return this.sqlSessionTemplate.selectOne("bbs.getName", uId);
	}
	
	
	/**
	 * ref 최대값 찾기
	 * @param map
	 * @return
	 */
	public int getMaxNum(Map<String, Object> map) {
		return this.sqlSessionTemplate.selectOne("bbs.getMaxNum", map);
	}
	
	
	/**
	 * 게시글 전체보기
	 * @param map
	 * @return
	 */
	public List<Map<String, Object>> b_selectList(Map<String, Object> map) {
		return this.sqlSessionTemplate.selectList("bbs.b_list", map);
		}
	
	
	/**
	 * 게시글 상세보기
	 * @param map
	 * @return
	 */
	public Map<String, Object> b_selectDetail(int num) {
		 return this.sqlSessionTemplate.selectOne("bbs.b_detail", num);
	}
	
	
	/**
	 * 게시글 삭제
	 * @param num
	 * @return
	 */
	public int b_delete(int num) {
		return this.sqlSessionTemplate.delete("bbs.b_delete", num);
	}
	
	
	/**
	 * 게시글 수정
	 * @param map
	 * @return
	 */
	public int b_update(Map<String, Object> map) {
		return this.sqlSessionTemplate.update("bbs.b_update", map);
	}
	
	
	/**
	 * 조회수 증가
	 * @param num
	 * @return
	 */
	public int b_upCnt(int num) {
		return this.sqlSessionTemplate.update("bbs.b_upCnt",num);
	}
	
	
	/**
	 * 전체 레코드 수 조회
	 * @return
	 */
	public int c_list() {
		return this.sqlSessionTemplate.selectOne("bbs.c_list");
	}
	
	
	/**
	 * 답변 작성
	 * @param map
	 * @return
	 */
	public int com_insert(Map<String, Object> map) {
		return this.sqlSessionTemplate.insert("bbs.com_insert", map);
	}
	
	public int com_upPos(Map<String, Object> map) {
		return this.sqlSessionTemplate.update("bbs.com_update", map);
	}
	

	/**
	 * 게시글 번호로 제목, 내용, 작성자 이름 찾기
	 * @param num
	 * @return
	 */
	public Map<String, Object> getsub(int num) {
		return this.sqlSessionTemplate.selectOne("bbs.getsub", num);
	}
	
	
	public List<Map<String, Object>> CommentsList(int num){
		return this.sqlSessionTemplate.selectList("bbs.Commentslist", num);
	}
	
	public int insertCom(Map<String, Object> map){
		return this.sqlSessionTemplate.insert("bbs.insertCom", map);
	}
	
	public int c_delete(int num) {
		return this.sqlSessionTemplate.delete("bbs.c_delete", num);
	}
}
