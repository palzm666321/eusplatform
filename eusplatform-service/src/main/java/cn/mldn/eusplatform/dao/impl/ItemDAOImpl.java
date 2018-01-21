package cn.mldn.eusplatform.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import cn.mldn.eusplatform.dao.IItemDAO;
import cn.mldn.eusplatform.vo.Item;
import cn.mldn.util.dao.abs.AbstractDAO;

public class ItemDAOImpl extends AbstractDAO implements IItemDAO {

	
	@Override
	public Map<Long, String> findByIid(Long iid) throws SQLException {
		String sql="select iid,title from item";
		super.pstmt=super.conn.prepareStatement(sql);
		ResultSet rs=super.pstmt.executeQuery();
		Map<Long,String> map=new HashMap<Long,String>();
		while(rs.next()) {
			map.put(rs.getLong(1), rs.getString(2));
		}
		return map;
	}
	
	@Override
	public boolean doCreate(Item vo) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doEdit(Item vo) throws SQLException {
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
	public Item findById(Long id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Item> findAll() throws SQLException {
		String sql = "SELECT iid,title from item";
		super.pstmt = super.conn.prepareStatement(sql) ;
		ResultSet rs = super.pstmt.executeQuery() ;
		List<Item> list=new ArrayList<Item>();
		while (rs.next()) {
			Item vo=new Item();
			vo.setIid(rs.getLong(1));
			vo.setTitle(rs.getString(2));
			list.add(vo);
		}
		return list;
	}

	@Override
	public List<Item> findAll(Long currentPage, Integer lineSize) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Item> findSplit(String column, String keyWord, Long currentPage, Integer lineSize) throws Exception {
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
