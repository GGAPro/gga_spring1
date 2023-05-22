package com.gga.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gga.dao.OrderDao;
import com.gga.vo.OrderVo;

@Controller
public class OrderController {
	/**
	 *	orderconProc.do 
	 */
	@RequestMapping(value="/orderconProc.do", method=RequestMethod.POST)
	@ResponseBody
	public void orderconProc(String seat, String price, String oid) {
		OrderDao orderDao = new OrderDao();
		/*
		 * String seat = request.getParameter("seat"); String price =
		 * request.getParameter("price"); String oid = request.getParameter("oid");
		 */
		orderDao.insert(seat, price, oid);
	}
	/**
	 *	ordercon.do 
	 */
	@RequestMapping(value="/ordercon.do", method=RequestMethod.GET)
	public String ordercon() {
		
		return "/order/ordercon";
	}
	/**
	 *	seat.do 
	 */
	@RequestMapping(value="/seat.do", method=RequestMethod.GET)
	public String seat() {
		return "/order/seat";
	}
	/**
	 *	orderProc.do 
	 */
	@RequestMapping(value="/orderProc.do", method=RequestMethod.POST)
	public ModelAndView orderProc(OrderVo orderVo) {
		ModelAndView model = new ModelAndView();
		OrderDao orderDao = new OrderDao();
		int result = orderDao.insert(orderVo);
		String oid = orderVo.getOid();
		if(result ==1){
			
			model.addObject("oid", oid);
			model.setViewName("/order/seat");
			/*out.write("location.href ='http://localhost:9000/gga_spring1/order/seat.jsp?oid="+oid+"'");*/
		}
		
		return model;
	}
	/**
	 *	order.do 
	 */
	@RequestMapping(value="/order.do", method=RequestMethod.GET)
	public String order() {
		return "/order/order";
	}
	
	/**
	 * oidProc.do - header에서 예매눌렀을 시 oid값 생성 
	 */
	@RequestMapping(value="/oidProc.do", method=RequestMethod.GET)
	@ResponseBody
	public String oidProc() {
		OrderDao orderDao = new OrderDao();
		String oid = orderDao.getOid();
		return oid;
	}
}
