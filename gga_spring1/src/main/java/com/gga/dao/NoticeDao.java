package com.gga.dao;

import java.util.ArrayList;

import com.gga.vo.NoticeVo;

public class NoticeDao extends DBConn{
	/*
	 * delete
	 */
	public int delete(String nid) {
		int result = 0;
		String sql = "delete from ggadmin_notice where nid=?";
		getPreparedStatement(sql);
		
		try {
			pstmt.setString(1, nid);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * update
	 */
	public int update(NoticeVo noticeVo) {
		int result = 0;
		String sql = "update ggadmin_notice set ntitle=?, ncontent=? where nid=?";
		getPreparedStatement(sql);
		
		try {
			pstmt.setString(1, noticeVo.getNtitle());
			pstmt.setString(2, noticeVo.getNcontent());
			pstmt.setString(3, noticeVo.getNid());
			
			result = pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * select- 
	 */
	public NoticeVo select(String nid) {
		NoticeVo noticeVo = new NoticeVo();
		String sql = "SELECT NID,NTITLE,NCONTENT,NHITS,NDATE FROM GGADMIN_NOTICE WHERE NID=?";
		getPreparedStatement(sql);
		
		try {
			pstmt.setString(1, nid);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				noticeVo.setNid(rs.getString(1));
				noticeVo.setNtitle(rs.getString(2));
				noticeVo.setNcontent(rs.getString(3));
				noticeVo.setNhits(rs.getInt(4));
				noticeVo.setNdate(rs.getString(5));
			}
			
			} catch(Exception e) {
				e.printStackTrace();
			}
		return noticeVo;
		}
	
	
	
	
	/**
	 * select - 관리자 공지사항 게시글 전체 리스트
	 */
	public ArrayList<NoticeVo> select(){
		ArrayList<NoticeVo> list = new ArrayList<NoticeVo>();
		String sql = "select rownum rno, ntitle, nhits, ndate, nid "
				+ " from (select ntitle, nhits, ndate, nid from ggadmin_notice order by ndate desc)";
		getPreparedStatement(sql);
		
		try {
			rs = pstmt.executeQuery();
			while(rs.next()) {
				NoticeVo noticeVo = new NoticeVo();
				noticeVo.setRno(rs.getInt(1));
				noticeVo.setNtitle(rs.getString(2));
				noticeVo.setNhits(rs.getInt(3));
				noticeVo.setNdate(rs.getString(4));
				noticeVo.setNid(rs.getString(5));
				list.add(noticeVo);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
		
	}
	
	
	
	/**
	 * insert - 게시글 등록
	 */
	public int insert(NoticeVo noticeVo) {
		int result = 0;
		String sql=" insert into ggadmin_notice(nid, ntitle, ncontent, nhits, ndate) values('n_'||ltrim(to_char(sequ_gga_notice.nextval,'0000')), ?, ?, 0, sysdate)";
		getPreparedStatement(sql);
		
		try {
			pstmt.setString(1, noticeVo.getNtitle());
			pstmt.setString(2, noticeVo.getNcontent());
			
			result = pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return result; 
		
		
		
	}
}