package cn.mldn.eusplatform.dao;

import java.sql.SQLException;

import cn.mldn.eusplatform.vo.Dept;
import cn.mldn.util.dao.IBaseDAO;

public interface ILevelDAO extends IBaseDAO<Long,Dept> {
	
	
	public Long getLid(Double num)throws SQLException;
	
}
