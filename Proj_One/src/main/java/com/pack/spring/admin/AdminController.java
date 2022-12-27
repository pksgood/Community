package com.pack.spring.admin;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.pack.spring.bbs.BbsService;
import com.pack.spring.bbs.UtilMgr;

@Controller
public class AdminController {
	private static final String SAVEFOLER = "D:/silsp/Community/WebContent/fileUpload";
	private static String encType = "UTF-8";
	private static int maxSize = 5 * 1024 * 1024;
	@Autowired
	AdminService adminService;

	@RequestMapping(value = "/admin/memberList", method = RequestMethod.GET)
	public ModelAndView list(@RequestParam Map<String, Object> map,
			@RequestParam(value = "nowPage", required = false, defaultValue = "1") int nowPage,
			@RequestParam(value = "keyField", required = false, defaultValue = "") String keyField,
			@RequestParam(value = "keyWord", required = false, defaultValue = "") String keyWord) {

		List<Map<String, Object>> list = this.adminService.m_selectList(map);

		int mc_list = this.adminService.mc_list();
		// 페이징처리
		int currentPage = nowPage; // 현재 페이지
		/*
		 * if(map.get("nowPage").toString()!=null){
		 * currentPage=Integer.parseInt(map.get("nowPage").toString()); }
		 */
		// 현재 페이지와 무관한 변수들
		int totalRecord = mc_list; // 총 레코드 수
		if (list != null && !list.isEmpty()) {
			totalRecord = list.size();
		}
		int pageSize = 5; // 현재 페이지에 보여줄 레코드 개수
		int totalPage = (int) Math.ceil((float) totalRecord / pageSize); // 총 페이지수
		int blockSize = 10; // 한 블럭에 보여줄 페이지 수

		// 현재 페이지를 이용해 계산하는 변수들
		int firstPage = currentPage - ((currentPage - 1) % blockSize);
		// -> 블럭의 시작페이지

		int lastPage = firstPage + (blockSize - 1);
		// 블럭의 마지막 페이지

		int curPos = (currentPage - 1) * pageSize;

		if (curPos != 0) {
			curPos++;
		}

		// 페이지당 ArrayList에서의 시작 index

		int num = totalRecord - curPos; // 페이지당 글 라스트 시작 번호

		int nowBlock = (int) Math.ceil((double) currentPage / blockSize);
		int totalBlock = (int) Math.ceil((double) totalPage / blockSize);

		System.out.println("totalRecord: " + totalRecord);
		System.out.println("pageSize 현재 페이지에 보여줄 레코드 개수: " + pageSize);
		System.out.println("totalPage 총 페이지 수: " + totalPage);
		System.out.println("blockSize 한 블럭에 보여줄 페이지 수: " + blockSize);
		System.out.println("firstPage 블럭의 시작 페이지: " + firstPage);
		System.out.println("lastPage 블럭의 마지막 페이지: " + lastPage);
		System.out.println("curPos 페이지당 시작 board num: " + curPos);
		System.out.println("currentPage 현재페이지: " + currentPage);
		System.out.println("nowBlock 현재 블럭: " + nowBlock);
		System.out.println("totalBlock: " + totalBlock);
		System.out.println("lastPageNum 페이지당 글 라스트 시작 번호: " + num);
		System.out.println();
		System.out.println("=============================================");
		System.out.println("keyField: " + keyField);
		System.out.println("keyWord: " + keyWord);

		ModelAndView mav = new ModelAndView();
		mav.addObject("nowBlock", nowBlock);
		mav.addObject("totalBlock", totalBlock);
		mav.addObject("keyField", keyField);
		mav.addObject("keyWord", keyWord);
		mav.addObject("lastPageNum", num);
		mav.addObject("totalPage", totalPage);
		mav.addObject("firstPage", firstPage);
		mav.addObject("lastPage", lastPage);
		mav.addObject("curPos", curPos);
		mav.addObject("nowPage", currentPage);
		mav.addObject("pageSize", pageSize);
		mav.addObject("blockSize", blockSize);
		mav.addObject("totalRecord", totalRecord);
		mav.addObject("list", list);
		mav.setViewName("/admin/memberList");
		return mav;
	}

	
	
	@RequestMapping(value = "/admin/memberDetail", method = RequestMethod.GET)
	public ModelAndView m_detail(@RequestParam int num) {
		this.adminService.a_upCnt(num);

		Map<String, Object> detailMap = this.adminService.m_detail(num);

		ModelAndView mav = new ModelAndView();
		mav.addObject("Obj", detailMap);
		mav.setViewName("/admin/memberDetail");

		return mav;
	}
	
	
	
	
	
	
	
	
	
