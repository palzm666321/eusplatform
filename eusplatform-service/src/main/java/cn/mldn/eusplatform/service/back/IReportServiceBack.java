package cn.mldn.eusplatform.service.back;

import java.util.List;
import java.util.Map;

import cn.mldn.eusplatform.vo.Item;
import cn.mldn.eusplatform.vo.Report;
import cn.mldn.eusplatform.vo.Schedule;

public interface IReportServiceBack {
	
	/**
	 * 根据所选列查询关键字返回数据量，如果没有，则返回所有数据量
	 * @param column 要查询的列
	 * @param keyWord 要查询的关键字
	 * @return 数据量
	 * @throws Exception
	 */
	public Long getCount(String column,String keyWord)throws Exception ;
	
	/**
	 * 返回所有未出差的雇员信息
	 * @return Map集合，包括如下
	 * key= ，value=
	 * @throws Exception
	 */
	public Map<String,Object> traveler()throws Exception; 
	
	/**
	 * 根据指定编号删除数据
	 * @param sid 调度编号
	 * @return 成功返回true，否则返回false
	 * @throws Exception
	 */
	public boolean remove(Long sid) throws Exception;
	
	/**
	 * 根据指定编号返回调度申请表信息
	 * @return Map集合返回，包括如下
	 * key=schedule，value=调度信息，IScheduleDAO.findBySchedule方法
	 * key=itemMap，value= 根据指定iid编号查询对应功能，IItemDAO.findByIid(vo.getIid())方法
	 * @throws Exception
	 */
	public Map<String,Object> fingByReport(Long sid)throws Exception;
	
	/**
	 * 修改调度申请表信息
	 * @param vo 调度信息
	 * @return 成功返回true，否则返回false
	 * @throws Exception 
	 */
	public boolean edit(Report vo)throws Exception;
	
	/**
	 * 返回所有调度申请表信息
	 * @return Map集合返回，包括如下
	 * key=scheduleList，value=所有调度信息，IScheduleDAO.findAll方法
	 * key=itemMap，value= 根据指定iid编号查询对应功能，IItemDAO.findByIid(vo.getIid())方法
	 * @throws Exception
	 */
	public Map<String,Object> list(String column, String keyWord, Long currentPage, Integer lineSize)throws Exception;
	
	public List<Report> reportList(String column, String keyWord, Long currentPage, Integer lineSize)throws Exception;
	
	/**
	 * 返回扩展功能全部数据
	 * @return List集合
	 * @throws Exception
	 */
	public List<Report> reportList()throws Exception;
	
	/**
	 * 添加调度申请单信息，新添加的调度申请单信息名称不能与已有的调度申请单信息名称相同
	 * @param vo 要添加的部门信息
	 * @return 添加成功返回true，否则返回false
	 * @throws Exception 
	 */
	public boolean add(Report vo,String eid)throws Exception;
}
