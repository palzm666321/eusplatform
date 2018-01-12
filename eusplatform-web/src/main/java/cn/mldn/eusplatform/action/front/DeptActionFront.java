package cn.mldn.eusplatform.action.front;

import cn.mldn.eusplatform.service.back.IDeptServiceBack;
import cn.mldn.eusplatform.vo.Dept;
import cn.mldn.util.action.ActionResourceUtil;
import cn.mldn.util.action.abs.AbstractAction;
import cn.mldn.util.factory.Factory;
import cn.mldn.util.web.ModelAndView;

public class DeptActionFront extends AbstractAction{
	
	public void edit(Dept vo) {
		IDeptServiceBack deptService=Factory.getServiceInstance("dept.service.back");
		vo.setEid(super.getEid());
		try {
			super.print(deptService.edit(vo));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ModelAndView list() {
		ModelAndView mav=new ModelAndView(ActionResourceUtil.getPage("front.emp.list.page"));
 		IDeptServiceBack deptService=Factory.getServiceInstance("dept.service.back");
		try {
			mav.addObject("deptList",deptService.list());
		} catch (Exception e) {  
			e.printStackTrace();
		}
		return mav;
	}
	
	public ModelAndView add(Dept vo) {
		ModelAndView mav=new ModelAndView(ActionResourceUtil.getPage("front.emp.list.page"));
		IDeptServiceBack deptService=Factory.getServiceInstance("dept.service.back");
		vo.setEid(super.getEid());
		try {
			deptService.add(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}

}
