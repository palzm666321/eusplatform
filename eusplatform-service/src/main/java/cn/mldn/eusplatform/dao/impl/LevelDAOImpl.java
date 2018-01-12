package cn.mldn.eusplatform.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import cn.mldn.eusplatform.dao.ILevelDAO;
import cn.mldn.eusplatform.vo.Dept;
import cn.mldn.util.dao.abs.AbstractDAO;

public class LevelDAOImpl extends AbstractDAO implements ILevelDAO {

	@Override
	public Long getLid(Double num) throws SQLException {
		String sql="select lid from level where num between losal and hisal";
		super.pstmt=super.conn.prepareStatement(sql);
		super.pstmt.setDouble(1, num);
		ResultSet rs=super.pstmt.executeQuery();
		if(rs.next()) {
			return rs.getLong(1);
		}
		return 0L;
	}
	
	@Override
	public boolean doCreate(Dept vo) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doEdit(Dept vo) throws SQLException {
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
	public Dept findById(Long id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Dept> findAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
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
