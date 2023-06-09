package com.gga.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gga.dao.MovieDao;
import com.gga.vo.MovieVo;

@Controller
public class MovieController {
	/**
	 * admin => movie_delete_proc.do
	 */
	@RequestMapping(value="/movie_delete_proc.do", method=RequestMethod.POST)
	public String movie_delete_proc(String movieid) {
		String viewName ="";
		MovieDao movieDao = new MovieDao();
		int result = movieDao.delete(movieid);
		if(result == 1) {
			viewName="redirect:/movie_list.do";
		}else {
			//삭제 실패 페이지
		}
		
		return viewName;
	}
	/**
	 * admin => movie_update_proc.do
	 */
	@RequestMapping(value="/movie_update_proc.do", method=RequestMethod.POST)
	public String movie_update_proc(MovieVo movieVo) {
		String viewName ="";
		MovieDao movieDao = new MovieDao();
		int result = movieDao.update(movieVo);
		if(result == 1) {
			viewName="redirect:/movie_list.do";
		}else {
			//업데이트 실패 페이지
		}
		
		return viewName;
	}
	/**
	 * admin -> movie_update.do
	 */
	@RequestMapping(value="/movie_update.do", method=RequestMethod.GET)
	public ModelAndView moive_update(String movieid) {
		ModelAndView model = new ModelAndView();
		MovieDao movieDao = new MovieDao();
		MovieVo movieVo = movieDao.mselect(movieid);
		
		model.addObject("movieVo", movieVo);
		model.setViewName("/admin/moviemanager/movie_update");
		return model;
	}
	
	/**
	 * admin -> movie_content.do
	 */
	@RequestMapping(value="/movie_content.do", method=RequestMethod.GET)
	public ModelAndView movie_content(String movieid) {
		ModelAndView model = new ModelAndView();
		MovieDao movieDao = new MovieDao();
		MovieVo movieVo = movieDao.mselect(movieid);
		
		model.addObject("movieVo", movieVo);
		model.setViewName("/admin/moviemanager/movie_content");
		return model;
	}
	
	/**
	 * admin -> movie_register_proc.do
	 */
	@RequestMapping(value="/movie_register_proc.do", method=RequestMethod.POST)
	public String movie_register_proc(MovieVo movieVo) {
		String viewName = "";
		MovieDao movieDao = new MovieDao();
		int result = movieDao.insert(movieVo);
		
		if(result == 1) {
			viewName = "redirect:/movie_list.do";
		} else {
			//등록 실패 페이지
		}
		return viewName;
	}
	/**
	 * admin -> movie_register.do
	 */
	@RequestMapping(value="/movie_register.do", method=RequestMethod.GET)
	public String movie_register() {
		return "/admin/moviemanager/movie_register";
	}
	/**
	 * admin -> moive_list.do
	 */
	@RequestMapping(value="/movie_list.do", method=RequestMethod.GET)
	public ModelAndView movie_list() {
		ModelAndView model = new ModelAndView();
		
		MovieDao movieDao = new MovieDao();
		ArrayList<MovieVo> movieList = movieDao.select();
		
		model.addObject("movieList", movieList);
		model.setViewName("/admin/moviemanager/movie_list");
		
		return model;
	}
	/**
	 * movie_menu.do 
	 */
	@RequestMapping(value="/movie_menu.do", method=RequestMethod.GET)
	public String movie_menu() {
		return "/movie/movie_menu";
	}
	
	/**
	 * commingsoon.do 
	 */
	@RequestMapping(value="/commingsoon.do", method=RequestMethod.GET)
	public String commingsoon() {
		return "/movie/commingsoon";
	}
	
	/**
	 * movieinfo.do 
	 */
	@RequestMapping(value="/movieinfo.do", method=RequestMethod.GET)
	public ModelAndView movieinfo(String movieid) {
		ModelAndView model = new ModelAndView();
		
		MovieDao movieDao = new MovieDao();
		MovieVo movieVo = movieDao.mselect(movieid);
		
		model.addObject("movieVo", movieVo);
		model.setViewName("/movie/movieinfo");
		return model;
	}
}