	/**
	 * 공지게시판 전체 목록 list
	 * 
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/admin/notice", method = RequestMethod.GET)
	public ModelAndView noticeList(@RequestParam Map<String, Object> map,
			@RequestParam(value = "nowPage", required = false, defaultValue = "1") int nowPage,
			@RequestParam(value = "keyField", required = false, defaultValue = "") String keyField,
			@RequestParam(value = "keyWord", required = false, defaultValue = "") String keyWord) {

		List<Map<String, Object>> list = this.adminService.a_selectList(map);

		int c_list = this.adminService.countList();
		// 페이징처리
		int currentPage = nowPage; // 현재 페이지
		/*
		 * if(map.get("nowPage").toString()!=null){
		 * currentPage=Integer.parseInt(map.get("nowPage").toString()); }
		 */
		// 현재 페이지와 무관한 변수들
		int totalRecord = c_list; // 총 레코드 수
		if (list != null && !list.isEmpty()) {
			totalRecord = list.size();
		}
		int pageSize = 5; // 현재 페이지에 보여줄 레코드 개수
		int totalPage = (int) Math.ceil((float) totalRecord / pageSize); // 총 페이지수
		int blockSize = 10; // 한 블럭에 보여줄 페이지 수

		// 현재 페이지를 이용해 계산하는 변수들
		int firstPage = currentPage - ((currentPage - 1) % blockSize);
		// -> 블럭의 시작페이지

		int lastPage = firstPage + (blockSize - 1);
		// 블럭의 마지막 페이지

		int curPos = (currentPage - 1) * pageSize;

		if (curPos != 0) {
			curPos++;
		}

		// 페이지당 ArrayList에서의 시작 index

		int num = totalRecord - curPos; // 페이지당 글 라스트 시작 번호

		int nowBlock = (int) Math.ceil((double) currentPage / blockSize);
		int totalBlock = (int) Math.ceil((double) totalPage / blockSize);

		System.out.println("totalRecord: " + totalRecord);
		System.out.println("pageSize 현재 페이지에 보여줄 레코드 개수: " + pageSize);
		System.out.println("totalPage 총 페이지 수: " + totalPage);
		System.out.println("blockSize 한 블럭에 보여줄 페이지 수: " + blockSize);
		System.out.println("firstPage 블럭의 시작 페이지: " + firstPage);
		System.out.println("lastPage 블럭의 마지막 페이지: " + lastPage);
		System.out.println("curPos 페이지당 시작 board num: " + curPos);
		System.out.println("currentPage 현재페이지: " + currentPage);
		System.out.println("nowBlock 현재 블럭: " + nowBlock);
		System.out.println("totalBlock: " + totalBlock);
		System.out.println("lastPageNum 페이지당 글 라스트 시작 번호: " + num);
		System.out.println();
		System.out.println("=============================================");
		System.out.println("keyField: " + keyField);
		System.out.println("keyWord: " + keyWord);

