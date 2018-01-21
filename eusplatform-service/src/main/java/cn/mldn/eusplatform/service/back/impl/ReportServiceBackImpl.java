package cn.mldn.eusplatform.service.back.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.mldn.eusplatform.dao.IReportDAO;
import cn.mldn.eusplatform.service.back.IReportServiceBack;
import cn.mldn.eusplatform.vo.Report;
import cn.mldn.util.factory.Factory;
import cn.mldn.util.service.abs.AbstractService;

public class ReportServiceBackImpl extends AbstractService implements IReportServiceBack {

	@Override
	public List<Report> reportList(String column, String keyWord, Long currentPage, Integer lineSize) throws Exception {
		IReportDAO reportDAO=Factory.getDAOInstance("report.dao");
		if(column==null) {
			reportDAO.findAll(currentPage, lineSize);
		}
		return reportDAO.findSplit(column, keyWord, currentPage, lineSize);
	}
	
	@Override
	public Long getCount(String column, String keyWord) throws Exception {
		IReportDAO reportDAO=Factory.getDAOInstance("report.dao");
		return reportDAO.getAllCount();
	}

	@Override
	public Map<String, Object> traveler() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Long sid) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Map<String, Object> fingByReport(Long sid) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean edit(Report vo) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Map<String, Object> list(String column, String keyWord, Long currentPage, Integer lineSize)
			throws Exception {
		IReportDAO reportDAO=Factory.getDAOInstance("report.dao");
		Map<String,Object> map=new HashMap<String,Object>();
		if(column==null) {
			map.put("reportList", reportDAO.findAll(currentPage, lineSize));
		}else {
			map.put("reportList", reportDAO.findSplit(column, keyWord, currentPage, lineSize));
		}
		return map;
	}

	@Override
	public List<Report> reportList() throws Exception {
		IReportDAO reportDAO=Factory.getDAOInstance("report.dao");
		return reportDAO.findAll();
	}

	@Override
	public boolean add(Report vo, String srid) throws Exception {
		IReportDAO reportDAO=Factory.getDAOInstance("report.dao");
		
		return false;
	}

}
