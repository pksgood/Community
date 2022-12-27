package com.pack.spring.bbs;

import java.util.List;
import java.util.Map;


public interface BbsService {

	/**
	 * 게시글 작성Service
	 * @param map
	 * @return
	 */
	int b_create(Map<String, Object> map);
	
	
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
	 * 전체목록 보기Service
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> b_list(Map<String, Object> map);
	
	
	/**
	 * 게시글 상세보기Service
	 * @param map
	 * @return
	 */
	Map<String, Object> b_detail(int num);
	
	
	/**
	 * 게시글 삭제
	 * @param num
	 * @return
	 */
	boolean b_delete(int num);


	/**
	 * 게시글 수정
	 * @param map
	 * @return
	 */
	boolean b_update(Map<String, Object> map);

	
	/**
	 * 조회수 증가
	 * @param num
	 * @return
	 */
	int b_upCnt(int num);
	
	
	/**
	 * 전체 레드코 수 조회
	 * @return
	 */
	int c_list();
	
	
	/**
	 * 댓글 작성
	 * @param map
	 * @return
	 */
	int com_insert(Map<String, Object> map);
	
	int com_upPos(Map<String, Object> map);
	
	/**
	 * 게시글 번호로 제목, 내용, 작성자 이름 찾기
	 * @param num
	 * @return
	 */
	Map<String, Object> getsub(int num);
	
	
	
	List<Map<String, Object>> CommentsList(int num);
	
	int insertCom(Map<String, Object> map);
	
	int c_delete(int num);

}
