package cn.mldn.eusplatform.dao;

import java.sql.SQLException;
import java.util.Map;

import cn.mldn.eusplatform.vo.Level;
import cn.mldn.util.dao.IBaseDAO;

public interface ILevelDAO extends IBaseDAO<Long,Level> {
	
	/**
	 * 查询工资等级中的所有工资等级编号以及工资等级对应的职位
	 * @return Map集合
	 * key=工资等级编号（Long）， value=工资等级对应的职位（String）
	 * @throws SQLException SQL
	 */
	public Map<Long,String> findByLid()throws SQLException;
	/**
	 * 根据指定的工资返回工资等级信息
	 * @param num 指定工资
	 * @return 工资等级信息
	 * @throws SQLException SQL
	 */
	public Level getLevel(Double num)throws SQLException;
	
}