		ModelAndView mav = new ModelAndView();
		mav.addObject("nowBlock", nowBlock);
		mav.addObject("totalBlock", totalBlock);
		mav.addObject("keyField", keyField);
		mav.addObject("keyWord", keyWord);
		mav.addObject("lastPageNum", num);
		mav.addObject("totalPage", totalPage);
		mav.addObject("firstPage", firstPage);
		mav.addObject("lastPage", lastPage);
		mav.addObject("curPos", curPos);
		mav.addObject("nowPage", currentPage);
		mav.addObject("pageSize", pageSize);
		mav.addObject("blockSize", blockSize);
		mav.addObject("totalRecord", totalRecord);
		mav.addObject("list", list);
		mav.setViewName("/admin/notice");
		return mav;
	}

	/**
	 * 공지글 작성화면 보기
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/admin/noticeWrite", method = RequestMethod.GET)
	public ModelAndView write(HttpServletRequest request) {
		HttpSession session = request.getSession();

		String uId = (String) session.getAttribute("uId_Session");

		String uName = this.adminService.getName(uId);

		ModelAndView mav = new ModelAndView();

		mav.addObject("uId", uId);
		mav.addObject("uName", uName);
		mav.setViewName("/admin/noticeWrite");
		return mav;
	}

			 /**
			 * 게시판 글 작성
			 */

	@RequestMapping(value = "/admin/noticeWrite", method = RequestMethod.POST)
	public ModelAndView createPost(HttpServletRequest request, @RequestParam Map<String, Object> map)
			throws IOException {

		ModelAndView mav = new ModelAndView();

		int maxNum = this.adminService.getMaxNum(map);
		int ref = maxNum + 1;

		MultipartRequest multi = null;
		int fileSize = 0;
		String fileName = null;

		File file = new File(SAVEFOLER);

		if (!file.exists()) {
			file.mkdirs();
		}

		multi = new MultipartRequest(request, SAVEFOLER, maxSize, encType, new DefaultFileRenamePolicy());

		if (multi.getFilesystemName("fileName") != null) {
			fileName = multi.getFilesystemName("fileName");
			fileSize = (int) multi.getFile("fileName").length();
		}

		String uId = multi.getParameter("uId");
		String uName = multi.getParameter("uName");
		String subject = multi.getParameter("subject");
		String content = multi.getParameter("content");

		if (multi.getParameter("contentType").equalsIgnoreCase("TEXT")) {
			content = UtilMgr.replace(content, "<", "&lt;");
		}

		map.put("uId", uId);
		map.put("uName", uName);
		map.put("subject", subject);
		map.put("content", content);
		map.put("fileName", fileName);
		map.put("fileSize", fileSize);

		int cnt = this.adminService.a_insert(map);

		if (cnt > 0) {
			mav.setViewName("redirect:/admin/notice");
		} else {
			mav.setViewName("redirect:/admin/noticeWrite");
		}

		return mav;
	}

	/**
	 * 게시글 상세보기
	 * 
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/admin/read", method = RequestMethod.GET)
	public ModelAndView detail(@RequestParam int num) {
		this.adminService.a_upCnt(num);

		Map<String, Object> detailMap = this.adminService.a_selectDetail(num);

		ModelAndView mav = new ModelAndView();
		mav.addObject("data", detailMap);
		mav.setViewName("/admin/read");

		return mav;
	}

	/**
	 * 수정화면 보여주기
	 * 
	 * @param request
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/admin/modify", method = RequestMethod.GET)
	public ModelAndView modify(HttpServletRequest request, @RequestParam Map<String, Object> map) {

		String num = map.get("num").toString();

		Map<String, Object> detailMap = this.adminService.a_selectDetail(Integer.parseInt(num));
		ModelAndView mav = new ModelAndView();

		HttpSession session = request.getSession();

		String uId = (String) session.getAttribute("uId_Session");
		String uName = this.adminService.getName(uId);

		mav.addObject("num", num);
		mav.addObject("data", detailMap);
		mav.addObject("map", map);
		mav.addObject("uId", uId);
		mav.addObject("uName", uName);
		mav.setViewName("/admin/modify");
		return mav;
	}

	/**
	 * 수정처리
	 * 
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/admin/modify", method = RequestMethod.POST)
	public ModelAndView modify2(@RequestParam Map<String, Object> map) {
		ModelAndView mav = new ModelAndView();

		int cnt = this.adminService.a_update(map);
		mav.addObject("cnt", cnt);

		if (cnt > 0) {
			mav.setViewName("redirect:/admin/modifyProc");
		} else {
			mav.setViewName("redirect:/admin/modify");
		}

		return mav;
	}

	/**
	 * 수정처리후 Proc -> notice까지 이동
	 * 
	 * @return
	 */
	@RequestMapping(value = "/admin/modifyProc", method = RequestMethod.GET)
	public ModelAndView modifyProc2() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/admin/modifyProc");
		return mav;
	}

	/**
	 * 게시글 삭제
	 * 
	 * @param num
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/admin/deleteProc", method = RequestMethod.GET)
	public ModelAndView memberDelete(@RequestParam int num, HttpServletRequest request) {
		HttpSession session = request.getSession();
		ModelAndView mav = new ModelAndView();
		int cnt = this.adminService.a_delete(num);
		mav.setViewName("redirect:/admin/notice");
		return mav;
	}

	/**
	 * Comments 작성창 띄우기
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/admin/comments", method = RequestMethod.GET)
	public ModelAndView commentsWrite(HttpServletRequest request) {
		HttpSession session = request.getSession();

		String uId = (String) session.getAttribute("uId_Session");

		String uName = this.adminService.getName(uId);

		ModelAndView mav = new ModelAndView();

		mav.addObject("uId", uId);
		mav.addObject("uName", uName);
		mav.setViewName("/admin/comments");
		return mav;
	}

	@RequestMapping(value = "/admin/commentsList", method = RequestMethod.GET)
	public ModelAndView commentsList(@RequestParam Map<String, Object> map, @RequestParam int num) {
		List<Map<String, Object>> list = this.adminService.CommentsList(num);
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", list);
		return mav;
	}

	@RequestMapping(value = "/admin/insertCom", method = RequestMethod.POST)
	public ModelAndView InsertCom(@RequestParam Map<String, Object> map, @RequestParam int num) {
		int cnt = this.adminService.insertCom(map);
		ModelAndView mav = new ModelAndView();
		mav.addObject("insert", cnt);
		mav.setViewName("redirect:/admin/read?num=" + num);
		return mav;

	}

}
