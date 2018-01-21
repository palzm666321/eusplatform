package cn.mldn.eusplatform.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import cn.mldn.eusplatform.dao.IScheduleDAO;
import cn.mldn.eusplatform.vo.Schedule;
import cn.mldn.util.dao.abs.AbstractDAO;

public class ScheduleDAOImpl extends AbstractDAO implements IScheduleDAO {

	@Override
	public boolean editByAnote(Schedule vo) throws SQLException {
		String sql="update schedule set audit=?,anote=? where sid=?";
		super.pstmt=super.conn.prepareStatement(sql);
		super.pstmt.setInt(1, vo.getAudit());
		super.pstmt.setString(2, vo.getAnote());
		super.pstmt.setLong(3, vo.getSid());
		return super.pstmt.executeUpdate()>0;
	}
	
	@Override
	public boolean doCreate(Schedule vo) throws SQLException {
		String sql="insert into schedule(seid,aeid,iid,title,sdate,subdate,audit,note,auddate,anote,ecount)values(?,?,?,?,?,?,?,?,?,?,?)";
		super.pstmt=super.conn.prepareStatement(sql);
		super.pstmt.setString(1, vo.getSeid());
		super.pstmt.setString(2, vo.getAeid());
		super.pstmt.setLong(3, vo.getIid());
		super.pstmt.setString(4, vo.getTitle());
		super.pstmt.setDate(5, new java.sql.Date(vo.getSdate().getTime()));
		super.pstmt.setDate(6, new java.sql.Date(vo.getSubdate().getTime()));
		super.pstmt.setInt(7, vo.getAudit());
		super.pstmt.setString(8, vo.getNote());
		super.pstmt.setDate(9, new java.sql.Date(vo.getAuddate().getTime()));
		super.pstmt.setString(10, vo.getAnote());
		super.pstmt.setInt(11, vo.getEcount());
		return super.pstmt.executeUpdate()>0;
	}

	@Override
	public boolean doEdit(Schedule vo) throws SQLException {
		String sql="update schedule set seid=?,aeid=?,iid=?,title=?,sdate=?,subdate=?,audit=?,note=?,auddate=?,anote=?,ecount=? where sid=?";
		super.pstmt=super.conn.prepareStatement(sql);
		super.pstmt.setString(1, vo.getSeid());
		super.pstmt.setString(2, vo.getAeid());
		super.pstmt.setLong(3, vo.getIid());
		super.pstmt.setString(4, vo.getTitle());
		super.pstmt.setDate(5, new java.sql.Date(vo.getSdate().getTime()));
		super.pstmt.setDate(6, new java.sql.Date(vo.getSubdate().getTime()));
		super.pstmt.setInt(7, vo.getAudit());
		super.pstmt.setString(8, vo.getNote());
		super.pstmt.setDate(9, new java.sql.Date(vo.getAuddate().getTime()));
		super.pstmt.setString(10, vo.getAnote());
		super.pstmt.setInt(11, vo.getEcount());
		super.pstmt.setLong(12, vo.getSid());
		return super.pstmt.executeUpdate()>0;
	}

	@Override
	public boolean doRemove(Long id) throws SQLException {
		String sql="delete from schedule where sid=?";
		super.pstmt=super.conn.prepareStatement(sql);
		super.pstmt.setLong(1, id);
		return super.pstmt.executeUpdate()>0;
	}

	@Override
	public boolean doRemove(Set<Long> ids) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Schedule findById(Long id) throws SQLException {
		String sql="select sid,seid,aeid,iid,title,sdate,subdate,audit,note,auddate,anote,ecount from schedule where sid=?";
		super.pstmt=super.conn.prepareStatement(sql);
		super.pstmt.setLong(1, id);
		ResultSet rs=super.pstmt.executeQuery();
		if(rs.next()) {
			Schedule vo=new Schedule();
			vo.setSid(rs.getLong(1));
			vo.setSeid(rs.getString(2));
			vo.setAeid(rs.getString(3));
			vo.setIid(rs.getLong(4));
			vo.setTitle(rs.getString(5));
			vo.setSdate(rs.getDate(6));
			vo.setSubdate(rs.getDate(7));
			vo.setAudit(rs.getInt(8));
			vo.setNote(rs.getString(9));
			vo.setAuddate(rs.getDate(10));
			vo.setAnote(rs.getString(11));
			vo.setEcount(rs.getInt(12));
			return vo;
		}
		return null;
	}

