package cn.mldn.eusplatform.dao;

import java.sql.SQLException;
import java.util.Map;

import cn.mldn.eusplatform.vo.Item;
import cn.mldn.util.dao.IBaseDAO;

public interface IItemDAO extends IBaseDAO<Long, Item> {
	
	/**
	 * 根据指定iid编号查询所对应的功能
	 * @param iid 功能编号
	 * @return Map集合
	 * key=iid编号，value=功能
	 * @throws SQLException SQL
 	 */
	public Map<Long,String> findByIid(Long iid)throws SQLException;
	
}
