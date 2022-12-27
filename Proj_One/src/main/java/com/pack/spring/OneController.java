package com.pack.spring;

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

import com.mysql.cj.Session;

@Controller
public class OneController {
	@Autowired
	OneService oneService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/index");
		return mav;
	}
	//회원약관 페이지 보여주기
	@RequestMapping(value = "/joinAgreement", method = RequestMethod.GET)
	public ModelAndView insert() {
		return new ModelAndView("member/joinAgreement");
	}
	//회원가입 페이지 보여주기
	@RequestMapping(value = "/member/member", method = RequestMethod.GET)
	public ModelAndView member() {
		return new ModelAndView("/member/member");
	}
	//회원 약관 포스트
	@RequestMapping(value="/member/joinAgreement", method = RequestMethod.POST)
	public ModelAndView signup(@RequestParam String vCode) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("vCode", vCode);
		mav.setViewName("redirect:/member/member");
		return mav;
	}
	
	//회원가입 포스트
	@RequestMapping(value="/member/member", method = RequestMethod.POST)
	public ModelAndView member2(@RequestParam Map<String, Object> map,@RequestParam(value="uHobby", required = false) String[] hobby) {
		String[] hobbyName = {"인터넷", "여행", "게임", "영화", "운동"};
		 char[] hobbyCode = {'0', '0', '0', '0', '0'};
	      for (int i=0; i<hobby.length; i++) {
	         for(int j=0; j<hobbyName.length; j++) {
	            if (hobby[i].equals(hobbyName[j])) {
	               hobbyCode[j] = '1';
	            }
	         }
	      }
	    map.put("uHobby", new String(hobbyCode));
		boolean sign = this.oneService.create(map);
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("sign", sign);
		mav.setViewName("redirect:/member/memberProc");
		return mav;
	}
	//회원가입 확인페이지 보여주기
		@RequestMapping(value = "/member/memberProc", method = RequestMethod.GET)
		public ModelAndView memberProc() {
			return new ModelAndView("/member/memberProc");
		}
	//아이디 체크
	@RequestMapping(value="/member/idCheck", method = RequestMethod.GET)
	public ModelAndView idChk(@RequestParam String uId) {
		ModelAndView mav = new ModelAndView();
		boolean res = this.oneService.idChk(uId);
		mav.addObject("result", res);
		mav.addObject("uId", uId);
		mav.setViewName("member/idCheck");
		return mav;
	}
	
	@RequestMapping(value="member/zipCheck", method = RequestMethod.GET)
	public ModelAndView zipChk() {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("member/zipCheck");
		return mav;
	}
	@RequestMapping(value="member/zipCheck", method = RequestMethod.POST)
	public ModelAndView zipChe2(@RequestParam String area3) {
		List<Map<String, Object>> list = this.oneService.zipChk(area3);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", list);
		mav.addObject("area3", area3);
		mav.setViewName("member/zipCheck");
		return mav;
	}
	
//////////////////////////////////////////////////////////로긴/////////////////////////////////////////////////
	@RequestMapping(value="/member/login", method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("member/login");
		return mav;
	}
	@RequestMapping(value="/member/login", method = RequestMethod.POST)
	public ModelAndView login2(@RequestParam Map<String, Object> map, HttpServletRequest request ) {
		boolean login = this.oneService.login(map);
		HttpSession session = request.getSession();
		if(login) {
			session.setAttribute("uId_Session", (String)map.get("uId"));
		}
		ModelAndView mav = new ModelAndView();
		mav.addObject("login", login);
		mav.setViewName("redirect:/member/loginProc");
		return mav;
	}
	@RequestMapping(value="/member/loginProc", method = RequestMethod.GET)
	public ModelAndView loginProc() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("member/loginProc");
		return mav;
	}
	@RequestMapping(value="/member/logout", method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();
		ModelAndView mav = new ModelAndView();
		mav.setViewName("member/logout");
		return mav;
	}
	
	@RequestMapping(value="/member/myPage", method = RequestMethod.GET)
	public ModelAndView myPage() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("member/myPage");
		return mav;
	}
	
	@RequestMapping(value="/member/memberMod", method = RequestMethod.GET)
	public ModelAndView memberMod(@RequestParam String uId) {
		ModelAndView mav = new ModelAndView();
		Map<String, Object> map = this.oneService.memberMod(uId);
		mav.addObject("Obj", map);
		mav.setViewName("member/memberMod");
		return mav;
	}
	
	@RequestMapping(value="/member/memberMod", method = RequestMethod.POST)
	public ModelAndView memberMod2(@RequestParam Map<String, Object> map,@RequestParam(value="uHobby", required = false) String[] hobby, HttpServletRequest request ) {
	      String[] hobbyName = {"인터넷", "여행", "게임", "영화", "운동"};
	      char[] hobbyCode = {'0', '0', '0', '0', '0'};
	      for (int i=0; i<hobby.length; i++) {
	         for(int j=0; j<hobbyName.length; j++) {
	            if (hobby[i].equals(hobbyName[j])) {
	               hobbyCode[j] = '1';
	            }
	         }
	      }
	    map.put("uHobby", new String(hobbyCode));
		ModelAndView mav = new ModelAndView();
		boolean update = this.oneService.memberMod2(map);
		mav.addObject("update", update);
		mav.setViewName("redirect:/member/memberModProc");
		return mav;
	}
	
	@RequestMapping(value="/member/memberModProc", method = RequestMethod.GET)
	public ModelAndView memberModProc() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/member/memberModProc");
		return mav;
	}
	@RequestMapping(value="/member/memberQuit", method = RequestMethod.GET)
	public ModelAndView memberQuit() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/member/memberQuit");
		return mav;
	}
	@RequestMapping(value="/member/memberQuit", method = RequestMethod.POST)
	public ModelAndView memberQuit2() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("member/memberQuitProc");
		return mav;
	}
	
	@RequestMapping(value="/member/memberQuitProc", method = RequestMethod.POST)
	public ModelAndView memberDelete(@RequestParam(value="uId") String uId, HttpServletRequest request) {
		HttpSession session = request.getSession();
		ModelAndView mav = new ModelAndView();
		boolean del = this.oneService.memberDelete(uId);
		mav.setViewName("/index");
		session.invalidate();
		return mav;
	}
}
