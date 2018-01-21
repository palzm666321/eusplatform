package cn.mldn.eusplatform.action.front;

import cn.mldn.eusplatform.service.back.IEmpServiceBack;
import cn.mldn.eusplatform.vo.Emp;
import cn.mldn.util.action.ActionResourceUtil;
import cn.mldn.util.action.abs.AbstractAction;
import cn.mldn.util.factory.Factory;
import cn.mldn.util.web.ModelAndView;
import cn.mldn.util.web.ServletObjectUtil;
import cn.mldn.util.web.SplitPageUtil;

public class EmpActionFront extends AbstractAction{
	
	public ModelAndView preEdit(String eid) {
		ModelAndView mav=new ModelAndView(ActionResourceUtil.getPage("front.emp.edit.page"));
		IEmpServiceBack empService=Factory.getServiceInstance("emp.service.back");
		try {
			mav.addObjectMap(empService.listByEmp(eid));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
	
	public ModelAndView edit(Emp vo) {
		ModelAndView mav=new ModelAndView(ActionResourceUtil.getPage("front.emp.list.action"));
		IEmpServiceBack empService=Factory.getServiceInstance("emp.service.back");
		vo.setIneid(super.getEid());
		try {
			empService.edit(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
	
	public ModelAndView list() {
		ModelAndView mav=new ModelAndView(ActionResourceUtil.getPage("front.emp.list.page"));
		IEmpServiceBack empService=Factory.getServiceInstance("emp.service.back");
		SplitPageUtil spu=new SplitPageUtil("雇员编号:eid|雇员姓名:ename","front.emp.list.action");
		try {
			ServletObjectUtil.getRequest().setAttribute("allRecorders", empService.getCount(spu.getColumn(), spu.getKeyWord()));
			mav.addObjectMap(empService.list(spu.getColumn(), spu.getKeyWord(), spu.getCurrentPage(), spu.getLineSize()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
	
	public ModelAndView preAdd() {
		ModelAndView mav=new ModelAndView(ActionResourceUtil.getPage("front.emp.add.page"));
		IEmpServiceBack empService=Factory.getServiceInstance("emp.service.back");
		try {
			mav.addObjectMap(empService.listLevelAndDept());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
	
	public ModelAndView add(Emp vo) {
		ModelAndView mav=new ModelAndView(ActionResourceUtil.getPage("front.emp.list.action"));
		IEmpServiceBack empService=Factory.getServiceInstance("emp.service.back");
		vo.setIneid(super.getEid());
		try {
			empService.add(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}

}
