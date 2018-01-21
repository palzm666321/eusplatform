package cn.mldn.eusplatform.action.front;

import cn.mldn.eusplatform.service.back.IEmpServiceBack;
import cn.mldn.eusplatform.service.back.IReportServiceBack;
import cn.mldn.eusplatform.service.back.IScheduleServiceBack;
import cn.mldn.eusplatform.vo.Dept;
import cn.mldn.util.action.ActionResourceUtil;
import cn.mldn.util.action.abs.AbstractAction;
import cn.mldn.util.factory.Factory;
import cn.mldn.util.web.ModelAndView;
import cn.mldn.util.web.ServletObjectUtil;
import cn.mldn.util.web.SplitPageUtil;

public class ReportActionFront extends AbstractAction{
	
	
	public ModelAndView findByMap(Long sid) {
		ModelAndView mav=new ModelAndView(ActionResourceUtil.getPage("front.report.schedule.list.page"));
		IScheduleServiceBack scheduleService=Factory.getServiceInstance("schedule.service.back");
		try {
			mav.addObjectMap(scheduleService.fingBySchedule(sid));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
	
	public ModelAndView list() {
		ModelAndView mav=new ModelAndView(ActionResourceUtil.getPage("front.report.schedule.list.page"));
	//	IReportServiceBack reportService=Factory.getServiceInstance("report.service.back");
		IScheduleServiceBack scheduleService=Factory.getServiceInstance("schedule.service.back");
		SplitPageUtil spu=new SplitPageUtil(null,"front.report.schedule.list.page");
		try {
			ServletObjectUtil.getRequest().setAttribute("allRecorders", scheduleService.getCount(spu.getColumn(), spu.getKeyWord()));
			mav.addObjectMap(scheduleService.list(spu.getColumn(), spu.getKeyWord(), spu.getCurrentPage(), spu.getLineSize()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
	
	public ModelAndView preAdd() {
		return null;
	}
	
	
	public ModelAndView add(Dept vo) {
		return null;
	}

}
