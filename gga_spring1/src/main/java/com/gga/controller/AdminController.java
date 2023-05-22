package com.gga.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gga.dao.BoardDao;
import com.gga.dao.MemberDao;
import com.gga.dao.NoticeDao;
import com.gga.vo.BoardVo;
import com.gga.vo.MemberVo;
import com.gga.vo.NoticeVo;

@Controller
public class AdminController {
	/*
	 * admin_board_content - 리뷰 상세보기 ( 관리자 )
	 */
	@RequestMapping(value="/admin_board_content.do",method=RequestMethod.GET)
	public ModelAndView admin_board_content(String bid) {
		ModelAndView model = new ModelAndView();
		BoardDao boardDao = new BoardDao();
		BoardVo boardVo = boardDao.select(bid);
		
		model.addObject("boardVo", boardVo);
		model.setViewName("/admin/board/admin_board_content");
		
		return model;
	}
	
	/*
	 * admin_board_list - 리뷰 관리 ( 관리자 )
	 */
	@RequestMapping(value="/admin_board_list.do", method=RequestMethod.GET)
	public String admin_board_list() {
		return "/admin/board/admin_board_list";
	}
	
	/*
	 * admin_member_list - 회원 관리 ( 관리자 )
	 */
	@RequestMapping(value="/admin_member_list.do", method=RequestMethod.GET)
	public ModelAndView admin_member_list() {
		ModelAndView model = new ModelAndView();
		MemberDao memberDao = new MemberDao();
		ArrayList<MemberVo> list = memberDao.select();
		
		model.addObject("list", list);
		model.setViewName("/admin/member/admin_member_list");
		
		return model;
	}
	/*
	 * admin_notice_delete_proc 삭제완료 처리
	 */
	@RequestMapping(value="/admin_notice_delete_proc.do", method=RequestMethod.POST)
	public ModelAndView admin_notice_delete_proc(String nid) {
		ModelAndView model = new ModelAndView();
		NoticeDao noticeDao = new NoticeDao();
		int result = noticeDao.delete(nid);
		if(result == 1) {
			/* model.setViewName("redirect:/admin/notice/admin_notice_list.do"); */
			model.setViewName("redirect:/admin_notice_list.do");
		}
		return model;
	}
	
	
	/*
	 * admin_notice_delete 공지사항 삭제 폼
	 */
	@RequestMapping(value="/admin_notice_delete.do", method=RequestMethod.GET)
	public ModelAndView admin_notice_delete(String nid) {
		ModelAndView model = new ModelAndView();
//		NoticeDao noticeDao = new NoticeDao();
//		NoticeVo noticeVo = noticeDao.dele(nid);
		model.addObject("nid", nid);
		model.setViewName("/admin/notice/admin_notice_delete");
		
		return model;
	}
	
	
	/*
	 * admin_notice_write_proc.do
	 */
	@RequestMapping(value="/admin_notice_write_proc.do", method=RequestMethod.POST)
	public String admin_notice_write_proc(NoticeVo noticeVo) {
		String viewName = "";
		NoticeDao noticeDao = new NoticeDao();
		int result = noticeDao.insert(noticeVo);
		if(result == 1) {
			viewName = "redirect:/admin_notice_list.do";
		}else {
			
		}
		return viewName;
	}
	
	
	/*
	 * admin_notice_write
	 */
	@RequestMapping(value="/admin_notice_write.do", method = RequestMethod.GET)
	public String admin_notice_write() {
		return "/admin/notice/admin_notice_write";
	}
	
	
	/*
	 * admin_notice_update_proc.do - 공지사항 수정 처리
	 */
	@RequestMapping(value="/admin_notice_update_proc.do", method=RequestMethod.POST)
	public ModelAndView admin_notice_update_proc(NoticeVo noticeVo) {
		ModelAndView model = new ModelAndView();
		NoticeDao noticeDao = new NoticeDao();
		int result = noticeDao.update(noticeVo);
		
		if(result == 1) {
			model.setViewName("redirect:/admin_notice_list.do");
		}else {
			
		}
		return model;
	}
	
	
	/*
	 * admin_notice_update.do
	 */
	@RequestMapping(value="/admin_notice_update.do", method=RequestMethod.GET)
	public ModelAndView admin_notice_update(String nid) {
		ModelAndView model = new ModelAndView();
		NoticeDao noticeDao = new NoticeDao();
		NoticeVo noticeVo = noticeDao.select(nid);
		model.addObject("noticeVo", noticeVo);
		model.setViewName("/admin/notice/admin_notice_update");
		
		return model;
	}
	
	
	
	/*
	 * admin_notice_content.do
	 */
	@RequestMapping(value="/admin_notice_content.do", method=RequestMethod.GET)
	public ModelAndView admin_notice_content(String nid) {
		ModelAndView model = new ModelAndView();
		NoticeDao noticeDao = new NoticeDao();
		NoticeVo noticeVo = noticeDao.select(nid);
		model.addObject("noticeVo", noticeVo);
		model.setViewName("/admin/notice/admin_notice_content");
		return model;
	}
	
	
	/*
	 * admin_index.do
	 */
	@RequestMapping(value="/admin_index.do", method=RequestMethod.GET)
	public String admin_index() {
		return "admin/admin_index";
	}
	
	
	
	/*
	 * admin_notice_list.do
	 */
	@RequestMapping(value="/admin_notice_list.do", method=RequestMethod.GET)
	public ModelAndView admin_notice_list() {
		ModelAndView model = new ModelAndView();
		NoticeDao noticeDao = new NoticeDao();
		
		ArrayList<NoticeVo> list = noticeDao.select();
		model.addObject("list", list);
		model.setViewName("admin/notice/admin_notice_list");
		
		return model;
	}
}
