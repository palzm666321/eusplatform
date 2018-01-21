package cn.mldn.eusplatform.action.front;

import cn.mldn.eusplatform.service.back.IScheduleServiceBack;
import cn.mldn.eusplatform.vo.Schedule;
import cn.mldn.util.action.ActionResourceUtil;
import cn.mldn.util.action.abs.AbstractAction;
import cn.mldn.util.factory.Factory;
import cn.mldn.util.web.ModelAndView;
import cn.mldn.util.web.ServletObjectUtil;
import cn.mldn.util.web.SplitPageUtil;

public class ScheduleActionFront extends AbstractAction{

	public ModelAndView report(Long sid) {
		ModelAndView mav=new ModelAndView(ActionResourceUtil.getPage("front.schedule.report.page"));
		IScheduleServiceBack scheduleService=Factory.getServiceInstance("schedule.service.back");
		try {
			mav.addObjectMap(scheduleService.fingBySchedule(sid));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
	
	public ModelAndView show(Long sid) {
		ModelAndView mav=new ModelAndView(ActionResourceUtil.getPage("front.schedule.show.page"));
		IScheduleServiceBack scheduleService=Factory.getServiceInstance("schedule.service.back");
		try {
			mav.addObjectMap(scheduleService.fingBySchedule(sid));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
	
	
	public ModelAndView editByAnote(Schedule vo) {
		ModelAndView mav=new ModelAndView(ActionResourceUtil.getPage("front.schedule.auditList.action"));
		IScheduleServiceBack scheduleService=Factory.getServiceInstance("schedule.service.back");
		try {
			scheduleService.editByAnote(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
	
	public ModelAndView listByEid(Long sid) {
		ModelAndView mav=new ModelAndView(ActionResourceUtil.getPage("front.schedule.apple.page"));
		IScheduleServiceBack scheduleService=Factory.getServiceInstance("schedule.service.back");
		try {
			mav.addObjectMap(scheduleService.fingBySchedule(sid));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
	
	public ModelAndView traveler() {
		ModelAndView mav=new ModelAndView(ActionResourceUtil.getPage("front.schedule.traveler.page"));
		IScheduleServiceBack scheduleService=Factory.getServiceInstance("schedule.service.back");
		try {
			mav.addObjectMap(scheduleService.traveler());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
	
	public ModelAndView remove(Long sid) {
		ModelAndView mav=new ModelAndView(ActionResourceUtil.getPage("front.schedule.list.action"));
		IScheduleServiceBack scheduleService=Factory.getServiceInstance("schedule.service.back");
		try {
			scheduleService.remove(sid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
	
	public ModelAndView preEdit(Long sid) {
		ModelAndView mav=new ModelAndView(ActionResourceUtil.getPage("front.schedule.edit.page"));
		IScheduleServiceBack scheduleService=Factory.getServiceInstance("schedule.service.back");
		try {
			mav.addObjectMap(scheduleService.fingBySchedule(sid));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	} 
	
	public ModelAndView edit(Schedule vo) {
		ModelAndView mav=new ModelAndView(ActionResourceUtil.getPage("front.schedule.list.action"));
		IScheduleServiceBack scheduleService=Factory.getServiceInstance("schedule.service.back");
		try {
			scheduleService.edit(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
	
	
	
	public ModelAndView scheduleList() {
		ModelAndView mav=new ModelAndView(ActionResourceUtil.getPage("front.schedule.scheduleList.page"));
		IScheduleServiceBack scheduleService=Factory.getServiceInstance("schedule.service.back");
		SplitPageUtil spu=new SplitPageUtil(null, "front.schedule.list.page");
		try {
			ServletObjectUtil.getRequest().setAttribute("allRecorders", scheduleService.getCount(spu.getColumn(), spu.getKeyWord()));
			mav.addObjectMap(scheduleService.list(spu.getColumn(),spu.getKeyWord(),spu.getCurrentPage(),spu.getLineSize()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
	
	public ModelAndView auditList() {
		ModelAndView mav=new ModelAndView(ActionResourceUtil.getPage("front.schedule.auditList.page"));
		IScheduleServiceBack scheduleService=Factory.getServiceInstance("schedule.service.back");
		SplitPageUtil spu=new SplitPageUtil(null, "front.schedule.list.page");
		try {
			ServletObjectUtil.getRequest().setAttribute("allRecorders", scheduleService.getCount(spu.getColumn(), spu.getKeyWord()));
			mav.addObjectMap(scheduleService.list(spu.getColumn(),spu.getKeyWord(),spu.getCurrentPage(),spu.getLineSize()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
	
	public ModelAndView list() {
		ModelAndView mav=new ModelAndView(ActionResourceUtil.getPage("front.schedule.list.page"));
		IScheduleServiceBack scheduleService=Factory.getServiceInstance("schedule.service.back");
		SplitPageUtil spu=new SplitPageUtil(null, "front.schedule.list.page");
		try {
			ServletObjectUtil.getRequest().setAttribute("allRecorders", scheduleService.getCount(spu.getColumn(), spu.getKeyWord()));
			mav.addObjectMap(scheduleService.list(spu.getColumn(),spu.getKeyWord(),spu.getCurrentPage(),spu.getLineSize()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
	
	public ModelAndView preAdd() {
		ModelAndView mav=new ModelAndView(ActionResourceUtil.getPage("front.schedule.add.page"));
		IScheduleServiceBack scheduleService=Factory.getServiceInstance("schedule.service.back");
		try {
			mav.addObject("itemList", scheduleService.ItemList());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
	
	
	public ModelAndView add(Schedule vo) {
		ModelAndView mav=new ModelAndView(ActionResourceUtil.getPage("front.schedule.list.action"));
		IScheduleServiceBack scheduleService=Factory.getServiceInstance("schedule.service.back");
		try {
			scheduleService.add(vo,super.getEid());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}

}
