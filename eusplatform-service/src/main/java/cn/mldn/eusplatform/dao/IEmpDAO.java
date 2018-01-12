package cn.mldn.eusplatform.dao;

import java.sql.SQLException;
import java.util.Map;

import cn.mldn.eusplatform.vo.Emp;
import cn.mldn.util.dao.IBaseDAO;

public interface IEmpDAO extends IBaseDAO<String, Emp> {
	
	public Map<String,Long> findByEidAndDid(String eid)throws SQLException;
	
}