	@Override
	public List<Schedule> findAll() throws SQLException {
		String sql="select sid,seid,aeid,iid,title,sdate,subdate,audit,note,auddate,anote,ecount from schedule";
		super.pstmt=super.conn.prepareStatement(sql);
		List<Schedule> list=new ArrayList<Schedule>();
		ResultSet rs=super.pstmt.executeQuery();
		while(rs.next()) {
			Schedule vo=new Schedule();
			vo.setSid(rs.getLong(1));
			vo.setSeid(rs.getString(2));
			vo.setAeid(rs.getString(3));
			vo.setIid(rs.getLong(4));
			vo.setTitle(rs.getString(5));
			vo.setSdate(rs.getDate(6));
			vo.setSubdate(rs.getDate(7));
			vo.setAudit(rs.getInt(8));
			vo.setNote(rs.getString(9));
			vo.setAuddate(rs.getDate(10));
			vo.setAnote(rs.getString(11));
			vo.setEcount(rs.getInt(12));
			list.add(vo);
		}
		return list;
	}

	@Override
	public List<Schedule> findAll(Long currentPage, Integer lineSize) throws Exception {
		String sql="select sid,seid,aeid,iid,title,sdate,subdate,audit,note,auddate,anote,ecount from schedule limit ?,?";
		super.pstmt=super.conn.prepareStatement(sql);
		super.pstmt.setLong(1, (currentPage-1)*lineSize);
		super.pstmt.setLong(2, lineSize);
		List<Schedule> list=new ArrayList<Schedule>();
		ResultSet rs=super.pstmt.executeQuery();
		while(rs.next()) {
			Schedule vo=new Schedule();
			vo.setSid(rs.getLong(1));
			vo.setSeid(rs.getString(2));
			vo.setAeid(rs.getString(3));
			vo.setIid(rs.getLong(4));
			vo.setTitle(rs.getString(5));
			vo.setSdate(rs.getDate(6));
			vo.setSubdate(rs.getDate(7));
			vo.setAudit(rs.getInt(8));
			vo.setNote(rs.getString(9));
			vo.setAuddate(rs.getDate(10));
			vo.setAnote(rs.getString(11));
			vo.setEcount(rs.getInt(12));
			list.add(vo);
		}
		return list;
	}

	@Override
	public List<Schedule> findSplit(String column, String keyWord, Long currentPage, Integer lineSize)
			throws Exception {
		String sql="select sid,seid,aeid,iid,title,sdate,subdate,audit,note,auddate,anote,ecount from schedule where "+column+" like ? limit ?,?";
		super.pstmt=super.conn.prepareStatement(sql);
		super.pstmt.setString(1, "%"+keyWord+"%");
		super.pstmt.setLong(2, (currentPage-1)*lineSize);
		super.pstmt.setLong(3, lineSize);
		List<Schedule> list=new ArrayList<Schedule>();
		ResultSet rs=super.pstmt.executeQuery();
		while(rs.next()) {
			Schedule vo=new Schedule();
			vo.setSid(rs.getLong(1));
			vo.setSeid(rs.getString(2));
			vo.setAeid(rs.getString(3));
			vo.setIid(rs.getLong(4));
			vo.setTitle(rs.getString(5));
			vo.setSdate(rs.getDate(6));
			vo.setSubdate(rs.getDate(7));
			vo.setAudit(rs.getInt(8));
			vo.setNote(rs.getString(9));
			vo.setAuddate(rs.getDate(10));
			vo.setAnote(rs.getString(11));
			vo.setEcount(rs.getInt(12));
			list.add(vo);
		}
		return list;
	}

	@Override
	public Long getAllCount() throws SQLException {
		String sql="select count(*) from schedule";
		super.pstmt=super.conn.prepareStatement(sql);
		ResultSet rs=super.pstmt.executeQuery();
		if(rs.next()) {
			return rs.getLong(1);
		}
		return 0L;
	}

	@Override
	public Long getSplitCount(String column, String keyWord) throws SQLException {
		String sql="select count(*) from schedule where "+column+" like ?";
		super.pstmt=super.conn.prepareStatement(sql);
		super.pstmt.setString(1, "%"+keyWord+"%");
		ResultSet rs=super.pstmt.executeQuery();
		if(rs.next()) {
			return rs.getLong(1);
		}
		return 0L;
	}

}
