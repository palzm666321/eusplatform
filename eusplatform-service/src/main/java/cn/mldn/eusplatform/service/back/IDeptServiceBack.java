package cn.mldn.eusplatform.service.back;

import java.util.List;

import cn.mldn.eusplatform.vo.Dept;

public interface IDeptServiceBack {
	
	/**
	 * 修改部门名称和最大上限人数，最大上限人数不能低于当前人员并且当前用户必须为人事部用户（mldn-human）
	 * @param vo 要修改的部门信息
	 * @return 修改成功返回true，否则返回false
	 * @throws Exception 
	 */
	public boolean edit(Dept vo)throws Exception;
	
	/**
	 * 添加部门，新添加的部门名称不能与已有的部门名称相同
	 * @param vo 要添加的部门信息
	 * @return 添加成功返回true，否则返回false
	 * @throws Exception 
	 */
	public boolean add(Dept vo)throws Exception;
	
	/**
	 * 输出所有部门信息
	 * @return List集合，包括了所有部门
	 * @throws Exception
	 */
	public List<Dept> list()throws Exception;
	
}
