package cn.mldn.eusplatform.service.back;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import cn.mldn.eusplatform.vo.Emp;
import cn.mldn.eusplatform.vo.Level;

public interface IEmpServiceBack {
	
	/**
	 * 根据部门表中的编号查找所对应的雇员信息
	 * @param did 部门编号
	 * @return List<Emp> 雇员集合
	 * @throws SQLException SQL
	 */
	public List<Emp> findByDid(Long did)throws Exception;
	
	/**
	 * 根据所选列查询关键字返回数据量，如果没有，则返回所有数据量
	 * @param column 要查询的列
	 * @param keyWord 要查询的关键字
	 * @return 数据量
	 * @throws Exception
	 */
	public Long getCount(String column,String keyWord)throws Exception ;
	
	/**
	 * 要修改的雇员信息
	 * @param vo 雇员信息
	 * @return 修改成功返回true，否则返回false
	 * @throws Exception
	 */
	public boolean edit(Emp vo)throws Exception;
	
	/**
	 * 根据指定的雇员编号查询雇员信息
	 * @param eid 雇员编号
	 * @return Map集合，包括如下
	 * key=emp，value=根据eid查询当前雇员信息，empDAO.findById(eid)
	 * key=levelList，value=返回所有工资等级信息，levelDAO.findAll()
	 * key=deptList，value=返回所有部门信息，deptDAO.findAll()
	 * @throws Exception
	 */
	public Map<String,Object> listByEmp(String eid)throws Exception;
	
	/**
	 * 查询所有雇员信息
	 * @param column 要查询关键字的列
	 * @param keyWord 关键字
	 * @param currentPage 行
	 * @param lineSize 列
	 * @return 查询后的所有雇员信息
	 * @throws Exception 
	 */
	public Map<String,Object> list(String column, String keyWord, Long currentPage, Integer lineSize)throws Exception;
	
	/**
	 * 根据当前工资查询工资等级信息
	 * @param num 当前工资
	 * @return 工资等级信息
	 * @throws Exception
	 */
	public Level findByLevel(Double num)throws Exception;
	
	
	/**
	 * 返回下拉框的Dept部门信息和Level工资等级信息
	 * @return Map集合，包括如下
	 * key=deptList，value=部门信息集合
	 * key=levelList，value=员工工资等级信息集合
	 * @throws Exception
	 */
	public Map<String,Object> listLevelAndDept() throws Exception;
	
	/**
	 * 添加当前雇员信息，有如下限制
	 * · 员工登录ID不允许重复；
	 * · 验证员工的工资范围是否在指定的等级范围之内；
	 * · 雇员入职的时候需要在emp.ineid字段上保存有入职办理的员工编号，如果现在有其它的人事部员工修改了该员工信息的时候则emp.ineid字段要换上当前更新的雇员编号
	 * @param emp 雇员信息
	 * @return 添加成功返回true，否则返回false
	 * @throws Exception
	 */
	public boolean add(Emp emp)throws Exception;
	
	/**
	 * 实现用户的登录处理操作，该操作要执行如下的几步：
	 * 1、调用IMemberDAO.findById()方法根据用户名查找用户的信息，随后进行密码比对，如果密码正确则表示登录成功；
	 * 2、当登录成功之后应该根据用户编号获得用户对应的角色与权限数据信息；
	 * @param emp 包含有用户登录名（mid）与密码（password）两个重要的信息
	 * @return 返回的内容包含有如下数据：<br>
	 * 1、key = emp、value = 登录成功后的用户信息，如果没有返回雇员对象则表示登录失败；
	 * 2、key = allRoles、value = 用户对应的所有角色，Set集合；
	 * 3、key = allActions、value = 用户对应的所有权限，Set集合；
	 * @throws Exception 抛出状态的处理异常
	 */
	public Map<String, Object> login(Emp emp) throws Exception;
}
