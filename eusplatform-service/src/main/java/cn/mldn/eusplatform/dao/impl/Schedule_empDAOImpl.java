package cn.mldn.eusplatform.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import cn.mldn.eusplatform.dao.ISchedule_empDAO;
import cn.mldn.eusplatform.vo.Schedule_emp;
import cn.mldn.util.dao.abs.AbstractDAO;

public class Schedule_empDAOImpl extends AbstractDAO implements ISchedule_empDAO {

	@Override
	public boolean doCreate(Schedule_emp vo) throws SQLException {
		String sql="insert into schedule_emp(sid,eid)values(?,?)";
		super.pstmt=super.conn.prepareStatement(sql);
		super.pstmt.setLong(1, vo.getSid());
		super.pstmt.setString(2, vo.getEid());
		return super.pstmt.executeUpdate()>0;
	}

	@Override
	public boolean doEdit(Schedule_emp vo) throws SQLException {
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
	public Schedule_emp findById(Long id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Schedule_emp> findAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Schedule_emp> findAll(Long currentPage, Integer lineSize) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Schedule_emp> findSplit(String column, String keyWord, Long currentPage, Integer lineSize)
			throws Exception {
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
