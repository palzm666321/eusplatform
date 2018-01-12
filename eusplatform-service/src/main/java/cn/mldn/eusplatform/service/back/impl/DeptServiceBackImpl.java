package cn.mldn.eusplatform.service.back.impl;

import java.util.List;

import cn.mldn.eusplatform.dao.IDeptDAO;
import cn.mldn.eusplatform.service.back.IDeptServiceBack;
import cn.mldn.eusplatform.vo.Dept;
import cn.mldn.util.factory.Factory;
import cn.mldn.util.service.abs.AbstractService;

public class DeptServiceBackImpl extends AbstractService implements IDeptServiceBack {

	@Override
	public boolean edit(Dept vo) throws Exception {
		IDeptDAO deptDAO=Factory.getDAOInstance("dept.dao");
		if(vo.getEid().equals("mldn-human")) {
			return deptDAO.doEdit(vo);
		}
		return false;
	}

	
	@Override
	public List<Dept> list() throws Exception {
		IDeptDAO deptDAO=Factory.getDAOInstance("dept.dao");
		return deptDAO.findAll();
	}
	
	@Override
	public boolean add(Dept vo) throws Exception {
		IDeptDAO deptDAO=Factory.getDAOInstance("dept.dao");
		vo.setCurrnum(0);
		return deptDAO.doCreate(vo);
	}

	

}
