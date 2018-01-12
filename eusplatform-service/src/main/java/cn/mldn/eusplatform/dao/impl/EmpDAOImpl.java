package cn.mldn.eusplatform.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import cn.mldn.eusplatform.dao.IEmpDAO;
import cn.mldn.eusplatform.vo.Emp;
import cn.mldn.util.dao.abs.AbstractDAO;

public class EmpDAOImpl extends AbstractDAO implements IEmpDAO {

	@Override
		public Map<String, Long> findByEidAndDid(String eid) throws SQLException {
			String sql="select eid,did from emp where eid=? and locked=0";
			super.pstmt=super.conn.prepareStatement(sql);
			super.pstmt.setString(1, eid);
			ResultSet rs=super.pstmt.executeQuery();
			Map<String,Long> map=new HashMap<String,Long>();
			while(rs.next()) {
				map.put(rs.getString(1), rs.getLong(2));
			}
			return map;
		}
	
	@Override
	public boolean doCreate(Emp vo) throws SQLException {
		String sql="insert into emp(eid,lid,did,ename,salary,phone,password,photo,note,hiredate,ineid,locked)values(?,?,?,?,?,?,?,?,?,?,?,?)";
		super.pstmt=super.conn.prepareStatement(sql);
		super.pstmt.setString(1, vo.getEid());
		super.pstmt.setLong(2, vo.getLid());
		super.pstmt.setLong(3, vo.getDid());
		super.pstmt.setString(4, vo.getEname());
		super.pstmt.setDouble(5, vo.getSalary());
		super.pstmt.setString(6, vo.getPhone());
		super.pstmt.setString(7, vo.getPassword());
		super.pstmt.setString(8, vo.getPhoto());
		super.pstmt.setString(9, vo.getNote());
		super.pstmt.setDate(10, new java.sql.Date(vo.getHiredate().getTime()));
		super.pstmt.setString(11, vo.getIneid());
		super.pstmt.setInt(12, vo.getLocked());
		return super.pstmt.executeUpdate()>0;
	}

	@Override
	public boolean doEdit(Emp vo) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doRemove(String id) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doRemove(Set<String> ids) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Emp findById(String id) throws SQLException {
		String sql = "SELECT eid,lid,did,ename,salary,phone,password,photo,note,hiredate,ineid,locked "
				+ " FROM emp WHERE eid=? AND locked=0 " ;
		super.pstmt = super.conn.prepareStatement(sql) ;
		super.pstmt.setString(1, id);
		ResultSet rs = super.pstmt.executeQuery() ;
		if (rs.next()) {
			Emp emp = new Emp() ;
			emp.setEid(rs.getString(1));
			emp.setLid(rs.getLong(2));
			emp.setDid(rs.getLong(3));
			emp.setEname(rs.getString(4));
			emp.setSalary(rs.getDouble(5));
			emp.setPhone(rs.getString(6));
			emp.setPassword(rs.getString(7));
			emp.setPhoto(rs.getString(8));
			emp.setNote(rs.getString(9));
			emp.setHiredate(rs.getDate(10));
			emp.setIneid(rs.getString(11));
			emp.setLocked(rs.getInt(12));
			return emp ;
		}
		return null;
	}

	@Override
	public List<Emp> findAll() throws SQLException {
		String sql = "SELECT eid,lid,did,ename,salary,phone,password,photo,note,hiredate,ineid,locked "
				+ " FROM emp WHERE locked=0 " ;
		super.pstmt = super.conn.prepareStatement(sql) ;
		ResultSet rs = super.pstmt.executeQuery() ;
		List<Emp> list=new ArrayList<Emp>();
		if (rs.next()) {
			Emp emp = new Emp() ;
			emp.setEid(rs.getString(1));
			emp.setLid(rs.getLong(2));
			emp.setDid(rs.getLong(3));
			emp.setEname(rs.getString(4));
			emp.setSalary(rs.getDouble(5));
			emp.setPhone(rs.getString(6));
			emp.setPassword(rs.getString(7));
			emp.setPhoto(rs.getString(8));
			emp.setNote(rs.getString(9));
			emp.setHiredate(rs.getDate(10));
			emp.setIneid(rs.getString(11));
			emp.setLocked(rs.getInt(12));
			list.add(emp);
		}
		return list;
	}

	@Override
	public List<Emp> findAll(Long currentPage, Integer lineSize) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Emp> findSplit(String column, String keyWord, Long currentPage, Integer lineSize) throws Exception {
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
