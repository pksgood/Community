package com.pack.spring.bbs;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BbsServiceImp implements BbsService{
	
	@Autowired
	BbsDAO bbsDao;
	
	
	/**
	 * 게시글 작성
	 */
	@Override
	public int b_create(Map<String, Object> map) {
		return this.bbsDao.b_insert(map);
	}
	
	
	/**
	 * id로 이름찾기
	 */
	@Override
	public String getName(String uId) {
		return this.bbsDao.getName(uId);
	}
	
	
	/**
	 * ref최대값 찾기
	 */
	@Override
	public int getMaxNum(Map<String, Object> map) {
		return this.bbsDao.getMaxNum(map);
	}
	
	/**
	 * 게시글 전체 조회
	 */
	@Override
	public List<Map<String, Object>> b_list(Map<String, Object> map) {
		return this.bbsDao.b_selectList(map);
	}

	
	/**
	 * 게시글 상세보기
	 */
	@Override
	public Map<String, Object> b_detail(int num) {
		return this.bbsDao.b_selectDetail(num);
	}

	
	/**
	 * 게시글 삭제
	 */
	@Override
	public boolean b_delete(int num) {
		boolean res = false;
		int cnt =  this.bbsDao.b_delete(num);
		if (cnt == 1) res = true;
		return res;
		
	}

	
	/**
	 * 게시글 수정
	 */
	@Override
	public boolean b_update(Map<String, Object> map) {
		boolean res = false;
		int cnt =  this.bbsDao.b_update(map);
			if (cnt == 1) res = true;
		return res;
	}

	
	/**
	 * 조회수 증가
	 */
	@Override
	public int b_upCnt(int num) {
		return this.bbsDao.b_upCnt(num);
	}

	
	/**
	 * 전체 레코드 수
	 */
	@Override
	public int c_list() {
		return this.bbsDao.c_list();
	}

	
	/**
	 * 댓글작성
	 */
	@Override
	public int com_insert(Map<String, Object> map) {
		return this.bbsDao.com_insert(map);
	}


	/**
	 * 게시글 번호로 제목, 내용, 작성자이름 찾기
	 */
	@Override
	public Map<String, Object> getsub(int num) {
		return this.bbsDao.getsub(num);
	}


	@Override
	public int com_upPos(Map<String, Object> map) {
		return this.bbsDao.com_upPos(map);
	}


	@Override
	public List<Map<String, Object>> CommentsList(int num) {
		return this.bbsDao.CommentsList(num);
	}


	@Override
	public int insertCom(Map<String, Object> map) {
		return this.bbsDao.insertCom(map);
	}

	@Override
	public int c_delete(int num) {
		return this.bbsDao.c_delete(num);
	}
	
}
