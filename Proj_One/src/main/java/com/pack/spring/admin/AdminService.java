package com.pack.spring.admin;

import java.util.List;
import java.util.Map;



public interface AdminService {
	
	
	List<Map<String, Object>> m_selectList(Map<String, Object> map);
	
	int mc_list();
	
	Map<String, Object> m_detail(int num);
	
	int m_update(Map<String, Object> map);
	
	int c_delete(int num);
	
	
	
	/**
	 * 공지게시판 목록 전체 출력
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> a_selectList(Map<String, Object> map);
	
	
	/**
	 * 게시글 작성Service
	 * @param map
	 * @return
	 */
	int a_insert(Map<String, Object> map);
	
	
	
	/**
	 * id로 이름 찾기
	 * @param uId
	 * @return
	 */
	String getName(String uId);
	
	
	/**
	 * ref최대값 찾기
	 * @param map
	 * @return
	 */
	int getMaxNum(Map<String, Object> map);
	
	/**
	 * 게시글 상세보기
	 * @param num
	 * @return
	 */
	Map<String, Object> a_selectDetail(int num);
	
	
	/**
	 * 게시글 삭제
	 * @param num
	 * @return
	 */
	int a_delete(int num);
	
	
	/**
	 * 게시글 수정
	 * @param map
	 * @return
	 */
	int a_update(Map<String, Object> map);
	
	
	/**
	 * 조회수 증가
	 * @param num
	 * @return
	 */
	int a_upCnt(int num);
	
	
	/**
	 * 전체 레코드 수 조회
	 * @return
	 */
	int countList();
	
	/**
	 * 커멘트 리스트
	 * @param num
	 * @return
	 */
	List<Map<String, Object>> CommentsList(int num);
	
	/**
	 * 커멘트 작성하기
	 * @param map
	 * @return
	 */
	int insertCom(Map<String, Object> map);
}
