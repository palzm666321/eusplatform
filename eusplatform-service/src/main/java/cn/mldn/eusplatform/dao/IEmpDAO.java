package cn.mldn.eusplatform.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import cn.mldn.eusplatform.vo.Emp;
import cn.mldn.util.dao.IBaseDAO;

public interface IEmpDAO extends IBaseDAO<String, Emp> {
	
	
	/**
	 * 根据部门表中的编号查找所对应的雇员信息
	 * @param did 部门编号
	 * @return List<Emp> 雇员集合
	 * @throws SQLException SQL
	 */
	public List<Emp> findByDid(Long did)throws SQLException;
	
	/**
	 * 返回当前eid和did信息
	 * @return Map集合，包括如下
	 * key=eid（当前用户），value=did（部门编号）
	 * @throws SQLException SQL
	 */
	public Map<String,Long> findByEidAndDid(String eid)throws SQLException;
	
}
