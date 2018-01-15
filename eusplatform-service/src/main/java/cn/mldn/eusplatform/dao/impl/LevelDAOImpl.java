package cn.mldn.eusplatform.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import cn.mldn.eusplatform.dao.ILevelDAO;
import cn.mldn.eusplatform.vo.Level;
import cn.mldn.util.dao.abs.AbstractDAO;

public class LevelDAOImpl extends AbstractDAO implements ILevelDAO {

	@Override
	public Map<Long, String> findByLid() throws SQLException {
		String sql="select lid,title from level";
		super.pstmt=super.conn.prepareStatement(sql);
		Map<Long,String> map=new HashMap<Long,String>();
		ResultSet rs=super.pstmt.executeQuery();
		while(rs.next()) {
			map.put(rs.getLong(1), rs.getString(2));
		}
		return map;
	}
	
	@Override
	public Level getLevel(Double num) throws SQLException {
		String sql="select lid,title,losal,hisal from level where ? between losal and hisal";
		super.pstmt=super.conn.prepareStatement(sql);
		super.pstmt.setDouble(1, num);
		ResultSet rs=super.pstmt.executeQuery();
		if(rs.next()) {
			Level vo=new Level();
			vo.setLid(rs.getLong(1));
			vo.setTitle(rs.getString(2));
			vo.setLosal(rs.getDouble(3));
			vo.setHisal(rs.getDouble(4));
			return vo;
		}
		return null;
	}

	@Override
	public boolean doCreate(Level vo) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doEdit(Level vo) throws SQLException {
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
	public Level findById(Long lid) throws SQLException {
		String sql="select lid,title,losal,hisal from level where lid=?";
		super.pstmt=super.conn.prepareStatement(sql);
		super.pstmt.setLong(1, lid);
		ResultSet rs=super.pstmt.executeQuery();
		if(rs.next()) {
			Level vo=new Level();
			vo.setLid(rs.getLong(1));
			vo.setTitle(rs.getString(2));
			vo.setLosal(rs.getDouble(3));
			vo.setHisal(rs.getDouble(4));
			return vo;
		}
		return null;
	}

	@Override
	public List<Level> findAll() throws SQLException {
		String sql="select lid,title,losal,hisal from level";
		super.pstmt=super.conn.prepareStatement(sql);
		ResultSet rs=super.pstmt.executeQuery();
		List<Level> list=new ArrayList<Level>();
		while(rs.next()) {
			Level vo=new Level();
			vo.setLid(rs.getLong(1));
			vo.setTitle(rs.getString(2));
			vo.setLosal(rs.getDouble(3));
			vo.setHisal(rs.getDouble(4));
			list.add(vo);
		}
		return list;
	}

	@Override
	public List<Level> findAll(Long currentPage, Integer lineSize) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Level> findSplit(String column, String keyWord, Long currentPage, Integer lineSize) throws Exception {
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
