package com.gga.dao;

import com.gga.vo.OrderVo;

public class OrderDao extends DBConn{
	public OrderVo select(String oid) {
		OrderVo orderVo = new OrderVo();
		String sql = "select oid, movieid, price, seat, otime, odate, mid, oname, ocarnum, oemail, ophone, orderdate from morder where oid =?";
		getPreparedStatement(sql);
		try {
			pstmt.setString(1, oid);
			rs= pstmt.executeQuery();
			while(rs.next()) {
				orderVo.setOid(oid);
				orderVo.setMovieid(rs.getString(2));
				orderVo.setPrice(rs.getString(3));
				orderVo.setSeat(rs.getString(4));
				orderVo.setOtime(rs.getString(5));
				orderVo.setOdate(rs.getString(6));
				orderVo.setMid(rs.getString(7));
				orderVo.setOname(rs.getString(8));
				orderVo.setOcarnum(rs.getString(9));
				orderVo.setOemail(rs.getString(10));
				orderVo.setOphone(rs.getString(11));
				orderVo.setOrderdate(rs.getString(12));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return orderVo;
	}
	
	
	
	public int insert(String seat, String price, String oid) {
		int result = 0;
		String sql = "update morder set price = ?, seat= ? " + 
				" where oid = ?";
		getPreparedStatement(sql);
		try {
			pstmt.setString(1, price);
			pstmt.setString(2, seat);
			pstmt.setString(3, oid);
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return result;
	}
	
	public String getOid() {
		String result="";
		String sql="select 'o_'||ltrim(to_char(sysdate,'yymmdd'))||ltrim(to_char(sequ_morder_oid.nextval,'0000')) oid from dual";
		getPreparedStatement(sql);
		try {
			rs= pstmt.executeQuery();
			while(rs.next()) {
				
				result = rs.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public int insert(OrderVo orderVo) {
		int result = 0;
		
		String sql=" insert into morder"
				+ "(movieid, otime, odate, oname, ocarnum, oemail, ophone, orderdate, oid) "
				+ " values(?, ?, ?, ?, ?, ?, ?, sysdate, ?)";
		getPreparedStatement(sql);
		
		try {
			pstmt.setString(1, orderVo.getMovieid());
			pstmt.setString(2, orderVo.getOtime());
			pstmt.setString(3, orderVo.getOdate());
			pstmt.setString(4, orderVo.getOname());
			pstmt.setString(5, orderVo.getOcarnum());
			pstmt.setString(6, orderVo.getOemail());
			pstmt.setString(7, orderVo.getOphone());
			pstmt.setString(8, orderVo.getOid());
			
			/* pstmt.setString(5, orderVo.getMid()); */
			result = pstmt.executeUpdate();
	
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

}
