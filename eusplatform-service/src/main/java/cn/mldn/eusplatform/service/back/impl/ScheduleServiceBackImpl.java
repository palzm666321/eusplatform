package cn.mldn.eusplatform.service.back.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import cn.mldn.eusplatform.dao.IDeptDAO;
import cn.mldn.eusplatform.dao.IEmpDAO;
import cn.mldn.eusplatform.dao.IItemDAO;
import cn.mldn.eusplatform.dao.ILevelDAO;
import cn.mldn.eusplatform.dao.IScheduleDAO;
import cn.mldn.eusplatform.service.back.IScheduleServiceBack;
import cn.mldn.eusplatform.vo.Item;
import cn.mldn.eusplatform.vo.Schedule;
import cn.mldn.util.factory.Factory;
import cn.mldn.util.service.abs.AbstractService;

public class ScheduleServiceBackImpl extends AbstractService implements IScheduleServiceBack {

	@Override
	public boolean editByAnote(Schedule vo) throws Exception {
		IScheduleDAO scheduleDAO=Factory.getDAOInstance("schedule.dao");
		return scheduleDAO.editByAnote(vo);
	}
	
	@Override
	public Long getCount(String column, String keyWord) throws Exception {
		IScheduleDAO scheduleDAO=Factory.getDAOInstance("schedule.dao");
		if(column=="") {
			return scheduleDAO.getAllCount();
		}else {
			return scheduleDAO.getSplitCount(column, keyWord);
		}
	}
	
	@Override
	public Map<String, Object> traveler() throws Exception {
		//IScheduleDAO scheduleDAO=Factory.getDAOInstance("schedule.dao");
		IEmpDAO empDAO=Factory.getDAOInstance("emp.dao");
		ILevelDAO levelDAO=Factory.getDAOInstance("level.dao");
		IDeptDAO deptDAO=Factory.getDAOInstance("dept.dao");
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("empList", empDAO.findAll());
	//	map.put("empByDid", empDAO.findByDid(did));
		map.put("levelMap", levelDAO.findByLid());
		map.put("deptList", deptDAO.findAll());
		map.put("deptMap", deptDAO.findByDid());
		return map;
	}
	
	@Override
	public boolean remove(Long sid) throws Exception {
		IScheduleDAO scheduleDAO=Factory.getDAOInstance("schedule.dao");
		return scheduleDAO.doRemove(sid);
	}
	
	@Override
	public Map<String,Object> fingBySchedule(Long sid) throws Exception {
		IScheduleDAO scheduleDAO=Factory.getDAOInstance("schedule.dao");
		ILevelDAO levelDAO=Factory.getDAOInstance("level.dao");
		IDeptDAO deptDAO=Factory.getDAOInstance("dept.dao");
		IItemDAO itemDAO=Factory.getDAOInstance("item.dao");
		IEmpDAO empDAO=Factory.getDAOInstance("emp.dao");
		Map<String,Object> map=new HashMap<String,Object>();
		Schedule vo=scheduleDAO.findById(sid);
		map.put("itemMap", itemDAO.findByIid(vo.getIid()));
		map.put("empList", empDAO.findAll());
		map.put("levelMap", levelDAO.findByLid());
		map.put("deptMap", deptDAO.findByDid());
		map.put("schedule", vo);
		return map;
	}
	
	@Override
	public boolean edit(Schedule vo) throws Exception {
		IScheduleDAO scheduleDAO=Factory.getDAOInstance("schedule.dao");
		return scheduleDAO.doEdit(vo);
	}
	
	@Override
	public Map<String, Object> list(String column, String keyWord, Long currentPage, Integer lineSize) throws Exception {
		IScheduleDAO scheduleDAO=Factory.getDAOInstance("schedule.dao");
		IItemDAO itemDAO=Factory.getDAOInstance("item.dao");
		Map<String,Object> map=new HashMap<String,Object>();
		List<Schedule> list=scheduleDAO.findAll(currentPage,lineSize);
//		if(column!=null) {
//			list=scheduleDAO.findSplit(column,keyWord,currentPage,lineSize);
//		}else {
//			list=scheduleDAO.findAll(currentPage,lineSize);
//		}
		
		Iterator<Schedule> it=list.iterator();
		while(it.hasNext()) {
			Schedule vo=it.next();
			map.put("itemMap",itemDAO.findByIid(vo.getIid()));
		}
		map.put("scheduleList", list);
		return map;
	}
	
	@Override
	public List<Item> ItemList() throws Exception {
		IItemDAO itemDAO=Factory.getDAOInstance("item.dao");
		return itemDAO.findAll();
	}

	@Override
	public boolean add(Schedule vo,String eid) throws Exception {
		IScheduleDAO scheduleDAO=Factory.getDAOInstance("schedule.dao");
		vo.setAudit(-1);
		vo.setSubdate(new Date());
		vo.setEcount(0);
		vo.setAuddate(new Date());
		
		
//			ISchedule_empDAO schedule_empDAO=Factory.getDAOInstance("schedule_emp.dao");
//			Schedule_emp schemp=new Schedule_emp(); 
//			schemp.setEid(eid);
//			schemp.setSid(vo.getSid());
//			schedule_empDAO.doCreate(schemp);
		
		
		return scheduleDAO.doCreate(vo);
	}

	

}
