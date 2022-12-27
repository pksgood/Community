package com.pack.spring.admin;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImp implements AdminService{

	@Autowired
	AdminDAO dao;
	

	@Override
	public List<Map<String, Object>> m_selectList(Map<String, Object> map) {
		return this.dao.m_selectList(map);
	}

	@Override
	public int mc_list() {
		return this.dao.mc_list();
	}
	
	
	
	/**
	 * 전체 게시글 목록 조회
	 */
	@Override
	public List<Map<String, Object>> a_selectList(Map<String, Object> map) {
		return this.dao.a_selectList(map);
	}
	
	
	/**
	 * id로 이름찾기
	 */
	@Override
	public String getName(String uId) {
		return this.dao.getName(uId);
	}
	
	
	/**
	 * 공지글 작성
	 */
	@Override
	public int a_insert(Map<String, Object> map) {
		return this.dao.a_insert(map);
	}

	
	/**
	 * 게시글 상세보기
	 */
	@Override
	public Map<String, Object> a_selectDetail(int num) {
		return this.dao.a_selectDetail(num);
	}

	
	/**
	 * 게시글 삭제
	 */
	@Override
	public int a_delete(int num) {
		return this.dao.a_delete(num);
	}

	
	/**
	 * 게시글 수정
	 */
	@Override
	public int a_update(Map<String, Object> map) {
		return this.dao.a_update(map);
	}

	
	/**
	 * 게시글 조회수 증가
	 */
	@Override
	public int a_upCnt(int num) {
		return this.dao.a_upCnt(num);
	}

	
	/**
	 * 전체 레코드 갯수 조회
	 */
	@Override
	public int countList() {
		return this.dao.countList();
	}

	@Override
	public List<Map<String, Object>> CommentsList(int num) {
		return this.dao.CommentsList(num);
	}

	@Override
	public int insertCom(Map<String, Object> map) {
		return this.dao.insertCom(map);
	}

	@Override
	public int getMaxNum(Map<String, Object> map) {
		return this.dao.getMaxNum(map);
	}

	@Override
	public Map<String, Object> m_detail(int num) {
		return this.dao.m_detail(num);
	}

}
