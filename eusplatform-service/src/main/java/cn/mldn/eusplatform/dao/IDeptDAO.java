package cn.mldn.eusplatform.dao;

import java.sql.SQLException;
import java.util.List;

import cn.mldn.eusplatform.vo.Dept;
import cn.mldn.util.dao.IBaseDAO;

public interface IDeptDAO extends IBaseDAO<Long,Dept> {
	
	/**
	 * 根据指定的部门编号和当前用户修改部门名称和名额上限，名额上限不能低于当前员工数
	 * @param eid 当前用户名称
	 * @param did 当前部门名称
	 * @return 修改成功返回true，否则返回false
	 * @throws SQLException SQL
	 */
	public boolean doEdit(String eid,Long did)throws SQLException;
	
	/**
	 * 根据指定用户查询所有部门信息
	 * @param eid 指定用户
	 * @return 该部门的所有角色数据
	 * @throws SQLException JDBC
	 */
	public List<Dept> findAllByDept(String eid) throws SQLException ;
}
