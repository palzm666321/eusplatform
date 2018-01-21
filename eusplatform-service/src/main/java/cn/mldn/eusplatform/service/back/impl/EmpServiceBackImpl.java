package cn.mldn.eusplatform.service.back.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.mldn.eusplatform.dao.IActionDAO;
import cn.mldn.eusplatform.dao.IDeptDAO;
import cn.mldn.eusplatform.dao.IEmpDAO;
import cn.mldn.eusplatform.dao.ILevelDAO;
import cn.mldn.eusplatform.dao.IRoleDAO;
import cn.mldn.eusplatform.service.back.IEmpServiceBack;
import cn.mldn.eusplatform.vo.Emp;
import cn.mldn.eusplatform.vo.Level;
import cn.mldn.util.factory.Factory;
import cn.mldn.util.service.abs.AbstractService;

public class EmpServiceBackImpl extends AbstractService implements IEmpServiceBack {

	@Override
	public List<Emp> findByDid(Long did) throws Exception {
		IEmpDAO empDAO=Factory.getDAOInstance("emp.dao");
		return empDAO.findByDid(did);
	}
	
	public Long getCount(String column,String keyWord)throws Exception{
		IEmpDAO empDAO=Factory.getDAOInstance("emp.dao");
		if(column=="") {
			return empDAO.getAllCount();
		}else {
			return empDAO.getSplitCount(column, keyWord);
		}
	}
	
	@Override
	public boolean edit(Emp vo) throws Exception {
		IEmpDAO empDAO=Factory.getDAOInstance("emp.dao");
		vo.setHiredate(new Date());
		vo.setLocked(0);
		return empDAO.doEdit(vo);
	}
	
	@Override
	public Map<String,Object> listByEmp(String eid) throws Exception {
		IEmpDAO empDAO=Factory.getDAOInstance("emp.dao");
		ILevelDAO levelDAO=Factory.getDAOInstance("level.dao");
		IDeptDAO deptDAO=Factory.getDAOInstance("dept.dao");
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("emp", empDAO.findById(eid));
		map.put("levelList", levelDAO.findAll());
		map.put("deptList", deptDAO.findAll());
		return map;
	}
	
	@Override
	public Map<String,Object> list(String column, String keyWord, Long currentPage, Integer lineSize) throws Exception {
		IEmpDAO empDAO=Factory.getDAOInstance("emp.dao");
		ILevelDAO levelDAO=Factory.getDAOInstance("level.dao");
		IDeptDAO deptDAO=Factory.getDAOInstance("dept.dao");
		Map<String,Object> map=new HashMap<String,Object>();
		if(column=="") {
			map.put("allEmps",empDAO.findAll(currentPage, lineSize));
		}else {
			map.put("allEmps",empDAO.findSplit(column, keyWord,currentPage, lineSize));
		}
		map.put("title", levelDAO.findByLid());
		map.put("dname", deptDAO.findByDid());
		return map;
	}
	
	public Level findByLevel(Double num)throws Exception{
		ILevelDAO levelDAO=Factory.getDAOInstance("level.dao");
		return levelDAO.getLevel(num);
	}
	
	@Override
	public Map<String,Object> listLevelAndDept() throws Exception {
		IDeptDAO deptDAO=Factory.getDAOInstance("dept.dao");
		ILevelDAO levelDAO=Factory.getDAOInstance("level.dao");
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("deptList", deptDAO.findAll());
		map.put("levelList",levelDAO.findAll());
		return map;
	}
	
	@Override
	public boolean add(Emp emp) throws Exception {
		IEmpDAO empDAO=Factory.getDAOInstance("emp.dao");
		ILevelDAO levelDAO=Factory.getDAOInstance("level.dao");
		emp.setHiredate(new Date());
		emp.setLid(levelDAO.getLevel(emp.getSalary()).getLid());
		emp.setLocked(0);
		return empDAO.doCreate(emp);
	}
	
	@Override
	public Map<String, Object> login(Emp emp) throws Exception {
		Map<String, Object> result = new HashMap<String, Object>() ;
		IEmpDAO empDAO = Factory.getDAOInstance("emp.dao") ;
		Emp selectEmp = empDAO.findById(emp.getEid()) ;	// 根据雇员编号查询雇员信息
		result.put("emp", selectEmp) ;	// 设置查询出来的雇员信息
		if (selectEmp != null) {	// 雇员登录成功
			IRoleDAO roleDAO = Factory.getDAOInstance("role.dao") ;	// 获取角色信息
			IActionDAO actionDAO = Factory.getDAOInstance("action.dao") ;	// 获取权限信息
			result.put("allRoles", roleDAO.findAllByDept(selectEmp.getDid())) ;	// 根据部门编号查询角色信息
			result.put("allActions", actionDAO.findAllByDept(selectEmp.getDid())) ;
		}
		return result ;
	}

}
