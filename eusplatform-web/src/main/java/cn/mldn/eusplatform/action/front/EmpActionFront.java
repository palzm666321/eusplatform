package cn.mldn.eusplatform.action.front;

import cn.mldn.eusplatform.service.back.IDeptServiceBack;
import cn.mldn.eusplatform.service.back.IEmpServiceBack;
import cn.mldn.eusplatform.vo.Emp;
import cn.mldn.util.action.ActionResourceUtil;
import cn.mldn.util.action.abs.AbstractAction;
import cn.mldn.util.factory.Factory;
import cn.mldn.util.web.ModelAndView;

public class EmpActionFront extends AbstractAction{
	
	public ModelAndView list() {
		ModelAndView mav=new ModelAndView(ActionResourceUtil.getPage("front.emp.list.page"));
		IEmpServiceBack empService=Factory.getServiceInstance("emp.service.back");
		IDeptServiceBack deptService=Factory.getServiceInstance("dept.service.back");
		try {
			mav.addObject("deptList", deptService.list());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
	
	public ModelAndView add(Emp vo) {
		ModelAndView mav=new ModelAndView(ActionResourceUtil.getPage("front.emp.list.page"));
		IEmpServiceBack empService=Factory.getServiceInstance("emp.service.back");
		vo.setEid(super.getEid());
		try {
			super.print(empService.add(vo));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}

}
