package cn.mldn.eusplatform.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import cn.mldn.eusplatform.dao.IReportDAO;
import cn.mldn.eusplatform.vo.Emp;
import cn.mldn.eusplatform.vo.Report;
import cn.mldn.util.dao.abs.AbstractDAO;

public class ReportDAOImpl extends AbstractDAO implements IReportDAO {

	@Override
	public boolean doCreate(Report vo) throws SQLException {
		String sql="insert into report(sid,eid,subdate,note)values(?,?,?,?)";
		super.pstmt=super.conn.prepareStatement(sql);
		super.pstmt.setLong(1, vo.getSid());
		super.pstmt.setString(2, vo.getEid());
		super.pstmt.setDate(3, new java.sql.Date(vo.getSubdate().getTime()));
		super.pstmt.setString(4, vo.getNote());
		return super.pstmt.executeUpdate()>0;
	}

	@Override
	public boolean doEdit(Report vo) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doRemove(Long id) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doRemove(Set<Long> ids) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Report findById(Long id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Report> findAll() throws SQLException {
		String sql = "SELECT srid,sid,eid,subdate,note FROM report WHERE locked=0" ;
		super.pstmt = super.conn.prepareStatement(sql) ;
		ResultSet rs = super.pstmt.executeQuery() ;
		List<Report> list=new ArrayList<Report>();
		while (rs.next()) {
			Report vo = new Report() ;
			vo.setSrid(rs.getLong(1));
			vo.setSid(rs.getLong(2));
			vo.setEid(rs.getString(3));
			vo.setSubdate(rs.getDate(4));
			vo.setNote(rs.getString(5));
			list.add(vo);
		}
		return list;
	}

	@Override
	public List<Report> findAll(Long currentPage, Integer lineSize) throws Exception {
		String sql = "SELECT srid,sid,eid,subdate,note FROM report WHERE locked=0 limit ?,?" ;
		super.pstmt = super.conn.prepareStatement(sql) ;
		super.pstmt.setLong(1, (currentPage-1)*lineSize);
		super.pstmt.setInt(2, lineSize);
		ResultSet rs = super.pstmt.executeQuery() ;
		List<Report> list=new ArrayList<Report>();
		while (rs.next()) {
			Report vo = new Report() ;
			vo.setSrid(rs.getLong(1));
			vo.setSid(rs.getLong(2));
			vo.setEid(rs.getString(3));
			vo.setSubdate(rs.getDate(4));
			vo.setNote(rs.getString(5));
			list.add(vo);
		}
		return list;
	}

	@Override
	public List<Report> findSplit(String column, String keyWord, Long currentPage, Integer lineSize) throws Exception {
		String sql = "SELECT srid,sid,eid,subdate,note FROM report WHERE "+column+" like ? and locked=0 limit ?,?" ;
		super.pstmt = super.conn.prepareStatement(sql) ;
		super.pstmt.setString(1, "%"+keyWord+"%");
		super.pstmt.setLong(2, (currentPage-1)*lineSize);
		super.pstmt.setInt(3, lineSize);
		ResultSet rs = super.pstmt.executeQuery() ;
		List<Report> list=new ArrayList<Report>();
		while (rs.next()) {
			Report vo = new Report() ;
			vo.setSrid(rs.getLong(1));
			vo.setSid(rs.getLong(2));
			vo.setEid(rs.getString(3));
			vo.setSubdate(rs.getDate(4));
			vo.setNote(rs.getString(5));
			list.add(vo);
		}
		return list;
	}

	@Override
	public Long getAllCount() throws SQLException {
		String sql="select count(*) from report";
		super.pstmt=super.conn.prepareStatement(sql);
		ResultSet rs=super.pstmt.executeQuery();
		if(rs.next()) {
			return rs.getLong(1);
		}
		return 0L;
	}

	@Override
	public Long getSplitCount(String column, String keyWord) throws SQLException {
		String sql="select count(*) from report where "+column+" like ?";
		super.pstmt=super.conn.prepareStatement(sql);
		super.pstmt.setString(1, "%"+keyWord+"%");
		ResultSet rs=super.pstmt.executeQuery();
		if(rs.next()) {
			return rs.getLong(1);
		}
		return 0L;
	}
	
	
}
