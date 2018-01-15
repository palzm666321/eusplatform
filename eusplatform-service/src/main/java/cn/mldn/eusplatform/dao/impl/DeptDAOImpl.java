package cn.mldn.eusplatform.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import cn.mldn.eusplatform.dao.IDeptDAO;
import cn.mldn.eusplatform.vo.Dept;
import cn.mldn.util.dao.abs.AbstractDAO;

public class DeptDAOImpl extends AbstractDAO implements IDeptDAO {

	@Override
	public Map<Long, String> findByDid() throws SQLException {
		String sql="select did,dname from dept";
		super.pstmt=super.conn.prepareStatement(sql);
		ResultSet rs=super.pstmt.executeQuery();
		Map<Long,String> map=new HashMap<Long,String>();
		while(rs.next()) {
			map.put(rs.getLong(1),rs.getString(2));
		}
		return map;
	}
	
	@Override
	public boolean doEdit(String eid,Long did) throws SQLException {
		return false;
	}
	
	@Override
	public List<Dept> findAllByDept(String eid) throws SQLException {
		String sql="select did,dname,eid,maxnum,currnum from dept where eid=?";
		super.pstmt=super.conn.prepareStatement(sql);
		super.pstmt.setString(1, eid);
		List<Dept> list=new ArrayList<Dept>();
		ResultSet rs=super.pstmt.executeQuery();
		while(rs.next()) {
			Dept vo=new Dept();
			vo.setDid(rs.getLong(1));
			vo.setDname(rs.getString(2));
			vo.setEid(rs.getString(3));
			vo.setMaxnum(rs.getInt(4));
			vo.setCurrnum(rs.getInt(5));
			list.add(vo);
		}
		return list;
	}
	
	@Override
	public boolean doCreate(Dept vo) throws SQLException {
		String sql="insert into dept(dname,eid,maxnum,currnum)values(?,?,?,?)";
		super.pstmt=super.conn.prepareStatement(sql);
		super.pstmt.setString(1, vo.getDname());
		super.pstmt.setString(2, vo.getEid());
		super.pstmt.setInt(3, vo.getMaxnum());
		super.pstmt.setInt(4, vo.getCurrnum());
		return super.pstmt.executeUpdate()>0;
	}

	@Override
	public boolean doEdit(Dept vo) throws SQLException {
		String sql="update dept set dname=?,maxnum=? where did=?";
		super.pstmt=super.conn.prepareStatement(sql);
		super.pstmt.setString(1, vo.getDname());
		super.pstmt.setLong(2, vo.getMaxnum());
		super.pstmt.setLong(3, vo.getDid());
		return super.pstmt.executeUpdate()>0;
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
	public Dept findById(Long did) throws SQLException {
		String sql="select did,dname,eid,maxnum,currnum from dept where did=?";
		super.pstmt=super.conn.prepareStatement(sql);
		super.pstmt.setLong(1, did);
		ResultSet rs=super.pstmt.executeQuery();
		while(rs.next()) {
			Dept vo=new Dept();
			vo.setDid(rs.getLong(1));
			vo.setDname(rs.getString(2));
			vo.setEid(rs.getString(3));
			vo.setMaxnum(rs.getInt(4));
			vo.setCurrnum(rs.getInt(5));
			return vo;
		}
		return null;
	}

	@Override
	public List<Dept> findAll() throws SQLException {
		String sql="select did,dname,eid,maxnum,currnum from dept";
		super.pstmt=super.conn.prepareStatement(sql);
		List<Dept> list=new ArrayList<Dept>();
		ResultSet rs=super.pstmt.executeQuery();
		while(rs.next()) {
			Dept vo=new Dept();
			vo.setDid(rs.getLong(1));
			vo.setDname(rs.getString(2));
			vo.setEid(rs.getString(3));
			vo.setMaxnum(rs.getInt(4));
			vo.setCurrnum(rs.getInt(5));
			list.add(vo);
		}
		return list;
	}

	@Override
	public List<Dept> findAll(Long currentPage, Integer lineSize) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Dept> findSplit(String column, String keyWord, Long currentPage, Integer lineSize) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long getAllCount() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long getSplitCount(String column, String keyWord) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
