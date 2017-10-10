package cafe.jjdev.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cafe.jjdev.web.service.Member;
import cafe.jjdev.web.service.MemberDao;
import cafe.jjdev.web.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	private MemberDao memberDao;
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value="/memberList")
	public String memberList(Model model) {
		System.out.println("List!!!!!!!");
		List<Member> list = memberDao.selectMemberList();
		model.addAttribute("list", list);
		return "memberList";
	}
	
	@RequestMapping(value="/addMember", method = RequestMethod.POST)
	public String addMember(MemberRequest memberRequest) {
		System.out.println(memberRequest);
		memberService.addMember(memberRequest);
		return "redirect:/memberList"; // request.sendRedirect("/memberList") 
		//redirect: 
		
	}
	/*
	public String addMember(@RequestParam(value="memberId") String memberId,
							@RequestParam(value="memberPw") String memberPw,
							@RequestParam(value="memberName") String memberName) {
		return "";
	}
	*/
	
	@RequestMapping(value="/addMember", method = RequestMethod.GET)
	public String addMember() {
		return "addMember";
	}
	
	@RequestMapping("/getMember")
	public String getMember(Model model) {
		Member member = memberDao.selectMemberOne(2);
		model.addAttribute("member", member);
		return "getMember";
	}
	
	//로그인된 사용자만 접근하는 페이지
	@RequestMapping("/test")
	public String test(HttpSession session) {
		if(session.getAttribute("loginMember") == null) {
			return "redirect:/login";
		}else {
			return "test";
		}		
	}
	
	//로그인
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String login(HttpSession session) {
		if(session.getAttribute("loginMember") != null) {
			return "test";
		}else {
			return "login";
		}		
	}
	
	//로그인 처리
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String login(HttpSession session, Member member) {
		Member loginMember = memberDao.login(member);
		if(loginMember == null) {
			return "redirect:/login";
		}else {
			session.setAttribute("loginMember", loginMember);
			return "redirect:/test";
		}		
	}
	
	//로그아웃
	@RequestMapping(value="/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/login";
	}
}
